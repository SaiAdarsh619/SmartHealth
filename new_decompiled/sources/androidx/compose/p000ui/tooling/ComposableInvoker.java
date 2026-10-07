package androidx.compose.p000ui.tooling;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.runtime.Composer;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.SpreadBuilder;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: ComposableInvoker.kt */
@Deprecated(message = "Use androidx.compose.runtime.reflect.ComposableMethodInvoker instead")
@ExperimentalComposeUiApi
@Metadata(m286d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004H\u0002J1\u0010\t\u001a\u00020\n2\u0010\u0010\u000b\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\f2\u0010\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\r0\fH\u0002¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J=\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u0019J(\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u001b0\f\"\u0006\b\u0000\u0010\u001b\u0018\u0001*\u0002H\u001b2\u0006\u0010\u001c\u001a\u00020\u0004H\u0082\b¢\u0006\u0002\u0010\u001dJ5\u0010\u001e\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010 J9\u0010!\u001a\u00020\u001f*\u0006\u0012\u0002\b\u00030\r2\u0006\u0010\u0015\u001a\u00020\u00142\u001a\u0010\u0018\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\r0\f\"\u0006\u0012\u0002\b\u00030\rH\u0002¢\u0006\u0002\u0010\"J\u0012\u0010#\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\rH\u0002J=\u0010$\u001a\u0004\u0018\u00010\u0001*\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\f\"\u0004\u0018\u00010\u0001H\u0002¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006'"}, m287d2 = {"Landroidx/compose/ui/tooling/ComposableInvoker;", "", "()V", "BITS_PER_INT", "", "SLOTS_PER_INT", "changedParamCount", "realValueParams", "thisParams", "compatibleTypes", "", "methodTypes", "", "Ljava/lang/Class;", "actualTypes", "([Ljava/lang/Class;[Ljava/lang/Class;)Z", "defaultParamCount", "invokeComposable", "", "className", "", "methodName", "composer", "Landroidx/compose/runtime/Composer;", "args", "(Ljava/lang/String;Ljava/lang/String;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)V", "dup", "T", "count", "(Ljava/lang/Object;I)[Ljava/lang/Object;", "findComposableMethod", "Ljava/lang/reflect/Method;", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/reflect/Method;", "getDeclaredCompatibleMethod", "(Ljava/lang/Class;Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;", "getDefaultValue", "invokeComposableMethod", "instance", "(Ljava/lang/reflect/Method;Ljava/lang/Object;Landroidx/compose/runtime/Composer;[Ljava/lang/Object;)Ljava/lang/Object;", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ComposableInvoker {
    public static final int $stable = 0;
    private static final int BITS_PER_INT = 31;
    public static final ComposableInvoker INSTANCE = new ComposableInvoker();
    private static final int SLOTS_PER_INT = 10;

    private ComposableInvoker() {
    }

    private final boolean compatibleTypes(Class<?>[] methodTypes, Class<?>[] actualTypes) {
        Iterable $this$all$iv;
        if (methodTypes.length != actualTypes.length) {
            return false;
        }
        Collection destination$iv$iv = new ArrayList(methodTypes.length);
        int index$iv$iv = 0;
        int length = methodTypes.length;
        int i = 0;
        while (i < length) {
            destination$iv$iv.add(Boolean.valueOf(methodTypes[i].isAssignableFrom(actualTypes[index$iv$iv])));
            i++;
            index$iv$iv++;
        }
        Iterable $this$all$iv2 = (List) destination$iv$iv;
        if (!($this$all$iv2 instanceof Collection) || !((Collection) $this$all$iv2).isEmpty()) {
            Iterator it = $this$all$iv2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    $this$all$iv = 1;
                    break;
                }
                Object element$iv = it.next();
                boolean it2 = ((Boolean) element$iv).booleanValue();
                if (!it2) {
                    $this$all$iv = null;
                    break;
                }
            }
        } else {
            $this$all$iv = 1;
        }
        return $this$all$iv != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x0045 A[EDGE_INSN: B:10:0x0045->B:11:0x0045 BREAK  A[LOOP:0: B:2:0x0017->B:9:0x0041], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0041 A[LOOP:0: B:2:0x0017->B:9:0x0041, LOOP_END] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Method getDeclaredCompatibleMethod(Class<?> cls, String methodName, Class<?>... clsArr) {
        Object element$iv;
        boolean z;
        Class[] actualTypes = (Class[]) Arrays.copyOf(clsArr, clsArr.length);
        Object[] declaredMethods = cls.getDeclaredMethods();
        Intrinsics.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
        Object[] $this$firstOrNull$iv = declaredMethods;
        int length = $this$firstOrNull$iv.length;
        int i = 0;
        while (true) {
            if (i < length) {
                element$iv = $this$firstOrNull$iv[i];
                Method it = (Method) element$iv;
                if (Intrinsics.areEqual(methodName, it.getName())) {
                    ComposableInvoker composableInvoker = INSTANCE;
                    Class<?>[] parameterTypes = it.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (composableInvoker.compatibleTypes(parameterTypes, actualTypes)) {
                        z = true;
                        if (!z) {
                            break;
                        }
                        i++;
                    }
                }
                z = false;
                if (!z) {
                }
            } else {
                element$iv = null;
                break;
            }
        }
        Method method = (Method) element$iv;
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodException(methodName + " not found");
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final /* synthetic */ <T> T[] dup(T t, int i) {
        IntRange until = RangesKt.until(0, i);
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(until, 10));
        Iterator<Integer> it = until.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(t);
        }
        Intrinsics.reifiedOperationMarker(0, "T?");
        Object[] array = arrayList.toArray(new Object[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        return (T[]) array;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00f2 A[Catch: ReflectiveOperationException -> 0x010b, TryCatch #4 {ReflectiveOperationException -> 0x010b, blocks: (B:23:0x00e3, B:25:0x00f2, B:30:0x0107, B:27:0x0103), top: B:22:0x00e3 }] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0113 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0106 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final Method findComposableMethod(Class<?> cls, String methodName, Object... args) {
        int i;
        Method method;
        Method method2;
        int length;
        Method method3;
        int i2 = 0;
        try {
            int changedParams = changedParamCount(args.length, 0);
            SpreadBuilder spreadBuilder = new SpreadBuilder(3);
            Collection destination$iv$iv = new ArrayList();
            int length2 = args.length;
            int i3 = 0;
            while (i3 < length2) {
                try {
                    Object element$iv$iv$iv = args[i3];
                    Class<?> cls2 = element$iv$iv$iv != null ? element$iv$iv$iv.getClass() : null;
                    if (cls2 != null) {
                        destination$iv$iv.add(cls2);
                    }
                    i3++;
                    i2 = 0;
                } catch (ReflectiveOperationException e) {
                    e = e;
                    i = 0;
                    try {
                        Method[] declaredMethods = cls.getDeclaredMethods();
                        Intrinsics.checkNotNullExpressionValue(declaredMethods, "declaredMethods");
                        Method[] methodArr = declaredMethods;
                        length = methodArr.length;
                        while (true) {
                            if (i < length) {
                            }
                            i++;
                        }
                        method2 = method3;
                    } catch (ReflectiveOperationException e2) {
                        method2 = null;
                    }
                    method = method2;
                    if (method != null) {
                    }
                }
            }
            Collection $this$toTypedArray$iv = (List) destination$iv$iv;
            int i4 = 0;
            try {
                Object[] array = $this$toTypedArray$iv.toArray(new Class[0]);
                Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                spreadBuilder.addSpread(array);
                spreadBuilder.add(Composer.class);
                Class cls3 = Integer.TYPE;
                i4 = 0;
                Iterable $this$map$iv$iv = RangesKt.until(0, changedParams);
                Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
                Iterator<Integer> it = $this$map$iv$iv.iterator();
                while (it.hasNext()) {
                    ((IntIterator) it).nextInt();
                    destination$iv$iv$iv.add(cls3);
                }
                Collection thisCollection$iv$iv = (List) destination$iv$iv$iv;
                i = 0;
                try {
                    Object[] array2 = thisCollection$iv$iv.toArray(new Class[0]);
                    Intrinsics.checkNotNull(array2, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                    spreadBuilder.addSpread(array2);
                } catch (ReflectiveOperationException e3) {
                    e = e3;
                }
            } catch (ReflectiveOperationException e4) {
                e = e4;
                i = i4;
            }
            try {
                method = getDeclaredCompatibleMethod(cls, methodName, (Class[]) spreadBuilder.toArray(new Class[spreadBuilder.size()]));
            } catch (ReflectiveOperationException e5) {
                e = e5;
                Method[] declaredMethods2 = cls.getDeclaredMethods();
                Intrinsics.checkNotNullExpressionValue(declaredMethods2, "declaredMethods");
                Method[] methodArr2 = declaredMethods2;
                length = methodArr2.length;
                while (true) {
                    if (i < length) {
                        method3 = null;
                        break;
                    }
                    method3 = methodArr2[i];
                    Method it2 = method3;
                    if (Intrinsics.areEqual(it2.getName(), methodName)) {
                        break;
                    }
                    i++;
                }
                method2 = method3;
                method = method2;
                if (method != null) {
                }
            }
        } catch (ReflectiveOperationException e6) {
            e = e6;
            i = i2;
        }
        if (method != null) {
            return method;
        }
        throw new NoSuchMethodException(cls.getName() + '.' + methodName);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    private final Object getDefaultValue(Class<?> cls) {
        String name = cls.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -1325958191:
                    if (name.equals("double")) {
                        return Double.valueOf(0.0d);
                    }
                    break;
                case 104431:
                    if (name.equals("int")) {
                        return 0;
                    }
                    break;
                case 3039496:
                    if (name.equals("byte")) {
                        return (byte) 0;
                    }
                    break;
                case 3052374:
                    if (name.equals("char")) {
                        return (char) 0;
                    }
                    break;
                case 3327612:
                    if (name.equals("long")) {
                        return 0L;
                    }
                    break;
                case 64711720:
                    if (name.equals("boolean")) {
                        return false;
                    }
                    break;
                case 97526364:
                    if (name.equals("float")) {
                        return Float.valueOf(0.0f);
                    }
                    break;
                case 109413500:
                    if (name.equals("short")) {
                        return (short) 0;
                    }
                    break;
            }
        }
        return null;
    }

    private final Object invokeComposableMethod(Method $this$invokeComposableMethod, Object instance, Composer composer, Object... args) {
        int realParams;
        Object obj;
        Object[] parameterTypes = $this$invokeComposableMethod.getParameterTypes();
        Intrinsics.checkNotNullExpressionValue(parameterTypes, "parameterTypes");
        Object[] $this$indexOfLast$iv = parameterTypes;
        int i = -1;
        int length = $this$indexOfLast$iv.length - 1;
        if (length >= 0) {
            while (true) {
                int index$iv = length;
                length--;
                Class it = (Class) $this$indexOfLast$iv[index$iv];
                if (Intrinsics.areEqual(it, Composer.class)) {
                    i = index$iv;
                    break;
                }
                if (length < 0) {
                    break;
                }
            }
        }
        int composerIndex = i;
        int realParams2 = composerIndex;
        int thisParams = instance != null ? 1 : 0;
        int changedParams = changedParamCount(realParams2, thisParams);
        int totalParamsWithoutDefaults = realParams2 + 1 + changedParams;
        int totalParams = $this$invokeComposableMethod.getParameterTypes().length;
        boolean isDefault = totalParams != totalParamsWithoutDefaults;
        int defaultParams = isDefault ? defaultParamCount(realParams2) : 0;
        if (!(((realParams2 + 1) + changedParams) + defaultParams == totalParams)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        int changedStartIndex = composerIndex + 1;
        int defaultStartIndex = changedStartIndex + changedParams;
        Object[] arguments = new Object[totalParams];
        int i2 = 0;
        while (i2 < totalParams) {
            if (!(i2 >= 0 && i2 < realParams2)) {
                realParams = realParams2;
                if (i2 == composerIndex) {
                    obj = composer;
                } else {
                    if (changedStartIndex <= i2 && i2 < defaultStartIndex) {
                        obj = 0;
                    } else {
                        if (!(defaultStartIndex <= i2 && i2 < totalParams)) {
                            throw new IllegalStateException("Unexpected index".toString());
                        }
                        obj = 2097151;
                    }
                }
            } else if (i2 < 0 || i2 > ArraysKt.getLastIndex(args)) {
                ComposableInvoker composableInvoker = INSTANCE;
                Class<?> cls = $this$invokeComposableMethod.getParameterTypes()[i2];
                realParams = realParams2;
                Intrinsics.checkNotNullExpressionValue(cls, "parameterTypes[idx]");
                obj = composableInvoker.getDefaultValue(cls);
            } else {
                obj = args[i2];
                realParams = realParams2;
            }
            arguments[i2] = obj;
            i2++;
            realParams2 = realParams;
        }
        return $this$invokeComposableMethod.invoke(instance, Arrays.copyOf(arguments, arguments.length));
    }

    private final int changedParamCount(int realValueParams, int thisParams) {
        if (realValueParams == 0) {
            return 1;
        }
        int totalParams = realValueParams + thisParams;
        return (int) Math.ceil(totalParams / 10.0d);
    }

    private final int defaultParamCount(int realValueParams) {
        return (int) Math.ceil(realValueParams / 31.0d);
    }

    @ExperimentalComposeUiApi
    public final void invokeComposable(String className, String methodName, Composer composer, Object... args) {
        Intrinsics.checkNotNullParameter(className, "className");
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(args, "args");
        try {
            Class composableClass = Class.forName(className);
            Intrinsics.checkNotNullExpressionValue(composableClass, "composableClass");
            Method method = findComposableMethod(composableClass, methodName, Arrays.copyOf(args, args.length));
            method.setAccessible(true);
            if (Modifier.isStatic(method.getModifiers())) {
                invokeComposableMethod(method, null, composer, Arrays.copyOf(args, args.length));
            } else {
                Object instance = composableClass.getConstructor(new Class[0]).newInstance(new Object[0]);
                invokeComposableMethod(method, instance, composer, Arrays.copyOf(args, args.length));
            }
        } catch (ReflectiveOperationException e) {
            throw new ClassNotFoundException("Composable Method '" + className + '.' + methodName + "' not found", e);
        }
    }
}
