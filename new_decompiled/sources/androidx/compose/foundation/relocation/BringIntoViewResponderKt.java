package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoViewResponder.kt */
@Metadata(m286d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\u001c\u0010\b\u001a\u00020\u0006*\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¨\u0006\f"}, m287d2 = {"bringIntoViewResponder", "Landroidx/compose/ui/Modifier;", "responder", "Landroidx/compose/foundation/relocation/BringIntoViewResponder;", "completelyOverlaps", "", "Landroidx/compose/ui/geometry/Rect;", Vo2MaxRecord.MeasurementMethod.OTHER, "localRectOf", "Landroidx/compose/ui/layout/LayoutCoordinates;", "sourceCoordinates", "rect", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BringIntoViewResponderKt {
    @ExperimentalFoundationApi
    public static final Modifier bringIntoViewResponder(Modifier $this$bringIntoViewResponder, final BringIntoViewResponder responder) {
        Intrinsics.checkNotNullParameter($this$bringIntoViewResponder, "<this>");
        Intrinsics.checkNotNullParameter(responder, "responder");
        return ComposedModifierKt.composed($this$bringIntoViewResponder, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderKt$bringIntoViewResponder$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo $this$null) {
                Intrinsics.checkNotNullParameter($this$null, "$this$null");
                $this$null.setName("bringIntoViewResponder");
                $this$null.getProperties().set("responder", BringIntoViewResponder.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.relocation.BringIntoViewResponderKt$bringIntoViewResponder$2
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-852052847);
                ComposerKt.sourceInformation($composer, "C111@5086L36,112@5142L85:BringIntoViewResponder.kt#exjx5q");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-852052847, $changed, -1, "androidx.compose.foundation.relocation.bringIntoViewResponder.<anonymous> (BringIntoViewResponder.kt:110)");
                }
                BringIntoViewParent defaultParent = BringIntoViewResponder_androidKt.rememberDefaultBringIntoViewParent($composer, 0);
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(defaultParent);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new BringIntoViewResponderModifier(defaultParent);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                BringIntoViewResponderModifier modifier = (BringIntoViewResponderModifier) value$iv$iv;
                modifier.setResponder(BringIntoViewResponder.this);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifier;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Rect localRectOf(LayoutCoordinates $this$localRectOf, LayoutCoordinates sourceCoordinates, Rect rect) {
        Rect localRect = $this$localRectOf.localBoundingBoxOf(sourceCoordinates, false);
        return rect.m1797translatek4lQ0M(localRect.m1795getTopLeftF1C5BW0());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean completelyOverlaps(Rect $this$completelyOverlaps, Rect other) {
        return $this$completelyOverlaps.getLeft() <= other.getLeft() && $this$completelyOverlaps.getTop() <= other.getTop() && $this$completelyOverlaps.getRight() >= other.getRight() && $this$completelyOverlaps.getBottom() >= other.getBottom();
    }
}
