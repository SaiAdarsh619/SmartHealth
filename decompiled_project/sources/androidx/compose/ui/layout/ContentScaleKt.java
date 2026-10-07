package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Size;
import kotlin.Metadata;
/* compiled from: ContentScale.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001a%\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0005\u0010\u0006\u001a%\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\b\u0010\u0006\u001a%\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u0006\u001a%\u0010\u000b\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\u0006\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"computeFillHeight", "", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeFillHeight-iLBOSCw", "(JJ)F", "computeFillMaxDimension", "computeFillMaxDimension-iLBOSCw", "computeFillMinDimension", "computeFillMinDimension-iLBOSCw", "computeFillWidth", "computeFillWidth-iLBOSCw", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* loaded from: classes.dex */
public final class ContentScaleKt {
    /* renamed from: access$computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m3168access$computeFillHeightiLBOSCw(long srcSize, long dstSize) {
        return m3172computeFillHeightiLBOSCw(srcSize, dstSize);
    }

    /* renamed from: access$computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m3169access$computeFillMaxDimensioniLBOSCw(long srcSize, long dstSize) {
        return m3173computeFillMaxDimensioniLBOSCw(srcSize, dstSize);
    }

    /* renamed from: access$computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m3170access$computeFillMinDimensioniLBOSCw(long srcSize, long dstSize) {
        return m3174computeFillMinDimensioniLBOSCw(srcSize, dstSize);
    }

    /* renamed from: access$computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final /* synthetic */ float m3171access$computeFillWidthiLBOSCw(long srcSize, long dstSize) {
        return m3175computeFillWidthiLBOSCw(srcSize, dstSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMaxDimension-iLBOSCw  reason: not valid java name */
    public static final float m3173computeFillMaxDimensioniLBOSCw(long srcSize, long dstSize) {
        float widthScale = m3175computeFillWidthiLBOSCw(srcSize, dstSize);
        float heightScale = m3172computeFillHeightiLBOSCw(srcSize, dstSize);
        return Math.max(widthScale, heightScale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillMinDimension-iLBOSCw  reason: not valid java name */
    public static final float m3174computeFillMinDimensioniLBOSCw(long srcSize, long dstSize) {
        float widthScale = m3175computeFillWidthiLBOSCw(srcSize, dstSize);
        float heightScale = m3172computeFillHeightiLBOSCw(srcSize, dstSize);
        return Math.min(widthScale, heightScale);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillWidth-iLBOSCw  reason: not valid java name */
    public static final float m3175computeFillWidthiLBOSCw(long srcSize, long dstSize) {
        return Size.m1513getWidthimpl(dstSize) / Size.m1513getWidthimpl(srcSize);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: computeFillHeight-iLBOSCw  reason: not valid java name */
    public static final float m3172computeFillHeightiLBOSCw(long srcSize, long dstSize) {
        return Size.m1510getHeightimpl(dstSize) / Size.m1510getHeightimpl(srcSize);
    }
}
