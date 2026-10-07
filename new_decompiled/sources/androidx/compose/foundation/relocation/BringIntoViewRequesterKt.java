package androidx.compose.foundation.relocation;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BringIntoViewRequester.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0007\u001a\u0014\u0010\u0002\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0001H\u0007¨\u0006\u0004"}, m287d2 = {"BringIntoViewRequester", "Landroidx/compose/foundation/relocation/BringIntoViewRequester;", "bringIntoViewRequester", "Landroidx/compose/ui/Modifier;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BringIntoViewRequesterKt {
    @ExperimentalFoundationApi
    public static final BringIntoViewRequester BringIntoViewRequester() {
        return new BringIntoViewRequesterImpl();
    }

    @ExperimentalFoundationApi
    public static final Modifier bringIntoViewRequester(Modifier $this$bringIntoViewRequester, final BringIntoViewRequester bringIntoViewRequester) {
        Intrinsics.checkNotNullParameter($this$bringIntoViewRequester, "<this>");
        Intrinsics.checkNotNullParameter(bringIntoViewRequester, "bringIntoViewRequester");
        return ComposedModifierKt.composed($this$bringIntoViewRequester, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$$inlined$debugInspectorInfo$1
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
                $this$null.setName("bringIntoViewRequester");
                $this$null.getProperties().set("bringIntoViewRequester", BringIntoViewRequester.this);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2
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
                $composer.startReplaceableGroup(-992853993);
                ComposerKt.sourceInformation($composer, "C101@4480L36,102@4536L91,106@4700L180:BringIntoViewRequester.kt#exjx5q");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-992853993, $changed, -1, "androidx.compose.foundation.relocation.bringIntoViewRequester.<anonymous> (BringIntoViewRequester.kt:100)");
                }
                BringIntoViewParent defaultResponder = BringIntoViewResponder_androidKt.rememberDefaultBringIntoViewParent($composer, 0);
                $composer.startReplaceableGroup(1157296644);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(defaultResponder);
                Object it$iv$iv = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new BringIntoViewRequesterModifier(defaultResponder);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                final BringIntoViewRequesterModifier modifier = (BringIntoViewRequesterModifier) value$iv$iv;
                if (BringIntoViewRequester.this instanceof BringIntoViewRequesterImpl) {
                    BringIntoViewRequester bringIntoViewRequester2 = BringIntoViewRequester.this;
                    final BringIntoViewRequester bringIntoViewRequester3 = BringIntoViewRequester.this;
                    EffectsKt.DisposableEffect(bringIntoViewRequester2, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                            MutableVector this_$iv = ((BringIntoViewRequesterImpl) BringIntoViewRequester.this).getModifiers();
                            this_$iv.add(modifier);
                            final BringIntoViewRequester bringIntoViewRequester4 = BringIntoViewRequester.this;
                            final BringIntoViewRequesterModifier bringIntoViewRequesterModifier = modifier;
                            return new DisposableEffectResult() { // from class: androidx.compose.foundation.relocation.BringIntoViewRequesterKt$bringIntoViewRequester$2$1$invoke$$inlined$onDispose$1
                                @Override // androidx.compose.runtime.DisposableEffectResult
                                public void dispose() {
                                    MutableVector this_$iv2 = ((BringIntoViewRequesterImpl) BringIntoViewRequester.this).getModifiers();
                                    this_$iv2.remove(bringIntoViewRequesterModifier);
                                }
                            };
                        }
                    }, $composer, 0);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return modifier;
            }
        });
    }
}
