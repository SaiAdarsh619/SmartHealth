package androidx.compose.p000ui.input.nestedscroll;

import androidx.compose.p000ui.geometry.Offset;
import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ModifierLocalReadScope;
import androidx.compose.p000ui.modifier.ProvidableModifierLocal;
import androidx.compose.p000ui.unit.Velocity;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: NestedScrollModifierLocal.kt */
@Metadata(m286d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\u00022\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J)\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b&\u0010'J-\u0010(\u001a\u00020)2\u0006\u0010$\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010-J!\u0010.\u001a\u00020#2\u0006\u0010%\u001a\u00020#H\u0096@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0001¢\u0006\u0004\b/\u00100J%\u00101\u001a\u00020)2\u0006\u0010%\u001a\u00020)2\u0006\u0010*\u001a\u00020+H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b2\u00103R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00000\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R/\u0010\u0015\u001a\u0004\u0018\u00010\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u00008B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001c\u001a\u00020\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00064"}, m287d2 = {"Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "dispatcher", "Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "connection", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;)V", "getConnection", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "getDispatcher", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollDispatcher;", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "nestedCoroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getNestedCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "parent", "getParent", "()Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;", "setParent", "(Landroidx/compose/ui/input/nestedscroll/NestedScrollModifierLocal;)V", "parent$delegate", "Landroidx/compose/runtime/MutableState;", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NestedScrollModifierLocal implements ModifierLocalConsumer, ModifierLocalProvider<NestedScrollModifierLocal>, NestedScrollConnection {
    private final NestedScrollConnection connection;
    private final NestedScrollDispatcher dispatcher;

    /* renamed from: parent$delegate, reason: from kotlin metadata */
    private final MutableState parent;

    public NestedScrollModifierLocal(NestedScrollDispatcher dispatcher, NestedScrollConnection connection) {
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(connection, "connection");
        this.dispatcher = dispatcher;
        this.connection = connection;
        this.dispatcher.setCalculateNestedScrollScope$ui_release(new Function0<CoroutineScope>() { // from class: androidx.compose.ui.input.nestedscroll.NestedScrollModifierLocal.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final CoroutineScope invoke() {
                return NestedScrollModifierLocal.this.getNestedCoroutineScope();
            }
        });
        this.parent = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
    }

    public final NestedScrollDispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final NestedScrollConnection getConnection() {
        return this.connection;
    }

    private final NestedScrollModifierLocal getParent() {
        State $this$getValue$iv = this.parent;
        return (NestedScrollModifierLocal) $this$getValue$iv.getValue();
    }

    private final void setParent(NestedScrollModifierLocal nestedScrollModifierLocal) {
        MutableState $this$setValue$iv = this.parent;
        $this$setValue$iv.setValue(nestedScrollModifierLocal);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CoroutineScope getNestedCoroutineScope() {
        CoroutineScope originNestedScrollScope;
        NestedScrollModifierLocal parent = getParent();
        if ((parent == null || (originNestedScrollScope = parent.getNestedCoroutineScope()) == null) && (originNestedScrollScope = this.dispatcher.getOriginNestedScrollScope()) == null) {
            throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
        }
        return originNestedScrollScope;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public ProvidableModifierLocal<NestedScrollModifierLocal> getKey() {
        return NestedScrollModifierLocalKt.getModifierLocalNestedScroll();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // androidx.compose.p000ui.modifier.ModifierLocalProvider
    public NestedScrollModifierLocal getValue() {
        return this;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(ModifierLocalReadScope scope) {
        Intrinsics.checkNotNullParameter(scope, "scope");
        setParent((NestedScrollModifierLocal) scope.getCurrent(NestedScrollModifierLocalKt.getModifierLocalNestedScroll()));
        this.dispatcher.setParent$ui_release(getParent());
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreScroll-OzD1aCk */
    public long mo656onPreScrollOzD1aCk(long available, int source) {
        NestedScrollModifierLocal parent = getParent();
        long parentPreConsumed = parent != null ? parent.mo656onPreScrollOzD1aCk(available, source) : Offset.INSTANCE.m1776getZeroF1C5BW0();
        long selfPreConsumed = this.connection.mo656onPreScrollOzD1aCk(Offset.m1764minusMKHz9U(available, parentPreConsumed), source);
        return Offset.m1765plusMKHz9U(parentPreConsumed, selfPreConsumed);
    }

    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostScroll-DzOQY0M */
    public long mo655onPostScrollDzOQY0M(long consumed, long available, int source) {
        long selfConsumed = this.connection.mo655onPostScrollDzOQY0M(consumed, available, source);
        NestedScrollModifierLocal parent = getParent();
        long parentConsumed = parent != null ? parent.mo655onPostScrollDzOQY0M(Offset.m1765plusMKHz9U(consumed, selfConsumed), Offset.m1764minusMKHz9U(available, selfConsumed), source) : Offset.INSTANCE.m1776getZeroF1C5BW0();
        return Offset.m1765plusMKHz9U(selfConsumed, parentConsumed);
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x002e  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0041  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo821onPreFlingQWom1Mo(long parentPreConsumed, Continuation<? super Velocity> continuation) {
        NestedScrollModifierLocal$onPreFling$1 nestedScrollModifierLocal$onPreFling$1;
        NestedScrollModifierLocal$onPreFling$1 nestedScrollModifierLocal$onPreFling$12;
        NestedScrollModifierLocal nestedScrollModifierLocal;
        long parentPreConsumed2;
        Object mo821onPreFlingQWom1Mo;
        Object mo821onPreFlingQWom1Mo2;
        if (continuation instanceof NestedScrollModifierLocal$onPreFling$1) {
            nestedScrollModifierLocal$onPreFling$1 = (NestedScrollModifierLocal$onPreFling$1) continuation;
            if ((nestedScrollModifierLocal$onPreFling$1.label & Integer.MIN_VALUE) != 0) {
                nestedScrollModifierLocal$onPreFling$1.label -= Integer.MIN_VALUE;
                nestedScrollModifierLocal$onPreFling$12 = nestedScrollModifierLocal$onPreFling$1;
                Object $result = nestedScrollModifierLocal$onPreFling$12.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (nestedScrollModifierLocal$onPreFling$12.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        nestedScrollModifierLocal = this;
                        NestedScrollModifierLocal parent = nestedScrollModifierLocal.getParent();
                        if (parent == null) {
                            parentPreConsumed2 = Velocity.INSTANCE.m4618getZero9UxMQ8M();
                            NestedScrollConnection nestedScrollConnection = nestedScrollModifierLocal.connection;
                            long m4610minusAH228Gc = Velocity.m4610minusAH228Gc(parentPreConsumed, parentPreConsumed2);
                            nestedScrollModifierLocal$onPreFling$12.L$0 = null;
                            nestedScrollModifierLocal$onPreFling$12.J$0 = parentPreConsumed2;
                            nestedScrollModifierLocal$onPreFling$12.label = 2;
                            mo821onPreFlingQWom1Mo2 = nestedScrollConnection.mo821onPreFlingQWom1Mo(m4610minusAH228Gc, nestedScrollModifierLocal$onPreFling$12);
                            if (mo821onPreFlingQWom1Mo2 == coroutine_suspended) {
                            }
                            long selfPreConsumed = ((Velocity) mo821onPreFlingQWom1Mo2).getPackedValue();
                            return Velocity.m4598boximpl(Velocity.m4611plusAH228Gc(parentPreConsumed2, selfPreConsumed));
                        }
                        nestedScrollModifierLocal$onPreFling$12.L$0 = nestedScrollModifierLocal;
                        nestedScrollModifierLocal$onPreFling$12.J$0 = parentPreConsumed;
                        nestedScrollModifierLocal$onPreFling$12.label = 1;
                        mo821onPreFlingQWom1Mo = parent.mo821onPreFlingQWom1Mo(parentPreConsumed, nestedScrollModifierLocal$onPreFling$12);
                        if (mo821onPreFlingQWom1Mo == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        parentPreConsumed2 = ((Velocity) mo821onPreFlingQWom1Mo).getPackedValue();
                        NestedScrollConnection nestedScrollConnection2 = nestedScrollModifierLocal.connection;
                        long m4610minusAH228Gc2 = Velocity.m4610minusAH228Gc(parentPreConsumed, parentPreConsumed2);
                        nestedScrollModifierLocal$onPreFling$12.L$0 = null;
                        nestedScrollModifierLocal$onPreFling$12.J$0 = parentPreConsumed2;
                        nestedScrollModifierLocal$onPreFling$12.label = 2;
                        mo821onPreFlingQWom1Mo2 = nestedScrollConnection2.mo821onPreFlingQWom1Mo(m4610minusAH228Gc2, nestedScrollModifierLocal$onPreFling$12);
                        if (mo821onPreFlingQWom1Mo2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        long selfPreConsumed2 = ((Velocity) mo821onPreFlingQWom1Mo2).getPackedValue();
                        return Velocity.m4598boximpl(Velocity.m4611plusAH228Gc(parentPreConsumed2, selfPreConsumed2));
                    case 1:
                        parentPreConsumed = nestedScrollModifierLocal$onPreFling$12.J$0;
                        nestedScrollModifierLocal = (NestedScrollModifierLocal) nestedScrollModifierLocal$onPreFling$12.L$0;
                        ResultKt.throwOnFailure($result);
                        mo821onPreFlingQWom1Mo = $result;
                        parentPreConsumed2 = ((Velocity) mo821onPreFlingQWom1Mo).getPackedValue();
                        NestedScrollConnection nestedScrollConnection22 = nestedScrollModifierLocal.connection;
                        long m4610minusAH228Gc22 = Velocity.m4610minusAH228Gc(parentPreConsumed, parentPreConsumed2);
                        nestedScrollModifierLocal$onPreFling$12.L$0 = null;
                        nestedScrollModifierLocal$onPreFling$12.J$0 = parentPreConsumed2;
                        nestedScrollModifierLocal$onPreFling$12.label = 2;
                        mo821onPreFlingQWom1Mo2 = nestedScrollConnection22.mo821onPreFlingQWom1Mo(m4610minusAH228Gc22, nestedScrollModifierLocal$onPreFling$12);
                        if (mo821onPreFlingQWom1Mo2 == coroutine_suspended) {
                        }
                        long selfPreConsumed22 = ((Velocity) mo821onPreFlingQWom1Mo2).getPackedValue();
                        return Velocity.m4598boximpl(Velocity.m4611plusAH228Gc(parentPreConsumed2, selfPreConsumed22));
                    case 2:
                        long parentPreConsumed3 = nestedScrollModifierLocal$onPreFling$12.J$0;
                        ResultKt.throwOnFailure($result);
                        parentPreConsumed2 = parentPreConsumed3;
                        mo821onPreFlingQWom1Mo2 = $result;
                        long selfPreConsumed222 = ((Velocity) mo821onPreFlingQWom1Mo2).getPackedValue();
                        return Velocity.m4598boximpl(Velocity.m4611plusAH228Gc(parentPreConsumed2, selfPreConsumed222));
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        nestedScrollModifierLocal$onPreFling$1 = new NestedScrollModifierLocal$onPreFling$1(this, continuation);
        nestedScrollModifierLocal$onPreFling$12 = nestedScrollModifierLocal$onPreFling$1;
        Object $result2 = nestedScrollModifierLocal$onPreFling$12.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nestedScrollModifierLocal$onPreFling$12.label) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x003e  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0078  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x009d  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x002c  */
    @Override // androidx.compose.p000ui.input.nestedscroll.NestedScrollConnection
    /* renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo654onPostFlingRZ2iAVY(long j, long j2, Continuation<? super Velocity> continuation) {
        NestedScrollModifierLocal$onPostFling$1 nestedScrollModifierLocal$onPostFling$1;
        long consumed;
        long available;
        Object mo654onPostFlingRZ2iAVY;
        NestedScrollModifierLocal nestedScrollModifierLocal;
        NestedScrollModifierLocal parent;
        long selfConsumed;
        long parentConsumed;
        Object mo654onPostFlingRZ2iAVY2;
        if (continuation instanceof NestedScrollModifierLocal$onPostFling$1) {
            NestedScrollModifierLocal$onPostFling$1 nestedScrollModifierLocal$onPostFling$12 = (NestedScrollModifierLocal$onPostFling$1) continuation;
            if ((nestedScrollModifierLocal$onPostFling$12.label & Integer.MIN_VALUE) != 0) {
                nestedScrollModifierLocal$onPostFling$12.label -= Integer.MIN_VALUE;
                nestedScrollModifierLocal$onPostFling$1 = nestedScrollModifierLocal$onPostFling$12;
                Object $result = nestedScrollModifierLocal$onPostFling$1.result;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                switch (nestedScrollModifierLocal$onPostFling$1.label) {
                    case 0:
                        ResultKt.throwOnFailure($result);
                        consumed = j;
                        available = j2;
                        NestedScrollConnection nestedScrollConnection = this.connection;
                        nestedScrollModifierLocal$onPostFling$1.L$0 = this;
                        nestedScrollModifierLocal$onPostFling$1.J$0 = consumed;
                        nestedScrollModifierLocal$onPostFling$1.J$1 = available;
                        nestedScrollModifierLocal$onPostFling$1.label = 1;
                        mo654onPostFlingRZ2iAVY = nestedScrollConnection.mo654onPostFlingRZ2iAVY(consumed, available, nestedScrollModifierLocal$onPostFling$1);
                        if (mo654onPostFlingRZ2iAVY == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        nestedScrollModifierLocal = this;
                        long selfConsumed2 = ((Velocity) mo654onPostFlingRZ2iAVY).getPackedValue();
                        parent = nestedScrollModifierLocal.getParent();
                        if (parent != null) {
                            selfConsumed = selfConsumed2;
                            parentConsumed = Velocity.INSTANCE.m4618getZero9UxMQ8M();
                            return Velocity.m4598boximpl(Velocity.m4611plusAH228Gc(selfConsumed, parentConsumed));
                        }
                        long m4611plusAH228Gc = Velocity.m4611plusAH228Gc(consumed, selfConsumed2);
                        long m4610minusAH228Gc = Velocity.m4610minusAH228Gc(available, selfConsumed2);
                        nestedScrollModifierLocal$onPostFling$1.L$0 = null;
                        nestedScrollModifierLocal$onPostFling$1.J$0 = selfConsumed2;
                        nestedScrollModifierLocal$onPostFling$1.label = 2;
                        selfConsumed = selfConsumed2;
                        mo654onPostFlingRZ2iAVY2 = parent.mo654onPostFlingRZ2iAVY(m4611plusAH228Gc, m4610minusAH228Gc, nestedScrollModifierLocal$onPostFling$1);
                        if (mo654onPostFlingRZ2iAVY2 == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        parentConsumed = ((Velocity) mo654onPostFlingRZ2iAVY2).getPackedValue();
                        return Velocity.m4598boximpl(Velocity.m4611plusAH228Gc(selfConsumed, parentConsumed));
                    case 1:
                        long selfConsumed3 = nestedScrollModifierLocal$onPostFling$1.J$1;
                        long consumed2 = nestedScrollModifierLocal$onPostFling$1.J$0;
                        nestedScrollModifierLocal = (NestedScrollModifierLocal) nestedScrollModifierLocal$onPostFling$1.L$0;
                        ResultKt.throwOnFailure($result);
                        available = selfConsumed3;
                        consumed = consumed2;
                        mo654onPostFlingRZ2iAVY = $result;
                        long selfConsumed22 = ((Velocity) mo654onPostFlingRZ2iAVY).getPackedValue();
                        parent = nestedScrollModifierLocal.getParent();
                        if (parent != null) {
                        }
                        break;
                    case 2:
                        long selfConsumed4 = nestedScrollModifierLocal$onPostFling$1.J$0;
                        ResultKt.throwOnFailure($result);
                        selfConsumed = selfConsumed4;
                        mo654onPostFlingRZ2iAVY2 = $result;
                        parentConsumed = ((Velocity) mo654onPostFlingRZ2iAVY2).getPackedValue();
                        return Velocity.m4598boximpl(Velocity.m4611plusAH228Gc(selfConsumed, parentConsumed));
                    default:
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
            }
        }
        nestedScrollModifierLocal$onPostFling$1 = new NestedScrollModifierLocal$onPostFling$1(this, continuation);
        Object $result2 = nestedScrollModifierLocal$onPostFling$1.result;
        Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (nestedScrollModifierLocal$onPostFling$1.label) {
        }
    }
}
