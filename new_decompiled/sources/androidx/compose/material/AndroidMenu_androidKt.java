package androidx.compose.material;

import androidx.compose.animation.core.MutableTransitionState;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.TransformOrigin;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.unit.C0504Dp;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DpKt;
import androidx.compose.p000ui.unit.IntRect;
import androidx.compose.p000ui.window.AndroidPopup_androidKt;
import androidx.compose.p000ui.window.PopupProperties;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.health.platform.client.SdkConfig;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AndroidMenu.android.kt */
@Metadata(m286d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ag\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001aa\u0010\u0013\u001a\u00020\u00012\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001c"}, m287d2 = {"DropdownMenu", "", "expanded", "", "onDismissRequest", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "offset", "Landroidx/compose/ui/unit/DpOffset;", "properties", "Landroidx/compose/ui/window/PopupProperties;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "DropdownMenu-ILWXrKs", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;JLandroidx/compose/ui/window/PopupProperties;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItem", "onClick", "enabled", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "material_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class AndroidMenu_androidKt {
    /* JADX WARN: Removed duplicated region for block: B:32:0x02c9  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x014c  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0122  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0108  */
    /* renamed from: DropdownMenu-ILWXrKs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void m1224DropdownMenuILWXrKs(final boolean expanded, final Function0<Unit> onDismissRequest, Modifier modifier, long offset, PopupProperties properties, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        long offset2;
        PopupProperties popupProperties;
        PopupProperties properties2;
        long offset3;
        int $dirty;
        Modifier modifier3;
        Object it$iv$iv;
        Object value$iv$iv;
        final MutableTransitionState expandedStates;
        Object value$iv$iv2;
        boolean invalid$iv$iv;
        Modifier modifier4;
        long offset4;
        PopupProperties properties3;
        Modifier modifier5;
        ScopeUpdateScope endRestartGroup;
        int i2;
        int i3;
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-840283139);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenu)P(1,4,2,3:c#ui.unit.DpOffset,5)81@4099L42,85@4289L51,86@4376L7,90@4500L131,94@4641L400:AndroidMenu.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(expanded) ? 4 : 2;
        }
        if ((i & 2) != 0) {
            $dirty2 |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty2 |= $composer2.changed(onDismissRequest) ? 32 : 16;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            modifier2 = modifier;
        } else if (($changed & 896) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 256 : 128;
        } else {
            modifier2 = modifier;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            offset2 = offset;
        } else if (($changed & 7168) == 0) {
            offset2 = offset;
            $dirty2 |= $composer2.changed(offset2) ? 2048 : 1024;
        } else {
            offset2 = offset;
        }
        if ((57344 & $changed) == 0) {
            if ((i & 16) == 0) {
                popupProperties = properties;
                if ($composer2.changed(popupProperties)) {
                    i3 = 16384;
                    $dirty2 |= i3;
                }
            } else {
                popupProperties = properties;
            }
            i3 = 8192;
            $dirty2 |= i3;
        } else {
            popupProperties = properties;
        }
        if ((i & 32) == 0) {
            i2 = (458752 & $changed) == 0 ? $composer2.changed(content) ? 131072 : 65536 : 196608;
            if ((374491 & $dirty2) == 74898 || !$composer2.getSkipping()) {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    Modifier.Companion modifier6 = i4 == 0 ? Modifier.INSTANCE : modifier2;
                    if (i5 != 0) {
                        offset2 = DpKt.m4403DpOffsetYgX7TsA(C0504Dp.m4382constructorimpl(0), C0504Dp.m4382constructorimpl(0));
                    }
                    if ((i & 16) == 0) {
                        properties2 = new PopupProperties(true, false, false, null, false, false, 62, null);
                        offset3 = offset2;
                        $dirty = $dirty2 & (-57345);
                        modifier3 = modifier6;
                    } else {
                        properties2 = popupProperties;
                        offset3 = offset2;
                        $dirty = $dirty2;
                        modifier3 = modifier6;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if ((i & 16) != 0) {
                        $dirty2 &= -57345;
                    }
                    properties2 = popupProperties;
                    offset3 = offset2;
                    $dirty = $dirty2;
                    modifier3 = modifier2;
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-840283139, $dirty, -1, "androidx.compose.material.DropdownMenu (AndroidMenu.android.kt:73)");
                }
                $composer2.startReplaceableGroup(-492369756);
                ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                it$iv$iv = $composer2.rememberedValue();
                if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
                    value$iv$iv = new MutableTransitionState(false);
                    $composer2.updateRememberedValue(value$iv$iv);
                } else {
                    value$iv$iv = it$iv$iv;
                }
                $composer2.endReplaceableGroup();
                expandedStates = (MutableTransitionState) value$iv$iv;
                expandedStates.setTargetState(Boolean.valueOf(expanded));
                if (!((Boolean) expandedStates.getCurrentState()).booleanValue() || ((Boolean) expandedStates.getTargetState()).booleanValue()) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    value$iv$iv2 = $composer2.rememberedValue();
                    if (value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
                        value$iv$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TransformOrigin.m2325boximpl(TransformOrigin.INSTANCE.m2338getCenterSzJe1aQ()), null, 2, null);
                        $composer2.updateRememberedValue(value$iv$iv2);
                    }
                    $composer2.endReplaceableGroup();
                    final MutableState transformOriginState = (MutableState) value$iv$iv2;
                    ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
                    ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
                    Object consume = $composer2.consume(localDensity);
                    ComposerKt.sourceInformationMarkerEnd($composer2);
                    Density density = (Density) consume;
                    $composer2.startReplaceableGroup(1157296644);
                    ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
                    invalid$iv$iv = $composer2.changed(transformOriginState);
                    Object value$iv$iv3 = $composer2.rememberedValue();
                    if (!invalid$iv$iv && value$iv$iv3 != Composer.INSTANCE.getEmpty()) {
                        $composer2.endReplaceableGroup();
                        final int $dirty3 = $dirty;
                        DropdownMenuPositionProvider popupPositionProvider = new DropdownMenuPositionProvider(offset3, density, (Function2) value$iv$iv3, null);
                        final Modifier modifier7 = modifier3;
                        modifier4 = modifier3;
                        AndroidPopup_androidKt.Popup(popupPositionProvider, onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, 79632374, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                                invoke(composer, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer $composer3, int $changed2) {
                                ComposerKt.sourceInformation($composer3, "C99@4816L215:AndroidMenu.android.kt#jmzs0o");
                                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(79632374, $changed2, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
                                    }
                                    MenuKt.DropdownMenuContent(expandedStates, transformOriginState, modifier7, content, $composer3, MutableTransitionState.$stable | 48 | ($dirty3 & 896) | (($dirty3 >> 6) & 7168), 0);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                $composer3.skipToGroupEnd();
                            }
                        }), $composer2, ($dirty3 & SdkConfig.SDK_VERSION) | 3072 | (($dirty3 >> 6) & 896), 0);
                    }
                    value$iv$iv3 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                            invoke2(intRect, intRect2);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(IntRect parentBounds, IntRect menuBounds) {
                            Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
                            Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
                            transformOriginState.setValue(TransformOrigin.m2325boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
                        }
                    };
                    $composer2.updateRememberedValue(value$iv$iv3);
                    $composer2.endReplaceableGroup();
                    final int $dirty32 = $dirty;
                    DropdownMenuPositionProvider popupPositionProvider2 = new DropdownMenuPositionProvider(offset3, density, (Function2) value$iv$iv3, null);
                    final Modifier modifier72 = modifier3;
                    modifier4 = modifier3;
                    AndroidPopup_androidKt.Popup(popupPositionProvider2, onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, 79632374, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                            invoke(composer, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer $composer3, int $changed2) {
                            ComposerKt.sourceInformation($composer3, "C99@4816L215:AndroidMenu.android.kt#jmzs0o");
                            if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(79632374, $changed2, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
                                }
                                MenuKt.DropdownMenuContent(expandedStates, transformOriginState, modifier72, content, $composer3, MutableTransitionState.$stable | 48 | ($dirty32 & 896) | (($dirty32 >> 6) & 7168), 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                    return;
                                }
                                return;
                            }
                            $composer3.skipToGroupEnd();
                        }
                    }), $composer2, ($dirty32 & SdkConfig.SDK_VERSION) | 3072 | (($dirty32 >> 6) & 896), 0);
                } else {
                    modifier4 = modifier3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                offset4 = offset3;
                properties3 = properties2;
                modifier5 = modifier4;
            } else {
                $composer2.skipToGroupEnd();
                modifier5 = modifier2;
                offset4 = offset2;
                properties3 = popupProperties;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
                return;
            }
            final Modifier modifier8 = modifier5;
            final long j = offset4;
            final PopupProperties popupProperties2 = properties3;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i6) {
                    AndroidMenu_androidKt.m1224DropdownMenuILWXrKs(expanded, onDismissRequest, modifier8, j, popupProperties2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        if ((374491 & $dirty2) == 74898) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i4 == 0) {
        }
        if (i5 != 0) {
        }
        if ((i & 16) == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        it$iv$iv = $composer2.rememberedValue();
        if (it$iv$iv != Composer.INSTANCE.getEmpty()) {
        }
        $composer2.endReplaceableGroup();
        expandedStates = (MutableTransitionState) value$iv$iv;
        expandedStates.setTargetState(Boolean.valueOf(expanded));
        if (((Boolean) expandedStates.getCurrentState()).booleanValue()) {
        }
        $composer2.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
        value$iv$iv2 = $composer2.rememberedValue();
        if (value$iv$iv2 != Composer.INSTANCE.getEmpty()) {
        }
        $composer2.endReplaceableGroup();
        final MutableState<TransformOrigin> transformOriginState2 = (MutableState) value$iv$iv2;
        ProvidableCompositionLocal<Density> localDensity2 = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume2 = $composer2.consume(localDensity2);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Density density2 = (Density) consume2;
        $composer2.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation($composer2, "C(remember)P(1):Composables.kt#9igjgp");
        invalid$iv$iv = $composer2.changed(transformOriginState2);
        Object value$iv$iv32 = $composer2.rememberedValue();
        if (!invalid$iv$iv) {
            $composer2.endReplaceableGroup();
            final int $dirty322 = $dirty;
            DropdownMenuPositionProvider popupPositionProvider22 = new DropdownMenuPositionProvider(offset3, density2, (Function2) value$iv$iv32, null);
            final Modifier modifier722 = modifier3;
            modifier4 = modifier3;
            AndroidPopup_androidKt.Popup(popupPositionProvider22, onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, 79632374, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer $composer3, int $changed2) {
                    ComposerKt.sourceInformation($composer3, "C99@4816L215:AndroidMenu.android.kt#jmzs0o");
                    if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(79632374, $changed2, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
                        }
                        MenuKt.DropdownMenuContent(expandedStates, transformOriginState2, modifier722, content, $composer3, MutableTransitionState.$stable | 48 | ($dirty322 & 896) | (($dirty322 >> 6) & 7168), 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    $composer3.skipToGroupEnd();
                }
            }), $composer2, ($dirty322 & SdkConfig.SDK_VERSION) | 3072 | (($dirty322 >> 6) & 896), 0);
            if (ComposerKt.isTraceInProgress()) {
            }
            offset4 = offset3;
            properties3 = properties2;
            modifier5 = modifier4;
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup == null) {
            }
        }
        value$iv$iv32 = (Function2) new Function2<IntRect, IntRect, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$popupPositionProvider$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(IntRect intRect, IntRect intRect2) {
                invoke2(intRect, intRect2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(IntRect parentBounds, IntRect menuBounds) {
                Intrinsics.checkNotNullParameter(parentBounds, "parentBounds");
                Intrinsics.checkNotNullParameter(menuBounds, "menuBounds");
                transformOriginState2.setValue(TransformOrigin.m2325boximpl(MenuKt.calculateTransformOrigin(parentBounds, menuBounds)));
            }
        };
        $composer2.updateRememberedValue(value$iv$iv32);
        $composer2.endReplaceableGroup();
        final int $dirty3222 = $dirty;
        DropdownMenuPositionProvider popupPositionProvider222 = new DropdownMenuPositionProvider(offset3, density2, (Function2) value$iv$iv32, null);
        final Modifier modifier7222 = modifier3;
        modifier4 = modifier3;
        AndroidPopup_androidKt.Popup(popupPositionProvider222, onDismissRequest, properties2, ComposableLambdaKt.composableLambda($composer2, 79632374, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenu$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer $composer3, int $changed2) {
                ComposerKt.sourceInformation($composer3, "C99@4816L215:AndroidMenu.android.kt#jmzs0o");
                if (($changed2 & 11) != 2 || !$composer3.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(79632374, $changed2, -1, "androidx.compose.material.DropdownMenu.<anonymous> (AndroidMenu.android.kt:98)");
                    }
                    MenuKt.DropdownMenuContent(expandedStates, transformOriginState2, modifier7222, content, $composer3, MutableTransitionState.$stable | 48 | ($dirty3222 & 896) | (($dirty3222 >> 6) & 7168), 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                $composer3.skipToGroupEnd();
            }
        }), $composer2, ($dirty3222 & SdkConfig.SDK_VERSION) | 3072 | (($dirty3222 >> 6) & 896), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        offset4 = offset3;
        properties3 = properties2;
        modifier5 = modifier4;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0107  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x013e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ef  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void DropdownMenuItem(final Function0<Unit> onClick, Modifier modifier, boolean enabled, PaddingValues contentPadding, MutableInteractionSource interactionSource, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        Modifier modifier2;
        boolean z;
        PaddingValues paddingValues;
        MutableInteractionSource interactionSource2;
        int $dirty;
        Modifier modifier3;
        boolean enabled2;
        PaddingValues contentPadding2;
        Object value$iv$iv;
        ScopeUpdateScope endRestartGroup;
        int i2;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-1988562892);
        ComposerKt.sourceInformation($composer2, "C(DropdownMenuItem)P(5,4,2,1,3)132@6224L39,135@6318L227:AndroidMenu.android.kt#jmzs0o");
        int $dirty2 = $changed;
        if ((i & 1) != 0) {
            $dirty2 |= 6;
        } else if (($changed & 14) == 0) {
            $dirty2 |= $composer2.changed(onClick) ? 4 : 2;
        }
        int i3 = i & 2;
        if (i3 != 0) {
            $dirty2 |= 48;
            modifier2 = modifier;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            modifier2 = modifier;
            $dirty2 |= $composer2.changed(modifier2) ? 32 : 16;
        } else {
            modifier2 = modifier;
        }
        int i4 = i & 4;
        if (i4 != 0) {
            $dirty2 |= 384;
            z = enabled;
        } else if (($changed & 896) == 0) {
            z = enabled;
            $dirty2 |= $composer2.changed(z) ? 256 : 128;
        } else {
            z = enabled;
        }
        int i5 = i & 8;
        if (i5 != 0) {
            $dirty2 |= 3072;
            paddingValues = contentPadding;
        } else if (($changed & 7168) == 0) {
            paddingValues = contentPadding;
            $dirty2 |= $composer2.changed(paddingValues) ? 2048 : 1024;
        } else {
            paddingValues = contentPadding;
        }
        int i6 = i & 16;
        if (i6 != 0) {
            $dirty2 |= 24576;
            interactionSource2 = interactionSource;
        } else if (($changed & 57344) == 0) {
            interactionSource2 = interactionSource;
            $dirty2 |= $composer2.changed(interactionSource2) ? 16384 : 8192;
        } else {
            interactionSource2 = interactionSource;
        }
        if ((i & 32) == 0) {
            i2 = ($changed & 458752) == 0 ? $composer2.changed(content) ? 131072 : 65536 : 196608;
            $dirty = $dirty2;
            if ((374491 & $dirty) == 74898 || !$composer2.getSkipping()) {
                modifier3 = i3 == 0 ? Modifier.INSTANCE : modifier2;
                enabled2 = i4 == 0 ? true : z;
                contentPadding2 = i5 == 0 ? MenuDefaults.INSTANCE.getDropdownMenuItemContentPadding() : paddingValues;
                if (i6 != 0) {
                    $composer2.startReplaceableGroup(-492369756);
                    ComposerKt.sourceInformation($composer2, "C(remember):Composables.kt#9igjgp");
                    Object it$iv$iv = $composer2.rememberedValue();
                    if (it$iv$iv == Composer.INSTANCE.getEmpty()) {
                        value$iv$iv = InteractionSourceKt.MutableInteractionSource();
                        $composer2.updateRememberedValue(value$iv$iv);
                    } else {
                        value$iv$iv = it$iv$iv;
                    }
                    $composer2.endReplaceableGroup();
                    interactionSource2 = (MutableInteractionSource) value$iv$iv;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1988562892, $dirty, -1, "androidx.compose.material.DropdownMenuItem (AndroidMenu.android.kt:127)");
                }
                MenuKt.DropdownMenuItemContent(onClick, modifier3, enabled2, contentPadding2, interactionSource2, content, $composer2, ($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                $composer2.skipToGroupEnd();
                modifier3 = modifier2;
                enabled2 = z;
                contentPadding2 = paddingValues;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final Modifier modifier4 = modifier3;
            final boolean z2 = enabled2;
            final PaddingValues paddingValues2 = contentPadding2;
            final MutableInteractionSource mutableInteractionSource = interactionSource2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.AndroidMenu_androidKt$DropdownMenuItem$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i7) {
                    AndroidMenu_androidKt.DropdownMenuItem(onClick, modifier4, z2, paddingValues2, mutableInteractionSource, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty2 |= i2;
        $dirty = $dirty2;
        if ((374491 & $dirty) == 74898) {
        }
        if (i3 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 != 0) {
        }
        if (ComposerKt.isTraceInProgress()) {
        }
        MenuKt.DropdownMenuItemContent(onClick, modifier3, enabled2, contentPadding2, interactionSource2, content, $composer2, ($dirty & 14) | ($dirty & SdkConfig.SDK_VERSION) | ($dirty & 896) | ($dirty & 7168) | (57344 & $dirty) | ($dirty & 458752), 0);
        if (ComposerKt.isTraceInProgress()) {
        }
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }
}
