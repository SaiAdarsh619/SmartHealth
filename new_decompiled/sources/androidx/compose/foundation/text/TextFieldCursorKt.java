package androidx.compose.foundation.text;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.DrawModifierKt;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.Color;
import androidx.compose.p000ui.graphics.SolidColor;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.graphics.drawscope.DrawScope;
import androidx.compose.p000ui.text.TextLayoutResult;
import androidx.compose.p000ui.text.TextRange;
import androidx.compose.p000ui.text.input.OffsetMapping;
import androidx.compose.p000ui.text.input.TextFieldValue;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: TextFieldCursor.kt */
@Metadata(m286d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a4\u0010\b\u001a\u00020\t*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0000\"\u0019\u0010\u0000\u001a\u00020\u0001X\u0080\u0004ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, m287d2 = {"DefaultCursorThickness", "Landroidx/compose/ui/unit/Dp;", "getDefaultCursorThickness", "()F", "F", "cursorAnimationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "", "cursor", "Landroidx/compose/ui/Modifier;", "state", "Landroidx/compose/foundation/text/TextFieldState;", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "offsetMapping", "Landroidx/compose/ui/text/input/OffsetMapping;", "cursorBrush", "Landroidx/compose/ui/graphics/Brush;", "enabled", "", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class TextFieldCursorKt {
    private static final AnimationSpec<Float> cursorAnimationSpec = AnimationSpecKt.m432infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1<KeyframesSpec.KeyframesSpecConfig<Float>, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursorAnimationSpec$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(KeyframesSpec.KeyframesSpecConfig<Float> keyframesSpecConfig) {
            invoke2(keyframesSpecConfig);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(KeyframesSpec.KeyframesSpecConfig<Float> keyframes) {
            Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
            keyframes.setDurationMillis(1000);
            Float valueOf = Float.valueOf(1.0f);
            keyframes.m4at(valueOf, 0);
            keyframes.m4at(valueOf, 499);
            Float valueOf2 = Float.valueOf(0.0f);
            keyframes.m4at(valueOf2, 500);
            keyframes.m4at(valueOf2, 999);
        }
    }), null, 0, 6, null);
    private static final float DefaultCursorThickness = C0504Dp.m4382constructorimpl(2);

    public static final Modifier cursor(Modifier $this$cursor, final TextFieldState state, final TextFieldValue value, final OffsetMapping offsetMapping, final Brush cursorBrush, boolean enabled) {
        Intrinsics.checkNotNullParameter($this$cursor, "<this>");
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(cursorBrush, "cursorBrush");
        return enabled ? ComposedModifierKt.composed$default($this$cursor, null, new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                Modifier.Companion companion;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1634330012);
                ComposerKt.sourceInformation($composer, "C44@1689L27,47@1891L326:TextFieldCursor.kt#423gt5");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1634330012, $changed, -1, "androidx.compose.foundation.text.cursor.<anonymous> (TextFieldCursor.kt:43)");
                }
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = AnimatableKt.Animatable$default(1.0f, 0.0f, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                final Animatable cursorAlpha = (Animatable) value$iv$iv;
                boolean z = true;
                if (Brush.this instanceof SolidColor) {
                    long $this$isUnspecified$iv = ((SolidColor) Brush.this).getValue();
                    if (($this$isUnspecified$iv == Color.INSTANCE.m2032getUnspecified0d7_KjU() ? 1 : 0) != 0) {
                        z = false;
                    }
                }
                boolean isBrushSpecified = z;
                if (state.getHasFocus() && TextRange.m3951getCollapsedimpl(value.getSelection()) && isBrushSpecified) {
                    EffectsKt.LaunchedEffect(value.getText(), TextRange.m3945boximpl(value.getSelection()), new C02431(cursorAlpha, null), $composer, 512);
                    final OffsetMapping offsetMapping2 = offsetMapping;
                    final TextFieldValue textFieldValue = value;
                    final TextFieldState textFieldState = state;
                    final Brush brush = Brush.this;
                    companion = DrawModifierKt.drawWithContent(composed, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                            invoke2(contentDrawScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ContentDrawScope drawWithContent) {
                            Rect rect;
                            TextLayoutResult value2;
                            Intrinsics.checkNotNullParameter(drawWithContent, "$this$drawWithContent");
                            drawWithContent.drawContent();
                            float cursorAlphaValue = RangesKt.coerceIn(cursorAlpha.getValue().floatValue(), 0.0f, 1.0f);
                            if (!(cursorAlphaValue == 0.0f)) {
                                int transformedOffset = offsetMapping2.originalToTransformed(TextRange.m3957getStartimpl(textFieldValue.getSelection()));
                                TextLayoutResultProxy layoutResult = textFieldState.getLayoutResult();
                                if (layoutResult == null || (value2 = layoutResult.getValue()) == null || (rect = value2.getCursorRect(transformedOffset)) == null) {
                                    rect = new Rect(0.0f, 0.0f, 0.0f, 0.0f);
                                }
                                Rect cursorRect = rect;
                                float cursorWidth = drawWithContent.mo648toPx0680j_4(TextFieldCursorKt.getDefaultCursorThickness());
                                float f = 2;
                                float cursorX = RangesKt.coerceAtMost(cursorRect.getLeft() + (cursorWidth / f), Size.m1829getWidthimpl(drawWithContent.mo2490getSizeNHjbRc()) - (cursorWidth / f));
                                DrawScope.m2476drawLine1RTmtNc$default(drawWithContent, brush, OffsetKt.Offset(cursorX, cursorRect.getTop()), OffsetKt.Offset(cursorX, cursorRect.getBottom()), cursorWidth, 0, null, cursorAlphaValue, null, 0, 432, null);
                            }
                        }
                    });
                } else {
                    companion = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return companion;
            }

            /* compiled from: TextFieldCursor.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1", m297f = "TextFieldCursor.kt", m298i = {}, m299l = {50, 52}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.text.TextFieldCursorKt$cursor$1$1 */
            static final class C02431 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ Animatable<Float, AnimationVector1D> $cursorAlpha;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02431(Animatable<Float, AnimationVector1D> animatable, Continuation<? super C02431> continuation) {
                    super(2, continuation);
                    this.$cursorAlpha = animatable;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C02431(this.$cursorAlpha, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((C02431) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* JADX WARN: Removed duplicated region for block: B:12:0x0051 A[RETURN] */
                /* JADX WARN: Removed duplicated region for block: B:13:0x0052  */
                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object invokeSuspend(Object $result) {
                    C02431 c02431;
                    AnimationSpec animationSpec;
                    Object animateTo;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            c02431 = this;
                            c02431.label = 1;
                            if (c02431.$cursorAlpha.snapTo(Boxing.boxFloat(1.0f), c02431) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            Animatable<Float, AnimationVector1D> animatable = c02431.$cursorAlpha;
                            Float boxFloat = Boxing.boxFloat(0.0f);
                            animationSpec = TextFieldCursorKt.cursorAnimationSpec;
                            c02431.label = 2;
                            animateTo = animatable.animateTo(boxFloat, (r12 & 2) != 0 ? animatable.defaultSpringSpec : animationSpec, (r12 & 4) != 0 ? animatable.getVelocity() : null, (r12 & 8) != 0 ? null : null, c02431);
                            return animateTo != coroutine_suspended ? coroutine_suspended : Unit.INSTANCE;
                        case 1:
                            c02431 = this;
                            ResultKt.throwOnFailure($result);
                            Animatable<Float, AnimationVector1D> animatable2 = c02431.$cursorAlpha;
                            Float boxFloat2 = Boxing.boxFloat(0.0f);
                            animationSpec = TextFieldCursorKt.cursorAnimationSpec;
                            c02431.label = 2;
                            animateTo = animatable2.animateTo(boxFloat2, (r12 & 2) != 0 ? animatable2.defaultSpringSpec : animationSpec, (r12 & 4) != 0 ? animatable2.getVelocity() : null, (r12 & 8) != 0 ? null : null, c02431);
                            if (animateTo != coroutine_suspended) {
                            }
                            break;
                        case 2:
                            ResultKt.throwOnFailure($result);
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
        }, 1, null) : $this$cursor;
    }

    public static final float getDefaultCursorThickness() {
        return DefaultCursorThickness;
    }
}
