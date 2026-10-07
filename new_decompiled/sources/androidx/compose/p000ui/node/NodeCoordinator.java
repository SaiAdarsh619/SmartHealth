package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.geometry.MutableRect;
import androidx.compose.p000ui.geometry.MutableRectKt;
import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.geometry.OffsetKt;
import androidx.compose.p000ui.geometry.Rect;
import androidx.compose.p000ui.geometry.Size;
import androidx.compose.p000ui.geometry.SizeKt;
import androidx.compose.p000ui.graphics.Canvas;
import androidx.compose.p000ui.graphics.GraphicsLayerScope;
import androidx.compose.p000ui.graphics.Matrix;
import androidx.compose.p000ui.graphics.Paint;
import androidx.compose.p000ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.p000ui.layout.AlignmentLine;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutCoordinatesKt;
import androidx.compose.p000ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.p000ui.layout.LookaheadScope;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.Placeable;
import androidx.compose.p000ui.semantics.SemanticsConfiguration;
import androidx.compose.p000ui.semantics.SemanticsNodeKt;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntOffset;
import androidx.compose.p000ui.unit.IntOffsetKt;
import androidx.compose.p000ui.unit.IntSize;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* compiled from: NodeCoordinator.kt */
@Metadata(m286d1 = {"\u0000 \u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\"\b \u0018\u0000 \u008e\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004\u008e\u0002\u008f\u0002B\r\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ$\u0010\u0080\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00002\u0007\u0010\u0082\u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020 H\u0002J,\u0010\u0080\u0001\u001a\u00030\u0084\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u00002\b\u0010\u0085\u0001\u001a\u00030\u0084\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0086\u0001\u0010\u0087\u0001J\t\u0010\u0088\u0001\u001a\u00020\u0007H\u0016J \u0010\u0089\u0001\u001a\u00020K2\u0006\u0010J\u001a\u00020KH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008a\u0001\u0010\u008b\u0001J\u0013\u0010\u008c\u0001\u001a\u00020@2\b\u0010\u008d\u0001\u001a\u00030\u008e\u0001H&J\t\u0010\u008f\u0001\u001a\u00020\u0007H\u0016J*\u0010\u0090\u0001\u001a\u00020\u001a2\b\u0010\u0091\u0001\u001a\u00030\u0084\u00012\u0006\u0010J\u001a\u00020KH\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J\u0010\u0010\u0094\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u0006J\u001c\u0010\u0096\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u00062\b\u0010\u0097\u0001\u001a\u00030\u0098\u0001H\u0004J\u0012\u0010\u0099\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u0006H\u0002J\u0018\u0010\u009a\u0001\u001a\u00020\u00002\u0007\u0010\u009b\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\b\u009c\u0001J\"\u0010\u009d\u0001\u001a\u00030\u0084\u00012\u0007\u0010]\u001a\u00030\u0084\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u009e\u0001\u0010\u008b\u0001J\u001b\u0010\u009f\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020 H\u0002J$\u0010¡\u0001\u001a\u00020 2\f\u0010¢\u0001\u001a\u0007\u0012\u0002\b\u00030£\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¤\u0001\u0010¥\u0001J6\u0010¦\u0001\u001a\u0005\u0018\u0001H§\u0001\"\u0007\b\u0000\u0010§\u0001\u0018\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010£\u0001H\u0086\bø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¨\u0001\u0010©\u0001J\u0014\u0010ª\u0001\u001a\u0004\u0018\u00010q2\u0007\u0010«\u0001\u001a\u00020 H\u0002J1\u0010¬\u0001\u001a\u0005\u0018\u0001H§\u0001\"\u0005\b\u0000\u0010§\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010£\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u00ad\u0001\u0010©\u0001J`\u0010®\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0091\u0001\u001a\u00030\u0084\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¶\u0001\u0010·\u0001Jb\u0010¸\u0001\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0091\u0001\u001a\u00030\u0084\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¹\u0001\u0010·\u0001J\t\u0010º\u0001\u001a\u00020\u0007H\u0016J\u0013\u0010»\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u0006H\u0096\u0002J\"\u0010¼\u0001\u001a\u00020 2\b\u0010\u0091\u0001\u001a\u00030\u0084\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b½\u0001\u0010¾\u0001J\u0007\u0010¿\u0001\u001a\u00020 J\u001c\u0010À\u0001\u001a\u00030Á\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\u0007\u0010\u0083\u0001\u001a\u00020 H\u0016J,\u0010Ã\u0001\u001a\u00030\u0084\u00012\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010Ä\u0001\u001a\u00030\u0084\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÅ\u0001\u0010Æ\u0001J#\u0010Ç\u0001\u001a\u00030\u0084\u00012\b\u0010È\u0001\u001a\u00030\u0084\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÉ\u0001\u0010\u008b\u0001J#\u0010Ê\u0001\u001a\u00030\u0084\u00012\b\u0010È\u0001\u001a\u00030\u0084\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bË\u0001\u0010\u008b\u0001J#\u0010Ì\u0001\u001a\u00030\u0084\u00012\b\u0010\u0091\u0001\u001a\u00030\u0084\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÍ\u0001\u0010\u008b\u0001J\u0007\u0010Î\u0001\u001a\u00020\u0007J\"\u0010Ï\u0001\u001a\u00020\u00072\u0019\u00102\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b1J\t\u0010Ð\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010Ñ\u0001\u001a\u00020\u00072\u0007\u0010Ò\u0001\u001a\u00020Q2\u0007\u0010Ó\u0001\u001a\u00020QH\u0014J\u0007\u0010Ô\u0001\u001a\u00020\u0007J\u0007\u0010Õ\u0001\u001a\u00020\u0007J\u0012\u0010Ö\u0001\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u0006H\u0016J7\u0010×\u0001\u001a\u00030Ø\u00012\b\u0010Ù\u0001\u001a\u00030Ú\u00012\u000e\u0010Û\u0001\u001a\t\u0012\u0005\u0012\u00030Ø\u00010$H\u0084\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bÜ\u0001\u0010Ý\u0001JC\u0010Þ\u0001\u001a\u00020\u00072\u0006\u0010]\u001a\u00020\\2\u0006\u0010|\u001a\u00020\u001a2\u0019\u00102\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b1H\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bß\u0001\u0010à\u0001J\u001d\u0010á\u0001\u001a\u00020\u00072\b\u0010\u0082\u0001\u001a\u00030Á\u0001H\u0096@ø\u0001\u0000¢\u0006\u0003\u0010â\u0001J,\u0010ã\u0001\u001a\u00020\u00072\u0007\u0010 \u0001\u001a\u00020\u000e2\u0007\u0010\u0083\u0001\u001a\u00020 2\t\b\u0002\u0010ä\u0001\u001a\u00020 H\u0000¢\u0006\u0003\bå\u0001J\u000f\u0010æ\u0001\u001a\u00020\u0007H\u0010¢\u0006\u0003\bç\u0001J\u0007\u0010è\u0001\u001a\u00020 J\"\u0010é\u0001\u001a\u00030\u0084\u00012\u0007\u0010]\u001a\u00030\u0084\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bê\u0001\u0010\u008b\u0001J\b\u0010ë\u0001\u001a\u00030Á\u0001J+\u0010ì\u0001\u001a\u00020\u00072\u0007\u0010Â\u0001\u001a\u00020\u00032\b\u0010í\u0001\u001a\u00030î\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bï\u0001\u0010ð\u0001J+\u0010ñ\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00002\b\u0010í\u0001\u001a\u00030î\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bò\u0001\u0010ó\u0001J+\u0010ô\u0001\u001a\u00020\u00072\u0007\u0010\u0081\u0001\u001a\u00020\u00002\b\u0010í\u0001\u001a\u00030î\u0001H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0001\u0010ó\u0001J\t\u0010ö\u0001\u001a\u00020\u0007H\u0002J\u0011\u0010÷\u0001\u001a\u00020\u00072\u0006\u0010A\u001a\u00020@H\u0004J\u001b\u0010ø\u0001\u001a\u00020\u00072\n\u0010\u008d\u0001\u001a\u0005\u0018\u00010\u008e\u0001H\u0000¢\u0006\u0003\bù\u0001JL\u0010ú\u0001\u001a\u00020\u0007\"\u0007\b\u0000\u0010§\u0001\u0018\u00012\u000f\u0010¢\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010£\u00012\u0014\u0010Û\u0001\u001a\u000f\u0012\u0005\u0012\u0003H§\u0001\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0003ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bû\u0001\u0010ü\u0001J4\u0010ú\u0001\u001a\u00020\u00072\u0007\u0010ý\u0001\u001a\u00020Q2\u0007\u0010«\u0001\u001a\u00020 2\u0013\u0010Û\u0001\u001a\u000e\u0012\u0004\u0012\u00020q\u0012\u0004\u0012\u00020\u00070\u0005H\u0086\bø\u0001\u0003J#\u0010þ\u0001\u001a\u00030\u0084\u00012\b\u0010ÿ\u0001\u001a\u00030\u0084\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0080\u0002\u0010\u008b\u0001J+\u0010\u0081\u0002\u001a\u00020\u00072\u0007\u0010\u0095\u0001\u001a\u00020\u00062\u0013\u0010Û\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005H\u0084\bø\u0001\u0003J\"\u0010\u0082\u0002\u001a\u00020 2\b\u0010\u0091\u0001\u001a\u00030\u0084\u0001H\u0004ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0083\u0002\u0010¾\u0001Ji\u0010\u0084\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u0001*\u0005\u0018\u0001H§\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0091\u0001\u001a\u00030\u0084\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0085\u0002\u0010\u0086\u0002Jr\u0010\u0087\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u0001*\u0005\u0018\u0001H§\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0091\u0001\u001a\u00030\u0084\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 2\u0007\u0010\u0088\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0089\u0002\u0010\u008a\u0002Jr\u0010\u008b\u0002\u001a\u00020\u0007\"\n\b\u0000\u0010§\u0001*\u00030¯\u0001*\u0005\u0018\u0001H§\u00012\u000f\u0010°\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010±\u00012\b\u0010\u0091\u0001\u001a\u00030\u0084\u00012\u000f\u0010²\u0001\u001a\n\u0012\u0005\u0012\u0003H§\u00010³\u00012\u0007\u0010´\u0001\u001a\u00020 2\u0007\u0010µ\u0001\u001a\u00020 2\u0007\u0010\u0088\u0002\u001a\u00020\u001aH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u008c\u0002\u0010\u008a\u0002J\r\u0010\u008d\u0002\u001a\u00020\u0000*\u00020\u0003H\u0002R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u00108VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\u001a8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001cR\u0014\u0010\u001f\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00070$X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\u00020 8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b'\u0010\"R\u000e\u0010(\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010*\u001a\u00020 2\u0006\u0010)\u001a\u00020 @BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\"\u0010-\u001a\u0004\u0018\u00010,2\b\u0010)\u001a\u0004\u0018\u00010,@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b.\u0010/RD\u00102\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b12\u0019\u0010)\u001a\u0015\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b1@BX\u0084\u000e¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u000e\u00105\u001a\u000206X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000208X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\u0002088VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b<\u0010=R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\"\u0010A\u001a\u0004\u0018\u00010@2\b\u0010)\u001a\u0004\u0018\u00010@@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\bB\u0010CR$\u0010E\u001a\u00020\f2\u0006\u0010D\u001a\u00020\f8P@PX\u0090\u000e¢\u0006\f\u001a\u0004\bF\u0010G\"\u0004\bH\u0010IR\u001a\u0010J\u001a\u00020K8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bL\u0010MR\u001c\u0010N\u001a\u0010\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020Q\u0018\u00010OX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010R\u001a\u0004\u0018\u00010\u00018VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bS\u0010\u0015R\u0013\u0010T\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\bU\u0010\u0018R\u0016\u0010V\u001a\u0004\u0018\u00010W8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0013\u0010Z\u001a\u0004\u0018\u00010\u00038F¢\u0006\u0006\u001a\u0004\b[\u0010\u0018R/\u0010]\u001a\u00020\\2\u0006\u0010)\u001a\u00020\\@TX\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010a\u001a\u0004\b^\u0010M\"\u0004\b_\u0010`R\u001a\u0010b\u001a\b\u0012\u0004\u0012\u00020P0c8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0014\u0010f\u001a\u00020\u000e8DX\u0084\u0004¢\u0006\u0006\u001a\u0004\bg\u0010hR\u001a\u0010i\u001a\u00020j8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bk\u0010MR\u0014\u0010l\u001a\u00020m8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bn\u0010oR\u0012\u0010p\u001a\u00020qX¦\u0004¢\u0006\u0006\u001a\u0004\br\u0010sR\u001c\u0010t\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bu\u0010v\"\u0004\bw\u0010xR\u001c\u0010y\u001a\u0004\u0018\u00010\u0000X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bz\u0010v\"\u0004\b{\u0010xR$\u0010|\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u001a@DX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b}\u0010\u001c\"\u0004\b~\u0010\u007f\u0082\u0002\u0016\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!\n\u0005\b\u009920\u0001¨\u0006\u0090\u0002"}, m287d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "alignmentLinesOwner", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "child", "getChild", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "coordinates", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "density", "", "getDensity", "()F", "fontScale", "getFontScale", "hasMeasureResult", "", "getHasMeasureResult", "()Z", "invalidateParentLayer", "Lkotlin/Function0;", "isAttached", "isClipping", "isValid", "lastLayerAlpha", "<set-?>", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate$ui_release", "()Landroidx/compose/ui/node/LookaheadDelegate;", "value", "measureResult", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "minimumTouchTargetSize", "Landroidx/compose/ui/geometry/Size;", "getMinimumTouchTargetSize-NH-jbRc", "()J", "oldAlignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "", "parent", "getParent", "parentCoordinates", "getParentCoordinates", "parentData", "", "getParentData", "()Ljava/lang/Object;", "parentLayoutCoordinates", "getParentLayoutCoordinates", "Landroidx/compose/ui/unit/IntOffset;", "position", "getPosition-nOcc-ac", "setPosition--gyyYBs", "(J)V", "J", "providedAlignmentLines", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "rectCache", "getRectCache", "()Landroidx/compose/ui/geometry/MutableRect;", "size", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrapped", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "zIndex", "getZIndex", "setZIndex", "(F)V", "ancestorToLocal", "ancestor", "rect", "clipBounds", "Landroidx/compose/ui/geometry/Offset;", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "attach", "calculateMinimumTouchTargetPadding", "calculateMinimumTouchTargetPadding-E7KxVPU", "(J)J", "createLookaheadDelegate", "scope", "Landroidx/compose/ui/layout/LookaheadScope;", "detach", "distanceInMinimumTouchTarget", "pointerPosition", "distanceInMinimumTouchTarget-tz77jQw", "(JJ)F", "draw", "canvas", "drawBorder", "paint", "Landroidx/compose/ui/graphics/Paint;", "drawContainedDrawModifiers", "findCommonAncestor", Vo2MaxRecord.MeasurementMethod.OTHER, "findCommonAncestor$ui_release", "fromParentPosition", "fromParentPosition-MK-Hz9U", "fromParentRect", "bounds", "hasNode", "type", "Landroidx/compose/ui/node/NodeKind;", "hasNode-H91voCI", "(I)Z", "head", "T", "head-H91voCI", "(I)Ljava/lang/Object;", "headNode", "includeTail", "headUnchecked", "headUnchecked-H91voCI", "hitTest", "Landroidx/compose/ui/node/DelegatableNode;", "hitTestSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "isInLayer", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestChild", "hitTestChild-YqVAtuI", "invalidateLayer", "invoke", "isPointerInBounds", "isPointerInBounds-k-4lQ0M", "(J)Z", "isTransparent", "localBoundingBoxOf", "Landroidx/compose/ui/geometry/Rect;", "sourceCoordinates", "localPositionOf", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localToRoot", "relativeToLocal", "localToRoot-MK-Hz9U", "localToWindow", "localToWindow-MK-Hz9U", "offsetFromEdge", "offsetFromEdge-MK-Hz9U", "onInitialize", "onLayerBlockUpdated", "onLayoutModifierNodeChanged", "onMeasureResultChanged", "width", "height", "onMeasured", "onPlaced", "performDraw", "performingMeasure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "block", "performingMeasure-K40F9xA", "(JLkotlin/jvm/functions/Function0;)Landroidx/compose/ui/layout/Placeable;", "placeAt", "placeAt-f8xVGno", "(JFLkotlin/jvm/functions/Function1;)V", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "rectInParent", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "replace", "replace$ui_release", "shouldSharePointerInputWithSiblings", "toParentPosition", "toParentPosition-MK-Hz9U", "touchBoundsInRoot", "transformFrom", "matrix", "Landroidx/compose/ui/graphics/Matrix;", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFromAncestor", "transformFromAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformToAncestor-EL8BTi8", "updateLayerParameters", "updateLookaheadDelegate", "updateLookaheadScope", "updateLookaheadScope$ui_release", "visitNodes", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "mask", "windowToLocal", "relativeToWindow", "windowToLocal-MK-Hz9U", "withPositionTranslation", "withinLayerBounds", "withinLayerBounds-k-4lQ0M", "hit", "hit-1hIXUjU", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitNear", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "speculativeHit", "speculativeHit-JHbHoSQ", "toCoordinator", "Companion", "HitTestSource", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    private MeasureResult _measureResult;
    private MutableRect _rectCache;
    private final Function0<Unit> invalidateParentLayer;
    private boolean isClipping;
    private float lastLayerAlpha;
    private boolean lastLayerDrawingWasSkipped;
    private OwnedLayer layer;
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    private Density layerDensity;
    private LayoutDirection layerLayoutDirection;
    private LayerPositionalProperties layerPositionalProperties;
    private final LayoutNode layoutNode;
    private LookaheadDelegate lookaheadDelegate;
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position;
    private NodeCoordinator wrapped;
    private NodeCoordinator wrappedBy;
    private float zIndex;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayerParams$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator coordinator) {
            LayerPositionalProperties layerPositionalProperties;
            LayerPositionalProperties layerPositionalProperties2;
            LayerPositionalProperties layerPositionalProperties3;
            Intrinsics.checkNotNullParameter(coordinator, "coordinator");
            if (coordinator.isValid()) {
                layerPositionalProperties = coordinator.layerPositionalProperties;
                if (layerPositionalProperties == null) {
                    coordinator.updateLayerParameters();
                    return;
                }
                layerPositionalProperties2 = NodeCoordinator.tmpLayerPositionalProperties;
                layerPositionalProperties2.copyFrom(layerPositionalProperties);
                coordinator.updateLayerParameters();
                layerPositionalProperties3 = NodeCoordinator.tmpLayerPositionalProperties;
                if (!layerPositionalProperties3.hasSameValuesAs(layerPositionalProperties)) {
                    LayoutNode layoutNode = coordinator.getLayoutNode();
                    LayoutNodeLayoutDelegate layoutDelegate = layoutNode.getLayoutDelegate();
                    if (layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
                        if (layoutDelegate.getCoordinatesAccessedDuringPlacement()) {
                            LayoutNode.requestRelayout$ui_release$default(layoutNode, false, 1, null);
                        }
                        layoutDelegate.getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
                    }
                    Owner owner = layoutNode.getOwner();
                    if (owner != null) {
                        owner.requestOnPositionedCallback(layoutNode);
                    }
                }
            }
        }
    };
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = new Function1<NodeCoordinator, Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$onCommitAffectingLayer$1
        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(NodeCoordinator nodeCoordinator) {
            invoke2(nodeCoordinator);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(NodeCoordinator coordinator) {
            Intrinsics.checkNotNullParameter(coordinator, "coordinator");
            OwnedLayer layer = coordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
        }
    };
    private static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    private static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    private static final float[] tmpMatrix = Matrix.m2190constructorimpl$default(null, 1, null);
    private static final HitTestSource<PointerInputModifierNode> PointerInputSource = new HitTestSource<PointerInputModifierNode>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$PointerInputSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw, reason: not valid java name */
        public int mo3689entityTypeOLwlOKw() {
            return Nodes.INSTANCE.m3712getPointerInputOLwlOKw();
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(PointerInputModifierNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return node.interceptOutOfBoundsChildEvents();
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            return true;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI, reason: not valid java name */
        public void mo3688childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult<PointerInputModifierNode> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m3621hitTestM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };
    private static final HitTestSource<SemanticsModifierNode> SemanticsSource = new HitTestSource<SemanticsModifierNode>() { // from class: androidx.compose.ui.node.NodeCoordinator$Companion$SemanticsSource$1
        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: entityType-OLwlOKw */
        public int mo3689entityTypeOLwlOKw() {
            return Nodes.INSTANCE.m3713getSemanticsOLwlOKw();
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean interceptOutOfBoundsChildEvents(SemanticsModifierNode node) {
            Intrinsics.checkNotNullParameter(node, "node");
            return false;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        public boolean shouldHitTestChildren(LayoutNode parentLayoutNode) {
            SemanticsConfiguration collapsedSemanticsConfiguration;
            Intrinsics.checkNotNullParameter(parentLayoutNode, "parentLayoutNode");
            SemanticsModifierNode outerSemantics = SemanticsNodeKt.getOuterSemantics(parentLayoutNode);
            boolean z = false;
            if (outerSemantics != null && (collapsedSemanticsConfiguration = SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics)) != null && collapsedSemanticsConfiguration.getIsClearingSemantics()) {
                z = true;
            }
            return !z;
        }

        @Override // androidx.compose.ui.node.NodeCoordinator.HitTestSource
        /* renamed from: childHitTest-YqVAtuI */
        public void mo3688childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult<SemanticsModifierNode> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
            Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
            Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
            layoutNode.m3622hitTestSemanticsM_7yMNQ$ui_release(pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        }
    };

    /* compiled from: NodeCoordinator.kt */
    @Metadata(m286d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H&ø\u0001\u0003\u0082\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, m287d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "N", "Landroidx/compose/ui/node/DelegatableNode;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public interface HitTestSource<N extends DelegatableNode> {
        /* renamed from: childHitTest-YqVAtuI */
        void mo3688childHitTestYqVAtuI(LayoutNode layoutNode, long pointerPosition, HitTestResult<N> hitTestResult, boolean isTouchEvent, boolean isInLayer);

        /* renamed from: entityType-OLwlOKw */
        int mo3689entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(N node);

        boolean shouldHitTestChildren(LayoutNode parentLayoutNode);
    }

    public abstract LookaheadDelegate createLookaheadDelegate(LookaheadScope scope);

    public abstract Modifier.Node getTail();

    public Object propagateRelocationRequest(Rect rect, Continuation<? super Unit> continuation) {
        return propagateRelocationRequest$suspendImpl(this, rect, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(Canvas canvas) {
        invoke2(canvas);
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable, androidx.compose.p000ui.node.MeasureScopeWithLayoutNode
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    public NodeCoordinator(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        this.lastLayerAlpha = 0.8f;
        this.position = IntOffset.INSTANCE.m4510getZeronOccac();
        this.invalidateParentLayer = new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invalidateParentLayer$1
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
                NodeCoordinator wrappedBy = NodeCoordinator.this.getWrappedBy();
                if (wrappedBy != null) {
                    wrappedBy.invalidateLayer();
                }
            }
        };
    }

    /* renamed from: getWrapped$ui_release, reason: from getter */
    public final NodeCoordinator getWrapped() {
        return this.wrapped;
    }

    public final void setWrapped$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    /* renamed from: getWrappedBy$ui_release, reason: from getter */
    public final NodeCoordinator getWrappedBy() {
        return this.wrappedBy;
    }

    public final void setWrappedBy$ui_release(NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    @Override // androidx.compose.p000ui.layout.IntrinsicMeasureScope
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @Override // androidx.compose.p000ui.unit.Density
    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    @Override // androidx.compose.p000ui.unit.Density
    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node headNode(boolean includeTail) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes().getHead();
        }
        if (includeTail) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null) {
                return null;
            }
            return tail.getChild();
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 != null) {
            return nodeCoordinator2.getTail();
        }
        return null;
    }

    public final void visitNodes(int mask, boolean includeTail, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        Modifier.Node stopNode = getTail();
        if (!includeTail && (stopNode = stopNode.getParent()) == null) {
            return;
        }
        for (Modifier.Node node = headNode(includeTail); node != null && (node.getAggregateChildKindSet() & mask) != 0; node = node.getChild()) {
            if ((node.getKindSet() & mask) != 0) {
                block.invoke(node);
            }
            if (node == stopNode) {
                return;
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ, reason: not valid java name */
    public final /* synthetic */ <T> void m3686visitNodesaLcG6gQ(int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        boolean includeTail$iv = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node stopNode$iv = getTail();
        if (includeTail$iv || (stopNode$iv = stopNode$iv.getParent()) != null) {
            for (Modifier.Node node$iv = headNode(includeTail$iv); node$iv != null && (node$iv.getAggregateChildKindSet() & type) != 0; node$iv = node$iv.getChild()) {
                if ((node$iv.getKindSet() & type) != 0) {
                    Modifier.Node it = node$iv;
                    Intrinsics.reifiedOperationMarker(3, "T");
                    if (it instanceof Object) {
                        block.invoke(it);
                    }
                }
                if (node$iv == stopNode$iv) {
                    return;
                }
            }
        }
    }

    /* renamed from: hasNode-H91voCI, reason: not valid java name */
    public final boolean m3678hasNodeH91voCI(int type) {
        Modifier.Node headNode = headNode(NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type));
        return headNode != null && DelegatableNodeKt.m3593has64DMado(headNode, type);
    }

    /* renamed from: head-H91voCI, reason: not valid java name */
    public final /* synthetic */ <T> T m3679headH91voCI(int type) {
        boolean m3701getIncludeSelfInTraversalH91voCI = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (m3701getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node headNode = headNode(m3701getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & type) != 0; headNode = headNode.getChild()) {
                if ((headNode.getKindSet() & type) != 0) {
                    Intrinsics.reifiedOperationMarker(2, "T");
                    return (T) headNode;
                }
                if (headNode == tail) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    /* renamed from: headUnchecked-H91voCI, reason: not valid java name */
    public final <T> T m3680headUncheckedH91voCI(int type) {
        boolean m3701getIncludeSelfInTraversalH91voCI = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type);
        Modifier.Node tail = getTail();
        if (m3701getIncludeSelfInTraversalH91voCI || (tail = tail.getParent()) != null) {
            for (Modifier.Node headNode = headNode(m3701getIncludeSelfInTraversalH91voCI); headNode != null && (headNode.getAggregateChildKindSet() & type) != 0; headNode = headNode.getChild()) {
                if ((headNode.getKindSet() & type) != 0) {
                    return (T) headNode;
                }
                if (headNode == tail) {
                    return null;
                }
            }
            return null;
        }
        return null;
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: getSize-YbymL2g */
    public final long mo3497getSizeYbymL2g() {
        return getMeasuredSize();
    }

    protected final Function1<GraphicsLayerScope, Unit> getLayerBlock() {
        return this.layerBlock;
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate().getAlignmentLinesOwner$ui_release();
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public void replace$ui_release() {
        mo3493placeAtf8xVGno(getPosition(), this.zIndex, this.layerBlock);
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public boolean isAttached() {
        return getTail().getIsAttached();
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    public void setMeasureResult$ui_release(MeasureResult value) {
        Intrinsics.checkNotNullParameter(value, "value");
        MeasureResult old = this._measureResult;
        if (value != old) {
            this._measureResult = value;
            if (old == null || value.getWidth() != old.getWidth() || value.getHeight() != old.getHeight()) {
                onMeasureResultChanged(value.getWidth(), value.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if ((!(map == null || map.isEmpty()) || !value.getAlignmentLines().isEmpty()) && !Intrinsics.areEqual(value.getAlignmentLines(), this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map it = this.oldAlignmentLines;
                if (it == null) {
                    it = new LinkedHashMap();
                    this.oldAlignmentLines = it;
                }
                it.clear();
                it.putAll(value.getAlignmentLines());
            }
        }
    }

    /* renamed from: getLookaheadDelegate$ui_release, reason: from getter */
    public final LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    public final void updateLookaheadScope$ui_release(LookaheadScope scope) {
        LookaheadDelegate lookaheadDelegate = null;
        if (scope != null) {
            LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
            if (!Intrinsics.areEqual(scope, lookaheadDelegate2 != null ? lookaheadDelegate2.getLookaheadScope() : null)) {
                lookaheadDelegate = createLookaheadDelegate(scope);
            } else {
                lookaheadDelegate = this.lookaheadDelegate;
            }
        }
        this.lookaheadDelegate = lookaheadDelegate;
    }

    protected final void updateLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate;
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Set set = null;
        for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrapped) {
            MeasureResult measureResult = coordinator._measureResult;
            Map alignmentLines = measureResult != null ? measureResult.getAlignmentLines() : null;
            boolean z = false;
            if (alignmentLines != null && (!alignmentLines.isEmpty())) {
                z = true;
            }
            if (z) {
                if (set == null) {
                    Set set2 = new LinkedHashSet();
                    set = set2;
                }
                set.addAll(alignmentLines.keySet());
            }
        }
        return set == null ? SetsKt.emptySet() : set;
    }

    protected void onMeasureResultChanged(int width, int height) {
        OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.mo3718resizeozmzZPI(IntSizeKt.IntSize(width, height));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
        m3538setMeasuredSizeozmzZPI(IntSizeKt.IntSize(width, height));
        int type$iv = Nodes.INSTANCE.m3705getDrawOLwlOKw();
        boolean includeTail$iv$iv = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type$iv);
        Modifier.Node stopNode$iv$iv = getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent()) != null) {
            for (Modifier.Node node$iv$iv = headNode(includeTail$iv$iv); node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet() & type$iv) != 0; node$iv$iv = node$iv$iv.getChild()) {
                if ((node$iv$iv.getKindSet() & type$iv) != 0) {
                    Object obj = node$iv$iv;
                    if (obj instanceof DrawModifierNode) {
                        DrawModifierNode it = (DrawModifierNode) obj;
                        it.onMeasureResultChanged();
                    }
                }
                if (node$iv$iv == stopNode$iv$iv) {
                    return;
                }
            }
        }
    }

    @Override // androidx.compose.p000ui.node.LookaheadCapablePlaceable
    /* renamed from: getPosition-nOcc-ac, reason: from getter */
    public long getPosition() {
        return this.position;
    }

    /* renamed from: setPosition--gyyYBs, reason: not valid java name */
    protected void m3684setPositiongyyYBs(long j) {
        this.position = j;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    protected final void setZIndex(float f) {
        this.zIndex = f;
    }

    /* JADX WARN: Type inference failed for: r9v5, types: [T, java.lang.Object] */
    @Override // androidx.compose.p000ui.layout.Measured, androidx.compose.p000ui.layout.IntrinsicMeasurable
    public Object getParentData() {
        Ref.ObjectRef data = new Ref.ObjectRef();
        Modifier.Node thisNode = getTail();
        Density $this$_get_parentData__u24lambda_u2d8 = getLayoutNode().getDensity();
        NodeChain this_$iv = getLayoutNode().getNodes();
        for (Modifier.Node node$iv = this_$iv.getTail(); node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            if (it != thisNode) {
                int kind$iv = Nodes.INSTANCE.m3711getParentDataOLwlOKw();
                if (((it.getKindSet() & kind$iv) != 0) && (it instanceof ParentDataModifierNode)) {
                    Modifier.Node $this$_get_parentData__u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6 = it;
                    data.element = ((ParentDataModifierNode) $this$_get_parentData__u24lambda_u2d8_u24lambda_u2d7_u24lambda_u2d6).modifyParentData($this$_get_parentData__u24lambda_u2d8, data.element);
                }
            }
        }
        return data.element;
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    protected final MutableRect getRectCache() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect == null) {
            MutableRect it = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
            this._rectCache = it;
            return it;
        }
        return mutableRect;
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* renamed from: performingMeasure-K40F9xA, reason: not valid java name */
    protected final Placeable m3683performingMeasureK40F9xA(long constraints, Function0<? extends Placeable> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        m3539setMeasurementConstraintsBRTryo0(constraints);
        Placeable result = block.invoke();
        OwnedLayer layer = getLayer();
        if (layer != null) {
            layer.mo3718resizeozmzZPI(getMeasuredSize());
        }
        return result;
    }

    public final void onMeasured() {
        Modifier.Node stopNode$iv$iv;
        Snapshot.Companion this_$iv;
        int type$iv;
        NodeCoordinator this_$iv2;
        if (m3678hasNodeH91voCI(Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw())) {
            Snapshot.Companion this_$iv3 = Snapshot.INSTANCE;
            Snapshot snapshot$iv = this_$iv3.createNonObservableSnapshot();
            try {
                Snapshot previous$iv$iv = snapshot$iv.makeCurrent();
                try {
                    try {
                        int type$iv2 = Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw();
                        NodeCoordinator this_$iv4 = this;
                        boolean includeTail$iv$iv = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type$iv2);
                        if (!includeTail$iv$iv) {
                            stopNode$iv$iv = this_$iv4.getTail().getParent();
                            if (stopNode$iv$iv == null) {
                                Unit unit = Unit.INSTANCE;
                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                snapshot$iv.dispose();
                            }
                        } else {
                            try {
                                stopNode$iv$iv = this_$iv4.getTail();
                            } catch (Throwable th) {
                                th = th;
                                snapshot$iv.restoreCurrent(previous$iv$iv);
                                throw th;
                            }
                        }
                        Modifier.Node node$iv$iv = this_$iv4.headNode(includeTail$iv$iv);
                        while (node$iv$iv != null) {
                            if ((node$iv$iv.getAggregateChildKindSet() & type$iv2) != 0) {
                                if ((node$iv$iv.getKindSet() & type$iv2) == 0) {
                                    this_$iv = this_$iv3;
                                    type$iv = type$iv2;
                                    this_$iv2 = this_$iv4;
                                } else {
                                    Object obj = node$iv$iv;
                                    this_$iv = this_$iv3;
                                    try {
                                        if (obj instanceof LayoutAwareModifierNode) {
                                            LayoutAwareModifierNode it = (LayoutAwareModifierNode) obj;
                                            type$iv = type$iv2;
                                            this_$iv2 = this_$iv4;
                                            it.mo3581onRemeasuredozmzZPI(getMeasuredSize());
                                        } else {
                                            type$iv = type$iv2;
                                            this_$iv2 = this_$iv4;
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        snapshot$iv.restoreCurrent(previous$iv$iv);
                                        throw th;
                                    }
                                }
                                if (node$iv$iv == stopNode$iv$iv) {
                                    break;
                                }
                                node$iv$iv = node$iv$iv.getChild();
                                this_$iv3 = this_$iv;
                                this_$iv4 = this_$iv2;
                                type$iv2 = type$iv;
                            } else {
                                break;
                            }
                        }
                        Unit unit2 = Unit.INSTANCE;
                        snapshot$iv.restoreCurrent(previous$iv$iv);
                        snapshot$iv.dispose();
                    } catch (Throwable th3) {
                        th = th3;
                        snapshot$iv.dispose();
                        throw th;
                    }
                } catch (Throwable th4) {
                    th = th4;
                }
            } catch (Throwable th5) {
                th = th5;
            }
        }
    }

    public final void onInitialize() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.compose.p000ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    public void mo3493placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        onLayerBlockUpdated(layerBlock);
        if (!IntOffset.m4499equalsimpl0(getPosition(), position)) {
            m3684setPositiongyyYBs(position);
            getLayoutNode().getLayoutDelegate().getMeasurePassDelegate().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer layer = this.layer;
            if (layer != null) {
                layer.mo3717movegyyYBs(position);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            invalidateAlignmentLinesFromPositionChange(this);
            Owner owner = getLayoutNode().getOwner();
            if (owner != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = zIndex;
    }

    public final void draw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.drawLayer(canvas);
            return;
        }
        float x = IntOffset.m4500getXimpl(getPosition());
        float y = IntOffset.m4501getYimpl(getPosition());
        canvas.translate(x, y);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-x, -y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        int type$iv = Nodes.INSTANCE.m3705getDrawOLwlOKw();
        boolean includeTail$iv$iv = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type$iv);
        Modifier.Node stopNode$iv$iv = getTail();
        if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent()) != null) {
            Modifier.Node node$iv$iv = headNode(includeTail$iv$iv);
            while (true) {
                if (node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet() & type$iv) != 0) {
                    if ((node$iv$iv.getKindSet() & type$iv) != 0) {
                        DrawModifierNode drawModifierNode = node$iv$iv;
                        r7 = drawModifierNode instanceof DrawModifierNode ? drawModifierNode : null;
                    } else if (node$iv$iv == stopNode$iv$iv) {
                        break;
                    } else {
                        node$iv$iv = node$iv$iv.getChild();
                    }
                } else {
                    break;
                }
            }
        }
        DrawModifierNode head = r7;
        if (head == null) {
            performDraw(canvas);
        } else {
            LayoutNodeDrawScope drawScope = getLayoutNode().getMDrawScope$ui_release();
            drawScope.m3631drawx_KDEd0$ui_release(canvas, IntSizeKt.m4552toSizeozmzZPI(mo3497getSizeYbymL2g()), this, head);
        }
    }

    public void performDraw(Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    public final void onPlaced() {
        LookaheadDelegate lookahead = this.lookaheadDelegate;
        if (lookahead != null) {
            int type$iv = Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw();
            boolean includeTail$iv$iv = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type$iv);
            Modifier.Node stopNode$iv$iv = getTail();
            if (includeTail$iv$iv || (stopNode$iv$iv = stopNode$iv$iv.getParent()) != null) {
                for (Modifier.Node node$iv$iv = headNode(includeTail$iv$iv); node$iv$iv != null && (node$iv$iv.getAggregateChildKindSet() & type$iv) != 0; node$iv$iv = node$iv$iv.getChild()) {
                    if ((node$iv$iv.getKindSet() & type$iv) != 0) {
                        Object obj = node$iv$iv;
                        if (obj instanceof LayoutAwareModifierNode) {
                            LayoutAwareModifierNode it = (LayoutAwareModifierNode) obj;
                            it.onLookaheadPlaced(lookahead.getLookaheadLayoutCoordinates());
                        }
                    }
                    if (node$iv$iv == stopNode$iv$iv) {
                        break;
                    }
                }
            }
        }
        int type$iv2 = Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw();
        boolean includeTail$iv$iv2 = NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(type$iv2);
        Modifier.Node stopNode$iv$iv2 = getTail();
        if (includeTail$iv$iv2 || (stopNode$iv$iv2 = stopNode$iv$iv2.getParent()) != null) {
            for (Modifier.Node node$iv$iv2 = headNode(includeTail$iv$iv2); node$iv$iv2 != null && (node$iv$iv2.getAggregateChildKindSet() & type$iv2) != 0; node$iv$iv2 = node$iv$iv2.getChild()) {
                if ((node$iv$iv2.getKindSet() & type$iv2) != 0) {
                    Object obj2 = node$iv$iv2;
                    if (obj2 instanceof LayoutAwareModifierNode) {
                        LayoutAwareModifierNode it2 = (LayoutAwareModifierNode) obj2;
                        it2.onPlaced(this);
                    }
                }
                if (node$iv$iv2 == stopNode$iv$iv2) {
                    return;
                }
            }
        }
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public void invoke2(final Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayoutNode().getIsPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$invoke$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                    NodeCoordinator.this.drawContainedDrawModifiers(canvas);
                }
            });
            this.lastLayerDrawingWasSkipped = false;
        } else {
            this.lastLayerDrawingWasSkipped = true;
        }
    }

    public final void onLayerBlockUpdated(Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        Owner owner;
        boolean layerInvalidated = (this.layerBlock == layerBlock && Intrinsics.areEqual(this.layerDensity, getLayoutNode().getDensity()) && this.layerLayoutDirection == getLayoutNode().getLayoutDirection()) ? false : true;
        this.layerBlock = layerBlock;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        if (isAttached() && layerBlock != null) {
            if (this.layer == null) {
                OwnedLayer $this$onLayerBlockUpdated_u24lambda_u2d16 = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this, this.invalidateParentLayer);
                $this$onLayerBlockUpdated_u24lambda_u2d16.mo3718resizeozmzZPI(getMeasuredSize());
                $this$onLayerBlockUpdated_u24lambda_u2d16.mo3717movegyyYBs(getPosition());
                this.layer = $this$onLayerBlockUpdated_u24lambda_u2d16;
                updateLayerParameters();
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                return;
            }
            if (layerInvalidated) {
                updateLayerParameters();
                return;
            }
            return;
        }
        OwnedLayer it = this.layer;
        if (it != null) {
            it.destroy();
            getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
            if (isAttached() && (owner = getLayoutNode().getOwner()) != null) {
                owner.onLayoutChange(getLayoutNode());
            }
        }
        this.layer = null;
        this.lastLayerDrawingWasSkipped = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateLayerParameters() {
        OwnedLayer layer = this.layer;
        if (layer == null) {
            if (!(this.layerBlock == null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else {
            final Function1 layerBlock = this.layerBlock;
            if (layerBlock == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            graphicsLayerScope.reset();
            graphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$updateLayerParameters$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    ReusableGraphicsLayerScope reusableGraphicsLayerScope;
                    Function1<GraphicsLayerScope, Unit> function1 = layerBlock;
                    reusableGraphicsLayerScope = NodeCoordinator.graphicsLayerScope;
                    function1.invoke(reusableGraphicsLayerScope);
                }
            });
            LayerPositionalProperties it = this.layerPositionalProperties;
            if (it == null) {
                it = new LayerPositionalProperties();
                this.layerPositionalProperties = it;
            }
            LayerPositionalProperties layerPositionalProperties = it;
            layerPositionalProperties.copyFrom(graphicsLayerScope);
            layer.mo3720updateLayerPropertiesNHXXZp8(graphicsLayerScope.getScaleX(), graphicsLayerScope.getScaleY(), graphicsLayerScope.getAlpha(), graphicsLayerScope.getTranslationX(), graphicsLayerScope.getTranslationY(), graphicsLayerScope.getShadowElevation(), graphicsLayerScope.getRotationX(), graphicsLayerScope.getRotationY(), graphicsLayerScope.getRotationZ(), graphicsLayerScope.getCameraDistance(), graphicsLayerScope.getTransformOrigin(), graphicsLayerScope.getShape(), graphicsLayerScope.getClip(), graphicsLayerScope.getRenderEffect(), graphicsLayerScope.getAmbientShadowColor(), graphicsLayerScope.getSpotShadowColor(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
            this.isClipping = graphicsLayerScope.getClip();
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner = getLayoutNode().getOwner();
        if (owner != null) {
            owner.onLayoutChange(getLayoutNode());
        }
    }

    /* renamed from: getLastLayerDrawingWasSkipped$ui_release, reason: from getter */
    public final boolean getLastLayerDrawingWasSkipped() {
        return this.lastLayerDrawingWasSkipped;
    }

    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @Override // androidx.compose.p000ui.node.OwnerScope
    public boolean isValid() {
        return this.layer != null && isAttached();
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc, reason: not valid java name */
    public final long m3677getMinimumTouchTargetSizeNHjbRc() {
        Density $this$getMinimumTouchTargetSize_NH_jbRc_u24lambda_u2d19 = this.layerDensity;
        return $this$getMinimumTouchTargetSize_NH_jbRc_u24lambda_u2d19.mo649toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().mo3625getMinimumTouchTargetSizeMYxV2XQ());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: hitTest-YqVAtuI, reason: not valid java name */
    public final <T extends DelegatableNode> void m3681hitTestYqVAtuI(HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        DelegatableNode head = (DelegatableNode) m3680headUncheckedH91voCI(hitTestSource.mo3689entityTypeOLwlOKw());
        if (!m3687withinLayerBoundsk4lQ0M(pointerPosition)) {
            if (isTouchEvent) {
                float distanceFromEdge = m3675distanceInMinimumTouchTargettz77jQw(pointerPosition, m3677getMinimumTouchTargetSizeNHjbRc());
                if (((Float.isInfinite(distanceFromEdge) || Float.isNaN(distanceFromEdge)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(distanceFromEdge, false)) {
                    m3669hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, false, distanceFromEdge);
                    return;
                }
                return;
            }
            return;
        }
        if (head == null) {
            mo3615hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        if (m3682isPointerInBoundsk4lQ0M(pointerPosition)) {
            m3668hit1hIXUjU(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
            return;
        }
        float distanceFromEdge2 = !isTouchEvent ? Float.POSITIVE_INFINITY : m3675distanceInMinimumTouchTargettz77jQw(pointerPosition, m3677getMinimumTouchTargetSizeNHjbRc());
        if (((Float.isInfinite(distanceFromEdge2) || Float.isNaN(distanceFromEdge2)) ? false : true) && hitTestResult.isHitInMinimumTouchTargetBetter(distanceFromEdge2, isInLayer)) {
            m3669hitNearJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
        } else {
            m3671speculativeHitJHbHoSQ(head, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU, reason: not valid java name */
    public final <T extends DelegatableNode> void m3668hit1hIXUjU(final T t, final HitTestSource<T> hitTestSource, final long pointerPosition, final HitTestResult<T> hitTestResult, final boolean isTouchEvent, final boolean isInLayer) {
        if (t == null) {
            mo3615hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else {
            hitTestResult.hit(t, isInLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hit$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/NodeCoordinator;TT;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource<TT;>;JLandroidx/compose/ui/node/HitTestResult<TT;>;ZZ)V */
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
                    Object m3691nextUncheckedUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m3691nextUncheckedUntilhw7D004 = NodeCoordinatorKt.m3691nextUncheckedUntilhw7D004(t, hitTestSource.mo3689entityTypeOLwlOKw(), Nodes.INSTANCE.m3708getLayoutOLwlOKw());
                    nodeCoordinator.m3668hit1hIXUjU((DelegatableNode) m3691nextUncheckedUntilhw7D004, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ, reason: not valid java name */
    public final <T extends DelegatableNode> void m3669hitNearJHbHoSQ(final T t, final HitTestSource<T> hitTestSource, final long pointerPosition, final HitTestResult<T> hitTestResult, final boolean isTouchEvent, final boolean isInLayer, final float distanceFromEdge) {
        if (t == null) {
            mo3615hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
        } else {
            hitTestResult.hitInMinimumTouchTarget(t, distanceFromEdge, isInLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$hitNear$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/NodeCoordinator;TT;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource<TT;>;JLandroidx/compose/ui/node/HitTestResult<TT;>;ZZF)V */
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
                    Object m3691nextUncheckedUntilhw7D004;
                    NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                    m3691nextUncheckedUntilhw7D004 = NodeCoordinatorKt.m3691nextUncheckedUntilhw7D004(t, hitTestSource.mo3689entityTypeOLwlOKw(), Nodes.INSTANCE.m3708getLayoutOLwlOKw());
                    nodeCoordinator.m3669hitNearJHbHoSQ((DelegatableNode) m3691nextUncheckedUntilhw7D004, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: speculativeHit-JHbHoSQ, reason: not valid java name */
    public final <T extends DelegatableNode> void m3671speculativeHitJHbHoSQ(final T t, final HitTestSource<T> hitTestSource, final long pointerPosition, final HitTestResult<T> hitTestResult, final boolean isTouchEvent, final boolean isInLayer, final float distanceFromEdge) {
        Object m3691nextUncheckedUntilhw7D004;
        if (t != null) {
            if (!hitTestSource.interceptOutOfBoundsChildEvents(t)) {
                m3691nextUncheckedUntilhw7D004 = NodeCoordinatorKt.m3691nextUncheckedUntilhw7D004(t, hitTestSource.mo3689entityTypeOLwlOKw(), Nodes.INSTANCE.m3708getLayoutOLwlOKw());
                m3671speculativeHitJHbHoSQ((DelegatableNode) m3691nextUncheckedUntilhw7D004, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
                return;
            } else {
                hitTestResult.speculativeHit(t, distanceFromEdge, isInLayer, new Function0<Unit>() { // from class: androidx.compose.ui.node.NodeCoordinator$speculativeHit$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Incorrect types in method signature: (Landroidx/compose/ui/node/NodeCoordinator;TT;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource<TT;>;JLandroidx/compose/ui/node/HitTestResult<TT;>;ZZF)V */
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
                        Object m3691nextUncheckedUntilhw7D0042;
                        NodeCoordinator nodeCoordinator = NodeCoordinator.this;
                        m3691nextUncheckedUntilhw7D0042 = NodeCoordinatorKt.m3691nextUncheckedUntilhw7D004(t, hitTestSource.mo3689entityTypeOLwlOKw(), Nodes.INSTANCE.m3708getLayoutOLwlOKw());
                        nodeCoordinator.m3671speculativeHitJHbHoSQ((DelegatableNode) m3691nextUncheckedUntilhw7D0042, hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer, distanceFromEdge);
                    }
                });
                return;
            }
        }
        mo3615hitTestChildYqVAtuI(hitTestSource, pointerPosition, hitTestResult, isTouchEvent, isInLayer);
    }

    /* renamed from: hitTestChild-YqVAtuI */
    public <T extends DelegatableNode> void mo3615hitTestChildYqVAtuI(HitTestSource<T> hitTestSource, long pointerPosition, HitTestResult<T> hitTestResult, boolean isTouchEvent, boolean isInLayer) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator wrapped = this.wrapped;
        if (wrapped != null) {
            long positionInWrapped = wrapped.m3676fromParentPositionMKHz9U(pointerPosition);
            wrapped.m3681hitTestYqVAtuI(hitTestSource, positionInWrapped, hitTestResult, isTouchEvent, isInLayer);
        }
    }

    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.INSTANCE.getZero();
        }
        LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect bounds = getRectCache();
        long padding = m3674calculateMinimumTouchTargetPaddingE7KxVPU(m3677getMinimumTouchTargetSizeNHjbRc());
        bounds.setLeft(-Size.m1829getWidthimpl(padding));
        bounds.setTop(-Size.m1826getHeightimpl(padding));
        bounds.setRight(getMeasuredWidth() + Size.m1829getWidthimpl(padding));
        bounds.setBottom(getMeasuredHeight() + Size.m1826getHeightimpl(padding));
        NodeCoordinator coordinator = this;
        while (coordinator != root) {
            coordinator.rectInParent$ui_release(bounds, false, true);
            if (bounds.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            coordinator = nodeCoordinator;
        }
        return MutableRectKt.toRect(bounds);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: windowToLocal-MK-Hz9U */
    public long mo3502windowToLocalMKHz9U(long relativeToWindow) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        LayoutCoordinates root = LayoutCoordinatesKt.findRootCoordinates(this);
        long positionInRoot = Offset.m1764minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).mo3721calculateLocalPositionMKHz9U(relativeToWindow), LayoutCoordinatesKt.positionInRoot(root));
        return mo3498localPositionOfR5De75A(root, positionInRoot);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: localToWindow-MK-Hz9U */
    public long mo3500localToWindowMKHz9U(long relativeToLocal) {
        long positionInRoot = mo3499localToRootMKHz9U(relativeToLocal);
        Owner owner = LayoutNodeKt.requireOwner(getLayoutNode());
        return owner.mo3722calculatePositionInWindowMKHz9U(positionInRoot);
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates $this$toCoordinator) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = $this$toCoordinator instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) $this$toCoordinator : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull($this$toCoordinator, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) $this$toCoordinator;
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: localPositionOf-R5De75A */
    public long mo3498localPositionOfR5De75A(LayoutCoordinates sourceCoordinates, long relativeToSource) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        NodeCoordinator nodeCoordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(nodeCoordinator);
        long position = relativeToSource;
        NodeCoordinator coordinator = nodeCoordinator;
        while (coordinator != commonAncestor) {
            position = coordinator.m3685toParentPositionMKHz9U(position);
            NodeCoordinator nodeCoordinator2 = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            coordinator = nodeCoordinator2;
        }
        return m3667ancestorToLocalR5De75A(commonAncestor, position);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: transformFrom-EL8BTi8 */
    public void mo3501transformFromEL8BTi8(LayoutCoordinates sourceCoordinates, float[] matrix) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(matrix, "matrix");
        NodeCoordinator coordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(coordinator);
        Matrix.m2199resetimpl(matrix);
        coordinator.m3673transformToAncestorEL8BTi8(commonAncestor, matrix);
        m3672transformFromAncestorEL8BTi8(commonAncestor, matrix);
    }

    /* renamed from: transformToAncestor-EL8BTi8, reason: not valid java name */
    private final void m3673transformToAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        NodeCoordinator wrapper = this;
        while (!Intrinsics.areEqual(wrapper, ancestor)) {
            OwnedLayer ownedLayer = wrapper.layer;
            if (ownedLayer != null) {
                ownedLayer.mo3719transform58bKbWc(matrix);
            }
            long position = wrapper.getPosition();
            if (!IntOffset.m4499equalsimpl0(position, IntOffset.INSTANCE.m4510getZeronOccac())) {
                Matrix.m2199resetimpl(tmpMatrix);
                Matrix.m2210translateimpl$default(tmpMatrix, IntOffset.m4500getXimpl(position), IntOffset.m4501getYimpl(position), 0.0f, 4, null);
                Matrix.m2207timesAssign58bKbWc(matrix, tmpMatrix);
            }
            NodeCoordinator nodeCoordinator = wrapper.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            wrapper = nodeCoordinator;
        }
    }

    /* renamed from: transformFromAncestor-EL8BTi8, reason: not valid java name */
    private final void m3672transformFromAncestorEL8BTi8(NodeCoordinator ancestor, float[] matrix) {
        if (!Intrinsics.areEqual(ancestor, this)) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            nodeCoordinator.m3672transformFromAncestorEL8BTi8(ancestor, matrix);
            if (!IntOffset.m4499equalsimpl0(getPosition(), IntOffset.INSTANCE.m4510getZeronOccac())) {
                Matrix.m2199resetimpl(tmpMatrix);
                Matrix.m2210translateimpl$default(tmpMatrix, -IntOffset.m4500getXimpl(getPosition()), -IntOffset.m4501getYimpl(getPosition()), 0.0f, 4, null);
                Matrix.m2207timesAssign58bKbWc(matrix, tmpMatrix);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.mo3714inverseTransform58bKbWc(matrix);
            }
        }
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    public Rect localBoundingBoxOf(LayoutCoordinates sourceCoordinates, boolean clipBounds) {
        Intrinsics.checkNotNullParameter(sourceCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        if (!sourceCoordinates.isAttached()) {
            throw new IllegalStateException(("LayoutCoordinates " + sourceCoordinates + " is not attached!").toString());
        }
        NodeCoordinator srcCoordinator = toCoordinator(sourceCoordinates);
        NodeCoordinator commonAncestor = findCommonAncestor$ui_release(srcCoordinator);
        MutableRect bounds = getRectCache();
        bounds.setLeft(0.0f);
        bounds.setTop(0.0f);
        bounds.setRight(IntSize.m4542getWidthimpl(sourceCoordinates.mo3497getSizeYbymL2g()));
        bounds.setBottom(IntSize.m4541getHeightimpl(sourceCoordinates.mo3497getSizeYbymL2g()));
        NodeCoordinator coordinator = srcCoordinator;
        while (coordinator != commonAncestor) {
            rectInParent$ui_release$default(coordinator, bounds, clipBounds, false, 4, null);
            if (bounds.isEmpty()) {
                return Rect.INSTANCE.getZero();
            }
            NodeCoordinator nodeCoordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
            coordinator = nodeCoordinator;
        }
        ancestorToLocal(commonAncestor, bounds, clipBounds);
        return MutableRectKt.toRect(bounds);
    }

    /* renamed from: ancestorToLocal-R5De75A, reason: not valid java name */
    private final long m3667ancestorToLocalR5De75A(NodeCoordinator ancestor, long offset) {
        if (ancestor == this) {
            return offset;
        }
        NodeCoordinator wrappedBy = this.wrappedBy;
        if (wrappedBy == null || Intrinsics.areEqual(ancestor, wrappedBy)) {
            return m3676fromParentPositionMKHz9U(offset);
        }
        return m3676fromParentPositionMKHz9U(wrappedBy.m3667ancestorToLocalR5De75A(ancestor, offset));
    }

    private final void ancestorToLocal(NodeCoordinator ancestor, MutableRect rect, boolean clipBounds) {
        if (ancestor == this) {
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.ancestorToLocal(ancestor, rect, clipBounds);
        }
        fromParentRect(rect, clipBounds);
    }

    @Override // androidx.compose.p000ui.layout.LayoutCoordinates
    /* renamed from: localToRoot-MK-Hz9U */
    public long mo3499localToRootMKHz9U(long relativeToLocal) {
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        }
        long position = relativeToLocal;
        for (NodeCoordinator coordinator = this; coordinator != null; coordinator = coordinator.wrappedBy) {
            position = coordinator.m3685toParentPositionMKHz9U(position);
        }
        return position;
    }

    protected final void withPositionTranslation(Canvas canvas, Function1<? super Canvas, Unit> block) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(block, "block");
        float x = IntOffset.m4500getXimpl(getPosition());
        float y = IntOffset.m4501getYimpl(getPosition());
        canvas.translate(x, y);
        block.invoke(canvas);
        canvas.translate(-x, -y);
    }

    /* renamed from: toParentPosition-MK-Hz9U, reason: not valid java name */
    public long m3685toParentPositionMKHz9U(long position) {
        OwnedLayer layer = this.layer;
        long targetPosition = layer != null ? layer.mo3716mapOffset8S9VItk(position, false) : position;
        return IntOffsetKt.m4514plusNvtHpc(targetPosition, getPosition());
    }

    /* renamed from: fromParentPosition-MK-Hz9U, reason: not valid java name */
    public long m3676fromParentPositionMKHz9U(long position) {
        long relativeToPosition = IntOffsetKt.m4512minusNvtHpc(position, getPosition());
        OwnedLayer layer = this.layer;
        return layer != null ? layer.mo3716mapOffset8S9VItk(relativeToPosition, true) : relativeToPosition;
    }

    protected final void drawBorder(Canvas canvas, Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        Rect rect = new Rect(0.5f, 0.5f, IntSize.m4542getWidthimpl(getMeasuredSize()) - 0.5f, IntSize.m4541getHeightimpl(getMeasuredSize()) - 0.5f);
        canvas.drawRect(rect, paint);
    }

    public void attach() {
        onLayerBlockUpdated(this.layerBlock);
    }

    public void detach() {
        onLayerBlockUpdated(this.layerBlock);
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z, boolean z2, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        nodeCoordinator.rectInParent$ui_release(mutableRect, z, z2);
    }

    public final void rectInParent$ui_release(MutableRect bounds, boolean clipBounds, boolean clipToMinimumTouchTargetSize) {
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        OwnedLayer layer = this.layer;
        if (layer != null) {
            if (this.isClipping) {
                if (clipToMinimumTouchTargetSize) {
                    long minTouch = m3677getMinimumTouchTargetSizeNHjbRc();
                    float horz = Size.m1829getWidthimpl(minTouch) / 2.0f;
                    float vert = Size.m1826getHeightimpl(minTouch) / 2.0f;
                    bounds.intersect(-horz, -vert, IntSize.m4542getWidthimpl(mo3497getSizeYbymL2g()) + horz, IntSize.m4541getHeightimpl(mo3497getSizeYbymL2g()) + vert);
                } else if (clipBounds) {
                    bounds.intersect(0.0f, 0.0f, IntSize.m4542getWidthimpl(mo3497getSizeYbymL2g()), IntSize.m4541getHeightimpl(mo3497getSizeYbymL2g()));
                }
                if (bounds.isEmpty()) {
                    return;
                }
            }
            layer.mapBounds(bounds, false);
        }
        int x = IntOffset.m4500getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() + x);
        bounds.setRight(bounds.getRight() + x);
        int y = IntOffset.m4501getYimpl(getPosition());
        bounds.setTop(bounds.getTop() + y);
        bounds.setBottom(bounds.getBottom() + y);
    }

    private final void fromParentRect(MutableRect bounds, boolean clipBounds) {
        int x = IntOffset.m4500getXimpl(getPosition());
        bounds.setLeft(bounds.getLeft() - x);
        bounds.setRight(bounds.getRight() - x);
        int y = IntOffset.m4501getYimpl(getPosition());
        bounds.setTop(bounds.getTop() - y);
        bounds.setBottom(bounds.getBottom() - y);
        OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.mapBounds(bounds, true);
            if (this.isClipping && clipBounds) {
                bounds.intersect(0.0f, 0.0f, IntSize.m4542getWidthimpl(mo3497getSizeYbymL2g()), IntSize.m4541getHeightimpl(mo3497getSizeYbymL2g()));
                if (bounds.isEmpty()) {
                }
            }
        }
    }

    /* renamed from: withinLayerBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3687withinLayerBoundsk4lQ0M(long pointerPosition) {
        if (!OffsetKt.m1777isFinitek4lQ0M(pointerPosition)) {
            return false;
        }
        OwnedLayer layer = this.layer;
        return layer == null || !this.isClipping || layer.mo3715isInLayerk4lQ0M(pointerPosition);
    }

    /* renamed from: isPointerInBounds-k-4lQ0M, reason: not valid java name */
    protected final boolean m3682isPointerInBoundsk4lQ0M(long pointerPosition) {
        float x = Offset.m1760getXimpl(pointerPosition);
        float y = Offset.m1761getYimpl(pointerPosition);
        return x >= 0.0f && y >= 0.0f && x < ((float) getMeasuredWidth()) && y < ((float) getMeasuredHeight());
    }

    public void invalidateLayer() {
        OwnedLayer layer = this.layer;
        if (layer != null) {
            layer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    static /* synthetic */ Object propagateRelocationRequest$suspendImpl(NodeCoordinator $this, Rect rect, Continuation $completion) {
        NodeCoordinator parent = $this.wrappedBy;
        if (parent == null) {
            return Unit.INSTANCE;
        }
        Rect boundingBoxInParentCoordinates = parent.localBoundingBoxOf($this, false);
        Rect rectInParentBounds = rect.m1797translatek4lQ0M(boundingBoxInParentCoordinates.m1795getTopLeftF1C5BW0());
        Object propagateRelocationRequest = parent.propagateRelocationRequest(rectInParentBounds, $completion);
        return propagateRelocationRequest == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? propagateRelocationRequest : Unit.INSTANCE;
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final NodeCoordinator findCommonAncestor$ui_release(NodeCoordinator other) {
        Intrinsics.checkNotNullParameter(other, "other");
        LayoutNode ancestor1 = other.getLayoutNode();
        LayoutNode ancestor2 = getLayoutNode();
        if (ancestor1 == ancestor2) {
            Modifier.Node otherNode = other.getTail();
            DelegatableNode $this$visitLocalParents$iv = getTail();
            int mask$iv = Nodes.INSTANCE.m3708getLayoutOLwlOKw();
            if (!$this$visitLocalParents$iv.getNode().getIsAttached()) {
                throw new IllegalStateException("Check failed.".toString());
            }
            for (Modifier.Node next$iv = $this$visitLocalParents$iv.getNode().getParent(); next$iv != null; next$iv = next$iv.getParent()) {
                if ((next$iv.getKindSet() & mask$iv) != 0) {
                    Modifier.Node it = next$iv;
                    if (it == otherNode) {
                        return other;
                    }
                }
            }
            return this;
        }
        while (ancestor1.getDepth() > ancestor2.getDepth()) {
            LayoutNode parent$ui_release = ancestor1.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release);
            ancestor1 = parent$ui_release;
        }
        while (ancestor2.getDepth() > ancestor1.getDepth()) {
            LayoutNode parent$ui_release2 = ancestor2.getParent$ui_release();
            Intrinsics.checkNotNull(parent$ui_release2);
            ancestor2 = parent$ui_release2;
        }
        while (ancestor1 != ancestor2) {
            LayoutNode parent1 = ancestor1.getParent$ui_release();
            LayoutNode parent2 = ancestor2.getParent$ui_release();
            if (parent1 == null || parent2 == null) {
                throw new IllegalArgumentException("layouts are not part of the same hierarchy");
            }
            ancestor1 = parent1;
            ancestor2 = parent2;
        }
        return ancestor2 == getLayoutNode() ? this : ancestor1 == other.getLayoutNode() ? other : ancestor1.getInnerCoordinator$ui_release();
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        DelegatableNode start = headNode(NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(Nodes.INSTANCE.m3712getPointerInputOLwlOKw()));
        if (start == null) {
            return false;
        }
        DelegatableNode $this$visitLocalChildren_u2d6rFNWt0$iv = start;
        int type$iv = Nodes.INSTANCE.m3712getPointerInputOLwlOKw();
        if (!$this$visitLocalChildren_u2d6rFNWt0$iv.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node self$iv$iv = $this$visitLocalChildren_u2d6rFNWt0$iv.getNode();
        if ((self$iv$iv.getAggregateChildKindSet() & type$iv) != 0) {
            for (Modifier.Node next$iv$iv = self$iv$iv.getChild(); next$iv$iv != null; next$iv$iv = next$iv$iv.getChild()) {
                if ((next$iv$iv.getKindSet() & type$iv) != 0) {
                    Object obj = next$iv$iv;
                    if (obj instanceof PointerInputModifierNode) {
                        PointerInputModifierNode it = (PointerInputModifierNode) obj;
                        if (it.sharePointerInputWithSiblings()) {
                            return true;
                        }
                    } else {
                        continue;
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U, reason: not valid java name */
    private final long m3670offsetFromEdgeMKHz9U(long pointerPosition) {
        float x = Offset.m1760getXimpl(pointerPosition);
        float horizontal = Math.max(0.0f, x < 0.0f ? -x : x - getMeasuredWidth());
        float y = Offset.m1761getYimpl(pointerPosition);
        float vertical = Math.max(0.0f, y < 0.0f ? -y : y - getMeasuredHeight());
        return OffsetKt.Offset(horizontal, vertical);
    }

    /* renamed from: calculateMinimumTouchTargetPadding-E7KxVPU, reason: not valid java name */
    protected final long m3674calculateMinimumTouchTargetPaddingE7KxVPU(long minimumTouchTargetSize) {
        float widthDiff = Size.m1829getWidthimpl(minimumTouchTargetSize) - getMeasuredWidth();
        float heightDiff = Size.m1826getHeightimpl(minimumTouchTargetSize) - getMeasuredHeight();
        return SizeKt.Size(Math.max(0.0f, widthDiff / 2.0f), Math.max(0.0f, heightDiff / 2.0f));
    }

    /* renamed from: distanceInMinimumTouchTarget-tz77jQw, reason: not valid java name */
    protected final float m3675distanceInMinimumTouchTargettz77jQw(long pointerPosition, long minimumTouchTargetSize) {
        if (getMeasuredWidth() >= Size.m1829getWidthimpl(minimumTouchTargetSize) && getMeasuredHeight() >= Size.m1826getHeightimpl(minimumTouchTargetSize)) {
            return Float.POSITIVE_INFINITY;
        }
        long m3674calculateMinimumTouchTargetPaddingE7KxVPU = m3674calculateMinimumTouchTargetPaddingE7KxVPU(minimumTouchTargetSize);
        float width = Size.m1829getWidthimpl(m3674calculateMinimumTouchTargetPaddingE7KxVPU);
        float height = Size.m1826getHeightimpl(m3674calculateMinimumTouchTargetPaddingE7KxVPU);
        long offsetFromEdge = m3670offsetFromEdgeMKHz9U(pointerPosition);
        if ((width > 0.0f || height > 0.0f) && Offset.m1760getXimpl(offsetFromEdge) <= width && Offset.m1761getYimpl(offsetFromEdge) <= height) {
            return Offset.m1759getDistanceSquaredimpl(offsetFromEdge);
        }
        return Float.POSITIVE_INFINITY;
    }

    /* compiled from: NodeCoordinator.kt */
    @Metadata(m286d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0080\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0019X\u0082\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001a\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, m287d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInputSource$annotations", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPointerInputSource$annotations() {
        }

        private Companion() {
        }

        public final HitTestSource<PointerInputModifierNode> getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        public final HitTestSource<SemanticsModifierNode> getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }
}
