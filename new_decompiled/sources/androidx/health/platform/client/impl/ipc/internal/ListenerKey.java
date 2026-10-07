package androidx.health.platform.client.impl.ipc.internal;

/* loaded from: classes14.dex */
public final class ListenerKey {
    private final Object mListenerKey;

    public ListenerKey(Object listenerKey) {
        this.mListenerKey = listenerKey;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ListenerKey)) {
            return false;
        }
        ListenerKey that = (ListenerKey) o;
        return this.mListenerKey.equals(that);
    }

    public int hashCode() {
        return System.identityHashCode(this.mListenerKey);
    }

    public String toString() {
        return String.valueOf(this.mListenerKey);
    }
}
