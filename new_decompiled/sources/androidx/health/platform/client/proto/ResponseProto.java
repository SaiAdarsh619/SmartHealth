package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.ChangeProto;
import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes14.dex */
public final class ResponseProto {

    public interface AggregateDataResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.AggregateDataRow getRows(int i);

        int getRowsCount();

        List<DataProto.AggregateDataRow> getRowsList();
    }

    public interface GetChangesResponseOrBuilder extends MessageLiteOrBuilder {
        ChangeProto.DataChange getChanges(int i);

        int getChangesCount();

        List<ChangeProto.DataChange> getChangesList();

        boolean getChangesTokenExpired();

        boolean getHasMore();

        String getNextChangesToken();

        ByteString getNextChangesTokenBytes();

        boolean hasChangesTokenExpired();

        boolean hasHasMore();

        boolean hasNextChangesToken();
    }

    public interface GetChangesTokenResponseOrBuilder extends MessageLiteOrBuilder {
        String getChangesToken();

        ByteString getChangesTokenBytes();

        boolean hasChangesToken();
    }

    public interface InsertDataResponseOrBuilder extends MessageLiteOrBuilder {
        String getDataPointUid(int i);

        ByteString getDataPointUidBytes(int i);

        int getDataPointUidCount();

        List<String> getDataPointUidList();
    }

    public interface ReadDataPointResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getData();

        boolean hasData();
    }

    public interface ReadDataRangeResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint(int i);

        int getDataPointCount();

        List<DataProto.DataPoint> getDataPointList();

        String getPageToken();

        ByteString getPageTokenBytes();

        boolean hasPageToken();
    }

    public interface ReadDataResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint();

        boolean hasDataPoint();
    }

    public interface ReadExerciseRouteResponseOrBuilder extends MessageLiteOrBuilder {
        DataProto.DataPoint getDataPoint();

        boolean hasDataPoint();
    }

    private ResponseProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class ReadDataPointResponse extends GeneratedMessageLite<ReadDataPointResponse, Builder> implements ReadDataPointResponseOrBuilder {
        public static final int DATA_FIELD_NUMBER = 1;
        private static final ReadDataPointResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataPointResponse> PARSER;
        private int bitField0_;
        private DataProto.DataPoint data_;

        private ReadDataPointResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
        public boolean hasData() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
        public DataProto.DataPoint getData() {
            return this.data_ == null ? DataProto.DataPoint.getDefaultInstance() : this.data_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setData(DataProto.DataPoint value) {
            value.getClass();
            this.data_ = value;
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeData(DataProto.DataPoint value) {
            value.getClass();
            if (this.data_ != null && this.data_ != DataProto.DataPoint.getDefaultInstance()) {
                this.data_ = DataProto.DataPoint.newBuilder(this.data_).mergeFrom((DataProto.DataPoint.Builder) value).buildPartial();
            } else {
                this.data_ = value;
            }
            this.bitField0_ |= 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearData() {
            this.data_ = null;
            this.bitField0_ &= -2;
        }

        public static ReadDataPointResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataPointResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataPointResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataPointResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataPointResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataPointResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataPointResponse parseFrom(InputStream input) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataPointResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataPointResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadDataPointResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataPointResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataPointResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataPointResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataPointResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataPointResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataPointResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataPointResponse, Builder> implements ReadDataPointResponseOrBuilder {
            private Builder() {
                super(ReadDataPointResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
            public boolean hasData() {
                return ((ReadDataPointResponse) this.instance).hasData();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataPointResponseOrBuilder
            public DataProto.DataPoint getData() {
                return ((ReadDataPointResponse) this.instance).getData();
            }

            public Builder setData(DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).setData(value);
                return this;
            }

            public Builder setData(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).setData(builderForValue.build());
                return this;
            }

            public Builder mergeData(DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).mergeData(value);
                return this;
            }

            public Builder clearData() {
                copyOnWrite();
                ((ReadDataPointResponse) this.instance).clearData();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadDataPointResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "data_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadDataPointResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDataPointResponse.class) {
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
            ReadDataPointResponse defaultInstance = new ReadDataPointResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadDataPointResponse.class, defaultInstance);
        }

        public static ReadDataPointResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataPointResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class InsertDataResponse extends GeneratedMessageLite<InsertDataResponse, Builder> implements InsertDataResponseOrBuilder {
        public static final int DATA_POINT_UID_FIELD_NUMBER = 1;
        private static final InsertDataResponse DEFAULT_INSTANCE;
        private static volatile Parser<InsertDataResponse> PARSER;
        private Internal.ProtobufList<String> dataPointUid_ = GeneratedMessageLite.emptyProtobufList();

        private InsertDataResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public List<String> getDataPointUidList() {
            return this.dataPointUid_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public int getDataPointUidCount() {
            return this.dataPointUid_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public String getDataPointUid(int index) {
            return this.dataPointUid_.get(index);
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
        public ByteString getDataPointUidBytes(int index) {
            return ByteString.copyFromUtf8(this.dataPointUid_.get(index));
        }

        private void ensureDataPointUidIsMutable() {
            Internal.ProtobufList<String> tmp = this.dataPointUid_;
            if (!tmp.isModifiable()) {
                this.dataPointUid_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDataPointUid(int index, String value) {
            value.getClass();
            ensureDataPointUidIsMutable();
            this.dataPointUid_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPointUid(String value) {
            value.getClass();
            ensureDataPointUidIsMutable();
            this.dataPointUid_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllDataPointUid(Iterable<String> values) {
            ensureDataPointUidIsMutable();
            AbstractMessageLite.addAll(values, this.dataPointUid_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDataPointUid() {
            this.dataPointUid_ = GeneratedMessageLite.emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addDataPointUidBytes(ByteString value) {
            ensureDataPointUidIsMutable();
            this.dataPointUid_.add(value.toStringUtf8());
        }

        public static InsertDataResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static InsertDataResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static InsertDataResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static InsertDataResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static InsertDataResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static InsertDataResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static InsertDataResponse parseFrom(InputStream input) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static InsertDataResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static InsertDataResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (InsertDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static InsertDataResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InsertDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static InsertDataResponse parseFrom(CodedInputStream input) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static InsertDataResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (InsertDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(InsertDataResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<InsertDataResponse, Builder> implements InsertDataResponseOrBuilder {
            private Builder() {
                super(InsertDataResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public List<String> getDataPointUidList() {
                return Collections.unmodifiableList(((InsertDataResponse) this.instance).getDataPointUidList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public int getDataPointUidCount() {
                return ((InsertDataResponse) this.instance).getDataPointUidCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public String getDataPointUid(int index) {
                return ((InsertDataResponse) this.instance).getDataPointUid(index);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.InsertDataResponseOrBuilder
            public ByteString getDataPointUidBytes(int index) {
                return ((InsertDataResponse) this.instance).getDataPointUidBytes(index);
            }

            public Builder setDataPointUid(int index, String value) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).setDataPointUid(index, value);
                return this;
            }

            public Builder addDataPointUid(String value) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).addDataPointUid(value);
                return this;
            }

            public Builder addAllDataPointUid(Iterable<String> values) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).addAllDataPointUid(values);
                return this;
            }

            public Builder clearDataPointUid() {
                copyOnWrite();
                ((InsertDataResponse) this.instance).clearDataPointUid();
                return this;
            }

            public Builder addDataPointUidBytes(ByteString value) {
                copyOnWrite();
                ((InsertDataResponse) this.instance).addDataPointUidBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new InsertDataResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"dataPointUid_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001a", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<InsertDataResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (InsertDataResponse.class) {
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
            InsertDataResponse defaultInstance = new InsertDataResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(InsertDataResponse.class, defaultInstance);
        }

        public static InsertDataResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<InsertDataResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataResponse extends GeneratedMessageLite<ReadDataResponse, Builder> implements ReadDataResponseOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final ReadDataResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadDataResponse> PARSER;
        private int bitField0_;
        private DataProto.DataPoint dataPoint_;

        private ReadDataResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
        public boolean hasDataPoint() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
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

        public static ReadDataResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataResponse parseFrom(InputStream input) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataResponse, Builder> implements ReadDataResponseOrBuilder {
            private Builder() {
                super(ReadDataResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
            public boolean hasDataPoint() {
                return ((ReadDataResponse) this.instance).hasDataPoint();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataResponseOrBuilder
            public DataProto.DataPoint getDataPoint() {
                return ((ReadDataResponse) this.instance).getDataPoint();
            }

            public Builder setDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadDataResponse) this.instance).setDataPoint(value);
                return this;
            }

            public Builder setDataPoint(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataResponse) this.instance).setDataPoint(builderForValue.build());
                return this;
            }

            public Builder mergeDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadDataResponse) this.instance).mergeDataPoint(value);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((ReadDataResponse) this.instance).clearDataPoint();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadDataResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataPoint_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadDataResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDataResponse.class) {
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
            ReadDataResponse defaultInstance = new ReadDataResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadDataResponse.class, defaultInstance);
        }

        public static ReadDataResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadDataRangeResponse extends GeneratedMessageLite<ReadDataRangeResponse, Builder> implements ReadDataRangeResponseOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final ReadDataRangeResponse DEFAULT_INSTANCE;
        public static final int PAGE_TOKEN_FIELD_NUMBER = 2;
        private static volatile Parser<ReadDataRangeResponse> PARSER;
        private int bitField0_;
        private Internal.ProtobufList<DataProto.DataPoint> dataPoint_ = emptyProtobufList();
        private String pageToken_ = "";

        private ReadDataRangeResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public List<DataProto.DataPoint> getDataPointList() {
            return this.dataPoint_;
        }

        public List<? extends DataProto.DataPointOrBuilder> getDataPointOrBuilderList() {
            return this.dataPoint_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public int getDataPointCount() {
            return this.dataPoint_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
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

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public boolean hasPageToken() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public String getPageToken() {
            return this.pageToken_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
        public ByteString getPageTokenBytes() {
            return ByteString.copyFromUtf8(this.pageToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageToken(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.pageToken_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPageToken() {
            this.bitField0_ &= -2;
            this.pageToken_ = getDefaultInstance().getPageToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPageTokenBytes(ByteString value) {
            this.pageToken_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        public static ReadDataRangeResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRangeResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRangeResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRangeResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRangeResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadDataRangeResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadDataRangeResponse parseFrom(InputStream input) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRangeResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataRangeResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadDataRangeResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRangeResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRangeResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadDataRangeResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadDataRangeResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadDataRangeResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadDataRangeResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadDataRangeResponse, Builder> implements ReadDataRangeResponseOrBuilder {
            private Builder() {
                super(ReadDataRangeResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public List<DataProto.DataPoint> getDataPointList() {
                return Collections.unmodifiableList(((ReadDataRangeResponse) this.instance).getDataPointList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public int getDataPointCount() {
                return ((ReadDataRangeResponse) this.instance).getDataPointCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public DataProto.DataPoint getDataPoint(int index) {
                return ((ReadDataRangeResponse) this.instance).getDataPoint(index);
            }

            public Builder setDataPoint(int index, DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setDataPoint(index, value);
                return this;
            }

            public Builder setDataPoint(int index, DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setDataPoint(index, builderForValue.build());
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(value);
                return this;
            }

            public Builder addDataPoint(int index, DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(index, value);
                return this;
            }

            public Builder addDataPoint(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(builderForValue.build());
                return this;
            }

            public Builder addDataPoint(int index, DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addDataPoint(index, builderForValue.build());
                return this;
            }

            public Builder addAllDataPoint(Iterable<? extends DataProto.DataPoint> values) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).addAllDataPoint(values);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).clearDataPoint();
                return this;
            }

            public Builder removeDataPoint(int index) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).removeDataPoint(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public boolean hasPageToken() {
                return ((ReadDataRangeResponse) this.instance).hasPageToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public String getPageToken() {
                return ((ReadDataRangeResponse) this.instance).getPageToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadDataRangeResponseOrBuilder
            public ByteString getPageTokenBytes() {
                return ((ReadDataRangeResponse) this.instance).getPageTokenBytes();
            }

            public Builder setPageToken(String value) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setPageToken(value);
                return this;
            }

            public Builder clearPageToken() {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).clearPageToken();
                return this;
            }

            public Builder setPageTokenBytes(ByteString value) {
                copyOnWrite();
                ((ReadDataRangeResponse) this.instance).setPageTokenBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadDataRangeResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataPoint_", DataProto.DataPoint.class, "pageToken_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadDataRangeResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadDataRangeResponse.class) {
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
            ReadDataRangeResponse defaultInstance = new ReadDataRangeResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadDataRangeResponse.class, defaultInstance);
        }

        public static ReadDataRangeResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadDataRangeResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ReadExerciseRouteResponse extends GeneratedMessageLite<ReadExerciseRouteResponse, Builder> implements ReadExerciseRouteResponseOrBuilder {
        public static final int DATA_POINT_FIELD_NUMBER = 1;
        private static final ReadExerciseRouteResponse DEFAULT_INSTANCE;
        private static volatile Parser<ReadExerciseRouteResponse> PARSER;
        private int bitField0_;
        private DataProto.DataPoint dataPoint_;

        private ReadExerciseRouteResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
        public boolean hasDataPoint() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
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

        public static ReadExerciseRouteResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadExerciseRouteResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadExerciseRouteResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadExerciseRouteResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadExerciseRouteResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ReadExerciseRouteResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ReadExerciseRouteResponse parseFrom(InputStream input) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadExerciseRouteResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadExerciseRouteResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (ReadExerciseRouteResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadExerciseRouteResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadExerciseRouteResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ReadExerciseRouteResponse parseFrom(CodedInputStream input) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ReadExerciseRouteResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ReadExerciseRouteResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ReadExerciseRouteResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ReadExerciseRouteResponse, Builder> implements ReadExerciseRouteResponseOrBuilder {
            private Builder() {
                super(ReadExerciseRouteResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
            public boolean hasDataPoint() {
                return ((ReadExerciseRouteResponse) this.instance).hasDataPoint();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.ReadExerciseRouteResponseOrBuilder
            public DataProto.DataPoint getDataPoint() {
                return ((ReadExerciseRouteResponse) this.instance).getDataPoint();
            }

            public Builder setDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).setDataPoint(value);
                return this;
            }

            public Builder setDataPoint(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).setDataPoint(builderForValue.build());
                return this;
            }

            public Builder mergeDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).mergeDataPoint(value);
                return this;
            }

            public Builder clearDataPoint() {
                copyOnWrite();
                ((ReadExerciseRouteResponse) this.instance).clearDataPoint();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ReadExerciseRouteResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataPoint_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ReadExerciseRouteResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (ReadExerciseRouteResponse.class) {
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
            ReadExerciseRouteResponse defaultInstance = new ReadExerciseRouteResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ReadExerciseRouteResponse.class, defaultInstance);
        }

        public static ReadExerciseRouteResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ReadExerciseRouteResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class AggregateDataResponse extends GeneratedMessageLite<AggregateDataResponse, Builder> implements AggregateDataResponseOrBuilder {
        private static final AggregateDataResponse DEFAULT_INSTANCE;
        private static volatile Parser<AggregateDataResponse> PARSER = null;
        public static final int ROWS_FIELD_NUMBER = 1;
        private Internal.ProtobufList<DataProto.AggregateDataRow> rows_ = emptyProtobufList();

        private AggregateDataResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
        public List<DataProto.AggregateDataRow> getRowsList() {
            return this.rows_;
        }

        public List<? extends DataProto.AggregateDataRowOrBuilder> getRowsOrBuilderList() {
            return this.rows_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
        public int getRowsCount() {
            return this.rows_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
        public DataProto.AggregateDataRow getRows(int index) {
            return this.rows_.get(index);
        }

        public DataProto.AggregateDataRowOrBuilder getRowsOrBuilder(int index) {
            return this.rows_.get(index);
        }

        private void ensureRowsIsMutable() {
            Internal.ProtobufList<DataProto.AggregateDataRow> tmp = this.rows_;
            if (!tmp.isModifiable()) {
                this.rows_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setRows(int index, DataProto.AggregateDataRow value) {
            value.getClass();
            ensureRowsIsMutable();
            this.rows_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRows(DataProto.AggregateDataRow value) {
            value.getClass();
            ensureRowsIsMutable();
            this.rows_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addRows(int index, DataProto.AggregateDataRow value) {
            value.getClass();
            ensureRowsIsMutable();
            this.rows_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllRows(Iterable<? extends DataProto.AggregateDataRow> values) {
            ensureRowsIsMutable();
            AbstractMessageLite.addAll(values, this.rows_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearRows() {
            this.rows_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeRows(int index) {
            ensureRowsIsMutable();
            this.rows_.remove(index);
        }

        public static AggregateDataResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static AggregateDataResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static AggregateDataResponse parseFrom(InputStream input) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateDataResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (AggregateDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static AggregateDataResponse parseFrom(CodedInputStream input) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static AggregateDataResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (AggregateDataResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(AggregateDataResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<AggregateDataResponse, Builder> implements AggregateDataResponseOrBuilder {
            private Builder() {
                super(AggregateDataResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
            public List<DataProto.AggregateDataRow> getRowsList() {
                return Collections.unmodifiableList(((AggregateDataResponse) this.instance).getRowsList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
            public int getRowsCount() {
                return ((AggregateDataResponse) this.instance).getRowsCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.AggregateDataResponseOrBuilder
            public DataProto.AggregateDataRow getRows(int index) {
                return ((AggregateDataResponse) this.instance).getRows(index);
            }

            public Builder setRows(int index, DataProto.AggregateDataRow value) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).setRows(index, value);
                return this;
            }

            public Builder setRows(int index, DataProto.AggregateDataRow.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).setRows(index, builderForValue.build());
                return this;
            }

            public Builder addRows(DataProto.AggregateDataRow value) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(value);
                return this;
            }

            public Builder addRows(int index, DataProto.AggregateDataRow value) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(index, value);
                return this;
            }

            public Builder addRows(DataProto.AggregateDataRow.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(builderForValue.build());
                return this;
            }

            public Builder addRows(int index, DataProto.AggregateDataRow.Builder builderForValue) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addRows(index, builderForValue.build());
                return this;
            }

            public Builder addAllRows(Iterable<? extends DataProto.AggregateDataRow> values) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).addAllRows(values);
                return this;
            }

            public Builder clearRows() {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).clearRows();
                return this;
            }

            public Builder removeRows(int index) {
                copyOnWrite();
                ((AggregateDataResponse) this.instance).removeRows(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new AggregateDataResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"rows_", DataProto.AggregateDataRow.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<AggregateDataResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (AggregateDataResponse.class) {
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
            AggregateDataResponse defaultInstance = new AggregateDataResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(AggregateDataResponse.class, defaultInstance);
        }

        public static AggregateDataResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<AggregateDataResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesTokenResponse extends GeneratedMessageLite<GetChangesTokenResponse, Builder> implements GetChangesTokenResponseOrBuilder {
        public static final int CHANGES_TOKEN_FIELD_NUMBER = 1;
        private static final GetChangesTokenResponse DEFAULT_INSTANCE;
        private static volatile Parser<GetChangesTokenResponse> PARSER;
        private int bitField0_;
        private String changesToken_ = "";

        private GetChangesTokenResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
        public boolean hasChangesToken() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
        public String getChangesToken() {
            return this.changesToken_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
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

        public static GetChangesTokenResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesTokenResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesTokenResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesTokenResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesTokenResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesTokenResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesTokenResponse parseFrom(InputStream input) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesTokenResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesTokenResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetChangesTokenResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesTokenResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesTokenResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesTokenResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesTokenResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesTokenResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesTokenResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesTokenResponse, Builder> implements GetChangesTokenResponseOrBuilder {
            private Builder() {
                super(GetChangesTokenResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
            public boolean hasChangesToken() {
                return ((GetChangesTokenResponse) this.instance).hasChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
            public String getChangesToken() {
                return ((GetChangesTokenResponse) this.instance).getChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesTokenResponseOrBuilder
            public ByteString getChangesTokenBytes() {
                return ((GetChangesTokenResponse) this.instance).getChangesTokenBytes();
            }

            public Builder setChangesToken(String value) {
                copyOnWrite();
                ((GetChangesTokenResponse) this.instance).setChangesToken(value);
                return this;
            }

            public Builder clearChangesToken() {
                copyOnWrite();
                ((GetChangesTokenResponse) this.instance).clearChangesToken();
                return this;
            }

            public Builder setChangesTokenBytes(ByteString value) {
                copyOnWrite();
                ((GetChangesTokenResponse) this.instance).setChangesTokenBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new GetChangesTokenResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "changesToken_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<GetChangesTokenResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (GetChangesTokenResponse.class) {
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
            GetChangesTokenResponse defaultInstance = new GetChangesTokenResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(GetChangesTokenResponse.class, defaultInstance);
        }

        public static GetChangesTokenResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesTokenResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class GetChangesResponse extends GeneratedMessageLite<GetChangesResponse, Builder> implements GetChangesResponseOrBuilder {
        public static final int CHANGES_FIELD_NUMBER = 1;
        public static final int CHANGES_TOKEN_EXPIRED_FIELD_NUMBER = 4;
        private static final GetChangesResponse DEFAULT_INSTANCE;
        public static final int HAS_MORE_FIELD_NUMBER = 2;
        public static final int NEXT_CHANGES_TOKEN_FIELD_NUMBER = 3;
        private static volatile Parser<GetChangesResponse> PARSER;
        private int bitField0_;
        private boolean changesTokenExpired_;
        private boolean hasMore_;
        private Internal.ProtobufList<ChangeProto.DataChange> changes_ = emptyProtobufList();
        private String nextChangesToken_ = "";

        private GetChangesResponse() {
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public List<ChangeProto.DataChange> getChangesList() {
            return this.changes_;
        }

        public List<? extends ChangeProto.DataChangeOrBuilder> getChangesOrBuilderList() {
            return this.changes_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public int getChangesCount() {
            return this.changes_.size();
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public ChangeProto.DataChange getChanges(int index) {
            return this.changes_.get(index);
        }

        public ChangeProto.DataChangeOrBuilder getChangesOrBuilder(int index) {
            return this.changes_.get(index);
        }

        private void ensureChangesIsMutable() {
            Internal.ProtobufList<ChangeProto.DataChange> tmp = this.changes_;
            if (!tmp.isModifiable()) {
                this.changes_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanges(int index, ChangeProto.DataChange value) {
            value.getClass();
            ensureChangesIsMutable();
            this.changes_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(ChangeProto.DataChange value) {
            value.getClass();
            ensureChangesIsMutable();
            this.changes_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(int index, ChangeProto.DataChange value) {
            value.getClass();
            ensureChangesIsMutable();
            this.changes_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChanges(Iterable<? extends ChangeProto.DataChange> values) {
            ensureChangesIsMutable();
            AbstractMessageLite.addAll(values, this.changes_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChanges() {
            this.changes_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removeChanges(int index) {
            ensureChangesIsMutable();
            this.changes_.remove(index);
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean hasHasMore() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean getHasMore() {
            return this.hasMore_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setHasMore(boolean value) {
            this.bitField0_ |= 1;
            this.hasMore_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearHasMore() {
            this.bitField0_ &= -2;
            this.hasMore_ = false;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean hasNextChangesToken() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public String getNextChangesToken() {
            return this.nextChangesToken_;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public ByteString getNextChangesTokenBytes() {
            return ByteString.copyFromUtf8(this.nextChangesToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesToken(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.nextChangesToken_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNextChangesToken() {
            this.bitField0_ &= -3;
            this.nextChangesToken_ = getDefaultInstance().getNextChangesToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesTokenBytes(ByteString value) {
            this.nextChangesToken_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean hasChangesTokenExpired() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
        public boolean getChangesTokenExpired() {
            return this.changesTokenExpired_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChangesTokenExpired(boolean value) {
            this.bitField0_ |= 4;
            this.changesTokenExpired_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChangesTokenExpired() {
            this.bitField0_ &= -5;
            this.changesTokenExpired_ = false;
        }

        public static GetChangesResponse parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesResponse parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesResponse parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesResponse parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesResponse parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static GetChangesResponse parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static GetChangesResponse parseFrom(InputStream input) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesResponse parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesResponse parseDelimitedFrom(InputStream input) throws IOException {
            return (GetChangesResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesResponse parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesResponse) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static GetChangesResponse parseFrom(CodedInputStream input) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static GetChangesResponse parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (GetChangesResponse) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(GetChangesResponse prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<GetChangesResponse, Builder> implements GetChangesResponseOrBuilder {
            private Builder() {
                super(GetChangesResponse.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public List<ChangeProto.DataChange> getChangesList() {
                return Collections.unmodifiableList(((GetChangesResponse) this.instance).getChangesList());
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public int getChangesCount() {
                return ((GetChangesResponse) this.instance).getChangesCount();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public ChangeProto.DataChange getChanges(int index) {
                return ((GetChangesResponse) this.instance).getChanges(index);
            }

            public Builder setChanges(int index, ChangeProto.DataChange value) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setChanges(index, value);
                return this;
            }

            public Builder setChanges(int index, ChangeProto.DataChange.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setChanges(index, builderForValue.build());
                return this;
            }

            public Builder addChanges(ChangeProto.DataChange value) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(value);
                return this;
            }

            public Builder addChanges(int index, ChangeProto.DataChange value) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(index, value);
                return this;
            }

            public Builder addChanges(ChangeProto.DataChange.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(builderForValue.build());
                return this;
            }

            public Builder addChanges(int index, ChangeProto.DataChange.Builder builderForValue) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addChanges(index, builderForValue.build());
                return this;
            }

            public Builder addAllChanges(Iterable<? extends ChangeProto.DataChange> values) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).addAllChanges(values);
                return this;
            }

            public Builder clearChanges() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearChanges();
                return this;
            }

            public Builder removeChanges(int index) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).removeChanges(index);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean hasHasMore() {
                return ((GetChangesResponse) this.instance).hasHasMore();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean getHasMore() {
                return ((GetChangesResponse) this.instance).getHasMore();
            }

            public Builder setHasMore(boolean value) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setHasMore(value);
                return this;
            }

            public Builder clearHasMore() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearHasMore();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean hasNextChangesToken() {
                return ((GetChangesResponse) this.instance).hasNextChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public String getNextChangesToken() {
                return ((GetChangesResponse) this.instance).getNextChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public ByteString getNextChangesTokenBytes() {
                return ((GetChangesResponse) this.instance).getNextChangesTokenBytes();
            }

            public Builder setNextChangesToken(String value) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setNextChangesToken(value);
                return this;
            }

            public Builder clearNextChangesToken() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearNextChangesToken();
                return this;
            }

            public Builder setNextChangesTokenBytes(ByteString value) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setNextChangesTokenBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean hasChangesTokenExpired() {
                return ((GetChangesResponse) this.instance).hasChangesTokenExpired();
            }

            @Override // androidx.health.platform.client.proto.ResponseProto.GetChangesResponseOrBuilder
            public boolean getChangesTokenExpired() {
                return ((GetChangesResponse) this.instance).getChangesTokenExpired();
            }

            public Builder setChangesTokenExpired(boolean value) {
                copyOnWrite();
                ((GetChangesResponse) this.instance).setChangesTokenExpired(value);
                return this;
            }

            public Builder clearChangesTokenExpired() {
                copyOnWrite();
                ((GetChangesResponse) this.instance).clearChangesTokenExpired();
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new GetChangesResponse();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "changes_", ChangeProto.DataChange.class, "hasMore_", "nextChangesToken_", "changesTokenExpired_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဈ\u0001\u0004ဇ\u0002", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<GetChangesResponse> parser = PARSER;
                    if (parser == null) {
                        synchronized (GetChangesResponse.class) {
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
            GetChangesResponse defaultInstance = new GetChangesResponse();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(GetChangesResponse.class, defaultInstance);
        }

        public static GetChangesResponse getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<GetChangesResponse> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
