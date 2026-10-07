package androidx.compose.p000ui.layout;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.node.LookaheadDelegate;
import androidx.compose.p000ui.node.NodeCoordinator;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LookaheadLayout.kt */
@Metadata(m286d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002Jg\u0010\t\u001a\u00020\n*\u00020\n2V\u0010\u000b\u001aR\u0012\u0004\u0012\u00020\r\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00160\f¢\u0006\u0002\b\u0017H\u0016ø\u0001\u0000JD\u0010\u0018\u001a\u00020\n*\u00020\n26\u0010\u0018\u001a2\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001b\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u001d0\u0019H\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, m287d2 = {"Landroidx/compose/ui/layout/LookaheadLayoutScopeImpl;", "Landroidx/compose/ui/layout/LookaheadLayoutScope;", "()V", "root", "Landroidx/compose/ui/node/NodeCoordinator;", "getRoot", "()Landroidx/compose/ui/node/NodeCoordinator;", "setRoot", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "intermediateLayout", "Landroidx/compose/ui/Modifier;", "measure", "Lkotlin/Function4;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "measurable", "Landroidx/compose/ui/unit/Constraints;", "constraints", "Landroidx/compose/ui/unit/IntSize;", "lookaheadSize", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "onPlaced", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "lookaheadScopeCoordinates", "layoutCoordinates", "", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class LookaheadLayoutScopeImpl implements LookaheadLayoutScope {
    private NodeCoordinator root;

    public final NodeCoordinator getRoot() {
        return this.root;
    }

    public final void setRoot(NodeCoordinator nodeCoordinator) {
        this.root = nodeCoordinator;
    }

    @Override // androidx.compose.p000ui.layout.LookaheadLayoutScope
    public Modifier onPlaced(Modifier $this$onPlaced, final Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> onPlaced) {
        Intrinsics.checkNotNullParameter($this$onPlaced, "<this>");
        Intrinsics.checkNotNullParameter(onPlaced, "onPlaced");
        return ComposedModifierKt.composed($this$onPlaced, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$onPlaced$$inlined$debugInspectorInfo$1
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
                $this$null.setName("onPlaced");
                $this$null.getProperties().set("onPlaced", Function2.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$onPlaced$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                $composer.startReplaceableGroup(-814093691);
                ComposerKt.sourceInformation($composer, "C177@7302L232:LookaheadLayout.kt#80mrfh");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-814093691, $changed, -1, "androidx.compose.ui.layout.LookaheadLayoutScopeImpl.onPlaced.<anonymous> (LookaheadLayout.kt:176)");
                }
                Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> function2 = onPlaced;
                final LookaheadLayoutScopeImpl lookaheadLayoutScopeImpl = this;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new LookaheadOnPlacedModifier(function2, new Function0<LookaheadLayoutCoordinates>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$onPlaced$2$1$1
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final LookaheadLayoutCoordinates invoke() {
                            NodeCoordinator $this$invoke_u24lambda_u2d0 = LookaheadLayoutScopeImpl.this.getRoot();
                            if ($this$invoke_u24lambda_u2d0 != null) {
                                LookaheadDelegate lookaheadDelegate = $this$invoke_u24lambda_u2d0.getLookaheadDelegate();
                                Intrinsics.checkNotNull(lookaheadDelegate);
                                LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinates = lookaheadDelegate.getLookaheadLayoutCoordinates();
                                if (lookaheadLayoutCoordinates != null) {
                                    return lookaheadLayoutCoordinates;
                                }
                            }
                            throw new IllegalStateException("Lookahead root has not been set up yet".toString());
                        }
                    });
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                Modifier then = composed.then((Modifier) value$iv$iv);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return then;
            }
        });
    }

    @Override // androidx.compose.p000ui.layout.LookaheadLayoutScope
    public Modifier intermediateLayout(Modifier $this$intermediateLayout, final Function4<? super MeasureScope, ? super Measurable, ? super Constraints, ? super IntSize, ? extends MeasureResult> measure) {
        Intrinsics.checkNotNullParameter($this$intermediateLayout, "<this>");
        Intrinsics.checkNotNullParameter(measure, "measure");
        return $this$intermediateLayout.then(new LookaheadIntermediateLayoutModifierImpl(measure, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.layout.LookaheadLayoutScopeImpl$intermediateLayout$$inlined$debugInspectorInfo$1
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
                $this$null.setName("intermediateLayout");
                $this$null.getProperties().set("measure", Function4.this);
            }
        } : InspectableValueKt.getNoInspectorInfo()));
    }
}
