package androidx.health.connect.client.impl.converters.records;

import androidx.health.connect.client.records.metadata.DeviceTypes;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.ranges.RangesKt;

/* compiled from: DeviceTypeConverters.kt */
@Metadata(m286d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0005\"\u001d\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0005¨\u0006\b"}, m287d2 = {"DEVICE_TYPE_INT_TO_STRING_MAP", "", "", "", "getDEVICE_TYPE_INT_TO_STRING_MAP", "()Ljava/util/Map;", "DEVICE_TYPE_STRING_TO_INT_MAP", "getDEVICE_TYPE_STRING_TO_INT_MAP", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class DeviceTypeConvertersKt {
    private static final Map<Integer, String> DEVICE_TYPE_INT_TO_STRING_MAP;
    private static final Map<String, Integer> DEVICE_TYPE_STRING_TO_INT_MAP = MapsKt.mapOf(TuplesKt.m294to(DeviceTypes.UNKNOWN, 0), TuplesKt.m294to(DeviceTypes.CHEST_STRAP, 7), TuplesKt.m294to(DeviceTypes.FITNESS_BAND, 6), TuplesKt.m294to(DeviceTypes.HEAD_MOUNTED, 5), TuplesKt.m294to(DeviceTypes.PHONE, 2), TuplesKt.m294to(DeviceTypes.RING, 4), TuplesKt.m294to(DeviceTypes.SCALE, 3), TuplesKt.m294to(DeviceTypes.SMART_DISPLAY, 8), TuplesKt.m294to(DeviceTypes.WATCH, 1));

    public static final Map<String, Integer> getDEVICE_TYPE_STRING_TO_INT_MAP() {
        return DEVICE_TYPE_STRING_TO_INT_MAP;
    }

    static {
        Iterable $this$associate$iv = DEVICE_TYPE_STRING_TO_INT_MAP.entrySet();
        int capacity$iv = RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16);
        Map destination$iv$iv = new LinkedHashMap(capacity$iv);
        for (Object element$iv$iv : $this$associate$iv) {
            Map.Entry it = (Map.Entry) element$iv$iv;
            Pair m294to = TuplesKt.m294to(it.getValue(), it.getKey());
            destination$iv$iv.put(m294to.getFirst(), m294to.getSecond());
        }
        DEVICE_TYPE_INT_TO_STRING_MAP = destination$iv$iv;
    }

    public static final Map<Integer, String> getDEVICE_TYPE_INT_TO_STRING_MAP() {
        return DEVICE_TYPE_INT_TO_STRING_MAP;
    }
}
