package androidx.health.connect.client.impl.converters.records;

import androidx.health.platform.client.proto.DataProto;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ValueExt.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0000\u001a\u0010\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0000\u001a&\u0010\b\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\t2\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00070\u000bH\u0000\u001a\u0010\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\rH\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0000¨\u0006\u000f"}, m287d2 = {"boolVal", "Landroidx/health/platform/client/proto/DataProto$Value;", "value", "", "doubleVal", "", "enumVal", "", "enumValFromInt", "", "intToStringMap", "", "longVal", "", "stringVal", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ValueExtKt {
    public static final DataProto.Value longVal(long value) {
        DataProto.Value build = DataProto.Value.newBuilder().setLongVal(value).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setLongVal(value).build()");
        return build;
    }

    public static final DataProto.Value doubleVal(double value) {
        DataProto.Value build = DataProto.Value.newBuilder().setDoubleVal(value).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setDoubleVal(value).build()");
        return build;
    }

    public static final DataProto.Value stringVal(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        DataProto.Value build = DataProto.Value.newBuilder().setStringVal(value).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setStringVal(value).build()");
        return build;
    }

    public static final DataProto.Value enumVal(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        DataProto.Value build = DataProto.Value.newBuilder().setEnumVal(value).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setEnumVal(value).build()");
        return build;
    }

    public static final DataProto.Value boolVal(boolean value) {
        DataProto.Value build = DataProto.Value.newBuilder().setBooleanVal(value).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setBooleanVal(value).build()");
        return build;
    }

    public static final DataProto.Value enumValFromInt(int value, Map<Integer, String> intToStringMap) {
        Intrinsics.checkNotNullParameter(intToStringMap, "intToStringMap");
        String p0 = intToStringMap.get(Integer.valueOf(value));
        if (p0 != null) {
            return enumVal(p0);
        }
        return null;
    }
}
