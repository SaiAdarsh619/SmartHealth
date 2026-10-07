package androidx.compose.p000ui.modifier;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.node.BackwardsCompatNode;
import androidx.compose.p000ui.node.DelegatableNodeKt;
import androidx.compose.p000ui.node.LayoutNode;
import androidx.compose.p000ui.node.Nodes;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.runtime.collection.MutableVector;
import java.util.HashSet;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ModifierLocalManager.kt */
@Metadata(m286d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u0015\u001a\u00020\u0012J*\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00172\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\t2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0019H\u0002J\u001a\u0010\u001a\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tJ\u0006\u0010\u001b\u001a\u00020\u0012J\u001a\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\b2\n\u0010\u0014\u001a\u0006\u0012\u0002\b\u00030\tR$\u0010\u0005\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR$\u0010\u000e\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0010\u001a\u0018\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, m287d2 = {"Landroidx/compose/ui/modifier/ModifierLocalManager;", "", "owner", "Landroidx/compose/ui/node/Owner;", "(Landroidx/compose/ui/node/Owner;)V", "inserted", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Pair;", "Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/modifier/ModifierLocal;", "invalidated", "", "getOwner", "()Landroidx/compose/ui/node/Owner;", "removed", "Landroidx/compose/ui/node/LayoutNode;", "updated", "insertedProvider", "", "node", "key", "invalidate", "invalidateConsumersOfNodeForKey", "Landroidx/compose/ui/Modifier$Node;", "set", "", "removedProvider", "triggerUpdates", "updatedProvider", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class ModifierLocalManager {
    private final MutableVector<Pair<BackwardsCompatNode, ModifierLocal<?>>> inserted;
    private boolean invalidated;
    private final Owner owner;
    private final MutableVector<Pair<LayoutNode, ModifierLocal<?>>> removed;
    private final MutableVector<Pair<BackwardsCompatNode, ModifierLocal<?>>> updated;

    public ModifierLocalManager(Owner owner) {
        Intrinsics.checkNotNullParameter(owner, "owner");
        this.owner = owner;
        this.inserted = new MutableVector<>(new Pair[16], 0);
        this.updated = new MutableVector<>(new Pair[16], 0);
        this.removed = new MutableVector<>(new Pair[16], 0);
    }

    public final Owner getOwner() {
        return this.owner;
    }

    public final void invalidate() {
        if (!this.invalidated) {
            this.invalidated = true;
            this.owner.registerOnEndApplyChangesListener(new Function0<Unit>() { // from class: androidx.compose.ui.modifier.ModifierLocalManager$invalidate$1
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
                    ModifierLocalManager.this.triggerUpdates();
                }
            });
        }
    }

    public final void triggerUpdates() {
        this.invalidated = false;
        Iterable toUpdate = new HashSet();
        MutableVector this_$iv = this.removed;
        int size$iv = this_$iv.getSize();
        if (size$iv > 0) {
            int i$iv = 0;
            Object[] content$iv = this_$iv.getContent();
            Intrinsics.checkNotNull(content$iv, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                Pair<LayoutNode, ModifierLocal<?>> pair = (Pair) content$iv[i$iv];
                LayoutNode layout = pair.component1();
                ModifierLocal key = pair.component2();
                if (layout.isAttached()) {
                    invalidateConsumersOfNodeForKey(layout.getNodes().getHead(), key, (Set) toUpdate);
                }
                i$iv++;
            } while (i$iv < size$iv);
        }
        this.removed.clear();
        MutableVector this_$iv2 = this.inserted;
        int size$iv2 = this_$iv2.getSize();
        if (size$iv2 > 0) {
            int i$iv2 = 0;
            Object[] content$iv2 = this_$iv2.getContent();
            Intrinsics.checkNotNull(content$iv2, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                Pair<BackwardsCompatNode, ModifierLocal<?>> pair2 = (Pair) content$iv2[i$iv2];
                BackwardsCompatNode node = pair2.component1();
                ModifierLocal key2 = pair2.component2();
                if (node.getIsAttached()) {
                    invalidateConsumersOfNodeForKey(node, key2, (Set) toUpdate);
                }
                i$iv2++;
            } while (i$iv2 < size$iv2);
        }
        this.inserted.clear();
        MutableVector this_$iv3 = this.updated;
        int size$iv3 = this_$iv3.getSize();
        if (size$iv3 > 0) {
            int i$iv3 = 0;
            Object[] content$iv3 = this_$iv3.getContent();
            Intrinsics.checkNotNull(content$iv3, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                Pair<BackwardsCompatNode, ModifierLocal<?>> pair3 = (Pair) content$iv3[i$iv3];
                BackwardsCompatNode node2 = pair3.component1();
                ModifierLocal key3 = pair3.component2();
                if (node2.getIsAttached()) {
                    invalidateConsumersOfNodeForKey(node2, key3, (Set) toUpdate);
                }
                i$iv3++;
            } while (i$iv3 < size$iv3);
        }
        this.updated.clear();
        Iterable $this$forEach$iv = toUpdate;
        for (Object element$iv : $this$forEach$iv) {
            BackwardsCompatNode it = (BackwardsCompatNode) element$iv;
            it.updateModifierLocalConsumer();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void invalidateConsumersOfNodeForKey(Modifier.Node node, ModifierLocal<?> key, Set<BackwardsCompatNode> set) {
        boolean diveDeeper$iv$iv;
        Modifier.Node $this$visitSubtreeIf_u2d6rFNWt0$iv = node;
        int type$iv = Nodes.INSTANCE.m3710getLocalsOLwlOKw();
        if (!$this$visitSubtreeIf_u2d6rFNWt0$iv.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        MutableVector branches$iv$iv = new MutableVector(new Modifier.Node[16], 0);
        Modifier.Node child$iv$iv = $this$visitSubtreeIf_u2d6rFNWt0$iv.getNode().getChild();
        if (child$iv$iv == null) {
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, $this$visitSubtreeIf_u2d6rFNWt0$iv.getNode());
        } else {
            branches$iv$iv.add(child$iv$iv);
        }
        while (branches$iv$iv.isNotEmpty()) {
            Modifier.Node branch$iv$iv = (Modifier.Node) branches$iv$iv.removeAt(branches$iv$iv.getSize() - 1);
            if ((branch$iv$iv.getAggregateChildKindSet() & type$iv) != 0) {
                for (Modifier.Node node$iv$iv = branch$iv$iv; node$iv$iv != null; node$iv$iv = node$iv$iv.getChild()) {
                    if ((node$iv$iv.getKindSet() & type$iv) != 0) {
                        Object obj = node$iv$iv;
                        if (obj instanceof ModifierLocalNode) {
                            ModifierLocalNode it = (ModifierLocalNode) obj;
                            if ((it instanceof BackwardsCompatNode) && (((BackwardsCompatNode) it).getElement() instanceof ModifierLocalConsumer)) {
                                if (((BackwardsCompatNode) it).getReadValues().contains(key)) {
                                    set.add(it);
                                }
                            }
                            diveDeeper$iv$iv = !it.getProvidedValues().contains$ui_release(key);
                        } else {
                            diveDeeper$iv$iv = true;
                        }
                        if (diveDeeper$iv$iv) {
                        }
                    }
                }
            }
            DelegatableNodeKt.addLayoutNodeChildren(branches$iv$iv, branch$iv$iv);
        }
    }

    public final void updatedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        MutableVector this_$iv = this.updated;
        this_$iv.add(TuplesKt.m294to(node, key));
        invalidate();
    }

    public final void insertedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        MutableVector this_$iv = this.inserted;
        this_$iv.add(TuplesKt.m294to(node, key));
        invalidate();
    }

    public final void removedProvider(BackwardsCompatNode node, ModifierLocal<?> key) {
        Intrinsics.checkNotNullParameter(node, "node");
        Intrinsics.checkNotNullParameter(key, "key");
        MutableVector this_$iv = this.removed;
        this_$iv.add(TuplesKt.m294to(DelegatableNodeKt.requireLayoutNode(node), key));
        invalidate();
    }
}
