package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import androidx.health.platform.client.proto.WireFormat;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* loaded from: classes14.dex */
public final class DataProto {

    public interface AggregateDataRowOrBuilder extends MessageLiteOrBuilder {
        boolean containsDoubleValues(String str);

        boolean containsLongValues(String str);

        DataOrigin getDataOrigins(int i);

        int getDataOriginsCount();

        List<DataOrigin> getDataOriginsList();

        @Deprecated
        Map<String, Double> getDoubleValues();

        int getDoubleValuesCount();

        Map<String, Double> getDoubleValuesMap();

        double getDoubleValuesOrDefault(String str, double d);

        double getDoubleValuesOrThrow(String str);

        String getEndLocalDateTime();

        ByteString getEndLocalDateTimeBytes();

        long getEndTimeEpochMs();

        @Deprecated
        Map<String, Long> getLongValues();

        int getLongValuesCount();

        Map<String, Long> getLongValuesMap();

        long getLongValuesOrDefault(String str, long j);

        long getLongValuesOrThrow(String str);

        String getStartLocalDateTime();

        ByteString getStartLocalDateTimeBytes();

        long getStartTimeEpochMs();

        int getZoneOffsetSeconds();

        boolean hasEndLocalDateTime();

        boolean hasEndTimeEpochMs();

        boolean hasStartLocalDateTime();

        boolean hasStartTimeEpochMs();

        boolean hasZoneOffsetSeconds();
    }

