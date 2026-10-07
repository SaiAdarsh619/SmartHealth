package androidx.compose.p000ui.graphics.colorspace;

import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TransferParameters.kt */
@Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003JO\u0010\u001a\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\""}, m287d2 = {"Landroidx/compose/ui/graphics/colorspace/TransferParameters;", "", "gamma", "", "a", "b", "c", "d", "e", "f", "(DDDDDDD)V", "getA", "()D", "getB", "getC", "getD", "getE", "getF", "getGamma", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "ui-graphics_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final /* data */ class TransferParameters {
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;
    private final double gamma;

    /* renamed from: component1, reason: from getter */
    public final double getGamma() {
        return this.gamma;
    }

    /* renamed from: component2, reason: from getter */
    public final double getA() {
        return this.a;
    }

    /* renamed from: component3, reason: from getter */
    public final double getB() {
        return this.b;
    }

    /* renamed from: component4, reason: from getter */
    public final double getC() {
        return this.c;
    }

    /* renamed from: component5, reason: from getter */
    public final double getD() {
        return this.d;
    }

    /* renamed from: component6, reason: from getter */
    public final double getE() {
        return this.e;
    }

    /* renamed from: component7, reason: from getter */
    public final double getF() {
        return this.f;
    }

    public final TransferParameters copy(double gamma, double a, double b, double c, double d, double e, double f) {
        return new TransferParameters(gamma, a, b, c, d, e, f);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof TransferParameters)) {
            return false;
        }
        TransferParameters transferParameters = (TransferParameters) other;
        return Intrinsics.areEqual((Object) Double.valueOf(this.gamma), (Object) Double.valueOf(transferParameters.gamma)) && Intrinsics.areEqual((Object) Double.valueOf(this.a), (Object) Double.valueOf(transferParameters.a)) && Intrinsics.areEqual((Object) Double.valueOf(this.b), (Object) Double.valueOf(transferParameters.b)) && Intrinsics.areEqual((Object) Double.valueOf(this.c), (Object) Double.valueOf(transferParameters.c)) && Intrinsics.areEqual((Object) Double.valueOf(this.d), (Object) Double.valueOf(transferParameters.d)) && Intrinsics.areEqual((Object) Double.valueOf(this.e), (Object) Double.valueOf(transferParameters.e)) && Intrinsics.areEqual((Object) Double.valueOf(this.f), (Object) Double.valueOf(transferParameters.f));
    }

    public int hashCode() {
        return (((((((((((Double.hashCode(this.gamma) * 31) + Double.hashCode(this.a)) * 31) + Double.hashCode(this.b)) * 31) + Double.hashCode(this.c)) * 31) + Double.hashCode(this.d)) * 31) + Double.hashCode(this.e)) * 31) + Double.hashCode(this.f);
    }

    public String toString() {
        return "TransferParameters(gamma=" + this.gamma + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", e=" + this.e + ", f=" + this.f + ')';
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x008e, code lost:
    
        if ((r20.gamma == 0.0d) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00ce, code lost:
    
        if ((r20.gamma == 0.0d) != false) goto L58;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public TransferParameters(double gamma, double a, double b, double c, double d, double e, double f) {
        this.gamma = gamma;
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
        if (Double.isNaN(this.a) || Double.isNaN(this.b) || Double.isNaN(this.c) || Double.isNaN(this.d) || Double.isNaN(this.e) || Double.isNaN(this.f) || Double.isNaN(this.gamma)) {
            throw new IllegalArgumentException("Parameters cannot be NaN");
        }
        if (this.d < 0.0d || this.d > 1.0d) {
            throw new IllegalArgumentException("Parameter d must be in the range [0..1], was " + this.d);
        }
        if (this.d == 0.0d) {
            if (!(this.a == 0.0d)) {
            }
            throw new IllegalArgumentException("Parameter a or g is zero, the transfer function is constant");
        }
        if (this.d >= 1.0d) {
            if (this.c == 0.0d) {
                throw new IllegalArgumentException("Parameter c is zero, the transfer function is constant");
            }
        }
        if (!(this.a == 0.0d)) {
        }
        if (this.c == 0.0d) {
            throw new IllegalArgumentException("Parameter a or g is zero, and c is zero, the transfer function is constant");
        }
        if (this.c < 0.0d) {
            throw new IllegalArgumentException("The transfer function must be increasing");
        }
        if (this.a >= 0.0d && this.gamma >= 0.0d) {
        } else {
            throw new IllegalArgumentException("The transfer function must be positive or increasing");
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ TransferParameters(double d, double d2, double d3, double d4, double d5, double d6, double d7, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(d, d2, d3, d4, d5, r14, r16);
        double d8;
        double d9;
        if ((i & 32) == 0) {
            d8 = d6;
        } else {
            d8 = 0.0d;
        }
        if ((i & 64) == 0) {
            d9 = d7;
        } else {
            d9 = 0.0d;
        }
    }

    public final double getGamma() {
        return this.gamma;
    }

    public final double getA() {
        return this.a;
    }

    public final double getB() {
        return this.b;
    }

    public final double getC() {
        return this.c;
    }

    public final double getD() {
        return this.d;
    }

    public final double getE() {
        return this.e;
    }

    public final double getF() {
        return this.f;
    }
}
