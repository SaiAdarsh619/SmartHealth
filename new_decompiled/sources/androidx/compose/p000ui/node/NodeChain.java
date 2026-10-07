package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.layout.ModifierInfo;
import androidx.compose.runtime.collection.MutableVector;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NodeChain.kt */
@Metadata(m286d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002`aB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010%\u001a\u00020&J\u0018\u0010'\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u0010H\u0002J\r\u0010*\u001a\u00020&H\u0000¢\u0006\u0002\b+J\u0010\u0010,\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0002JE\u0010.\u001a\u0004\u0018\u0001H/\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020\u001903H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b4\u00105J0\u00106\u001a\u00060\rR\u00020\u00002\u0006\u0010#\u001a\u00020\u00102\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0002J\f\u00109\u001a\b\u0012\u0004\u0012\u00020;0:J!\u0010<\u001a\u00020\u00192\n\u00100\u001a\u0006\u0012\u0002\b\u000301H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b=\u0010>J.\u0010\u0011\u001a\u0004\u0018\u0001H/\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/01H\u0080\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b?\u0010@J%\u0010A\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\u0080\bø\u0001\u0000¢\u0006\u0002\bBJC\u0010A\u001a\u00020&\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020&03H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bC\u0010DJ-\u0010A\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00062\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\u0080\bø\u0001\u0000¢\u0006\u0002\bBJ%\u0010F\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\u0080\bø\u0001\u0000¢\u0006\u0002\bGJ\u0018\u0010H\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u00102\u0006\u0010)\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020&H\u0002J\u0010\u0010J\u001a\u00020\u00102\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0018\u0010K\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u00102\u0006\u0010M\u001a\u00020\u0010H\u0002J<\u0010N\u001a\u00020&2\f\u00107\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010O\u001a\u00020\u00062\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010P\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0010H\u0002J\b\u0010Q\u001a\u00020&H\u0002J.\u0010#\u001a\u0004\u0018\u0001H/\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/01H\u0080\bø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bR\u0010@J%\u0010S\u001a\u00020&2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\u0080\bø\u0001\u0000¢\u0006\u0002\bTJC\u0010S\u001a\u00020&\"\u0006\b\u0000\u0010/\u0018\u00012\f\u00100\u001a\b\u0012\u0004\u0012\u0002H/012\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u0002H/\u0012\u0004\u0012\u00020&03H\u0080\bø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\bU\u0010DJ-\u0010S\u001a\u00020&2\u0006\u0010E\u001a\u00020\u00062\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020&03H\u0080\bø\u0001\u0000¢\u0006\u0002\bTJ\b\u0010V\u001a\u00020WH\u0016J\b\u0010X\u001a\u00020&H\u0002J\u0015\u0010Y\u001a\u00020&2\u0006\u0010Z\u001a\u00020[H\u0000¢\u0006\u0002\b\\J \u0010]\u001a\u00020\u00102\u0006\u0010L\u001a\u00020\u000b2\u0006\u0010M\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u0010H\u0002J\u0017\u0010^\u001a\u00020&2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0000¢\u0006\u0002\b_R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0018\u00010\rR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u000f\u001a\u00020\u0010@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010 \u001a\u00020\u001f2\u0006\u0010\u000f\u001a\u00020\u001f@BX\u0080\u000e¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u0010X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0013\u0082\u0002\u0012\n\u0005\b\u009920\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006b"}, m287d2 = {"Landroidx/compose/ui/node/NodeChain;", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "(Landroidx/compose/ui/node/LayoutNode;)V", "aggregateChildKindSet", "", "getAggregateChildKindSet", "()I", "buffer", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "cachedDiffer", "Landroidx/compose/ui/node/NodeChain$Differ;", "current", "<set-?>", "Landroidx/compose/ui/Modifier$Node;", "head", "getHead$ui_release", "()Landroidx/compose/ui/Modifier$Node;", "innerCoordinator", "Landroidx/compose/ui/node/InnerNodeCoordinator;", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/InnerNodeCoordinator;", "isUpdating", "", "()Z", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "logger", "Landroidx/compose/ui/node/NodeChain$Logger;", "Landroidx/compose/ui/node/NodeCoordinator;", "outerCoordinator", "getOuterCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "tail", "getTail$ui_release", "attach", "", "createAndInsertNodeAsParent", "element", "child", "detach", "detach$ui_release", "disposeAndRemoveNode", "node", "firstFromHead", "T", "type", "Landroidx/compose/ui/node/NodeKind;", "block", "Lkotlin/Function1;", "firstFromHead-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "getDiffer", "before", "after", "getModifierInfo", "", "Landroidx/compose/ui/layout/ModifierInfo;", "has", "has-H91voCI$ui_release", "(I)Z", "head-H91voCI$ui_release", "(I)Ljava/lang/Object;", "headToTail", "headToTail$ui_release", "headToTail-aLcG6gQ$ui_release", "(ILkotlin/jvm/functions/Function1;)V", "mask", "headToTailExclusive", "headToTailExclusive$ui_release", "insertParent", "padChain", "removeNode", "replaceNode", "prev", "next", "structuralUpdate", "beforeSize", "afterSize", "syncCoordinators", "tail-H91voCI$ui_release", "tailToHead", "tailToHead$ui_release", "tailToHead-aLcG6gQ$ui_release", "toString", "", "trimChain", "updateFrom", "m", "Landroidx/compose/ui/Modifier;", "updateFrom$ui_release", "updateNodeAndReplaceIfNeeded", "useLogger", "useLogger$ui_release", "Differ", "Logger", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class NodeChain {
    private MutableVector<Modifier.Element> buffer;
    private Differ cachedDiffer;
    private MutableVector<Modifier.Element> current;
    private Modifier.Node head;
    private final InnerNodeCoordinator innerCoordinator;
    private final LayoutNode layoutNode;
    private Logger logger;
    private NodeCoordinator outerCoordinator;
    private final Modifier.Node tail;

    /* compiled from: NodeChain.kt */
    @Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b`\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\nH&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J0\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J8\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH&ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0017À\u0006\u0001"}, m287d2 = {"Landroidx/compose/ui/node/NodeChain$Logger;", "", "linearDiffAborted", "", "index", "", "prev", "Landroidx/compose/ui/Modifier$Element;", "next", "node", "Landroidx/compose/ui/Modifier$Node;", "nodeInserted", "atIndex", "newIndex", "element", "child", "inserted", "nodeRemoved", "oldIndex", "nodeReused", "nodeUpdated", "before", "after", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    public interface Logger {
        void linearDiffAborted(int index, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeInserted(int atIndex, int newIndex, Modifier.Element element, Modifier.Node child, Modifier.Node inserted);

        void nodeRemoved(int oldIndex, Modifier.Element element, Modifier.Node node);

        void nodeReused(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node node);

        void nodeUpdated(int oldIndex, int newIndex, Modifier.Element prev, Modifier.Element next, Modifier.Node before, Modifier.Node after);
    }

    public NodeChain(LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.layoutNode = layoutNode;
        this.innerCoordinator = new InnerNodeCoordinator(this.layoutNode);
        this.outerCoordinator = this.innerCoordinator;
        this.tail = this.innerCoordinator.getTail();
        this.head = this.tail;
    }

    public final LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    /* renamed from: getInnerCoordinator$ui_release, reason: from getter */
    public final InnerNodeCoordinator getInnerCoordinator() {
        return this.innerCoordinator;
    }

    /* renamed from: getOuterCoordinator$ui_release, reason: from getter */
    public final NodeCoordinator getOuterCoordinator() {
        return this.outerCoordinator;
    }

    /* renamed from: getTail$ui_release, reason: from getter */
    public final Modifier.Node getTail() {
        return this.tail;
    }

    /* renamed from: getHead$ui_release, reason: from getter */
    public final Modifier.Node getHead() {
        return this.head;
    }

    private final boolean isUpdating() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        return node == nodeChainKt$SentinelHead$1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getAggregateChildKindSet() {
        return this.head.getAggregateChildKindSet();
    }

    public final void useLogger$ui_release(Logger logger) {
        this.logger = logger;
    }

    private final void padChain() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (!(node != nodeChainKt$SentinelHead$1)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node currentHead = this.head;
        nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
        currentHead.setParent$ui_release(nodeChainKt$SentinelHead$12);
        nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
        nodeChainKt$SentinelHead$13.setChild$ui_release(currentHead);
        nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
        this.head = nodeChainKt$SentinelHead$14;
    }

    private final void trimChain() {
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$1;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$12;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$13;
        NodeChainKt$SentinelHead$1 nodeChainKt$SentinelHead$14;
        Modifier.Node node = this.head;
        nodeChainKt$SentinelHead$1 = NodeChainKt.SentinelHead;
        if (node == nodeChainKt$SentinelHead$1) {
            nodeChainKt$SentinelHead$12 = NodeChainKt.SentinelHead;
            Modifier.Node child$ui_release = nodeChainKt$SentinelHead$12.getChild();
            if (child$ui_release == null) {
                child$ui_release = this.tail;
            }
            this.head = child$ui_release;
            this.head.setParent$ui_release(null);
            nodeChainKt$SentinelHead$13 = NodeChainKt.SentinelHead;
            nodeChainKt$SentinelHead$13.setChild$ui_release(null);
            Modifier.Node node2 = this.head;
            nodeChainKt$SentinelHead$14 = NodeChainKt.SentinelHead;
            if (!(node2 != nodeChainKt$SentinelHead$14)) {
                throw new IllegalStateException("Check failed.".toString());
            }
            return;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    public final void updateFrom$ui_release(Modifier m) {
        MutableVector after;
        Modifier.Node node;
        int i;
        Modifier.Element next;
        Modifier.Element next2;
        Intrinsics.checkNotNullParameter(m, "m");
        boolean attachNeeded = false;
        boolean coordinatorSyncNeeded = false;
        padChain();
        MutableVector mutableVector = this.current;
        if (mutableVector == null) {
            mutableVector = new MutableVector(new Modifier.Element[16], 0);
        }
        MutableVector before = mutableVector;
        MutableVector<Modifier.Element> mutableVector2 = this.buffer;
        if (mutableVector2 == null) {
            mutableVector2 = new MutableVector<>(new Modifier.Element[16], 0);
        }
        after = NodeChainKt.fillVector(m, mutableVector2);
        if (after.getSize() == before.getSize()) {
            int size = before.getSize();
            Modifier.Node node2 = this.tail.getParent();
            int i2 = size - 1;
            int aggregateChildKindSet = 0;
            while (node2 != null && i2 >= 0) {
                Modifier.Element prev = before.getContent()[i2];
                Modifier.Element next3 = after.getContent()[i2];
                switch (NodeChainKt.reuseActionForModifiers(prev, next3)) {
                    case 0:
                        Logger logger = this.logger;
                        if (logger != null) {
                            logger.linearDiffAborted(i2, prev, next3, node2);
                        }
                        node = node2.getChild();
                        i = i2 + 1;
                        break;
                    case 1:
                        Modifier.Node beforeUpdate = node2;
                        node2 = updateNodeAndReplaceIfNeeded(prev, next3, beforeUpdate);
                        attachNeeded = attachNeeded || beforeUpdate != node2;
                        Logger logger2 = this.logger;
                        if (logger2 != null) {
                            next = next3;
                            logger2.nodeUpdated(i2, i2, prev, next, beforeUpdate, node2);
                        } else {
                            next = next3;
                        }
                        break;
                    case 2:
                        Logger logger3 = this.logger;
                        if (logger3 != null) {
                            next2 = next3;
                            logger3.nodeReused(i2, i2, prev, next2, node2);
                        } else {
                            next2 = next3;
                        }
                        break;
                }
                i2--;
                int aggregateChildKindSet2 = aggregateChildKindSet | node2.getKindSet();
                node2.setAggregateChildKindSet$ui_release(aggregateChildKindSet2);
                node2 = node2.getParent();
                aggregateChildKindSet = aggregateChildKindSet2;
            }
            node = node2;
            i = i2;
            if (i > 0) {
                if (!(node != null)) {
                    throw new IllegalStateException("Check failed.".toString());
                }
                structuralUpdate(before, i, after, i, node);
                attachNeeded = true;
                coordinatorSyncNeeded = true;
            }
        } else if (before.getSize() == 0) {
            attachNeeded = true;
            coordinatorSyncNeeded = true;
            int aggregateChildKindSet3 = 0;
            Modifier.Node node3 = this.tail;
            for (int i3 = after.getSize() - 1; i3 >= 0; i3--) {
                Modifier.Element next4 = after.getContent()[i3];
                Modifier.Node child = node3;
                node3 = createAndInsertNodeAsParent(next4, child);
                Logger logger4 = this.logger;
                if (logger4 != null) {
                    logger4.nodeInserted(0, i3, next4, child, node3);
                }
                aggregateChildKindSet3 |= node3.getKindSet();
                node3.setAggregateChildKindSet$ui_release(aggregateChildKindSet3);
            }
        } else {
            structuralUpdate(before, before.getSize(), after, after.getSize(), this.tail);
            attachNeeded = true;
            coordinatorSyncNeeded = true;
        }
        this.current = after;
        before.clear();
        this.buffer = before;
        trimChain();
        if (coordinatorSyncNeeded) {
            syncCoordinators();
        }
        if (attachNeeded && this.layoutNode.isAttached()) {
            attach();
        }
    }

    private final void syncCoordinators() {
        LayoutModifierNodeCoordinator c;
        NodeCoordinator coordinator = this.innerCoordinator;
        for (Modifier.Node node = this.tail.getParent(); node != null; node = node.getParent()) {
            int kind$iv = Nodes.INSTANCE.m3708getLayoutOLwlOKw();
            Modifier.Node this_$iv = node;
            if (((this_$iv.getKindSet() & kind$iv) != 0) && (node instanceof LayoutModifierNode)) {
                if (node.getIsAttached()) {
                    NodeCoordinator coordinator2 = node.getCoordinator();
                    Intrinsics.checkNotNull(coordinator2, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
                    c = (LayoutModifierNodeCoordinator) coordinator2;
                    LayoutModifierNode prevNode = c.getLayoutModifierNode();
                    c.setLayoutModifierNode$ui_release((LayoutModifierNode) node);
                    if (prevNode != node) {
                        c.onLayoutModifierNodeChanged();
                    }
                } else {
                    c = new LayoutModifierNodeCoordinator(this.layoutNode, (LayoutModifierNode) node);
                    node.updateCoordinator$ui_release(c);
                }
                coordinator.setWrappedBy$ui_release(c);
                c.setWrapped$ui_release(coordinator);
                NodeCoordinator coordinator3 = c;
                coordinator = coordinator3;
            } else {
                node.updateCoordinator$ui_release(coordinator);
            }
        }
        LayoutNode parent$ui_release = this.layoutNode.getParent$ui_release();
        coordinator.setWrappedBy$ui_release(parent$ui_release != null ? parent$ui_release.getInnerCoordinator$ui_release() : null);
        this.outerCoordinator = coordinator;
    }

    public final void attach() {
        for (Modifier.Node node$iv = getHead(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            if (!it.getIsAttached()) {
                it.attach$ui_release();
            }
        }
    }

    public final List<ModifierInfo> getModifierInfo() {
        MutableVector current = this.current;
        if (current == null) {
            return CollectionsKt.emptyList();
        }
        int capacity$iv = current.getSize();
        MutableVector infoList = new MutableVector(new ModifierInfo[capacity$iv], 0);
        int i = 0;
        Modifier.Node node$iv = getHead();
        while (node$iv != null && node$iv != getTail()) {
            Modifier.Node node = node$iv;
            NodeCoordinator coordinator = node.getCoordinator();
            if (coordinator == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            infoList.add(new ModifierInfo(current.getContent()[i], coordinator, coordinator.getLayer()));
            node$iv = node$iv.getChild();
            i++;
        }
        return infoList.asMutableList();
    }

    public final void detach$ui_release() {
        for (Modifier.Node node$iv = getTail(); node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            if (it.getIsAttached()) {
                it.detach$ui_release();
            }
        }
    }

    private final Differ getDiffer(Modifier.Node tail, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after) {
        Differ current = this.cachedDiffer;
        if (current == null) {
            Differ it = new Differ(this, tail, tail.getAggregateChildKindSet(), before, after);
            this.cachedDiffer = it;
            return it;
        }
        current.setNode(tail);
        current.setAggregateChildKindSet(tail.getAggregateChildKindSet());
        current.setBefore(before);
        current.setAfter(after);
        return current;
    }

    /* compiled from: NodeChain.kt */
    @Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\nJ\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0010\u0010 \u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010!\u001a\u00020\u001e2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\f\"\u0004\b\u0014\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\""}, m287d2 = {"Landroidx/compose/ui/node/NodeChain$Differ;", "Landroidx/compose/ui/node/DiffCallback;", "node", "Landroidx/compose/ui/Modifier$Node;", "aggregateChildKindSet", "", "before", "Landroidx/compose/runtime/collection/MutableVector;", "Landroidx/compose/ui/Modifier$Element;", "after", "(Landroidx/compose/ui/node/NodeChain;Landroidx/compose/ui/Modifier$Node;ILandroidx/compose/runtime/collection/MutableVector;Landroidx/compose/runtime/collection/MutableVector;)V", "getAfter", "()Landroidx/compose/runtime/collection/MutableVector;", "setAfter", "(Landroidx/compose/runtime/collection/MutableVector;)V", "getAggregateChildKindSet", "()I", "setAggregateChildKindSet", "(I)V", "getBefore", "setBefore", "getNode", "()Landroidx/compose/ui/Modifier$Node;", "setNode", "(Landroidx/compose/ui/Modifier$Node;)V", "areItemsTheSame", "", "oldIndex", "newIndex", "insert", "", "atIndex", "remove", "same", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
    private final class Differ implements DiffCallback {
        private MutableVector<Modifier.Element> after;
        private int aggregateChildKindSet;
        private MutableVector<Modifier.Element> before;
        private Modifier.Node node;
        final /* synthetic */ NodeChain this$0;

        public Differ(NodeChain this$0, Modifier.Node node, int aggregateChildKindSet, MutableVector<Modifier.Element> before, MutableVector<Modifier.Element> after) {
            Intrinsics.checkNotNullParameter(node, "node");
            Intrinsics.checkNotNullParameter(before, "before");
            Intrinsics.checkNotNullParameter(after, "after");
            this.this$0 = this$0;
            this.node = node;
            this.aggregateChildKindSet = aggregateChildKindSet;
            this.before = before;
            this.after = after;
        }

        public final Modifier.Node getNode() {
            return this.node;
        }

        public final void setNode(Modifier.Node node) {
            Intrinsics.checkNotNullParameter(node, "<set-?>");
            this.node = node;
        }

        public final int getAggregateChildKindSet() {
            return this.aggregateChildKindSet;
        }

        public final void setAggregateChildKindSet(int i) {
            this.aggregateChildKindSet = i;
        }

        public final MutableVector<Modifier.Element> getBefore() {
            return this.before;
        }

        public final void setBefore(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.before = mutableVector;
        }

        public final MutableVector<Modifier.Element> getAfter() {
            return this.after;
        }

        public final void setAfter(MutableVector<Modifier.Element> mutableVector) {
            Intrinsics.checkNotNullParameter(mutableVector, "<set-?>");
            this.after = mutableVector;
        }

        @Override // androidx.compose.p000ui.node.DiffCallback
        public boolean areItemsTheSame(int oldIndex, int newIndex) {
            MutableVector this_$iv = this.before;
            Modifier.Element element = this_$iv.getContent()[oldIndex];
            MutableVector this_$iv2 = this.after;
            return NodeChainKt.reuseActionForModifiers(element, this_$iv2.getContent()[newIndex]) != 0;
        }

        @Override // androidx.compose.p000ui.node.DiffCallback
        public void insert(int atIndex, int newIndex) {
            Modifier.Node child = this.node;
            NodeChain nodeChain = this.this$0;
            MutableVector this_$iv = this.after;
            this.node = nodeChain.createAndInsertNodeAsParent(this_$iv.getContent()[newIndex], child);
            Logger logger = this.this$0.logger;
            if (logger != null) {
                MutableVector this_$iv2 = this.after;
                logger.nodeInserted(atIndex, newIndex, this_$iv2.getContent()[newIndex], child, this.node);
            }
            this.aggregateChildKindSet |= this.node.getKindSet();
            this.node.setAggregateChildKindSet$ui_release(this.aggregateChildKindSet);
        }

        @Override // androidx.compose.p000ui.node.DiffCallback
        public void remove(int oldIndex) {
            Modifier.Node parent = this.node.getParent();
            Intrinsics.checkNotNull(parent);
            this.node = parent;
            Logger logger = this.this$0.logger;
            if (logger != null) {
                MutableVector this_$iv = this.before;
                logger.nodeRemoved(oldIndex, this_$iv.getContent()[oldIndex], this.node);
            }
            this.node = this.this$0.disposeAndRemoveNode(this.node);
        }

        @Override // androidx.compose.p000ui.node.DiffCallback
        public void same(int oldIndex, int newIndex) {
            Modifier.Node parent = this.node.getParent();
            Intrinsics.checkNotNull(parent);
            this.node = parent;
            MutableVector this_$iv = this.before;
            Modifier.Element prev = this_$iv.getContent()[oldIndex];
            MutableVector this_$iv2 = this.after;
            Modifier.Element next = this_$iv2.getContent()[newIndex];
            if (Intrinsics.areEqual(prev, next)) {
                Logger logger = this.this$0.logger;
                if (logger != null) {
                    logger.nodeReused(oldIndex, newIndex, prev, next, this.node);
                }
            } else {
                Modifier.Node beforeUpdate = this.node;
                this.node = this.this$0.updateNodeAndReplaceIfNeeded(prev, next, beforeUpdate);
                Logger logger2 = this.this$0.logger;
                if (logger2 != null) {
                    logger2.nodeUpdated(oldIndex, newIndex, prev, next, beforeUpdate, this.node);
                }
            }
            this.aggregateChildKindSet |= this.node.getKindSet();
            this.node.setAggregateChildKindSet$ui_release(this.aggregateChildKindSet);
        }
    }

    private final void structuralUpdate(MutableVector<Modifier.Element> before, int beforeSize, MutableVector<Modifier.Element> after, int afterSize, Modifier.Node tail) {
        MyersDiffKt.executeDiff(beforeSize, afterSize, getDiffer(tail, before, after));
    }

    private final Modifier.Node replaceNode(Modifier.Node prev, Modifier.Node next) {
        Modifier.Node parent = prev.getParent();
        if (parent != null) {
            next.setParent$ui_release(parent);
            parent.setChild$ui_release(next);
            prev.setParent$ui_release(null);
        }
        Modifier.Node child = prev.getChild();
        if (child != null) {
            next.setChild$ui_release(child);
            child.setParent$ui_release(next);
            prev.setChild$ui_release(null);
        }
        next.updateCoordinator$ui_release(prev.getCoordinator());
        return next;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node disposeAndRemoveNode(Modifier.Node node) {
        if (node.getIsAttached()) {
            node.detach$ui_release();
        }
        return removeNode(node);
    }

    private final Modifier.Node removeNode(Modifier.Node node) {
        Modifier.Node child = node.getChild();
        Modifier.Node parent = node.getParent();
        if (child != null) {
            child.setParent$ui_release(parent);
            node.setChild$ui_release(null);
        }
        if (parent != null) {
            parent.setChild$ui_release(child);
            node.setParent$ui_release(null);
        }
        Intrinsics.checkNotNull(child);
        return child;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node createAndInsertNodeAsParent(Modifier.Element element, Modifier.Node child) {
        BackwardsCompatNode it;
        if (element instanceof ModifierNodeElement) {
            it = ((ModifierNodeElement) element).create();
            it.setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(it));
        } else {
            it = new BackwardsCompatNode(element);
        }
        return insertParent(it, child);
    }

    private final Modifier.Node insertParent(Modifier.Node node, Modifier.Node child) {
        Modifier.Node theParent = child.getParent();
        if (theParent != null) {
            theParent.setChild$ui_release(node);
            node.setParent$ui_release(theParent);
        }
        child.setParent$ui_release(node);
        node.setChild$ui_release(child);
        return node;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Modifier.Node updateNodeAndReplaceIfNeeded(Modifier.Element prev, Modifier.Element next, Modifier.Node node) {
        Modifier.Node updated;
        if ((prev instanceof ModifierNodeElement) && (next instanceof ModifierNodeElement)) {
            updated = NodeChainKt.updateUnsafe((ModifierNodeElement) next, node);
            if (updated != node) {
                node.detach$ui_release();
                Modifier.Node result = replaceNode(node, updated);
                return result;
            }
            return updated;
        }
        if (!(node instanceof BackwardsCompatNode)) {
            throw new IllegalStateException("Check failed.".toString());
        }
        ((BackwardsCompatNode) node).setElement(next);
        return node;
    }

    /* JADX WARN: Type inference failed for: r12v5, types: [T, androidx.compose.ui.Modifier$Node, java.lang.Object] */
    /* renamed from: firstFromHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m3656firstFromHeadaLcG6gQ$ui_release(int type, Function1<? super T, Boolean> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & type) == 0) {
            return null;
        }
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            Modifier.Node node = head;
            if ((node.getKindSet() & type) != 0) {
                Modifier.Node node2 = node;
                Intrinsics.reifiedOperationMarker(3, "T");
                if ((node2 instanceof Object) && block.invoke(node2).booleanValue()) {
                    return node2;
                }
            }
            if ((node.getAggregateChildKindSet() & type) == 0) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: headToTail-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> void m3659headToTailaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & type) == 0) {
            return;
        }
        for (Modifier.Node node$iv$iv = getHead(); node$iv$iv != null; node$iv$iv = node$iv$iv.getChild()) {
            Modifier.Node it$iv = node$iv$iv;
            if ((it$iv.getKindSet() & type) != 0) {
                Modifier.Node it = it$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it instanceof Object) {
                    block.invoke(it);
                }
            }
            if ((it$iv.getAggregateChildKindSet() & type) == 0) {
                return;
            }
        }
    }

    public final void headToTail$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node node$iv = getHead(); node$iv != null; node$iv = node$iv.getChild()) {
            Modifier.Node it = node$iv;
            if ((it.getKindSet() & mask) != 0) {
                block.invoke(it);
            }
            if ((it.getAggregateChildKindSet() & mask) == 0) {
                return;
            }
        }
    }

    public final void headToTail$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getHead(); node != null; node = node.getChild()) {
            block.invoke(node);
        }
    }

    public final void headToTailExclusive$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getHead(); node != null && node != getTail(); node = node.getChild()) {
            block.invoke(node);
        }
    }

    /* renamed from: tailToHead-aLcG6gQ$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> void m3661tailToHeadaLcG6gQ$ui_release(int type, Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & type) == 0) {
            return;
        }
        for (Modifier.Node node$iv$iv = getTail(); node$iv$iv != null; node$iv$iv = node$iv$iv.getParent()) {
            Modifier.Node it$iv = node$iv$iv;
            if ((it$iv.getKindSet() & type) != 0) {
                Modifier.Node it = it$iv;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (it instanceof Object) {
                    block.invoke(it);
                }
            }
        }
    }

    public final void tailToHead$ui_release(int mask, Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if ((getAggregateChildKindSet() & mask) == 0) {
            return;
        }
        for (Modifier.Node node$iv = getTail(); node$iv != null; node$iv = node$iv.getParent()) {
            Modifier.Node it = node$iv;
            if ((it.getKindSet() & mask) != 0) {
                block.invoke(it);
            }
        }
    }

    public final void tailToHead$ui_release(Function1<? super Modifier.Node, Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        for (Modifier.Node node = getTail(); node != null; node = node.getParent()) {
            block.invoke(node);
        }
    }

    /* renamed from: tail-H91voCI$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m3660tailH91voCI$ui_release(int type) {
        if ((getAggregateChildKindSet() & type) == 0) {
            return null;
        }
        for (Modifier.Node tail = getTail(); tail != null; tail = tail.getParent()) {
            Modifier.Node node = tail;
            if ((node.getKindSet() & type) != 0) {
                T t = (T) node;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (t instanceof Object) {
                    return t;
                }
            }
        }
        return null;
    }

    /* renamed from: head-H91voCI$ui_release, reason: not valid java name */
    public final /* synthetic */ <T> T m3658headH91voCI$ui_release(int type) {
        if ((getAggregateChildKindSet() & type) == 0) {
            return null;
        }
        for (Modifier.Node head = getHead(); head != null; head = head.getChild()) {
            Modifier.Node node = head;
            if ((node.getKindSet() & type) != 0) {
                T t = (T) node;
                Intrinsics.reifiedOperationMarker(3, "T");
                if (t instanceof Object) {
                    return t;
                }
            }
            if ((node.getAggregateChildKindSet() & type) == 0) {
                return null;
            }
        }
        return null;
    }

    /* renamed from: has-H91voCI$ui_release, reason: not valid java name */
    public final boolean m3657hasH91voCI$ui_release(int type) {
        return (getAggregateChildKindSet() & type) != 0;
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u2d15 = new StringBuilder();
        $this$toString_u24lambda_u2d15.append("[");
        if (this.head == this.tail) {
            $this$toString_u24lambda_u2d15.append("]");
        } else {
            Modifier.Node node$iv = getHead();
            while (true) {
                if (node$iv == null || node$iv == getTail()) {
                    break;
                }
                Modifier.Node it = node$iv;
                $this$toString_u24lambda_u2d15.append(String.valueOf(it));
                if (it.getChild() == this.tail) {
                    $this$toString_u24lambda_u2d15.append("]");
                    break;
                }
                $this$toString_u24lambda_u2d15.append(",");
                node$iv = node$iv.getChild();
            }
        }
        String sb = $this$toString_u24lambda_u2d15.toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().apply(builderAction).toString()");
        return sb;
    }
}
