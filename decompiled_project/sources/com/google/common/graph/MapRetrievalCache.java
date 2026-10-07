package com.google.common.graph;

import com.google.common.base.Preconditions;
import java.util.Map;
import javax.annotation.CheckForNull;
@ElementTypesAreNonnullByDefault
/* loaded from: classes14.dex */
final class MapRetrievalCache<K, V> extends MapIteratorCache<K, V> {
    @CheckForNull
    private volatile transient CacheEntry<K, V> cacheEntry1;
    @CheckForNull
    private volatile transient CacheEntry<K, V> cacheEntry2;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapRetrievalCache(Map<K, V> backingMap) {
        super(backingMap);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.common.graph.MapIteratorCache
    @CheckForNull
    public V get(Object key) {
        Preconditions.checkNotNull(key);
        V value = getIfCached(key);
        if (value != null) {
            return value;
        }
        V value2 = getWithoutCaching(key);
        if (value2 != null) {
            addToCache(key, value2);
        }
        return value2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.graph.MapIteratorCache
    @CheckForNull
    public V getIfCached(@CheckForNull Object key) {
        V value = (V) super.getIfCached(key);
        if (value != null) {
            return value;
        }
        CacheEntry<K, V> entry = this.cacheEntry1;
        if (entry != null && entry.key == key) {
            return entry.value;
        }
        CacheEntry<K, V> entry2 = this.cacheEntry2;
        if (entry2 != null && entry2.key == key) {
            addToCache(entry2);
            return entry2.value;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.graph.MapIteratorCache
    public void clearCache() {
        super.clearCache();
        this.cacheEntry1 = null;
        this.cacheEntry2 = null;
    }

    private void addToCache(K key, V value) {
        addToCache(new CacheEntry<>(key, value));
    }

    private void addToCache(CacheEntry<K, V> entry) {
        this.cacheEntry2 = this.cacheEntry1;
        this.cacheEntry1 = entry;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes14.dex */
    public static final class CacheEntry<K, V> {
        final K key;
        final V value;

        CacheEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
