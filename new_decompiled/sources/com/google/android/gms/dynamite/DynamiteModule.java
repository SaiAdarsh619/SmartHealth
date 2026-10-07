package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.CrashUtils;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes14.dex */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final int REMOTE = 1;
    private static Boolean zzb;
    private static String zzc;
    private static boolean zzd;
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;
    private static int zze = -1;
    private static Boolean zzf = null;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy zza = new zzl();

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzpVar) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzpVar) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String moduleId) {
        try {
            Class<?> loadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + moduleId + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get(null), moduleId)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + moduleId + "'");
            return 0;
        } catch (ClassNotFoundException e) {
            Log.w("DynamiteModule", "Local module descriptor class for " + moduleId + " not found.");
            return 0;
        } catch (Exception e2) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e2.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String moduleId) {
        return zza(context, moduleId, false);
    }

    @ResultIgnorabilityUnspecified
    public static DynamiteModule load(Context context, VersionPolicy policy, String moduleId) throws LoadingException {
        DynamiteModule zzc2;
        Boolean bool;
        IObjectWrapper zzh2;
        zzr zzrVar;
        Boolean valueOf;
        IObjectWrapper zze2;
        Context applicationContext = context.getApplicationContext();
        zzp zzpVar = null;
        if (applicationContext == null) {
            throw new LoadingException("null application Context", zzpVar);
        }
        zzn zznVar = (zzn) zzg.get();
        zzn zznVar2 = new zzn(null);
        zzg.set(zznVar2);
        long longValue = ((Long) zzh.get()).longValue();
        try {
            zzh.set(Long.valueOf(SystemClock.elapsedRealtime()));
            VersionPolicy.SelectionResult selectModule = policy.selectModule(context, moduleId, zzi);
            Log.i("DynamiteModule", "Considering local module " + moduleId + ":" + selectModule.localVersion + " and remote module " + moduleId + ":" + selectModule.remoteVersion);
            int i = selectModule.selection;
            if (i != 0) {
                if (i == -1) {
                    if (selectModule.localVersion != 0) {
                        i = -1;
                    }
                }
                if (i != 1 || selectModule.remoteVersion != 0) {
                    if (i == -1) {
                        zzc2 = zzc(applicationContext, moduleId);
                    } else {
                        if (i != 1) {
                            throw new LoadingException("VersionPolicy returned invalid code:" + i, zzpVar);
                        }
                        try {
                            int i2 = selectModule.remoteVersion;
                            try {
                                synchronized (DynamiteModule.class) {
                                    if (!zzf(context)) {
                                        throw new LoadingException("Remote loading disabled", zzpVar);
                                    }
                                    bool = zzb;
                                }
                                if (bool == null) {
                                    throw new LoadingException("Failed to determine which loading route to use.", zzpVar);
                                }
                                if (bool.booleanValue()) {
                                    Log.i("DynamiteModule", "Selected remote version of " + moduleId + ", version >= " + i2);
                                    synchronized (DynamiteModule.class) {
                                        zzrVar = zzl;
                                    }
                                    if (zzrVar == null) {
                                        throw new LoadingException("DynamiteLoaderV2 was not cached.", zzpVar);
                                    }
                                    zzn zznVar3 = (zzn) zzg.get();
                                    if (zznVar3 == null || zznVar3.zza == null) {
                                        throw new LoadingException("No result cursor", zzpVar);
                                    }
                                    Context applicationContext2 = context.getApplicationContext();
                                    Cursor cursor = zznVar3.zza;
                                    ObjectWrapper.wrap(null);
                                    synchronized (DynamiteModule.class) {
                                        valueOf = Boolean.valueOf(zze >= 2);
                                    }
                                    if (valueOf.booleanValue()) {
                                        Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                        zze2 = zzrVar.zzf(ObjectWrapper.wrap(applicationContext2), moduleId, i2, ObjectWrapper.wrap(cursor));
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                        zze2 = zzrVar.zze(ObjectWrapper.wrap(applicationContext2), moduleId, i2, ObjectWrapper.wrap(cursor));
                                    }
                                    Context context2 = (Context) ObjectWrapper.unwrap(zze2);
                                    if (context2 == null) {
                                        throw new LoadingException("Failed to get module context", zzpVar);
                                    }
                                    zzc2 = new DynamiteModule(context2);
                                } else {
                                    Log.i("DynamiteModule", "Selected remote version of " + moduleId + ", version >= " + i2);
                                    zzq zzg2 = zzg(context);
                                    if (zzg2 == null) {
                                        throw new LoadingException("Failed to create IDynamiteLoader.", zzpVar);
                                    }
                                    int zze3 = zzg2.zze();
                                    if (zze3 >= 3) {
                                        zzn zznVar4 = (zzn) zzg.get();
                                        if (zznVar4 == null) {
                                            throw new LoadingException("No cached result cursor holder", zzpVar);
                                        }
                                        zzh2 = zzg2.zzi(ObjectWrapper.wrap(context), moduleId, i2, ObjectWrapper.wrap(zznVar4.zza));
                                    } else if (zze3 == 2) {
                                        Log.w("DynamiteModule", "IDynamite loader version = 2");
                                        zzh2 = zzg2.zzj(ObjectWrapper.wrap(context), moduleId, i2);
                                    } else {
                                        Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                        zzh2 = zzg2.zzh(ObjectWrapper.wrap(context), moduleId, i2);
                                    }
                                    Object unwrap = ObjectWrapper.unwrap(zzh2);
                                    if (unwrap == null) {
                                        throw new LoadingException("Failed to load remote module.", zzpVar);
                                    }
                                    zzc2 = new DynamiteModule((Context) unwrap);
                                }
                            } catch (RemoteException e) {
                                throw new LoadingException("Failed to load remote module.", e, zzpVar);
                            } catch (LoadingException e2) {
                                throw e2;
                            } catch (Throwable th) {
                                CrashUtils.addDynamiteErrorToDropBox(context, th);
                                throw new LoadingException("Failed to load remote module.", th, zzpVar);
                            }
                        } catch (LoadingException e3) {
                            Log.w("DynamiteModule", "Failed to load remote module: " + e3.getMessage());
                            int i3 = selectModule.localVersion;
                            if (i3 == 0 || policy.selectModule(context, moduleId, new zzo(i3, 0)).selection != -1) {
                                throw new LoadingException("Remote load failed. No local fallback found.", e3, zzpVar);
                            }
                            zzc2 = zzc(applicationContext, moduleId);
                        }
                    }
                    return zzc2;
                }
            }
            throw new LoadingException("No acceptable module " + moduleId + " found. Local version is " + selectModule.localVersion + " and remote version is " + selectModule.remoteVersion + ".", zzpVar);
        } finally {
            if (longValue == 0) {
                zzh.remove();
            } else {
                zzh.set(Long.valueOf(longValue));
            }
            Cursor cursor2 = zznVar2.zza;
            if (cursor2 != null) {
                cursor2.close();
            }
            zzg.set(zznVar);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:53:0x01c7 A[Catch: all -> 0x01ce, TryCatch #7 {all -> 0x01ce, blocks: (B:3:0x0002, B:9:0x00e0, B:67:0x00e6, B:11:0x0107, B:40:0x0160, B:29:0x016f, B:53:0x01c7, B:54:0x01ca, B:48:0x01bd, B:71:0x00ec, B:131:0x01cd, B:5:0x0003, B:74:0x0009, B:75:0x0025, B:82:0x00dd, B:87:0x0048, B:105:0x009d, B:113:0x00a0, B:125:0x00bb, B:8:0x00df, B:128:0x00c1), top: B:2:0x0002, inners: #6, #8 }] */
    /* JADX WARN: Removed duplicated region for block: B:55:? A[Catch: all -> 0x01ce, SYNTHETIC, TRY_LEAVE, TryCatch #7 {all -> 0x01ce, blocks: (B:3:0x0002, B:9:0x00e0, B:67:0x00e6, B:11:0x0107, B:40:0x0160, B:29:0x016f, B:53:0x01c7, B:54:0x01ca, B:48:0x01bd, B:71:0x00ec, B:131:0x01cd, B:5:0x0003, B:74:0x0009, B:75:0x0025, B:82:0x00dd, B:87:0x0048, B:105:0x009d, B:113:0x00a0, B:125:0x00bb, B:8:0x00df, B:128:0x00c1), top: B:2:0x0002, inners: #6, #8 }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:30:0x01c0 -> B:23:0x01c2). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int zza(Context context, String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException e;
        int zze2;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = zzb;
                int i = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e2.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                zzd(classLoader);
                            } catch (LoadingException e3) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!zzf(context)) {
                                return 0;
                            }
                            if (zzd || Boolean.TRUE.equals(null)) {
                                declaredField.set(null, ClassLoader.getSystemClassLoader());
                                bool = Boolean.FALSE;
                            } else {
                                try {
                                    int zzb2 = zzb(context, str, z, true);
                                    String str2 = zzc;
                                    if (str2 != null && !str2.isEmpty()) {
                                        ClassLoader zza2 = zzb.zza();
                                        if (zza2 == null) {
                                            if (Build.VERSION.SDK_INT >= 29) {
                                                String str3 = zzc;
                                                Preconditions.checkNotNull(str3);
                                                zza2 = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            } else {
                                                String str4 = zzc;
                                                Preconditions.checkNotNull(str4);
                                                zza2 = new zzc(str4, ClassLoader.getSystemClassLoader());
                                            }
                                        }
                                        zzd(zza2);
                                        declaredField.set(null, zza2);
                                        zzb = Boolean.TRUE;
                                        return zzb2;
                                    }
                                    return zzb2;
                                } catch (LoadingException e4) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                }
                            }
                        }
                        zzb = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return zzb(context, str, z, false);
                    } catch (LoadingException e5) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e5.getMessage());
                        return 0;
                    }
                }
                zzq zzg2 = zzg(context);
                if (zzg2 != null) {
                    try {
                        zze2 = zzg2.zze();
                    } catch (RemoteException e6) {
                        e = e6;
                    } catch (Throwable th2) {
                        th = th2;
                    }
                    if (zze2 >= 3) {
                        zzn zznVar = (zzn) zzg.get();
                        if (zznVar == null || (cursor = zznVar.zza) == null) {
                            Cursor cursor2 = (Cursor) ObjectWrapper.unwrap(zzg2.zzk(ObjectWrapper.wrap(context), str, z, ((Long) zzh.get()).longValue()));
                            if (cursor2 != null) {
                                try {
                                    if (cursor2.moveToFirst()) {
                                        int i2 = cursor2.getInt(0);
                                        r2 = (i2 <= 0 || !zze(cursor2)) ? cursor2 : null;
                                        if (r2 != null) {
                                            r2.close();
                                        }
                                        i = i2;
                                    }
                                } catch (RemoteException e7) {
                                    e = e7;
                                    r2 = cursor2;
                                    try {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e.getMessage());
                                        if (r2 != null) {
                                            r2.close();
                                        }
                                        return i;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        if (r2 != null) {
                                            throw th;
                                        }
                                        r2.close();
                                        throw th;
                                    }
                                } catch (Throwable th4) {
                                    th = th4;
                                    r2 = cursor2;
                                    if (r2 != null) {
                                    }
                                }
                            }
                            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                            if (cursor2 != null) {
                                cursor2.close();
                            }
                        } else {
                            i = cursor.getInt(0);
                        }
                    } else if (zze2 == 2) {
                        Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                        i = zzg2.zzg(ObjectWrapper.wrap(context), str, z);
                    } else {
                        Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                        i = zzg2.zzf(ObjectWrapper.wrap(context), str, z);
                    }
                }
                return i;
            }
        } catch (Throwable th5) {
            CrashUtils.addDynamiteErrorToDropBox(context, th5);
            throw th5;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static int zzb(Context context, String str, boolean z, boolean z2) throws LoadingException {
        Throwable th;
        Exception e;
        Cursor cursor;
        Cursor cursor2 = null;
        Object[] objArr = 0;
        Object[] objArr2 = 0;
        Object[] objArr3 = 0;
        try {
            boolean z3 = true;
            cursor = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) zzh.get()).longValue())).build(), null, null, null, null);
            if (cursor != null) {
                try {
                    if (cursor.moveToFirst()) {
                        boolean z4 = false;
                        int i = cursor.getInt(0);
                        if (i > 0) {
                            synchronized (DynamiteModule.class) {
                                zzc = cursor.getString(2);
                                int columnIndex = cursor.getColumnIndex("loaderVersion");
                                if (columnIndex >= 0) {
                                    zze = cursor.getInt(columnIndex);
                                }
                                int columnIndex2 = cursor.getColumnIndex("disableStandaloneDynamiteLoader2");
                                if (columnIndex2 >= 0) {
                                    if (cursor.getInt(columnIndex2) == 0) {
                                        z3 = false;
                                    }
                                    zzd = z3;
                                    z4 = z3;
                                }
                            }
                            if (zze(cursor)) {
                                cursor = null;
                            }
                        }
                        if (!z2 || !z4) {
                            if (cursor != null) {
                                cursor.close();
                            }
                            return i;
                        }
                        try {
                            throw new LoadingException("forcing fallback to container DynamiteLoader impl", objArr2 == true ? 1 : 0);
                        } catch (Exception e2) {
                            e = e2;
                            try {
                                if (e instanceof LoadingException) {
                                    throw e;
                                }
                                throw new LoadingException("V2 version check failed: " + e.getMessage(), e, objArr == true ? 1 : 0);
                            } catch (Throwable th2) {
                                th = th2;
                                cursor2 = cursor;
                                if (cursor2 != null) {
                                    cursor2.close();
                                }
                                throw th;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            cursor2 = cursor;
                            if (cursor2 != null) {
                            }
                            throw th;
                        }
                    }
                } catch (Exception e3) {
                    e = e3;
                } catch (Throwable th4) {
                    th = th4;
                    cursor2 = cursor;
                }
            }
            Log.w("DynamiteModule", "Failed to retrieve remote module version.");
            throw new LoadingException("Failed to connect to dynamite module ContentResolver.", objArr3 == true ? 1 : 0);
        } catch (Exception e4) {
            e = e4;
            cursor = null;
        } catch (Throwable th5) {
            th = th5;
        }
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzrVar;
        zzp zzpVar = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzrVar = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                zzrVar = queryLocalInterface instanceof zzr ? (zzr) queryLocalInterface : new zzr(iBinder);
            }
            zzl = zzrVar;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, zzpVar);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zznVar = (zzn) zzg.get();
        if (zznVar == null || zznVar.zza != null) {
            return false;
        }
        zznVar.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals(null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzqVar;
        synchronized (DynamiteModule.class) {
            zzq zzqVar2 = zzk;
            if (zzqVar2 != null) {
                return zzqVar2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzqVar = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzqVar = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzqVar != null) {
                    zzk = zzqVar;
                    return zzqVar;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    @ResultIgnorabilityUnspecified
    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String className) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(className).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(className)), e, null);
        }
    }
}
