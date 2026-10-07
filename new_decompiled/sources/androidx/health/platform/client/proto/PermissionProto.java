package androidx.health.platform.client.proto;

import androidx.health.platform.client.proto.DataProto;
import androidx.health.platform.client.proto.GeneratedMessageLite;
import androidx.health.platform.client.proto.Internal;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

/* loaded from: classes14.dex */
public final class PermissionProto {

    public interface PermissionOrBuilder extends MessageLiteOrBuilder {
        AccessType getAccessType();

        DataProto.DataType getDataType();

        String getPermission();

        ByteString getPermissionBytes();

        boolean hasAccessType();

        boolean hasDataType();

        boolean hasPermission();
    }

    private PermissionProto() {
    }

    public static void registerAllExtensions(ExtensionRegistryLite registry) {
    }

    public enum AccessType implements Internal.EnumLite {
        ACCESS_TYPE_UNKNOWN(0),
        ACCESS_TYPE_READ(1),
        ACCESS_TYPE_WRITE(2);

        public static final int ACCESS_TYPE_READ_VALUE = 1;
        public static final int ACCESS_TYPE_UNKNOWN_VALUE = 0;
        public static final int ACCESS_TYPE_WRITE_VALUE = 2;
        private static final Internal.EnumLiteMap<AccessType> internalValueMap = new Internal.EnumLiteMap<AccessType>() { // from class: androidx.health.platform.client.proto.PermissionProto.AccessType.1
            @Override // androidx.health.platform.client.proto.Internal.EnumLiteMap
            public AccessType findValueByNumber(int number) {
                return AccessType.forNumber(number);
            }
        };
        private final int value;

        @Override // androidx.health.platform.client.proto.Internal.EnumLite
        public final int getNumber() {
            return this.value;
        }

        @Deprecated
        public static AccessType valueOf(int value) {
            return forNumber(value);
        }

        public static AccessType forNumber(int value) {
            switch (value) {
                case 0:
                    return ACCESS_TYPE_UNKNOWN;
                case 1:
                    return ACCESS_TYPE_READ;
                case 2:
                    return ACCESS_TYPE_WRITE;
                default:
                    return null;
            }
        }

        public static Internal.EnumLiteMap<AccessType> internalGetValueMap() {
            return internalValueMap;
        }

        public static Internal.EnumVerifier internalGetVerifier() {
            return AccessTypeVerifier.INSTANCE;
        }

        private static final class AccessTypeVerifier implements Internal.EnumVerifier {
            static final Internal.EnumVerifier INSTANCE = new AccessTypeVerifier();

            private AccessTypeVerifier() {
            }

            @Override // androidx.health.platform.client.proto.Internal.EnumVerifier
            public boolean isInRange(int number) {
                return AccessType.forNumber(number) != null;
            }
        }

        AccessType(int value) {
            this.value = value;
        }
    }

    public static final class Permission extends GeneratedMessageLite<Permission, Builder> implements PermissionOrBuilder {
        public static final int ACCESS_TYPE_FIELD_NUMBER = 2;
        public static final int DATA_TYPE_FIELD_NUMBER = 1;
        private static final Permission DEFAULT_INSTANCE;
        private static volatile Parser<Permission> PARSER = null;
        public static final int PERMISSION_FIELD_NUMBER = 3;
        private int accessType_;
        private int bitField0_;
        private DataProto.DataType dataType_;
        private String permission_ = "";

