package androidx.health.platform.client.proto;
@CheckReturnValue
/* loaded from: classes14.dex */
interface MessageInfoFactory {
    boolean isSupported(Class<?> clazz);

    MessageInfo messageInfoFor(Class<?> clazz);
}
