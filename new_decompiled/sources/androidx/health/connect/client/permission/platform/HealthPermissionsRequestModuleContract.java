package androidx.health.connect.client.permission.platform;

import android.content.Context;
import android.content.Intent;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HealthPermissionsRequestModuleContract.kt */
@Metadata(m286d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0001\u0018\u00002\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J,\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002\u0018\u00010\r2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016J \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\bH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m287d2 = {"Landroidx/health/connect/client/permission/platform/HealthPermissionsRequestModuleContract;", "Landroidx/activity/result/contract/ActivityResultContract;", "", "", "()V", "requestPermissions", "Landroidx/activity/result/contract/ActivityResultContracts$RequestMultiplePermissions;", "createIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "input", "getSynchronousResult", "Landroidx/activity/result/contract/ActivityResultContract$SynchronousResult;", "parseResult", "resultCode", "", "intent", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HealthPermissionsRequestModuleContract extends ActivityResultContract<Set<? extends String>, Set<? extends String>> {
    private final ActivityResultContracts.RequestMultiplePermissions requestPermissions = new ActivityResultContracts.RequestMultiplePermissions();

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ Intent createIntent(Context p0, Set<? extends String> set) {
        return createIntent2(p0, (Set<String>) set);
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public /* bridge */ /* synthetic */ ActivityResultContract.SynchronousResult<Set<? extends String>> getSynchronousResult(Context p0, Set<? extends String> set) {
        return getSynchronousResult2(p0, (Set<String>) set);
    }

    /* renamed from: createIntent, reason: avoid collision after fix types in other method */
    public Intent createIntent2(Context context, Set<String> input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Set<String> $this$toTypedArray$iv = input;
        Intent createIntent = this.requestPermissions.createIntent(context, (String[]) $this$toTypedArray$iv.toArray(new String[0]));
        Intrinsics.checkNotNullExpressionValue(createIntent, "requestPermissions.creat…xt, input.toTypedArray())");
        return createIntent;
    }

    @Override // androidx.activity.result.contract.ActivityResultContract
    public Set<? extends String> parseResult(int resultCode, Intent intent) {
        Map $this$filterValues$iv = this.requestPermissions.parseResult(resultCode, intent);
        Intrinsics.checkNotNullExpressionValue($this$filterValues$iv, "requestPermissions.parseResult(resultCode, intent)");
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
            Boolean it = entry$iv.getValue();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                result$iv.put(entry$iv.getKey(), entry$iv.getValue());
            }
        }
        return result$iv.keySet();
    }

    /* renamed from: getSynchronousResult, reason: avoid collision after fix types in other method */
    public ActivityResultContract.SynchronousResult<Set<String>> getSynchronousResult2(Context context, Set<String> input) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(input, "input");
        Set<String> $this$toTypedArray$iv = input;
        ActivityResultContract.SynchronousResult result = this.requestPermissions.getSynchronousResult(context, (String[]) $this$toTypedArray$iv.toArray(new String[0]));
        if (result == null) {
            return null;
        }
        Map<String, Boolean> value = result.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "result.value");
        Map<String, Boolean> $this$filterValues$iv = value;
        LinkedHashMap result$iv = new LinkedHashMap();
        for (Map.Entry entry$iv : $this$filterValues$iv.entrySet()) {
            Boolean it = entry$iv.getValue();
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (it.booleanValue()) {
                result$iv.put(entry$iv.getKey(), entry$iv.getValue());
            }
        }
        LinkedHashMap $this$filterValues$iv2 = result$iv;
        return new ActivityResultContract.SynchronousResult<>($this$filterValues$iv2.keySet());
    }
}
