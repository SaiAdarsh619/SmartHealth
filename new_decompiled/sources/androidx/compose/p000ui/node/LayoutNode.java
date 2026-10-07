package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutInfo;
import androidx.compose.p000ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.p000ui.layout.LookaheadScope;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasurePolicy;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.ModifierInfo;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.layout.Remeasurement;
import androidx.compose.p000ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.p000ui.platform.JvmActuals_jvmKt;
import androidx.compose.p000ui.platform.ViewConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifierCore;
import androidx.compose.p000ui.semantics.SemanticsNodeKt;
import androidx.compose.p000ui.unit.Constraints;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.DensityKt;
import androidx.compose.p000ui.unit.DpSize;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.collection.MutableVector;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutNode.kt */
@Metadata(m286d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b>\b\u0000\u0018\u0000 Á\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\bÁ\u0002Â\u0002Ã\u0002Ä\u0002B\u0019\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010Í\u0001\u001a\u00030\u009d\u00012\b\u0010§\u0001\u001a\u00030\u009c\u0001H\u0000¢\u0006\u0003\bÎ\u0001J\u0010\u0010Ï\u0001\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bÐ\u0001J\u0010\u0010Ñ\u0001\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bÒ\u0001J\u0010\u0010Ó\u0001\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bÔ\u0001J\n\u0010Õ\u0001\u001a\u00030\u009d\u0001H\u0002J\u0014\u0010Ö\u0001\u001a\u00030×\u00012\b\b\u0002\u00103\u001a\u00020\tH\u0002J\u0010\u0010Ø\u0001\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bÙ\u0001J\u0010\u0010Ú\u0001\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bÛ\u0001J\u001a\u0010Ü\u0001\u001a\u00030\u009d\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0000¢\u0006\u0003\bß\u0001J%\u0010à\u0001\u001a\u00030\u009d\u00012\u0015\u0010á\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030\u009d\u00010\u009b\u0001H\u0086\bø\u0001\u0000J+\u0010â\u0001\u001a\u00030\u009d\u00012\u001b\u0010á\u0001\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030\u009d\u00010ã\u0001H\u0086\bø\u0001\u0000J#\u0010ä\u0001\u001a\u00030\u009d\u00012\u0016\u0010á\u0001\u001a\u0011\u0012\u0005\u0012\u00030å\u0001\u0012\u0005\u0012\u00030\u009d\u00010\u009b\u0001H\u0082\bJ\"\u0010æ\u0001\u001a\u00030\u009d\u00012\u0015\u0010á\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0005\u0012\u00030\u009d\u00010\u009b\u0001H\u0082\bJ\n\u0010ç\u0001\u001a\u00030\u009d\u0001H\u0016J\u0010\u0010è\u0001\u001a\t\u0012\u0005\u0012\u00030é\u00010 H\u0016JJ\u0010ê\u0001\u001a\u00030\u009d\u00012\b\u0010ë\u0001\u001a\u00030ì\u00012\u000f\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030ï\u00010î\u00012\t\b\u0002\u0010ð\u0001\u001a\u00020\u00072\t\b\u0002\u0010ñ\u0001\u001a\u00020\u0007H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\bò\u0001\u0010ó\u0001JJ\u0010ô\u0001\u001a\u00030\u009d\u00012\b\u0010ë\u0001\u001a\u00030ì\u00012\u000f\u0010õ\u0001\u001a\n\u0012\u0005\u0012\u00030ö\u00010î\u00012\t\b\u0002\u0010ð\u0001\u001a\u00020\u00072\t\b\u0002\u0010ñ\u0001\u001a\u00020\u0007H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b÷\u0001\u0010ó\u0001J$\u0010<\u001a\u00030\u009d\u00012\u000f\u0010á\u0001\u001a\n\u0012\u0005\u0012\u00030\u009d\u00010ø\u0001H\u0080\bø\u0001\u0000¢\u0006\u0003\bù\u0001J\"\u0010ú\u0001\u001a\u00030\u009d\u00012\u0007\u0010û\u0001\u001a\u00020\t2\u0007\u0010ü\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bý\u0001J\u0010\u0010þ\u0001\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bÿ\u0001J\u0010\u0010\u0080\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u0081\u0002J\u0010\u0010\u0082\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u0083\u0002J\n\u0010\u0084\u0002\u001a\u00030\u009d\u0001H\u0002J#\u0010\u0085\u0002\u001a\u00020\u00072\f\b\u0002\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b\u0088\u0002J\u0010\u0010\u0089\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u008a\u0002J\u0010\u0010\u008b\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u008c\u0002J\u0010\u0010\u008d\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u008e\u0002J\u0010\u0010\u008f\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u0090\u0002J\u0010\u0010\u0091\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u0092\u0002J\n\u0010\u0093\u0002\u001a\u00030\u009d\u0001H\u0002J\n\u0010\u0094\u0002\u001a\u00030\u009d\u0001H\u0002J+\u0010\u0095\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u0096\u0002\u001a\u00020\t2\u0007\u0010\u0097\u0002\u001a\u00020\t2\u0007\u0010\u0098\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\b\u0099\u0002J\u0013\u0010\u009a\u0002\u001a\u00030\u009d\u00012\u0007\u0010\u009b\u0002\u001a\u00020\u0000H\u0002J\n\u0010\u009c\u0002\u001a\u00030\u009d\u0001H\u0002J\n\u0010\u009d\u0002\u001a\u00030\u009d\u0001H\u0016J\u0010\u0010\u009e\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b\u009f\u0002J\u0010\u0010 \u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b¡\u0002J\"\u0010¢\u0002\u001a\u00030\u009d\u00012\u0007\u0010£\u0002\u001a\u00020\t2\u0007\u0010¤\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\b¥\u0002J\n\u0010¦\u0002\u001a\u00030\u009d\u0001H\u0002J#\u0010§\u0002\u001a\u00020\u00072\f\b\u0002\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b¨\u0002J\u0010\u0010©\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bª\u0002J\"\u0010«\u0002\u001a\u00030\u009d\u00012\u0007\u0010û\u0001\u001a\u00020\t2\u0007\u0010\u0098\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\b¬\u0002J\u0010\u0010\u00ad\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b®\u0002J\u001b\u0010¯\u0002\u001a\u00030\u009d\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\b±\u0002J\u001b\u0010²\u0002\u001a\u00030\u009d\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\b³\u0002J\u001b\u0010´\u0002\u001a\u00030\u009d\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\bµ\u0002J\u001b\u0010¶\u0002\u001a\u00030\u009d\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\b·\u0002J\u0019\u0010¸\u0002\u001a\u00030\u009d\u00012\u0007\u0010¹\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bº\u0002J\u0010\u0010»\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\b¼\u0002J\t\u0010½\u0002\u001a\u00020\u0007H\u0002J\n\u0010¾\u0002\u001a\u00030×\u0001H\u0016J\u0010\u0010¿\u0002\u001a\u00030\u009d\u0001H\u0000¢\u0006\u0003\bÀ\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\f8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00078\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020-@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00000 8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010#R\u0014\u0010:\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b;\u00105R\u000e\u0010<\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?R\u001a\u0010B\u001a\u00020\u0007X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u0010\u001eR\u0014\u0010E\u001a\u00020FX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0018R$\u0010P\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0018\"\u0004\bQ\u0010\u001eR\u001e\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0018R\u0013\u0010T\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020\u00078VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020XX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR$\u0010\\\u001a\u00020[2\u0006\u0010,\u001a\u00020[@VX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u0018R\u0014\u0010c\u001a\u00020d8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0014\u0010g\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0018R\u0014\u0010i\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0018R\u001a\u0010k\u001a\b\u0018\u00010lR\u00020X8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020p8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR(\u0010u\u001a\u0004\u0018\u00010t2\b\u0010s\u001a\u0004\u0018\u00010t@BX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0018\u0010z\u001a\u00060{R\u00020X8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0014\u0010~\u001a\u00020\u00078@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u007f\u0010\u0018R+\u0010\u0081\u0001\u001a\u00030\u0080\u00012\u0007\u0010,\u001a\u00030\u0080\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001\"\u0006\b\u0084\u0001\u0010\u0085\u0001R\u001d\u0010\u0086\u0001\u001a\u00020JX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0087\u0001\u0010L\"\u0005\b\u0088\u0001\u0010NR\u001d\u0010\u0089\u0001\u001a\u00020JX\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u008a\u0001\u0010L\"\u0005\b\u008b\u0001\u0010NR+\u0010\u008d\u0001\u001a\u00030\u008c\u00012\u0007\u0010,\u001a\u00030\u008c\u0001@VX\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u008e\u0001\u0010\u008f\u0001\"\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001d\u0010\u0092\u0001\u001a\u00020\u0007X\u0080\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0093\u0001\u0010\u0018\"\u0005\b\u0094\u0001\u0010\u001eR\u000f\u0010\u0095\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0096\u0001\u001a\u00030\u0097\u0001X\u0080\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0098\u0001\u0010\u0099\u0001R0\u0010\u009a\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010\u009b\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u009e\u0001\u0010\u009f\u0001\"\u0006\b \u0001\u0010¡\u0001R0\u0010¢\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u009c\u0001\u0012\u0005\u0012\u00030\u009d\u0001\u0018\u00010\u009b\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010\u009f\u0001\"\u0006\b¤\u0001\u0010¡\u0001R\u0016\u0010¥\u0001\u001a\u00020\u00138@X\u0080\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010?R'\u0010§\u0001\u001a\u0005\u0018\u00010\u009c\u00012\t\u0010R\u001a\u0005\u0018\u00010\u009c\u0001@BX\u0080\u000e¢\u0006\n\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010ª\u0001\u001a\u0004\u0018\u00010\u00008@X\u0080\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0019\u0010\u00ad\u0001\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R \u0010°\u0001\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t@BX\u0080\u000e¢\u0006\t\n\u0000\u001a\u0005\b±\u0001\u00105R\u000f\u0010²\u0001\u001a\u00020JX\u0082\u000e¢\u0006\u0002\n\u0000R \u0010³\u0001\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t@BX\u0080\u000e¢\u0006\t\n\u0000\u001a\u0005\b´\u0001\u00105R\u000f\u0010µ\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\t\n\u0000\u001a\u0005\b¶\u0001\u00105R\"\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u0080\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u000f\u0010½\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010¾\u0001\u001a\u00030¿\u0001X\u0096\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R\u000f\u0010Ä\u0001\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Å\u0001\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0007\u001a\u0005\bÆ\u0001\u00105R\u0010\u0010Ç\u0001\u001a\u00030È\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\f8@X\u0081\u0004¢\u0006\u000e\u0012\u0005\bÊ\u0001\u0010\u001b\u001a\u0005\bË\u0001\u0010\u000eR\u000f\u0010Ì\u0001\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006Å\u0002"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "()I", "setDepth$ui_release", "(I)V", "foldedChildren", "getFoldedChildren$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isLookaheadRoot", "setLookaheadRoot", "<set-?>", "isPlaced", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValid", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "newScope", "Landroidx/compose/ui/layout/LookaheadScope;", "mLookaheadScope", "getMLookaheadScope$ui_release", "()Landroidx/compose/ui/layout/LookaheadScope;", "setMLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "setMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "setMeasuredByParentInLookahead$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nextChildPlaceOrder", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "previousPlaceOrder", "getPreviousPlaceOrder$ui_release", "relayoutWithoutParentInProgress", "getSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "attach", "attach$ui_release", "checkChildrenPlaceOrderForUpdates", "checkChildrenPlaceOrderForUpdates$ui_release", "clearPlaceOrder", "clearPlaceOrder$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinatorIncludingInner", "forceRemeasure", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "Landroidx/compose/ui/node/SemanticsModifierNode;", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onNodePlaced", "onNodePlaced$ui_release", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class LayoutNode implements Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, Owner.OnLayoutCompletedListener {
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    private LayoutNode _foldedParent;
    private NodeCoordinator _innerLayerCoordinator;
    private MutableVector<LayoutNode> _unfoldedChildren;
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    private Density density;
    private int depth;
    private boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    private final IntrinsicsPolicy intrinsicsPolicy;
    private UsageByParent intrinsicsUsageByParent;
    private boolean isLookaheadRoot;
    private boolean isPlaced;
    private final boolean isVirtual;
    private final LayoutNodeLayoutDelegate layoutDelegate;
    private LayoutDirection layoutDirection;
    private LookaheadScope mLookaheadScope;
    private MeasurePolicy measurePolicy;
    private UsageByParent measuredByParent;
    private UsageByParent measuredByParentInLookahead;
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private int nextChildPlaceOrder;
    private final NodeChain nodes;
    private Function1<? super Owner, Unit> onAttach;
    private Function1<? super Owner, Unit> onDetach;
    private Owner owner;
    private int placeOrder;
    private UsageByParent previousIntrinsicsUsageByParent;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;
    private final int semanticsId;
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private float zIndex;
    private boolean zSortedChildrenInvalidated;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new NoIntrinsicsMeasurePolicy() { // from class: androidx.compose.ui.node.LayoutNode$Companion$ErrorMeasurePolicy$1
        @Override // androidx.compose.p000ui.layout.MeasurePolicy
        /* renamed from: measure-3p2s80s */
        public /* bridge */ /* synthetic */ MeasureResult mo331measure3p2s80s(MeasureScope $this$measure_u2d3p2s80s, List measurables, long constraints) {
            return (MeasureResult) m3626measure3p2s80s($this$measure_u2d3p2s80s, (List<? extends Measurable>) measurables, constraints);
        }

        /* renamed from: measure-3p2s80s, reason: not valid java name */
        public Void m3626measure3p2s80s(MeasureScope measure, List<? extends Measurable> measurables, long constraints) {
            Intrinsics.checkNotNullParameter(measure, "$this$measure");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException("Undefined measure and it is required".toString());
        }
    };
    private static final Function0<LayoutNode> Constructor = new Function0<LayoutNode>() { // from class: androidx.compose.ui.node.LayoutNode$Companion$Constructor$1
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function0
        public final LayoutNode invoke() {
            return new LayoutNode(false, 0 == true ? 1 : 0, 3, null);
        }
    };
    private static final ViewConfiguration DummyViewConfiguration = new ViewConfiguration() { // from class: androidx.compose.ui.node.LayoutNode$Companion$DummyViewConfiguration$1
        @Override // androidx.compose.p000ui.platform.ViewConfiguration
        public long getLongPressTimeoutMillis() {
            return 400L;
        }

        @Override // androidx.compose.p000ui.platform.ViewConfiguration
        public long getDoubleTapTimeoutMillis() {
            return 300L;
        }

        @Override // androidx.compose.p000ui.platform.ViewConfiguration
        public long getDoubleTapMinTimeMillis() {
            return 40L;
        }

        @Override // androidx.compose.p000ui.platform.ViewConfiguration
        public float getTouchSlop() {
            return 16.0f;
        }

        @Override // androidx.compose.p000ui.platform.ViewConfiguration
        /* renamed from: getMinimumTouchTargetSize-MYxV2XQ, reason: not valid java name */
        public long mo3625getMinimumTouchTargetSizeMYxV2XQ() {
            return DpSize.INSTANCE.m4490getZeroMYxV2XQ();
        }
    };
    private static final Comparator<LayoutNode> ZComparator = new Comparator() { // from class: androidx.compose.ui.node.LayoutNode$$ExternalSyntheticLambda0
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            int m3616ZComparator$lambda37;
            m3616ZComparator$lambda37 = LayoutNode.m3616ZComparator$lambda37((LayoutNode) obj, (LayoutNode) obj2);
            return m3616ZComparator$lambda37;
        }
    };

    /* compiled from: LayoutNode.kt */
    @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(m286d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0080\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            iArr[LayoutState.Idle.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public LayoutNode() {
        this(false, 0 == true ? 1 : 0, 3, null);
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    public LayoutNode(boolean isVirtual, int semanticsId) {
        this.isVirtual = isVirtual;
        this.semanticsId = semanticsId;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new Function0<Unit>() { // from class: androidx.compose.ui.node.LayoutNode$_foldedChildren$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                LayoutNode.this.getLayoutDelegate().markChildrenDirty();
            }
        });
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, null);
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.measuredByParent = UsageByParent.NotUsed;
        this.measuredByParentInLookahead = UsageByParent.NotUsed;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        this.previousIntrinsicsUsageByParent = UsageByParent.NotUsed;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.INSTANCE;
    }

    public /* synthetic */ LayoutNode(boolean z, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z, (i2 & 2) != 0 ? SemanticsModifierCore.INSTANCE.generateSemanticsId() : i);
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    public int getSemanticsId() {
        return this.semanticsId;
    }

    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        if (lookaheadPassDelegate != null) {
            return Boolean.valueOf(lookaheadPassDelegate.isPlaced());
        }
        return null;
    }

    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                MutableVector it = new MutableVector(new LayoutNode[16], 0);
                this._unfoldedChildren = it;
                mutableVector = it;
            }
            MutableVector unfoldedChildren = mutableVector;
            unfoldedChildren.clear();
            MutableVectorWithMutationTracking this_$iv = this._foldedChildren;
            MutableVector this_$iv$iv = this_$iv.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
                    if (it2.isVirtual) {
                        MutableVector elements$iv = it2.get_children$ui_release();
                        unfoldedChildren.addAll(unfoldedChildren.getSize(), elements$iv);
                    } else {
                        unfoldedChildren.add(it2);
                    }
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate().getChildMeasurables$ui_release();
    }

    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        return lookaheadPassDelegate.getChildMeasurables$ui_release();
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode parent$ui_release;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (!this.isVirtual || (parent$ui_release = getParent$ui_release()) == null) {
            return;
        }
        parent$ui_release.unfoldedVirtualChildrenListDirty = true;
    }

    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    public final void forEachChild(Function1<? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv.getContent();
        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            block.invoke(content$iv[i$iv]);
            i$iv++;
        } while (i$iv < size$iv);
    }

    public final void forEachChildIndexed(Function2<? super Integer, ? super LayoutNode, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        MutableVector this_$iv = get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = 0;
        Object[] content$iv = this_$iv.getContent();
        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            block.invoke(Integer.valueOf(i$iv), content$iv[i$iv]);
            i$iv++;
        } while (i$iv < size$iv);
    }

    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        boolean z = false;
        if (layoutNode != null && layoutNode.isVirtual) {
            z = true;
        }
        LayoutNode layoutNode2 = this._foldedParent;
        if (!z) {
            return layoutNode2;
        }
        if (layoutNode2 != null) {
            return layoutNode2.getParent$ui_release();
        }
        return null;
    }

    /* renamed from: getOwner$ui_release, reason: from getter */
    public final Owner getOwner() {
        return this.owner;
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    public boolean isAttached() {
        return this.owner != null;
    }

    /* renamed from: getDepth$ui_release, reason: from getter */
    public final int getDepth() {
        return this.depth;
    }

    public final void setDepth$ui_release(int i) {
        this.depth = i;
    }

    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    private final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    private final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void insertAt$ui_release(int index, LayoutNode instance) {
        MutableVector<LayoutNode> vector;
        int size;
        Intrinsics.checkNotNullParameter(instance, "instance");
        NodeCoordinator nodeCoordinator = null;
        if ((instance._foldedParent == null) != true) {
            StringBuilder append = new StringBuilder().append("Cannot insert ").append(instance).append(" because it already has a parent. This tree: ").append(debugTreeToString$default(this, 0, 1, null)).append(" Other tree: ");
            LayoutNode layoutNode = instance._foldedParent;
            throw new IllegalStateException(append.append(layoutNode != null ? debugTreeToString$default(layoutNode, 0, 1, null) : null).toString().toString());
        }
        if ((instance.owner == null) != true) {
            throw new IllegalStateException(("Cannot insert " + instance + " because it already has an owner. This tree: " + debugTreeToString$default(this, 0, 1, null) + " Other tree: " + debugTreeToString$default(instance, 0, 1, null)).toString());
        }
        instance._foldedParent = this;
        this._foldedChildren.add(index, instance);
        onZSortedChildrenInvalidated$ui_release();
        if (instance.isVirtual) {
            if (this.isVirtual) {
                throw new IllegalArgumentException("Virtual LayoutNode can't be added into a virtual parent".toString());
            }
            this.virtualChildrenCount++;
        }
        invalidateUnfoldedVirtualChildren();
        NodeCoordinator outerCoordinator$ui_release = instance.getOuterCoordinator$ui_release();
        if (this.isVirtual) {
            LayoutNode layoutNode2 = this._foldedParent;
            if (layoutNode2 != null) {
                nodeCoordinator = layoutNode2.getInnerCoordinator$ui_release();
            }
        } else {
            nodeCoordinator = getInnerCoordinator$ui_release();
        }
        outerCoordinator$ui_release.setWrappedBy$ui_release(nodeCoordinator);
        if (instance.isVirtual && (size = (vector = instance._foldedChildren.getVector()).getSize()) > 0) {
            int i = 0;
            LayoutNode[] content = vector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                content[i].getOuterCoordinator$ui_release().setWrappedBy$ui_release(getInnerCoordinator$ui_release());
                i++;
            } while (i < size);
        }
        Owner owner = this.owner;
        if (owner != null) {
            instance.attach$ui_release(owner);
        }
        if (instance.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() + 1);
        }
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void removeAt$ui_release(int index, int count) {
        if (count >= 0) {
            int i = (index + count) - 1;
            if (index > i) {
                return;
            }
            while (true) {
                LayoutNode child = this._foldedChildren.removeAt(i);
                onChildRemoved(child);
                if (i == index) {
                    return;
                } else {
                    i--;
                }
            }
        } else {
            throw new IllegalArgumentException(("count (" + count + ") must be greater than 0").toString());
        }
    }

    public final void removeAll$ui_release() {
        int i = this._foldedChildren.getSize();
        while (true) {
            i--;
            if (-1 < i) {
                onChildRemoved(this._foldedChildren.get(i));
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    private final void onChildRemoved(LayoutNode child) {
        if (child.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            this.layoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(r0.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            child.detach$ui_release();
        }
        child._foldedParent = null;
        child.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
        if (child.isVirtual) {
            this.virtualChildrenCount--;
            MutableVectorWithMutationTracking this_$iv = child._foldedChildren;
            MutableVector this_$iv$iv = this_$iv.getVector();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv > 0) {
                int i$iv$iv = 0;
                Object[] content$iv$iv = this_$iv$iv.getContent();
                Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                    it.getOuterCoordinator$ui_release().setWrappedBy$ui_release(null);
                    i$iv$iv++;
                } while (i$iv$iv < size$iv$iv);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    public final void move$ui_release(int from, int to, int count) {
        if (from == to) {
            return;
        }
        for (int i = 0; i < count; i++) {
            int fromIndex = from > to ? from + i : from;
            int toIndex = from > to ? to + i : (to + count) - 2;
            LayoutNode child = this._foldedChildren.removeAt(fromIndex);
            this._foldedChildren.add(toIndex, child);
        }
        onZSortedChildrenInvalidated$ui_release();
        invalidateUnfoldedVirtualChildren();
        invalidateMeasurements$ui_release();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002a  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void attach$ui_release(Owner owner) {
        Object[] objArr;
        LookaheadScope lookaheadScope;
        Intrinsics.checkNotNullParameter(owner, "owner");
        LookaheadScope lookaheadScope2 = null;
        if ((this.owner == null) != true) {
            throw new IllegalStateException(("Cannot attach " + this + " as it already is attached.  Tree: " + debugTreeToString$default(this, 0, 1, null)).toString());
        }
        if (this._foldedParent != null) {
            LayoutNode layoutNode = this._foldedParent;
            if (!Intrinsics.areEqual(layoutNode != null ? layoutNode.owner : null, owner)) {
                objArr = false;
                if (objArr == true) {
                    StringBuilder append = new StringBuilder().append("Attaching to a different owner(").append(owner).append(") than the parent's owner(");
                    LayoutNode parent$ui_release = getParent$ui_release();
                    StringBuilder append2 = append.append(parent$ui_release != null ? parent$ui_release.owner : null).append("). This tree: ").append(debugTreeToString$default(this, 0, 1, null)).append(" Parent tree: ");
                    LayoutNode layoutNode2 = this._foldedParent;
                    throw new IllegalStateException(append2.append(layoutNode2 != null ? debugTreeToString$default(layoutNode2, 0, 1, null) : null).toString().toString());
                }
                LayoutNode parent$ui_release2 = getParent$ui_release();
                if (parent$ui_release2 == null) {
                    this.isPlaced = true;
                }
                this.owner = owner;
                this.depth = (parent$ui_release2 != null ? parent$ui_release2.depth : -1) + 1;
                if (SemanticsNodeKt.getOuterSemantics(this) != null) {
                    owner.onSemanticsChange();
                }
                owner.onAttach(this);
                if (parent$ui_release2 != null && (lookaheadScope = parent$ui_release2.mLookaheadScope) != null) {
                    lookaheadScope2 = lookaheadScope;
                } else if (this.isLookaheadRoot) {
                    lookaheadScope2 = new LookaheadScope(this);
                }
                setMLookaheadScope(lookaheadScope2);
                this.nodes.attach();
                MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
                int size = vector.getSize();
                if (size > 0) {
                    int i = 0;
                    LayoutNode[] content = vector.getContent();
                    Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                    do {
                        content[i].attach$ui_release(owner);
                        i++;
                    } while (i < size);
                }
                invalidateMeasurements$ui_release();
                if (parent$ui_release2 != null) {
                    parent$ui_release2.invalidateMeasurements$ui_release();
                }
                NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
                for (NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(outerCoordinator$ui_release, wrapped) && outerCoordinator$ui_release != null; outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped()) {
                    outerCoordinator$ui_release.attach();
                }
                Function1<? super Owner, Unit> function1 = this.onAttach;
                if (function1 != null) {
                    function1.invoke(owner);
                    return;
                }
                return;
            }
        }
        objArr = true;
        if (objArr == true) {
        }
    }

    public final void detach$ui_release() {
        Owner owner = this.owner;
        if (owner == null) {
            StringBuilder append = new StringBuilder().append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            throw new IllegalStateException(append.append(parent$ui_release != null ? debugTreeToString$default(parent$ui_release, 0, 1, null) : null).toString().toString());
        }
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
            parent.invalidateMeasurements$ui_release();
            this.measuredByParent = UsageByParent.NotUsed;
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner);
        }
        NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator delegate$iv = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate$iv, final$iv) && delegate$iv != null; delegate$iv = delegate$iv.getWrapped()) {
            NodeCoordinator it = delegate$iv;
            it.detach();
        }
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner.onSemanticsChange();
        }
        this.nodes.detach$ui_release();
        owner.onDetach(this);
        this.owner = null;
        this.depth = 0;
        MutableVector this_$iv$iv = this._foldedChildren.getVector();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                child.detach$ui_release();
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector this_$iv = this._zSortedChildren;
            MutableVector elements$iv = get_children$ui_release();
            this_$iv.addAll(this_$iv.getSize(), elements$iv);
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @Override // androidx.compose.p000ui.node.OwnerScope
    public boolean isValid() {
        return isAttached();
    }

    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    static /* synthetic */ String debugTreeToString$default(LayoutNode layoutNode, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return layoutNode.debugTreeToString(i);
    }

    private final String debugTreeToString(int depth) {
        StringBuilder tree = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            tree.append("  ");
        }
        tree.append("|-");
        tree.append(toString());
        tree.append('\n');
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv > 0) {
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
                tree.append(child.debugTreeToString(depth + 1));
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
        String treeString = tree.toString();
        Intrinsics.checkNotNullExpressionValue(treeString, "tree.toString()");
        if (depth == 0) {
            String treeString2 = treeString.substring(0, treeString.length() - 1);
            Intrinsics.checkNotNullExpressionValue(treeString2, "this as java.lang.String…ing(startIndex, endIndex)");
            return treeString2;
        }
        return treeString;
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(m286d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        private final String error;

        public NoIntrinsicsMeasurePolicy(String error) {
            Intrinsics.checkNotNullParameter(error, "error");
            this.error = error;
        }

        @Override // androidx.compose.p000ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List measurables, int width) {
            return ((Number) m3627maxIntrinsicHeight($this$maxIntrinsicHeight, (List<? extends IntrinsicMeasurable>) measurables, width)).intValue();
        }

        @Override // androidx.compose.p000ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List measurables, int height) {
            return ((Number) m3628maxIntrinsicWidth($this$maxIntrinsicWidth, (List<? extends IntrinsicMeasurable>) measurables, height)).intValue();
        }

        @Override // androidx.compose.p000ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List measurables, int width) {
            return ((Number) m3629minIntrinsicHeight($this$minIntrinsicHeight, (List<? extends IntrinsicMeasurable>) measurables, width)).intValue();
        }

        @Override // androidx.compose.p000ui.layout.MeasurePolicy
        public /* bridge */ /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List measurables, int height) {
            return ((Number) m3630minIntrinsicWidth($this$minIntrinsicWidth, (List<? extends IntrinsicMeasurable>) measurables, height)).intValue();
        }

        /* renamed from: minIntrinsicWidth, reason: collision with other method in class */
        public Void m3630minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: minIntrinsicHeight, reason: collision with other method in class */
        public Void m3629minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: maxIntrinsicWidth, reason: collision with other method in class */
        public Void m3628maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, List<? extends IntrinsicMeasurable> measurables, int height) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        /* renamed from: maxIntrinsicHeight, reason: collision with other method in class */
        public Void m3627maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, List<? extends IntrinsicMeasurable> measurables, int width) {
            Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
            Intrinsics.checkNotNullParameter(measurables, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Override // androidx.compose.p000ui.node.ComposeUiNode
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @Override // androidx.compose.p000ui.node.ComposeUiNode
    public void setMeasurePolicy(MeasurePolicy value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.measurePolicy, value)) {
            this.measurePolicy = value;
            this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
            invalidateMeasurements$ui_release();
        }
    }

    /* renamed from: getIntrinsicsPolicy$ui_release, reason: from getter */
    public final IntrinsicsPolicy getIntrinsicsPolicy() {
        return this.intrinsicsPolicy;
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo, androidx.compose.p000ui.node.ComposeUiNode
    public Density getDensity() {
        return this.density;
    }

    @Override // androidx.compose.p000ui.node.ComposeUiNode
    public void setDensity(Density value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (!Intrinsics.areEqual(this.density, value)) {
            this.density = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    /* renamed from: getMLookaheadScope$ui_release, reason: from getter */
    public final LookaheadScope getMLookaheadScope() {
        return this.mLookaheadScope;
    }

    private final void setMLookaheadScope(LookaheadScope newScope) {
        if (!Intrinsics.areEqual(newScope, this.mLookaheadScope)) {
            this.mLookaheadScope = newScope;
            this.layoutDelegate.onLookaheadScopeChanged$ui_release(newScope);
            NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped();
            for (NodeCoordinator delegate$iv = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate$iv, final$iv) && delegate$iv != null; delegate$iv = delegate$iv.getWrapped()) {
                NodeCoordinator coordinator = delegate$iv;
                coordinator.updateLookaheadScope$ui_release(newScope);
            }
        }
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo, androidx.compose.p000ui.node.ComposeUiNode
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    @Override // androidx.compose.p000ui.node.ComposeUiNode
    public void setLayoutDirection(LayoutDirection value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (this.layoutDirection != value) {
            this.layoutDirection = value;
            onDensityOrLayoutDirectionChanged();
        }
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo, androidx.compose.p000ui.node.ComposeUiNode
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Override // androidx.compose.p000ui.node.ComposeUiNode
    public void setViewConfiguration(ViewConfiguration viewConfiguration) {
        Intrinsics.checkNotNullParameter(viewConfiguration, "<set-?>");
        this.viewConfiguration = viewConfiguration;
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate $this$_get_alignmentLinesRequired__u24lambda_u2d17 = this.layoutDelegate;
        if ($this$_get_alignmentLinesRequired__u24lambda_u2d17.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = $this$_get_alignmentLinesRequired__u24lambda_u2d17.getLookaheadAlignmentLinesOwner$ui_release();
        return lookaheadAlignmentLinesOwner$ui_release != null && (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) != null && alignmentLines.getRequired$ui_release();
    }

    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    /* renamed from: isPlaced, reason: from getter */
    public boolean getIsPlaced() {
        return this.isPlaced;
    }

    /* renamed from: getPlaceOrder$ui_release, reason: from getter */
    public final int getPlaceOrder() {
        return this.placeOrder;
    }

    /* renamed from: getPreviousPlaceOrder$ui_release, reason: from getter */
    public final int getPreviousPlaceOrder() {
        return this.previousPlaceOrder;
    }

    /* renamed from: getMeasuredByParent$ui_release, reason: from getter */
    public final UsageByParent getMeasuredByParent() {
        return this.measuredByParent;
    }

    public final void setMeasuredByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParent = usageByParent;
    }

    /* renamed from: getMeasuredByParentInLookahead$ui_release, reason: from getter */
    public final UsageByParent getMeasuredByParentInLookahead() {
        return this.measuredByParentInLookahead;
    }

    public final void setMeasuredByParentInLookahead$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParentInLookahead = usageByParent;
    }

    /* renamed from: getIntrinsicsUsageByParent$ui_release, reason: from getter */
    public final UsageByParent getIntrinsicsUsageByParent() {
        return this.intrinsicsUsageByParent;
    }

    public final void setIntrinsicsUsageByParent$ui_release(UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    /* renamed from: getCanMultiMeasure$ui_release, reason: from getter */
    public final boolean getCanMultiMeasure() {
        return this.canMultiMeasure;
    }

    public final void setCanMultiMeasure$ui_release(boolean z) {
        this.canMultiMeasure = z;
    }

    /* renamed from: isLookaheadRoot, reason: from getter */
    public final boolean getIsLookaheadRoot() {
        return this.isLookaheadRoot;
    }

    public final void setLookaheadRoot(boolean value) {
        if (value != this.isLookaheadRoot) {
            if (!value) {
                setMLookaheadScope(null);
            } else {
                setMLookaheadScope(new LookaheadScope(this));
            }
            this.isLookaheadRoot = value;
        }
    }

    /* renamed from: getNodes$ui_release, reason: from getter */
    public final NodeChain getNodes() {
        return this.nodes;
    }

    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator();
    }

    /* renamed from: getLayoutDelegate$ui_release, reason: from getter */
    public final LayoutNodeLayoutDelegate getLayoutDelegate() {
        return this.layoutDelegate;
    }

    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator();
    }

    /* renamed from: getSubcompositionsState$ui_release, reason: from getter */
    public final LayoutNodeSubcompositionsState getSubcompositionsState() {
        return this.subcompositionsState;
    }

    public final void setSubcompositionsState$ui_release(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    /* renamed from: getInnerLayerCoordinatorIsDirty$ui_release, reason: from getter */
    public final boolean getInnerLayerCoordinatorIsDirty() {
        return this.innerLayerCoordinatorIsDirty;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z) {
        this.innerLayerCoordinatorIsDirty = z;
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator coordinator = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy = getOuterCoordinator$ui_release().getWrappedBy();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual(coordinator, wrappedBy)) {
                    break;
                }
                if ((coordinator != null ? coordinator.getLayer() : null) != null) {
                    this._innerLayerCoordinator = coordinator;
                    break;
                }
                coordinator = coordinator != null ? coordinator.getWrappedBy() : null;
            }
        }
        NodeCoordinator coordinator2 = this._innerLayerCoordinator;
        if (coordinator2 == null || coordinator2.getLayer() != null) {
            return coordinator2;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent = getParent$ui_release();
        if (parent != null) {
            parent.invalidateLayer$ui_release();
        }
    }

    @Override // androidx.compose.p000ui.node.ComposeUiNode
    public Modifier getModifier() {
        return this.modifier;
    }

    @Override // androidx.compose.p000ui.node.ComposeUiNode
    public void setModifier(Modifier value) {
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(value, "value");
        if (Intrinsics.areEqual(value, this.modifier)) {
            return;
        }
        if (!(!this.isVirtual || getModifier() == Modifier.INSTANCE)) {
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
        this.modifier = value;
        boolean oldShouldInvalidateParentLayer = shouldInvalidateParentLayer();
        NodeCoordinator oldOuterCoordinator = getOuterCoordinator$ui_release();
        this.nodes.updateFrom$ui_release(value);
        NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator delegate$iv = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate$iv, final$iv) && delegate$iv != null; delegate$iv = delegate$iv.getWrapped()) {
            NodeCoordinator it = delegate$iv;
            it.onInitialize();
            it.updateLookaheadScope$ui_release(this.mLookaheadScope);
        }
        this.layoutDelegate.updateParentData();
        if ((oldShouldInvalidateParentLayer || shouldInvalidateParentLayer()) && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        if (!Intrinsics.areEqual(oldOuterCoordinator, getInnerCoordinator$ui_release()) || !Intrinsics.areEqual(getOuterCoordinator$ui_release(), getInnerCoordinator$ui_release())) {
            invalidateMeasurements$ui_release();
        }
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    public final void setOnAttach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    public final void setOnDetach$ui_release(Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    /* renamed from: getNeedsOnPositionedDispatch$ui_release, reason: from getter */
    public final boolean getNeedsOnPositionedDispatch() {
        return this.needsOnPositionedDispatch;
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z) {
        this.needsOnPositionedDispatch = z;
    }

    public final void place$ui_release(int x, int y) {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate $this$place_u24lambda_u2d21 = getMeasurePassDelegate();
        Placeable.PlacementScope.Companion this_$iv = Placeable.PlacementScope.INSTANCE;
        int parentWidth$iv = $this$place_u24lambda_u2d21.getMeasuredWidth();
        LayoutDirection parentLayoutDirection$iv = getLayoutDirection();
        LayoutNode parent$ui_release = getParent$ui_release();
        LookaheadCapablePlaceable lookaheadCapablePlaceable$iv = parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null;
        LayoutCoordinates previousLayoutCoordinates$iv = Placeable.PlacementScope._coordinates;
        int previousParentWidth$iv = Placeable.PlacementScope.INSTANCE.getParentWidth();
        LayoutDirection previousParentLayoutDirection$iv = Placeable.PlacementScope.INSTANCE.getParentLayoutDirection();
        LayoutNodeLayoutDelegate previousLayoutDelegate$iv = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentWidth = parentWidth$iv;
        Placeable.PlacementScope.Companion companion2 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentLayoutDirection = parentLayoutDirection$iv;
        boolean wasPlacingForAlignment$iv = this_$iv.configureForPlacingForAlignment(lookaheadCapablePlaceable$iv);
        Placeable.PlacementScope.Companion $this$place_u24lambda_u2d21_u24lambda_u2d20 = this_$iv;
        Placeable.PlacementScope.placeRelative$default($this$place_u24lambda_u2d21_u24lambda_u2d20, $this$place_u24lambda_u2d21, x, y, 0.0f, 4, null);
        if (lookaheadCapablePlaceable$iv != null) {
            lookaheadCapablePlaceable$iv.setPlacingForAlignment$ui_release(wasPlacingForAlignment$iv);
        }
        Placeable.PlacementScope.Companion companion3 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentWidth = previousParentWidth$iv;
        Placeable.PlacementScope.Companion companion4 = Placeable.PlacementScope.INSTANCE;
        Placeable.PlacementScope.parentLayoutDirection = previousParentLayoutDirection$iv;
        Placeable.PlacementScope._coordinates = previousLayoutCoordinates$iv;
        Placeable.PlacementScope.layoutDelegate = previousLayoutDelegate$iv;
    }

    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        try {
            this.relayoutWithoutParentInProgress = true;
            getMeasurePassDelegate().replace();
        } finally {
            this.relayoutWithoutParentInProgress = false;
        }
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        lookaheadPassDelegate.replace();
    }

    public final void draw$ui_release(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterCoordinator$ui_release().draw(canvas);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m3617hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) == 0) {
            z3 = z;
        } else {
            z3 = false;
        }
        if ((i & 8) == 0) {
            z4 = z2;
        } else {
            z4 = true;
        }
        layoutNode.m3621hitTestM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m3621hitTestM_7yMNQ$ui_release(long pointerPosition, HitTestResult<PointerInputModifierNode> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        long positionInWrapped = getOuterCoordinator$ui_release().m3676fromParentPositionMKHz9U(pointerPosition);
        getOuterCoordinator$ui_release().m3681hitTestYqVAtuI(NodeCoordinator.INSTANCE.getPointerInputSource(), positionInWrapped, hitTestResult, isTouchEvent, isInLayer);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release$default, reason: not valid java name */
    public static /* synthetic */ void m3618hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j, HitTestResult hitTestResult, boolean z, boolean z2, int i, Object obj) {
        boolean z3;
        boolean z4;
        if ((i & 4) == 0) {
            z3 = z;
        } else {
            z3 = true;
        }
        if ((i & 8) == 0) {
            z4 = z2;
        } else {
            z4 = true;
        }
        layoutNode.m3622hitTestSemanticsM_7yMNQ$ui_release(j, hitTestResult, z3, z4);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release, reason: not valid java name */
    public final void m3622hitTestSemanticsM_7yMNQ$ui_release(long pointerPosition, HitTestResult<SemanticsModifierNode> hitSemanticsEntities, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitSemanticsEntities, "hitSemanticsEntities");
        long positionInWrapped = getOuterCoordinator$ui_release().m3676fromParentPositionMKHz9U(pointerPosition);
        getOuterCoordinator$ui_release().m3681hitTestYqVAtuI(NodeCoordinator.INSTANCE.getSemanticsSource(), positionInWrapped, hitSemanticsEntities, true, isInLayer);
    }

    public final void onNodePlaced$ui_release() {
        LayoutNode parent = getParent$ui_release();
        float newZIndex = getInnerCoordinator$ui_release().getZIndex();
        NodeCoordinator inner$iv = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator$iv = getOuterCoordinator$ui_release(); coordinator$iv != inner$iv; coordinator$iv = ((LayoutModifierNodeCoordinator) coordinator$iv).getWrapped()) {
            Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator it = (LayoutModifierNodeCoordinator) coordinator$iv;
            newZIndex += it.getZIndex();
        }
        if (!(newZIndex == this.zIndex)) {
            this.zIndex = newZIndex;
            if (parent != null) {
                parent.onZSortedChildrenInvalidated$ui_release();
            }
            if (parent != null) {
                parent.invalidateLayer$ui_release();
            }
        }
        if (!getIsPlaced()) {
            if (parent != null) {
                parent.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
        }
        if (parent != null) {
            if (!this.relayoutWithoutParentInProgress && parent.getLayoutState$ui_release() == LayoutState.LayingOut) {
                if (!(this.placeOrder == Integer.MAX_VALUE)) {
                    throw new IllegalStateException("Place was called on a node which was placed already".toString());
                }
                this.placeOrder = parent.nextChildPlaceOrder;
                parent.nextChildPlaceOrder++;
            }
        } else {
            this.placeOrder = 0;
        }
        this.layoutDelegate.getAlignmentLinesOwner$ui_release().layoutChildren();
    }

    public final void clearPlaceOrder$ui_release() {
        this.nextChildPlaceOrder = 0;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
            child.previousPlaceOrder = child.placeOrder;
            child.placeOrder = Integer.MAX_VALUE;
            if (child.measuredByParent == UsageByParent.InLayoutBlock) {
                child.measuredByParent = UsageByParent.NotUsed;
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    public final void checkChildrenPlaceOrderForUpdates$ui_release() {
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode child = (LayoutNode) content$iv$iv[i$iv$iv];
            if (child.previousPlaceOrder != child.placeOrder) {
                onZSortedChildrenInvalidated$ui_release();
                invalidateLayer$ui_release();
                if (child.placeOrder == Integer.MAX_VALUE) {
                    child.markSubtreeAsNotPlaced();
                }
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean wasPlaced = getIsPlaced();
        this.isPlaced = true;
        if (!wasPlaced) {
            if (getMeasurePending$ui_release()) {
                requestRemeasure$ui_release(true);
            } else if (getLookaheadMeasurePending$ui_release()) {
                requestLookaheadRemeasure$ui_release(true);
            }
        }
        NodeCoordinator final$iv = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator delegate$iv = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate$iv, final$iv) && delegate$iv != null; delegate$iv = delegate$iv.getWrapped()) {
            NodeCoordinator it = delegate$iv;
            if (it.getLastLayerDrawingWasSkipped()) {
                it.invalidateLayer();
            }
        }
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode it2 = (LayoutNode) content$iv$iv[i$iv$iv];
            if (it2.placeOrder != Integer.MAX_VALUE) {
                it2.markNodeAndSubtreeAsPlaced();
                rescheduleRemeasureOrRelayout$ui_release(it2);
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(LayoutNode it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (WhenMappings.$EnumSwitchMapping$0[it.getLayoutState$ui_release().ordinal()] == 1) {
            if (it.getMeasurePending$ui_release()) {
                it.requestRemeasure$ui_release(true);
                return;
            }
            if (it.getLayoutPending$ui_release()) {
                it.requestRelayout$ui_release(true);
                return;
            } else if (it.getLookaheadMeasurePending$ui_release()) {
                it.requestLookaheadRemeasure$ui_release(true);
                return;
            } else {
                if (it.getLookaheadLayoutPending$ui_release()) {
                    it.requestLookaheadRelayout$ui_release(true);
                    return;
                }
                return;
            }
        }
        throw new IllegalStateException("Unexpected state " + it.getLayoutState$ui_release());
    }

    private final void markSubtreeAsNotPlaced() {
        if (getIsPlaced()) {
            this.isPlaced = false;
            MutableVector this_$iv$iv = get_children$ui_release();
            int size$iv$iv = this_$iv$iv.getSize();
            if (size$iv$iv <= 0) {
                return;
            }
            int i$iv$iv = 0;
            Object[] content$iv$iv = this_$iv$iv.getContent();
            Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
                it.markSubtreeAsNotPlaced();
                i$iv$iv++;
            } while (i$iv$iv < size$iv$iv);
        }
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRemeasure$ui_release(z);
    }

    public final void requestRemeasure$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.ignoreRemeasureRequests || this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestMeasure$default(owner, this, false, forceRequest, 2, null);
        getMeasurePassDelegate().invalidateIntrinsicsParent(forceRequest);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z);
    }

    public final void requestLookaheadRemeasure$ui_release(boolean forceRequest) {
        if (!(this.mLookaheadScope != null)) {
            throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
        }
        Owner owner = this.owner;
        if (owner != null && !this.ignoreRemeasureRequests && !this.isVirtual) {
            owner.onRequestMeasure(this, true, forceRequest);
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            lookaheadPassDelegate.invalidateIntrinsicsParent(forceRequest);
        }
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.mLookaheadScope != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, 1, null);
        } else {
            requestRemeasure$ui_release$default(this, false, 1, null);
        }
    }

    public final void ignoreRemeasureRequests$ui_release(Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        this.ignoreRemeasureRequests = true;
        block.invoke();
        this.ignoreRemeasureRequests = false;
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestRelayout$ui_release(z);
    }

    public final void requestRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        Owner.onRequestRelayout$default(owner, this, false, forceRequest, 2, null);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z);
    }

    public final void requestLookaheadRelayout$ui_release(boolean forceRequest) {
        Owner owner;
        if (this.isVirtual || (owner = this.owner) == null) {
            return;
        }
        owner.onRequestRelayout(this, true, forceRequest);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void dispatchOnPositionedCallbacks$ui_release() {
        NodeChain this_$iv;
        if (getLayoutState$ui_release() != LayoutState.Idle || getLayoutPending$ui_release() || getMeasurePending$ui_release() || !getIsPlaced()) {
            return;
        }
        NodeChain this_$iv2 = this.nodes;
        int type$iv = Nodes.INSTANCE.m3706getGlobalPositionAwareOLwlOKw();
        if ((this_$iv2.getAggregateChildKindSet() & type$iv) == 0) {
            return;
        }
        Modifier.Node node$iv$iv$iv = this_$iv2.getHead();
        while (node$iv$iv$iv != null) {
            Modifier.Node node = node$iv$iv$iv;
            if ((node.getKindSet() & type$iv) != 0) {
                if (!(node instanceof GlobalPositionAwareModifierNode)) {
                    this_$iv = this_$iv2;
                } else {
                    GlobalPositionAwareModifierNode it = (GlobalPositionAwareModifierNode) node;
                    this_$iv = this_$iv2;
                    it.onGloballyPositioned(DelegatableNodeKt.m3597requireCoordinator64DMado(it, Nodes.INSTANCE.m3706getGlobalPositionAwareOLwlOKw()));
                }
            } else {
                this_$iv = this_$iv2;
            }
            if ((node.getAggregateChildKindSet() & type$iv) == 0) {
                return;
            }
            node$iv$iv$iv = node$iv$iv$iv.getChild();
            this_$iv2 = this_$iv;
        }
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator inner$iv = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator$iv = getOuterCoordinator$ui_release(); coordinator$iv != inner$iv; coordinator$iv = ((LayoutModifierNodeCoordinator) coordinator$iv).getWrapped()) {
            Intrinsics.checkNotNull(coordinator$iv, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator coordinator = (LayoutModifierNodeCoordinator) coordinator$iv;
            OwnedLayer layer = coordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m3619lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m3637getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m3623lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m3623lookaheadRemeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints != null && this.mLookaheadScope != null) {
            LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
            Intrinsics.checkNotNull(lookaheadPassDelegate);
            return lookaheadPassDelegate.m3639remeasureBRTryo0(constraints.getValue());
        }
        return false;
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default, reason: not valid java name */
    public static /* synthetic */ boolean m3620remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i, Object obj) {
        if ((i & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m3636getLastConstraintsDWUhwKw();
        }
        return layoutNode.m3624remeasure_Sx5XlM$ui_release(constraints);
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release, reason: not valid java name */
    public final boolean m3624remeasure_Sx5XlM$ui_release(Constraints constraints) {
        if (constraints != null) {
            if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
                clearSubtreeIntrinsicsUsage$ui_release();
            }
            return getMeasurePassDelegate().m3642remeasureBRTryo0(constraints.getValue());
        }
        return false;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    @Override // androidx.compose.p000ui.layout.Remeasurement
    public void forceRemeasure() {
        requestRemeasure$ui_release$default(this, false, 1, null);
        Constraints lastConstraints = this.layoutDelegate.m3636getLastConstraintsDWUhwKw();
        if (lastConstraints != null) {
            Owner owner = this.owner;
            if (owner != null) {
                owner.mo3724measureAndLayout0kLqBqw(this, lastConstraints.getValue());
                return;
            }
            return;
        }
        Owner owner2 = this.owner;
        if (owner2 != null) {
            Owner.measureAndLayout$default(owner2, false, 1, null);
        }
    }

    @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
    public void onLayoutComplete() {
        NodeCoordinator this_$iv = getInnerCoordinator$ui_release();
        int type$iv = Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw();
        boolean includeTail$iv$iv = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type$iv);
        Modifier.Node stopNode$iv$iv = this_$iv.getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent()) != null) {
            for (Modifier.Node node$iv$iv = this_$iv.headNode(includeTail$iv$iv); node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet() & type$iv) != 0; node$iv$iv = node$iv$iv.getChild()) {
                if ((node$iv$iv.getKindSet() & type$iv) != 0) {
                    Object obj = node$iv$iv;
                    if (obj instanceof LayoutAwareModifierNode) {
                        LayoutAwareModifierNode it = (LayoutAwareModifierNode) obj;
                        it.onPlaced(getInnerCoordinator$ui_release());
                    }
                }
                if (node$iv$iv == stopNode$iv$iv) {
                    return;
                }
            }
        }
    }

    private final void forEachCoordinator(Function1<? super LayoutModifierNodeCoordinator, Unit> block) {
        NodeCoordinator inner = getInnerCoordinator$ui_release();
        for (NodeCoordinator coordinator = getOuterCoordinator$ui_release(); coordinator != inner; coordinator = ((LayoutModifierNodeCoordinator) coordinator).getWrapped()) {
            Intrinsics.checkNotNull(coordinator, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            block.invoke((LayoutModifierNodeCoordinator) coordinator);
        }
    }

    private final void forEachCoordinatorIncludingInner(Function1<? super NodeCoordinator, Unit> block) {
        NodeCoordinator wrapped = getInnerCoordinator$ui_release().getWrapped();
        for (NodeCoordinator delegate = getOuterCoordinator$ui_release(); !Intrinsics.areEqual(delegate, wrapped) && delegate != null; delegate = delegate.getWrapped()) {
            block.invoke(delegate);
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        if (this.nodes.m3657hasH91voCI$ui_release(Nodes.INSTANCE.m3705getDrawOLwlOKw()) && !this.nodes.m3657hasH91voCI$ui_release(Nodes.INSTANCE.m3708getLayoutOLwlOKw())) {
            return true;
        }
        NodeChain this_$iv = this.nodes;
        for (Modifier.Node node$iv = this_$iv.getHead(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            int kind$iv = Nodes.INSTANCE.m3708getLayoutOLwlOKw();
            int kind$iv2 = (it.getKindSet() & kind$iv) != 0 ? 1 : 0;
            if (kind$iv2 != 0 && (it instanceof LayoutModifierNode) && DelegatableNodeKt.m3597requireCoordinator64DMado(it, Nodes.INSTANCE.m3708getLayoutOLwlOKw()).getLayer() != null) {
                return false;
            }
            int kind$iv3 = Nodes.INSTANCE.m3705getDrawOLwlOKw();
            if ((it.getKindSet() & kind$iv3) != 0) {
                return true;
            }
        }
        return true;
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            if (it.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                it.clearSubtreeIntrinsicsUsage$ui_release();
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            if (it.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                it.clearSubtreePlacementIntrinsicsUsage();
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector this_$iv$iv = get_children$ui_release();
        int size$iv$iv = this_$iv$iv.getSize();
        if (size$iv$iv <= 0) {
            return;
        }
        int i$iv$iv = 0;
        Object[] content$iv$iv = this_$iv$iv.getContent();
        Intrinsics.checkNotNull(content$iv$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode it = (LayoutNode) content$iv$iv[i$iv$iv];
            it.intrinsicsUsageByParent = it.previousIntrinsicsUsageByParent;
            if (it.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                it.resetSubtreeIntrinsicsUsage$ui_release();
            }
            i$iv$iv++;
        } while (i$iv$iv < size$iv$iv);
    }

    @Override // androidx.compose.p000ui.layout.LayoutInfo
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    /* compiled from: LayoutNode.kt */
    @Metadata(m286d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0080T¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, m287d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ZComparator$lambda-37, reason: not valid java name */
    public static final int m3616ZComparator$lambda37(LayoutNode node1, LayoutNode node2) {
        if (node1.zIndex == node2.zIndex) {
            return Intrinsics.compare(node1.placeOrder, node2.placeOrder);
        }
        return Float.compare(node1.zIndex, node2.zIndex);
    }
}
