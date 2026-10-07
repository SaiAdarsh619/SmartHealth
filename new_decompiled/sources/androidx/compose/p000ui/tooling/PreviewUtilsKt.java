package androidx.compose.p000ui.tooling;

import android.util.Log;
import androidx.compose.p000ui.tooling.preview.PreviewParameterProvider;
import java.lang.reflect.Constructor;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.KotlinReflectionNotSupportedError;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* compiled from: PreviewUtils.kt */
@Metadata(m286d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a3\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u0014\u0010\u0003\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\b\u001a\u001a\u0010\t\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u0005\u0018\u00010\u0004*\u00020\nH\u0000\u001a)\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0002¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, m287d2 = {"getPreviewProviderParameters", "", "", "parameterProviderClass", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "", "(Ljava/lang/Class;I)[Ljava/lang/Object;", "asPreviewProviderClass", "", "toArray", "Lkotlin/sequences/Sequence;", "size", "(Lkotlin/sequences/Sequence;I)[Ljava/lang/Object;", "ui-tooling_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class PreviewUtilsKt {
    public static final Class<? extends PreviewParameterProvider<?>> asPreviewProviderClass(String $this$asPreviewProviderClass) {
        Intrinsics.checkNotNullParameter($this$asPreviewProviderClass, "<this>");
        try {
            Class cls = Class.forName($this$asPreviewProviderClass);
            if (cls instanceof Class) {
                return cls;
            }
            return null;
        } catch (ClassNotFoundException e) {
            Log.e("PreviewProvider", "Unable to find provider '" + $this$asPreviewProviderClass + '\'', e);
            return null;
        }
    }

    public static final Object[] getPreviewProviderParameters(Class<? extends PreviewParameterProvider<?>> cls, int parameterProviderIndex) {
        if (cls == null) {
            return new Object[0];
        }
        try {
            Object[] constructors = cls.getConstructors();
            Intrinsics.checkNotNullExpressionValue(constructors, "parameterProviderClass.constructors");
            Object[] $this$singleOrNull$iv = constructors;
            Object single$iv = null;
            boolean found$iv = false;
            int length = $this$singleOrNull$iv.length;
            int i = 0;
            while (true) {
                if (i < length) {
                    Object element$iv = $this$singleOrNull$iv[i];
                    Constructor it = (Constructor) element$iv;
                    Class<?>[] parameterTypes = it.getParameterTypes();
                    Intrinsics.checkNotNullExpressionValue(parameterTypes, "it.parameterTypes");
                    if (parameterTypes.length == 0) {
                        if (found$iv) {
                            single$iv = null;
                            break;
                        }
                        single$iv = element$iv;
                        found$iv = true;
                    }
                    i++;
                } else if (!found$iv) {
                    single$iv = null;
                }
            }
            Constructor $this$getPreviewProviderParameters_u24lambda_u2d1 = (Constructor) single$iv;
            if ($this$getPreviewProviderParameters_u24lambda_u2d1 == null) {
                throw new IllegalArgumentException("PreviewParameterProvider constructor can not have parameters");
            }
            $this$getPreviewProviderParameters_u24lambda_u2d1.setAccessible(true);
            Object newInstance = $this$getPreviewProviderParameters_u24lambda_u2d1.newInstance(new Object[0]);
            Intrinsics.checkNotNull(newInstance, "null cannot be cast to non-null type androidx.compose.ui.tooling.preview.PreviewParameterProvider<*>");
            PreviewParameterProvider params = (PreviewParameterProvider) newInstance;
            return parameterProviderIndex < 0 ? toArray(params.getValues(), params.getCount()) : new Object[]{SequencesKt.elementAt(params.getValues(), parameterProviderIndex)};
        } catch (KotlinReflectionNotSupportedError e) {
            throw new IllegalStateException("Deploying Compose Previews with PreviewParameterProvider arguments requires adding a dependency to the kotlin-reflect library.\nConsider adding 'debugImplementation \"org.jetbrains.kotlin:kotlin-reflect:$kotlin_version\"' to the module's build.gradle.");
        }
    }

    private static final Object[] toArray(Sequence<? extends Object> sequence, int size) {
        Iterator iterator = sequence.iterator();
        Object[] objArr = new Object[size];
        for (int i = 0; i < size; i++) {
            objArr[i] = iterator.next();
        }
        return objArr;
    }
}
