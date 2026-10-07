package androidx.health.connect.client.feature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import androidx.core.content.p001pm.PackageInfoCompat;
import androidx.health.connect.client.HealthConnectFeatures;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthConnectFeaturesApkImpl.kt */
@Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m287d2 = {"Landroidx/health/connect/client/feature/HealthConnectFeaturesApkImpl;", "Landroidx/health/connect/client/HealthConnectFeatures;", "context", "Landroid/content/Context;", "providerPackageName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "getFeatureStatus", "", "feature", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HealthConnectFeaturesApkImpl implements HealthConnectFeatures {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private final Context context;
    private final String providerPackageName;

    public HealthConnectFeaturesApkImpl(Context context, String providerPackageName) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
        this.context = context;
        this.providerPackageName = providerPackageName;
    }

    @Override // androidx.health.connect.client.HealthConnectFeatures
    public int getFeatureStatus(int feature) {
        return INSTANCE.getFeatureStatus$connect_client_release(HealthConnectFeatures.INSTANCE.getFEATURE_TO_VERSION_INFO_MAP$connect_client_release(), this.context, this.providerPackageName, feature);
    }

    /* compiled from: HealthConnectFeaturesApkImpl.kt */
    @Metadata(m286d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0081\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J5\u0010\u0003\u001a\u00020\u0004*\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0004H\u0001¢\u0006\u0002\b\f¨\u0006\r"}, m287d2 = {"Landroidx/health/connect/client/feature/HealthConnectFeaturesApkImpl$Companion;", "", "()V", "getFeatureStatus", "", "", "Landroidx/health/connect/client/feature/HealthConnectVersionInfo;", "context", "Landroid/content/Context;", "providerPackageName", "", "feature", "getFeatureStatus$connect_client_release", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getFeatureStatus$connect_client_release(Map<Integer, HealthConnectVersionInfo> map, Context context, String providerPackageName, int feature) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(providerPackageName, 0);
                Intrinsics.checkNotNullExpressionValue(packageInfo, "{\n                    co…ame, 0)\n                }");
                long installedVersion = PackageInfoCompat.getLongVersionCode(packageInfo);
                HealthConnectVersionInfo healthConnectVersionInfo = map.get(Integer.valueOf(feature));
                Long minimumRequiredVersion = healthConnectVersionInfo != null ? healthConnectVersionInfo.getApkVersionCode() : null;
                if (minimumRequiredVersion != null && minimumRequiredVersion.longValue() <= installedVersion) {
                    return 2;
                }
                return 1;
            } catch (PackageManager.NameNotFoundException e) {
                throw new IllegalStateException("Provider APK not installed!".toString());
            }
        }
    }
}
