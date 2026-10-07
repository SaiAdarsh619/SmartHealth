package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes14.dex */
public final class ChangeProto {

    public interface ChangesEventOrBuilder extends MessageLiteOrBuilder {
        DataChange getChanges(int i);

        int getChangesCount();

        List<DataChange> getChangesList();

        String getNextChangesToken();

        ByteString getNextChangesTokenBytes();

        boolean hasNextChangesToken();
    }

    public interface DataChangeOrBuilder extends MessageLiteOrBuilder {
        DataChange.ChangeCase getChangeCase();

        String getDeleteUid();

        ByteString getDeleteUidBytes();

        DataProto.DataPoint getUpsertDataPoint();

        boolean hasDeleteUid();

        boolean hasUpsertDataPoint();
    }

    private ChangeProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class DataChange extends GeneratedMessageLite<DataChange, Builder> implements DataChangeOrBuilder {
        private static final DataChange DEFAULT_INSTANCE;
        public static final int DELETE_UID_FIELD_NUMBER = 2;
        private static volatile Parser<DataChange> PARSER = null;
        public static final int UPSERT_DATA_POINT_FIELD_NUMBER = 1;
        private int changeCase_ = 0;
        private Object change_;

        private DataChange() {
        }

        public enum ChangeCase {
            UPSERT_DATA_POINT(1),
            DELETE_UID(2),
            CHANGE_NOT_SET(0);

            private final int value;

            ChangeCase(int value) {
                this.value = value;
            }

            @Deprecated
            public static ChangeCase valueOf(int value) {
                return forNumber(value);
            }

            public static ChangeCase forNumber(int value) {
                switch (value) {
                    case 0:
                        return CHANGE_NOT_SET;
                    case 1:
                        return UPSERT_DATA_POINT;
                    case 2:
                        return DELETE_UID;
                    default:
                        return null;
                }
            }

            public int getNumber() {
                return this.value;
            }
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public ChangeCase getChangeCase() {
            return ChangeCase.forNumber(this.changeCase_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearChange() {
            this.changeCase_ = 0;
            this.change_ = null;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public boolean hasUpsertDataPoint() {
            return this.changeCase_ == 1;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public DataProto.DataPoint getUpsertDataPoint() {
            if (this.changeCase_ == 1) {
                return (DataProto.DataPoint) this.change_;
            }
            return DataProto.DataPoint.getDefaultInstance();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setUpsertDataPoint(DataProto.DataPoint value) {
            value.getClass();
            this.change_ = value;
            this.changeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void mergeUpsertDataPoint(DataProto.DataPoint value) {
            value.getClass();
            if (this.changeCase_ == 1 && this.change_ != DataProto.DataPoint.getDefaultInstance()) {
                this.change_ = DataProto.DataPoint.newBuilder((DataProto.DataPoint) this.change_).mergeFrom((DataProto.DataPoint.Builder) value).buildPartial();
            } else {
                this.change_ = value;
            }
            this.changeCase_ = 1;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearUpsertDataPoint() {
            if (this.changeCase_ == 1) {
                this.changeCase_ = 0;
                this.change_ = null;
            }
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public boolean hasDeleteUid() {
            return this.changeCase_ == 2;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public String getDeleteUid() {
            if (this.changeCase_ != 2) {
                return "";
            }
            String ref = (String) this.change_;
            return ref;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
        public ByteString getDeleteUidBytes() {
            String ref = "";
            if (this.changeCase_ == 2) {
                ref = (String) this.change_;
            }
            return ByteString.copyFromUtf8(ref);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeleteUid(String value) {
            value.getClass();
            this.changeCase_ = 2;
            this.change_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearDeleteUid() {
            if (this.changeCase_ == 2) {
                this.changeCase_ = 0;
                this.change_ = null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setDeleteUidBytes(ByteString value) {
            this.change_ = value.toStringUtf8();
            this.changeCase_ = 2;
        }

        public static DataChange parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataChange parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataChange parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataChange parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataChange parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static DataChange parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static DataChange parseFrom(InputStream input) throws IOException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataChange parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataChange parseDelimitedFrom(InputStream input) throws IOException {
            return (DataChange) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static DataChange parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataChange) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static DataChange parseFrom(CodedInputStream input) throws IOException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static DataChange parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (DataChange) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(DataChange prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<DataChange, Builder> implements DataChangeOrBuilder {
            private Builder() {
                super(DataChange.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public ChangeCase getChangeCase() {
                return ((DataChange) this.instance).getChangeCase();
            }

            public Builder clearChange() {
                copyOnWrite();
                ((DataChange) this.instance).clearChange();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public boolean hasUpsertDataPoint() {
                return ((DataChange) this.instance).hasUpsertDataPoint();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public DataProto.DataPoint getUpsertDataPoint() {
                return ((DataChange) this.instance).getUpsertDataPoint();
            }

            public Builder setUpsertDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((DataChange) this.instance).setUpsertDataPoint(value);
                return this;
            }

            public Builder setUpsertDataPoint(DataProto.DataPoint.Builder builderForValue) {
                copyOnWrite();
                ((DataChange) this.instance).setUpsertDataPoint(builderForValue.build());
                return this;
            }

            public Builder mergeUpsertDataPoint(DataProto.DataPoint value) {
                copyOnWrite();
                ((DataChange) this.instance).mergeUpsertDataPoint(value);
                return this;
            }

            public Builder clearUpsertDataPoint() {
                copyOnWrite();
                ((DataChange) this.instance).clearUpsertDataPoint();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public boolean hasDeleteUid() {
                return ((DataChange) this.instance).hasDeleteUid();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public String getDeleteUid() {
                return ((DataChange) this.instance).getDeleteUid();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.DataChangeOrBuilder
            public ByteString getDeleteUidBytes() {
                return ((DataChange) this.instance).getDeleteUidBytes();
            }

            public Builder setDeleteUid(String value) {
                copyOnWrite();
                ((DataChange) this.instance).setDeleteUid(value);
                return this;
            }

            public Builder clearDeleteUid() {
                copyOnWrite();
                ((DataChange) this.instance).clearDeleteUid();
                return this;
            }

            public Builder setDeleteUidBytes(ByteString value) {
                copyOnWrite();
                ((DataChange) this.instance).setDeleteUidBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new DataChange();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"change_", "changeCase_", DataProto.DataPoint.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0001\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001<\u0000\u0002;\u0000", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<DataChange> parser = PARSER;
                    if (parser == null) {
                        synchronized (DataChange.class) {
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
            DataChange defaultInstance = new DataChange();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(DataChange.class, defaultInstance);
        }

        public static DataChange getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<DataChange> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }

    public static final class ChangesEvent extends GeneratedMessageLite<ChangesEvent, Builder> implements ChangesEventOrBuilder {
        public static final int CHANGES_FIELD_NUMBER = 2;
        private static final ChangesEvent DEFAULT_INSTANCE;
        public static final int NEXT_CHANGES_TOKEN_FIELD_NUMBER = 1;
        private static volatile Parser<ChangesEvent> PARSER;
        private int bitField0_;
        private String nextChangesToken_ = "";
        private Internal.ProtobufList<DataChange> changes_ = emptyProtobufList();

        private ChangesEvent() {
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public boolean hasNextChangesToken() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public String getNextChangesToken() {
            return this.nextChangesToken_;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public ByteString getNextChangesTokenBytes() {
            return ByteString.copyFromUtf8(this.nextChangesToken_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesToken(String value) {
            value.getClass();
            this.bitField0_ |= 1;
            this.nextChangesToken_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearNextChangesToken() {
            this.bitField0_ &= -2;
            this.nextChangesToken_ = getDefaultInstance().getNextChangesToken();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setNextChangesTokenBytes(ByteString value) {
            this.nextChangesToken_ = value.toStringUtf8();
            this.bitField0_ |= 1;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public List<DataChange> getChangesList() {
            return this.changes_;
        }

        public List<? extends DataChangeOrBuilder> getChangesOrBuilderList() {
            return this.changes_;
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public int getChangesCount() {
            return this.changes_.size();
        }

        @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
        public DataChange getChanges(int index) {
            return this.changes_.get(index);
        }

        public DataChangeOrBuilder getChangesOrBuilder(int index) {
            return this.changes_.get(index);
        }

        private void ensureChangesIsMutable() {
            Internal.ProtobufList<DataChange> tmp = this.changes_;
            if (!tmp.isModifiable()) {
                this.changes_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setChanges(int index, DataChange value) {
            value.getClass();
            ensureChangesIsMutable();
            this.changes_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(DataChange value) {
            value.getClass();
            ensureChangesIsMutable();
            this.changes_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addChanges(int index, DataChange value) {
            value.getClass();
            ensureChangesIsMutable();
            this.changes_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllChanges(Iterable<? extends DataChange> values) {
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

        public static ChangesEvent parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ChangesEvent parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ChangesEvent parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ChangesEvent parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ChangesEvent parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ChangesEvent parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ChangesEvent parseFrom(InputStream input) throws IOException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ChangesEvent parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ChangesEvent parseDelimitedFrom(InputStream input) throws IOException {
            return (ChangesEvent) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ChangesEvent parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangesEvent) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ChangesEvent parseFrom(CodedInputStream input) throws IOException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ChangesEvent parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ChangesEvent) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ChangesEvent prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ChangesEvent, Builder> implements ChangesEventOrBuilder {
            private Builder() {
                super(ChangesEvent.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public boolean hasNextChangesToken() {
                return ((ChangesEvent) this.instance).hasNextChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public String getNextChangesToken() {
                return ((ChangesEvent) this.instance).getNextChangesToken();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public ByteString getNextChangesTokenBytes() {
                return ((ChangesEvent) this.instance).getNextChangesTokenBytes();
            }

            public Builder setNextChangesToken(String value) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setNextChangesToken(value);
                return this;
            }

            public Builder clearNextChangesToken() {
                copyOnWrite();
                ((ChangesEvent) this.instance).clearNextChangesToken();
                return this;
            }

            public Builder setNextChangesTokenBytes(ByteString value) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setNextChangesTokenBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public List<DataChange> getChangesList() {
                return Collections.unmodifiableList(((ChangesEvent) this.instance).getChangesList());
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public int getChangesCount() {
                return ((ChangesEvent) this.instance).getChangesCount();
            }

            @Override // androidx.health.platform.client.proto.ChangeProto.ChangesEventOrBuilder
            public DataChange getChanges(int index) {
                return ((ChangesEvent) this.instance).getChanges(index);
            }

            public Builder setChanges(int index, DataChange value) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setChanges(index, value);
                return this;
            }

            public Builder setChanges(int index, DataChange.Builder builderForValue) {
                copyOnWrite();
                ((ChangesEvent) this.instance).setChanges(index, builderForValue.build());
                return this;
            }

            public Builder addChanges(DataChange value) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(value);
                return this;
            }

            public Builder addChanges(int index, DataChange value) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(index, value);
                return this;
            }

            public Builder addChanges(DataChange.Builder builderForValue) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(builderForValue.build());
                return this;
            }

            public Builder addChanges(int index, DataChange.Builder builderForValue) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addChanges(index, builderForValue.build());
                return this;
            }

            public Builder addAllChanges(Iterable<? extends DataChange> values) {
                copyOnWrite();
                ((ChangesEvent) this.instance).addAllChanges(values);
                return this;
            }

            public Builder clearChanges() {
                copyOnWrite();
                ((ChangesEvent) this.instance).clearChanges();
                return this;
            }

            public Builder removeChanges(int index) {
                copyOnWrite();
                ((ChangesEvent) this.instance).removeChanges(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ChangesEvent();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "nextChangesToken_", "changes_", DataChange.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ChangesEvent> parser = PARSER;
                    if (parser == null) {
                        synchronized (ChangesEvent.class) {
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
            ChangesEvent defaultInstance = new ChangesEvent();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ChangesEvent.class, defaultInstance);
        }

        public static ChangesEvent getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ChangesEvent> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
