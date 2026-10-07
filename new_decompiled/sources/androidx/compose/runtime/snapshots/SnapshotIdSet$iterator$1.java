package androidx.compose.runtime.snapshots;

import androidx.compose.animation.core.AnimationConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.sequences.SequenceScope;

/* compiled from: SnapshotIdSet.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlin/sequences/SequenceScope;", ""}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
@DebugMetadata(m296c = "androidx.compose.runtime.snapshots.SnapshotIdSet$iterator$1", m297f = "SnapshotIdSet.kt", m298i = {0, 0, 1, 1, 2, 2}, m299l = {295, AnimationConstants.DefaultDurationMillis, 307}, m300m = "invokeSuspend", m301n = {"$this$sequence", "belowBound", "$this$sequence", "index", "$this$sequence", "index"}, m302s = {"L$0", "L$1", "L$0", "I$0", "L$0", "I$0"})
/* loaded from: classes.dex */
final class SnapshotIdSet$iterator$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super Integer>, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ SnapshotIdSet this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapshotIdSet$iterator$1(SnapshotIdSet snapshotIdSet, Continuation<? super SnapshotIdSet$iterator$1> continuation) {
        super(2, continuation);
        this.this$0 = snapshotIdSet;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1 = new SnapshotIdSet$iterator$1(this.this$0, continuation);
        snapshotIdSet$iterator$1.L$0 = obj;
        return snapshotIdSet$iterator$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(SequenceScope<? super Integer> sequenceScope, Continuation<? super Unit> continuation) {
        return ((SnapshotIdSet$iterator$1) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x00da  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0108 -> B:7:0x010d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:14:0x010c -> B:7:0x010d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x00a6 -> B:18:0x00c8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00c4 -> B:18:0x00c8). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:33:0x0083 -> B:30:0x0086). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        SnapshotIdSet$iterator$1 snapshotIdSet$iterator$1;
        SequenceScope $this$sequence;
        int length;
        int[] belowBound;
        int i;
        SequenceScope $this$sequence2;
        int index;
        SequenceScope $this$sequence3;
        int index2;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                snapshotIdSet$iterator$1 = this;
                SequenceScope $this$sequence4 = (SequenceScope) snapshotIdSet$iterator$1.L$0;
                int[] belowBound2 = snapshotIdSet$iterator$1.this$0.belowBound;
                if (belowBound2 != null) {
                    $this$sequence = $this$sequence4;
                    length = belowBound2.length;
                    belowBound = belowBound2;
                    i = 0;
                    if (i < length) {
                        int element = belowBound[i];
                        snapshotIdSet$iterator$1.L$0 = $this$sequence;
                        snapshotIdSet$iterator$1.L$1 = belowBound;
                        snapshotIdSet$iterator$1.I$0 = i;
                        snapshotIdSet$iterator$1.I$1 = length;
                        snapshotIdSet$iterator$1.label = 1;
                        if ($this$sequence.yield(Boxing.boxInt(element), snapshotIdSet$iterator$1) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        i++;
                        if (i < length) {
                            $this$sequence4 = $this$sequence;
                        }
                    }
                }
                if (snapshotIdSet$iterator$1.this$0.lowerSet != 0) {
                    $this$sequence2 = $this$sequence4;
                    index = 0;
                    if (index >= 64) {
                        $this$sequence4 = $this$sequence2;
                    } else {
                        if ((snapshotIdSet$iterator$1.this$0.lowerSet & (1 << index)) != 0) {
                            snapshotIdSet$iterator$1.L$0 = $this$sequence2;
                            snapshotIdSet$iterator$1.L$1 = null;
                            snapshotIdSet$iterator$1.I$0 = index;
                            snapshotIdSet$iterator$1.label = 2;
                            if ($this$sequence2.yield(Boxing.boxInt(snapshotIdSet$iterator$1.this$0.lowerBound + index), snapshotIdSet$iterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        index++;
                        if (index >= 64) {
                        }
                    }
                }
                if (snapshotIdSet$iterator$1.this$0.upperSet != 0) {
                    $this$sequence3 = $this$sequence4;
                    index2 = 0;
                    if (index2 < 64) {
                        if ((snapshotIdSet$iterator$1.this$0.upperSet & (1 << index2)) != 0) {
                            snapshotIdSet$iterator$1.L$0 = $this$sequence3;
                            snapshotIdSet$iterator$1.L$1 = null;
                            snapshotIdSet$iterator$1.I$0 = index2;
                            snapshotIdSet$iterator$1.label = 3;
                            if ($this$sequence3.yield(Boxing.boxInt(index2 + 64 + snapshotIdSet$iterator$1.this$0.lowerBound), snapshotIdSet$iterator$1) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        }
                        index2++;
                        if (index2 < 64) {
                        }
                    }
                }
                return Unit.INSTANCE;
            case 1:
                snapshotIdSet$iterator$1 = this;
                length = snapshotIdSet$iterator$1.I$1;
                i = snapshotIdSet$iterator$1.I$0;
                belowBound = (int[]) snapshotIdSet$iterator$1.L$1;
                $this$sequence = (SequenceScope) snapshotIdSet$iterator$1.L$0;
                ResultKt.throwOnFailure($result);
                i++;
                if (i < length) {
                }
                break;
            case 2:
                snapshotIdSet$iterator$1 = this;
                index = snapshotIdSet$iterator$1.I$0;
                $this$sequence2 = (SequenceScope) snapshotIdSet$iterator$1.L$0;
                ResultKt.throwOnFailure($result);
                index++;
                if (index >= 64) {
                }
                break;
            case 3:
                snapshotIdSet$iterator$1 = this;
                index2 = snapshotIdSet$iterator$1.I$0;
                $this$sequence3 = (SequenceScope) snapshotIdSet$iterator$1.L$0;
                ResultKt.throwOnFailure($result);
                index2++;
                if (index2 < 64) {
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
