package androidx.profileinstaller;

import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.os.Build;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.Executor;

/* loaded from: classes14.dex */
public class DeviceProfileWriter {
    private final String mApkName;
    private final AssetManager mAssetManager;
    private final File mCurProfile;
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    private final Executor mExecutor;
    private DexProfileData[] mProfile;
    private final String mProfileMetaSourceLocation;
    private final String mProfileSourceLocation;
    private byte[] mTranscodedProfile;
    private boolean mDeviceSupportsAotProfile = false;
    private final byte[] mDesiredVersion = desiredVersion();

    private void result(final int code, final Object data) {
        this.mExecutor.execute(new Runnable() { // from class: androidx.profileinstaller.DeviceProfileWriter$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                DeviceProfileWriter.this.m4671lambda$result$0$androidxprofileinstallerDeviceProfileWriter(code, data);
            }
        });
    }

    /* renamed from: lambda$result$0$androidx-profileinstaller-DeviceProfileWriter, reason: not valid java name */
    /* synthetic */ void m4671lambda$result$0$androidxprofileinstallerDeviceProfileWriter(int code, Object data) {
        this.mDiagnostics.onResultReceived(code, data);
    }

    public DeviceProfileWriter(AssetManager assetManager, Executor executor, ProfileInstaller.DiagnosticsCallback diagnosticsCallback, String apkName, String profileSourceLocation, String profileMetaSourceLocation, File curProfile) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = apkName;
        this.mProfileSourceLocation = profileSourceLocation;
        this.mProfileMetaSourceLocation = profileMetaSourceLocation;
        this.mCurProfile = curProfile;
    }

    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.mCurProfile.canWrite()) {
            result(4, null);
            return false;
        }
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    public DeviceProfileWriter read() {
        AssetFileDescriptor fd;
        InputStream is;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion == null) {
            return this;
        }
        try {
            fd = this.mAssetManager.openFd(this.mProfileSourceLocation);
            try {
                is = fd.createInputStream();
                try {
                    byte[] baselineVersion = ProfileTranscoder.readHeader(is, ProfileTranscoder.MAGIC_PROF);
                    this.mProfile = ProfileTranscoder.readProfile(is, baselineVersion, this.mApkName);
                    if (is != null) {
                        is.close();
                    }
                    if (fd != null) {
                        fd.close();
                    }
                } finally {
                }
            } finally {
            }
        } catch (FileNotFoundException e) {
            this.mDiagnostics.onResultReceived(6, e);
        } catch (IOException e2) {
            this.mDiagnostics.onResultReceived(7, e2);
        } catch (IllegalStateException e3) {
            this.mDiagnostics.onResultReceived(8, e3);
        }
        DexProfileData[] profile = this.mProfile;
        if (profile != null && requiresMetadata()) {
            try {
                fd = this.mAssetManager.openFd(this.mProfileMetaSourceLocation);
                try {
                    is = fd.createInputStream();
                    try {
                        byte[] metaVersion = ProfileTranscoder.readHeader(is, ProfileTranscoder.MAGIC_PROFM);
                        this.mProfile = ProfileTranscoder.readMeta(is, metaVersion, this.mDesiredVersion, profile);
                        if (is != null) {
                            is.close();
                        }
                        if (fd != null) {
                            fd.close();
                        }
                        return this;
                    } finally {
                        if (is != null) {
                            try {
                                is.close();
                            } catch (Throwable th) {
                                th.addSuppressed(th);
                            }
                        }
                    }
                } finally {
                }
            } catch (FileNotFoundException e4) {
                this.mDiagnostics.onResultReceived(9, e4);
            } catch (IOException e5) {
                this.mDiagnostics.onResultReceived(7, e5);
            } catch (IllegalStateException e6) {
                this.mProfile = null;
                this.mDiagnostics.onResultReceived(8, e6);
            }
        }
        return this;
    }

    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream os;
        boolean success;
        DexProfileData[] profile = this.mProfile;
        byte[] desiredVersion = this.mDesiredVersion;
        if (profile == null || desiredVersion == null) {
            return this;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            os = new ByteArrayOutputStream();
            try {
                ProfileTranscoder.writeHeader(os, desiredVersion);
                success = ProfileTranscoder.transcodeAndWriteBody(os, desiredVersion, profile);
            } catch (Throwable th) {
                try {
                    os.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        } catch (IOException e) {
            this.mDiagnostics.onResultReceived(7, e);
        } catch (IllegalStateException e2) {
            this.mDiagnostics.onResultReceived(8, e2);
        }
        if (!success) {
            this.mDiagnostics.onResultReceived(5, null);
            this.mProfile = null;
            os.close();
            return this;
        }
        this.mTranscodedProfile = os.toByteArray();
        os.close();
        this.mProfile = null;
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public boolean write() {
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            try {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
                    try {
                        Encoding.writeAll(byteArrayInputStream, fileOutputStream);
                        result(1, null);
                        fileOutputStream.close();
                        byteArrayInputStream.close();
                        return true;
                    } finally {
                    }
                } catch (Throwable th) {
                    try {
                        byteArrayInputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            } finally {
                this.mTranscodedProfile = null;
                this.mProfile = null;
            }
        } catch (FileNotFoundException e) {
            result(6, e);
            return false;
        } catch (IOException e2) {
            result(7, e2);
            return false;
        }
    }

    private static byte[] desiredVersion() {
        switch (Build.VERSION.SDK_INT) {
            case 24:
            case 25:
                return ProfileVersion.V001_N;
            case 26:
                return ProfileVersion.V005_O;
            case 27:
                return ProfileVersion.V009_O_MR1;
            case 28:
            case 29:
            case 30:
                return ProfileVersion.V010_P;
            case 31:
                return ProfileVersion.V015_S;
            default:
                return null;
        }
    }

    private static boolean requiresMetadata() {
        switch (Build.VERSION.SDK_INT) {
            case 24:
            case 25:
                return true;
            case 26:
            case 27:
            case 28:
            case 29:
            case 30:
                return false;
            case 31:
                return true;
            default:
                return false;
        }
    }
}
