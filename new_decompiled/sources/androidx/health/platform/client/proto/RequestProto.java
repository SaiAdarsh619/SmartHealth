package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import androidx.health.platform.client.proto.TimeProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes14.dex */
public final class RequestProto {

    public interface AggregateDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataOrigin getDataOrigin(int i);

        int getDataOriginCount();

        List<DataProto.DataOrigin> getDataOriginList();

        AggregateMetricSpec getMetricSpec(int i);

        int getMetricSpecCount();

        List<AggregateMetricSpec> getMetricSpecList();

        long getSliceDurationMillis();

        String getSlicePeriod();

        ByteString getSlicePeriodBytes();

        TimeProto.TimeSpec getTimeSpec();

        boolean hasSliceDurationMillis();

        boolean hasSlicePeriod();

        boolean hasTimeSpec();
    }

    public interface AggregateMetricSpecOrBuilder extends MessageLiteOrBuilder {
        String getAggregationType();

        ByteString getAggregationTypeBytes();

        String getDataTypeName();

        ByteString getDataTypeNameBytes();

        String getFieldName();

        ByteString getFieldNameBytes();

        boolean hasAggregationType();

        boolean hasDataTypeName();

        boolean hasFieldName();
    }

    public interface DataTypeIdPairOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataType getDataType();

        String getId();

        ByteString getIdBytes();

        boolean hasDataType();

        boolean hasId();
    }

    public interface DeleteDataRangeRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataType getDataType(int i);

        int getDataTypeCount();

        List<DataProto.DataType> getDataTypeList();

        TimeProto.TimeSpec getTimeSpec();

        boolean hasTimeSpec();
    }

    public interface DeleteDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataTypeIdPair getClientIds(int i);

        int getClientIdsCount();

        List<DataTypeIdPair> getClientIdsList();

        DataTypeIdPair getUids(int i);

        int getUidsCount();

        List<DataTypeIdPair> getUidsList();
    }

    public interface GetChangesRequestOrBuilder extends MessageLiteOrBuilder {
        String getChangesToken();

        ByteString getChangesTokenBytes();

        boolean hasChangesToken();
    }

    public interface GetChangesTokenRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataOrigin getDataOriginFilters(int i);

        int getDataOriginFiltersCount();

        List<DataProto.DataOrigin> getDataOriginFiltersList();

        DataProto.DataType getDataType(int i);

        int getDataTypeCount();

        List<DataProto.DataType> getDataTypeList();
    }

    public interface ReadDataPointRequestOrBuilder extends MessageLiteOrBuilder {
        String getClientId();

        ByteString getClientIdBytes();

        DataProto.DataType getDataType();

        String getUid();

        ByteString getUidBytes();

        boolean hasClientId();

        boolean hasDataType();

        boolean hasUid();
    }

    public interface ReadDataRangeRequestOrBuilder extends MessageLiteOrBuilder {
        boolean getAscOrdering();

        DataProto.DataOrigin getDataOriginFilters(int i);

        int getDataOriginFiltersCount();

        List<DataProto.DataOrigin> getDataOriginFiltersList();

        DataProto.DataType getDataType();

        int getLimit();

        int getPageSize();

        String getPageToken();

        ByteString getPageTokenBytes();

        TimeProto.TimeSpec getTimeSpec();

        boolean hasAscOrdering();

        boolean hasDataType();

        boolean hasLimit();

        boolean hasPageSize();

        boolean hasPageToken();

        boolean hasTimeSpec();
    }

    public interface ReadDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataTypeIdPair getDataTypeIdPair();

        boolean hasDataTypeIdPair();
    }

    public interface ReadExerciseRouteRequestOrBuilder extends MessageLiteOrBuilder {
        String getSessionUid();

        ByteString getSessionUidBytes();

        boolean hasSessionUid();
    }

    public interface RegisterForDataNotificationsRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataType getDataTypes(int i);

        int getDataTypesCount();

        List<DataProto.DataType> getDataTypesList();

        String getNotificationIntentAction();

        ByteString getNotificationIntentActionBytes();

        boolean hasNotificationIntentAction();
    }

    public interface RequestContextOrBuilder extends MessageLiteOrBuilder {
        String getCallingPackage();

        ByteString getCallingPackageBytes();

        boolean getIsInForeground();

        String getPermissionToken();

        ByteString getPermissionTokenBytes();

        int getSdkVersion();

        boolean hasCallingPackage();

        boolean hasIsInForeground();

        boolean hasPermissionToken();

        boolean hasSdkVersion();
    }

    public interface SimpleDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint();

        boolean hasDataPoint();
    }

    public interface UnregisterFromDataNotificationsRequestOrBuilder extends MessageLiteOrBuilder {
        String getNotificationIntentAction();

        ByteString getNotificationIntentActionBytes();

        boolean hasNotificationIntentAction();
    }

    public interface UpsertDataRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint(int i);

        int getDataPointCount();

        List<DataProto.DataPoint> getDataPointList();
    }

    public interface UpsertExerciseRouteRequestOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getExerciseRoute();

        String getSessionUid();

        ByteString getSessionUidBytes();

        boolean hasExerciseRoute();

        boolean hasSessionUid();
    }

    private RequestProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class SimpleDataRequest extends GeneratedMessageLite<SimpleDataRequest, Builder> implements SimpleDataRequestOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final SimpleDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<SimpleDataRequest> PARSER;
        private int bitField0_;
        private DataProto.DataPoint dataPoint_;

        private SimpleDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
        public boolean hasDataPoint() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
        public DataProto.DataPoint getDataPoint() {
            return this.dataPoint_ == null ? DataProto.DataPoint.getDefaultInstance() : this.dataPoint_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataPoint(DataProto.DataPoint value) {
            value.getClass();
            this.dataPoint_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataPoint(DataProto.DataPoint value) {
            value.getClass();
            if (this.dataPoint_ != null && this.dataPoint_ != DataProto.DataPoint.getDefaultInstance()) {
                this.dataPoint_ = DataProto.DataPoint.newBuilder(this.dataPoint_).mergeFrom((DataProto.DataPoint.Builder) value).buildPartial();
            } else {
                this.dataPoint_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataPoint() {
            this.dataPoint_ = null;
            this.bitField0_ &= -2;
        }

        public static SimpleDataRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SimpleDataRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SimpleDataRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SimpleDataRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SimpleDataRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static SimpleDataRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static SimpleDataRequest parseFrom(InputStream input) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SimpleDataRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SimpleDataRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (SimpleDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static SimpleDataRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SimpleDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static SimpleDataRequest parseFrom(CodedInputStream input) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static SimpleDataRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (SimpleDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(SimpleDataRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<SimpleDataRequest, Builder> implements SimpleDataRequestOrBuilder {
            private Builder() {
                super(SimpleDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
            public boolean hasDataPoint() {
                return ((SimpleDataRequest) this.instance).hasDataPoint();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.SimpleDataRequestOrBuilder
            public DataProto.DataPoint getDataPoint() {
                return ((SimpleDataRequest) this.instance).getDataPoint();
            }

            public Builder setDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).setDataPoint(value);
                return this;
            }

            public Builder setDataPoint(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).setDataPoint(builderForValue.build());
                return this;
            }

            public Builder mergeDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).mergeDataPoint(value);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((SimpleDataRequest) this.instance).clearDataPoint();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new SimpleDataRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataPoint_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<SimpleDataRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (SimpleDataRequest.class) {
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
            SimpleDataRequest defaultInstance = new SimpleDataRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(SimpleDataRequest.class, defaultInstance);
        }

        public static SimpleDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<SimpleDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataPointRequest extends GeneratedMessageLite<ReadDataPointRequest, Builder> implements ReadDataPointRequestOrBuilder {
        public static final int CLIENT_ID_FIELD_NUMBER = 3;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final ReadDataPointRequest DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataPointRequest> PARSER = null;
        public static final int UID_FIELD_NUMBER = 2;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private String uid_ = "";
        private String clientId_ = "";

        private ReadDataPointRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public DataProto.DataType getDataType() {
            return this.dataType_ == null ? DataProto.DataType.getDefaultInstance() : this.dataType_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(DataProto.DataType value) {
            value.getClass();
            this.dataType_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataType(DataProto.DataType value) {
            value.getClass();
            if (this.dataType_ != null && this.dataType_ != DataProto.DataType.getDefaultInstance()) {
                this.dataType_ = DataProto.DataType.newBuilder(this.dataType_).mergeFrom((DataProto.DataType.Builder) value).buildPartial();
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

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public boolean hasUid() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public String getUid() {
            return this.uid_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
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

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public boolean hasClientId() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public String getClientId() {
            return this.clientId_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
        public ByteString getClientIdBytes() {
            return ByteString.copyFromUtf8(this.clientId_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientId(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.clientId_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientId() {
            this.bitField0_ &= -5;
            this.clientId_ = getDefaultInstance().getClientId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientIdBytes(ByteString value) {
            this.clientId_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static ReadDataPointRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataPointRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataPointRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataPointRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataPointRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataPointRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataPointRequest parseFrom(InputStream input) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataPointRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataPointRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadDataPointRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataPointRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataPointRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataPointRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataPointRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataPointRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataPointRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataPointRequest, Builder> implements ReadDataPointRequestOrBuilder {
            private Builder() {
                super(ReadDataPointRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public boolean hasDataType() {
                return ((ReadDataPointRequest) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public DataProto.DataType getDataType() {
                return ((ReadDataPointRequest) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType value) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setDataType(value);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setDataType(builderForValue.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType value) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).mergeDataType(value);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public boolean hasUid() {
                return ((ReadDataPointRequest) this.instance).hasUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public String getUid() {
                return ((ReadDataPointRequest) this.instance).getUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public ByteString getUidBytes() {
                return ((ReadDataPointRequest) this.instance).getUidBytes();
            }

            public Builder setUid(String value) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setUid(value);
                return this;
            }

            public Builder clearUid() {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).clearUid();
                return this;
            }

            public Builder setUidBytes(ByteString value) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setUidBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public boolean hasClientId() {
                return ((ReadDataPointRequest) this.instance).hasClientId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public String getClientId() {
                return ((ReadDataPointRequest) this.instance).getClientId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataPointRequestOrBuilder
            public ByteString getClientIdBytes() {
                return ((ReadDataPointRequest) this.instance).getClientIdBytes();
            }

            public Builder setClientId(String value) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setClientId(value);
                return this;
            }

            public Builder clearClientId() {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).clearClientId();
                return this;
            }

            public Builder setClientIdBytes(ByteString value) {
                copyOnWrite();
                ((ReadDataPointRequest) this.instance).setClientIdBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadDataPointRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataType_", "uid_", "clientId_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadDataPointRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDataPointRequest.class) {
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
            ReadDataPointRequest defaultInstance = new ReadDataPointRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadDataPointRequest.class, defaultInstance);
        }

        public static ReadDataPointRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataPointRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RequestContext extends GeneratedMessageLite<RequestContext, Builder> implements RequestContextOrBuilder {
        public static final int CALLING_PACKAGE_FIELD_NUMBER = 1;
        private static final RequestContext DEFAULT_INSTANCE;
        public static final int IS_IN_FOREGROUND_FIELD_NUMBER = 4;
        private static volatile Parser<RequestContext> PARSER = null;
        public static final int PERMISSION_TOKEN_FIELD_NUMBER = 3;
        public static final int SDK_VERSION_FIELD_NUMBER = 2;
        private int bitField0_;
        private boolean isInForeground_;
        private int sdkVersion_;
        private String callingPackage_ = "";
        private String permissionToken_ = "";

        private RequestContext() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasCallingPackage() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public String getCallingPackage() {
            return this.callingPackage_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public ByteString getCallingPackageBytes() {
            return ByteString.copyFromUtf8(this.callingPackage_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallingPackage(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.callingPackage_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCallingPackage() {
            this.bitField0_ &= -2;
            this.callingPackage_ = getDefaultInstance().getCallingPackage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCallingPackageBytes(ByteString value) {
            this.callingPackage_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasSdkVersion() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public int getSdkVersion() {
            return this.sdkVersion_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSdkVersion(int value) {
            this.bitField0_ |= 2;
            this.sdkVersion_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSdkVersion() {
            this.bitField0_ &= -3;
            this.sdkVersion_ = 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasPermissionToken() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public String getPermissionToken() {
            return this.permissionToken_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public ByteString getPermissionTokenBytes() {
            return ByteString.copyFromUtf8(this.permissionToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermissionToken(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.permissionToken_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPermissionToken() {
            this.bitField0_ &= -5;
            this.permissionToken_ = getDefaultInstance().getPermissionToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermissionTokenBytes(ByteString value) {
            this.permissionToken_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean hasIsInForeground() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
        public boolean getIsInForeground() {
            return this.isInForeground_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIsInForeground(boolean value) {
            this.bitField0_ |= 8;
            this.isInForeground_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearIsInForeground() {
            this.bitField0_ &= -9;
            this.isInForeground_ = false;
        }

        public static RequestContext parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RequestContext parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RequestContext parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RequestContext parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RequestContext parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RequestContext parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RequestContext parseFrom(InputStream input) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RequestContext parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RequestContext parseDelimitedFrom(InputStream input) throws IOException {
            return (RequestContext) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static RequestContext parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RequestContext) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RequestContext parseFrom(CodedInputStream input) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RequestContext parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RequestContext) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RequestContext prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RequestContext, Builder> implements RequestContextOrBuilder {
            private Builder() {
                super(RequestContext.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasCallingPackage() {
                return ((RequestContext) this.instance).hasCallingPackage();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public String getCallingPackage() {
                return ((RequestContext) this.instance).getCallingPackage();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public ByteString getCallingPackageBytes() {
                return ((RequestContext) this.instance).getCallingPackageBytes();
            }

            public Builder setCallingPackage(String value) {
                copyOnWrite();
                ((RequestContext) this.instance).setCallingPackage(value);
                return this;
            }

            public Builder clearCallingPackage() {
                copyOnWrite();
                ((RequestContext) this.instance).clearCallingPackage();
                return this;
            }

            public Builder setCallingPackageBytes(ByteString value) {
                copyOnWrite();
                ((RequestContext) this.instance).setCallingPackageBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasSdkVersion() {
                return ((RequestContext) this.instance).hasSdkVersion();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public int getSdkVersion() {
                return ((RequestContext) this.instance).getSdkVersion();
            }

            public Builder setSdkVersion(int value) {
                copyOnWrite();
                ((RequestContext) this.instance).setSdkVersion(value);
                return this;
            }

            public Builder clearSdkVersion() {
                copyOnWrite();
                ((RequestContext) this.instance).clearSdkVersion();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasPermissionToken() {
                return ((RequestContext) this.instance).hasPermissionToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public String getPermissionToken() {
                return ((RequestContext) this.instance).getPermissionToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public ByteString getPermissionTokenBytes() {
                return ((RequestContext) this.instance).getPermissionTokenBytes();
            }

            public Builder setPermissionToken(String value) {
                copyOnWrite();
                ((RequestContext) this.instance).setPermissionToken(value);
                return this;
            }

            public Builder clearPermissionToken() {
                copyOnWrite();
                ((RequestContext) this.instance).clearPermissionToken();
                return this;
            }

            public Builder setPermissionTokenBytes(ByteString value) {
                copyOnWrite();
                ((RequestContext) this.instance).setPermissionTokenBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean hasIsInForeground() {
                return ((RequestContext) this.instance).hasIsInForeground();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RequestContextOrBuilder
            public boolean getIsInForeground() {
                return ((RequestContext) this.instance).getIsInForeground();
            }

            public Builder setIsInForeground(boolean value) {
                copyOnWrite();
                ((RequestContext) this.instance).setIsInForeground(value);
                return this;
            }

            public Builder clearIsInForeground() {
                copyOnWrite();
                ((RequestContext) this.instance).clearIsInForeground();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new RequestContext();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "callingPackage_", "sdkVersion_", "permissionToken_", "isInForeground_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002င\u0001\u0003ဈ\u0002\u0004ဇ\u0003", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<RequestContext> parser = PARSER;
                    if (parser == null) {
                        synchronized (RequestContext.class) {
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
            RequestContext defaultInstance = new RequestContext();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(RequestContext.class, defaultInstance);
        }

        public static RequestContext getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RequestContext> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UpsertDataRequest extends GeneratedMessageLite<UpsertDataRequest, Builder> implements UpsertDataRequestOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final UpsertDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<UpsertDataRequest> PARSER;
        private Internal.ProtobufList<DataProto.DataPoint> dataPoint_ = emptyProtobufList();

        private UpsertDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
        public List<DataProto.DataPoint> getDataPointList() {
            return this.dataPoint_;
        }

        public List<? extends DataProto.DataPointOrBuilder> getDataPointOrBuilderList() {
            return this.dataPoint_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
        public int getDataPointCount() {
            return this.dataPoint_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
        public DataProto.DataPoint getDataPoint(int index) {
            return this.dataPoint_.get(index);
        }

        public DataProto.DataPointOrBuilder getDataPointOrBuilder(int index) {
            return this.dataPoint_.get(index);
        }

        private void ensureDataPointIsMutable() {
            Internal.ProtobufList<DataProto.DataPoint> tmp = this.dataPoint_;
            if (!tmp.isModifiable()) {
                this.dataPoint_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataPoint(int index, DataProto.DataPoint value) {
            value.getClass();
            ensureDataPointIsMutable();
            this.dataPoint_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPoint(DataProto.DataPoint value) {
            value.getClass();
            ensureDataPointIsMutable();
            this.dataPoint_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPoint(int index, DataProto.DataPoint value) {
            value.getClass();
            ensureDataPointIsMutable();
            this.dataPoint_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataPoint(Iterable<? extends DataProto.DataPoint> values) {
            ensureDataPointIsMutable();
            AbstractMessageLite.addAll(values, this.dataPoint_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataPoint() {
            this.dataPoint_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataPoint(int index) {
            ensureDataPointIsMutable();
            this.dataPoint_.remove(index);
        }

        public static UpsertDataRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UpsertDataRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UpsertDataRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UpsertDataRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UpsertDataRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UpsertDataRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UpsertDataRequest parseFrom(InputStream input) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UpsertDataRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UpsertDataRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpsertDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static UpsertDataRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpsertDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UpsertDataRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UpsertDataRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpsertDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UpsertDataRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UpsertDataRequest, Builder> implements UpsertDataRequestOrBuilder {
            private Builder() {
                super(UpsertDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
            public List<DataProto.DataPoint> getDataPointList() {
                return Collections.unmodifiableList(((UpsertDataRequest) this.instance).getDataPointList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
            public int getDataPointCount() {
                return ((UpsertDataRequest) this.instance).getDataPointCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertDataRequestOrBuilder
            public DataProto.DataPoint getDataPoint(int index) {
                return ((UpsertDataRequest) this.instance).getDataPoint(index);
            }

            public Builder setDataPoint(int index, DataProto.DataPoint value) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).setDataPoint(index, value);
                return this;
            }

            public Builder setDataPoint(int index, DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).setDataPoint(index, builderForValue.build());
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(value);
                return this;
            }

            public Builder addDataPoint(int index, DataProto.DataPoint value) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(index, value);
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(builderForValue.build());
                return this;
            }

            public Builder addDataPoint(int index, DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addDataPoint(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataPoint(Iterable<? extends DataProto.DataPoint> values) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).addAllDataPoint(values);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).clearDataPoint();
                return this;
            }

            public Builder removeDataPoint(int index) {
                copyOnWrite();
                ((UpsertDataRequest) this.instance).removeDataPoint(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new UpsertDataRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"dataPoint_", DataProto.DataPoint.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UpsertDataRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (UpsertDataRequest.class) {
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
            UpsertDataRequest defaultInstance = new UpsertDataRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(UpsertDataRequest.class, defaultInstance);
        }

        public static UpsertDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpsertDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DataTypeIdPair extends GeneratedMessageLite<DataTypeIdPair, Builder> implements DataTypeIdPairOrBuilder {
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final DataTypeIdPair DEFAULT_INSTANCE;
        public static final int ID_FIELD_NUMBER = 2;
        private static volatile Parser<DataTypeIdPair> PARSER;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private String id_ = "";

        private DataTypeIdPair() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public DataProto.DataType getDataType() {
            return this.dataType_ == null ? DataProto.DataType.getDefaultInstance() : this.dataType_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(DataProto.DataType value) {
            value.getClass();
            this.dataType_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataType(DataProto.DataType value) {
            value.getClass();
            if (this.dataType_ != null && this.dataType_ != DataProto.DataType.getDefaultInstance()) {
                this.dataType_ = DataProto.DataType.newBuilder(this.dataType_).mergeFrom((DataProto.DataType.Builder) value).buildPartial();
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

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public boolean hasId() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public String getId() {
            return this.id_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
        public ByteString getIdBytes() {
            return ByteString.copyFromUtf8(this.id_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setId(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.id_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearId() {
            this.bitField0_ &= -3;
            this.id_ = getDefaultInstance().getId();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setIdBytes(ByteString value) {
            this.id_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        public static DataTypeIdPair parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataTypeIdPair parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataTypeIdPair parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataTypeIdPair parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataTypeIdPair parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataTypeIdPair parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataTypeIdPair parseFrom(InputStream input) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataTypeIdPair parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataTypeIdPair parseDelimitedFrom(InputStream input) throws IOException {
            return (DataTypeIdPair) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DataTypeIdPair parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataTypeIdPair) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataTypeIdPair parseFrom(CodedInputStream input) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataTypeIdPair parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataTypeIdPair) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataTypeIdPair prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataTypeIdPair, Builder> implements DataTypeIdPairOrBuilder {
            private Builder() {
                super(DataTypeIdPair.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public boolean hasDataType() {
                return ((DataTypeIdPair) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public DataProto.DataType getDataType() {
                return ((DataTypeIdPair) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType value) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setDataType(value);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setDataType(builderForValue.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType value) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).mergeDataType(value);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public boolean hasId() {
                return ((DataTypeIdPair) this.instance).hasId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public String getId() {
                return ((DataTypeIdPair) this.instance).getId();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DataTypeIdPairOrBuilder
            public ByteString getIdBytes() {
                return ((DataTypeIdPair) this.instance).getIdBytes();
            }

            public Builder setId(String value) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setId(value);
                return this;
            }

            public Builder clearId() {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).clearId();
                return this;
            }

            public Builder setIdBytes(ByteString value) {
                copyOnWrite();
                ((DataTypeIdPair) this.instance).setIdBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new DataTypeIdPair();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataType_", "id_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဈ\u0001", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DataTypeIdPair> parser = PARSER;
                    if (parser == null) {
                        synchronized (DataTypeIdPair.class) {
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
            DataTypeIdPair defaultInstance = new DataTypeIdPair();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(DataTypeIdPair.class, defaultInstance);
        }

        public static DataTypeIdPair getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataTypeIdPair> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DeleteDataRequest extends GeneratedMessageLite<DeleteDataRequest, Builder> implements DeleteDataRequestOrBuilder {
        public static final int CLIENT_IDS_FIELD_NUMBER = 2;
        private static final DeleteDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<DeleteDataRequest> PARSER = null;
        public static final int UIDS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<DataTypeIdPair> uids_ = emptyProtobufList();
        private Internal.ProtobufList<DataTypeIdPair> clientIds_ = emptyProtobufList();

        private DeleteDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public List<DataTypeIdPair> getUidsList() {
            return this.uids_;
        }

        public List<? extends DataTypeIdPairOrBuilder> getUidsOrBuilderList() {
            return this.uids_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public int getUidsCount() {
            return this.uids_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public DataTypeIdPair getUids(int index) {
            return this.uids_.get(index);
        }

        public DataTypeIdPairOrBuilder getUidsOrBuilder(int index) {
            return this.uids_.get(index);
        }

        private void ensureUidsIsMutable() {
            Internal.ProtobufList<DataTypeIdPair> tmp = this.uids_;
            if (!tmp.isModifiable()) {
                this.uids_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUids(int index, DataTypeIdPair value) {
            value.getClass();
            ensureUidsIsMutable();
            this.uids_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUids(DataTypeIdPair value) {
            value.getClass();
            ensureUidsIsMutable();
            this.uids_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addUids(int index, DataTypeIdPair value) {
            value.getClass();
            ensureUidsIsMutable();
            this.uids_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllUids(Iterable<? extends DataTypeIdPair> values) {
            ensureUidsIsMutable();
            AbstractMessageLite.addAll(values, this.uids_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUids() {
            this.uids_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeUids(int index) {
            ensureUidsIsMutable();
            this.uids_.remove(index);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public List<DataTypeIdPair> getClientIdsList() {
            return this.clientIds_;
        }

        public List<? extends DataTypeIdPairOrBuilder> getClientIdsOrBuilderList() {
            return this.clientIds_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public int getClientIdsCount() {
            return this.clientIds_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
        public DataTypeIdPair getClientIds(int index) {
            return this.clientIds_.get(index);
        }

        public DataTypeIdPairOrBuilder getClientIdsOrBuilder(int index) {
            return this.clientIds_.get(index);
        }

        private void ensureClientIdsIsMutable() {
            Internal.ProtobufList<DataTypeIdPair> tmp = this.clientIds_;
            if (!tmp.isModifiable()) {
                this.clientIds_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setClientIds(int index, DataTypeIdPair value) {
            value.getClass();
            ensureClientIdsIsMutable();
            this.clientIds_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClientIds(DataTypeIdPair value) {
            value.getClass();
            ensureClientIdsIsMutable();
            this.clientIds_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addClientIds(int index, DataTypeIdPair value) {
            value.getClass();
            ensureClientIdsIsMutable();
            this.clientIds_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllClientIds(Iterable<? extends DataTypeIdPair> values) {
            ensureClientIdsIsMutable();
            AbstractMessageLite.addAll(values, this.clientIds_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearClientIds() {
            this.clientIds_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeClientIds(int index) {
            ensureClientIdsIsMutable();
            this.clientIds_.remove(index);
        }

        public static DeleteDataRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DeleteDataRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DeleteDataRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DeleteDataRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DeleteDataRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DeleteDataRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DeleteDataRequest parseFrom(InputStream input) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DeleteDataRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DeleteDataRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DeleteDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DeleteDataRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeleteDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DeleteDataRequest parseFrom(CodedInputStream input) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DeleteDataRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeleteDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeleteDataRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DeleteDataRequest, Builder> implements DeleteDataRequestOrBuilder {
            private Builder() {
                super(DeleteDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public List<DataTypeIdPair> getUidsList() {
                return Collections.unmodifiableList(((DeleteDataRequest) this.instance).getUidsList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public int getUidsCount() {
                return ((DeleteDataRequest) this.instance).getUidsCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public DataTypeIdPair getUids(int index) {
                return ((DeleteDataRequest) this.instance).getUids(index);
            }

            public Builder setUids(int index, DataTypeIdPair value) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setUids(index, value);
                return this;
            }

            public Builder setUids(int index, DataTypeIdPair.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setUids(index, builderForValue.build());
                return this;
            }

            public Builder addUids(DataTypeIdPair value) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(value);
                return this;
            }

            public Builder addUids(int index, DataTypeIdPair value) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(index, value);
                return this;
            }

            public Builder addUids(DataTypeIdPair.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(builderForValue.build());
                return this;
            }

            public Builder addUids(int index, DataTypeIdPair.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addUids(index, builderForValue.build());
                return this;
            }

            public Builder addAllUids(Iterable<? extends DataTypeIdPair> values) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addAllUids(values);
                return this;
            }

            public Builder clearUids() {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).clearUids();
                return this;
            }

            public Builder removeUids(int index) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).removeUids(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public List<DataTypeIdPair> getClientIdsList() {
                return Collections.unmodifiableList(((DeleteDataRequest) this.instance).getClientIdsList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public int getClientIdsCount() {
                return ((DeleteDataRequest) this.instance).getClientIdsCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRequestOrBuilder
            public DataTypeIdPair getClientIds(int index) {
                return ((DeleteDataRequest) this.instance).getClientIds(index);
            }

            public Builder setClientIds(int index, DataTypeIdPair value) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setClientIds(index, value);
                return this;
            }

            public Builder setClientIds(int index, DataTypeIdPair.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).setClientIds(index, builderForValue.build());
                return this;
            }

            public Builder addClientIds(DataTypeIdPair value) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(value);
                return this;
            }

            public Builder addClientIds(int index, DataTypeIdPair value) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(index, value);
                return this;
            }

            public Builder addClientIds(DataTypeIdPair.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(builderForValue.build());
                return this;
            }

            public Builder addClientIds(int index, DataTypeIdPair.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addClientIds(index, builderForValue.build());
                return this;
            }

            public Builder addAllClientIds(Iterable<? extends DataTypeIdPair> values) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).addAllClientIds(values);
                return this;
            }

            public Builder clearClientIds() {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).clearClientIds();
                return this;
            }

            public Builder removeClientIds(int index) {
                copyOnWrite();
                ((DeleteDataRequest) this.instance).removeClientIds(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new DeleteDataRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"uids_", DataTypeIdPair.class, "clientIds_", DataTypeIdPair.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DeleteDataRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (DeleteDataRequest.class) {
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
            DeleteDataRequest defaultInstance = new DeleteDataRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(DeleteDataRequest.class, defaultInstance);
        }

        public static DeleteDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeleteDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class DeleteDataRangeRequest extends GeneratedMessageLite<DeleteDataRangeRequest, Builder> implements DeleteDataRangeRequestOrBuilder {
        public static final int DATA_TYPE_FIELD_NUMBER = 2;
        private static final DeleteDataRangeRequest DEFAULT_INSTANCE;
        private static volatile Parser<DeleteDataRangeRequest> PARSER = null;
        public static final int TIME_SPEC_FIELD_NUMBER = 1;
        private int bitField0_;
        private Internal.ProtobufList<DataProto.DataType> dataType_ = emptyProtobufList();
        private TimeProto.TimeSpec timeSpec_;

        private DeleteDataRangeRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public boolean hasTimeSpec() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public TimeProto.TimeSpec getTimeSpec() {
            return this.timeSpec_ == null ? TimeProto.TimeSpec.getDefaultInstance() : this.timeSpec_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeSpec(TimeProto.TimeSpec value) {
            value.getClass();
            this.timeSpec_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimeSpec(TimeProto.TimeSpec value) {
            value.getClass();
            if (this.timeSpec_ != null && this.timeSpec_ != TimeProto.TimeSpec.getDefaultInstance()) {
                this.timeSpec_ = TimeProto.TimeSpec.newBuilder(this.timeSpec_).mergeFrom((TimeProto.TimeSpec.Builder) value).buildPartial();
            } else {
                this.timeSpec_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeSpec() {
            this.timeSpec_ = null;
            this.bitField0_ &= -2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public List<DataProto.DataType> getDataTypeList() {
            return this.dataType_;
        }

        public List<? extends DataProto.DataTypeOrBuilder> getDataTypeOrBuilderList() {
            return this.dataType_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public int getDataTypeCount() {
            return this.dataType_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
        public DataProto.DataType getDataType(int index) {
            return this.dataType_.get(index);
        }

        public DataProto.DataTypeOrBuilder getDataTypeOrBuilder(int index) {
            return this.dataType_.get(index);
        }

        private void ensureDataTypeIsMutable() {
            Internal.ProtobufList<DataProto.DataType> tmp = this.dataType_;
            if (!tmp.isModifiable()) {
                this.dataType_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(int index, DataProto.DataType value) {
            value.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(DataProto.DataType value) {
            value.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(int index, DataProto.DataType value) {
            value.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataType(Iterable<? extends DataProto.DataType> values) {
            ensureDataTypeIsMutable();
            AbstractMessageLite.addAll(values, this.dataType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataType(int index) {
            ensureDataTypeIsMutable();
            this.dataType_.remove(index);
        }

        public static DeleteDataRangeRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DeleteDataRangeRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DeleteDataRangeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DeleteDataRangeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DeleteDataRangeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DeleteDataRangeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DeleteDataRangeRequest parseFrom(InputStream input) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DeleteDataRangeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DeleteDataRangeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (DeleteDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DeleteDataRangeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeleteDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DeleteDataRangeRequest parseFrom(CodedInputStream input) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DeleteDataRangeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DeleteDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DeleteDataRangeRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DeleteDataRangeRequest, Builder> implements DeleteDataRangeRequestOrBuilder {
            private Builder() {
                super(DeleteDataRangeRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public boolean hasTimeSpec() {
                return ((DeleteDataRangeRequest) this.instance).hasTimeSpec();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public TimeProto.TimeSpec getTimeSpec() {
                return ((DeleteDataRangeRequest) this.instance).getTimeSpec();
            }

            public Builder setTimeSpec(TimeProto.TimeSpec value) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setTimeSpec(value);
                return this;
            }

            public Builder setTimeSpec(TimeProto.TimeSpec.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setTimeSpec(builderForValue.build());
                return this;
            }

            public Builder mergeTimeSpec(TimeProto.TimeSpec value) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).mergeTimeSpec(value);
                return this;
            }

            public Builder clearTimeSpec() {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).clearTimeSpec();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public List<DataProto.DataType> getDataTypeList() {
                return Collections.unmodifiableList(((DeleteDataRangeRequest) this.instance).getDataTypeList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public int getDataTypeCount() {
                return ((DeleteDataRangeRequest) this.instance).getDataTypeCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.DeleteDataRangeRequestOrBuilder
            public DataProto.DataType getDataType(int index) {
                return ((DeleteDataRangeRequest) this.instance).getDataType(index);
            }

            public Builder setDataType(int index, DataProto.DataType value) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setDataType(index, value);
                return this;
            }

            public Builder setDataType(int index, DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).setDataType(index, builderForValue.build());
                return this;
            }

            public Builder addDataType(DataProto.DataType value) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(value);
                return this;
            }

            public Builder addDataType(int index, DataProto.DataType value) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(index, value);
                return this;
            }

            public Builder addDataType(DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(builderForValue.build());
                return this;
            }

            public Builder addDataType(int index, DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addDataType(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataType(Iterable<? extends DataProto.DataType> values) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).addAllDataType(values);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).clearDataType();
                return this;
            }

            public Builder removeDataType(int index) {
                copyOnWrite();
                ((DeleteDataRangeRequest) this.instance).removeDataType(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new DeleteDataRangeRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "timeSpec_", "dataType_", DataProto.DataType.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဉ\u0000\u0002\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DeleteDataRangeRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (DeleteDataRangeRequest.class) {
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
            DeleteDataRangeRequest defaultInstance = new DeleteDataRangeRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(DeleteDataRangeRequest.class, defaultInstance);
        }

        public static DeleteDataRangeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DeleteDataRangeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataRequest extends GeneratedMessageLite<ReadDataRequest, Builder> implements ReadDataRequestOrBuilder {
        public static final int DATA_TYPE_ID_PAIR_FIELD_NUMBER = 1;
        private static final ReadDataRequest DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataRequest> PARSER;
        private int bitField0_;
        private DataTypeIdPair dataTypeIdPair_;

        private ReadDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
        public boolean hasDataTypeIdPair() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
        public DataTypeIdPair getDataTypeIdPair() {
            return this.dataTypeIdPair_ == null ? DataTypeIdPair.getDefaultInstance() : this.dataTypeIdPair_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypeIdPair(DataTypeIdPair value) {
            value.getClass();
            this.dataTypeIdPair_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataTypeIdPair(DataTypeIdPair value) {
            value.getClass();
            if (this.dataTypeIdPair_ != null && this.dataTypeIdPair_ != DataTypeIdPair.getDefaultInstance()) {
                this.dataTypeIdPair_ = DataTypeIdPair.newBuilder(this.dataTypeIdPair_).mergeFrom((DataTypeIdPair.Builder) value).buildPartial();
            } else {
                this.dataTypeIdPair_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataTypeIdPair() {
            this.dataTypeIdPair_ = null;
            this.bitField0_ &= -2;
        }

        public static ReadDataRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRequest parseFrom(InputStream input) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataRequest, Builder> implements ReadDataRequestOrBuilder {
            private Builder() {
                super(ReadDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
            public boolean hasDataTypeIdPair() {
                return ((ReadDataRequest) this.instance).hasDataTypeIdPair();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRequestOrBuilder
            public DataTypeIdPair getDataTypeIdPair() {
                return ((ReadDataRequest) this.instance).getDataTypeIdPair();
            }

            public Builder setDataTypeIdPair(DataTypeIdPair value) {
                copyOnWrite();
                ((ReadDataRequest) this.instance).setDataTypeIdPair(value);
                return this;
            }

            public Builder setDataTypeIdPair(DataTypeIdPair.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRequest) this.instance).setDataTypeIdPair(builderForValue.build());
                return this;
            }

            public Builder mergeDataTypeIdPair(DataTypeIdPair value) {
                copyOnWrite();
                ((ReadDataRequest) this.instance).mergeDataTypeIdPair(value);
                return this;
            }

            public Builder clearDataTypeIdPair() {
                copyOnWrite();
                ((ReadDataRequest) this.instance).clearDataTypeIdPair();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadDataRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataTypeIdPair_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadDataRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDataRequest.class) {
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
            ReadDataRequest defaultInstance = new ReadDataRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadDataRequest.class, defaultInstance);
        }

        public static ReadDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataRangeRequest extends GeneratedMessageLite<ReadDataRangeRequest, Builder> implements ReadDataRangeRequestOrBuilder {
        public static final int ASC_ORDERING_FIELD_NUMBER = 7;
        public static final int DATA_ORIGIN_FILTERS_FIELD_NUMBER = 3;
        public static final int DATA_TYPE_FIELD_NUMBER = 2;
        private static final ReadDataRangeRequest DEFAULT_INSTANCE;
        public static final int LIMIT_FIELD_NUMBER = 4;
        public static final int PAGE_SIZE_FIELD_NUMBER = 5;
        public static final int PAGE_TOKEN_FIELD_NUMBER = 6;
        private static volatile Parser<ReadDataRangeRequest> PARSER = null;
        public static final int TIME_SPEC_FIELD_NUMBER = 1;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private int limit_;
        private int pageSize_;
        private TimeProto.TimeSpec timeSpec_;
        private Internal.ProtobufList<DataProto.DataOrigin> dataOriginFilters_ = emptyProtobufList();
        private boolean ascOrdering_ = true;
        private String pageToken_ = "";

        private ReadDataRangeRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasTimeSpec() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public TimeProto.TimeSpec getTimeSpec() {
            return this.timeSpec_ == null ? TimeProto.TimeSpec.getDefaultInstance() : this.timeSpec_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeSpec(TimeProto.TimeSpec value) {
            value.getClass();
            this.timeSpec_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimeSpec(TimeProto.TimeSpec value) {
            value.getClass();
            if (this.timeSpec_ != null && this.timeSpec_ != TimeProto.TimeSpec.getDefaultInstance()) {
                this.timeSpec_ = TimeProto.TimeSpec.newBuilder(this.timeSpec_).mergeFrom((TimeProto.TimeSpec.Builder) value).buildPartial();
            } else {
                this.timeSpec_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeSpec() {
            this.timeSpec_ = null;
            this.bitField0_ &= -2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public DataProto.DataType getDataType() {
            return this.dataType_ == null ? DataProto.DataType.getDefaultInstance() : this.dataType_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(DataProto.DataType value) {
            value.getClass();
            this.dataType_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeDataType(DataProto.DataType value) {
            value.getClass();
            if (this.dataType_ != null && this.dataType_ != DataProto.DataType.getDefaultInstance()) {
                this.dataType_ = DataProto.DataType.newBuilder(this.dataType_).mergeFrom((DataProto.DataType.Builder) value).buildPartial();
            } else {
                this.dataType_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = null;
            this.bitField0_ &= -3;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public List<DataProto.DataOrigin> getDataOriginFiltersList() {
            return this.dataOriginFilters_;
        }

        public List<? extends DataProto.DataOriginOrBuilder> getDataOriginFiltersOrBuilderList() {
            return this.dataOriginFilters_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public int getDataOriginFiltersCount() {
            return this.dataOriginFilters_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public DataProto.DataOrigin getDataOriginFilters(int index) {
            return this.dataOriginFilters_.get(index);
        }

        public DataProto.DataOriginOrBuilder getDataOriginFiltersOrBuilder(int index) {
            return this.dataOriginFilters_.get(index);
        }

        private void ensureDataOriginFiltersIsMutable() {
            Internal.ProtobufList<DataProto.DataOrigin> tmp = this.dataOriginFilters_;
            if (!tmp.isModifiable()) {
                this.dataOriginFilters_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOriginFilters(int index, DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(int index, DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> values) {
            ensureDataOriginFiltersIsMutable();
            AbstractMessageLite.addAll(values, this.dataOriginFilters_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOriginFilters() {
            this.dataOriginFilters_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOriginFilters(int index) {
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.remove(index);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasAscOrdering() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean getAscOrdering() {
            return this.ascOrdering_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAscOrdering(boolean value) {
            this.bitField0_ |= 4;
            this.ascOrdering_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAscOrdering() {
            this.bitField0_ &= -5;
            this.ascOrdering_ = true;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasLimit() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public int getLimit() {
            return this.limit_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setLimit(int value) {
            this.bitField0_ |= 8;
            this.limit_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearLimit() {
            this.bitField0_ &= -9;
            this.limit_ = 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasPageSize() {
            return (this.bitField0_ & 16) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public int getPageSize() {
            return this.pageSize_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageSize(int value) {
            this.bitField0_ |= 16;
            this.pageSize_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageSize() {
            this.bitField0_ &= -17;
            this.pageSize_ = 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public boolean hasPageToken() {
            return (this.bitField0_ & 32) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public String getPageToken() {
            return this.pageToken_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
        public ByteString getPageTokenBytes() {
            return ByteString.copyFromUtf8(this.pageToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageToken(String value) {
            value.getClass();
            this.bitField0_ |= 32;
            this.pageToken_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageToken() {
            this.bitField0_ &= -33;
            this.pageToken_ = getDefaultInstance().getPageToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageTokenBytes(ByteString value) {
            this.pageToken_ = value.toStringUtf8();
            this.bitField0_ |= 32;
        }

        public static ReadDataRangeRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRangeRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRangeRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRangeRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRangeRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRangeRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRangeRequest parseFrom(InputStream input) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRangeRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataRangeRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRangeRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRangeRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataRangeRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRangeRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRangeRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataRangeRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataRangeRequest, Builder> implements ReadDataRangeRequestOrBuilder {
            private Builder() {
                super(ReadDataRangeRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasTimeSpec() {
                return ((ReadDataRangeRequest) this.instance).hasTimeSpec();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public TimeProto.TimeSpec getTimeSpec() {
                return ((ReadDataRangeRequest) this.instance).getTimeSpec();
            }

            public Builder setTimeSpec(TimeProto.TimeSpec value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setTimeSpec(value);
                return this;
            }

            public Builder setTimeSpec(TimeProto.TimeSpec.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setTimeSpec(builderForValue.build());
                return this;
            }

            public Builder mergeTimeSpec(TimeProto.TimeSpec value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).mergeTimeSpec(value);
                return this;
            }

            public Builder clearTimeSpec() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearTimeSpec();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasDataType() {
                return ((ReadDataRangeRequest) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public DataProto.DataType getDataType() {
                return ((ReadDataRangeRequest) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataType(value);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataType(builderForValue.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).mergeDataType(value);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public List<DataProto.DataOrigin> getDataOriginFiltersList() {
                return Collections.unmodifiableList(((ReadDataRangeRequest) this.instance).getDataOriginFiltersList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public int getDataOriginFiltersCount() {
                return ((ReadDataRangeRequest) this.instance).getDataOriginFiltersCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public DataProto.DataOrigin getDataOriginFilters(int index) {
                return ((ReadDataRangeRequest) this.instance).getDataOriginFilters(index);
            }

            public Builder setDataOriginFilters(int index, DataProto.DataOrigin value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataOriginFilters(index, value);
                return this;
            }

            public Builder setDataOriginFilters(int index, DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setDataOriginFilters(index, builderForValue.build());
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(value);
                return this;
            }

            public Builder addDataOriginFilters(int index, DataProto.DataOrigin value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(index, value);
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(builderForValue.build());
                return this;
            }

            public Builder addDataOriginFilters(int index, DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addDataOriginFilters(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> values) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).addAllDataOriginFilters(values);
                return this;
            }

            public Builder clearDataOriginFilters() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearDataOriginFilters();
                return this;
            }

            public Builder removeDataOriginFilters(int index) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).removeDataOriginFilters(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasAscOrdering() {
                return ((ReadDataRangeRequest) this.instance).hasAscOrdering();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean getAscOrdering() {
                return ((ReadDataRangeRequest) this.instance).getAscOrdering();
            }

            public Builder setAscOrdering(boolean value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setAscOrdering(value);
                return this;
            }

            public Builder clearAscOrdering() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearAscOrdering();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasLimit() {
                return ((ReadDataRangeRequest) this.instance).hasLimit();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public int getLimit() {
                return ((ReadDataRangeRequest) this.instance).getLimit();
            }

            public Builder setLimit(int value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setLimit(value);
                return this;
            }

            public Builder clearLimit() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearLimit();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasPageSize() {
                return ((ReadDataRangeRequest) this.instance).hasPageSize();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public int getPageSize() {
                return ((ReadDataRangeRequest) this.instance).getPageSize();
            }

            public Builder setPageSize(int value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setPageSize(value);
                return this;
            }

            public Builder clearPageSize() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearPageSize();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public boolean hasPageToken() {
                return ((ReadDataRangeRequest) this.instance).hasPageToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public String getPageToken() {
                return ((ReadDataRangeRequest) this.instance).getPageToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadDataRangeRequestOrBuilder
            public ByteString getPageTokenBytes() {
                return ((ReadDataRangeRequest) this.instance).getPageTokenBytes();
            }

            public Builder setPageToken(String value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setPageToken(value);
                return this;
            }

            public Builder clearPageToken() {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).clearPageToken();
                return this;
            }

            public Builder setPageTokenBytes(ByteString value) {
                copyOnWrite();
                ((ReadDataRangeRequest) this.instance).setPageTokenBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadDataRangeRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "timeSpec_", "dataType_", "dataOriginFilters_", DataProto.DataOrigin.class, "limit_", "pageSize_", "pageToken_", "ascOrdering_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004င\u0003\u0005င\u0004\u0006ဈ\u0005\u0007ဇ\u0002", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadDataRangeRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDataRangeRequest.class) {
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
            ReadDataRangeRequest defaultInstance = new ReadDataRangeRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadDataRangeRequest.class, defaultInstance);
        }

        public static ReadDataRangeRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataRangeRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateMetricSpec extends GeneratedMessageLite<AggregateMetricSpec, Builder> implements AggregateMetricSpecOrBuilder {
        public static final int AGGREGATION_TYPE_FIELD_NUMBER = 2;
        public static final int DATA_TYPE_NAME_FIELD_NUMBER = 1;
        private static final AggregateMetricSpec DEFAULT_INSTANCE;
        public static final int FIELD_NAME_FIELD_NUMBER = 3;
        private static volatile Parser<AggregateMetricSpec> PARSER;
        private int bitField0_;
        private String dataTypeName_ = "";
        private String aggregationType_ = "";
        private String fieldName_ = "";

        private AggregateMetricSpec() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public boolean hasDataTypeName() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public String getDataTypeName() {
            return this.dataTypeName_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public ByteString getDataTypeNameBytes() {
            return ByteString.copyFromUtf8(this.dataTypeName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypeName(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.dataTypeName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataTypeName() {
            this.bitField0_ &= -2;
            this.dataTypeName_ = getDefaultInstance().getDataTypeName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypeNameBytes(ByteString value) {
            this.dataTypeName_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public boolean hasAggregationType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public String getAggregationType() {
            return this.aggregationType_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public ByteString getAggregationTypeBytes() {
            return ByteString.copyFromUtf8(this.aggregationType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregationType(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.aggregationType_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAggregationType() {
            this.bitField0_ &= -3;
            this.aggregationType_ = getDefaultInstance().getAggregationType();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAggregationTypeBytes(ByteString value) {
            this.aggregationType_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public boolean hasFieldName() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public String getFieldName() {
            return this.fieldName_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
        public ByteString getFieldNameBytes() {
            return ByteString.copyFromUtf8(this.fieldName_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldName(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.fieldName_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearFieldName() {
            this.bitField0_ &= -5;
            this.fieldName_ = getDefaultInstance().getFieldName();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setFieldNameBytes(ByteString value) {
            this.fieldName_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static AggregateMetricSpec parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateMetricSpec parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateMetricSpec parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateMetricSpec parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateMetricSpec parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateMetricSpec parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateMetricSpec parseFrom(InputStream input) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateMetricSpec parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateMetricSpec parseDelimitedFrom(InputStream input) throws IOException {
            return (AggregateMetricSpec) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateMetricSpec parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateMetricSpec) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateMetricSpec parseFrom(CodedInputStream input) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateMetricSpec parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateMetricSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateMetricSpec prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateMetricSpec, Builder> implements AggregateMetricSpecOrBuilder {
            private Builder() {
                super(AggregateMetricSpec.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public boolean hasDataTypeName() {
                return ((AggregateMetricSpec) this.instance).hasDataTypeName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public String getDataTypeName() {
                return ((AggregateMetricSpec) this.instance).getDataTypeName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public ByteString getDataTypeNameBytes() {
                return ((AggregateMetricSpec) this.instance).getDataTypeNameBytes();
            }

            public Builder setDataTypeName(String value) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setDataTypeName(value);
                return this;
            }

            public Builder clearDataTypeName() {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).clearDataTypeName();
                return this;
            }

            public Builder setDataTypeNameBytes(ByteString value) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setDataTypeNameBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public boolean hasAggregationType() {
                return ((AggregateMetricSpec) this.instance).hasAggregationType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public String getAggregationType() {
                return ((AggregateMetricSpec) this.instance).getAggregationType();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public ByteString getAggregationTypeBytes() {
                return ((AggregateMetricSpec) this.instance).getAggregationTypeBytes();
            }

            public Builder setAggregationType(String value) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setAggregationType(value);
                return this;
            }

            public Builder clearAggregationType() {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).clearAggregationType();
                return this;
            }

            public Builder setAggregationTypeBytes(ByteString value) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setAggregationTypeBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public boolean hasFieldName() {
                return ((AggregateMetricSpec) this.instance).hasFieldName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public String getFieldName() {
                return ((AggregateMetricSpec) this.instance).getFieldName();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateMetricSpecOrBuilder
            public ByteString getFieldNameBytes() {
                return ((AggregateMetricSpec) this.instance).getFieldNameBytes();
            }

            public Builder setFieldName(String value) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setFieldName(value);
                return this;
            }

            public Builder clearFieldName() {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).clearFieldName();
                return this;
            }

            public Builder setFieldNameBytes(ByteString value) {
                copyOnWrite();
                ((AggregateMetricSpec) this.instance).setFieldNameBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new AggregateMetricSpec();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataTypeName_", "aggregationType_", "fieldName_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<AggregateMetricSpec> parser = PARSER;
                    if (parser == null) {
                        synchronized (AggregateMetricSpec.class) {
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
            AggregateMetricSpec defaultInstance = new AggregateMetricSpec();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(AggregateMetricSpec.class, defaultInstance);
        }

        public static AggregateMetricSpec getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateMetricSpec> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateDataRequest extends GeneratedMessageLite<AggregateDataRequest, Builder> implements AggregateDataRequestOrBuilder {
        public static final int DATA_ORIGIN_FIELD_NUMBER = 3;
        private static final AggregateDataRequest DEFAULT_INSTANCE;
        public static final int METRIC_SPEC_FIELD_NUMBER = 2;
        private static volatile Parser<AggregateDataRequest> PARSER = null;
        public static final int SLICE_DURATION_MILLIS_FIELD_NUMBER = 4;
        public static final int SLICE_PERIOD_FIELD_NUMBER = 5;
        public static final int TIME_SPEC_FIELD_NUMBER = 1;
        private int bitField0_;
        private long sliceDurationMillis_;
        private TimeProto.TimeSpec timeSpec_;
        private Internal.ProtobufList<AggregateMetricSpec> metricSpec_ = emptyProtobufList();
        private Internal.ProtobufList<DataProto.DataOrigin> dataOrigin_ = emptyProtobufList();
        private String slicePeriod_ = "";

        private AggregateDataRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public boolean hasTimeSpec() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public TimeProto.TimeSpec getTimeSpec() {
            return this.timeSpec_ == null ? TimeProto.TimeSpec.getDefaultInstance() : this.timeSpec_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setTimeSpec(TimeProto.TimeSpec value) {
            value.getClass();
            this.timeSpec_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeTimeSpec(TimeProto.TimeSpec value) {
            value.getClass();
            if (this.timeSpec_ != null && this.timeSpec_ != TimeProto.TimeSpec.getDefaultInstance()) {
                this.timeSpec_ = TimeProto.TimeSpec.newBuilder(this.timeSpec_).mergeFrom((TimeProto.TimeSpec.Builder) value).buildPartial();
            } else {
                this.timeSpec_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearTimeSpec() {
            this.timeSpec_ = null;
            this.bitField0_ &= -2;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public List<AggregateMetricSpec> getMetricSpecList() {
            return this.metricSpec_;
        }

        public List<? extends AggregateMetricSpecOrBuilder> getMetricSpecOrBuilderList() {
            return this.metricSpec_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public int getMetricSpecCount() {
            return this.metricSpec_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public AggregateMetricSpec getMetricSpec(int index) {
            return this.metricSpec_.get(index);
        }

        public AggregateMetricSpecOrBuilder getMetricSpecOrBuilder(int index) {
            return this.metricSpec_.get(index);
        }

        private void ensureMetricSpecIsMutable() {
            Internal.ProtobufList<AggregateMetricSpec> tmp = this.metricSpec_;
            if (!tmp.isModifiable()) {
                this.metricSpec_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMetricSpec(int index, AggregateMetricSpec value) {
            value.getClass();
            ensureMetricSpecIsMutable();
            this.metricSpec_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetricSpec(AggregateMetricSpec value) {
            value.getClass();
            ensureMetricSpecIsMutable();
            this.metricSpec_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addMetricSpec(int index, AggregateMetricSpec value) {
            value.getClass();
            ensureMetricSpecIsMutable();
            this.metricSpec_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllMetricSpec(Iterable<? extends AggregateMetricSpec> values) {
            ensureMetricSpecIsMutable();
            AbstractMessageLite.addAll(values, this.metricSpec_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMetricSpec() {
            this.metricSpec_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeMetricSpec(int index) {
            ensureMetricSpecIsMutable();
            this.metricSpec_.remove(index);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public List<DataProto.DataOrigin> getDataOriginList() {
            return this.dataOrigin_;
        }

        public List<? extends DataProto.DataOriginOrBuilder> getDataOriginOrBuilderList() {
            return this.dataOrigin_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public int getDataOriginCount() {
            return this.dataOrigin_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public DataProto.DataOrigin getDataOrigin(int index) {
            return this.dataOrigin_.get(index);
        }

        public DataProto.DataOriginOrBuilder getDataOriginOrBuilder(int index) {
            return this.dataOrigin_.get(index);
        }

        private void ensureDataOriginIsMutable() {
            Internal.ProtobufList<DataProto.DataOrigin> tmp = this.dataOrigin_;
            if (!tmp.isModifiable()) {
                this.dataOrigin_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOrigin(int index, DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginIsMutable();
            this.dataOrigin_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigin(DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginIsMutable();
            this.dataOrigin_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOrigin(int index, DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginIsMutable();
            this.dataOrigin_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOrigin(Iterable<? extends DataProto.DataOrigin> values) {
            ensureDataOriginIsMutable();
            AbstractMessageLite.addAll(values, this.dataOrigin_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOrigin() {
            this.dataOrigin_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOrigin(int index) {
            ensureDataOriginIsMutable();
            this.dataOrigin_.remove(index);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public boolean hasSliceDurationMillis() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public long getSliceDurationMillis() {
            return this.sliceDurationMillis_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSliceDurationMillis(long value) {
            this.bitField0_ |= 2;
            this.sliceDurationMillis_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSliceDurationMillis() {
            this.bitField0_ &= -3;
            this.sliceDurationMillis_ = 0L;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public boolean hasSlicePeriod() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public String getSlicePeriod() {
            return this.slicePeriod_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
        public ByteString getSlicePeriodBytes() {
            return ByteString.copyFromUtf8(this.slicePeriod_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlicePeriod(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.slicePeriod_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSlicePeriod() {
            this.bitField0_ &= -5;
            this.slicePeriod_ = getDefaultInstance().getSlicePeriod();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSlicePeriodBytes(ByteString value) {
            this.slicePeriod_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static AggregateDataRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataRequest parseFrom(InputStream input) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateDataRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (AggregateDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateDataRequest parseFrom(CodedInputStream input) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateDataRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateDataRequest, Builder> implements AggregateDataRequestOrBuilder {
            private Builder() {
                super(AggregateDataRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public boolean hasTimeSpec() {
                return ((AggregateDataRequest) this.instance).hasTimeSpec();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public TimeProto.TimeSpec getTimeSpec() {
                return ((AggregateDataRequest) this.instance).getTimeSpec();
            }

            public Builder setTimeSpec(TimeProto.TimeSpec value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setTimeSpec(value);
                return this;
            }

            public Builder setTimeSpec(TimeProto.TimeSpec.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setTimeSpec(builderForValue.build());
                return this;
            }

            public Builder mergeTimeSpec(TimeProto.TimeSpec value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).mergeTimeSpec(value);
                return this;
            }

            public Builder clearTimeSpec() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearTimeSpec();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public List<AggregateMetricSpec> getMetricSpecList() {
                return Collections.unmodifiableList(((AggregateDataRequest) this.instance).getMetricSpecList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public int getMetricSpecCount() {
                return ((AggregateDataRequest) this.instance).getMetricSpecCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public AggregateMetricSpec getMetricSpec(int index) {
                return ((AggregateDataRequest) this.instance).getMetricSpec(index);
            }

            public Builder setMetricSpec(int index, AggregateMetricSpec value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setMetricSpec(index, value);
                return this;
            }

            public Builder setMetricSpec(int index, AggregateMetricSpec.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setMetricSpec(index, builderForValue.build());
                return this;
            }

            public Builder addMetricSpec(AggregateMetricSpec value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(value);
                return this;
            }

            public Builder addMetricSpec(int index, AggregateMetricSpec value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(index, value);
                return this;
            }

            public Builder addMetricSpec(AggregateMetricSpec.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(builderForValue.build());
                return this;
            }

            public Builder addMetricSpec(int index, AggregateMetricSpec.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addMetricSpec(index, builderForValue.build());
                return this;
            }

            public Builder addAllMetricSpec(Iterable<? extends AggregateMetricSpec> values) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addAllMetricSpec(values);
                return this;
            }

            public Builder clearMetricSpec() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearMetricSpec();
                return this;
            }

            public Builder removeMetricSpec(int index) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).removeMetricSpec(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public List<DataProto.DataOrigin> getDataOriginList() {
                return Collections.unmodifiableList(((AggregateDataRequest) this.instance).getDataOriginList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public int getDataOriginCount() {
                return ((AggregateDataRequest) this.instance).getDataOriginCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public DataProto.DataOrigin getDataOrigin(int index) {
                return ((AggregateDataRequest) this.instance).getDataOrigin(index);
            }

            public Builder setDataOrigin(int index, DataProto.DataOrigin value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setDataOrigin(index, value);
                return this;
            }

            public Builder setDataOrigin(int index, DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setDataOrigin(index, builderForValue.build());
                return this;
            }

            public Builder addDataOrigin(DataProto.DataOrigin value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(value);
                return this;
            }

            public Builder addDataOrigin(int index, DataProto.DataOrigin value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(index, value);
                return this;
            }

            public Builder addDataOrigin(DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(builderForValue.build());
                return this;
            }

            public Builder addDataOrigin(int index, DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addDataOrigin(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataOrigin(Iterable<? extends DataProto.DataOrigin> values) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).addAllDataOrigin(values);
                return this;
            }

            public Builder clearDataOrigin() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearDataOrigin();
                return this;
            }

            public Builder removeDataOrigin(int index) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).removeDataOrigin(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public boolean hasSliceDurationMillis() {
                return ((AggregateDataRequest) this.instance).hasSliceDurationMillis();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public long getSliceDurationMillis() {
                return ((AggregateDataRequest) this.instance).getSliceDurationMillis();
            }

            public Builder setSliceDurationMillis(long value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setSliceDurationMillis(value);
                return this;
            }

            public Builder clearSliceDurationMillis() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearSliceDurationMillis();
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public boolean hasSlicePeriod() {
                return ((AggregateDataRequest) this.instance).hasSlicePeriod();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public String getSlicePeriod() {
                return ((AggregateDataRequest) this.instance).getSlicePeriod();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.AggregateDataRequestOrBuilder
            public ByteString getSlicePeriodBytes() {
                return ((AggregateDataRequest) this.instance).getSlicePeriodBytes();
            }

            public Builder setSlicePeriod(String value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setSlicePeriod(value);
                return this;
            }

            public Builder clearSlicePeriod() {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).clearSlicePeriod();
                return this;
            }

            public Builder setSlicePeriodBytes(ByteString value) {
                copyOnWrite();
                ((AggregateDataRequest) this.instance).setSlicePeriodBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new AggregateDataRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "timeSpec_", "metricSpec_", AggregateMetricSpec.class, "dataOrigin_", DataProto.DataOrigin.class, "sliceDurationMillis_", "slicePeriod_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဉ\u0000\u0002\u001b\u0003\u001b\u0004ဂ\u0001\u0005ဈ\u0002", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<AggregateDataRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (AggregateDataRequest.class) {
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
            AggregateDataRequest defaultInstance = new AggregateDataRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(AggregateDataRequest.class, defaultInstance);
        }

        public static AggregateDataRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateDataRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesTokenRequest extends GeneratedMessageLite<GetChangesTokenRequest, Builder> implements GetChangesTokenRequestOrBuilder {
        public static final int DATA_ORIGIN_FILTERS_FIELD_NUMBER = 2;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final GetChangesTokenRequest DEFAULT_INSTANCE;
        private static volatile Parser<GetChangesTokenRequest> PARSER;
        private Internal.ProtobufList<DataProto.DataType> dataType_ = emptyProtobufList();
        private Internal.ProtobufList<DataProto.DataOrigin> dataOriginFilters_ = emptyProtobufList();

        private GetChangesTokenRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public List<DataProto.DataType> getDataTypeList() {
            return this.dataType_;
        }

        public List<? extends DataProto.DataTypeOrBuilder> getDataTypeOrBuilderList() {
            return this.dataType_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public int getDataTypeCount() {
            return this.dataType_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public DataProto.DataType getDataType(int index) {
            return this.dataType_.get(index);
        }

        public DataProto.DataTypeOrBuilder getDataTypeOrBuilder(int index) {
            return this.dataType_.get(index);
        }

        private void ensureDataTypeIsMutable() {
            Internal.ProtobufList<DataProto.DataType> tmp = this.dataType_;
            if (!tmp.isModifiable()) {
                this.dataType_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataType(int index, DataProto.DataType value) {
            value.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(DataProto.DataType value) {
            value.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataType(int index, DataProto.DataType value) {
            value.getClass();
            ensureDataTypeIsMutable();
            this.dataType_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataType(Iterable<? extends DataProto.DataType> values) {
            ensureDataTypeIsMutable();
            AbstractMessageLite.addAll(values, this.dataType_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataType() {
            this.dataType_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataType(int index) {
            ensureDataTypeIsMutable();
            this.dataType_.remove(index);
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public List<DataProto.DataOrigin> getDataOriginFiltersList() {
            return this.dataOriginFilters_;
        }

        public List<? extends DataProto.DataOriginOrBuilder> getDataOriginFiltersOrBuilderList() {
            return this.dataOriginFilters_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public int getDataOriginFiltersCount() {
            return this.dataOriginFilters_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
        public DataProto.DataOrigin getDataOriginFilters(int index) {
            return this.dataOriginFilters_.get(index);
        }

        public DataProto.DataOriginOrBuilder getDataOriginFiltersOrBuilder(int index) {
            return this.dataOriginFilters_.get(index);
        }

        private void ensureDataOriginFiltersIsMutable() {
            Internal.ProtobufList<DataProto.DataOrigin> tmp = this.dataOriginFilters_;
            if (!tmp.isModifiable()) {
                this.dataOriginFilters_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataOriginFilters(int index, DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataOriginFilters(int index, DataProto.DataOrigin value) {
            value.getClass();
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> values) {
            ensureDataOriginFiltersIsMutable();
            AbstractMessageLite.addAll(values, this.dataOriginFilters_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataOriginFilters() {
            this.dataOriginFilters_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataOriginFilters(int index) {
            ensureDataOriginFiltersIsMutable();
            this.dataOriginFilters_.remove(index);
        }

        public static GetChangesTokenRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesTokenRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesTokenRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesTokenRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesTokenRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesTokenRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesTokenRequest parseFrom(InputStream input) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesTokenRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesTokenRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetChangesTokenRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesTokenRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesTokenRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesTokenRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesTokenRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesTokenRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesTokenRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesTokenRequest, Builder> implements GetChangesTokenRequestOrBuilder {
            private Builder() {
                super(GetChangesTokenRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public List<DataProto.DataType> getDataTypeList() {
                return Collections.unmodifiableList(((GetChangesTokenRequest) this.instance).getDataTypeList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public int getDataTypeCount() {
                return ((GetChangesTokenRequest) this.instance).getDataTypeCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public DataProto.DataType getDataType(int index) {
                return ((GetChangesTokenRequest) this.instance).getDataType(index);
            }

            public Builder setDataType(int index, DataProto.DataType value) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataType(index, value);
                return this;
            }

            public Builder setDataType(int index, DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataType(index, builderForValue.build());
                return this;
            }

            public Builder addDataType(DataProto.DataType value) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(value);
                return this;
            }

            public Builder addDataType(int index, DataProto.DataType value) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(index, value);
                return this;
            }

            public Builder addDataType(DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(builderForValue.build());
                return this;
            }

            public Builder addDataType(int index, DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataType(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataType(Iterable<? extends DataProto.DataType> values) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addAllDataType(values);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).clearDataType();
                return this;
            }

            public Builder removeDataType(int index) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).removeDataType(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public List<DataProto.DataOrigin> getDataOriginFiltersList() {
                return Collections.unmodifiableList(((GetChangesTokenRequest) this.instance).getDataOriginFiltersList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public int getDataOriginFiltersCount() {
                return ((GetChangesTokenRequest) this.instance).getDataOriginFiltersCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesTokenRequestOrBuilder
            public DataProto.DataOrigin getDataOriginFilters(int index) {
                return ((GetChangesTokenRequest) this.instance).getDataOriginFilters(index);
            }

            public Builder setDataOriginFilters(int index, DataProto.DataOrigin value) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataOriginFilters(index, value);
                return this;
            }

            public Builder setDataOriginFilters(int index, DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).setDataOriginFilters(index, builderForValue.build());
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin value) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(value);
                return this;
            }

            public Builder addDataOriginFilters(int index, DataProto.DataOrigin value) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(index, value);
                return this;
            }

            public Builder addDataOriginFilters(DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(builderForValue.build());
                return this;
            }

            public Builder addDataOriginFilters(int index, DataProto.DataOrigin.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addDataOriginFilters(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataOriginFilters(Iterable<? extends DataProto.DataOrigin> values) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).addAllDataOriginFilters(values);
                return this;
            }

            public Builder clearDataOriginFilters() {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).clearDataOriginFilters();
                return this;
            }

            public Builder removeDataOriginFilters(int index) {
                copyOnWrite();
                ((GetChangesTokenRequest) this.instance).removeDataOriginFilters(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new GetChangesTokenRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"dataType_", DataProto.DataType.class, "dataOriginFilters_", DataProto.DataOrigin.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0002\u0000\u0001\u001b\u0002\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<GetChangesTokenRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (GetChangesTokenRequest.class) {
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
            GetChangesTokenRequest defaultInstance = new GetChangesTokenRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(GetChangesTokenRequest.class, defaultInstance);
        }

        public static GetChangesTokenRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesTokenRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesRequest extends GeneratedMessageLite<GetChangesRequest, Builder> implements GetChangesRequestOrBuilder {
        public static final int CHANGES_TOKEN_FIELD_NUMBER = 1;
        private static final GetChangesRequest DEFAULT_INSTANCE;
        private static volatile Parser<GetChangesRequest> PARSER;
        private int bitField0_;
        private String changesToken_ = "";

        private GetChangesRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
        public boolean hasChangesToken() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
        public String getChangesToken() {
            return this.changesToken_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
        public ByteString getChangesTokenBytes() {
            return ByteString.copyFromUtf8(this.changesToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChangesToken(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.changesToken_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChangesToken() {
            this.bitField0_ &= -2;
            this.changesToken_ = getDefaultInstance().getChangesToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChangesTokenBytes(ByteString value) {
            this.changesToken_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static GetChangesRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesRequest parseFrom(InputStream input) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (GetChangesRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesRequest parseFrom(CodedInputStream input) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesRequest, Builder> implements GetChangesRequestOrBuilder {
            private Builder() {
                super(GetChangesRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
            public boolean hasChangesToken() {
                return ((GetChangesRequest) this.instance).hasChangesToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
            public String getChangesToken() {
                return ((GetChangesRequest) this.instance).getChangesToken();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.GetChangesRequestOrBuilder
            public ByteString getChangesTokenBytes() {
                return ((GetChangesRequest) this.instance).getChangesTokenBytes();
            }

            public Builder setChangesToken(String value) {
                copyOnWrite();
                ((GetChangesRequest) this.instance).setChangesToken(value);
                return this;
            }

            public Builder clearChangesToken() {
                copyOnWrite();
                ((GetChangesRequest) this.instance).clearChangesToken();
                return this;
            }

            public Builder setChangesTokenBytes(ByteString value) {
                copyOnWrite();
                ((GetChangesRequest) this.instance).setChangesTokenBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new GetChangesRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "changesToken_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<GetChangesRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (GetChangesRequest.class) {
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
            GetChangesRequest defaultInstance = new GetChangesRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(GetChangesRequest.class, defaultInstance);
        }

        public static GetChangesRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class RegisterForDataNotificationsRequest extends GeneratedMessageLite<RegisterForDataNotificationsRequest, Builder> implements RegisterForDataNotificationsRequestOrBuilder {
        public static final int DATA_TYPES_FIELD_NUMBER = 2;
        private static final RegisterForDataNotificationsRequest DEFAULT_INSTANCE;
        public static final int NOTIFICATIONINTENTACTION_FIELD_NUMBER = 1;
        private static volatile Parser<RegisterForDataNotificationsRequest> PARSER;
        private int bitField0_;
        private String notificationIntentAction_ = "";
        private Internal.ProtobufList<DataProto.DataType> dataTypes_ = emptyProtobufList();

        private RegisterForDataNotificationsRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public boolean hasNotificationIntentAction() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public String getNotificationIntentAction() {
            return this.notificationIntentAction_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public ByteString getNotificationIntentActionBytes() {
            return ByteString.copyFromUtf8(this.notificationIntentAction_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentAction(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.notificationIntentAction_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNotificationIntentAction() {
            this.bitField0_ &= -2;
            this.notificationIntentAction_ = getDefaultInstance().getNotificationIntentAction();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentActionBytes(ByteString value) {
            this.notificationIntentAction_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public List<DataProto.DataType> getDataTypesList() {
            return this.dataTypes_;
        }

        public List<? extends DataProto.DataTypeOrBuilder> getDataTypesOrBuilderList() {
            return this.dataTypes_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public int getDataTypesCount() {
            return this.dataTypes_.size();
        }

        @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
        public DataProto.DataType getDataTypes(int index) {
            return this.dataTypes_.get(index);
        }

        public DataProto.DataTypeOrBuilder getDataTypesOrBuilder(int index) {
            return this.dataTypes_.get(index);
        }

        private void ensureDataTypesIsMutable() {
            Internal.ProtobufList<DataProto.DataType> tmp = this.dataTypes_;
            if (!tmp.isModifiable()) {
                this.dataTypes_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataTypes(int index, DataProto.DataType value) {
            value.getClass();
            ensureDataTypesIsMutable();
            this.dataTypes_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataTypes(DataProto.DataType value) {
            value.getClass();
            ensureDataTypesIsMutable();
            this.dataTypes_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataTypes(int index, DataProto.DataType value) {
            value.getClass();
            ensureDataTypesIsMutable();
            this.dataTypes_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataTypes(Iterable<? extends DataProto.DataType> values) {
            ensureDataTypesIsMutable();
            AbstractMessageLite.addAll(values, this.dataTypes_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataTypes() {
            this.dataTypes_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeDataTypes(int index) {
            ensureDataTypesIsMutable();
            this.dataTypes_.remove(index);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RegisterForDataNotificationsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RegisterForDataNotificationsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static RegisterForDataNotificationsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static RegisterForDataNotificationsRequest parseFrom(InputStream input) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RegisterForDataNotificationsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RegisterForDataNotificationsRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (RegisterForDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static RegisterForDataNotificationsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterForDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static RegisterForDataNotificationsRequest parseFrom(CodedInputStream input) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static RegisterForDataNotificationsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (RegisterForDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(RegisterForDataNotificationsRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<RegisterForDataNotificationsRequest, Builder> implements RegisterForDataNotificationsRequestOrBuilder {
            private Builder() {
                super(RegisterForDataNotificationsRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public boolean hasNotificationIntentAction() {
                return ((RegisterForDataNotificationsRequest) this.instance).hasNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public String getNotificationIntentAction() {
                return ((RegisterForDataNotificationsRequest) this.instance).getNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public ByteString getNotificationIntentActionBytes() {
                return ((RegisterForDataNotificationsRequest) this.instance).getNotificationIntentActionBytes();
            }

            public Builder setNotificationIntentAction(String value) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setNotificationIntentAction(value);
                return this;
            }

            public Builder clearNotificationIntentAction() {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).clearNotificationIntentAction();
                return this;
            }

            public Builder setNotificationIntentActionBytes(ByteString value) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setNotificationIntentActionBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public List<DataProto.DataType> getDataTypesList() {
                return Collections.unmodifiableList(((RegisterForDataNotificationsRequest) this.instance).getDataTypesList());
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public int getDataTypesCount() {
                return ((RegisterForDataNotificationsRequest) this.instance).getDataTypesCount();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.RegisterForDataNotificationsRequestOrBuilder
            public DataProto.DataType getDataTypes(int index) {
                return ((RegisterForDataNotificationsRequest) this.instance).getDataTypes(index);
            }

            public Builder setDataTypes(int index, DataProto.DataType value) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setDataTypes(index, value);
                return this;
            }

            public Builder setDataTypes(int index, DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).setDataTypes(index, builderForValue.build());
                return this;
            }

            public Builder addDataTypes(DataProto.DataType value) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(value);
                return this;
            }

            public Builder addDataTypes(int index, DataProto.DataType value) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(index, value);
                return this;
            }

            public Builder addDataTypes(DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(builderForValue.build());
                return this;
            }

            public Builder addDataTypes(int index, DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addDataTypes(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataTypes(Iterable<? extends DataProto.DataType> values) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).addAllDataTypes(values);
                return this;
            }

            public Builder clearDataTypes() {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).clearDataTypes();
                return this;
            }

            public Builder removeDataTypes(int index) {
                copyOnWrite();
                ((RegisterForDataNotificationsRequest) this.instance).removeDataTypes(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new RegisterForDataNotificationsRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "notificationIntentAction_", "dataTypes_", DataProto.DataType.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<RegisterForDataNotificationsRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (RegisterForDataNotificationsRequest.class) {
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
            RegisterForDataNotificationsRequest defaultInstance = new RegisterForDataNotificationsRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(RegisterForDataNotificationsRequest.class, defaultInstance);
        }

        public static RegisterForDataNotificationsRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<RegisterForDataNotificationsRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UnregisterFromDataNotificationsRequest extends GeneratedMessageLite<UnregisterFromDataNotificationsRequest, Builder> implements UnregisterFromDataNotificationsRequestOrBuilder {
        private static final UnregisterFromDataNotificationsRequest DEFAULT_INSTANCE;
        public static final int NOTIFICATIONINTENTACTION_FIELD_NUMBER = 1;
        private static volatile Parser<UnregisterFromDataNotificationsRequest> PARSER;
        private int bitField0_;
        private String notificationIntentAction_ = "";

        private UnregisterFromDataNotificationsRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
        public boolean hasNotificationIntentAction() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
        public String getNotificationIntentAction() {
            return this.notificationIntentAction_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
        public ByteString getNotificationIntentActionBytes() {
            return ByteString.copyFromUtf8(this.notificationIntentAction_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentAction(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.notificationIntentAction_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNotificationIntentAction() {
            this.bitField0_ &= -2;
            this.notificationIntentAction_ = getDefaultInstance().getNotificationIntentAction();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNotificationIntentActionBytes(ByteString value) {
            this.notificationIntentAction_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(InputStream input) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UnregisterFromDataNotificationsRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UnregisterFromDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static UnregisterFromDataNotificationsRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnregisterFromDataNotificationsRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(CodedInputStream input) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UnregisterFromDataNotificationsRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UnregisterFromDataNotificationsRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UnregisterFromDataNotificationsRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UnregisterFromDataNotificationsRequest, Builder> implements UnregisterFromDataNotificationsRequestOrBuilder {
            private Builder() {
                super(UnregisterFromDataNotificationsRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
            public boolean hasNotificationIntentAction() {
                return ((UnregisterFromDataNotificationsRequest) this.instance).hasNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
            public String getNotificationIntentAction() {
                return ((UnregisterFromDataNotificationsRequest) this.instance).getNotificationIntentAction();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UnregisterFromDataNotificationsRequestOrBuilder
            public ByteString getNotificationIntentActionBytes() {
                return ((UnregisterFromDataNotificationsRequest) this.instance).getNotificationIntentActionBytes();
            }

            public Builder setNotificationIntentAction(String value) {
                copyOnWrite();
                ((UnregisterFromDataNotificationsRequest) this.instance).setNotificationIntentAction(value);
                return this;
            }

            public Builder clearNotificationIntentAction() {
                copyOnWrite();
                ((UnregisterFromDataNotificationsRequest) this.instance).clearNotificationIntentAction();
                return this;
            }

            public Builder setNotificationIntentActionBytes(ByteString value) {
                copyOnWrite();
                ((UnregisterFromDataNotificationsRequest) this.instance).setNotificationIntentActionBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new UnregisterFromDataNotificationsRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "notificationIntentAction_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UnregisterFromDataNotificationsRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (UnregisterFromDataNotificationsRequest.class) {
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
            UnregisterFromDataNotificationsRequest defaultInstance = new UnregisterFromDataNotificationsRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(UnregisterFromDataNotificationsRequest.class, defaultInstance);
        }

        public static UnregisterFromDataNotificationsRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UnregisterFromDataNotificationsRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class UpsertExerciseRouteRequest extends GeneratedMessageLite<UpsertExerciseRouteRequest, Builder> implements UpsertExerciseRouteRequestOrBuilder {
        private static final UpsertExerciseRouteRequest DEFAULT_INSTANCE;
        public static final int EXERCISEROUTE_FIELD_NUMBER = 2;
        private static volatile Parser<UpsertExerciseRouteRequest> PARSER = null;
        public static final int SESSIONUID_FIELD_NUMBER = 1;
        private int bitField0_;
        private DataProto.DataPoint exerciseRoute_;
        private String sessionUid_ = "";

        private UpsertExerciseRouteRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public boolean hasSessionUid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public String getSessionUid() {
            return this.sessionUid_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public ByteString getSessionUidBytes() {
            return ByteString.copyFromUtf8(this.sessionUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUid(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.sessionUid_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionUid() {
            this.bitField0_ &= -2;
            this.sessionUid_ = getDefaultInstance().getSessionUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUidBytes(ByteString value) {
            this.sessionUid_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public boolean hasExerciseRoute() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
        public DataProto.DataPoint getExerciseRoute() {
            return this.exerciseRoute_ == null ? DataProto.DataPoint.getDefaultInstance() : this.exerciseRoute_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setExerciseRoute(DataProto.DataPoint value) {
            value.getClass();
            this.exerciseRoute_ = value;
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeExerciseRoute(DataProto.DataPoint value) {
            value.getClass();
            if (this.exerciseRoute_ != null && this.exerciseRoute_ != DataProto.DataPoint.getDefaultInstance()) {
                this.exerciseRoute_ = DataProto.DataPoint.newBuilder(this.exerciseRoute_).mergeFrom((DataProto.DataPoint.Builder) value).buildPartial();
            } else {
                this.exerciseRoute_ = value;
            }
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearExerciseRoute() {
            this.exerciseRoute_ = null;
            this.bitField0_ &= -3;
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UpsertExerciseRouteRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UpsertExerciseRouteRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static UpsertExerciseRouteRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static UpsertExerciseRouteRequest parseFrom(InputStream input) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UpsertExerciseRouteRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UpsertExerciseRouteRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (UpsertExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static UpsertExerciseRouteRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpsertExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static UpsertExerciseRouteRequest parseFrom(CodedInputStream input) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static UpsertExerciseRouteRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (UpsertExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(UpsertExerciseRouteRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<UpsertExerciseRouteRequest, Builder> implements UpsertExerciseRouteRequestOrBuilder {
            private Builder() {
                super(UpsertExerciseRouteRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public boolean hasSessionUid() {
                return ((UpsertExerciseRouteRequest) this.instance).hasSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public String getSessionUid() {
                return ((UpsertExerciseRouteRequest) this.instance).getSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public ByteString getSessionUidBytes() {
                return ((UpsertExerciseRouteRequest) this.instance).getSessionUidBytes();
            }

            public Builder setSessionUid(String value) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setSessionUid(value);
                return this;
            }

            public Builder clearSessionUid() {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).clearSessionUid();
                return this;
            }

            public Builder setSessionUidBytes(ByteString value) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setSessionUidBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public boolean hasExerciseRoute() {
                return ((UpsertExerciseRouteRequest) this.instance).hasExerciseRoute();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.UpsertExerciseRouteRequestOrBuilder
            public DataProto.DataPoint getExerciseRoute() {
                return ((UpsertExerciseRouteRequest) this.instance).getExerciseRoute();
            }

            public Builder setExerciseRoute(DataProto.DataPoint value) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setExerciseRoute(value);
                return this;
            }

            public Builder setExerciseRoute(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).setExerciseRoute(builderForValue.build());
                return this;
            }

            public Builder mergeExerciseRoute(DataProto.DataPoint value) {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).mergeExerciseRoute(value);
                return this;
            }

            public Builder clearExerciseRoute() {
                copyOnWrite();
                ((UpsertExerciseRouteRequest) this.instance).clearExerciseRoute();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new UpsertExerciseRouteRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "sessionUid_", "exerciseRoute_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဉ\u0001", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<UpsertExerciseRouteRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (UpsertExerciseRouteRequest.class) {
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
            UpsertExerciseRouteRequest defaultInstance = new UpsertExerciseRouteRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(UpsertExerciseRouteRequest.class, defaultInstance);
        }

        public static UpsertExerciseRouteRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<UpsertExerciseRouteRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadExerciseRouteRequest extends GeneratedMessageLite<ReadExerciseRouteRequest, Builder> implements ReadExerciseRouteRequestOrBuilder {
        private static final ReadExerciseRouteRequest DEFAULT_INSTANCE;
        private static volatile Parser<ReadExerciseRouteRequest> PARSER = null;
        public static final int SESSIONUID_FIELD_NUMBER = 1;
        private int bitField0_;
        private String sessionUid_ = "";

        private ReadExerciseRouteRequest() {
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
        public boolean hasSessionUid() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
        public String getSessionUid() {
            return this.sessionUid_;
        }

        @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
        public ByteString getSessionUidBytes() {
            return ByteString.copyFromUtf8(this.sessionUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUid(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.sessionUid_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearSessionUid() {
            this.bitField0_ &= -2;
            this.sessionUid_ = getDefaultInstance().getSessionUid();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setSessionUidBytes(ByteString value) {
            this.sessionUid_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static ReadExerciseRouteRequest parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadExerciseRouteRequest parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadExerciseRouteRequest parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadExerciseRouteRequest parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadExerciseRouteRequest parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadExerciseRouteRequest parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadExerciseRouteRequest parseFrom(InputStream input) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadExerciseRouteRequest parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadExerciseRouteRequest parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadExerciseRouteRequest parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadExerciseRouteRequest) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadExerciseRouteRequest parseFrom(CodedInputStream input) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadExerciseRouteRequest parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadExerciseRouteRequest) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadExerciseRouteRequest prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadExerciseRouteRequest, Builder> implements ReadExerciseRouteRequestOrBuilder {
            private Builder() {
                super(ReadExerciseRouteRequest.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
            public boolean hasSessionUid() {
                return ((ReadExerciseRouteRequest) this.instance).hasSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
            public String getSessionUid() {
                return ((ReadExerciseRouteRequest) this.instance).getSessionUid();
            }

            @Override // androidx.health.platform.client.proto.RequestProto.ReadExerciseRouteRequestOrBuilder
            public ByteString getSessionUidBytes() {
                return ((ReadExerciseRouteRequest) this.instance).getSessionUidBytes();
            }

            public Builder setSessionUid(String value) {
                copyOnWrite();
                ((ReadExerciseRouteRequest) this.instance).setSessionUid(value);
                return this;
            }

            public Builder clearSessionUid() {
                copyOnWrite();
                ((ReadExerciseRouteRequest) this.instance).clearSessionUid();
                return this;
            }

            public Builder setSessionUidBytes(ByteString value) {
                copyOnWrite();
                ((ReadExerciseRouteRequest) this.instance).setSessionUidBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadExerciseRouteRequest();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "sessionUid_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadExerciseRouteRequest> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadExerciseRouteRequest.class) {
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
            ReadExerciseRouteRequest defaultInstance = new ReadExerciseRouteRequest();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadExerciseRouteRequest.class, defaultInstance);
        }

        public static ReadExerciseRouteRequest getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadExerciseRouteRequest> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
