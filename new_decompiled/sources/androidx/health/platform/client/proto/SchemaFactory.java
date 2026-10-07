package androidx.health.platform.client.proto;

@CheckReturnValue
/* loaded from: classes14.dex */
interface SchemaFactory {
    <T> Schema<T> createSchema(Class<T> messageType);
}
