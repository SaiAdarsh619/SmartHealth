package androidx.work.impl.model;

import androidx.autofill.HintConstants;
import androidx.work.WorkInfo;
import androidx.work.impl.model.WorkSpec;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* compiled from: WorkSpecDao.kt */
@Metadata(m286d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a,\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00070\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0000\u001a\u001a\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f\u001a&\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0001\u001a&\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006*\u00020\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u0001\"\u0010\u0010\u0000\u001a\u00020\u00018\u0002X\u0083T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u00018\u0002X\u0083T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u00018\u0002X\u0083T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, m287d2 = {"WORK_INFO_BY_IDS", "", "WORK_INFO_BY_NAME", "WORK_INFO_BY_TAG", "WORK_INFO_COLUMNS", "dedup", "Lkotlinx/coroutines/flow/Flow;", "", "Landroidx/work/WorkInfo;", "Landroidx/work/impl/model/WorkSpec$WorkInfoPojo;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getWorkStatusPojoFlowDataForIds", "Landroidx/work/impl/model/WorkSpecDao;", "id", "Ljava/util/UUID;", "getWorkStatusPojoFlowForName", HintConstants.AUTOFILL_HINT_NAME, "getWorkStatusPojoFlowForTag", "tag", "work-runtime_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class WorkSpecDaoKt {
    private static final String WORK_INFO_BY_IDS = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (:ids)";
    private static final String WORK_INFO_BY_NAME = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN (SELECT work_spec_id FROM workname WHERE name=:name)";
    private static final String WORK_INFO_BY_TAG = "SELECT id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason FROM workspec WHERE id IN\n            (SELECT work_spec_id FROM worktag WHERE tag=:tag)";
    private static final String WORK_INFO_COLUMNS = "id, state, output, run_attempt_count, generation, required_network_type, requires_charging,requires_device_idle, requires_battery_not_low, requires_storage_not_low, trigger_content_update_delay, trigger_max_content_delay, content_uri_triggers, initial_delay, interval_duration, flex_duration, backoff_policy, backoff_delay_duration, last_enqueue_time, period_count, next_schedule_time_override, stop_reason";

    public static final Flow<WorkInfo> getWorkStatusPojoFlowDataForIds(WorkSpecDao $this$getWorkStatusPojoFlowDataForIds, UUID id) {
        Intrinsics.checkNotNullParameter($this$getWorkStatusPojoFlowDataForIds, "<this>");
        Intrinsics.checkNotNullParameter(id, "id");
        final Flow $this$map$iv = $this$getWorkStatusPojoFlowDataForIds.getWorkStatusPojoFlowDataForIds(CollectionsKt.listOf(String.valueOf(id)));
        return FlowKt.distinctUntilChanged(new Flow<WorkInfo>() { // from class: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m287d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2 */
            public static final class C09202<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2", m297f = "WorkSpecDao.kt", m298i = {}, m299l = {223}, m300m = "emit", m301n = {}, m302s = {})
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$getWorkStatusPojoFlowDataForIds$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C09202.this.emit(null, this);
                    }
                }

                public C09202(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    AnonymousClass1 anonymousClass12;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            anonymousClass12 = anonymousClass1;
                            Object $result = anonymousClass12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (anonymousClass12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    List it = (List) value;
                                    WorkSpec.WorkInfoPojo workInfoPojo = (WorkSpec.WorkInfoPojo) CollectionsKt.firstOrNull(it);
                                    WorkInfo workInfo = workInfoPojo != null ? workInfoPojo.toWorkInfo() : null;
                                    anonymousClass12.label = 1;
                                    if (flowCollector.emit(workInfo, anonymousClass12) != coroutine_suspended) {
                                        break;
                                    } else {
                                        return coroutine_suspended;
                                    }
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass12 = anonymousClass1;
                    Object $result2 = anonymousClass12.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass12.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super WorkInfo> flowCollector, Continuation $completion) {
                Object collect = Flow.this.collect(new C09202(flowCollector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
    }

    public static final Flow<List<WorkInfo>> getWorkStatusPojoFlowForName(WorkSpecDao $this$getWorkStatusPojoFlowForName, CoroutineDispatcher dispatcher, String name) {
        Intrinsics.checkNotNullParameter($this$getWorkStatusPojoFlowForName, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(name, "name");
        return dedup($this$getWorkStatusPojoFlowForName.getWorkStatusPojoFlowForName(name), dispatcher);
    }

    public static final Flow<List<WorkInfo>> getWorkStatusPojoFlowForTag(WorkSpecDao $this$getWorkStatusPojoFlowForTag, CoroutineDispatcher dispatcher, String tag) {
        Intrinsics.checkNotNullParameter($this$getWorkStatusPojoFlowForTag, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Intrinsics.checkNotNullParameter(tag, "tag");
        return dedup($this$getWorkStatusPojoFlowForTag.getWorkStatusPojoFlowForTag(tag), dispatcher);
    }

    public static final Flow<List<WorkInfo>> dedup(final Flow<? extends List<WorkSpec.WorkInfoPojo>> flow, CoroutineDispatcher dispatcher) {
        Intrinsics.checkNotNullParameter(flow, "<this>");
        Intrinsics.checkNotNullParameter(dispatcher, "dispatcher");
        Flow $this$map$iv = FlowKt.distinctUntilChanged(new Flow<List<? extends WorkInfo>>() { // from class: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1

            /* compiled from: Emitters.kt */
            @Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u008a@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\b"}, m287d2 = {"<anonymous>", "", "T", "R", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$unsafeTransform$1$1", "kotlinx/coroutines/flow/FlowKt__TransformKt$map$$inlined$unsafeTransform$1$2"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
            /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2 */
            public static final class C09192<T> implements FlowCollector {
                final /* synthetic */ FlowCollector $this_unsafeFlow;

                /* compiled from: Emitters.kt */
                @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
                @DebugMetadata(m296c = "androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2", m297f = "WorkSpecDao.kt", m298i = {}, m299l = {223}, m300m = "emit", m301n = {}, m302s = {})
                /* renamed from: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1, reason: invalid class name */
                public static final class AnonymousClass1 extends ContinuationImpl {
                    Object L$0;
                    int label;
                    /* synthetic */ Object result;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.result = obj;
                        this.label |= Integer.MIN_VALUE;
                        return C09192.this.emit(null, this);
                    }
                }

                public C09192(FlowCollector flowCollector) {
                    this.$this_unsafeFlow = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:11:0x002d  */
                /* JADX WARN: Removed duplicated region for block: B:14:0x0032  */
                /* JADX WARN: Removed duplicated region for block: B:8:0x0025  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public final Object emit(Object value, Continuation continuation) {
                    AnonymousClass1 anonymousClass1;
                    AnonymousClass1 anonymousClass12;
                    if (continuation instanceof AnonymousClass1) {
                        anonymousClass1 = (AnonymousClass1) continuation;
                        if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                            anonymousClass1.label -= Integer.MIN_VALUE;
                            anonymousClass12 = anonymousClass1;
                            Object $result = anonymousClass12.result;
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            switch (anonymousClass12.label) {
                                case 0:
                                    ResultKt.throwOnFailure($result);
                                    FlowCollector flowCollector = this.$this_unsafeFlow;
                                    Iterable list = (List) value;
                                    Iterable $this$map$iv = list;
                                    Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                                    for (Object item$iv$iv : $this$map$iv) {
                                        WorkSpec.WorkInfoPojo pojo = (WorkSpec.WorkInfoPojo) item$iv$iv;
                                        destination$iv$iv.add(pojo.toWorkInfo());
                                    }
                                    anonymousClass12.label = 1;
                                    if (flowCollector.emit((List) destination$iv$iv, anonymousClass12) == coroutine_suspended) {
                                        return coroutine_suspended;
                                    }
                                    break;
                                case 1:
                                    ResultKt.throwOnFailure($result);
                                    break;
                                default:
                                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return Unit.INSTANCE;
                        }
                    }
                    anonymousClass1 = new AnonymousClass1(continuation);
                    anonymousClass12 = anonymousClass1;
                    Object $result2 = anonymousClass12.result;
                    Object coroutine_suspended2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    switch (anonymousClass12.label) {
                    }
                    return Unit.INSTANCE;
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector<? super List<? extends WorkInfo>> flowCollector, Continuation $completion) {
                Object collect = Flow.this.collect(new C09192(flowCollector), $completion);
                return collect == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collect : Unit.INSTANCE;
            }
        });
        return FlowKt.flowOn($this$map$iv, dispatcher);
    }
}
