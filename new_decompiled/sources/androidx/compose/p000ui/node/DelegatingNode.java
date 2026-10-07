package androidx.compose.p000ui.node;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.p000ui.Modifier;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatingNode.kt */
@ExperimentalComposeUiApi
@Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0001H\u0002J#\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\n¢\u0006\u0002\u0010\u000bJ\u001d\u0010\f\u001a\u00020\u00052\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u000eH\u0082\bJ$\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\b0\u0010\"\b\b\u0000\u0010\b*\u00020\u00012\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\b0\nJ\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u0017\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0010¢\u0006\u0002\b\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m287d2 = {"Landroidx/compose/ui/node/DelegatingNode;", "Landroidx/compose/ui/Modifier$Node;", "()V", "delegate", "addDelegate", "", "node", "delegated", "T", "fn", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Landroidx/compose/ui/Modifier$Node;", "forEachDelegate", "block", "Lkotlin/Function1;", "lazyDelegated", "Lkotlin/Lazy;", "onAttach", "onDetach", "updateCoordinator", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "updateCoordinator$ui_release", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public abstract class DelegatingNode extends Modifier.Node {
    public static final int $stable = 8;
    private Modifier.Node delegate;

    @Override // androidx.compose.ui.Modifier.Node
    public void updateCoordinator$ui_release(NodeCoordinator coordinator) {
        super.updateCoordinator$ui_release(coordinator);
        for (Modifier.Node node$iv = this.delegate; node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            it.updateCoordinator$ui_release(coordinator);
        }
    }

    public final <T extends Modifier.Node> T delegated(Function0<? extends T> fn) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        Modifier.Node owner = getNode();
        T invoke = fn.invoke();
        invoke.setAsDelegateTo$ui_release(owner);
        if (getIsAttached()) {
            updateCoordinator$ui_release(owner.getCoordinator());
            invoke.attach$ui_release();
        }
        addDelegate(invoke);
        return invoke;
    }

    private final void addDelegate(Modifier.Node node) {
        Modifier.Node tail = this.delegate;
        if (tail != null) {
            node.setParent$ui_release(tail);
        }
        this.delegate = node;
    }

    public final <T extends Modifier.Node> Lazy<T> lazyDelegated(final Function0<? extends T> fn) {
        Intrinsics.checkNotNullParameter(fn, "fn");
        return LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<T>() { // from class: androidx.compose.ui.node.DelegatingNode$lazyDelegated$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Incorrect return type in method signature: ()TT; */
            @Override // kotlin.jvm.functions.Function0
            public final Modifier.Node invoke() {
                return DelegatingNode.this.delegated(fn);
            }
        });
    }

    private final void forEachDelegate(Function1<? super Modifier.Node, Unit> block) {
        for (Modifier.Node node = this.delegate; node != null; node = node.getParent()) {
            block.invoke(node);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        super.onAttach();
        for (Modifier.Node node$iv = this.delegate; node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            updateCoordinator$ui_release(getCoordinator());
            it.attach$ui_release();
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        for (Modifier.Node node$iv = this.delegate; node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            it.detach$ui_release();
        }
        super.onDetach();
    }
}
