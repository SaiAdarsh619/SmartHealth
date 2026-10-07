package androidx.health.connect.client.impl.platform.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.records.SeriesRecord;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResultGroupByDurationAggregator.kt */
@Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001b\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\t\u0010\u0014\u001a\u00020\u0015H\u0096\u0001J\u0015\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0019R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\t\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u001a"}, m287d2 = {"Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessorWithZoneOffset;", "T", "Landroidx/health/connect/client/records/Record;", "Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;", "delegate", "bucketStartTime", "Ljava/time/Instant;", "(Landroidx/health/connect/client/impl/platform/aggregate/AggregationProcessor;Ljava/time/Instant;)V", "getBucketStartTime", "()Ljava/time/Instant;", "minTime", "getMinTime", "setMinTime", "(Ljava/time/Instant;)V", "zoneOffset", "Ljava/time/ZoneOffset;", "getZoneOffset", "()Ljava/time/ZoneOffset;", "setZoneOffset", "(Ljava/time/ZoneOffset;)V", "getProcessedAggregationResult", "Landroidx/health/connect/client/aggregate/AggregationResult;", "processRecord", "", "record", "(Landroidx/health/connect/client/records/Record;)V", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
final class AggregationProcessorWithZoneOffset<T extends Record> implements AggregationProcessor<T> {
    private final Instant bucketStartTime;
    private final AggregationProcessor<T> delegate;
    private Instant minTime;
    private ZoneOffset zoneOffset;

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public AggregationResult getProcessedAggregationResult() {
        return this.delegate.getProcessedAggregationResult();
    }

    public AggregationProcessorWithZoneOffset(AggregationProcessor<T> delegate, Instant bucketStartTime) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        Intrinsics.checkNotNullParameter(bucketStartTime, "bucketStartTime");
        this.delegate = delegate;
        this.bucketStartTime = bucketStartTime;
    }

    public final Instant getBucketStartTime() {
        return this.bucketStartTime;
    }

    public final ZoneOffset getZoneOffset() {
        return this.zoneOffset;
    }

    public final void setZoneOffset(ZoneOffset zoneOffset) {
        this.zoneOffset = zoneOffset;
    }

    public final Instant getMinTime() {
        return this.minTime;
    }

    public final void setMinTime(Instant instant) {
        this.minTime = instant;
    }

    @Override // androidx.health.connect.client.impl.platform.aggregate.AggregationProcessor
    public void processRecord(T record) {
        Instant recordTime;
        ZoneOffset recordZoneOffset;
        Intrinsics.checkNotNullParameter(record, "record");
        if (record instanceof InstantaneousRecord) {
            recordTime = ((InstantaneousRecord) record).getTime();
        } else if (record instanceof SeriesRecord) {
            Iterable $this$filter$iv = ((SeriesRecord) record).getSamples();
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filter$iv) {
                if (AggregatorUtils.INSTANCE.getTime$connect_client_release(element$iv$iv).compareTo(this.bucketStartTime) >= 0) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            Iterator it = ((List) destination$iv$iv).iterator();
            if (!it.hasNext()) {
                throw new NoSuchElementException();
            }
            Object it2 = it.next();
            Instant time$connect_client_release = AggregatorUtils.INSTANCE.getTime$connect_client_release(it2);
            while (it.hasNext()) {
                Object it3 = it.next();
                Instant time$connect_client_release2 = AggregatorUtils.INSTANCE.getTime$connect_client_release(it3);
                if (time$connect_client_release.compareTo(time$connect_client_release2) > 0) {
                    time$connect_client_release = time$connect_client_release2;
                }
            }
            recordTime = time$connect_client_release;
        } else {
            if (!(record instanceof IntervalRecord)) {
                throw new IllegalStateException(("Unsupported record " + record).toString());
            }
            recordTime = ((IntervalRecord) record).getStartTime();
        }
        if (record instanceof InstantaneousRecord) {
            recordZoneOffset = ((InstantaneousRecord) record).getZoneOffset();
        } else {
            if (!(record instanceof IntervalRecord)) {
                throw new IllegalStateException(("Unsupported record " + record).toString());
            }
            recordZoneOffset = ((IntervalRecord) record).getStartZoneOffset();
        }
        if (this.minTime == null || recordTime.compareTo(this.minTime) < 0) {
            this.minTime = recordTime;
            this.zoneOffset = recordZoneOffset;
        }
        this.delegate.processRecord(record);
    }
}