    public interface AggregatedValueOrBuilder extends MessageLiteOrBuilder {
        boolean containsValues(String str);

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);
    }

    public interface DataOriginOrBuilder extends MessageLiteOrBuilder {
        String getApplicationId();

        ByteString getApplicationIdBytes();

        boolean hasApplicationId();
    }

    public interface DataPointOrBuilder extends MessageLiteOrBuilder {
        boolean containsSubTypeDataLists(String str);

        boolean containsValues(String str);

        AggregatedValue getAvg();

        String getClientId();

        ByteString getClientIdBytes();

        long getClientVersion();

        DataOrigin getDataOrigin();

        DataType getDataType();

        Device getDevice();

        long getEndTimeMillis();

        int getEndZoneOffsetSeconds();

        long getInstantTimeMillis();

        AggregatedValue getMax();

        AggregatedValue getMin();

        String getOriginSampleUid();

        ByteString getOriginSampleUidBytes();

        String getOriginSeriesUid();

        ByteString getOriginSeriesUidBytes();

        int getRecordingMethod();

        SeriesValue getSeriesValues(int i);

        int getSeriesValuesCount();

        List<SeriesValue> getSeriesValuesList();

        long getStartTimeMillis();

        int getStartZoneOffsetSeconds();

        @Deprecated
        Map<String, DataPoint.SubTypeDataList> getSubTypeDataLists();

        int getSubTypeDataListsCount();

        Map<String, DataPoint.SubTypeDataList> getSubTypeDataListsMap();

        DataPoint.SubTypeDataList getSubTypeDataListsOrDefault(String str, DataPoint.SubTypeDataList subTypeDataList);

        DataPoint.SubTypeDataList getSubTypeDataListsOrThrow(String str);

        String getUid();

        ByteString getUidBytes();

        long getUpdateTimeMillis();

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);

        int getZoneOffsetSeconds();

        boolean hasAvg();

        boolean hasClientId();

        boolean hasClientVersion();

        boolean hasDataOrigin();

        boolean hasDataType();

        boolean hasDevice();

        boolean hasEndTimeMillis();

        boolean hasEndZoneOffsetSeconds();

        boolean hasInstantTimeMillis();

        boolean hasMax();

        boolean hasMin();

        boolean hasOriginSampleUid();

        boolean hasOriginSeriesUid();

        boolean hasRecordingMethod();

        boolean hasStartTimeMillis();

        boolean hasStartZoneOffsetSeconds();

        boolean hasUid();

        boolean hasUpdateTimeMillis();

        boolean hasZoneOffsetSeconds();
    }

    public interface DataTypeOrBuilder extends MessageLiteOrBuilder {
        String getName();

        ByteString getNameBytes();

        boolean hasName();
    }

    public interface DeviceOrBuilder extends MessageLiteOrBuilder {
        String getIdentifier();

        ByteString getIdentifierBytes();

        String getManufacturer();

        ByteString getManufacturerBytes();

        String getModel();

        ByteString getModelBytes();

        String getType();

        ByteString getTypeBytes();

        boolean hasIdentifier();

        boolean hasManufacturer();

        boolean hasModel();

        boolean hasType();
    }

    public interface SeriesValueOrBuilder extends MessageLiteOrBuilder {
        boolean containsValues(String str);

        long getInstantTimeMillis();

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);

        boolean hasInstantTimeMillis();
    }

    public interface SubTypeDataValueOrBuilder extends MessageLiteOrBuilder {
        boolean containsValues(String str);

        long getEndTimeMillis();

        long getStartTimeMillis();

        @Deprecated
        Map<String, Value> getValues();

        int getValuesCount();

        Map<String, Value> getValuesMap();

        Value getValuesOrDefault(String str, Value value);

        Value getValuesOrThrow(String str);

        boolean hasEndTimeMillis();

        boolean hasStartTimeMillis();
    }

    public interface ValueOrBuilder extends MessageLiteOrBuilder {
        boolean getBooleanVal();

        double getDoubleVal();

        String getEnumVal();

        ByteString getEnumValBytes();

        long getLongVal();

        String getStringVal();

        ByteString getStringValBytes();

        Value.ValueCase getValueCase();

        boolean hasBooleanVal();

        boolean hasDoubleVal();

        boolean hasEnumVal();

        boolean hasLongVal();

        boolean hasStringVal();
    }

    private DataProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class DataType extends GeneratedMessageLite<DataType, Builder> implements DataTypeOrBuilder {
        private static final DataType DEFAULT_INSTANCE;
        public static final int NAME_FIELD_NUMBER = 1;
        private static volatile Parser<DataType> PARSER;
        private int bitField0_;
        private String name_ = "";

        private DataType() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
        public boolean hasName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
        public String getName() {
            return this.name_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
        public ByteString getNameBytes() {
            return ByteString.copyFromUtf8(this.name_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setName(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.name_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearName() {
            this.bitField0_ &= -2;
            this.name_ = getDefaultInstance().getName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNameBytes(ByteString value) {
            this.name_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static DataType parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataType parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataType parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataType parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataType parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataType parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataType parseFrom(InputStream input) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataType parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataType parseDelimitedFrom(InputStream input) throws IOException {
            return (DataType) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DataType parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataType) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataType parseFrom(CodedInputStream input) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataType parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataType) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataType prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataType, Builder> implements DataTypeOrBuilder {
            private Builder() {
                super(DataType.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
            public boolean hasName() {
                return ((DataType) this.instance).hasName();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
            public String getName() {
                return ((DataType) this.instance).getName();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataTypeOrBuilder
            public ByteString getNameBytes() {
                return ((DataType) this.instance).getNameBytes();
            }

            public Builder setName(String value) {
                copyOnWrite();
                ((DataType) this.instance).setName(value);
                return this;
            }

            public Builder clearName() {
                copyOnWrite();
                ((DataType) this.instance).clearName();
                return this;
            }

            public Builder setNameBytes(ByteString value) {
                copyOnWrite();
                ((DataType) this.instance).setNameBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new DataType();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "name_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DataType> parser = PARSER;
                    if (parser == null) {
                        synchronized (DataType.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            DataType defaultInstance = new DataType();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(DataType.class, defaultInstance);
        }

        public static DataType getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataType> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Value extends GeneratedMessageLite<Value, Builder> implements ValueOrBuilder {
        public static final int BOOLEAN_VAL_FIELD_NUMBER = 5;
        private static final Value DEFAULT_INSTANCE;
        public static final int DOUBLE_VAL_FIELD_NUMBER = 2;
        public static final int ENUM_VAL_FIELD_NUMBER = 4;
        public static final int LONG_VAL_FIELD_NUMBER = 1;
        private static volatile Parser<Value> PARSER = null;
        public static final int STRING_VAL_FIELD_NUMBER = 3;
        private int valueCase_ = 0;
        private Object value_;

        private Value() {
        }

        public enum ValueCase {
            LONG_VAL(1),
            DOUBLE_VAL(2),
            STRING_VAL(3),
            ENUM_VAL(4),
            BOOLEAN_VAL(5),
            VALUE_NOT_SET(0);

            private final int value;

            ValueCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ValueCase valueOf(int value) {
                return forNumber(value);
            }

            public static ValueCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return VALUE_NOT_SET;
                    case 1:
                        return LONG_VAL;
                    case 2:
                        return DOUBLE_VAL;
                    case 3:
                        return STRING_VAL;
                    case 4:
                        return ENUM_VAL;
                    case 5:
                        return BOOLEAN_VAL;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public ValueCase getValueCase() {
            return ValueCase.forNumber(this.valueCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearValue() {
            this.valueCase_ = 0;
            this.value_ = null;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasLongVal() {
            return this.valueCase_ == 1;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public long getLongVal() {
            if (this.valueCase_ == 1) {
                return ((Long) this.value_).longValue();
            }
            return 0L;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLongVal(long value) {
            this.valueCase_ = 1;
            this.value_ = Long.valueOf(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLongVal() {
            if (this.valueCase_ == 1) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasDoubleVal() {
            return this.valueCase_ == 2;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public double getDoubleVal() {
            if (this.valueCase_ == 2) {
                return ((Double) this.value_).doubleValue();
            }
            return 0.0d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDoubleVal(double value) {
            this.valueCase_ = 2;
            this.value_ = Double.valueOf(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDoubleVal() {
            if (this.valueCase_ == 2) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasStringVal() {
            return this.valueCase_ == 3;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public String getStringVal() {
            if (this.valueCase_ != 3) {
                return "";
            }
            String ref = (String) this.value_;
            return ref;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public ByteString getStringValBytes() {
            String ref = "";
            if (this.valueCase_ == 3) {
                ref = (String) this.value_;
            }
            return ByteString.copyFromUtf8(ref);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringVal(String value) {
            value.getClass();
            this.valueCase_ = 3;
            this.value_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStringVal() {
            if (this.valueCase_ == 3) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStringValBytes(ByteString value) {
            this.value_ = value.toStringUtf8();
            this.valueCase_ = 3;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasEnumVal() {
            return this.valueCase_ == 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public String getEnumVal() {
            if (this.valueCase_ != 4) {
                return "";
            }
            String ref = (String) this.value_;
            return ref;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public ByteString getEnumValBytes() {
            String ref = "";
            if (this.valueCase_ == 4) {
                ref = (String) this.value_;
            }
            return ByteString.copyFromUtf8(ref);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumVal(String value) {
            value.getClass();
            this.valueCase_ = 4;
            this.value_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEnumVal() {
            if (this.valueCase_ == 4) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEnumValBytes(ByteString value) {
            this.value_ = value.toStringUtf8();
            this.valueCase_ = 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean hasBooleanVal() {
            return this.valueCase_ == 5;
        }

        @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
        public boolean getBooleanVal() {
            if (this.valueCase_ == 5) {
                return ((Boolean) this.value_).booleanValue();
            }
            return false;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setBooleanVal(boolean value) {
            this.valueCase_ = 5;
            this.value_ = Boolean.valueOf(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearBooleanVal() {
            if (this.valueCase_ == 5) {
                this.valueCase_ = 0;
                this.value_ = null;
            }
        }

        public static Value parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Value parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Value parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Value parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Value parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Value parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Value parseFrom(InputStream input) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Value parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Value parseDelimitedFrom(InputStream input) throws IOException {
            return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Value parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Value) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Value parseFrom(CodedInputStream input) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Value parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Value) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Value prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Value, Builder> implements ValueOrBuilder {
            private Builder() {
                super(Value.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public ValueCase getValueCase() {
                return ((Value) this.instance).getValueCase();
            }

            public Builder clearValue() {
                copyOnWrite();
                ((Value) this.instance).clearValue();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasLongVal() {
                return ((Value) this.instance).hasLongVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public long getLongVal() {
                return ((Value) this.instance).getLongVal();
            }

            public Builder setLongVal(long value) {
                copyOnWrite();
                ((Value) this.instance).setLongVal(value);
                return this;
            }

            public Builder clearLongVal() {
                copyOnWrite();
                ((Value) this.instance).clearLongVal();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasDoubleVal() {
                return ((Value) this.instance).hasDoubleVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public double getDoubleVal() {
                return ((Value) this.instance).getDoubleVal();
            }

            public Builder setDoubleVal(double value) {
                copyOnWrite();
                ((Value) this.instance).setDoubleVal(value);
                return this;
            }

            public Builder clearDoubleVal() {
                copyOnWrite();
                ((Value) this.instance).clearDoubleVal();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasStringVal() {
                return ((Value) this.instance).hasStringVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public String getStringVal() {
                return ((Value) this.instance).getStringVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public ByteString getStringValBytes() {
                return ((Value) this.instance).getStringValBytes();
            }

            public Builder setStringVal(String value) {
                copyOnWrite();
                ((Value) this.instance).setStringVal(value);
                return this;
            }

            public Builder clearStringVal() {
                copyOnWrite();
                ((Value) this.instance).clearStringVal();
                return this;
            }

            public Builder setStringValBytes(ByteString value) {
                copyOnWrite();
                ((Value) this.instance).setStringValBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasEnumVal() {
                return ((Value) this.instance).hasEnumVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public String getEnumVal() {
                return ((Value) this.instance).getEnumVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public ByteString getEnumValBytes() {
                return ((Value) this.instance).getEnumValBytes();
            }

            public Builder setEnumVal(String value) {
                copyOnWrite();
                ((Value) this.instance).setEnumVal(value);
                return this;
            }

            public Builder clearEnumVal() {
                copyOnWrite();
                ((Value) this.instance).clearEnumVal();
                return this;
            }

            public Builder setEnumValBytes(ByteString value) {
                copyOnWrite();
                ((Value) this.instance).setEnumValBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean hasBooleanVal() {
                return ((Value) this.instance).hasBooleanVal();
            }

            @Override // androidx.health.platform.client.proto.DataProto.ValueOrBuilder
            public boolean getBooleanVal() {
                return ((Value) this.instance).getBooleanVal();
            }

            public Builder setBooleanVal(boolean value) {
                copyOnWrite();
                ((Value) this.instance).setBooleanVal(value);
                return this;
            }

            public Builder clearBooleanVal() {
                copyOnWrite();
                ((Value) this.instance).clearBooleanVal();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new Value();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"value_", "valueCase_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0001\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u00015\u0000\u00023\u0000\u0003;\u0000\u0004;\u0000\u0005:\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<Value> parser = PARSER;
                    if (parser == null) {
                        synchronized (Value.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Value defaultInstance = new Value();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(Value.class, defaultInstance);
        }

        public static Value getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Value> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class Device extends GeneratedMessageLite<Device, Builder> implements DeviceOrBuilder {
        private static final Device DEFAULT_INSTANCE;
        public static final int IDENTIFIER_FIELD_NUMBER = 1;
        public static final int MANUFACTURER_FIELD_NUMBER = 2;
        public static final int MODEL_FIELD_NUMBER = 3;
        private static volatile Parser<Device> PARSER = null;
        public static final int TYPE_FIELD_NUMBER = 4;
        private int bitField0_;
        private String identifier_ = "";
        private String manufacturer_ = "";
        private String model_ = "";
        private String type_ = "";

        private Device() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasIdentifier() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getIdentifier() {
            return this.identifier_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getIdentifierBytes() {
            return ByteString.copyFromUtf8(this.identifier_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifier(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.identifier_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIdentifier() {
            this.bitField0_ &= -2;
            this.identifier_ = getDefaultInstance().getIdentifier();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdentifierBytes(ByteString value) {
            this.identifier_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasManufacturer() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getManufacturer() {
            return this.manufacturer_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getManufacturerBytes() {
            return ByteString.copyFromUtf8(this.manufacturer_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setManufacturer(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.manufacturer_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearManufacturer() {
            this.bitField0_ &= -3;
            this.manufacturer_ = getDefaultInstance().getManufacturer();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setManufacturerBytes(ByteString value) {
            this.manufacturer_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasModel() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getModel() {
            return this.model_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getModelBytes() {
            return ByteString.copyFromUtf8(this.model_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModel(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.model_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearModel() {
            this.bitField0_ &= -5;
            this.model_ = getDefaultInstance().getModel();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setModelBytes(ByteString value) {
            this.model_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public boolean hasType() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public String getType() {
            return this.type_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
        public ByteString getTypeBytes() {
            return ByteString.copyFromUtf8(this.type_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setType(String value) {
            value.getClass();
            this.bitField0_ |= 8;
            this.type_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearType() {
            this.bitField0_ &= -9;
            this.type_ = getDefaultInstance().getType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTypeBytes(ByteString value) {
            this.type_ = value.toStringUtf8();
            this.bitField0_ |= 8;
        }

        public static Device parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Device parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Device parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Device parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Device parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Device parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Device parseFrom(InputStream input) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Device parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Device parseDelimitedFrom(InputStream input) throws IOException {
            return (Device) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Device parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Device) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Device parseFrom(CodedInputStream input) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Device parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Device) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Device prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Device, Builder> implements DeviceOrBuilder {
            private Builder() {
                super(Device.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasIdentifier() {
                return ((Device) this.instance).hasIdentifier();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getIdentifier() {
                return ((Device) this.instance).getIdentifier();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getIdentifierBytes() {
                return ((Device) this.instance).getIdentifierBytes();
            }

            public Builder setIdentifier(String value) {
                copyOnWrite();
                ((Device) this.instance).setIdentifier(value);
                return this;
            }

            public Builder clearIdentifier() {
                copyOnWrite();
                ((Device) this.instance).clearIdentifier();
                return this;
            }

            public Builder setIdentifierBytes(ByteString value) {
                copyOnWrite();
                ((Device) this.instance).setIdentifierBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasManufacturer() {
                return ((Device) this.instance).hasManufacturer();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getManufacturer() {
                return ((Device) this.instance).getManufacturer();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getManufacturerBytes() {
                return ((Device) this.instance).getManufacturerBytes();
            }

            public Builder setManufacturer(String value) {
                copyOnWrite();
                ((Device) this.instance).setManufacturer(value);
                return this;
            }

            public Builder clearManufacturer() {
                copyOnWrite();
                ((Device) this.instance).clearManufacturer();
                return this;
            }

            public Builder setManufacturerBytes(ByteString value) {
                copyOnWrite();
                ((Device) this.instance).setManufacturerBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasModel() {
                return ((Device) this.instance).hasModel();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getModel() {
                return ((Device) this.instance).getModel();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getModelBytes() {
                return ((Device) this.instance).getModelBytes();
            }

            public Builder setModel(String value) {
                copyOnWrite();
                ((Device) this.instance).setModel(value);
                return this;
            }

            public Builder clearModel() {
                copyOnWrite();
                ((Device) this.instance).clearModel();
                return this;
            }

            public Builder setModelBytes(ByteString value) {
                copyOnWrite();
                ((Device) this.instance).setModelBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public boolean hasType() {
                return ((Device) this.instance).hasType();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public String getType() {
                return ((Device) this.instance).getType();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DeviceOrBuilder
            public ByteString getTypeBytes() {
                return ((Device) this.instance).getTypeBytes();
            }

            public Builder setType(String value) {
                copyOnWrite();
                ((Device) this.instance).setType(value);
                return this;
            }

            public Builder clearType() {
                copyOnWrite();
                ((Device) this.instance).clearType();
                return this;
            }

            public Builder setTypeBytes(ByteString value) {
                copyOnWrite();
                ((Device) this.instance).setTypeBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new Device();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "identifier_", "manufacturer_", "model_", "type_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<Device> parser = PARSER;
                    if (parser == null) {
                        synchronized (Device.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            Device defaultInstance = new Device();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(Device.class, defaultInstance);
        }

        public static Device getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Device> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DataOrigin extends GeneratedMessageLite<DataOrigin, Builder> implements DataOriginOrBuilder {
        public static final int APPLICATION_ID_FIELD_NUMBER = 1;
        private static final DataOrigin DEFAULT_INSTANCE;
        private static volatile Parser<DataOrigin> PARSER;
        private String applicationId_ = "";
        private int bitField0_;

        private DataOrigin() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
        public boolean hasApplicationId() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
        public String getApplicationId() {
            return this.applicationId_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
        public ByteString getApplicationIdBytes() {
            return ByteString.copyFromUtf8(this.applicationId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApplicationId(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.applicationId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearApplicationId() {
            this.bitField0_ &= -2;
            this.applicationId_ = getDefaultInstance().getApplicationId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setApplicationIdBytes(ByteString value) {
            this.applicationId_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static DataOrigin parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataOrigin parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataOrigin parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataOrigin parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataOrigin parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataOrigin parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataOrigin parseFrom(InputStream input) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataOrigin parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataOrigin parseDelimitedFrom(InputStream input) throws IOException {
            return (DataOrigin) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DataOrigin parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataOrigin) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataOrigin parseFrom(CodedInputStream input) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataOrigin parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataOrigin) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataOrigin prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataOrigin, Builder> implements DataOriginOrBuilder {
            private Builder() {
                super(DataOrigin.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
            public boolean hasApplicationId() {
                return ((DataOrigin) this.instance).hasApplicationId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
            public String getApplicationId() {
                return ((DataOrigin) this.instance).getApplicationId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataOriginOrBuilder
            public ByteString getApplicationIdBytes() {
                return ((DataOrigin) this.instance).getApplicationIdBytes();
            }

            public Builder setApplicationId(String value) {
                copyOnWrite();
                ((DataOrigin) this.instance).setApplicationId(value);
                return this;
            }

            public Builder clearApplicationId() {
                copyOnWrite();
                ((DataOrigin) this.instance).clearApplicationId();
                return this;
            }

            public Builder setApplicationIdBytes(ByteString value) {
                copyOnWrite();
                ((DataOrigin) this.instance).setApplicationIdBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new DataOrigin();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "applicationId_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DataOrigin> parser = PARSER;
                    if (parser == null) {
                        synchronized (DataOrigin.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            DataOrigin defaultInstance = new DataOrigin();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(DataOrigin.class, defaultInstance);
        }

        public static DataOrigin getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataOrigin> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SeriesValue extends GeneratedMessageLite<SeriesValue, Builder> implements SeriesValueOrBuilder {
        private static final SeriesValue DEFAULT_INSTANCE;
        public static final int INSTANT_TIME_MILLIS_FIELD_NUMBER = 2;
        private static volatile Parser<SeriesValue> PARSER = null;
        public static final int VALUES_FIELD_NUMBER = 1;
        private int bitField0_;
        private long instantTimeMillis_;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();

        private SeriesValue() {
        }

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public boolean containsValues(String key) {
            key.getClass();
            return internalGetValues().containsKey(key);
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public Value getValuesOrDefault(String key, Value defaultValue) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public Value getValuesOrThrow(String key) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public boolean hasInstantTimeMillis() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
        public long getInstantTimeMillis() {
            return this.instantTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstantTimeMillis(long value) {
            this.bitField0_ |= 1;
            this.instantTimeMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInstantTimeMillis() {
            this.bitField0_ &= -2;
            this.instantTimeMillis_ = 0L;
        }

        public static SeriesValue parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SeriesValue parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SeriesValue parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SeriesValue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SeriesValue parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SeriesValue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SeriesValue parseFrom(InputStream input) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SeriesValue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SeriesValue parseDelimitedFrom(InputStream input) throws IOException {
            return (SeriesValue) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SeriesValue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeriesValue) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SeriesValue parseFrom(CodedInputStream input) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SeriesValue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SeriesValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SeriesValue prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SeriesValue, Builder> implements SeriesValueOrBuilder {
            private Builder() {
                super(SeriesValue.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public int getValuesCount() {
                return ((SeriesValue) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public boolean containsValues(String key) {
                key.getClass();
                return ((SeriesValue) this.instance).getValuesMap().containsKey(key);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String key) {
                key.getClass();
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().remove(key);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((SeriesValue) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public Value getValuesOrDefault(String key, Value defaultValue) {
                key.getClass();
                Map<String, Value> map = ((SeriesValue) this.instance).getValuesMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public Value getValuesOrThrow(String key) {
                key.getClass();
                Map<String, Value> map = ((SeriesValue) this.instance).getValuesMap();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder putValues(String key, Value value) {
                key.getClass();
                value.getClass();
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().put(key, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> values) {
                copyOnWrite();
                ((SeriesValue) this.instance).getMutableValuesMap().putAll(values);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public boolean hasInstantTimeMillis() {
                return ((SeriesValue) this.instance).hasInstantTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SeriesValueOrBuilder
            public long getInstantTimeMillis() {
                return ((SeriesValue) this.instance).getInstantTimeMillis();
            }

            public Builder setInstantTimeMillis(long value) {
                copyOnWrite();
                ((SeriesValue) this.instance).setInstantTimeMillis(value);
                return this;
            }

            public Builder clearInstantTimeMillis() {
                copyOnWrite();
                ((SeriesValue) this.instance).clearInstantTimeMillis();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new SeriesValue();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "values_", ValuesDefaultEntryHolder.defaultEntry, "instantTimeMillis_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0001\u0000\u0000\u00012\u0002ဂ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<SeriesValue> parser = PARSER;
                    if (parser == null) {
                        synchronized (SeriesValue.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SeriesValue defaultInstance = new SeriesValue();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(SeriesValue.class, defaultInstance);
        }

        public static SeriesValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SeriesValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class SubTypeDataValue extends GeneratedMessageLite<SubTypeDataValue, Builder> implements SubTypeDataValueOrBuilder {
        private static final SubTypeDataValue DEFAULT_INSTANCE;
        public static final int END_TIME_MILLIS_FIELD_NUMBER = 3;
        private static volatile Parser<SubTypeDataValue> PARSER = null;
        public static final int START_TIME_MILLIS_FIELD_NUMBER = 2;
        public static final int VALUES_FIELD_NUMBER = 1;
        private int bitField0_;
        private long endTimeMillis_;
        private long startTimeMillis_;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();

        private SubTypeDataValue() {
        }

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public boolean containsValues(String key) {
            key.getClass();
            return internalGetValues().containsKey(key);
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public Value getValuesOrDefault(String key, Value defaultValue) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public Value getValuesOrThrow(String key) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public boolean hasStartTimeMillis() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public long getStartTimeMillis() {
            return this.startTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeMillis(long value) {
            this.bitField0_ |= 1;
            this.startTimeMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeMillis() {
            this.bitField0_ &= -2;
            this.startTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public boolean hasEndTimeMillis() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
        public long getEndTimeMillis() {
            return this.endTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTimeMillis(long value) {
            this.bitField0_ |= 2;
            this.endTimeMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTimeMillis() {
            this.bitField0_ &= -3;
            this.endTimeMillis_ = 0L;
        }

        public static SubTypeDataValue parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SubTypeDataValue parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SubTypeDataValue parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SubTypeDataValue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SubTypeDataValue parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SubTypeDataValue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SubTypeDataValue parseFrom(InputStream input) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SubTypeDataValue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SubTypeDataValue parseDelimitedFrom(InputStream input) throws IOException {
            return (SubTypeDataValue) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SubTypeDataValue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubTypeDataValue) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SubTypeDataValue parseFrom(CodedInputStream input) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SubTypeDataValue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SubTypeDataValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SubTypeDataValue prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SubTypeDataValue, Builder> implements SubTypeDataValueOrBuilder {
            private Builder() {
                super(SubTypeDataValue.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public int getValuesCount() {
                return ((SubTypeDataValue) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public boolean containsValues(String key) {
                key.getClass();
                return ((SubTypeDataValue) this.instance).getValuesMap().containsKey(key);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String key) {
                key.getClass();
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().remove(key);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((SubTypeDataValue) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public Value getValuesOrDefault(String key, Value defaultValue) {
                key.getClass();
                Map<String, Value> map = ((SubTypeDataValue) this.instance).getValuesMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public Value getValuesOrThrow(String key) {
                key.getClass();
                Map<String, Value> map = ((SubTypeDataValue) this.instance).getValuesMap();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder putValues(String key, Value value) {
                key.getClass();
                value.getClass();
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().put(key, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> values) {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).getMutableValuesMap().putAll(values);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public boolean hasStartTimeMillis() {
                return ((SubTypeDataValue) this.instance).hasStartTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public long getStartTimeMillis() {
                return ((SubTypeDataValue) this.instance).getStartTimeMillis();
            }

            public Builder setStartTimeMillis(long value) {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).setStartTimeMillis(value);
                return this;
            }

            public Builder clearStartTimeMillis() {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).clearStartTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public boolean hasEndTimeMillis() {
                return ((SubTypeDataValue) this.instance).hasEndTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.SubTypeDataValueOrBuilder
            public long getEndTimeMillis() {
                return ((SubTypeDataValue) this.instance).getEndTimeMillis();
            }

            public Builder setEndTimeMillis(long value) {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).setEndTimeMillis(value);
                return this;
            }

            public Builder clearEndTimeMillis() {
                copyOnWrite();
                ((SubTypeDataValue) this.instance).clearEndTimeMillis();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new SubTypeDataValue();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "values_", ValuesDefaultEntryHolder.defaultEntry, "startTimeMillis_", "endTimeMillis_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0001\u0000\u0000\u00012\u0002ဂ\u0000\u0003ဂ\u0001", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<SubTypeDataValue> parser = PARSER;
                    if (parser == null) {
                        synchronized (SubTypeDataValue.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            SubTypeDataValue defaultInstance = new SubTypeDataValue();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(SubTypeDataValue.class, defaultInstance);
        }

        public static SubTypeDataValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SubTypeDataValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DataPoint extends GeneratedMessageLite<DataPoint, Builder> implements DataPointOrBuilder {
        public static final int AVG_FIELD_NUMBER = 18;
        public static final int CLIENT_ID_FIELD_NUMBER = 11;
        public static final int CLIENT_VERSION_FIELD_NUMBER = 12;
        public static final int DATA_ORIGIN_FIELD_NUMBER = 5;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final DataPoint DEFAULT_INSTANCE;
        public static final int DEVICE_FIELD_NUMBER = 13;
        public static final int END_TIME_MILLIS_FIELD_NUMBER = 10;
        public static final int END_ZONE_OFFSET_SECONDS_FIELD_NUMBER = 20;
        public static final int INSTANT_TIME_MILLIS_FIELD_NUMBER = 8;
        public static final int MAX_FIELD_NUMBER = 17;
        public static final int MIN_FIELD_NUMBER = 16;
        public static final int ORIGIN_SAMPLE_UID_FIELD_NUMBER = 14;
        public static final int ORIGIN_SERIES_UID_FIELD_NUMBER = 4;
        private static volatile Parser<DataPoint> PARSER = null;
        public static final int RECORDING_METHOD_FIELD_NUMBER = 23;
        public static final int SERIES_VALUES_FIELD_NUMBER = 15;
        public static final int START_TIME_MILLIS_FIELD_NUMBER = 9;
        public static final int START_ZONE_OFFSET_SECONDS_FIELD_NUMBER = 19;
        public static final int SUB_TYPE_DATA_LISTS_FIELD_NUMBER = 22;
        public static final int UID_FIELD_NUMBER = 3;
        public static final int UPDATE_TIME_MILLIS_FIELD_NUMBER = 7;
        public static final int VALUES_FIELD_NUMBER = 2;
        public static final int ZONE_OFFSET_SECONDS_FIELD_NUMBER = 6;
        private AggregatedValue avg_;
        private int bitField0_;
        private long clientVersion_;
        private DataOrigin dataOrigin_;
        private DataType dataType_;
        private Device device_;
        private long endTimeMillis_;
        private int endZoneOffsetSeconds_;
        private long instantTimeMillis_;
        private AggregatedValue max_;
        private AggregatedValue min_;
        private int recordingMethod_;
        private long startTimeMillis_;
        private int startZoneOffsetSeconds_;
        private long updateTimeMillis_;
        private int zoneOffsetSeconds_;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, SubTypeDataList> subTypeDataLists_ = MapFieldLite.emptyMapField();
        private String uid_ = "";
        private String originSeriesUid_ = "";
        private String clientId_ = "";
        private String originSampleUid_ = "";
        private Internal.ProtobufList<SeriesValue> seriesValues_ = emptyProtobufList();

        public interface SubTypeDataListOrBuilder extends MessageLiteOrBuilder {
            SubTypeDataValue getValues(int i);

            int getValuesCount();

            List<SubTypeDataValue> getValuesList();
        }

        private DataPoint() {
        }

        public static final class SubTypeDataList extends GeneratedMessageLite<SubTypeDataList, Builder> implements SubTypeDataListOrBuilder {
            private static final SubTypeDataList DEFAULT_INSTANCE;
            private static volatile Parser<SubTypeDataList> PARSER = null;
            public static final int VALUES_FIELD_NUMBER = 1;
            private Internal.ProtobufList<SubTypeDataValue> values_ = emptyProtobufList();

            private SubTypeDataList() {
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
            public List<SubTypeDataValue> getValuesList() {
                return this.values_;
            }

            public List<? extends SubTypeDataValueOrBuilder> getValuesOrBuilderList() {
                return this.values_;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
            public int getValuesCount() {
                return this.values_.size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
            public SubTypeDataValue getValues(int index) {
                return this.values_.get(index);
            }

            public SubTypeDataValueOrBuilder getValuesOrBuilder(int index) {
                return this.values_.get(index);
            }

            private void ensureValuesIsMutable() {
                Internal.ProtobufList<SubTypeDataValue> tmp = this.values_;
                if (!tmp.isModifiable()) {
                    this.values_ = GeneratedMessageLite.mutableCopy(tmp);
                }
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void setValues(int index, SubTypeDataValue value) {
                value.getClass();
                ensureValuesIsMutable();
                this.values_.set(index, value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addValues(SubTypeDataValue value) {
                value.getClass();
                ensureValuesIsMutable();
                this.values_.add(value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addValues(int index, SubTypeDataValue value) {
                value.getClass();
                ensureValuesIsMutable();
                this.values_.add(index, value);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void addAllValues(Iterable<? extends SubTypeDataValue> values) {
                ensureValuesIsMutable();
                AbstractMessageLite.addAll(values, this.values_);
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void clearValues() {
                this.values_ = emptyProtobufList();
            }

            /* JADX INFO: Access modifiers changed from: private */
            public void removeValues(int index) {
                ensureValuesIsMutable();
                this.values_.remove(index);
            }

            public static SubTypeDataList parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static SubTypeDataList parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static SubTypeDataList parseFrom(ByteString data) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static SubTypeDataList parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static SubTypeDataList parseFrom(byte[] data) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
            }

            public static SubTypeDataList parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
            }

            public static SubTypeDataList parseFrom(InputStream input) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static SubTypeDataList parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static SubTypeDataList parseDelimitedFrom(InputStream input) throws IOException {
                return (SubTypeDataList) parseDelimitedFrom(DEFAULT_INSTANCE, input);
            }

            public static SubTypeDataList parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (SubTypeDataList) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static SubTypeDataList parseFrom(CodedInputStream input) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
            }

            public static SubTypeDataList parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
                return (SubTypeDataList) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
            }

            public static Builder newBuilder() {
                return DEFAULT_INSTANCE.createBuilder();
            }

            public static Builder newBuilder(SubTypeDataList prototype) {
                return DEFAULT_INSTANCE.createBuilder(prototype);
            }

            public static final class Builder extends GeneratedMessageLite.Builder<SubTypeDataList, Builder> implements SubTypeDataListOrBuilder {
                private Builder() {
                    super(SubTypeDataList.DEFAULT_INSTANCE);
                }

                @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
                public List<SubTypeDataValue> getValuesList() {
                    return Collections.unmodifiableList(((SubTypeDataList) this.instance).getValuesList());
                }

                @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
                public int getValuesCount() {
                    return ((SubTypeDataList) this.instance).getValuesCount();
                }

                @Override // androidx.health.platform.client.proto.DataProto.DataPoint.SubTypeDataListOrBuilder
                public SubTypeDataValue getValues(int index) {
                    return ((SubTypeDataList) this.instance).getValues(index);
                }

                public Builder setValues(int index, SubTypeDataValue value) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).setValues(index, value);
                    return this;
                }

                public Builder setValues(int index, SubTypeDataValue.Builder builderForValue) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).setValues(index, builderForValue.build());
                    return this;
                }

                public Builder addValues(SubTypeDataValue value) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(value);
                    return this;
                }

                public Builder addValues(int index, SubTypeDataValue value) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(index, value);
                    return this;
                }

                public Builder addValues(SubTypeDataValue.Builder builderForValue) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(builderForValue.build());
                    return this;
                }

                public Builder addValues(int index, SubTypeDataValue.Builder builderForValue) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addValues(index, builderForValue.build());
                    return this;
                }

                public Builder addAllValues(Iterable<? extends SubTypeDataValue> values) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).addAllValues(values);
                    return this;
                }

                public Builder clearValues() {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).clearValues();
                    return this;
                }

                public Builder removeValues(int index) {
                    copyOnWrite();
                    ((SubTypeDataList) this.instance).removeValues(index);
                    return this;
                }
            }

            @Override // androidx.health.platform.client.proto.GeneratedMessageLite
            protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
                switch (method) {
                    case NEW_MUTABLE_INSTANCE:
                        return new SubTypeDataList();
                    case NEW_BUILDER:
                        return new Builder();
                    case BUILD_MESSAGE_INFO:
                        Object[] objects = {"values_", SubTypeDataValue.class};
                        return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objects);
                    case GET_DEFAULT_INSTANCE:
                        return DEFAULT_INSTANCE;
                    case GET_PARSER:
                        Parser<SubTypeDataList> parser = PARSER;
                        if (parser == null) {
                            synchronized (SubTypeDataList.class) {
                                parser = PARSER;
                                if (parser == null) {
                                    parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                    PARSER = parser;
                                }
                            }
                        }
                        return parser;
                    case GET_MEMOIZED_IS_INITIALIZED:
                        return (byte) 1;
                    case SET_MEMOIZED_IS_INITIALIZED:
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            static {
                SubTypeDataList defaultInstance = new SubTypeDataList();
                DEFAULT_INSTANCE = defaultInstance;
                GeneratedMessageLite.registerDefaultInstance(SubTypeDataList.class, defaultInstance);
            }

            public static SubTypeDataList getDefaultInstance() {
                return DEFAULT_INSTANCE;
            }

            public static Parser<SubTypeDataList> parser() {
                return DEFAULT_INSTANCE.getParserForType();
            }
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public DataType getDataType() {
            return this.dataType_ == null ? DataType.getDefaultInstance() : this.dataType_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(DataType value) {
            value.getClass();
            this.dataType_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataType(DataType value) {
            value.getClass();
            if (this.dataType_ != null && this.dataType_ != DataType.getDefaultInstance()) {
                this.dataType_ = DataType.newBuilder(this.dataType_).mergeFrom((DataType.Builder) value).buildPartial();
            } else {
                this.dataType_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = null;
            this.bitField0_ &= -2;
        }

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean containsValues(String key) {
            key.getClass();
            return internalGetValues().containsKey(key);
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Value getValuesOrDefault(String key, Value defaultValue) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Value getValuesOrThrow(String key) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getUid() {
            return this.uid_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public ByteString getUidBytes() {
            return ByteString.copyFromUtf8(this.uid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUid(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.uid_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUid() {
            this.bitField0_ &= -3;
            this.uid_ = getDefaultInstance().getUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUidBytes(ByteString value) {
            this.uid_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasOriginSeriesUid() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getOriginSeriesUid() {
            return this.originSeriesUid_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public ByteString getOriginSeriesUidBytes() {
            return ByteString.copyFromUtf8(this.originSeriesUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSeriesUid(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.originSeriesUid_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOriginSeriesUid() {
            this.bitField0_ &= -5;
            this.originSeriesUid_ = getDefaultInstance().getOriginSeriesUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSeriesUidBytes(ByteString value) {
            this.originSeriesUid_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasDataOrigin() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public DataOrigin getDataOrigin() {
            return this.dataOrigin_ == null ? DataOrigin.getDefaultInstance() : this.dataOrigin_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOrigin(DataOrigin value) {
            value.getClass();
            this.dataOrigin_ = value;
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataOrigin(DataOrigin value) {
            value.getClass();
            if (this.dataOrigin_ != null && this.dataOrigin_ != DataOrigin.getDefaultInstance()) {
                this.dataOrigin_ = DataOrigin.newBuilder(this.dataOrigin_).mergeFrom((DataOrigin.Builder) value).buildPartial();
            } else {
                this.dataOrigin_ = value;
            }
            this.bitField0_ |= 8;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOrigin() {
            this.dataOrigin_ = null;
            this.bitField0_ &= -9;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasZoneOffsetSeconds() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getZoneOffsetSeconds() {
            return this.zoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setZoneOffsetSeconds(int value) {
            this.bitField0_ |= 16;
            this.zoneOffsetSeconds_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearZoneOffsetSeconds() {
            this.bitField0_ &= -17;
            this.zoneOffsetSeconds_ = 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasUpdateTimeMillis() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getUpdateTimeMillis() {
            return this.updateTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpdateTimeMillis(long value) {
            this.bitField0_ |= 32;
            this.updateTimeMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpdateTimeMillis() {
            this.bitField0_ &= -33;
            this.updateTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasInstantTimeMillis() {
            return (this.bitField0_ & 64) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getInstantTimeMillis() {
            return this.instantTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setInstantTimeMillis(long value) {
            this.bitField0_ |= 64;
            this.instantTimeMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearInstantTimeMillis() {
            this.bitField0_ &= -65;
            this.instantTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasStartTimeMillis() {
            return (this.bitField0_ & 128) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getStartTimeMillis() {
            return this.startTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeMillis(long value) {
            this.bitField0_ |= 128;
            this.startTimeMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeMillis() {
            this.bitField0_ &= -129;
            this.startTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasEndTimeMillis() {
            return (this.bitField0_ & 256) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getEndTimeMillis() {
            return this.endTimeMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTimeMillis(long value) {
            this.bitField0_ |= 256;
            this.endTimeMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTimeMillis() {
            this.bitField0_ &= -257;
            this.endTimeMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasClientId() {
            return (this.bitField0_ & 512) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getClientId() {
            return this.clientId_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public ByteString getClientIdBytes() {
            return ByteString.copyFromUtf8(this.clientId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientId(String value) {
            value.getClass();
            this.bitField0_ |= 512;
            this.clientId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientId() {
            this.bitField0_ &= -513;
            this.clientId_ = getDefaultInstance().getClientId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientIdBytes(ByteString value) {
            this.clientId_ = value.toStringUtf8();
            this.bitField0_ |= 512;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasClientVersion() {
            return (this.bitField0_ & 1024) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public long getClientVersion() {
            return this.clientVersion_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientVersion(long value) {
            this.bitField0_ |= 1024;
            this.clientVersion_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientVersion() {
            this.bitField0_ &= -1025;
            this.clientVersion_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasDevice() {
            return (this.bitField0_ & 2048) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Device getDevice() {
            return this.device_ == null ? Device.getDefaultInstance() : this.device_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDevice(Device value) {
            value.getClass();
            this.device_ = value;
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDevice(Device value) {
            value.getClass();
            if (this.device_ != null && this.device_ != Device.getDefaultInstance()) {
                this.device_ = Device.newBuilder(this.device_).mergeFrom((Device.Builder) value).buildPartial();
            } else {
                this.device_ = value;
            }
            this.bitField0_ |= 2048;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDevice() {
            this.device_ = null;
            this.bitField0_ &= -2049;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasOriginSampleUid() {
            return (this.bitField0_ & 4096) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public String getOriginSampleUid() {
            return this.originSampleUid_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public ByteString getOriginSampleUidBytes() {
            return ByteString.copyFromUtf8(this.originSampleUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSampleUid(String value) {
            value.getClass();
            this.bitField0_ |= 4096;
            this.originSampleUid_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearOriginSampleUid() {
            this.bitField0_ &= -4097;
            this.originSampleUid_ = getDefaultInstance().getOriginSampleUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOriginSampleUidBytes(ByteString value) {
            this.originSampleUid_ = value.toStringUtf8();
            this.bitField0_ |= 4096;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public List<SeriesValue> getSeriesValuesList() {
            return this.seriesValues_;
        }

        public List<? extends SeriesValueOrBuilder> getSeriesValuesOrBuilderList() {
            return this.seriesValues_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getSeriesValuesCount() {
            return this.seriesValues_.size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public SeriesValue getSeriesValues(int index) {
            return this.seriesValues_.get(index);
        }

        public SeriesValueOrBuilder getSeriesValuesOrBuilder(int index) {
            return this.seriesValues_.get(index);
        }

        private void ensureSeriesValuesIsMutable() {
            Internal.ProtobufList<SeriesValue> tmp = this.seriesValues_;
            if (!tmp.isModifiable()) {
                this.seriesValues_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSeriesValues(int index, SeriesValue value) {
            value.getClass();
            ensureSeriesValuesIsMutable();
            this.seriesValues_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSeriesValues(SeriesValue value) {
            value.getClass();
            ensureSeriesValuesIsMutable();
            this.seriesValues_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addSeriesValues(int index, SeriesValue value) {
            value.getClass();
            ensureSeriesValuesIsMutable();
            this.seriesValues_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllSeriesValues(Iterable<? extends SeriesValue> values) {
            ensureSeriesValuesIsMutable();
            AbstractMessageLite.addAll(values, this.seriesValues_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSeriesValues() {
            this.seriesValues_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeSeriesValues(int index) {
            ensureSeriesValuesIsMutable();
            this.seriesValues_.remove(index);
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasMin() {
            return (this.bitField0_ & 8192) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public AggregatedValue getMin() {
            return this.min_ == null ? AggregatedValue.getDefaultInstance() : this.min_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMin(AggregatedValue value) {
            value.getClass();
            this.min_ = value;
            this.bitField0_ |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMin(AggregatedValue value) {
            value.getClass();
            if (this.min_ != null && this.min_ != AggregatedValue.getDefaultInstance()) {
                this.min_ = AggregatedValue.newBuilder(this.min_).mergeFrom((AggregatedValue.Builder) value).buildPartial();
            } else {
                this.min_ = value;
            }
            this.bitField0_ |= 8192;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMin() {
            this.min_ = null;
            this.bitField0_ &= -8193;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasMax() {
            return (this.bitField0_ & 16384) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public AggregatedValue getMax() {
            return this.max_ == null ? AggregatedValue.getDefaultInstance() : this.max_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMax(AggregatedValue value) {
            value.getClass();
            this.max_ = value;
            this.bitField0_ |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeMax(AggregatedValue value) {
            value.getClass();
            if (this.max_ != null && this.max_ != AggregatedValue.getDefaultInstance()) {
                this.max_ = AggregatedValue.newBuilder(this.max_).mergeFrom((AggregatedValue.Builder) value).buildPartial();
            } else {
                this.max_ = value;
            }
            this.bitField0_ |= 16384;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMax() {
            this.max_ = null;
            this.bitField0_ &= -16385;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasAvg() {
            return (this.bitField0_ & 32768) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public AggregatedValue getAvg() {
            return this.avg_ == null ? AggregatedValue.getDefaultInstance() : this.avg_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAvg(AggregatedValue value) {
            value.getClass();
            this.avg_ = value;
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeAvg(AggregatedValue value) {
            value.getClass();
            if (this.avg_ != null && this.avg_ != AggregatedValue.getDefaultInstance()) {
                this.avg_ = AggregatedValue.newBuilder(this.avg_).mergeFrom((AggregatedValue.Builder) value).buildPartial();
            } else {
                this.avg_ = value;
            }
            this.bitField0_ |= 32768;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAvg() {
            this.avg_ = null;
            this.bitField0_ &= -32769;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasStartZoneOffsetSeconds() {
            return (this.bitField0_ & 65536) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getStartZoneOffsetSeconds() {
            return this.startZoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartZoneOffsetSeconds(int value) {
            this.bitField0_ |= 65536;
            this.startZoneOffsetSeconds_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartZoneOffsetSeconds() {
            this.bitField0_ &= -65537;
            this.startZoneOffsetSeconds_ = 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasEndZoneOffsetSeconds() {
            return (this.bitField0_ & 131072) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getEndZoneOffsetSeconds() {
            return this.endZoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndZoneOffsetSeconds(int value) {
            this.bitField0_ |= 131072;
            this.endZoneOffsetSeconds_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndZoneOffsetSeconds() {
            this.bitField0_ &= -131073;
            this.endZoneOffsetSeconds_ = 0;
        }

        private static final class SubTypeDataListsDefaultEntryHolder {
            static final MapEntryLite<String, SubTypeDataList> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, SubTypeDataList.getDefaultInstance());

            private SubTypeDataListsDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, SubTypeDataList> internalGetSubTypeDataLists() {
            return this.subTypeDataLists_;
        }

        private MapFieldLite<String, SubTypeDataList> internalGetMutableSubTypeDataLists() {
            if (!this.subTypeDataLists_.isMutable()) {
                this.subTypeDataLists_ = this.subTypeDataLists_.mutableCopy();
            }
            return this.subTypeDataLists_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getSubTypeDataListsCount() {
            return internalGetSubTypeDataLists().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean containsSubTypeDataLists(String key) {
            key.getClass();
            return internalGetSubTypeDataLists().containsKey(key);
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        @Deprecated
        public Map<String, SubTypeDataList> getSubTypeDataLists() {
            return getSubTypeDataListsMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public Map<String, SubTypeDataList> getSubTypeDataListsMap() {
            return Collections.unmodifiableMap(internalGetSubTypeDataLists());
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public SubTypeDataList getSubTypeDataListsOrDefault(String key, SubTypeDataList defaultValue) {
            key.getClass();
            Map<String, SubTypeDataList> map = internalGetSubTypeDataLists();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public SubTypeDataList getSubTypeDataListsOrThrow(String key) {
            key.getClass();
            Map<String, SubTypeDataList> map = internalGetSubTypeDataLists();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, SubTypeDataList> getMutableSubTypeDataListsMap() {
            return internalGetMutableSubTypeDataLists();
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public boolean hasRecordingMethod() {
            return (this.bitField0_ & 262144) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
        public int getRecordingMethod() {
            return this.recordingMethod_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRecordingMethod(int value) {
            this.bitField0_ |= 262144;
            this.recordingMethod_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRecordingMethod() {
            this.bitField0_ &= -262145;
            this.recordingMethod_ = 0;
        }

        public static DataPoint parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataPoint parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataPoint parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataPoint parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataPoint parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataPoint parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataPoint parseFrom(InputStream input) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataPoint parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataPoint parseDelimitedFrom(InputStream input) throws IOException {
            return (DataPoint) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DataPoint parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataPoint) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataPoint parseFrom(CodedInputStream input) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataPoint parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataPoint) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataPoint prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataPoint, Builder> implements DataPointOrBuilder {
            private Builder() {
                super(DataPoint.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasDataType() {
                return ((DataPoint) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public DataType getDataType() {
                return ((DataPoint) this.instance).getDataType();
            }

            public Builder setDataType(DataType value) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataType(value);
                return this;
            }

            public Builder setDataType(DataType.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataType(builderForValue.build());
                return this;
            }

            public Builder mergeDataType(DataType value) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeDataType(value);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((DataPoint) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getValuesCount() {
                return ((DataPoint) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean containsValues(String key) {
                key.getClass();
                return ((DataPoint) this.instance).getValuesMap().containsKey(key);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String key) {
                key.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().remove(key);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((DataPoint) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Value getValuesOrDefault(String key, Value defaultValue) {
                key.getClass();
                Map<String, Value> map = ((DataPoint) this.instance).getValuesMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Value getValuesOrThrow(String key) {
                key.getClass();
                Map<String, Value> map = ((DataPoint) this.instance).getValuesMap();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder putValues(String key, Value value) {
                key.getClass();
                value.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().put(key, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> values) {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableValuesMap().putAll(values);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasUid() {
                return ((DataPoint) this.instance).hasUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getUid() {
                return ((DataPoint) this.instance).getUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getUidBytes() {
                return ((DataPoint) this.instance).getUidBytes();
            }

            public Builder setUid(String value) {
                copyOnWrite();
                ((DataPoint) this.instance).setUid(value);
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((DataPoint) this.instance).clearUid();
                return this;
            }

            public Builder setUidBytes(ByteString value) {
                copyOnWrite();
                ((DataPoint) this.instance).setUidBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasOriginSeriesUid() {
                return ((DataPoint) this.instance).hasOriginSeriesUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getOriginSeriesUid() {
                return ((DataPoint) this.instance).getOriginSeriesUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getOriginSeriesUidBytes() {
                return ((DataPoint) this.instance).getOriginSeriesUidBytes();
            }

            public Builder setOriginSeriesUid(String value) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSeriesUid(value);
                return this;
            }

            public Builder clearOriginSeriesUid() {
                copyOnWrite();
                ((DataPoint) this.instance).clearOriginSeriesUid();
                return this;
            }

            public Builder setOriginSeriesUidBytes(ByteString value) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSeriesUidBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasDataOrigin() {
                return ((DataPoint) this.instance).hasDataOrigin();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public DataOrigin getDataOrigin() {
                return ((DataPoint) this.instance).getDataOrigin();
            }

            public Builder setDataOrigin(DataOrigin value) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataOrigin(value);
                return this;
            }

            public Builder setDataOrigin(DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setDataOrigin(builderForValue.build());
                return this;
            }

            public Builder mergeDataOrigin(DataOrigin value) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeDataOrigin(value);
                return this;
            }

            public Builder clearDataOrigin() {
                copyOnWrite();
                ((DataPoint) this.instance).clearDataOrigin();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasZoneOffsetSeconds() {
                return ((DataPoint) this.instance).hasZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getZoneOffsetSeconds() {
                return ((DataPoint) this.instance).getZoneOffsetSeconds();
            }

            public Builder setZoneOffsetSeconds(int value) {
                copyOnWrite();
                ((DataPoint) this.instance).setZoneOffsetSeconds(value);
                return this;
            }

            public Builder clearZoneOffsetSeconds() {
                copyOnWrite();
                ((DataPoint) this.instance).clearZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasUpdateTimeMillis() {
                return ((DataPoint) this.instance).hasUpdateTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getUpdateTimeMillis() {
                return ((DataPoint) this.instance).getUpdateTimeMillis();
            }

            public Builder setUpdateTimeMillis(long value) {
                copyOnWrite();
                ((DataPoint) this.instance).setUpdateTimeMillis(value);
                return this;
            }

            public Builder clearUpdateTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearUpdateTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasInstantTimeMillis() {
                return ((DataPoint) this.instance).hasInstantTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getInstantTimeMillis() {
                return ((DataPoint) this.instance).getInstantTimeMillis();
            }

            public Builder setInstantTimeMillis(long value) {
                copyOnWrite();
                ((DataPoint) this.instance).setInstantTimeMillis(value);
                return this;
            }

            public Builder clearInstantTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearInstantTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasStartTimeMillis() {
                return ((DataPoint) this.instance).hasStartTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getStartTimeMillis() {
                return ((DataPoint) this.instance).getStartTimeMillis();
            }

            public Builder setStartTimeMillis(long value) {
                copyOnWrite();
                ((DataPoint) this.instance).setStartTimeMillis(value);
                return this;
            }

            public Builder clearStartTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearStartTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasEndTimeMillis() {
                return ((DataPoint) this.instance).hasEndTimeMillis();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getEndTimeMillis() {
                return ((DataPoint) this.instance).getEndTimeMillis();
            }

            public Builder setEndTimeMillis(long value) {
                copyOnWrite();
                ((DataPoint) this.instance).setEndTimeMillis(value);
                return this;
            }

            public Builder clearEndTimeMillis() {
                copyOnWrite();
                ((DataPoint) this.instance).clearEndTimeMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasClientId() {
                return ((DataPoint) this.instance).hasClientId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getClientId() {
                return ((DataPoint) this.instance).getClientId();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getClientIdBytes() {
                return ((DataPoint) this.instance).getClientIdBytes();
            }

            public Builder setClientId(String value) {
                copyOnWrite();
                ((DataPoint) this.instance).setClientId(value);
                return this;
            }

            public Builder clearClientId() {
                copyOnWrite();
                ((DataPoint) this.instance).clearClientId();
                return this;
            }

            public Builder setClientIdBytes(ByteString value) {
                copyOnWrite();
                ((DataPoint) this.instance).setClientIdBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasClientVersion() {
                return ((DataPoint) this.instance).hasClientVersion();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public long getClientVersion() {
                return ((DataPoint) this.instance).getClientVersion();
            }

            public Builder setClientVersion(long value) {
                copyOnWrite();
                ((DataPoint) this.instance).setClientVersion(value);
                return this;
            }

            public Builder clearClientVersion() {
                copyOnWrite();
                ((DataPoint) this.instance).clearClientVersion();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasDevice() {
                return ((DataPoint) this.instance).hasDevice();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Device getDevice() {
                return ((DataPoint) this.instance).getDevice();
            }

            public Builder setDevice(Device value) {
                copyOnWrite();
                ((DataPoint) this.instance).setDevice(value);
                return this;
            }

            public Builder setDevice(Device.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setDevice(builderForValue.build());
                return this;
            }

            public Builder mergeDevice(Device value) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeDevice(value);
                return this;
            }

            public Builder clearDevice() {
                copyOnWrite();
                ((DataPoint) this.instance).clearDevice();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasOriginSampleUid() {
                return ((DataPoint) this.instance).hasOriginSampleUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public String getOriginSampleUid() {
                return ((DataPoint) this.instance).getOriginSampleUid();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public ByteString getOriginSampleUidBytes() {
                return ((DataPoint) this.instance).getOriginSampleUidBytes();
            }

            public Builder setOriginSampleUid(String value) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSampleUid(value);
                return this;
            }

            public Builder clearOriginSampleUid() {
                copyOnWrite();
                ((DataPoint) this.instance).clearOriginSampleUid();
                return this;
            }

            public Builder setOriginSampleUidBytes(ByteString value) {
                copyOnWrite();
                ((DataPoint) this.instance).setOriginSampleUidBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public List<SeriesValue> getSeriesValuesList() {
                return Collections.unmodifiableList(((DataPoint) this.instance).getSeriesValuesList());
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getSeriesValuesCount() {
                return ((DataPoint) this.instance).getSeriesValuesCount();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public SeriesValue getSeriesValues(int index) {
                return ((DataPoint) this.instance).getSeriesValues(index);
            }

            public Builder setSeriesValues(int index, SeriesValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).setSeriesValues(index, value);
                return this;
            }

            public Builder setSeriesValues(int index, SeriesValue.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setSeriesValues(index, builderForValue.build());
                return this;
            }

            public Builder addSeriesValues(SeriesValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(value);
                return this;
            }

            public Builder addSeriesValues(int index, SeriesValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(index, value);
                return this;
            }

            public Builder addSeriesValues(SeriesValue.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(builderForValue.build());
                return this;
            }

            public Builder addSeriesValues(int index, SeriesValue.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).addSeriesValues(index, builderForValue.build());
                return this;
            }

            public Builder addAllSeriesValues(Iterable<? extends SeriesValue> values) {
                copyOnWrite();
                ((DataPoint) this.instance).addAllSeriesValues(values);
                return this;
            }

            public Builder clearSeriesValues() {
                copyOnWrite();
                ((DataPoint) this.instance).clearSeriesValues();
                return this;
            }

            public Builder removeSeriesValues(int index) {
                copyOnWrite();
                ((DataPoint) this.instance).removeSeriesValues(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasMin() {
                return ((DataPoint) this.instance).hasMin();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public AggregatedValue getMin() {
                return ((DataPoint) this.instance).getMin();
            }

            public Builder setMin(AggregatedValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).setMin(value);
                return this;
            }

            public Builder setMin(AggregatedValue.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setMin(builderForValue.build());
                return this;
            }

            public Builder mergeMin(AggregatedValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeMin(value);
                return this;
            }

            public Builder clearMin() {
                copyOnWrite();
                ((DataPoint) this.instance).clearMin();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasMax() {
                return ((DataPoint) this.instance).hasMax();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public AggregatedValue getMax() {
                return ((DataPoint) this.instance).getMax();
            }

            public Builder setMax(AggregatedValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).setMax(value);
                return this;
            }

            public Builder setMax(AggregatedValue.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setMax(builderForValue.build());
                return this;
            }

            public Builder mergeMax(AggregatedValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeMax(value);
                return this;
            }

            public Builder clearMax() {
                copyOnWrite();
                ((DataPoint) this.instance).clearMax();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasAvg() {
                return ((DataPoint) this.instance).hasAvg();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public AggregatedValue getAvg() {
                return ((DataPoint) this.instance).getAvg();
            }

            public Builder setAvg(AggregatedValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).setAvg(value);
                return this;
            }

            public Builder setAvg(AggregatedValue.Builder builderForValue) {
                copyOnWrite();
                ((DataPoint) this.instance).setAvg(builderForValue.build());
                return this;
            }

            public Builder mergeAvg(AggregatedValue value) {
                copyOnWrite();
                ((DataPoint) this.instance).mergeAvg(value);
                return this;
            }

            public Builder clearAvg() {
                copyOnWrite();
                ((DataPoint) this.instance).clearAvg();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasStartZoneOffsetSeconds() {
                return ((DataPoint) this.instance).hasStartZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getStartZoneOffsetSeconds() {
                return ((DataPoint) this.instance).getStartZoneOffsetSeconds();
            }

            public Builder setStartZoneOffsetSeconds(int value) {
                copyOnWrite();
                ((DataPoint) this.instance).setStartZoneOffsetSeconds(value);
                return this;
            }

            public Builder clearStartZoneOffsetSeconds() {
                copyOnWrite();
                ((DataPoint) this.instance).clearStartZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasEndZoneOffsetSeconds() {
                return ((DataPoint) this.instance).hasEndZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getEndZoneOffsetSeconds() {
                return ((DataPoint) this.instance).getEndZoneOffsetSeconds();
            }

            public Builder setEndZoneOffsetSeconds(int value) {
                copyOnWrite();
                ((DataPoint) this.instance).setEndZoneOffsetSeconds(value);
                return this;
            }

            public Builder clearEndZoneOffsetSeconds() {
                copyOnWrite();
                ((DataPoint) this.instance).clearEndZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getSubTypeDataListsCount() {
                return ((DataPoint) this.instance).getSubTypeDataListsMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean containsSubTypeDataLists(String key) {
                key.getClass();
                return ((DataPoint) this.instance).getSubTypeDataListsMap().containsKey(key);
            }

            public Builder clearSubTypeDataLists() {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().clear();
                return this;
            }

            public Builder removeSubTypeDataLists(String key) {
                key.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().remove(key);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            @Deprecated
            public Map<String, SubTypeDataList> getSubTypeDataLists() {
                return getSubTypeDataListsMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public Map<String, SubTypeDataList> getSubTypeDataListsMap() {
                return Collections.unmodifiableMap(((DataPoint) this.instance).getSubTypeDataListsMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public SubTypeDataList getSubTypeDataListsOrDefault(String key, SubTypeDataList defaultValue) {
                key.getClass();
                Map<String, SubTypeDataList> map = ((DataPoint) this.instance).getSubTypeDataListsMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public SubTypeDataList getSubTypeDataListsOrThrow(String key) {
                key.getClass();
                Map<String, SubTypeDataList> map = ((DataPoint) this.instance).getSubTypeDataListsMap();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder putSubTypeDataLists(String key, SubTypeDataList value) {
                key.getClass();
                value.getClass();
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().put(key, value);
                return this;
            }

            public Builder putAllSubTypeDataLists(Map<String, SubTypeDataList> values) {
                copyOnWrite();
                ((DataPoint) this.instance).getMutableSubTypeDataListsMap().putAll(values);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public boolean hasRecordingMethod() {
                return ((DataPoint) this.instance).hasRecordingMethod();
            }

            @Override // androidx.health.platform.client.proto.DataProto.DataPointOrBuilder
            public int getRecordingMethod() {
                return ((DataPoint) this.instance).getRecordingMethod();
            }

            public Builder setRecordingMethod(int value) {
                copyOnWrite();
                ((DataPoint) this.instance).setRecordingMethod(value);
                return this;
            }

            public Builder clearRecordingMethod() {
                copyOnWrite();
                ((DataPoint) this.instance).clearRecordingMethod();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new DataPoint();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataType_", "values_", ValuesDefaultEntryHolder.defaultEntry, "uid_", "originSeriesUid_", "dataOrigin_", "zoneOffsetSeconds_", "updateTimeMillis_", "instantTimeMillis_", "startTimeMillis_", "endTimeMillis_", "clientId_", "clientVersion_", "device_", "originSampleUid_", "seriesValues_", SeriesValue.class, "min_", "max_", "avg_", "startZoneOffsetSeconds_", "endZoneOffsetSeconds_", "subTypeDataLists_", SubTypeDataListsDefaultEntryHolder.defaultEntry, "recordingMethod_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0016\u0000\u0001\u0001\u0017\u0016\u0002\u0001\u0000\u0001ဉ\u0000\u00022\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဉ\u0003\u0006င\u0004\u0007ဂ\u0005\bဂ\u0006\tဂ\u0007\nဂ\b\u000bဈ\t\fဂ\n\rဉ\u000b\u000eဈ\f\u000f\u001b\u0010ဉ\r\u0011ဉ\u000e\u0012ဉ\u000f\u0013င\u0010\u0014င\u0011\u00162\u0017င\u0012", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DataPoint> parser = PARSER;
                    if (parser == null) {
                        synchronized (DataPoint.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            DataPoint defaultInstance = new DataPoint();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(DataPoint.class, defaultInstance);
        }

        public static DataPoint getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataPoint> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregatedValue extends GeneratedMessageLite<AggregatedValue, Builder> implements AggregatedValueOrBuilder {
        private static final AggregatedValue DEFAULT_INSTANCE;
        private static volatile Parser<AggregatedValue> PARSER = null;
        public static final int VALUES_FIELD_NUMBER = 1;
        private MapFieldLite<String, Value> values_ = MapFieldLite.emptyMapField();

        private AggregatedValue() {
        }

        private static final class ValuesDefaultEntryHolder {
            static final MapEntryLite<String, Value> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.MESSAGE, Value.getDefaultInstance());

            private ValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Value> internalGetValues() {
            return this.values_;
        }

        private MapFieldLite<String, Value> internalGetMutableValues() {
            if (!this.values_.isMutable()) {
                this.values_ = this.values_.mutableCopy();
            }
            return this.values_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public int getValuesCount() {
            return internalGetValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public boolean containsValues(String key) {
            key.getClass();
            return internalGetValues().containsKey(key);
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        @Deprecated
        public Map<String, Value> getValues() {
            return getValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public Map<String, Value> getValuesMap() {
            return Collections.unmodifiableMap(internalGetValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public Value getValuesOrDefault(String key, Value defaultValue) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            return map.containsKey(key) ? map.get(key) : defaultValue;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
        public Value getValuesOrThrow(String key) {
            key.getClass();
            Map<String, Value> map = internalGetValues();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Value> getMutableValuesMap() {
            return internalGetMutableValues();
        }

        public static AggregatedValue parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregatedValue parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregatedValue parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregatedValue parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregatedValue parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregatedValue parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregatedValue parseFrom(InputStream input) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregatedValue parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregatedValue parseDelimitedFrom(InputStream input) throws IOException {
            return (AggregatedValue) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregatedValue parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregatedValue) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregatedValue parseFrom(CodedInputStream input) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregatedValue parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregatedValue) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregatedValue prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregatedValue, Builder> implements AggregatedValueOrBuilder {
            private Builder() {
                super(AggregatedValue.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public int getValuesCount() {
                return ((AggregatedValue) this.instance).getValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public boolean containsValues(String key) {
                key.getClass();
                return ((AggregatedValue) this.instance).getValuesMap().containsKey(key);
            }

            public Builder clearValues() {
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().clear();
                return this;
            }

            public Builder removeValues(String key) {
                key.getClass();
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().remove(key);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            @Deprecated
            public Map<String, Value> getValues() {
                return getValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public Map<String, Value> getValuesMap() {
                return Collections.unmodifiableMap(((AggregatedValue) this.instance).getValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public Value getValuesOrDefault(String key, Value defaultValue) {
                key.getClass();
                Map<String, Value> map = ((AggregatedValue) this.instance).getValuesMap();
                return map.containsKey(key) ? map.get(key) : defaultValue;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregatedValueOrBuilder
            public Value getValuesOrThrow(String key) {
                key.getClass();
                Map<String, Value> map = ((AggregatedValue) this.instance).getValuesMap();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                }
                return map.get(key);
            }

            public Builder putValues(String key, Value value) {
                key.getClass();
                value.getClass();
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().put(key, value);
                return this;
            }

            public Builder putAllValues(Map<String, Value> values) {
                copyOnWrite();
                ((AggregatedValue) this.instance).getMutableValuesMap().putAll(values);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new AggregatedValue();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"values_", ValuesDefaultEntryHolder.defaultEntry};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u00012", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<AggregatedValue> parser = PARSER;
                    if (parser == null) {
                        synchronized (AggregatedValue.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AggregatedValue defaultInstance = new AggregatedValue();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(AggregatedValue.class, defaultInstance);
        }

        public static AggregatedValue getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregatedValue> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateDataRow extends GeneratedMessageLite<AggregateDataRow, Builder> implements AggregateDataRowOrBuilder {
        public static final int DATA_ORIGINS_FIELD_NUMBER = 8;
        private static final AggregateDataRow DEFAULT_INSTANCE;
        public static final int DOUBLE_VALUES_FIELD_NUMBER = 6;
        public static final int END_LOCAL_DATE_TIME_FIELD_NUMBER = 4;
        public static final int END_TIME_EPOCH_MS_FIELD_NUMBER = 2;
        public static final int LONG_VALUES_FIELD_NUMBER = 7;
        private static volatile Parser<AggregateDataRow> PARSER = null;
        public static final int START_LOCAL_DATE_TIME_FIELD_NUMBER = 3;
        public static final int START_TIME_EPOCH_MS_FIELD_NUMBER = 1;
        public static final int ZONE_OFFSET_SECONDS_FIELD_NUMBER = 5;
        private int bitField0_;
        private long endTimeEpochMs_;
        private long startTimeEpochMs_;
        private int zoneOffsetSeconds_;
        private MapFieldLite<String, Double> doubleValues_ = MapFieldLite.emptyMapField();
        private MapFieldLite<String, Long> longValues_ = MapFieldLite.emptyMapField();
        private String startLocalDateTime_ = "";
        private String endLocalDateTime_ = "";
        private Internal.ProtobufList<DataOrigin> dataOrigins_ = emptyProtobufList();

        private AggregateDataRow() {
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasStartTimeEpochMs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public long getStartTimeEpochMs() {
            return this.startTimeEpochMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartTimeEpochMs(long value) {
            this.bitField0_ |= 1;
            this.startTimeEpochMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartTimeEpochMs() {
            this.bitField0_ &= -2;
            this.startTimeEpochMs_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasEndTimeEpochMs() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public long getEndTimeEpochMs() {
            return this.endTimeEpochMs_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndTimeEpochMs(long value) {
            this.bitField0_ |= 2;
            this.endTimeEpochMs_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndTimeEpochMs() {
            this.bitField0_ &= -3;
            this.endTimeEpochMs_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasStartLocalDateTime() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public String getStartLocalDateTime() {
            return this.startLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public ByteString getStartLocalDateTimeBytes() {
            return ByteString.copyFromUtf8(this.startLocalDateTime_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartLocalDateTime(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.startLocalDateTime_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearStartLocalDateTime() {
            this.bitField0_ &= -5;
            this.startLocalDateTime_ = getDefaultInstance().getStartLocalDateTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setStartLocalDateTimeBytes(ByteString value) {
            this.startLocalDateTime_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasEndLocalDateTime() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public String getEndLocalDateTime() {
            return this.endLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public ByteString getEndLocalDateTimeBytes() {
            return ByteString.copyFromUtf8(this.endLocalDateTime_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndLocalDateTime(String value) {
            value.getClass();
            this.bitField0_ |= 8;
            this.endLocalDateTime_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearEndLocalDateTime() {
            this.bitField0_ &= -9;
            this.endLocalDateTime_ = getDefaultInstance().getEndLocalDateTime();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setEndLocalDateTimeBytes(ByteString value) {
            this.endLocalDateTime_ = value.toStringUtf8();
            this.bitField0_ |= 8;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean hasZoneOffsetSeconds() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getZoneOffsetSeconds() {
            return this.zoneOffsetSeconds_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setZoneOffsetSeconds(int value) {
            this.bitField0_ |= 16;
            this.zoneOffsetSeconds_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearZoneOffsetSeconds() {
            this.bitField0_ &= -17;
            this.zoneOffsetSeconds_ = 0;
        }

        private static final class DoubleValuesDefaultEntryHolder {
            static final MapEntryLite<String, Double> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.DOUBLE, Double.valueOf(0.0d));

            private DoubleValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Double> internalGetDoubleValues() {
            return this.doubleValues_;
        }

        private MapFieldLite<String, Double> internalGetMutableDoubleValues() {
            if (!this.doubleValues_.isMutable()) {
                this.doubleValues_ = this.doubleValues_.mutableCopy();
            }
            return this.doubleValues_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getDoubleValuesCount() {
            return internalGetDoubleValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean containsDoubleValues(String key) {
            key.getClass();
            return internalGetDoubleValues().containsKey(key);
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        @Deprecated
        public Map<String, Double> getDoubleValues() {
            return getDoubleValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public Map<String, Double> getDoubleValuesMap() {
            return Collections.unmodifiableMap(internalGetDoubleValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public double getDoubleValuesOrDefault(String key, double defaultValue) {
            key.getClass();
            Map<String, Double> map = internalGetDoubleValues();
            return map.containsKey(key) ? map.get(key).doubleValue() : defaultValue;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public double getDoubleValuesOrThrow(String key) {
            key.getClass();
            Map<String, Double> map = internalGetDoubleValues();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key).doubleValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Double> getMutableDoubleValuesMap() {
            return internalGetMutableDoubleValues();
        }

        private static final class LongValuesDefaultEntryHolder {
            static final MapEntryLite<String, Long> defaultEntry = MapEntryLite.newDefaultInstance(WireFormat.FieldType.STRING, "", WireFormat.FieldType.INT64, 0L);

            private LongValuesDefaultEntryHolder() {
            }
        }

        private MapFieldLite<String, Long> internalGetLongValues() {
            return this.longValues_;
        }

        private MapFieldLite<String, Long> internalGetMutableLongValues() {
            if (!this.longValues_.isMutable()) {
                this.longValues_ = this.longValues_.mutableCopy();
            }
            return this.longValues_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getLongValuesCount() {
            return internalGetLongValues().size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public boolean containsLongValues(String key) {
            key.getClass();
            return internalGetLongValues().containsKey(key);
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        @Deprecated
        public Map<String, Long> getLongValues() {
            return getLongValuesMap();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public Map<String, Long> getLongValuesMap() {
            return Collections.unmodifiableMap(internalGetLongValues());
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public long getLongValuesOrDefault(String key, long defaultValue) {
            key.getClass();
            Map<String, Long> map = internalGetLongValues();
            return map.containsKey(key) ? map.get(key).longValue() : defaultValue;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public long getLongValuesOrThrow(String key) {
            key.getClass();
            Map<String, Long> map = internalGetLongValues();
            if (!map.containsKey(key)) {
                throw new IllegalArgumentException();
            }
            return map.get(key).longValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Map<String, Long> getMutableLongValuesMap() {
            return internalGetMutableLongValues();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public List<DataOrigin> getDataOriginsList() {
            return this.dataOrigins_;
        }

        public List<? extends DataOriginOrBuilder> getDataOriginsOrBuilderList() {
            return this.dataOrigins_;
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public int getDataOriginsCount() {
            return this.dataOrigins_.size();
        }

        @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
        public DataOrigin getDataOrigins(int index) {
            return this.dataOrigins_.get(index);
        }

        public DataOriginOrBuilder getDataOriginsOrBuilder(int index) {
            return this.dataOrigins_.get(index);
        }

        private void ensureDataOriginsIsMutable() {
            Internal.ProtobufList<DataOrigin> tmp = this.dataOrigins_;
            if (!tmp.isModifiable()) {
                this.dataOrigins_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOrigins(int index, DataOrigin value) {
            value.getClass();
            ensureDataOriginsIsMutable();
            this.dataOrigins_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigins(DataOrigin value) {
            value.getClass();
            ensureDataOriginsIsMutable();
            this.dataOrigins_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigins(int index, DataOrigin value) {
            value.getClass();
            ensureDataOriginsIsMutable();
            this.dataOrigins_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOrigins(Iterable<? extends DataOrigin> values) {
            ensureDataOriginsIsMutable();
            AbstractMessageLite.addAll(values, this.dataOrigins_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOrigins() {
            this.dataOrigins_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOrigins(int index) {
            ensureDataOriginsIsMutable();
            this.dataOrigins_.remove(index);
        }

        public static AggregateDataRow parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataRow parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataRow parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataRow parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataRow parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataRow parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataRow parseFrom(InputStream input) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataRow parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateDataRow parseDelimitedFrom(InputStream input) throws IOException {
            return (AggregateDataRow) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataRow parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataRow) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateDataRow parseFrom(CodedInputStream input) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataRow parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataRow) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateDataRow prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateDataRow, Builder> implements AggregateDataRowOrBuilder {
            private Builder() {
                super(AggregateDataRow.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasStartTimeEpochMs() {
                return ((AggregateDataRow) this.instance).hasStartTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getStartTimeEpochMs() {
                return ((AggregateDataRow) this.instance).getStartTimeEpochMs();
            }

            public Builder setStartTimeEpochMs(long value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setStartTimeEpochMs(value);
                return this;
            }

            public Builder clearStartTimeEpochMs() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearStartTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasEndTimeEpochMs() {
                return ((AggregateDataRow) this.instance).hasEndTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getEndTimeEpochMs() {
                return ((AggregateDataRow) this.instance).getEndTimeEpochMs();
            }

            public Builder setEndTimeEpochMs(long value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setEndTimeEpochMs(value);
                return this;
            }

            public Builder clearEndTimeEpochMs() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearEndTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasStartLocalDateTime() {
                return ((AggregateDataRow) this.instance).hasStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public String getStartLocalDateTime() {
                return ((AggregateDataRow) this.instance).getStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public ByteString getStartLocalDateTimeBytes() {
                return ((AggregateDataRow) this.instance).getStartLocalDateTimeBytes();
            }

            public Builder setStartLocalDateTime(String value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setStartLocalDateTime(value);
                return this;
            }

            public Builder clearStartLocalDateTime() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearStartLocalDateTime();
                return this;
            }

            public Builder setStartLocalDateTimeBytes(ByteString value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setStartLocalDateTimeBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasEndLocalDateTime() {
                return ((AggregateDataRow) this.instance).hasEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public String getEndLocalDateTime() {
                return ((AggregateDataRow) this.instance).getEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public ByteString getEndLocalDateTimeBytes() {
                return ((AggregateDataRow) this.instance).getEndLocalDateTimeBytes();
            }

            public Builder setEndLocalDateTime(String value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setEndLocalDateTime(value);
                return this;
            }

            public Builder clearEndLocalDateTime() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearEndLocalDateTime();
                return this;
            }

            public Builder setEndLocalDateTimeBytes(ByteString value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setEndLocalDateTimeBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean hasZoneOffsetSeconds() {
                return ((AggregateDataRow) this.instance).hasZoneOffsetSeconds();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getZoneOffsetSeconds() {
                return ((AggregateDataRow) this.instance).getZoneOffsetSeconds();
            }

            public Builder setZoneOffsetSeconds(int value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setZoneOffsetSeconds(value);
                return this;
            }

            public Builder clearZoneOffsetSeconds() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearZoneOffsetSeconds();
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getDoubleValuesCount() {
                return ((AggregateDataRow) this.instance).getDoubleValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean containsDoubleValues(String key) {
                key.getClass();
                return ((AggregateDataRow) this.instance).getDoubleValuesMap().containsKey(key);
            }

            public Builder clearDoubleValues() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().clear();
                return this;
            }

            public Builder removeDoubleValues(String key) {
                key.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().remove(key);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            @Deprecated
            public Map<String, Double> getDoubleValues() {
                return getDoubleValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public Map<String, Double> getDoubleValuesMap() {
                return Collections.unmodifiableMap(((AggregateDataRow) this.instance).getDoubleValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public double getDoubleValuesOrDefault(String key, double defaultValue) {
                key.getClass();
                Map<String, Double> map = ((AggregateDataRow) this.instance).getDoubleValuesMap();
                return map.containsKey(key) ? map.get(key).doubleValue() : defaultValue;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public double getDoubleValuesOrThrow(String key) {
                key.getClass();
                Map<String, Double> map = ((AggregateDataRow) this.instance).getDoubleValuesMap();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                }
                return map.get(key).doubleValue();
            }

            public Builder putDoubleValues(String key, double value) {
                key.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().put(key, Double.valueOf(value));
                return this;
            }

            public Builder putAllDoubleValues(Map<String, Double> values) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableDoubleValuesMap().putAll(values);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getLongValuesCount() {
                return ((AggregateDataRow) this.instance).getLongValuesMap().size();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public boolean containsLongValues(String key) {
                key.getClass();
                return ((AggregateDataRow) this.instance).getLongValuesMap().containsKey(key);
            }

            public Builder clearLongValues() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().clear();
                return this;
            }

            public Builder removeLongValues(String key) {
                key.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().remove(key);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            @Deprecated
            public Map<String, Long> getLongValues() {
                return getLongValuesMap();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public Map<String, Long> getLongValuesMap() {
                return Collections.unmodifiableMap(((AggregateDataRow) this.instance).getLongValuesMap());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getLongValuesOrDefault(String key, long defaultValue) {
                key.getClass();
                Map<String, Long> map = ((AggregateDataRow) this.instance).getLongValuesMap();
                return map.containsKey(key) ? map.get(key).longValue() : defaultValue;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public long getLongValuesOrThrow(String key) {
                key.getClass();
                Map<String, Long> map = ((AggregateDataRow) this.instance).getLongValuesMap();
                if (!map.containsKey(key)) {
                    throw new IllegalArgumentException();
                }
                return map.get(key).longValue();
            }

            public Builder putLongValues(String key, long value) {
                key.getClass();
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().put(key, Long.valueOf(value));
                return this;
            }

            public Builder putAllLongValues(Map<String, Long> values) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).getMutableLongValuesMap().putAll(values);
                return this;
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public List<DataOrigin> getDataOriginsList() {
                return Collections.unmodifiableList(((AggregateDataRow) this.instance).getDataOriginsList());
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public int getDataOriginsCount() {
                return ((AggregateDataRow) this.instance).getDataOriginsCount();
            }

            @Override // androidx.health.platform.client.proto.DataProto.AggregateDataRowOrBuilder
            public DataOrigin getDataOrigins(int index) {
                return ((AggregateDataRow) this.instance).getDataOrigins(index);
            }

            public Builder setDataOrigins(int index, DataOrigin value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setDataOrigins(index, value);
                return this;
            }

            public Builder setDataOrigins(int index, DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).setDataOrigins(index, builderForValue.build());
                return this;
            }

            public Builder addDataOrigins(DataOrigin value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(value);
                return this;
            }

            public Builder addDataOrigins(int index, DataOrigin value) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(index, value);
                return this;
            }

            public Builder addDataOrigins(DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(builderForValue.build());
                return this;
            }

            public Builder addDataOrigins(int index, DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addDataOrigins(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataOrigins(Iterable<? extends DataOrigin> values) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).addAllDataOrigins(values);
                return this;
            }

            public Builder clearDataOrigins() {
                copyOnWrite();
                ((AggregateDataRow) this.instance).clearDataOrigins();
                return this;
            }

            public Builder removeDataOrigins(int index) {
                copyOnWrite();
                ((AggregateDataRow) this.instance).removeDataOrigins(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new AggregateDataRow();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "startTimeEpochMs_", "endTimeEpochMs_", "startLocalDateTime_", "endLocalDateTime_", "zoneOffsetSeconds_", "doubleValues_", DoubleValuesDefaultEntryHolder.defaultEntry, "longValues_", LongValuesDefaultEntryHolder.defaultEntry, "dataOrigins_", DataOrigin.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\b\u0000\u0001\u0001\b\b\u0002\u0001\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005င\u0004\u00062\u00072\b\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<AggregateDataRow> parser = PARSER;
                    if (parser == null) {
                        synchronized (AggregateDataRow.class) {
                            parser = PARSER;
                            if (parser == null) {
                                parser = new GeneratedMessageLite.DefaultInstanceBasedParser(DEFAULT_INSTANCE);
                                PARSER = parser;
                            }
                        }
                    }
                    return parser;
                case GET_MEMOIZED_IS_INITIALIZED:
                    return (byte) 1;
                case SET_MEMOIZED_IS_INITIALIZED:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            AggregateDataRow defaultInstance = new AggregateDataRow();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(AggregateDataRow.class, defaultInstance);
        }

        public static AggregateDataRow getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateDataRow> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
