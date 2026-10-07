package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.GeneratedMessageLite;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes14.dex */
public final class TimeProto {

    public interface TimeSpecOrBuilder extends MessageLiteOrBuilder {
        String getEndLocalDateTime();

        ByteString getEndLocalDateTimeBytes();

        long getEndTimeEpochMs();

        String getStartLocalDateTime();

        ByteString getStartLocalDateTimeBytes();

        long getStartTimeEpochMs();

        boolean hasEndLocalDateTime();

        boolean hasEndTimeEpochMs();

        boolean hasStartLocalDateTime();

        boolean hasStartTimeEpochMs();
    }

    private TimeProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class TimeSpec extends GeneratedMessageLite<TimeSpec, Builder> implements TimeSpecOrBuilder {
        private static final TimeSpec DEFAULT_INSTANCE;
        public static final int END_LOCAL_DATE_TIME_FIELD_NUMBER = 4;
        public static final int END_TIME_EPOCH_MS_FIELD_NUMBER = 2;
        private static volatile Parser<TimeSpec> PARSER = null;
        public static final int START_LOCAL_DATE_TIME_FIELD_NUMBER = 3;
        public static final int START_TIME_EPOCH_MS_FIELD_NUMBER = 1;
        private int bitField0_;
        private long endTimeEpochMs_;
        private long startTimeEpochMs_;
        private String startLocalDateTime_ = "";
        private String endLocalDateTime_ = "";

        private TimeSpec() {
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasStartTimeEpochMs() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
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

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasEndTimeEpochMs() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
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

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasStartLocalDateTime() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public String getStartLocalDateTime() {
            return this.startLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
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

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public boolean hasEndLocalDateTime() {
            return (this.bitField0_ & 8) != 0;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
        public String getEndLocalDateTime() {
            return this.endLocalDateTime_;
        }

        @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
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

        public static TimeSpec parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static TimeSpec parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static TimeSpec parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static TimeSpec parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static TimeSpec parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static TimeSpec parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static TimeSpec parseFrom(InputStream input) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static TimeSpec parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static TimeSpec parseDelimitedFrom(InputStream input) throws IOException {
            return (TimeSpec) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static TimeSpec parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TimeSpec) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static TimeSpec parseFrom(CodedInputStream input) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static TimeSpec parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (TimeSpec) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(TimeSpec prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<TimeSpec, Builder> implements TimeSpecOrBuilder {
            private Builder() {
                super(TimeSpec.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasStartTimeEpochMs() {
                return ((TimeSpec) this.instance).hasStartTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public long getStartTimeEpochMs() {
                return ((TimeSpec) this.instance).getStartTimeEpochMs();
            }

            public Builder setStartTimeEpochMs(long value) {
                copyOnWrite();
                ((TimeSpec) this.instance).setStartTimeEpochMs(value);
                return this;
            }

            public Builder clearStartTimeEpochMs() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearStartTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasEndTimeEpochMs() {
                return ((TimeSpec) this.instance).hasEndTimeEpochMs();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public long getEndTimeEpochMs() {
                return ((TimeSpec) this.instance).getEndTimeEpochMs();
            }

            public Builder setEndTimeEpochMs(long value) {
                copyOnWrite();
                ((TimeSpec) this.instance).setEndTimeEpochMs(value);
                return this;
            }

            public Builder clearEndTimeEpochMs() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearEndTimeEpochMs();
                return this;
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasStartLocalDateTime() {
                return ((TimeSpec) this.instance).hasStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public String getStartLocalDateTime() {
                return ((TimeSpec) this.instance).getStartLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public ByteString getStartLocalDateTimeBytes() {
                return ((TimeSpec) this.instance).getStartLocalDateTimeBytes();
            }

            public Builder setStartLocalDateTime(String value) {
                copyOnWrite();
                ((TimeSpec) this.instance).setStartLocalDateTime(value);
                return this;
            }

            public Builder clearStartLocalDateTime() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearStartLocalDateTime();
                return this;
            }

            public Builder setStartLocalDateTimeBytes(ByteString value) {
                copyOnWrite();
                ((TimeSpec) this.instance).setStartLocalDateTimeBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public boolean hasEndLocalDateTime() {
                return ((TimeSpec) this.instance).hasEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public String getEndLocalDateTime() {
                return ((TimeSpec) this.instance).getEndLocalDateTime();
            }

            @Override // androidx.health.platform.client.proto.TimeProto.TimeSpecOrBuilder
            public ByteString getEndLocalDateTimeBytes() {
                return ((TimeSpec) this.instance).getEndLocalDateTimeBytes();
            }

            public Builder setEndLocalDateTime(String value) {
                copyOnWrite();
                ((TimeSpec) this.instance).setEndLocalDateTime(value);
                return this;
            }

            public Builder clearEndLocalDateTime() {
                copyOnWrite();
                ((TimeSpec) this.instance).clearEndLocalDateTime();
                return this;
            }

            public Builder setEndLocalDateTimeBytes(ByteString value) {
                copyOnWrite();
                ((TimeSpec) this.instance).setEndLocalDateTimeBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new TimeSpec();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "startTimeEpochMs_", "endTimeEpochMs_", "startLocalDateTime_", "endLocalDateTime_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<TimeSpec> parser = PARSER;
                    if (parser == null) {
                        synchronized (TimeSpec.class) {
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
            TimeSpec defaultInstance = new TimeSpec();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(TimeSpec.class, defaultInstance);
        }

        public static TimeSpec getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<TimeSpec> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
