package androidx.health.connect.client.impl.converters.records;

import androidx.health.connect.client.records.ExerciseLap;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseSegment;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.metadata.DataOrigin;
import androidx.health.connect.client.records.metadata.Device;
import androidx.health.connect.client.units.Length;
import androidx.health.connect.client.units.LengthKt;
import androidx.health.connect.client.units.TemperatureDelta;
import androidx.health.platform.client.proto.DataProto;
import java.time.Instant;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProtoToRecordUtils.kt */
@Metadata(m286d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u001e\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0016H\u0000\u001a\u001e\u0010\u0015\u001a\u00020\u0016*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u0016H\u0000\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u0019*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a\u001e\u0010\u001d\u001a\u00020\u001e*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001eH\u0000\u001a\u001e\u0010\u001d\u001a\u00020\u001e*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001eH\u0000\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0019*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0019*\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0000\u001a0\u0010 \u001a\u00020!*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020!0#2\u0006\u0010$\u001a\u00020!H\u0000\u001a\u0012\u0010%\u001a\b\u0012\u0004\u0012\u00020'0&*\u00020(H\u0000\u001a\f\u0010)\u001a\u00020**\u00020+H\u0000\u001a\u0012\u0010,\u001a\b\u0012\u0004\u0012\u00020-0&*\u00020(H\u0000\u001a\u0012\u0010.\u001a\b\u0012\u0004\u0012\u00020/0&*\u00020(H\u0000\u001a\u0012\u00100\u001a\b\u0012\u0004\u0012\u0002010&*\u00020(H\u0000\u001a\u0012\u00102\u001a\b\u0012\u0004\u0012\u0002030&*\u00020(H\u0000\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0015\u0010\t\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u0004\"\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\b\"\u0015\u0010\u0011\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0004\"\u0017\u0010\u0013\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\b¨\u00064"}, m287d2 = {"endTime", "Ljava/time/Instant;", "Landroidx/health/platform/client/proto/DataProto$DataPoint;", "getEndTime", "(Landroidx/health/platform/client/proto/DataProto$DataPoint;)Ljava/time/Instant;", "endZoneOffset", "Ljava/time/ZoneOffset;", "getEndZoneOffset", "(Landroidx/health/platform/client/proto/DataProto$DataPoint;)Ljava/time/ZoneOffset;", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "getMetadata", "(Landroidx/health/platform/client/proto/DataProto$DataPoint;)Landroidx/health/connect/client/records/metadata/Metadata;", "startTime", "getStartTime", "startZoneOffset", "getStartZoneOffset", "time", "getTime", "zoneOffset", "getZoneOffset", "getDouble", "", "Landroidx/health/platform/client/proto/DataProto$DataPointOrBuilder;", "key", "", "defaultVal", "Landroidx/health/platform/client/proto/DataProto$SeriesValueOrBuilder;", "getEnum", "getLong", "", "getString", "mapEnum", "", "stringToIntMap", "", "default", "toDeltasList", "", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "Landroidx/health/platform/client/proto/DataProto$DataPoint$SubTypeDataList;", "toDevice", "Landroidx/health/connect/client/records/metadata/Device;", "Landroidx/health/platform/client/proto/DataProto$Device;", "toLapList", "Landroidx/health/connect/client/records/ExerciseLap;", "toLocationList", "Landroidx/health/connect/client/records/ExerciseRoute$Location;", "toSegmentList", "Landroidx/health/connect/client/records/ExerciseSegment;", "toStageList", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ProtoToRecordUtilsKt {
    public static final Instant getStartTime(DataProto.DataPoint $this$startTime) {
        Intrinsics.checkNotNullParameter($this$startTime, "<this>");
        Instant ofEpochMilli = Instant.ofEpochMilli($this$startTime.getStartTimeMillis());
        Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(startTimeMillis)");
        return ofEpochMilli;
    }

    public static final Instant getEndTime(DataProto.DataPoint $this$endTime) {
        Intrinsics.checkNotNullParameter($this$endTime, "<this>");
        Instant ofEpochMilli = Instant.ofEpochMilli($this$endTime.getEndTimeMillis());
        Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(endTimeMillis)");
        return ofEpochMilli;
    }

    public static final Instant getTime(DataProto.DataPoint $this$time) {
        Intrinsics.checkNotNullParameter($this$time, "<this>");
        Instant ofEpochMilli = Instant.ofEpochMilli($this$time.getInstantTimeMillis());
        Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(instantTimeMillis)");
        return ofEpochMilli;
    }

    public static final ZoneOffset getStartZoneOffset(DataProto.DataPoint $this$startZoneOffset) {
        Intrinsics.checkNotNullParameter($this$startZoneOffset, "<this>");
        if ($this$startZoneOffset.hasStartZoneOffsetSeconds()) {
            return ZoneOffset.ofTotalSeconds($this$startZoneOffset.getStartZoneOffsetSeconds());
        }
        return null;
    }

    public static final ZoneOffset getEndZoneOffset(DataProto.DataPoint $this$endZoneOffset) {
        Intrinsics.checkNotNullParameter($this$endZoneOffset, "<this>");
        if ($this$endZoneOffset.hasEndZoneOffsetSeconds()) {
            return ZoneOffset.ofTotalSeconds($this$endZoneOffset.getEndZoneOffsetSeconds());
        }
        return null;
    }

    public static final ZoneOffset getZoneOffset(DataProto.DataPoint $this$zoneOffset) {
        Intrinsics.checkNotNullParameter($this$zoneOffset, "<this>");
        if ($this$zoneOffset.hasZoneOffsetSeconds()) {
            return ZoneOffset.ofTotalSeconds($this$zoneOffset.getZoneOffsetSeconds());
        }
        return null;
    }

    public static /* synthetic */ long getLong$default(DataProto.DataPointOrBuilder dataPointOrBuilder, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLong(dataPointOrBuilder, str, j);
    }

    public static final long getLong(DataProto.DataPointOrBuilder $this$getLong, String key, long defaultVal) {
        Intrinsics.checkNotNullParameter($this$getLong, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getLong.getValuesMap().get(key);
        return value != null ? value.getLongVal() : defaultVal;
    }

    public static /* synthetic */ double getDouble$default(DataProto.DataPointOrBuilder dataPointOrBuilder, String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return getDouble(dataPointOrBuilder, str, d);
    }

    public static final double getDouble(DataProto.DataPointOrBuilder $this$getDouble, String key, double defaultVal) {
        Intrinsics.checkNotNullParameter($this$getDouble, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getDouble.getValuesMap().get(key);
        return value != null ? value.getDoubleVal() : defaultVal;
    }

    public static final String getString(DataProto.DataPointOrBuilder $this$getString, String key) {
        Intrinsics.checkNotNullParameter($this$getString, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getString.getValuesMap().get(key);
        if (value != null) {
            return value.getStringVal();
        }
        return null;
    }

    public static final String getEnum(DataProto.DataPointOrBuilder $this$getEnum, String key) {
        Intrinsics.checkNotNullParameter($this$getEnum, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getEnum.getValuesMap().get(key);
        if (value != null) {
            return value.getEnumVal();
        }
        return null;
    }

    public static final int mapEnum(DataProto.DataPointOrBuilder $this$mapEnum, String key, Map<String, Integer> stringToIntMap, int i) {
        Intrinsics.checkNotNullParameter($this$mapEnum, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        Intrinsics.checkNotNullParameter(stringToIntMap, "stringToIntMap");
        String value = getEnum($this$mapEnum, key);
        return value == null ? i : stringToIntMap.getOrDefault(value, Integer.valueOf(i)).intValue();
    }

    public static /* synthetic */ long getLong$default(DataProto.SeriesValueOrBuilder seriesValueOrBuilder, String str, long j, int i, Object obj) {
        if ((i & 2) != 0) {
            j = 0;
        }
        return getLong(seriesValueOrBuilder, str, j);
    }

    public static final long getLong(DataProto.SeriesValueOrBuilder $this$getLong, String key, long defaultVal) {
        Intrinsics.checkNotNullParameter($this$getLong, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getLong.getValuesMap().get(key);
        return value != null ? value.getLongVal() : defaultVal;
    }

    public static /* synthetic */ double getDouble$default(DataProto.SeriesValueOrBuilder seriesValueOrBuilder, String str, double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = 0.0d;
        }
        return getDouble(seriesValueOrBuilder, str, d);
    }

    public static final double getDouble(DataProto.SeriesValueOrBuilder $this$getDouble, String key, double defaultVal) {
        Intrinsics.checkNotNullParameter($this$getDouble, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getDouble.getValuesMap().get(key);
        return value != null ? value.getDoubleVal() : defaultVal;
    }

    public static final String getString(DataProto.SeriesValueOrBuilder $this$getString, String key) {
        Intrinsics.checkNotNullParameter($this$getString, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getString.getValuesMap().get(key);
        if (value != null) {
            return value.getStringVal();
        }
        return null;
    }

    public static final String getEnum(DataProto.SeriesValueOrBuilder $this$getEnum, String key) {
        Intrinsics.checkNotNullParameter($this$getEnum, "<this>");
        Intrinsics.checkNotNullParameter(key, "key");
        DataProto.Value value = $this$getEnum.getValuesMap().get(key);
        if (value != null) {
            return value.getEnumVal();
        }
        return null;
    }

    public static final androidx.health.connect.client.records.metadata.Metadata getMetadata(DataProto.DataPoint $this$metadata) {
        Device device;
        Intrinsics.checkNotNullParameter($this$metadata, "<this>");
        String uid = $this$metadata.hasUid() ? $this$metadata.getUid() : "";
        String applicationId = $this$metadata.getDataOrigin().getApplicationId();
        Intrinsics.checkNotNullExpressionValue(applicationId, "dataOrigin.applicationId");
        DataOrigin dataOrigin = new DataOrigin(applicationId);
        Instant ofEpochMilli = Instant.ofEpochMilli($this$metadata.getUpdateTimeMillis());
        String clientId = $this$metadata.hasClientId() ? $this$metadata.getClientId() : null;
        long clientVersion = $this$metadata.getClientVersion();
        if ($this$metadata.hasDevice()) {
            DataProto.Device device2 = $this$metadata.getDevice();
            Intrinsics.checkNotNullExpressionValue(device2, "device");
            device = toDevice(device2);
        } else {
            device = null;
        }
        int recordingMethod = $this$metadata.getRecordingMethod();
        Intrinsics.checkNotNullExpressionValue(uid, "if (hasUid()) uid else Metadata.EMPTY_ID");
        Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(updateTimeMillis)");
        return new androidx.health.connect.client.records.metadata.Metadata(recordingMethod, uid, dataOrigin, ofEpochMilli, clientId, clientVersion, device);
    }

    public static final Device toDevice(DataProto.Device $this$toDevice) {
        Intrinsics.checkNotNullParameter($this$toDevice, "<this>");
        String manufacturer = $this$toDevice.hasManufacturer() ? $this$toDevice.getManufacturer() : null;
        String model = $this$toDevice.hasModel() ? $this$toDevice.getModel() : null;
        Map<String, Integer> device_type_string_to_int_map = DeviceTypeConvertersKt.getDEVICE_TYPE_STRING_TO_INT_MAP();
        String type = $this$toDevice.getType();
        Intrinsics.checkNotNullExpressionValue(type, "type");
        return new Device(device_type_string_to_int_map.getOrDefault(type, 0).intValue(), manufacturer, model);
    }

    public static final List<SkinTemperatureRecord.Delta> toDeltasList(DataProto.DataPoint.SubTypeDataList $this$toDeltasList) {
        Intrinsics.checkNotNullParameter($this$toDeltasList, "<this>");
        Iterable valuesList = $this$toDeltasList.getValuesList();
        Intrinsics.checkNotNullExpressionValue(valuesList, "valuesList");
        Iterable $this$map$iv = valuesList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DataProto.SubTypeDataValue it = (DataProto.SubTypeDataValue) item$iv$iv;
            Instant ofEpochMilli = Instant.ofEpochMilli(it.getStartTimeMillis());
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(it.startTimeMillis)");
            TemperatureDelta.Companion companion = TemperatureDelta.INSTANCE;
            DataProto.Value value = it.getValuesMap().get("temperatureDelta");
            destination$iv$iv.add(new SkinTemperatureRecord.Delta(ofEpochMilli, companion.celsius(value != null ? value.getDoubleVal() : 0.0d)));
        }
        return (List) destination$iv$iv;
    }

    public static final List<SleepSessionRecord.Stage> toStageList(DataProto.DataPoint.SubTypeDataList $this$toStageList) {
        Intrinsics.checkNotNullParameter($this$toStageList, "<this>");
        Iterable valuesList = $this$toStageList.getValuesList();
        Intrinsics.checkNotNullExpressionValue(valuesList, "valuesList");
        Iterable $this$map$iv = valuesList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DataProto.SubTypeDataValue it = (DataProto.SubTypeDataValue) item$iv$iv;
            Instant ofEpochMilli = Instant.ofEpochMilli(it.getStartTimeMillis());
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(it.startTimeMillis)");
            Instant ofEpochMilli2 = Instant.ofEpochMilli(it.getEndTimeMillis());
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli2, "ofEpochMilli(it.endTimeMillis)");
            Map<String, Integer> map = SleepSessionRecord.STAGE_TYPE_STRING_TO_INT_MAP;
            DataProto.Value value = it.getValuesMap().get("stage");
            Integer num = map.get(value != null ? value.getEnumVal() : null);
            destination$iv$iv.add(new SleepSessionRecord.Stage(ofEpochMilli, ofEpochMilli2, num != null ? num.intValue() : 0));
        }
        return (List) destination$iv$iv;
    }

    public static final List<ExerciseSegment> toSegmentList(DataProto.DataPoint.SubTypeDataList $this$toSegmentList) {
        Intrinsics.checkNotNullParameter($this$toSegmentList, "<this>");
        Iterable valuesList = $this$toSegmentList.getValuesList();
        Intrinsics.checkNotNullExpressionValue(valuesList, "valuesList");
        Iterable $this$map$iv = valuesList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DataProto.SubTypeDataValue it = (DataProto.SubTypeDataValue) item$iv$iv;
            Instant ofEpochMilli = Instant.ofEpochMilli(it.getStartTimeMillis());
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(it.startTimeMillis)");
            Instant ofEpochMilli2 = Instant.ofEpochMilli(it.getEndTimeMillis());
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli2, "ofEpochMilli(it.endTimeMillis)");
            DataProto.Value value = it.getValuesMap().get("type");
            int intValue = (value != null ? Long.valueOf(value.getLongVal()) : 0).intValue();
            DataProto.Value value2 = it.getValuesMap().get("reps");
            destination$iv$iv.add(new ExerciseSegment(ofEpochMilli, ofEpochMilli2, intValue, value2 != null ? (int) value2.getLongVal() : 0));
        }
        return (List) destination$iv$iv;
    }

    public static final List<ExerciseLap> toLapList(DataProto.DataPoint.SubTypeDataList $this$toLapList) {
        Intrinsics.checkNotNullParameter($this$toLapList, "<this>");
        Iterable valuesList = $this$toLapList.getValuesList();
        Intrinsics.checkNotNullExpressionValue(valuesList, "valuesList");
        Iterable $this$map$iv = valuesList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DataProto.SubTypeDataValue it = (DataProto.SubTypeDataValue) item$iv$iv;
            Instant ofEpochMilli = Instant.ofEpochMilli(it.getStartTimeMillis());
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(it.startTimeMillis)");
            Instant ofEpochMilli2 = Instant.ofEpochMilli(it.getEndTimeMillis());
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli2, "ofEpochMilli(it.endTimeMillis)");
            DataProto.Value value = it.getValuesMap().get("length");
            destination$iv$iv.add(new ExerciseLap(ofEpochMilli, ofEpochMilli2, value != null ? LengthKt.getMeters(value.getDoubleVal()) : null));
        }
        return (List) destination$iv$iv;
    }

    public static final List<ExerciseRoute.Location> toLocationList(DataProto.DataPoint.SubTypeDataList $this$toLocationList) {
        Intrinsics.checkNotNullParameter($this$toLocationList, "<this>");
        Iterable valuesList = $this$toLocationList.getValuesList();
        Intrinsics.checkNotNullExpressionValue(valuesList, "valuesList");
        Iterable $this$map$iv = valuesList;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            DataProto.SubTypeDataValue it = (DataProto.SubTypeDataValue) item$iv$iv;
            Instant ofEpochMilli = Instant.ofEpochMilli(it.getStartTimeMillis());
            DataProto.Value value = it.getValuesMap().get("latitude");
            double doubleVal = value != null ? value.getDoubleVal() : 0.0d;
            DataProto.Value value2 = it.getValuesMap().get("longitude");
            double doubleVal2 = value2 != null ? value2.getDoubleVal() : 0.0d;
            DataProto.Value value3 = it.getValuesMap().get("altitude");
            Length meters = value3 != null ? LengthKt.getMeters(value3.getDoubleVal()) : null;
            DataProto.Value value4 = it.getValuesMap().get("horizontal_accuracy");
            Length meters2 = value4 != null ? LengthKt.getMeters(value4.getDoubleVal()) : null;
            DataProto.Value value5 = it.getValuesMap().get("vertical_accuracy");
            Length meters3 = value5 != null ? LengthKt.getMeters(value5.getDoubleVal()) : null;
            Intrinsics.checkNotNullExpressionValue(ofEpochMilli, "ofEpochMilli(it.startTimeMillis)");
            destination$iv$iv.add(new ExerciseRoute.Location(ofEpochMilli, doubleVal, doubleVal2, meters2, meters3, meters));
        }
        return (List) destination$iv$iv;
    }
}
