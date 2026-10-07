package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import androidx.health.platform.client.proto.PermissionProto;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.Collections;
import java.util.List;

/* loaded from: classes14.dex */
public final class ErrorProto {

    public interface ErrorStatusOrBuilder extends MessageLiteOrBuilder {
        int getCode();

        String getMessage();

        ByteString getMessageBytes();

        PermissionProto.Permission getPermission(int i);

        int getPermissionCount();

        List<PermissionProto.Permission> getPermissionList();

        boolean hasCode();

        boolean hasMessage();
    }

    private ErrorProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public static final class ErrorStatus extends GeneratedMessageLite<ErrorStatus, Builder> implements ErrorStatusOrBuilder {
        public static final int CODE_FIELD_NUMBER = 1;
        private static final ErrorStatus DEFAULT_INSTANCE;
        public static final int MESSAGE_FIELD_NUMBER = 2;
        private static volatile Parser<ErrorStatus> PARSER = null;
        public static final int PERMISSION_FIELD_NUMBER = 3;
        private int bitField0_;
        private int code_;
        private String message_ = "";
        private Internal.ProtobufList<PermissionProto.Permission> permission_ = emptyProtobufList();

        private ErrorStatus() {
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public boolean hasCode() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public int getCode() {
            return this.code_;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCode(int value) {
            this.bitField0_ |= 1;
            this.code_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearCode() {
            this.bitField0_ &= -2;
            this.code_ = 0;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public boolean hasMessage() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public String getMessage() {
            return this.message_;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public ByteString getMessageBytes() {
            return ByteString.copyFromUtf8(this.message_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessage(String value) {
            value.getClass();
            this.bitField0_ |= 2;
            this.message_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearMessage() {
            this.bitField0_ &= -3;
            this.message_ = getDefaultInstance().getMessage();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setMessageBytes(ByteString value) {
            this.message_ = value.toStringUtf8();
            this.bitField0_ |= 2;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public List<PermissionProto.Permission> getPermissionList() {
            return this.permission_;
        }

        public List<? extends PermissionProto.PermissionOrBuilder> getPermissionOrBuilderList() {
            return this.permission_;
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public int getPermissionCount() {
            return this.permission_.size();
        }

        @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
        public PermissionProto.Permission getPermission(int index) {
            return this.permission_.get(index);
        }

        public PermissionProto.PermissionOrBuilder getPermissionOrBuilder(int index) {
            return this.permission_.get(index);
        }

        private void ensurePermissionIsMutable() {
            Internal.ProtobufList<PermissionProto.Permission> tmp = this.permission_;
            if (!tmp.isModifiable()) {
                this.permission_ = GeneratedMessageLite.mutableCopy(tmp);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermission(int index, PermissionProto.Permission value) {
            value.getClass();
            ensurePermissionIsMutable();
            this.permission_.set(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPermission(PermissionProto.Permission value) {
            value.getClass();
            ensurePermissionIsMutable();
            this.permission_.add(value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addPermission(int index, PermissionProto.Permission value) {
            value.getClass();
            ensurePermissionIsMutable();
            this.permission_.add(index, value);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void addAllPermission(Iterable<? extends PermissionProto.Permission> values) {
            ensurePermissionIsMutable();
            AbstractMessageLite.addAll(values, this.permission_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPermission() {
            this.permission_ = emptyProtobufList();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void removePermission(int index) {
            ensurePermissionIsMutable();
            this.permission_.remove(index);
        }

        public static ErrorStatus parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ErrorStatus parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ErrorStatus parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ErrorStatus parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ErrorStatus parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static ErrorStatus parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static ErrorStatus parseFrom(InputStream input) throws IOException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ErrorStatus parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ErrorStatus parseDelimitedFrom(InputStream input) throws IOException {
            return (ErrorStatus) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static ErrorStatus parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrorStatus) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static ErrorStatus parseFrom(CodedInputStream input) throws IOException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static ErrorStatus parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (ErrorStatus) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(ErrorStatus prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<ErrorStatus, Builder> implements ErrorStatusOrBuilder {
            private Builder() {
                super(ErrorStatus.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public boolean hasCode() {
                return ((ErrorStatus) this.instance).hasCode();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public int getCode() {
                return ((ErrorStatus) this.instance).getCode();
            }

            public Builder setCode(int value) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setCode(value);
                return this;
            }

            public Builder clearCode() {
                copyOnWrite();
                ((ErrorStatus) this.instance).clearCode();
                return this;
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public boolean hasMessage() {
                return ((ErrorStatus) this.instance).hasMessage();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public String getMessage() {
                return ((ErrorStatus) this.instance).getMessage();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public ByteString getMessageBytes() {
                return ((ErrorStatus) this.instance).getMessageBytes();
            }

            public Builder setMessage(String value) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setMessage(value);
                return this;
            }

            public Builder clearMessage() {
                copyOnWrite();
                ((ErrorStatus) this.instance).clearMessage();
                return this;
            }

            public Builder setMessageBytes(ByteString value) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setMessageBytes(value);
                return this;
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public List<PermissionProto.Permission> getPermissionList() {
                return Collections.unmodifiableList(((ErrorStatus) this.instance).getPermissionList());
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public int getPermissionCount() {
                return ((ErrorStatus) this.instance).getPermissionCount();
            }

            @Override // androidx.health.platform.client.proto.ErrorProto.ErrorStatusOrBuilder
            public PermissionProto.Permission getPermission(int index) {
                return ((ErrorStatus) this.instance).getPermission(index);
            }

            public Builder setPermission(int index, PermissionProto.Permission value) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setPermission(index, value);
                return this;
            }

            public Builder setPermission(int index, PermissionProto.Permission.Builder builderForValue) {
                copyOnWrite();
                ((ErrorStatus) this.instance).setPermission(index, builderForValue.build());
                return this;
            }

            public Builder addPermission(PermissionProto.Permission value) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(value);
                return this;
            }

            public Builder addPermission(int index, PermissionProto.Permission value) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(index, value);
                return this;
            }

            public Builder addPermission(PermissionProto.Permission.Builder builderForValue) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(builderForValue.build());
                return this;
            }

            public Builder addPermission(int index, PermissionProto.Permission.Builder builderForValue) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addPermission(index, builderForValue.build());
                return this;
            }

            public Builder addAllPermission(Iterable<? extends PermissionProto.Permission> values) {
                copyOnWrite();
                ((ErrorStatus) this.instance).addAllPermission(values);
                return this;
            }

            public Builder clearPermission() {
                copyOnWrite();
                ((ErrorStatus) this.instance).clearPermission();
                return this;
            }

            public Builder removePermission(int index) {
                copyOnWrite();
                ((ErrorStatus) this.instance).removePermission(index);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new ErrorStatus();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "code_", "message_", "permission_", PermissionProto.Permission.class};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<ErrorStatus> parser = PARSER;
                    if (parser == null) {
                        synchronized (ErrorStatus.class) {
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
            ErrorStatus defaultInstance = new ErrorStatus();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(ErrorStatus.class, defaultInstance);
        }

        public static ErrorStatus getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<ErrorStatus> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