        private Permission() {
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public boolean hasDataType() {
            return (this.bitField0_ & 1) != 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
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

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public boolean hasAccessType() {
            return (this.bitField0_ & 2) != 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public AccessType getAccessType() {
            AccessType result = AccessType.forNumber(this.accessType_);
            return result == null ? AccessType.ACCESS_TYPE_UNKNOWN : result;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setAccessType(AccessType value) {
            this.accessType_ = value.getNumber();
            this.bitField0_ |= 2;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearAccessType() {
            this.bitField0_ &= -3;
            this.accessType_ = 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public boolean hasPermission() {
            return (this.bitField0_ & 4) != 0;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public String getPermission() {
            return this.permission_;
        }

        @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
        public ByteString getPermissionBytes() {
            return ByteString.copyFromUtf8(this.permission_);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermission(String value) {
            value.getClass();
            this.bitField0_ |= 4;
            this.permission_ = value;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clearPermission() {
            this.bitField0_ &= -5;
            this.permission_ = getDefaultInstance().getPermission();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setPermissionBytes(ByteString value) {
            this.permission_ = value.toStringUtf8();
            this.bitField0_ |= 4;
        }

        public static Permission parseFrom(ByteBuffer data) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Permission parseFrom(ByteBuffer data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Permission parseFrom(ByteString data) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Permission parseFrom(ByteString data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Permission parseFrom(byte[] data) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data);
        }

        public static Permission parseFrom(byte[] data, ExtensionRegistryLite extensionRegistry) throws InvalidProtocolBufferException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, data, extensionRegistry);
        }

        public static Permission parseFrom(InputStream input) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Permission parseFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Permission parseDelimitedFrom(InputStream input) throws IOException {
            return (Permission) parseDelimitedFrom(DEFAULT_INSTANCE, input);
        }

        public static Permission parseDelimitedFrom(InputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Permission) parseDelimitedFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Permission parseFrom(CodedInputStream input) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input);
        }

        public static Permission parseFrom(CodedInputStream input, ExtensionRegistryLite extensionRegistry) throws IOException {
            return (Permission) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, input, extensionRegistry);
        }

        public static Builder newBuilder() {
            return DEFAULT_INSTANCE.createBuilder();
        }

        public static Builder newBuilder(Permission prototype) {
            return DEFAULT_INSTANCE.createBuilder(prototype);
        }

        public static final class Builder extends GeneratedMessageLite.Builder<Permission, Builder> implements PermissionOrBuilder {
            private Builder() {
                super(Permission.DEFAULT_INSTANCE);
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public boolean hasDataType() {
                return ((Permission) this.instance).hasDataType();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public DataProto.DataType getDataType() {
                return ((Permission) this.instance).getDataType();
            }

            public Builder setDataType(DataProto.DataType value) {
                copyOnWrite();
                ((Permission) this.instance).setDataType(value);
                return this;
            }

            public Builder setDataType(DataProto.DataType.Builder builderForValue) {
                copyOnWrite();
                ((Permission) this.instance).setDataType(builderForValue.build());
                return this;
            }

            public Builder mergeDataType(DataProto.DataType value) {
                copyOnWrite();
                ((Permission) this.instance).mergeDataType(value);
                return this;
            }

            public Builder clearDataType() {
                copyOnWrite();
                ((Permission) this.instance).clearDataType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public boolean hasAccessType() {
                return ((Permission) this.instance).hasAccessType();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public AccessType getAccessType() {
                return ((Permission) this.instance).getAccessType();
            }

            public Builder setAccessType(AccessType value) {
                copyOnWrite();
                ((Permission) this.instance).setAccessType(value);
                return this;
            }

            public Builder clearAccessType() {
                copyOnWrite();
                ((Permission) this.instance).clearAccessType();
                return this;
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public boolean hasPermission() {
                return ((Permission) this.instance).hasPermission();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public String getPermission() {
                return ((Permission) this.instance).getPermission();
            }

            @Override // androidx.health.platform.client.proto.PermissionProto.PermissionOrBuilder
            public ByteString getPermissionBytes() {
                return ((Permission) this.instance).getPermissionBytes();
            }

            public Builder setPermission(String value) {
                copyOnWrite();
                ((Permission) this.instance).setPermission(value);
                return this;
            }

            public Builder clearPermission() {
                copyOnWrite();
                ((Permission) this.instance).clearPermission();
                return this;
            }

            public Builder setPermissionBytes(ByteString value) {
                copyOnWrite();
                ((Permission) this.instance).setPermissionBytes(value);
                return this;
            }
        }

        @Override // androidx.health.platform.client.proto.GeneratedMessageLite
        protected final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke method, Object arg0, Object arg1) {
            switch (method) {
                case NEW_MUTABLE_INSTANCE:
                    return new Permission();
                case NEW_BUILDER:
                    return new Builder();
                case BUILD_MESSAGE_INFO:
                    Object[] objects = {"bitField0_", "dataType_", "accessType_", AccessType.internalGetVerifier(), "permission_"};
                    return newMessageInfo(DEFAULT_INSTANCE, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002᠌\u0001\u0003ဈ\u0002", objects);
                case GET_DEFAULT_INSTANCE:
                    return DEFAULT_INSTANCE;
                case GET_PARSER:
                    Parser<Permission> parser = PARSER;
                    if (parser == null) {
                        synchronized (Permission.class) {
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
            Permission defaultInstance = new Permission();
            DEFAULT_INSTANCE = defaultInstance;
            GeneratedMessageLite.registerDefaultInstance(Permission.class, defaultInstance);
        }

        public static Permission getDefaultInstance() {
            return DEFAULT_INSTANCE;
        }

        public static Parser<Permission> parser() {
            return DEFAULT_INSTANCE.getParserForType();
        }
    }
}
