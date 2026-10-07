package androidx.health.connect.client.permission;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.health.platform.client.impl.logger.Logger;
import androidx.health.platform.client.permission.Permission;
import androidx.health.platform.client.proto.PermissionProto;
import androidx.health.platform.client.service.HealthDataServiceConstants;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: HealthPermissionsRequestAppContract.kt */
@Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J,\u0010\u000b\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\f2\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J \u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007H\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m287d2 = {"Landroidx/health/connect/client/permission/HealthPermissionsRequestAppContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "providerPackageName", "(Ljava/lang/String;)V", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HealthPermissionsRequestAppContract extends ActivityResultContract<Set<? extends String>, Set<? extends String>> {
    private final String providerPackageName;

    /* JADX WARN: Multi-variable type inference failed */
    public HealthPermissionsRequestAppContract() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Intent createIntent(Context p0, Set<? extends String> set) {
        return createIntent2(p0, (Set<String>) set);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Set<? extends String>> getSynchronousResult(Context p0, Set<? extends String> set) {
        return getSynchronousResult2(p0, (Set<String>) set);
    }

    public /* synthetic */ HealthPermissionsRequestAppContract(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "com.google.android.apps.healthdata" : str);
    }

    public HealthPermissionsRequestAppContract(String providerPackageName) {
        Intrinsics.checkNotNullParameter(providerPackageName, "providerPackageName");
        this.providerPackageName = providerPackageName;
    }

    /* renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(Context context, Set<String> input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        ArrayList protoPermissionList = (ArrayList) SequencesKt.toCollection(SequencesKt.map(CollectionsKt.asSequence(input), new Function1<String, Permission>() { // from class: androidx.health.connect.client.permission.HealthPermissionsRequestAppContract$createIntent$protoPermissionList$1
            @Override // kotlin.jvm.functions.Function1
            public final Permission invoke(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                PermissionProto.Permission build = PermissionProto.Permission.newBuilder().setPermission(it).build();
                Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setPermission(it).build()");
                return new Permission(build);
            }
        }), new ArrayList());
        Logger.debug("HealthConnectClient", "Requesting " + input.size() + " permissions.");
        Intent $this$createIntent_u24lambda_u240 = new Intent(HealthDataServiceConstants.ACTION_REQUEST_PERMISSIONS);
        $this$createIntent_u24lambda_u240.putParcelableArrayListExtra(HealthDataServiceConstants.KEY_REQUESTED_PERMISSIONS_STRING, protoPermissionList);
        if (this.providerPackageName.length() > 0) {
            $this$createIntent_u24lambda_u240.setPackage(this.providerPackageName);
        }
        return $this$createIntent_u24lambda_u240;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Set<? extends String> parseResult(int resultCode, Intent intent) {
        Set grantedPermissions;
        ArrayList parcelableArrayListExtra;
        Sequence asSequence;
        Sequence map;
        if (intent == null || (parcelableArrayListExtra = intent.getParcelableArrayListExtra(HealthDataServiceConstants.KEY_GRANTED_PERMISSIONS_STRING)) == null || (asSequence = CollectionsKt.asSequence(parcelableArrayListExtra)) == null || (map = SequencesKt.map(asSequence, new Function1<Permission, String>() { // from class: androidx.health.connect.client.permission.HealthPermissionsRequestAppContract$parseResult$grantedPermissions$1
            @Override // kotlin.jvm.functions.Function1
            public final String invoke(Permission it) {
                return it.getProto().getPermission();
            }
        })) == null || (grantedPermissions = SequencesKt.toSet(map)) == null) {
            grantedPermissions = SetsKt.emptySet();
        }
        Logger.debug("HealthConnectClient", "Granted " + grantedPermissions.size() + " permissions.");
        return grantedPermissions;
    }

    /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public ActivityResultContract.SynchronousResult<Set<String>> getSynchronousResult2(Context context, Set<String> input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        return null;
    }
}
