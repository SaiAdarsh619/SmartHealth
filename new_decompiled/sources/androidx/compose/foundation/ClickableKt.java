package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.ScrollableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.input.key.Key;
import androidx.compose.p000ui.input.key.KeyEvent;
import androidx.compose.p000ui.input.key.KeyEvent_androidKt;
import androidx.compose.p000ui.input.key.KeyInputModifierKt;
import androidx.compose.p000ui.input.pointer.PointerInputScope;
import androidx.compose.p000ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalReadScope;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.semantics.Role;
import androidx.compose.p000ui.semantics.SemanticsModifierKt;
import androidx.compose.p000ui.semantics.SemanticsPropertiesKt;
import androidx.compose.p000ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* compiled from: Clickable.kt */
@Metadata(m286d1 = {"\u0000d\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a<\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\bH\u0001ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aW\u0010\u000b\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0017\u001aE\u0010\u000b\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u0018\u001a\u0089\u0001\u0010\u0019\u001a\u00020\f*\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001d\u001aw\u0010\u0019\u001a\u00020\f*\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b\u001e\u001a©\u0001\u0010\u001f\u001a\u00020\f*\u00020\f2\u0006\u0010 \u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010!\u001a\u00020\"2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00060\b2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00122\u0010\b\u0002\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u0016H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\b&\u001aQ\u0010'\u001a\u00020\u0001*\u00020(2\u0006\u0010)\u001a\u00020%2\u0006\u0010\u0002\u001a\u00020\u00032\u000e\u0010\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00052\u0012\u0010*\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00160$H\u0080@ø\u0001\u0001ø\u0001\u0000ø\u0001\u0000¢\u0006\u0004\b+\u0010,\u0082\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006-"}, m287d2 = {"PressedInteractionSourceDisposableEffect", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "pressedInteraction", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "currentKeyPressInteractions", "", "Landroidx/compose/ui/input/key/Key;", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Ljava/util/Map;Landroidx/compose/runtime/Composer;I)V", "clickable", "Landroidx/compose/ui/Modifier;", "indication", "Landroidx/compose/foundation/Indication;", "enabled", "", "onClickLabel", "", "role", "Landroidx/compose/ui/semantics/Role;", "onClick", "Lkotlin/Function0;", "clickable-O2vRcR0", "clickable-XHw0xAI", "combinedClickable", "onLongClickLabel", "onLongClick", "onDoubleClick", "combinedClickable-XVZzFYc", "combinedClickable-cJG_KMw", "genericClickableWithoutGesture", "gestureModifiers", "indicationScope", "Lkotlinx/coroutines/CoroutineScope;", "keyClickOffset", "Landroidx/compose/runtime/State;", "Landroidx/compose/ui/geometry/Offset;", "genericClickableWithoutGesture-bdNGguI", "handlePressInteraction", "Landroidx/compose/foundation/gestures/PressGestureScope;", "pressPoint", "delayPressInteraction", "handlePressInteraction-EPk0efs", "(Landroidx/compose/foundation/gestures/PressGestureScope;JLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/MutableState;Landroidx/compose/runtime/State;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "foundation_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ClickableKt {
    /* renamed from: clickable-XHw0xAI$default, reason: not valid java name */
    public static /* synthetic */ Modifier m514clickableXHw0xAI$default(Modifier modifier, boolean z, String str, Role role, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        if ((i & 4) != 0) {
            role = null;
        }
        return m513clickableXHw0xAI(modifier, z, str, role, function0);
    }

    /* renamed from: clickable-XHw0xAI, reason: not valid java name */
    public static final Modifier m513clickableXHw0xAI(Modifier clickable, final boolean enabled, final String onClickLabel, final Role role, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(clickable, "$this$clickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(clickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-XHw0xAI$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                $this$null.setName("clickable");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("onClickLabel", onClickLabel);
                $this$null.getProperties().set("role", role);
                $this$null.getProperties().set("onClick", onClick);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$2
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
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(-756081143);
                ComposerKt.sourceInformation($composer, "C98@4098L7,99@4135L39:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-756081143, $changed, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:92)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Indication indication = (Indication) consume;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                Modifier m511clickableO2vRcR0 = ClickableKt.m511clickableO2vRcR0(companion, (MutableInteractionSource) value$iv$iv, indication, enabled, onClickLabel, role, onClick);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return m511clickableO2vRcR0;
            }
        });
    }

    /* renamed from: clickable-O2vRcR0, reason: not valid java name */
    public static final Modifier m511clickableO2vRcR0(Modifier clickable, final MutableInteractionSource interactionSource, final Indication indication, final boolean enabled, final String onClickLabel, final Role role, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(clickable, "$this$clickable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(clickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$clickable-O2vRcR0$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                $this$null.setName("clickable");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("onClickLabel", onClickLabel);
                $this$null.getProperties().set("role", role);
                $this$null.getProperties().set("onClick", onClick);
                $this$null.getProperties().set("indication", indication);
                $this$null.getProperties().set("interactionSource", interactionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4
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
                LinkedHashMap value$iv$iv2;
                Object value$iv$iv3;
                Object value$iv$iv4;
                Object value$iv$iv5;
                Modifier.Companion companion;
                String str;
                Object value$iv$iv6;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(92076020);
                ComposerKt.sourceInformation($composer, "C136@5787L29,137@5850L58,138@5951L56,146@6266L36,147@6350L33,148@6441L95,148@6420L116,151@6564L40,153@6678L550,171@7281L445,186@7960L24:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(92076020, $changed, -1, "androidx.compose.foundation.clickable.<anonymous> (Clickable.kt:135)");
                }
                State onClickState = SnapshotStateKt.rememberUpdatedState(onClick, $composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                MutableState pressedInteraction = (MutableState) value$iv$iv;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv2 = $composer.rememberedValue();
                if (it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = new LinkedHashMap();
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv2;
                }
                $composer.endReplaceableGroup();
                Map currentKeyPressInteractions = (Map) value$iv$iv2;
                $composer.startReplaceableGroup(1841981561);
                ComposerKt.sourceInformation($composer, "140@6043L170");
                if (enabled) {
                    ClickableKt.PressedInteractionSourceDisposableEffect(interactionSource, pressedInteraction, currentKeyPressInteractions, $composer, 560);
                }
                $composer.endReplaceableGroup();
                final Function0 isRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer($composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv3 = $composer.rememberedValue();
                if (it$iv$iv3 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv3;
                }
                $composer.endReplaceableGroup();
                final MutableState isClickableInScrollableContainer = (MutableState) value$iv$iv3;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv = $composer.changed(isClickableInScrollableContainer) | $composer.changed(isRootInScrollableContainer);
                Object it$iv$iv4 = $composer.rememberedValue();
                if (invalid$iv$iv || it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv4 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$delayPressInteraction$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            return Boolean.valueOf(isClickableInScrollableContainer.getValue().booleanValue() || isRootInScrollableContainer.invoke().booleanValue());
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv4);
                } else {
                    value$iv$iv4 = it$iv$iv4;
                }
                $composer.endReplaceableGroup();
                State delayPressInteraction = SnapshotStateKt.rememberUpdatedState(value$iv$iv4, $composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv5 = $composer.rememberedValue();
                if (it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1749boximpl(Offset.INSTANCE.m1776getZeroF1C5BW0()), null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv5);
                } else {
                    value$iv$iv5 = it$iv$iv5;
                }
                $composer.endReplaceableGroup();
                MutableState centreOffset = (MutableState) value$iv$iv5;
                Modifier.Companion companion2 = Modifier.INSTANCE;
                MutableInteractionSource mutableInteractionSource = interactionSource;
                Boolean valueOf = Boolean.valueOf(enabled);
                Object[] keys$iv = {centreOffset, Boolean.valueOf(enabled), interactionSource, pressedInteraction, delayPressInteraction, onClickState};
                boolean z = enabled;
                MutableInteractionSource mutableInteractionSource2 = interactionSource;
                $composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                boolean invalid$iv = false;
                for (Object key$iv : keys$iv) {
                    invalid$iv |= $composer.changed(key$iv);
                }
                ClickableKt$clickable$4$gesture$1$1 value$iv$iv7 = $composer.rememberedValue();
                if (invalid$iv || value$iv$iv7 == Composer.INSTANCE.getEmpty()) {
                    companion = companion2;
                    str = "C(remember):Composables.kt#9igjgp";
                    value$iv$iv7 = new ClickableKt$clickable$4$gesture$1$1(centreOffset, z, mutableInteractionSource2, pressedInteraction, delayPressInteraction, onClickState, null);
                    $composer.updateRememberedValue(value$iv$iv7);
                } else {
                    companion = companion2;
                    str = "C(remember):Composables.kt#9igjgp";
                }
                $composer.endReplaceableGroup();
                Modifier gesture = SuspendingPointerInputFilterKt.pointerInput(companion, mutableInteractionSource, valueOf, (Function2) value$iv$iv7);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, str);
                Object it$iv$iv6 = $composer.rememberedValue();
                if (it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv6 = new ModifierLocalConsumer() { // from class: androidx.compose.foundation.ClickableKt$clickable$4$1$1
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // androidx.compose.p000ui.modifier.ModifierLocalConsumer
                        public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
                            Intrinsics.checkNotNullParameter(scope, "scope");
                            isClickableInScrollableContainer.setValue(scope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
                        }
                    };
                    $composer.updateRememberedValue(value$iv$iv6);
                } else {
                    value$iv$iv6 = it$iv$iv6;
                }
                $composer.endReplaceableGroup();
                Modifier then = companion3.then((Modifier) value$iv$iv6);
                MutableInteractionSource mutableInteractionSource3 = interactionSource;
                Indication indication2 = indication;
                $composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, str);
                Object value$iv$iv$iv = $composer.rememberedValue();
                if (value$iv$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                    $composer.updateRememberedValue(value$iv$iv$iv);
                }
                $composer.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                $composer.endReplaceableGroup();
                Modifier m519genericClickableWithoutGesturebdNGguI = ClickableKt.m519genericClickableWithoutGesturebdNGguI(then, gesture, mutableInteractionSource3, indication2, coroutineScope, currentKeyPressInteractions, centreOffset, enabled, onClickLabel, role, null, null, onClick);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return m519genericClickableWithoutGesturebdNGguI;
            }
        });
    }

    @ExperimentalFoundationApi
    /* renamed from: combinedClickable-cJG_KMw, reason: not valid java name */
    public static final Modifier m517combinedClickablecJG_KMw(Modifier combinedClickable, final boolean enabled, final String onClickLabel, final Role role, final String onLongClickLabel, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(combinedClickable, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(combinedClickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-cJG_KMw$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                $this$null.setName("combinedClickable");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("onClickLabel", onClickLabel);
                $this$null.getProperties().set("role", role);
                $this$null.getProperties().set("onClick", onClick);
                $this$null.getProperties().set("onDoubleClick", function02);
                $this$null.getProperties().set("onLongClick", function0);
                $this$null.getProperties().set("onLongClickLabel", onLongClickLabel);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$2
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
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1969174843);
                ComposerKt.sourceInformation($composer, "C261@10940L7,262@10977L39:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1969174843, $changed, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:252)");
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                ProvidableCompositionLocal<Indication> localIndication = IndicationKt.getLocalIndication();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localIndication);
                ComposerKt.sourceInformationMarkerEnd($composer);
                Indication indication = (Indication) consume;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer.endReplaceableGroup();
                Modifier m515combinedClickableXVZzFYc = ClickableKt.m515combinedClickableXVZzFYc(companion, (MutableInteractionSource) value$iv$iv, indication, enabled, onClickLabel, role, onLongClickLabel, function0, function02, onClick);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return m515combinedClickableXVZzFYc;
            }
        });
    }

    @ExperimentalFoundationApi
    /* renamed from: combinedClickable-XVZzFYc, reason: not valid java name */
    public static final Modifier m515combinedClickableXVZzFYc(Modifier combinedClickable, final MutableInteractionSource interactionSource, final Indication indication, final boolean enabled, final String onClickLabel, final Role role, final String onLongClickLabel, final Function0<Unit> function0, final Function0<Unit> function02, final Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(combinedClickable, "$this$combinedClickable");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return ComposedModifierKt.composed(combinedClickable, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable-XVZzFYc$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                $this$null.setName("combinedClickable");
                $this$null.getProperties().set("enabled", Boolean.valueOf(enabled));
                $this$null.getProperties().set("onClickLabel", onClickLabel);
                $this$null.getProperties().set("role", role);
                $this$null.getProperties().set("onClick", onClick);
                $this$null.getProperties().set("onDoubleClick", function02);
                $this$null.getProperties().set("onLongClick", function0);
                $this$null.getProperties().set("onLongClickLabel", onLongClickLabel);
                $this$null.getProperties().set("indication", indication);
                $this$null.getProperties().set("interactionSource", interactionSource);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            /* JADX WARN: Removed duplicated region for block: B:35:0x01cd  */
            /* JADX WARN: Removed duplicated region for block: B:38:0x025a A[LOOP:0: B:37:0x0258->B:38:0x025a, LOOP_END] */
            /* JADX WARN: Removed duplicated region for block: B:47:0x02ce  */
            /* JADX WARN: Removed duplicated region for block: B:50:0x0320  */
            /* JADX WARN: Removed duplicated region for block: B:53:0x037b  */
            /* JADX WARN: Removed duplicated region for block: B:57:0x033d  */
            /* JADX WARN: Removed duplicated region for block: B:58:0x02dd  */
            /* JADX WARN: Removed duplicated region for block: B:61:0x01e9  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Object value$iv$iv;
                LinkedHashMap value$iv$iv2;
                Object value$iv$iv3;
                Object value$iv$iv4;
                Object it$iv$iv;
                Object value$iv$iv5;
                boolean invalid$iv;
                Object it$iv$iv2;
                ClickableKt$combinedClickable$4$gesture$1$1 value$iv$iv6;
                Object it$iv$iv3;
                final MutableState isClickableInScrollableContainer;
                Object value$iv$iv7;
                Object it$iv$iv$iv;
                Object value$iv$iv$iv;
                Object value$iv$iv8;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(1841718000);
                ComposerKt.sourceInformation($composer, "C307@13021L29,308@13082L33,309@13149L35,312@13316L58,313@13417L56,332@14268L36,333@14352L33,334@14443L95,334@14422L116,337@14566L40,340@14722L1028,368@15803L445,383@16482L24:Clickable.kt#71ulvw");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1841718000, $changed, -1, "androidx.compose.foundation.combinedClickable.<anonymous> (Clickable.kt:306)");
                }
                State onClickState = SnapshotStateKt.rememberUpdatedState(onClick, $composer, 0);
                State onLongClickState = SnapshotStateKt.rememberUpdatedState(function0, $composer, 0);
                State onDoubleClickState = SnapshotStateKt.rememberUpdatedState(function02, $composer, 0);
                boolean hasLongClick = function0 != null;
                boolean hasDoubleClick = function02 != null;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv4 = $composer.rememberedValue();
                if (it$iv$iv4 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv4;
                }
                $composer.endReplaceableGroup();
                final MutableState pressedInteraction = (MutableState) value$iv$iv;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv5 = $composer.rememberedValue();
                if (it$iv$iv5 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv2 = new LinkedHashMap();
                    $composer.updateRememberedValue(value$iv$iv2);
                } else {
                    value$iv$iv2 = it$iv$iv5;
                }
                $composer.endReplaceableGroup();
                Map currentKeyPressInteractions = (Map) value$iv$iv2;
                $composer.startReplaceableGroup(1321107720);
                ComposerKt.sourceInformation($composer, "317@13690L342,317@13659L373,326@14045L170");
                if (enabled) {
                    Boolean valueOf = Boolean.valueOf(hasLongClick);
                    Object key2$iv = interactionSource;
                    final MutableInteractionSource mutableInteractionSource = interactionSource;
                    $composer.startReplaceableGroup(511388516);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                    boolean invalid$iv$iv = $composer.changed(pressedInteraction) | $composer.changed(key2$iv);
                    Object it$iv$iv6 = $composer.rememberedValue();
                    if (invalid$iv$iv || it$iv$iv6 == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv8 = (Function1) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                                final MutableState<PressInteraction.Press> mutableState = pressedInteraction;
                                final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
                                return new DisposableEffectResult() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$1$1$invoke$$inlined$onDispose$1
                                    @Override // androidx.compose.runtime.DisposableEffectResult
                                    public void dispose() {
                                        PressInteraction.Press oldValue = (PressInteraction.Press) MutableState.this.getValue();
                                        if (oldValue == null) {
                                            return;
                                        }
                                        PressInteraction.Cancel interaction = new PressInteraction.Cancel(oldValue);
                                        mutableInteractionSource2.tryEmit(interaction);
                                        MutableState.this.setValue(null);
                                    }
                                };
                            }
                        };
                        $composer.updateRememberedValue(value$iv$iv8);
                    } else {
                        value$iv$iv8 = it$iv$iv6;
                    }
                    $composer.endReplaceableGroup();
                    EffectsKt.DisposableEffect(valueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) value$iv$iv8, $composer, 0);
                    ClickableKt.PressedInteractionSourceDisposableEffect(interactionSource, pressedInteraction, currentKeyPressInteractions, $composer, 560);
                }
                $composer.endReplaceableGroup();
                final Function0 isRootInScrollableContainer = Clickable_androidKt.isComposeRootInScrollableContainer($composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                Object it$iv$iv7 = $composer.rememberedValue();
                if (it$iv$iv7 == Composer.INSTANCE.getEmpty()) {
                    value$iv$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                    $composer.updateRememberedValue(value$iv$iv3);
                } else {
                    value$iv$iv3 = it$iv$iv7;
                }
                $composer.endReplaceableGroup();
                final MutableState isClickableInScrollableContainer2 = (MutableState) value$iv$iv3;
                $composer.startReplaceableGroup(511388516);
                ComposerKt.sourceInformation($composer, "C(remember)P(1,2):Composables.kt#9igjgp");
                boolean invalid$iv$iv2 = $composer.changed(isClickableInScrollableContainer2) | $composer.changed(isRootInScrollableContainer);
                Object it$iv$iv8 = $composer.rememberedValue();
                if (!invalid$iv$iv2 && it$iv$iv8 != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv4 = it$iv$iv8;
                    $composer.endReplaceableGroup();
                    State delayPressInteraction = SnapshotStateKt.rememberUpdatedState(value$iv$iv4, $composer, 0);
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Offset.m1749boximpl(Offset.INSTANCE.m1776getZeroF1C5BW0()), null, 2, null);
                        $composer.updateRememberedValue(value$iv$iv5);
                    } else {
                        value$iv$iv5 = it$iv$iv;
                    }
                    $composer.endReplaceableGroup();
                    MutableState centreOffset = (MutableState) value$iv$iv5;
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Object[] objArr = {interactionSource, Boolean.valueOf(hasLongClick), Boolean.valueOf(hasDoubleClick), Boolean.valueOf(enabled)};
                    Object[] keys$iv = {centreOffset, Boolean.valueOf(hasDoubleClick), Boolean.valueOf(enabled), onDoubleClickState, Boolean.valueOf(hasLongClick), onLongClickState, interactionSource, pressedInteraction, delayPressInteraction, onClickState};
                    boolean z = enabled;
                    MutableInteractionSource mutableInteractionSource2 = interactionSource;
                    $composer.startReplaceableGroup(-568225417);
                    ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv = false;
                    for (Object key$iv : keys$iv) {
                        invalid$iv |= $composer.changed(key$iv);
                    }
                    it$iv$iv2 = $composer.rememberedValue();
                    if (!invalid$iv && it$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv6 = it$iv$iv2;
                        $composer.endReplaceableGroup();
                        Modifier gesture = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv6);
                        Modifier.Companion companion2 = Modifier.INSTANCE;
                        $composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv3 = $composer.rememberedValue();
                        if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                            isClickableInScrollableContainer = isClickableInScrollableContainer2;
                            value$iv$iv7 = new ModifierLocalConsumer() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$2$1
                                /* JADX WARN: Multi-variable type inference failed */
                                @Override // androidx.compose.p000ui.modifier.ModifierLocalConsumer
                                public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
                                    Intrinsics.checkNotNullParameter(scope, "scope");
                                    isClickableInScrollableContainer.setValue(scope.getCurrent(ScrollableKt.getModifierLocalScrollableContainer()));
                                }
                            };
                            $composer.updateRememberedValue(value$iv$iv7);
                        } else {
                            isClickableInScrollableContainer = isClickableInScrollableContainer2;
                            value$iv$iv7 = it$iv$iv3;
                        }
                        $composer.endReplaceableGroup();
                        Modifier then = companion2.then((Modifier) value$iv$iv7);
                        MutableInteractionSource mutableInteractionSource3 = interactionSource;
                        Indication indication2 = indication;
                        $composer.startReplaceableGroup(773894976);
                        ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                        $composer.startReplaceableGroup(-492369756);
                        ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                        it$iv$iv$iv = $composer.rememberedValue();
                        if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                            value$iv$iv$iv = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, $composer));
                            $composer.updateRememberedValue(value$iv$iv$iv);
                        } else {
                            value$iv$iv$iv = it$iv$iv$iv;
                        }
                        $composer.endReplaceableGroup();
                        CompositionScopedCoroutineScopeCanceller wrapper$iv = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                        CoroutineScope coroutineScope = wrapper$iv.getCoroutineScope();
                        $composer.endReplaceableGroup();
                        Modifier m519genericClickableWithoutGesturebdNGguI = ClickableKt.m519genericClickableWithoutGesturebdNGguI(then, gesture, mutableInteractionSource3, indication2, coroutineScope, currentKeyPressInteractions, centreOffset, enabled, onClickLabel, role, onLongClickLabel, function0, onClick);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        $composer.endReplaceableGroup();
                        return m519genericClickableWithoutGesturebdNGguI;
                    }
                    value$iv$iv6 = new ClickableKt$combinedClickable$4$gesture$1$1(centreOffset, hasDoubleClick, z, hasLongClick, onDoubleClickState, onLongClickState, mutableInteractionSource2, pressedInteraction, delayPressInteraction, onClickState, null);
                    $composer.updateRememberedValue(value$iv$iv6);
                    $composer.endReplaceableGroup();
                    Modifier gesture2 = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion, objArr, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv6);
                    Modifier.Companion companion22 = Modifier.INSTANCE;
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv3 = $composer.rememberedValue();
                    if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer.endReplaceableGroup();
                    Modifier then2 = companion22.then((Modifier) value$iv$iv7);
                    MutableInteractionSource mutableInteractionSource32 = interactionSource;
                    Indication indication22 = indication;
                    $composer.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer.endReplaceableGroup();
                    CompositionScopedCoroutineScopeCanceller wrapper$iv2 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                    CoroutineScope coroutineScope2 = wrapper$iv2.getCoroutineScope();
                    $composer.endReplaceableGroup();
                    Modifier m519genericClickableWithoutGesturebdNGguI2 = ClickableKt.m519genericClickableWithoutGesturebdNGguI(then2, gesture2, mutableInteractionSource32, indication22, coroutineScope2, currentKeyPressInteractions, centreOffset, enabled, onClickLabel, role, onLongClickLabel, function0, onClick);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    return m519genericClickableWithoutGesturebdNGguI2;
                }
                value$iv$iv4 = (Function0) new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$combinedClickable$4$delayPressInteraction$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        return Boolean.valueOf(isClickableInScrollableContainer2.getValue().booleanValue() || isRootInScrollableContainer.invoke().booleanValue());
                    }
                };
                $composer.updateRememberedValue(value$iv$iv4);
                $composer.endReplaceableGroup();
                State delayPressInteraction2 = SnapshotStateKt.rememberUpdatedState(value$iv$iv4, $composer, 0);
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                it$iv$iv = $composer.rememberedValue();
                if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
                }
                $composer.endReplaceableGroup();
                MutableState centreOffset2 = (MutableState) value$iv$iv5;
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Object[] objArr2 = {interactionSource, Boolean.valueOf(hasLongClick), Boolean.valueOf(hasDoubleClick), Boolean.valueOf(enabled)};
                Object[] keys$iv2 = {centreOffset2, Boolean.valueOf(hasDoubleClick), Boolean.valueOf(enabled), onDoubleClickState, Boolean.valueOf(hasLongClick), onLongClickState, interactionSource, pressedInteraction, delayPressInteraction2, onClickState};
                boolean z2 = enabled;
                MutableInteractionSource mutableInteractionSource22 = interactionSource;
                $composer.startReplaceableGroup(-568225417);
                ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
                invalid$iv = false;
                while (r14 < r13) {
                }
                it$iv$iv2 = $composer.rememberedValue();
                if (!invalid$iv) {
                    value$iv$iv6 = it$iv$iv2;
                    $composer.endReplaceableGroup();
                    Modifier gesture22 = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion3, objArr2, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv6);
                    Modifier.Companion companion222 = Modifier.INSTANCE;
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv3 = $composer.rememberedValue();
                    if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer.endReplaceableGroup();
                    Modifier then22 = companion222.then((Modifier) value$iv$iv7);
                    MutableInteractionSource mutableInteractionSource322 = interactionSource;
                    Indication indication222 = indication;
                    $composer.startReplaceableGroup(773894976);
                    ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                    $composer.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                    it$iv$iv$iv = $composer.rememberedValue();
                    if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                    }
                    $composer.endReplaceableGroup();
                    CompositionScopedCoroutineScopeCanceller wrapper$iv22 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                    CoroutineScope coroutineScope22 = wrapper$iv22.getCoroutineScope();
                    $composer.endReplaceableGroup();
                    Modifier m519genericClickableWithoutGesturebdNGguI22 = ClickableKt.m519genericClickableWithoutGesturebdNGguI(then22, gesture22, mutableInteractionSource322, indication222, coroutineScope22, currentKeyPressInteractions, centreOffset2, enabled, onClickLabel, role, onLongClickLabel, function0, onClick);
                    if (ComposerKt.isTraceInProgress()) {
                    }
                    $composer.endReplaceableGroup();
                    return m519genericClickableWithoutGesturebdNGguI22;
                }
                value$iv$iv6 = new ClickableKt$combinedClickable$4$gesture$1$1(centreOffset2, hasDoubleClick, z2, hasLongClick, onDoubleClickState, onLongClickState, mutableInteractionSource22, pressedInteraction, delayPressInteraction2, onClickState, null);
                $composer.updateRememberedValue(value$iv$iv6);
                $composer.endReplaceableGroup();
                Modifier gesture222 = SuspendingPointerInputFilterKt.pointerInput((Modifier) companion3, objArr2, (Function2<? super PointerInputScope, ? super Continuation<? super Unit>, ? extends Object>) value$iv$iv6);
                Modifier.Companion companion2222 = Modifier.INSTANCE;
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                it$iv$iv3 = $composer.rememberedValue();
                if (it$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                }
                $composer.endReplaceableGroup();
                Modifier then222 = companion2222.then((Modifier) value$iv$iv7);
                MutableInteractionSource mutableInteractionSource3222 = interactionSource;
                Indication indication2222 = indication;
                $composer.startReplaceableGroup(773894976);
                ComposerKt.sourceInformation($composer, "C(rememberCoroutineScope)476@19869L144:Effects.kt#9igjgp");
                $composer.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer, "C(remember):Composables.kt#9igjgp");
                it$iv$iv$iv = $composer.rememberedValue();
                if (it$iv$iv$iv != Composer.INSTANCE.getEmpty()) {
                }
                $composer.endReplaceableGroup();
                CompositionScopedCoroutineScopeCanceller wrapper$iv222 = (CompositionScopedCoroutineScopeCanceller) value$iv$iv$iv;
                CoroutineScope coroutineScope222 = wrapper$iv222.getCoroutineScope();
                $composer.endReplaceableGroup();
                Modifier m519genericClickableWithoutGesturebdNGguI222 = ClickableKt.m519genericClickableWithoutGesturebdNGguI(then222, gesture222, mutableInteractionSource3222, indication2222, coroutineScope222, currentKeyPressInteractions, centreOffset2, enabled, onClickLabel, role, onLongClickLabel, function0, onClick);
                if (ComposerKt.isTraceInProgress()) {
                }
                $composer.endReplaceableGroup();
                return m519genericClickableWithoutGesturebdNGguI222;
            }
        });
    }

    public static final void PressedInteractionSourceDisposableEffect(final MutableInteractionSource interactionSource, final MutableState<PressInteraction.Press> pressedInteraction, final Map<Key, PressInteraction.Press> currentKeyPressInteractions, Composer $composer, final int $changed) {
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(pressedInteraction, "pressedInteraction");
        Intrinsics.checkNotNullParameter(currentKeyPressInteractions, "currentKeyPressInteractions");
        Composer $composer2 = $composer.startRestartGroup(1297229208);
        ComposerKt.sourceInformation($composer2, "C(PressedInteractionSourceDisposableEffect)P(1,2)414@17663L504:Clickable.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1297229208, $changed, -1, "androidx.compose.foundation.PressedInteractionSourceDisposableEffect (Clickable.kt:409)");
        }
        EffectsKt.DisposableEffect(interactionSource, new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final MutableState<PressInteraction.Press> mutableState = pressedInteraction;
                final Map<Key, PressInteraction.Press> map = currentKeyPressInteractions;
                final MutableInteractionSource mutableInteractionSource = interactionSource;
                return new DisposableEffectResult() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$1$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        PressInteraction.Press oldValue = (PressInteraction.Press) MutableState.this.getValue();
                        if (oldValue != null) {
                            PressInteraction.Cancel interaction = new PressInteraction.Cancel(oldValue);
                            mutableInteractionSource.tryEmit(interaction);
                            MutableState.this.setValue(null);
                        }
                        Iterable $this$forEach$iv = map.values();
                        for (Object element$iv : $this$forEach$iv) {
                            PressInteraction.Press it = (PressInteraction.Press) element$iv;
                            mutableInteractionSource.tryEmit(new PressInteraction.Cancel(it));
                        }
                        map.clear();
                    }
                };
            }
        }, $composer2, $changed & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.foundation.ClickableKt$PressedInteractionSourceDisposableEffect$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                ClickableKt.PressedInteractionSourceDisposableEffect(MutableInteractionSource.this, pressedInteraction, currentKeyPressInteractions, composer, $changed | 1);
            }
        });
    }

    /* renamed from: handlePressInteraction-EPk0efs, reason: not valid java name */
    public static final Object m521handlePressInteractionEPk0efs(PressGestureScope $this$handlePressInteraction_u2dEPk0efs, long pressPoint, MutableInteractionSource interactionSource, MutableState<PressInteraction.Press> mutableState, State<? extends Function0<Boolean>> state, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new ClickableKt$handlePressInteraction$2($this$handlePressInteraction_u2dEPk0efs, pressPoint, interactionSource, mutableState, state, null), continuation);
        return coroutineScope == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    private static final Modifier genericClickableWithoutGesture_bdNGguI$clickSemantics(Modifier $this$genericClickableWithoutGesture_bdNGguI_u24clickSemantics, final Role $role, final String $onClickLabel, final Function0<Unit> function0, final String $onLongClickLabel, final boolean $enabled, final Function0<Unit> function02) {
        return SemanticsModifierKt.semantics($this$genericClickableWithoutGesture_bdNGguI_u24clickSemantics, true, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semantics) {
                Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
                if (Role.this != null) {
                    SemanticsPropertiesKt.m3845setRolekuIjeqM(semantics, Role.this.getValue());
                }
                String str = $onClickLabel;
                final Function0<Unit> function03 = function02;
                SemanticsPropertiesKt.onClick(semantics, str, new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final Boolean invoke() {
                        function03.invoke();
                        return true;
                    }
                });
                if (function0 != null) {
                    String str2 = $onLongClickLabel;
                    final Function0<Unit> function04 = function0;
                    SemanticsPropertiesKt.onLongClick(semantics, str2, new Function0<Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$clickSemantics$1.2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        /* JADX WARN: Can't rename method to resolve collision */
                        @Override // kotlin.jvm.functions.Function0
                        public final Boolean invoke() {
                            function04.invoke();
                            return true;
                        }
                    });
                }
                if (!$enabled) {
                    SemanticsPropertiesKt.disabled(semantics);
                }
            }
        });
    }

    /* renamed from: genericClickableWithoutGesture_bdNGguI$detectPressAndClickFromKey */
    private static final Modifier m6x602ad71b(Modifier $this$genericClickableWithoutGesture_bdNGguI_u24detectPressAndClickFromKey, final boolean $enabled, final Map<Key, PressInteraction.Press> map, final State<Offset> state, final CoroutineScope $indicationScope, final Function0<Unit> function0, final MutableInteractionSource $interactionSource) {
        return KeyInputModifierKt.onKeyEvent($this$genericClickableWithoutGesture_bdNGguI_u24detectPressAndClickFromKey, new Function1<KeyEvent, Boolean>() { // from class: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
                return m528invokeZmokQxo(keyEvent.m3219unboximpl());
            }

            /* renamed from: invoke-ZmokQxo, reason: not valid java name */
            public final Boolean m528invokeZmokQxo(android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
                boolean z = true;
                if ($enabled && Clickable_androidKt.m531isPressZmokQxo(keyEvent)) {
                    if (!map.containsKey(Key.m2632boximpl(KeyEvent_androidKt.m3230getKeyZmokQxo(keyEvent)))) {
                        PressInteraction.Press press = new PressInteraction.Press(state.getValue().getPackedValue(), null);
                        map.put(Key.m2632boximpl(KeyEvent_androidKt.m3230getKeyZmokQxo(keyEvent)), press);
                        BuildersKt__Builders_commonKt.launch$default($indicationScope, null, null, new AnonymousClass1($interactionSource, press, null), 3, null);
                    } else {
                        z = false;
                    }
                } else if ($enabled && Clickable_androidKt.m529isClickZmokQxo(keyEvent)) {
                    PressInteraction.Press it = map.remove(Key.m2632boximpl(KeyEvent_androidKt.m3230getKeyZmokQxo(keyEvent)));
                    if (it != null) {
                        BuildersKt__Builders_commonKt.launch$default($indicationScope, null, null, new C0073x8f00ca0b($interactionSource, it, null), 3, null);
                    }
                    function0.invoke();
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }

            /* compiled from: Clickable.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1", m297f = "Clickable.kt", m298i = {}, m299l = {540}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.foundation.ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1$1, reason: invalid class name */
            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ MutableInteractionSource $interactionSource;
                final /* synthetic */ PressInteraction.Press $press;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass1(MutableInteractionSource mutableInteractionSource, PressInteraction.Press press, Continuation<? super AnonymousClass1> continuation) {
                    super(2, continuation);
                    this.$interactionSource = mutableInteractionSource;
                    this.$press = press;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new AnonymousClass1(this.$interactionSource, this.$press, continuation);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            this.label = 1;
                            if (this.$interactionSource.emit(this.$press, this) != coroutine_suspended) {
                                break;
                            } else {
                                return coroutine_suspended;
                            }
                        case 1:
                            ResultKt.throwOnFailure($result);
                            break;
                        default:
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    return Unit.INSTANCE;
                }
            }
        });
    }

    /* renamed from: genericClickableWithoutGesture-bdNGguI, reason: not valid java name */
    public static final Modifier m519genericClickableWithoutGesturebdNGguI(Modifier genericClickableWithoutGesture, Modifier gestureModifiers, MutableInteractionSource interactionSource, Indication indication, CoroutineScope indicationScope, Map<Key, PressInteraction.Press> currentKeyPressInteractions, State<Offset> keyClickOffset, boolean enabled, String onClickLabel, Role role, String onLongClickLabel, Function0<Unit> function0, Function0<Unit> onClick) {
        Intrinsics.checkNotNullParameter(genericClickableWithoutGesture, "$this$genericClickableWithoutGesture");
        Intrinsics.checkNotNullParameter(gestureModifiers, "gestureModifiers");
        Intrinsics.checkNotNullParameter(interactionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(indicationScope, "indicationScope");
        Intrinsics.checkNotNullParameter(currentKeyPressInteractions, "currentKeyPressInteractions");
        Intrinsics.checkNotNullParameter(keyClickOffset, "keyClickOffset");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        return FocusableKt.focusableInNonTouchMode(HoverableKt.hoverable(IndicationKt.indication(m6x602ad71b(genericClickableWithoutGesture_bdNGguI$clickSemantics(genericClickableWithoutGesture, role, onClickLabel, function0, onLongClickLabel, enabled, onClick), enabled, currentKeyPressInteractions, keyClickOffset, indicationScope, onClick, interactionSource), interactionSource, indication), interactionSource, enabled), enabled, interactionSource).then(gestureModifiers);
    }
}
