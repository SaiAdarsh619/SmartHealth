package androidx.health.platform.client.impl.sdkservice;

import android.content.Context;
import android.os.Binder;
import android.os.RemoteException;
import android.util.Log;
import androidx.health.platform.client.impl.permission.foregroundstate.ForegroundStateChecker;
import androidx.health.platform.client.impl.permission.token.PermissionTokenManager;
import androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService;
import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.function.Predicate;
import java.util.stream.Stream;

/* loaded from: classes14.dex */
final class HealthDataSdkServiceStubImpl extends IHealthDataSdkService.Stub {
    static final String ALLOWED_PACKAGE_NAME = "com.google.android.apps.healthdata";
    private static final String TAG = HealthDataSdkServiceStubImpl.class.getSimpleName();
    private final Context mContext;
    private final Executor mExecutor;

    HealthDataSdkServiceStubImpl(Context context, Executor executor) {
        this.mContext = context;
        this.mExecutor = executor;
    }

    @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
    public void setPermissionToken(String healthDataPackageName, final String permissionToken, final ISetPermissionTokenCallback callback) {
        verifyPackageName(healthDataPackageName);
        this.mExecutor.execute(new Runnable() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                HealthDataSdkServiceStubImpl.this.m52x8abba3dc(permissionToken, callback);
            }
        });
    }

    /* renamed from: lambda$setPermissionToken$0$androidx-health-platform-client-impl-sdkservice-HealthDataSdkServiceStubImpl */
    /* synthetic */ void m52x8abba3dc(String permissionToken, ISetPermissionTokenCallback callback) {
        PermissionTokenManager.setCurrentToken(this.mContext, permissionToken);
        try {
            callback.onSuccess();
        } catch (RemoteException e) {
            Log.e(TAG, String.format("HealthDataSdkService#setPermissionToken failed: %s", e.getMessage()));
        }
    }

    @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
    public void getPermissionToken(String healthDataPackageName, final IGetPermissionTokenCallback callback) {
        verifyPackageName(healthDataPackageName);
        this.mExecutor.execute(new Runnable() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                HealthDataSdkServiceStubImpl.this.m51x6726856f(callback);
            }
        });
    }

    /* renamed from: lambda$getPermissionToken$1$androidx-health-platform-client-impl-sdkservice-HealthDataSdkServiceStubImpl */
    /* synthetic */ void m51x6726856f(IGetPermissionTokenCallback callback) {
        try {
            String currentToken = PermissionTokenManager.getCurrentToken(this.mContext);
            callback.onSuccess(currentToken == null ? "" : currentToken);
        } catch (RemoteException e) {
            Log.e(TAG, String.format("HealthDataSdkService#getPermissionToken failed: %s", e.getMessage()));
        }
    }

    @Override // androidx.health.platform.client.impl.sdkservice.IHealthDataSdkService
    public void getIsInForeground(String healthDataPackageName, final IGetIsInForegroundCallback callback) {
        verifyPackageName(healthDataPackageName);
        this.mExecutor.execute(new Runnable() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                HealthDataSdkServiceStubImpl.lambda$getIsInForeground$2(IGetIsInForegroundCallback.this);
            }
        });
    }

    static /* synthetic */ void lambda$getIsInForeground$2(IGetIsInForegroundCallback callback) {
        try {
            callback.onSuccess(ForegroundStateChecker.isInForeground());
        } catch (RemoteException e) {
            Log.e(TAG, String.format("HealthDataSdkService#getIsInForeground failed: %s", e.getMessage()));
        }
    }

    private void verifyPackageName(final String packageName) {
        String[] callingApp = this.mContext.getPackageManager().getPackagesForUid(Binder.getCallingUid());
        if (packageName != null && callingApp != null) {
            Stream stream = Arrays.stream(callingApp);
            Objects.requireNonNull(packageName);
            if (!stream.noneMatch(new Predicate() { // from class: androidx.health.platform.client.impl.sdkservice.HealthDataSdkServiceStubImpl$$ExternalSyntheticLambda3
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    boolean equals;
                    equals = packageName.equals((String) obj);
                    return equals;
                }
            })) {
                if (!"com.google.android.apps.healthdata".equals(packageName)) {
                    throw new SecurityException("Not allowed!");
                }
                return;
            }
        }
        throw new SecurityException("Invalid package name!");
    }
}
