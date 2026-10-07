package androidx.health.connect.client.impl.converters.aggregate;

import androidx.health.connect.client.aggregate.AggregationResult;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByDuration;
import androidx.health.connect.client.aggregate.AggregationResultGroupedByPeriod;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.platform.client.proto.DataProto;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtoToAggregateDataRow.kt */
@Metadata(m286d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0002\u001a\n\u0010\u0005\u001a\u00020\u0006*\u00020\u0002¨\u0006\u0007"}, m287d2 = {"retrieveAggregateDataRow", "Landroidx/health/connect/client/aggregate/AggregationResult;", "Landroidx/health/platform/client/proto/DataProto$AggregateDataRow;", "toAggregateDataRowGroupByDuration", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByDuration;", "toAggregateDataRowGroupByPeriod", "Landroidx/health/connect/client/aggregate/AggregationResultGroupedByPeriod;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ProtoToAggregateDataRowKt {
    public static final AggregationResultGroupedByDuration toAggregateDataRowGroupByDuration(DataProto.AggregateDataRow $this$toAggregateDataRowGroupByDuration) {
        Intrinsics.checkNotNullParameter($this$toAggregateDataRowGroupByDuration, "<this>");
        if (!$this$toAggregateDataRowGroupByDuration.hasStartTimeEpochMs()) {
            throw new IllegalArgumentException("start time must be set".toString());
        }
        if (!$this$toAggregateDataRowGroupByDuration.hasEndTimeEpochMs()) {
            throw new IllegalArgumentException("end time must be set".toString());
        }
        AggregationResult retrieveAggregateDataRow = retrieveAggregateDataRow($this$toAggregateDataRowGroupByDuration);
        Instant ofEpochMilli = Instant.ofEpochMilli($this$toAggregateDataRowGroupByDuration.getStartTimeEpochMs());
        Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(startTimeEpochMs)");
        Instant ofEpochMilli2 = Instant.ofEpochMilli($this$toAggregateDataRowGroupByDuration.getEndTimeEpochMs());
        Intrinsics.checkNotNullExpressionValue(ofEpochMilli2, "ofEpochMilli(endTimeEpochMs)");
        ZoneOffset ofTotalSeconds = ZoneOffset.ofTotalSeconds($this$toAggregateDataRowGroupByDuration.getZoneOffsetSeconds());
        Intrinsics.checkNotNullExpressionValue(ofTotalSeconds, "ofTotalSeconds(zoneOffsetSeconds)");
        return new AggregationResultGroupedByDuration(retrieveAggregateDataRow, ofEpochMilli, ofEpochMilli2, ofTotalSeconds);
    }

    public static final AggregationResultGroupedByPeriod toAggregateDataRowGroupByPeriod(DataProto.AggregateDataRow $this$toAggregateDataRowGroupByPeriod) {
        Intrinsics.checkNotNullParameter($this$toAggregateDataRowGroupByPeriod, "<this>");
        if (!$this$toAggregateDataRowGroupByPeriod.hasStartLocalDateTime()) {
            throw new IllegalArgumentException("start time must be set".toString());
        }
        if (!$this$toAggregateDataRowGroupByPeriod.hasEndLocalDateTime()) {
            throw new IllegalArgumentException("end time must be set".toString());
        }
        AggregationResult retrieveAggregateDataRow = retrieveAggregateDataRow($this$toAggregateDataRowGroupByPeriod);
        LocalDateTime parse = LocalDateTime.parse($this$toAggregateDataRowGroupByPeriod.getStartLocalDateTime());
        Intrinsics.checkNotNullExpressionValue(parse, "parse(startLocalDateTime)");
        LocalDateTime parse2 = LocalDateTime.parse($this$toAggregateDataRowGroupByPeriod.getEndLocalDateTime());
        Intrinsics.checkNotNullExpressionValue(parse2, "parse(endLocalDateTime)");
        return new AggregationResultGroupedByPeriod(retrieveAggregateDataRow, parse, parse2);
    }

    public static final AggregationResult retrieveAggregateDataRow(DataProto.AggregateDataRow $this$retrieveAggregateDataRow) {
        Intrinsics.checkNotNullParameter($this$retrieveAggregateDataRow, "<this>");
        Map<String, Long> longValuesMap = $this$retrieveAggregateDataRow.getLongValuesMap();
        Intrinsics.checkNotNullExpressionValue(longValuesMap, "longValuesMap");
        Map<String, Double> doubleValuesMap = $this$retrieveAggregateDataRow.getDoubleValuesMap();
        Intrinsics.checkNotNullExpressionValue(doubleValuesMap, "doubleValuesMap");
        Iterable dataOriginsList = $this$retrieveAggregateDataRow.getDataOriginsList();
        Intrinsics.checkNotNullExpressionValue(dataOriginsList, "dataOriginsList");
        Iterable $this$mapTo$iv = dataOriginsList;
        Collection destination$iv = new HashSet();
        for (Object item$iv : $this$mapTo$iv) {
            DataProto.DataOrigin it = (DataProto.DataOrigin) item$iv;
            String applicationId = it.getApplicationId();
            Intrinsics.checkNotNullExpressionValue(applicationId, "it.applicationId");
            destination$iv.add(new DataOrigin(applicationId));
        }
        return new AggregationResult(longValuesMap, doubleValuesMap, (Set) destination$iv);
    }
}
