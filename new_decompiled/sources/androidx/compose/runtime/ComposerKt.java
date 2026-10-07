package androidx.compose.runtime;

import androidx.autofill.HintConstants;
import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Composer.kt */
@Metadata(m286d1 = {"\u0000ä\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0010\u001a\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0000\u001ai\u0010D\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H2\u0012\u0010I\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030K0J2&\u0010L\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`HH\u0003¢\u0006\u0002\u0010M\u001a(\u0010N\u001a\u0004\u0018\u00010\u00012\b\u0010O\u001a\u0004\u0018\u00010\u00012\b\u0010P\u001a\u0004\u0018\u00010\u00012\b\u0010Q\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\b\u0010R\u001a\u00020SH\u0007\u001aP\u0010T\u001a>\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010XH\u0002\u001a\u0010\u0010[\u001a\u00020\u00172\u0006\u0010O\u001a\u00020SH\u0000\u001a\"\u0010[\u001a\u00020\u00172\u0006\u0010O\u001a\u00020S2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010]H\u0080\bø\u0001\u0000\u001a\u0018\u0010^\u001a\u00020\u00172\u0006\u0010_\u001a\u00020`2\u0006\u0010^\u001a\u00020CH\u0007\u001a\u0010\u0010a\u001a\u00020\u00172\u0006\u0010_\u001a\u00020`H\u0007\u001a \u0010b\u001a\u00020\u00172\u0006\u0010_\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010^\u001a\u00020CH\u0007\u001a\b\u0010d\u001a\u00020\u0017H\u0007\u001a(\u0010e\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u00072\u0006\u0010h\u001a\u00020CH\u0007\u001a\u0018\u0010e\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00072\u0006\u0010h\u001a\u00020CH\u0007\u001a\f\u0010i\u001a\u00020S*\u00020\u0007H\u0002\u001a\f\u0010j\u001a\u00020\u0007*\u00020SH\u0002\u001a6\u0010k\u001a\u0002Hl\"\u0004\b\u0000\u0010l*\u00020`2\u0006\u0010m\u001a\u00020S2\u0011\u0010n\u001a\r\u0012\u0004\u0012\u0002Hl0]¢\u0006\u0002\boH\u0087\bø\u0001\u0000¢\u0006\u0002\u0010p\u001a\u001c\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010r*\u00020s2\u0006\u0010t\u001a\u00020uH\u0002\u001a@\u0010v\u001a\u00020S\"\u0004\b\u0000\u0010l*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Hl0FH\u0000\u001a\u001c\u0010w\u001a\u00020\u0007*\u00020x2\u0006\u0010y\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\u0007H\u0002\u001a(\u0010{\u001a\b\u0012\u0004\u0012\u00020}0|*\b\u0012\u0004\u0012\u00020}0|2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\u0080\u0001\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\u0082\u0001\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0002\u001a%\u0010\u0083\u0001\u001a\u0004\u0018\u00010}*\b\u0012\u0004\u0012\u00020}0|2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u0007H\u0002\u001aG\u0010\u0084\u0001\u001a\u0002Hl\"\u0004\b\u0000\u0010l*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Hl0FH\u0000¢\u0006\u0003\u0010\u0085\u0001\u001a1\u0010\u0086\u0001\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0081\u0001\u001a\u00020\u00072\b\u0010\u0087\u0001\u001a\u00030\u0088\u00012\t\u0010\u0089\u0001\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0084\u0001\u0010\u008a\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H21\u0010\u008b\u0001\u001a,\u0012!\u0012\u001f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0\u008d\u0001\u0012\u0004\u0012\u00020\u00170\u008c\u0001H\u0080\bø\u0001\u0000\u001a(\u0010\u008e\u0001\u001a\u00020\u0007*\u00020x2\u0007\u0010\u008f\u0001\u001a\u00020\u00072\u0007\u0010\u0090\u0001\u001a\u00020\u00072\u0007\u0010\u0091\u0001\u001a\u00020\u0007H\u0002\u001a[\u0010\u0092\u0001\u001a\u0004\u0018\u0001HX\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010X*4\u0012\u0004\u0012\u0002HV\u0012\n\u0012\b\u0012\u0004\u0012\u0002HX0W0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z2\u0006\u0010c\u001a\u0002HVH\u0002¢\u0006\u0003\u0010\u0093\u0001\u001aa\u0010\u0094\u0001\u001a\u00020S\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010X*4\u0012\u0004\u0012\u0002HV\u0012\n\u0012\b\u0012\u0004\u0012\u0002HX0W0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z2\u0006\u0010c\u001a\u0002HV2\u0006\u0010O\u001a\u0002HXH\u0002¢\u0006\u0003\u0010\u0095\u0001\u001ac\u0010\u0096\u0001\u001a\u0004\u0018\u00010\u0017\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010X*4\u0012\u0004\u0012\u0002HV\u0012\n\u0012\b\u0012\u0004\u0012\u0002HX0W0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z2\u0006\u0010c\u001a\u0002HV2\u0006\u0010O\u001a\u0002HXH\u0002¢\u0006\u0003\u0010\u0097\u0001\u001a\u0015\u0010\u0098\u0001\u001a\u00020\u0017*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u001a\u001e\u0010\u0099\u0001\u001a\u0004\u0018\u00010}*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0081\u0001\u001a\u00020\u0007H\u0002\u001a#\u0010\u009a\u0001\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020}0|2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u007f\u001a\u00020\u0007H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u000e\u0010\f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"[\u0010\r\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010\u001a\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0016\u0010\u001d\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0003\"\u000e\u0010\u001f\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u001c\u0010!\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0005\"\u0016\u0010$\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0003\"\u001c\u0010&\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\u0005\"\u0016\u0010)\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u0003\"\u001c\u0010+\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\u0005\"\u0016\u0010.\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b/\u0010\u0003\"\u001c\u00100\u001a\u00020\u00018\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u0005\"\u0016\u00103\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b4\u0010\u0003\"[\u00105\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"[\u00106\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0016\u00107\u001a\u00020\u00078\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b8\u0010\u0003\"\u000e\u00109\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"[\u0010:\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"[\u0010;\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010<\u001a\u00020\u0001*\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?*\u009f\u0001\b\u0000\u0010\u009b\u0001\"K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e2K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e*E\b\u0000\u0010\u009c\u0001\"\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0E2\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0E\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u009d\u0001"}, m287d2 = {"compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "endGroupInstance", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Lkotlin/ParameterName;", HintConstants.AUTOFILL_HINT_NAME, "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "nodeKeyReplace", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "removeCurrentGroupInstance", "resetSlotsInstance", "reuseKey", "getReuseKey$annotations", "rootKey", "skipToGroupEndInstance", "startRootGroup", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeRuntimeError", "", "message", "", "compositionLocalMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "getKey", "value", "left", "right", "isTraceInProgress", "", "multiMap", "Ljava/util/HashMap;", "K", "Ljava/util/LinkedHashSet;", "V", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "runtimeCheck", "lazyMessage", "Lkotlin/Function0;", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", "T", "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "contains", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "index", "root", "filterToRange", "", "Landroidx/compose/runtime/Invalidation;", "start", "end", "findInsertLocation", "location", "findLocation", "firstInRange", "getValueOf", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "mutate", "mutator", "Lkotlin/Function1;", "", "nearestCommonRootOf", "a", "b", "common", "pop", "(Ljava/util/HashMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Unit;", "removeCurrentGroup", "removeLocation", "removeRange", "Change", "CompositionLocalMap", "runtime_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ComposerKt {
    public static final int compositionLocalMapKey = 202;
    private static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final int nodeKeyReplace = 126;
    public static final int providerKey = 201;
    public static final int providerMapsKey = 204;
    public static final int providerValuesKey = 203;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> removeCurrentGroupInstance = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerKt$removeCurrentGroupInstance$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
            ComposerKt.removeCurrentGroup(slots, rememberManager);
        }
    };
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> skipToGroupEndInstance = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerKt$skipToGroupEndInstance$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
            slots.skipToGroupEnd();
        }
    };
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> endGroupInstance = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerKt$endGroupInstance$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
            slots.endGroup();
        }
    };
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> startRootGroup = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerKt$startRootGroup$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
            slots.ensureStarted(0);
        }
    };
    private static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> resetSlotsInstance = new Function3<Applier<?>, SlotWriter, RememberManager, Unit>() { // from class: androidx.compose.runtime.ComposerKt$resetSlotsInstance$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(Applier<?> applier, SlotWriter slotWriter, RememberManager rememberManager) {
            invoke2(applier, slotWriter, rememberManager);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Applier<?> applier, SlotWriter slots, RememberManager rememberManager) {
            Intrinsics.checkNotNullParameter(applier, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(slots, "slots");
            Intrinsics.checkNotNullParameter(rememberManager, "<anonymous parameter 2>");
            slots.reset();
        }
    };
    private static final Object invocation = new OpaqueKey("provider");
    private static final Object provider = new OpaqueKey("provider");
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    private static final Object providerValues = new OpaqueKey("providerValues");
    private static final Object providerMaps = new OpaqueKey("providers");
    private static final Object reference = new OpaqueKey("reference");

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    public static final PersistentMap<CompositionLocal<Object>, State<Object>> mutate(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Function1<? super Map<CompositionLocal<Object>, State<Object>>, Unit> mutator) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        mutator.invoke(builder);
        return builder.build();
    }

    public static final <T> boolean contains(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        return persistentMap.containsKey(key);
    }

    public static final <T> T getValueOf(PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, CompositionLocal<T> key) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        State state = (State) persistentMap.get(key);
        if (state != null) {
            return (T) state.getValue();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocalMapOf(ProvidedValue<?>[] providedValueArr, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Composer $composer, int $changed) {
        ProvidedValue[] providedValueArr2 = providedValueArr;
        $composer.startReplaceableGroup(721128344);
        sourceInformation($composer, "C(compositionLocalMapOf)P(1):Composer.kt#9igjgp");
        if (isTraceInProgress()) {
            traceEventStart(721128344, $changed, -1, "androidx.compose.runtime.compositionLocalMapOf (Composer.kt:307)");
        }
        PersistentMap result = ExtensionsKt.persistentHashMapOf();
        PersistentMap.Builder builder = result.builder();
        PersistentMap.Builder it = builder;
        int length = providedValueArr2.length;
        int i = 0;
        while (i < length) {
            ProvidedValue provided = providedValueArr2[i];
            $composer.startReplaceableGroup(680852989);
            sourceInformation($composer, "*317@11596L24");
            if (!provided.getCanOverride() && contains(persistentMap, provided.getCompositionLocal())) {
                $composer.endReplaceableGroup();
                i++;
                providedValueArr2 = providedValueArr;
            }
            CompositionLocal<?> compositionLocal = provided.getCompositionLocal();
            Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
            it.put(compositionLocal, provided.getCompositionLocal().provided$runtime_release(provided.getValue(), $composer, 72));
            $composer.endReplaceableGroup();
            i++;
            providedValueArr2 = providedValueArr;
        }
        PersistentMap<CompositionLocal<Object>, State<Object>> build = builder.build();
        if (isTraceInProgress()) {
            traceEventEnd();
        }
        $composer.endReplaceableGroup();
        return build;
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer composer, boolean z, Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter(composer, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        T t = (T) composer.rememberedValue();
        if (z || t == Composer.INSTANCE.getEmpty()) {
            T invoke = block.invoke();
            composer.updateRememberedValue(invoke);
            return invoke;
        }
        return t;
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer composer, String sourceInformation) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        composer.sourceInformation(sourceInformation);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer composer, int key, String sourceInformation) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(sourceInformation, "sourceInformation");
        composer.sourceInformationMarkerStart(key, sourceInformation);
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer it = compositionTracer;
        return it != null && it.isTraceInProgress();
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload with $dirty metadata instead", replaceWith = @ReplaceWith(expression = "traceEventStart(key, dirty1, dirty2, info)", imports = {}))
    @ComposeCompilerApi
    public static final /* synthetic */ void traceEventStart(int key, String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        traceEventStart(key, -1, -1, info);
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int key, int dirty1, int dirty2, String info) {
        Intrinsics.checkNotNullParameter(info, "info");
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(key, dirty1, dirty2, info);
        }
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
        }
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        composer.sourceInformationMarkerEnd();
    }

    public static final void removeCurrentGroup(SlotWriter $this$removeCurrentGroup, RememberManager rememberManager) {
        CompositionImpl composition;
        Intrinsics.checkNotNullParameter($this$removeCurrentGroup, "<this>");
        Intrinsics.checkNotNullParameter(rememberManager, "rememberManager");
        Iterator<Object> groupSlots = $this$removeCurrentGroup.groupSlots();
        while (groupSlots.hasNext()) {
            Object slot = groupSlots.next();
            if (slot instanceof RememberObserver) {
                rememberManager.forgetting((RememberObserver) slot);
            } else if ((slot instanceof RecomposeScopeImpl) && (composition = ((RecomposeScopeImpl) slot).getComposition()) != null) {
                composition.setPendingInvalidScopes$runtime_release(true);
                ((RecomposeScopeImpl) slot).release();
            }
        }
        $this$removeCurrentGroup.removeGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> HashMap<K, LinkedHashSet<V>> multiMap() {
        return new HashMap<>();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> boolean put(HashMap<K, LinkedHashSet<V>> hashMap, K k, V v) {
        LinkedHashSet<V> linkedHashSet;
        HashMap<K, LinkedHashSet<V>> $this$getOrPut$iv = hashMap;
        LinkedHashSet<V> linkedHashSet2 = $this$getOrPut$iv.get(k);
        if (linkedHashSet2 == null) {
            linkedHashSet = new LinkedHashSet<>();
            $this$getOrPut$iv.put(k, linkedHashSet);
        } else {
            linkedHashSet = linkedHashSet2;
        }
        return linkedHashSet.add(v);
    }

    private static final <K, V> Unit remove(HashMap<K, LinkedHashSet<V>> hashMap, K k, V v) {
        LinkedHashSet it = hashMap.get(k);
        if (it == null) {
            return null;
        }
        it.remove(v);
        if (it.isEmpty()) {
            hashMap.remove(k);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> V pop(HashMap<K, LinkedHashSet<V>> hashMap, K k) {
        V v;
        LinkedHashSet<V> linkedHashSet = hashMap.get(k);
        if (linkedHashSet == null || (v = (V) CollectionsKt.firstOrNull(linkedHashSet)) == null) {
            return null;
        }
        remove(hashMap, k, v);
        return v;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getKey(Object value, Object left, Object right) {
        Object key;
        JoinedKey it = value instanceof JoinedKey ? (JoinedKey) value : null;
        if (it == null) {
            return null;
        }
        if (Intrinsics.areEqual(it.getLeft(), left) && Intrinsics.areEqual(it.getRight(), right)) {
            key = value;
        } else {
            key = getKey(it.getLeft(), left, right);
            if (key == null) {
                key = getKey(it.getRight(), left, right);
            }
        }
        return key;
    }

    private static final int findLocation(List<Invalidation> list, int location) {
        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            Invalidation midVal = list.get(mid);
            int cmp = Intrinsics.compare(midVal.getLocation(), location);
            if (cmp < 0) {
                low = mid + 1;
            } else {
                if (cmp <= 0) {
                    return mid;
                }
                high = mid - 1;
            }
        }
        return -(low + 1);
    }

    private static final int findInsertLocation(List<Invalidation> list, int location) {
        int it = findLocation(list, location);
        return it < 0 ? -(it + 1) : it;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int location, RecomposeScopeImpl scope, Object instance) {
        int index = findLocation(list, location);
        IdentityArraySet identityArraySet = null;
        if (index < 0) {
            int i = -(index + 1);
            if (instance != null) {
                IdentityArraySet it = new IdentityArraySet();
                it.add(instance);
                identityArraySet = it;
            }
            list.add(i, new Invalidation(scope, location, identityArraySet));
            return;
        }
        if (instance == null) {
            list.get(index).setInstances(null);
            return;
        }
        IdentityArraySet<Object> instances = list.get(index).getInstances();
        if (instances != null) {
            instances.add(instance);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int start, int end) {
        int index = findInsertLocation(list, start);
        if (index < list.size()) {
            Invalidation firstInvalidation = list.get(index);
            if (firstInvalidation.getLocation() < end) {
                return firstInvalidation;
            }
            return null;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int location) {
        int index = findLocation(list, location);
        if (index >= 0) {
            return list.remove(index);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int start, int end) {
        int index = findInsertLocation(list, start);
        while (index < list.size()) {
            Invalidation validation = list.get(index);
            if (validation.getLocation() >= end) {
                return;
            } else {
                list.remove(index);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Invalidation> filterToRange(List<Invalidation> list, int start, int end) {
        List result = new ArrayList();
        for (int index = findInsertLocation(list, start); index < list.size(); index++) {
            Invalidation invalidation = list.get(index);
            if (invalidation.getLocation() >= end) {
                break;
            }
            result.add(invalidation);
        }
        return result;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int $this$asBool) {
        return $this$asBool != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable $this$collectNodesFrom, Anchor anchor) {
        List result = new ArrayList();
        SlotReader reader$iv = $this$collectNodesFrom.openReader();
        try {
            int index = $this$collectNodesFrom.anchorIndex(anchor);
            m1628collectNodesFrom$lambda10$collectFromGroup(reader$iv, result, index);
            Unit unit = Unit.INSTANCE;
            return result;
        } finally {
            reader$iv.close();
        }
    }

    /* renamed from: collectNodesFrom$lambda-10$collectFromGroup, reason: not valid java name */
    private static final void m1628collectNodesFrom$lambda10$collectFromGroup(SlotReader $reader, List<Object> list, int group) {
        if ($reader.isNode(group)) {
            list.add($reader.node(group));
            return;
        }
        int current = group + 1;
        int end = $reader.groupSize(group) + group;
        while (current < end) {
            m1628collectNodesFrom$lambda10$collectFromGroup($reader, list, current);
            current += $reader.groupSize(current);
        }
    }

    private static final int distanceFrom(SlotReader $this$distanceFrom, int index, int root) {
        int count = 0;
        int current = index;
        while (current > 0 && current != root) {
            current = $this$distanceFrom.parent(current);
            count++;
        }
        return count;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader $this$nearestCommonRootOf, int a, int b, int common) {
        if (a == b) {
            return a;
        }
        if (a == common || b == common) {
            return common;
        }
        if ($this$nearestCommonRootOf.parent(a) == b) {
            return b;
        }
        if ($this$nearestCommonRootOf.parent(b) == a) {
            return a;
        }
        if ($this$nearestCommonRootOf.parent(a) == $this$nearestCommonRootOf.parent(b)) {
            return $this$nearestCommonRootOf.parent(a);
        }
        int currentA = a;
        int currentB = b;
        int aDistance = distanceFrom($this$nearestCommonRootOf, a, common);
        int bDistance = distanceFrom($this$nearestCommonRootOf, b, common);
        int i = aDistance - bDistance;
        for (int i2 = 0; i2 < i; i2++) {
            currentA = $this$nearestCommonRootOf.parent(currentA);
        }
        int i3 = bDistance - aDistance;
        for (int i4 = 0; i4 < i3; i4++) {
            currentB = $this$nearestCommonRootOf.parent(currentB);
        }
        while (currentA != currentB) {
            currentA = $this$nearestCommonRootOf.parent(currentA);
            currentB = $this$nearestCommonRootOf.parent(currentB);
        }
        return currentA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo $this$joinedKey) {
        return $this$joinedKey.getObjectKey() != null ? new JoinedKey(Integer.valueOf($this$joinedKey.getKey()), $this$joinedKey.getObjectKey()) : Integer.valueOf($this$joinedKey.getKey());
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getReference() {
        return reference;
    }

    public static final void runtimeCheck(boolean value, Function0<? extends Object> lazyMessage) {
        Intrinsics.checkNotNullParameter(lazyMessage, "lazyMessage");
        if (!value) {
            Object message = lazyMessage.invoke();
            composeRuntimeError(message.toString());
            throw new KotlinNothingValueException();
        }
    }

    public static final void runtimeCheck(boolean value) {
        if (value) {
            return;
        }
        composeRuntimeError("Check failed".toString());
        throw new KotlinNothingValueException();
    }

    public static final Void composeRuntimeError(String message) {
        Intrinsics.checkNotNullParameter(message, "message");
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + message + "). Please report to Google or use https://goo.gle/compose-feedback");
    }
}
