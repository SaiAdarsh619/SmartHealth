package androidx.compose.p000ui.node;

import androidx.compose.p000ui.ExperimentalComposeUiApi;
import androidx.compose.p000ui.Modifier;
import androidx.compose.runtime.collection.MutableVector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DelegatableNode.kt */
@Metadata(m286d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u00022\u0006\u0010\u0004\u001a\u00020\u0003H\u0002\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\n\u0010\u000b\u001a2\u0010\f\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\tH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0016\u0010\f\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001a2\u0010\u0012\u001a\u0004\u0018\u0001H\r\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\tH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u000f\u001a\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001a6\u0010\u0014\u001a\u0004\u0018\u0001H\r\"\n\b\u0000\u0010\r\u0018\u0001*\u00020\u0015*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\tH\u0081\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u000f\u001a\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0003*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001a%\u0010\u0017\u001a\u00020\u0018*\u00020\u00072\n\u0010\u0019\u001a\u0006\u0012\u0002\b\u00030\tH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a\f\u0010\u001c\u001a\u00020\u001d*\u00020\u0007H\u0001\u001a\f\u0010\u001e\u001a\u00020\u001f*\u00020\u0007H\u0001\u001aG\u0010 \u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001a,\u0010 \u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002\u001aG\u0010%\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010$\u001a,\u0010%\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002\u001aG\u0010'\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010$\u001a,\u0010'\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002\u001aG\u0010)\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010$\u001a,\u0010)\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002\u001aG\u0010+\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010$\u001a,\u0010+\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\"H\u0081\bø\u0001\u0002\u001aG\u0010-\u001a\u00020\u0001\"\u0006\b\u0000\u0010\r\u0018\u0001*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\r0\t2\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u00020\u00060\"H\u0081\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b.\u0010$\u001a,\u0010-\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\"H\u0081\bø\u0001\u0002\u0082\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b\u009920\u0001¨\u0006/"}, m287d2 = {"addLayoutNodeChildren", "", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Node;", "node", "has", "", "Landroidx/compose/ui/node/DelegatableNode;", "type", "Landroidx/compose/ui/node/NodeKind;", "has-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Z", "localChild", "T", "localChild-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Ljava/lang/Object;", "mask", "", "localParent", "localParent-64DMado", "nearestAncestor", "", "nearestAncestor-64DMado", "requireCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "kind", "requireCoordinator-64DMado", "(Landroidx/compose/ui/node/DelegatableNode;I)Landroidx/compose/ui/node/NodeCoordinator;", "requireLayoutNode", "Landroidx/compose/ui/node/LayoutNode;", "requireOwner", "Landroidx/compose/ui/node/Owner;", "visitAncestors", "block", "Lkotlin/Function1;", "visitAncestors-6rFNWt0", "(Landroidx/compose/ui/node/DelegatableNode;ILkotlin/jvm/functions/Function1;)V", "visitChildren", "visitChildren-6rFNWt0", "visitLocalChildren", "visitLocalChildren-6rFNWt0", "visitLocalParents", "visitLocalParents-6rFNWt0", "visitSubtree", "visitSubtree-6rFNWt0", "visitSubtreeIf", "visitSubtreeIf-6rFNWt0", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class DelegatableNodeKt {
    @ExperimentalComposeUiApi
    public static final Modifier.Node localChild(DelegatableNode $this$localChild, int mask) {
        Intrinsics.checkNotNullParameter($this$localChild, "<this>");
        Modifier.Node child = $this$localChild.getNode().getChild();
        if (child == null || (child.getAggregateChildKindSet() & mask) == 0) {
            return null;
        }
        for (Modifier.Node next = child; next != null; next = next.getChild()) {
            if ((next.getKindSet() & mask) != 0) {
                return next;
            }
        }
        return null;
    }

    @ExperimentalComposeUiApi
    public static final Modifier.Node localParent(DelegatableNode $this$localParent, int mask) {
        Intrinsics.checkNotNullParameter($this$localParent, "<this>");
        for (Modifier.Node next = $this$localParent.getNode().getParent(); next != null; next = next.getParent()) {
            if ((next.getKindSet() & mask) != 0) {
                return next;
            }
        }
        return null;
    }

    @ExperimentalComposeUiApi
    public static final void visitAncestors(DelegatableNode $this$visitAncestors, int mask, Function1<? super Modifier.Node, Unit> block) {
        NodeChain nodes;
        Intrinsics.checkNotNullParameter($this$visitAncestors, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!$this$visitAncestors.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = $this$visitAncestors.getNode().getParent();
        LayoutNode layout = requireLayoutNode($this$visitAncestors);
        while (layout != null) {
            Modifier.Node head = layout.getNodes().getHead();
            if ((head.getAggregateChildKindSet() & mask) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & mask) != 0) {
                        block.invoke(node);
                    }
                    node = node.getParent();
                }
            }
            layout = layout.getParent$ui_release();
            node = (layout == null || (nodes = layout.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    @ExperimentalComposeUiApi
    public static final Modifier.Node nearestAncestor(DelegatableNode $this$nearestAncestor, int mask) {
        NodeChain nodes;
        Intrinsics.checkNotNullParameter($this$nearestAncestor, "<this>");
        if (!$this$nearestAncestor.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = $this$nearestAncestor.getNode().getParent();
        LayoutNode layout = requireLayoutNode($this$nearestAncestor);
        while (true) {
            Modifier.Node node2 = null;
            if (layout == null) {
                return null;
            }
            Modifier.Node head = layout.getNodes().getHead();
            if ((head.getAggregateChildKindSet() & mask) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & mask) != 0) {
                        return node;
                    }
                    node = node.getParent();
                }
            }
            layout = layout.getParent$ui_release();
            if (layout != null && (nodes = layout.getNodes()) != null) {
                node2 = nodes.getTail();
            }
            node = node2;
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitSubtree(DelegatableNode $this$visitSubtree, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtree, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!$this$visitSubtree.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node = $this$visitSubtree.getNode().getChild();
        NestedVectorStack nodes = new NestedVectorStack();
        for (LayoutNode layout = requireLayoutNode($this$visitSubtree); layout != null; layout = nodes.isNotEmpty() ? (LayoutNode) nodes.pop() : null) {
            node = node == null ? layout.getNodes().getHead() : node;
            if ((node.getAggregateChildKindSet() & mask) != 0) {
                while (node != null) {
                    if ((node.getKindSet() & mask) != 0) {
                        block.invoke(node);
                    }
                    node = node.getChild();
                }
                node = null;
            }
            nodes.push(layout.get_children$ui_release());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void addLayoutNodeChildren(MutableVector<Modifier.Node> mutableVector, Modifier.Node node) {
        MutableVector this_$iv = requireLayoutNode(node).get_children$ui_release();
        int size$iv = this_$iv.getSize();
        if (size$iv <= 0) {
            return;
        }
        int i$iv = size$iv - 1;
        Object[] content$iv = this_$iv.getContent();
        Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
        do {
            LayoutNode it = (LayoutNode) content$iv[i$iv];
            mutableVector.add(it.getNodes().getHead());
            i$iv--;
        } while (i$iv >= 0);
    }

    @ExperimentalComposeUiApi
    public static final void visitChildren(DelegatableNode $this$visitChildren, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitChildren, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!$this$visitChildren.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector branches = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = $this$visitChildren.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(branches, $this$visitChildren.getNode());
        } else {
            branches.add(child);
        }
        while (branches.isNotEmpty()) {
            Modifier.Node branch = (Modifier.Node) branches.removeAt(branches.getSize() - 1);
            if ((branch.getAggregateChildKindSet() & mask) == 0) {
                addLayoutNodeChildren(branches, branch);
            } else {
                Modifier.Node node = branch;
                while (true) {
                    if (node == null) {
                        break;
                    }
                    if ((node.getKindSet() & mask) != 0) {
                        block.invoke(node);
                        break;
                    }
                    node = node.getChild();
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitSubtreeIf(DelegatableNode $this$visitSubtreeIf, int mask, Function1<? super Modifier.Node, Boolean> block) {
        Intrinsics.checkNotNullParameter($this$visitSubtreeIf, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!$this$visitSubtreeIf.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector branches = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child = $this$visitSubtreeIf.getNode().getChild();
        if (child == null) {
            addLayoutNodeChildren(branches, $this$visitSubtreeIf.getNode());
        } else {
            branches.add(child);
        }
        while (branches.isNotEmpty()) {
            Modifier.Node branch = (Modifier.Node) branches.removeAt(branches.getSize() - 1);
            if ((branch.getAggregateChildKindSet() & mask) != 0) {
                for (Modifier.Node node = branch; node != null; node = node.getChild()) {
                    if ((node.getKindSet() & mask) != 0) {
                        boolean diveDeeper = block.invoke(node).booleanValue();
                        if (diveDeeper) {
                        }
                    }
                }
            }
            addLayoutNodeChildren(branches, branch);
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitLocalChildren(DelegatableNode $this$visitLocalChildren, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalChildren, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!$this$visitLocalChildren.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node self = $this$visitLocalChildren.getNode();
        if ((self.getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node next = self.getChild(); next != null; next = next.getChild()) {
            if ((next.getKindSet() & mask) != 0) {
                block.invoke(next);
            }
        }
    }

    @ExperimentalComposeUiApi
    public static final void visitLocalParents(DelegatableNode $this$visitLocalParents, int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter($this$visitLocalParents, "<this>");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!$this$visitLocalParents.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        for (Modifier.Node next = $this$visitLocalParents.getNode().getParent(); next != null; next = next.getParent()) {
            if ((next.getKindSet() & mask) != 0) {
                block.invoke(next);
            }
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitLocalChildren-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m3600visitLocalChildren6rFNWt0(DelegatableNode visitLocalChildren, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitLocalChildren, "$this$visitLocalChildren");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitLocalChildren.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node self$iv = visitLocalChildren.getNode();
        if ((self$iv.getAggregateChildKindSet() & type) == 0) {
            return;
        }
        for (Modifier.Node next$iv = self$iv.getChild(); next$iv != null; next$iv = next$iv.getChild()) {
            if ((next$iv.getKindSet() & type) != 0) {
                Modifier.Node it = next$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it instanceof Object) {
                    block.invoke(it);
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitLocalParents-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m3601visitLocalParents6rFNWt0(DelegatableNode visitLocalParents, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitLocalParents, "$this$visitLocalParents");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitLocalParents.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        for (Modifier.Node next$iv = visitLocalParents.getNode().getParent(); next$iv != null; next$iv = next$iv.getParent()) {
            if ((next$iv.getKindSet() & type) != 0) {
                Modifier.Node it = next$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it instanceof Object) {
                    block.invoke(it);
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: localParent-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m3595localParent64DMado(DelegatableNode localParent, int i) {
        Intrinsics.checkNotNullParameter(localParent, "$this$localParent");
        Object localParent2 = localParent(localParent, i);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) localParent2;
    }

    @ExperimentalComposeUiApi
    /* renamed from: localChild-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m3594localChild64DMado(DelegatableNode localChild, int i) {
        Intrinsics.checkNotNullParameter(localChild, "$this$localChild");
        Object localChild2 = localChild(localChild, i);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) localChild2;
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitAncestors-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m3598visitAncestors6rFNWt0(DelegatableNode visitAncestors, int type, Function1<? super T, Unit> block) {
        NodeChain nodes;
        Intrinsics.checkNotNullParameter(visitAncestors, "$this$visitAncestors");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitAncestors.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node$iv = visitAncestors.getNode().getParent();
        LayoutNode layout$iv = requireLayoutNode(visitAncestors);
        while (layout$iv != null) {
            Modifier.Node head$iv = layout$iv.getNodes().getHead();
            if ((head$iv.getAggregateChildKindSet() & type) != 0) {
                while (node$iv != null) {
                    if ((node$iv.getKindSet() & type) != 0) {
                        Modifier.Node it = node$iv;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (it instanceof Object) {
                            block.invoke(it);
                        }
                    }
                    node$iv = node$iv.getParent();
                }
            }
            layout$iv = layout$iv.getParent$ui_release();
            node$iv = (layout$iv == null || (nodes = layout$iv.getNodes()) == null) ? null : nodes.getTail();
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: nearestAncestor-64DMado, reason: not valid java name */
    public static final /* synthetic */ <T> T m3596nearestAncestor64DMado(DelegatableNode nearestAncestor, int i) {
        Intrinsics.checkNotNullParameter(nearestAncestor, "$this$nearestAncestor");
        Object nearestAncestor2 = nearestAncestor(nearestAncestor, i);
        Intrinsics.reifiedOperationMarker(2, "T");
        return (T) nearestAncestor2;
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitSubtree-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m3602visitSubtree6rFNWt0(DelegatableNode visitSubtree, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitSubtree, "$this$visitSubtree");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitSubtree.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node node$iv = visitSubtree.getNode().getChild();
        NestedVectorStack nodes$iv = new NestedVectorStack();
        for (LayoutNode layout$iv = requireLayoutNode(visitSubtree); layout$iv != null; layout$iv = nodes$iv.isNotEmpty() ? (LayoutNode) nodes$iv.pop() : null) {
            node$iv = node$iv == null ? layout$iv.getNodes().getHead() : node$iv;
            if ((node$iv.getAggregateChildKindSet() & type) != 0) {
                while (node$iv != null) {
                    if ((node$iv.getKindSet() & type) != 0) {
                        Modifier.Node it = node$iv;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (it instanceof Object) {
                            block.invoke(it);
                        }
                    }
                    node$iv = node$iv.getChild();
                }
                node$iv = null;
            }
            nodes$iv.push(layout$iv.get_children$ui_release());
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitChildren-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m3599visitChildren6rFNWt0(DelegatableNode visitChildren, int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(visitChildren, "$this$visitChildren");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitChildren.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector branches$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv = visitChildren.getNode().getChild();
        if (child$iv == null) {
            addLayoutNodeChildren(branches$iv, visitChildren.getNode());
        } else {
            branches$iv.add(child$iv);
        }
        while (branches$iv.isNotEmpty()) {
            Modifier.Node branch$iv = (Modifier.Node) branches$iv.removeAt(branches$iv.getSize() - 1);
            if ((branch$iv.getAggregateChildKindSet() & type) == 0) {
                addLayoutNodeChildren(branches$iv, branch$iv);
            } else {
                Modifier.Node node$iv = branch$iv;
                while (true) {
                    if (node$iv == null) {
                        break;
                    }
                    if ((node$iv.getKindSet() & type) != 0) {
                        Modifier.Node it = node$iv;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        if (it instanceof Object) {
                            block.invoke(it);
                        }
                    } else {
                        node$iv = node$iv.getChild();
                    }
                }
            }
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: visitSubtreeIf-6rFNWt0, reason: not valid java name */
    public static final /* synthetic */ <T> void m3603visitSubtreeIf6rFNWt0(DelegatableNode visitSubtreeIf, int type, Function1<? super T, Boolean> block) {
        Intrinsics.checkNotNullParameter(visitSubtreeIf, "$this$visitSubtreeIf");
        Intrinsics.checkNotNullParameter(block, "block");
        if (!visitSubtreeIf.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector branches$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv = visitSubtreeIf.getNode().getChild();
        if (child$iv == null) {
            addLayoutNodeChildren(branches$iv, visitSubtreeIf.getNode());
        } else {
            branches$iv.add(child$iv);
        }
        while (branches$iv.isNotEmpty()) {
            Modifier.Node branch$iv = (Modifier.Node) branches$iv.removeAt(branches$iv.getSize() - 1);
            if ((branch$iv.getAggregateChildKindSet() & type) != 0) {
                for (Modifier.Node node$iv = branch$iv; node$iv != null; node$iv = node$iv.getChild()) {
                    if ((node$iv.getKindSet() & type) != 0) {
                        Modifier.Node it = node$iv;
                        Intrinsics.reifiedOperationMarker(3, "T");
                        boolean diveDeeper$iv = it instanceof Object ? block.invoke(it).booleanValue() : true;
                        if (diveDeeper$iv) {
                        }
                    }
                }
            }
            addLayoutNodeChildren(branches$iv, branch$iv);
        }
    }

    @ExperimentalComposeUiApi
    /* renamed from: has-64DMado, reason: not valid java name */
    public static final boolean m3593has64DMado(DelegatableNode has, int type) {
        Intrinsics.checkNotNullParameter(has, "$this$has");
        return (has.getNode().getAggregateChildKindSet() & type) != 0;
    }

    @ExperimentalComposeUiApi
    /* renamed from: requireCoordinator-64DMado, reason: not valid java name */
    public static final NodeCoordinator m3597requireCoordinator64DMado(DelegatableNode requireCoordinator, int kind) {
        Intrinsics.checkNotNullParameter(requireCoordinator, "$this$requireCoordinator");
        NodeCoordinator coordinator = requireCoordinator.getNode().getCoordinator();
        Intrinsics.checkNotNull(coordinator);
        if (coordinator.getTail() != requireCoordinator || !NodeKindKt.m3701getIncludeSelfInTraversalH91voCI(kind)) {
            return coordinator;
        }
        NodeCoordinator wrapped = coordinator.getWrapped();
        Intrinsics.checkNotNull(wrapped);
        return wrapped;
    }

    @ExperimentalComposeUiApi
    public static final LayoutNode requireLayoutNode(DelegatableNode $this$requireLayoutNode) {
        Intrinsics.checkNotNullParameter($this$requireLayoutNode, "<this>");
        NodeCoordinator coordinator = $this$requireLayoutNode.getNode().getCoordinator();
        Intrinsics.checkNotNull(coordinator);
        return coordinator.getLayoutNode();
    }

    @ExperimentalComposeUiApi
    public static final Owner requireOwner(DelegatableNode $this$requireOwner) {
        Intrinsics.checkNotNullParameter($this$requireOwner, "<this>");
        Owner owner = requireLayoutNode($this$requireOwner).getOwner();
        Intrinsics.checkNotNull(owner);
        return owner;
    }
}
