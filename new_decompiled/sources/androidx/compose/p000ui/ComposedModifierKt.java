package androidx.compose.p000ui;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.focus.FocusEventModifier;
import androidx.compose.p000ui.focus.FocusEventModifierLocal;
import androidx.compose.p000ui.focus.FocusRequesterModifier;
import androidx.compose.p000ui.focus.FocusRequesterModifierLocal;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: ComposedModifier.kt */
@Metadata(m286d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\f¢\u0006\u0002\u0010\u000e\u001a\\\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0013\u001af\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0015\u001ap\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u0017\u001aj\u0010\b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00120\u0019\"\u0004\u0018\u00010\u00122\u0019\b\u0002\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\u0001¢\u0006\u0002\b\f2\u001c\u0010\r\u001a\u0018\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004¢\u0006\u0002\b\fH\u0007¢\u0006\u0002\u0010\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u0003*\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0003\"!\u0010\u0000\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"!\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\u0002\b\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u001e"}, m287d2 = {"WrapFocusEventModifier", "Lkotlin/Function1;", "Landroidx/compose/ui/focus/FocusEventModifier;", "Landroidx/compose/ui/Modifier;", "Landroidx/compose/runtime/Composable;", "Lkotlin/jvm/functions/Function3;", "WrapFocusRequesterModifier", "Landroidx/compose/ui/focus/FocusRequesterModifier;", "composed", "inspectorInfo", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "factory", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "fullyQualifiedName", "", "key1", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key2", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "key3", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "keys", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;[Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;)Landroidx/compose/ui/Modifier;", "materialize", "Landroidx/compose/runtime/Composer;", "modifier", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ComposedModifierKt {
    private static final Function3<FocusEventModifier, Composer, Integer, Modifier> WrapFocusEventModifier = new Function3<FocusEventModifier, Composer, Integer, FocusEventModifierLocal>() { // from class: androidx.compose.ui.ComposedModifierKt$WrapFocusEventModifier$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FocusEventModifierLocal invoke(FocusEventModifier focusEventModifier, Composer composer, Integer num) {
            return invoke(focusEventModifier, composer, num.intValue());
        }

        public final FocusEventModifierLocal invoke(FocusEventModifier mod, Composer $composer, int $changed) {
            Object value$iv$iv;
            Object value$iv$iv2;
            Intrinsics.checkNotNullParameter(mod, "mod");
            $composer.startReplaceableGroup(-1790596922);
            ComposerKt.sourceInformation($composer, "C309@13890L72,312@13978L51,312@13967L62:ComposedModifier.kt#quzd79");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1790596922, $changed, -1, "androidx.compose.ui.WrapFocusEventModifier.<anonymous> (ComposedModifier.kt:308)");
            }
            int i = $changed & 14;
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(mod);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new FocusEventModifierLocal(new ComposedModifierKt$WrapFocusEventModifier$1$modifier$1$1(mod));
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            final FocusEventModifierLocal modifier = (FocusEventModifierLocal) value$iv$iv;
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv2 = $composer.changed(modifier);
            Object it$iv$iv2 = $composer.rememberedValue();
            if (invalid$iv$iv2 || it$iv$iv2 == Composer.INSTANCE.getEmpty()) {
                value$iv$iv2 = (Function0) new Function0<Unit>() { // from class: androidx.compose.ui.ComposedModifierKt$WrapFocusEventModifier$1$1$1
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2() {
                        FocusEventModifierLocal.this.notifyIfNoFocusModifiers();
                    }
                };
                $composer.updateRememberedValue(value$iv$iv2);
            } else {
                value$iv$iv2 = it$iv$iv2;
            }
            $composer.endReplaceableGroup();
            EffectsKt.SideEffect((Function0) value$iv$iv2, $composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return modifier;
        }
    };
    private static final Function3<FocusRequesterModifier, Composer, Integer, Modifier> WrapFocusRequesterModifier = new Function3<FocusRequesterModifier, Composer, Integer, FocusRequesterModifierLocal>() { // from class: androidx.compose.ui.ComposedModifierKt$WrapFocusRequesterModifier$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ FocusRequesterModifierLocal invoke(FocusRequesterModifier focusRequesterModifier, Composer composer, Integer num) {
            return invoke(focusRequesterModifier, composer, num.intValue());
        }

        public final FocusRequesterModifierLocal invoke(FocusRequesterModifier mod, Composer $composer, int $changed) {
            Object value$iv$iv;
            Intrinsics.checkNotNullParameter(mod, "mod");
            $composer.startReplaceableGroup(945678692);
            ComposerKt.sourceInformation($composer, "C319@14150L77:ComposedModifier.kt#quzd79");
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(945678692, $changed, -1, "androidx.compose.ui.WrapFocusRequesterModifier.<anonymous> (ComposedModifier.kt:318)");
            }
            int i = $changed & 14;
            $composer.startReplaceableGroup(1157296644);
            ComposerKt.sourceInformation($composer, "C(remember)P(1):Composables.kt#9igjgp");
            boolean invalid$iv$iv = $composer.changed(mod);
            Object it$iv$iv = $composer.rememberedValue();
            if (invalid$iv$iv || it$iv$iv == Composer.INSTANCE.getEmpty()) {
                value$iv$iv = new FocusRequesterModifierLocal(mod.getFocusRequester());
                $composer.updateRememberedValue(value$iv$iv);
            } else {
                value$iv$iv = it$iv$iv;
            }
            $composer.endReplaceableGroup();
            FocusRequesterModifierLocal focusRequesterModifierLocal = (FocusRequesterModifierLocal) value$iv$iv;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            $composer.endReplaceableGroup();
            return focusRequesterModifierLocal;
        }
    };

    public static /* synthetic */ Modifier composed$default(Modifier modifier, Function1 function1, Function3 function3, int i, Object obj) {
        if ((i & 1) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, function1, function3);
    }

    public static final Modifier composed(Modifier $this$composed, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter($this$composed, "<this>");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return $this$composed.then(new ComposedModifier(inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Function1 function1, Function3 function3, int i, Object obj2) {
        if ((i & 4) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, (Function1<? super InspectorInfo, Unit>) function1, (Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier $this$composed, String fullyQualifiedName, Object key1, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter($this$composed, "<this>");
        Intrinsics.checkNotNullParameter(fullyQualifiedName, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return $this$composed.then(new KeyedComposedModifier1(fullyQualifiedName, key1, inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Function1 function1, Function3 function3, int i, Object obj3) {
        Function1 function12;
        if ((i & 8) == 0) {
            function12 = function1;
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, function12, function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier $this$composed, String fullyQualifiedName, Object key1, Object key2, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter($this$composed, "<this>");
        Intrinsics.checkNotNullParameter(fullyQualifiedName, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return $this$composed.then(new KeyedComposedModifier2(fullyQualifiedName, key1, key2, inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object obj, Object obj2, Object obj3, Function1 function1, Function3 function3, int i, Object obj4) {
        Function1 function12;
        if ((i & 16) == 0) {
            function12 = function1;
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, obj, obj2, obj3, function12, function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier $this$composed, String fullyQualifiedName, Object key1, Object key2, Object key3, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter($this$composed, "<this>");
        Intrinsics.checkNotNullParameter(fullyQualifiedName, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return $this$composed.then(new KeyedComposedModifier3(fullyQualifiedName, key1, key2, key3, inspectorInfo, factory));
    }

    public static /* synthetic */ Modifier composed$default(Modifier modifier, String str, Object[] objArr, Function1 function1, Function3 function3, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return composed(modifier, str, objArr, (Function1<? super InspectorInfo, Unit>) function1, (Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier>) function3);
    }

    @ExperimentalComposeUiApi
    public static final Modifier composed(Modifier $this$composed, String fullyQualifiedName, Object[] keys, Function1<? super InspectorInfo, Unit> inspectorInfo, Function3<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        Intrinsics.checkNotNullParameter($this$composed, "<this>");
        Intrinsics.checkNotNullParameter(fullyQualifiedName, "fullyQualifiedName");
        Intrinsics.checkNotNullParameter(keys, "keys");
        Intrinsics.checkNotNullParameter(inspectorInfo, "inspectorInfo");
        Intrinsics.checkNotNullParameter(factory, "factory");
        return $this$composed.then(new KeyedComposedModifierN(fullyQualifiedName, keys, inspectorInfo, factory));
    }

    public static final Modifier materialize(final Composer $this$materialize, Modifier modifier) {
        Intrinsics.checkNotNullParameter($this$materialize, "<this>");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        if (modifier.all(new Function1<Modifier.Element, Boolean>() { // from class: androidx.compose.ui.ComposedModifierKt$materialize$1
            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(Modifier.Element it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(((it instanceof ComposedModifier) || (it instanceof FocusEventModifier) || (it instanceof FocusRequesterModifier)) ? false : true);
            }
        })) {
            return modifier;
        }
        $this$materialize.startReplaceableGroup(1219399079);
        Modifier result = (Modifier) modifier.foldIn(Modifier.INSTANCE, new Function2<Modifier, Modifier.Element, Modifier>() { // from class: androidx.compose.ui.ComposedModifierKt$materialize$result$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Modifier invoke(Modifier acc, Modifier.Element element) {
                Modifier.Element newElement;
                Function3 function3;
                Function3 function32;
                Intrinsics.checkNotNullParameter(acc, "acc");
                Intrinsics.checkNotNullParameter(element, "element");
                if (element instanceof ComposedModifier) {
                    Function3<Modifier, Composer, Integer, Modifier> factory = ((ComposedModifier) element).getFactory();
                    Intrinsics.checkNotNull(factory, "null cannot be cast to non-null type @[ExtensionFunctionType] kotlin.Function3<androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                    Function3 factory2 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(factory, 3);
                    Modifier composedMod = (Modifier) factory2.invoke(Modifier.INSTANCE, Composer.this, 0);
                    newElement = ComposedModifierKt.materialize(Composer.this, composedMod);
                } else {
                    newElement = element;
                    if (element instanceof FocusEventModifier) {
                        function32 = ComposedModifierKt.WrapFocusEventModifier;
                        Intrinsics.checkNotNull(function32, "null cannot be cast to non-null type kotlin.Function3<androidx.compose.ui.focus.FocusEventModifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                        Function3 factory3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function32, 3);
                        newElement = newElement.then((Modifier) factory3.invoke(element, Composer.this, 0));
                    }
                    if (element instanceof FocusRequesterModifier) {
                        function3 = ComposedModifierKt.WrapFocusRequesterModifier;
                        Intrinsics.checkNotNull(function3, "null cannot be cast to non-null type kotlin.Function3<androidx.compose.ui.focus.FocusRequesterModifier, androidx.compose.runtime.Composer, kotlin.Int, androidx.compose.ui.Modifier>");
                        Function3 factory4 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3);
                        newElement = newElement.then((Modifier) factory4.invoke(element, Composer.this, 0));
                    }
                }
                return acc.then(newElement);
            }
        });
        $this$materialize.endReplaceableGroup();
        return result;
    }
}
