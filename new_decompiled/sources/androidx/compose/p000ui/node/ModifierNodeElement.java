package androidx.compose.p000ui.node;

import androidx.compose.p000ui.ActualKt;
import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.platform.InspectorValueInfo;
import androidx.compose.ui.Modifier.Node;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierNodeElement.kt */
@ExperimentalComposeUiApi
@Metadata(m286d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u0004B*\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\r\u0010\u000f\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0010J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0006H\u0096\u0002J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u0015\u0010\u0016\u001a\u00028\u00002\u0006\u0010\u0017\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0018R\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, m287d2 = {"Landroidx/compose/ui/node/ModifierNodeElement;", "N", "Landroidx/compose/ui/Modifier$Node;", "Landroidx/compose/ui/Modifier$Element;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "params", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "getParams$ui_release", "()Ljava/lang/Object;", "create", "()Landroidx/compose/ui/Modifier$Node;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "update", "node", "(Landroidx/compose/ui/Modifier$Node;)Landroidx/compose/ui/Modifier$Node;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public abstract class ModifierNodeElement<N extends Modifier.Node> extends InspectorValueInfo implements Modifier.Element {
    public static final int $stable = 0;
    private final Object params;

    public abstract N create();

    public abstract N update(N node);

    public /* synthetic */ ModifierNodeElement(Object obj, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : obj, function1);
    }

    /* renamed from: getParams$ui_release, reason: from getter */
    public final Object getParams() {
        return this.params;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ModifierNodeElement(Object params, Function1<? super InspectorInfo, Unit> inspectorInfo) {
        super(inspectorInfo);
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        this.params = params;
    }

    public int hashCode() {
        Object obj = this.params;
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if ((other instanceof ModifierNodeElement) && ActualKt.areObjectsOfSameType(this, other)) {
            return Intrinsics.areEqual(this.params, ((ModifierNodeElement) other).params);
        }
        return false;
    }
}
