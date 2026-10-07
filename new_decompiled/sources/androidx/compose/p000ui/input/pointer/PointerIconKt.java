package androidx.compose.p000ui.input.pointer;

import androidx.compose.p000ui.ComposedModifierKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PointerIcon.kt */
@Metadata(m286d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, m287d2 = {"pointerHoverIcon", "Landroidx/compose/ui/Modifier;", "icon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "overrideDescendants", "", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PointerIconKt {
    public static /* synthetic */ Modifier pointerHoverIcon$default(Modifier modifier, PointerIcon pointerIcon, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pointerHoverIcon(modifier, pointerIcon, z);
    }

    public static final Modifier pointerHoverIcon(Modifier $this$pointerHoverIcon, final PointerIcon icon, final boolean overrideDescendants) {
        Intrinsics.checkNotNullParameter($this$pointerHoverIcon, "<this>");
        Intrinsics.checkNotNullParameter(icon, "icon");
        return ComposedModifierKt.composed($this$pointerHoverIcon, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$$inlined$debugInspectorInfo$1
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
                $this$null.setName("pointerHoverIcon");
                $this$null.getProperties().set("icon", PointerIcon.this);
                $this$null.getProperties().set("overrideDescendants", Boolean.valueOf(overrideDescendants));
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3<Modifier, Composer, Integer, Modifier>() { // from class: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
                return invoke(modifier, composer, num.intValue());
            }

            public final Modifier invoke(Modifier composed, Composer $composer, int $changed) {
                Modifier.Companion pointerInput;
                Intrinsics.checkNotNullParameter(composed, "$this$composed");
                $composer.startReplaceableGroup(811087536);
                ComposerKt.sourceInformation($composer, "C68@2293L7:PointerIcon.kt#a556rk");
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(811087536, $changed, -1, "androidx.compose.ui.input.pointer.pointerHoverIcon.<anonymous> (PointerIcon.kt:67)");
                }
                ProvidableCompositionLocal<PointerIconService> localPointerIconService = CompositionLocalsKt.getLocalPointerIconService();
                ComposerKt.sourceInformationMarkerStart($composer, 2023513938, "C:CompositionLocal.kt#9igjgp");
                Object consume = $composer.consume(localPointerIconService);
                ComposerKt.sourceInformationMarkerEnd($composer);
                PointerIconService pointerIconService = (PointerIconService) consume;
                if (pointerIconService == null) {
                    pointerInput = Modifier.INSTANCE;
                } else {
                    pointerInput = SuspendingPointerInputFilterKt.pointerInput(composed, PointerIcon.this, Boolean.valueOf(overrideDescendants), new C04231(overrideDescendants, pointerIconService, PointerIcon.this, null));
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                $composer.endReplaceableGroup();
                return pointerInput;
            }

            /* compiled from: PointerIcon.kt */
            @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
            @DebugMetadata(m296c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1", m297f = "PointerIcon.kt", m298i = {}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_SWIMMING_POOL}, m300m = "invokeSuspend", m301n = {}, m302s = {})
            /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1 */
            static final class C04231 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
                final /* synthetic */ PointerIcon $icon;
                final /* synthetic */ boolean $overrideDescendants;
                final /* synthetic */ PointerIconService $pointerIconService;
                private /* synthetic */ Object L$0;
                int label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C04231(boolean z, PointerIconService pointerIconService, PointerIcon pointerIcon, Continuation<? super C04231> continuation) {
                    super(2, continuation);
                    this.$overrideDescendants = z;
                    this.$pointerIconService = pointerIconService;
                    this.$icon = pointerIcon;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C04231 c04231 = new C04231(this.$overrideDescendants, this.$pointerIconService, this.$icon, continuation);
                    c04231.L$0 = obj;
                    return c04231;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(PointerInputScope pointerInputScope, Continuation<? super Unit> continuation) {
                    return ((C04231) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                }

                /* compiled from: PointerIcon.kt */
                @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1", m297f = "PointerIcon.kt", m298i = {0}, m299l = {ExerciseSessionRecord.EXERCISE_TYPE_WATER_POLO}, m300m = "invokeSuspend", m301n = {"$this$awaitPointerEventScope"}, m302s = {"L$0"})
                /* renamed from: androidx.compose.ui.input.pointer.PointerIconKt$pointerHoverIcon$2$1$1, reason: invalid class name */
                static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
                    final /* synthetic */ PointerIcon $icon;
                    final /* synthetic */ boolean $overrideDescendants;
                    final /* synthetic */ PointerIconService $pointerIconService;
                    private /* synthetic */ Object L$0;
                    int label;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    AnonymousClass1(boolean z, PointerIconService pointerIconService, PointerIcon pointerIcon, Continuation<? super AnonymousClass1> continuation) {
                        super(2, continuation);
                        this.$overrideDescendants = z;
                        this.$pointerIconService = pointerIconService;
                        this.$icon = pointerIcon;
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                        AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$overrideDescendants, this.$pointerIconService, this.$icon, continuation);
                        anonymousClass1.L$0 = obj;
                        return anonymousClass1;
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(AwaitPointerEventScope awaitPointerEventScope, Continuation<? super Unit> continuation) {
                        return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
                    }

                    /* JADX WARN: Removed duplicated region for block: B:19:0x002d  */
                    /* JADX WARN: Removed duplicated region for block: B:22:0x0040 A[RETURN] */
                    /* JADX WARN: Removed duplicated region for block: B:23:0x0041  */
                    /* JADX WARN: Removed duplicated region for block: B:24:0x0030  */
                    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0041 -> B:7:0x0047). Please report as a decompilation issue!!! */
                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public final Object invokeSuspend(Object $result) {
                        AnonymousClass1 anonymousClass1;
                        AwaitPointerEventScope $this$awaitPointerEventScope;
                        Object awaitPointerEvent;
                        Object $result2;
                        AwaitPointerEventScope $this$awaitPointerEventScope2;
                        AnonymousClass1 anonymousClass12;
                        Object obj;
                        PointerEvent event;
                        boolean z;
                        Object $result3 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                        switch (this.label) {
                            case 0:
                                ResultKt.throwOnFailure($result);
                                anonymousClass1 = this;
                                $this$awaitPointerEventScope = (AwaitPointerEventScope) anonymousClass1.L$0;
                                PointerEventPass pass = anonymousClass1.$overrideDescendants ? PointerEventPass.Main : PointerEventPass.Initial;
                                anonymousClass1.L$0 = $this$awaitPointerEventScope;
                                anonymousClass1.label = 1;
                                awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(pass, anonymousClass1);
                                if (awaitPointerEvent == $result3) {
                                    return $result3;
                                }
                                Object obj2 = $result3;
                                $result2 = $result;
                                $result = awaitPointerEvent;
                                $this$awaitPointerEventScope2 = $this$awaitPointerEventScope;
                                anonymousClass12 = anonymousClass1;
                                obj = obj2;
                                event = (PointerEvent) $result;
                                z = false;
                                if (PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3324getRelease7fucELk()) && PointerEventKt.m3312isOutOfBoundsjwHxaWs(event.getChanges().get(0), $this$awaitPointerEventScope2.mo3280getSizeYbymL2g(), Size.INSTANCE.m1838getZeroNHjbRc())) {
                                    z = true;
                                }
                                boolean isOutsideRelease = z;
                                if (!PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3321getExit7fucELk()) && !isOutsideRelease) {
                                    anonymousClass12.$pointerIconService.setCurrent(anonymousClass12.$icon);
                                }
                                $result = $result2;
                                $result3 = obj;
                                anonymousClass1 = anonymousClass12;
                                $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                                if (anonymousClass1.$overrideDescendants) {
                                }
                                anonymousClass1.L$0 = $this$awaitPointerEventScope;
                                anonymousClass1.label = 1;
                                awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(pass, anonymousClass1);
                                if (awaitPointerEvent == $result3) {
                                }
                                break;
                            case 1:
                                AwaitPointerEventScope $this$awaitPointerEventScope3 = (AwaitPointerEventScope) this.L$0;
                                ResultKt.throwOnFailure($result);
                                $this$awaitPointerEventScope2 = $this$awaitPointerEventScope3;
                                anonymousClass12 = this;
                                obj = $result3;
                                $result2 = $result;
                                event = (PointerEvent) $result;
                                z = false;
                                if (PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3324getRelease7fucELk())) {
                                    z = true;
                                    break;
                                }
                                boolean isOutsideRelease2 = z;
                                if (!PointerEventType.m3316equalsimpl0(event.getType(), PointerEventType.INSTANCE.m3321getExit7fucELk())) {
                                    anonymousClass12.$pointerIconService.setCurrent(anonymousClass12.$icon);
                                }
                                $result = $result2;
                                $result3 = obj;
                                anonymousClass1 = anonymousClass12;
                                $this$awaitPointerEventScope = $this$awaitPointerEventScope2;
                                if (anonymousClass1.$overrideDescendants) {
                                }
                                anonymousClass1.L$0 = $this$awaitPointerEventScope;
                                anonymousClass1.label = 1;
                                awaitPointerEvent = $this$awaitPointerEventScope.awaitPointerEvent(pass, anonymousClass1);
                                if (awaitPointerEvent == $result3) {
                                }
                                break;
                            default:
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                    }
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object $result) {
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (this.label) {
                        case 0:
                            ResultKt.throwOnFailure($result);
                            PointerInputScope $this$pointerInput = (PointerInputScope) this.L$0;
                            this.label = 1;
                            if ($this$pointerInput.awaitPointerEventScope(new AnonymousClass1(this.$overrideDescendants, this.$pointerIconService, this.$icon, null), this) != coroutine_suspended) {
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
}
