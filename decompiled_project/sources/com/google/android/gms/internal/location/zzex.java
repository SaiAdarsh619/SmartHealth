package com.google.android.gms.internal.location;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
/* compiled from: com.google.android.gms:play-services-location@@21.2.0 */
/* loaded from: classes14.dex */
public abstract class zzex extends zzeu implements List, RandomAccess {
    private static final zzfa zza = new zzev(zzey.zza, 0);

    public static zzex zzi() {
        return zzey.zza;
    }

    public static zzex zzj(Collection collection) {
        if (collection instanceof zzeu) {
            zzex zze = ((zzeu) collection).zze();
            if (zze.zzf()) {
                Object[] array = zze.toArray();
                return zzk(array, array.length);
            }
            return zze;
        }
        Object[] array2 = collection.toArray();
        int length = array2.length;
        for (int i = 0; i < length; i++) {
            if (array2[i] == null) {
                StringBuilder sb = new StringBuilder(String.valueOf(i).length() + 9);
                sb.append("at index ");
                sb.append(i);
                throw new NullPointerException(sb.toString());
            }
        }
        return zzk(array2, length);
    }

    static zzex zzk(Object[] objArr, int i) {
        return i == 0 ? zzey.zza : new zzey(objArr, i);
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(@CheckForNull Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.List
    public final boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size != list.size()) {
                return false;
            }
            if (list instanceof RandomAccess) {
                for (int i = 0; i < size; i++) {
                    if (!zzeq.zza(get(i), list.get(i))) {
                        return false;
                    }
                }
                return true;
            }
            Iterator it = list.iterator();
            for (Object obj2 : this) {
                if (!it.hasNext()) {
                    return false;
                }
                if (!zzeq.zza(obj2, it.next())) {
                    return false;
                }
            }
            return !it.hasNext();
        }
        return false;
    }

    @Override // java.util.Collection, java.util.List
    public final int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.List
    public final int indexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (obj.equals(get(i))) {
                return i;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.location.zzeu, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final int lastIndexOf(@CheckForNull Object obj) {
        if (obj == null) {
            return -1;
        }
        for (int size = size() - 1; size >= 0; size--) {
            if (obj.equals(get(size))) {
                return size;
            }
        }
        return -1;
    }

    @Override // java.util.List
    public final /* synthetic */ ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    @Deprecated
    public final Object remove(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final Object set(int i, Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.location.zzeu
    public final zzez zza() {
        return listIterator(0);
    }

    @Override // com.google.android.gms.internal.location.zzeu
    @Deprecated
    public final zzex zze() {
        return this;
    }

    @Override // com.google.android.gms.internal.location.zzeu
    int zzg(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i2] = get(i2);
        }
        return size;
    }

    @Override // java.util.List
    /* renamed from: zzh */
    public zzex subList(int i, int i2) {
        zzer.zze(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 != 0) {
            return new zzew(this, i, i3);
        }
        return zzey.zza;
    }

    @Override // java.util.List
    /* renamed from: zzl */
    public final zzfa listIterator(int i) {
        zzer.zzd(i, size(), "index");
        return isEmpty() ? zza : new zzev(this, i);
    }
}
