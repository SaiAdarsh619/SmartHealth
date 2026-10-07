package com.google.common.collect;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes14.dex */
final class Hashing {

    /* renamed from: C1 */
    private static final long f265C1 = -862048943;

    /* renamed from: C2 */
    private static final long f266C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    static int smear(int hashCode) {
        return (int) (Integer.rotateLeft((int) (hashCode * f265C1), 15) * f266C2);
    }

    static int smearedHash(@CheckForNull Object o) {
        return smear(o == null ? 0 : o.hashCode());
    }

    static int closedTableSize(int expectedEntries, double loadFactor) {
        int expectedEntries2 = Math.max(expectedEntries, 2);
        int tableSize = Integer.highestOneBit(expectedEntries2);
        if (expectedEntries2 > ((int) (tableSize * loadFactor))) {
            int tableSize2 = tableSize << 1;
            if (tableSize2 > 0) {
                return tableSize2;
            }
            return 1073741824;
        }
        return tableSize;
    }

    static boolean needsResizing(int size, int tableSize, double loadFactor) {
        return ((double) size) > ((double) tableSize) * loadFactor && tableSize < 1073741824;
    }
}
