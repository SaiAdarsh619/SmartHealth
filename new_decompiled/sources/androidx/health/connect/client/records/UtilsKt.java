package androidx.health.connect.client.records;

import android.os.ext.SdkExtensions;
import androidx.autofill.HintConstants;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Utils.kt */
@Metadata(m286d1 = {"\u00002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000f\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0001\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000\u001a9\u0010\t\u001a\u00020\u0003\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b*\u0002H\n2\u0006\u0010\f\u001a\u0002H\n2\u0006\u0010\r\u001a\u0002H\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u000e\u001a1\u0010\u000f\u001a\u00020\u0003\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b*\u0002H\n2\u0006\u0010\u0010\u001a\u0002H\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u0011\u001a1\u0010\u0012\u001a\u00020\u0003\"\u000e\b\u0000\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b*\u0002H\n2\u0006\u0010\u0010\u001a\u0002H\n2\u0006\u0010\u0006\u001a\u00020\u0007H\u0000¢\u0006\u0002\u0010\u0011\u001a$\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00070\u0014*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00150\u0014H\u0000¨\u0006\u0016"}, m287d2 = {"isAtLeastSdkExtension13", "", "requireNonNegative", "", "value", "", HintConstants.AUTOFILL_HINT_NAME, "", "", "requireInRange", "T", "", "min", "max", "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/String;)V", "requireNotLess", Vo2MaxRecord.MeasurementMethod.OTHER, "(Ljava/lang/Comparable;Ljava/lang/Comparable;Ljava/lang/String;)V", "requireNotMore", "reverse", "", "", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class UtilsKt {
    public static final boolean isAtLeastSdkExtension13() {
        return SdkExtensions.getExtensionVersion(34) >= 13;
    }

    public static final <T extends Comparable<? super T>> void requireNotLess(T t, T other, String name) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(t.compareTo(other) >= 0)) {
            throw new IllegalArgumentException((name + " must not be less than " + other + ", currently " + t + '.').toString());
        }
    }

    public static final <T extends Comparable<? super T>> void requireNotMore(T t, T other, String name) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(t.compareTo(other) <= 0)) {
            throw new IllegalArgumentException((name + " must not be more than " + other + ", currently " + t + '.').toString());
        }
    }

    public static final void requireNonNegative(long value, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(value >= 0)) {
            throw new IllegalArgumentException((name + " must not be negative").toString());
        }
    }

    public static final void requireNonNegative(double value, String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(value >= 0.0d)) {
            throw new IllegalArgumentException((name + " must not be negative").toString());
        }
    }

    public static final Map<Integer, String> reverse(Map<String, Integer> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Iterable $this$associateBy$iv = map.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associateBy$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Map.Entry it2 = (Map.Entry) element$iv$iv;
            destination$iv$iv.put(Integer.valueOf(((Number) it.getValue()).intValue()), (String) it2.getKey());
        }
        return destination$iv$iv;
    }

    public static final <T extends Comparable<? super T>> void requireInRange(T t, T min, T max, String name) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(min, "min");
        Intrinsics.checkNotNullParameter(max, "max");
        Intrinsics.checkNotNullParameter(name, "name");
        requireNotLess(t, min, name);
        requireNotMore(t, max, name);
    }
}
