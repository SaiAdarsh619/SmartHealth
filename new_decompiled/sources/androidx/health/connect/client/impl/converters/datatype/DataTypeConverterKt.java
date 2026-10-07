package androidx.health.connect.client.impl.converters.datatype;

import androidx.health.connect.client.records.Record;
import androidx.health.platform.client.proto.DataProto;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

/* compiled from: DataTypeConverter.kt */
@Metadata(m286d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002\u001a\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002*\u00020\u0001\u001a\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002*\u00020\u0005\u001a\u0012\u0010\u0006\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\u00030\u0002¨\u0006\u0007"}, m287d2 = {"toDataType", "Landroidx/health/platform/client/proto/DataProto$DataType;", "Lkotlin/reflect/KClass;", "Landroidx/health/connect/client/records/Record;", "toDataTypeKClass", "", "toDataTypeName", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class DataTypeConverterKt {
    public static final String toDataTypeName(KClass<? extends Record> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String str = RecordsTypeNameMapKt.getRECORDS_CLASS_NAME_MAP().get(kClass);
        if (str != null) {
            return str;
        }
        throw new UnsupportedOperationException("Not supported yet: " + kClass);
    }

    public static final DataProto.DataType toDataType(KClass<? extends Record> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        DataProto.DataType build = DataProto.DataType.newBuilder().setName(toDataTypeName(kClass)).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setName(toDataTypeName()).build()");
        return build;
    }

    public static final KClass<? extends Record> toDataTypeKClass(String $this$toDataTypeKClass) {
        Intrinsics.checkNotNullParameter($this$toDataTypeKClass, "<this>");
        KClass<? extends Record> kClass = RecordsTypeNameMapKt.getRECORDS_TYPE_NAME_MAP().get($this$toDataTypeKClass);
        if (kClass != null) {
            return kClass;
        }
        throw new UnsupportedOperationException("Not supported yet: " + $this$toDataTypeKClass);
    }

    public static final KClass<? extends Record> toDataTypeKClass(DataProto.DataType $this$toDataTypeKClass) {
        Intrinsics.checkNotNullParameter($this$toDataTypeKClass, "<this>");
        String name = $this$toDataTypeKClass.getName();
        Intrinsics.checkNotNullExpressionValue(name, "name");
        return toDataTypeKClass(name);
    }
}
