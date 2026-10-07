package com.google.common.util.concurrent;

import sun.misc.Unsafe;

/* compiled from: D8$$SyntheticClass */
/* renamed from: com.google.common.util.concurrent.AbstractFuture$UnsafeAtomicHelper$$ExternalSyntheticBackportWithForwarding0 */
/* loaded from: classes14.dex */
public final /* synthetic */ class C1380x75145c29 {
    /* renamed from: m */
    public static /* synthetic */ boolean m282m(Unsafe unsafe, Object obj, long j, Object obj2, Object obj3) {
        while (!unsafe.compareAndSwapObject(obj, j, obj2, obj3)) {
            if (unsafe.getObject(obj, j) != obj2) {
                return false;
            }
        }
        return true;
    }
}
