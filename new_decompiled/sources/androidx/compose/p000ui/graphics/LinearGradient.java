package androidx.compose.p000ui.graphics;

import android.graphics.Shader;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Brush.kt */
@Metadata(m286d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001BD\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\u000bø\u0001\u0000¢\u0006\u0002\u0010\fJ!\u0010\u0013\u001a\u00060\u0014j\u0002`\u00152\u0006\u0010\u0016\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0096\u0002J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004ø\u0001\u0000¢\u0006\u0002\n\u0000R\u0019\u0010\t\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u001d\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0019\u0010\u0007\u001a\u00020\bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\rR\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\n\u001a\u00020\u000bX\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0012\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006!"}, m287d2 = {"Landroidx/compose/ui/graphics/LinearGradient;", "Landroidx/compose/ui/graphics/ShaderBrush;", "colors", "", "Landroidx/compose/ui/graphics/Color;", "stops", "", "start", "Landroidx/compose/ui/geometry/Offset;", "end", "tileMode", "Landroidx/compose/ui/graphics/TileMode;", "(Ljava/util/List;Ljava/util/List;JJILkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "intrinsicSize", "Landroidx/compose/ui/geometry/Size;", "getIntrinsicSize-NH-jbRc", "()J", "I", "createShader", "Landroid/graphics/Shader;", "Landroidx/compose/ui/graphics/Shader;", "size", "createShader-uvyYCjk", "(J)Landroid/graphics/Shader;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "", "hashCode", "", "toString", "", "ui-graphics_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LinearGradient extends ShaderBrush {
    private final List<Color> colors;
    private final long end;
    private final long start;
    private final List<Float> stops;
    private final int tileMode;

    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, list2, j, j2, i);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ LinearGradient(List list, List list2, long j, long j2, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, r3, j, j2, r8, null);
        List list3;
        int i3;
        if ((i2 & 2) == 0) {
            list3 = list2;
        } else {
            list3 = null;
        }
        if ((i2 & 16) == 0) {
            i3 = i;
        } else {
            i3 = TileMode.INSTANCE.m2320getClamp3opZhB0();
        }
    }

    private LinearGradient(List<Color> list, List<Float> list2, long start, long end, int tileMode) {
        this.colors = list;
        this.stops = list2;
        this.start = start;
        this.end = end;
        this.tileMode = tileMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x005c  */
    @Override // androidx.compose.p000ui.graphics.Brush
    /* renamed from: getIntrinsicSize-NH-jbRc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public long getIntrinsicSize() {
        float f;
        float m1761getYimpl;
        float m1760getXimpl = Offset.m1760getXimpl(this.start);
        float f2 = Float.NaN;
        if ((Float.isInfinite(m1760getXimpl) || Float.isNaN(m1760getXimpl)) ? false : true) {
            float m1760getXimpl2 = Offset.m1760getXimpl(this.end);
            if ((Float.isInfinite(m1760getXimpl2) || Float.isNaN(m1760getXimpl2)) ? false : true) {
                f = Math.abs(Offset.m1760getXimpl(this.start) - Offset.m1760getXimpl(this.end));
                m1761getYimpl = Offset.m1761getYimpl(this.start);
                if (Float.isInfinite(m1761getYimpl) && !Float.isNaN(m1761getYimpl)) {
                    float m1761getYimpl2 = Offset.m1761getYimpl(this.end);
                    if ((Float.isInfinite(m1761getYimpl2) || Float.isNaN(m1761getYimpl2)) ? false : true) {
                        f2 = Math.abs(Offset.m1761getYimpl(this.start) - Offset.m1761getYimpl(this.end));
                    }
                }
                return SizeKt.Size(f, f2);
            }
        }
        f = Float.NaN;
        m1761getYimpl = Offset.m1761getYimpl(this.start);
        if (Float.isInfinite(m1761getYimpl) && !Float.isNaN(m1761getYimpl)) {
        }
        return SizeKt.Size(f, f2);
    }

    @Override // androidx.compose.p000ui.graphics.ShaderBrush
    /* renamed from: createShader-uvyYCjk */
    public Shader mo1965createShaderuvyYCjk(long size) {
        float startX = (Offset.m1760getXimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1760getXimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1829getWidthimpl(size) : Offset.m1760getXimpl(this.start);
        float startY = (Offset.m1761getYimpl(this.start) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1761getYimpl(this.start) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1826getHeightimpl(size) : Offset.m1761getYimpl(this.start);
        float endX = (Offset.m1760getXimpl(this.end) > Float.POSITIVE_INFINITY ? 1 : (Offset.m1760getXimpl(this.end) == Float.POSITIVE_INFINITY ? 0 : -1)) == 0 ? Size.m1829getWidthimpl(size) : Offset.m1760getXimpl(this.end);
        float endY = Offset.m1761getYimpl(this.end) == Float.POSITIVE_INFINITY ? Size.m1826getHeightimpl(size) : Offset.m1761getYimpl(this.end);
        return ShaderKt.m2270LinearGradientShaderVjE6UOU(OffsetKt.Offset(startX, startY), OffsetKt.Offset(endX, endY), this.colors, this.stops, this.tileMode);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof LinearGradient) && Intrinsics.areEqual(this.colors, ((LinearGradient) other).colors) && Intrinsics.areEqual(this.stops, ((LinearGradient) other).stops) && Offset.m1757equalsimpl0(this.start, ((LinearGradient) other).start) && Offset.m1757equalsimpl0(this.end, ((LinearGradient) other).end) && TileMode.m2316equalsimpl0(this.tileMode, ((LinearGradient) other).tileMode);
    }

    public int hashCode() {
        int result = this.colors.hashCode();
        int i = result * 31;
        List<Float> list = this.stops;
        int result2 = i + (list != null ? list.hashCode() : 0);
        return (((((result2 * 31) + Offset.m1762hashCodeimpl(this.start)) * 31) + Offset.m1762hashCodeimpl(this.end)) * 31) + TileMode.m2317hashCodeimpl(this.tileMode);
    }

    public String toString() {
        String startValue = OffsetKt.m1777isFinitek4lQ0M(this.start) ? "start=" + ((Object) Offset.m1768toStringimpl(this.start)) + ", " : "";
        String endValue = OffsetKt.m1777isFinitek4lQ0M(this.end) ? "end=" + ((Object) Offset.m1768toStringimpl(this.end)) + ", " : "";
        return "LinearGradient(colors=" + this.colors + ", stops=" + this.stops + ", " + startValue + endValue + "tileMode=" + ((Object) TileMode.m2318toStringimpl(this.tileMode)) + ')';
    }
}
