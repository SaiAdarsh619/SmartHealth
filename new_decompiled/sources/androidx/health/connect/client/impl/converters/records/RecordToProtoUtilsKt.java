package androidx.health.connect.client.impl.converters.records;

import androidx.health.connect.client.records.ExerciseLap;
import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.ExerciseSegment;
import androidx.health.connect.client.records.InstantaneousRecord;
import androidx.health.connect.client.records.IntervalRecord;
import androidx.health.connect.client.records.SkinTemperatureRecord;
import androidx.health.connect.client.records.SleepSessionRecord;
import androidx.health.connect.client.records.metadata.Device;
import androidx.health.connect.client.records.metadata.DeviceTypes;
import androidx.health.connect.client.units.Length;
import androidx.health.platform.client.proto.DataProto;
import java.time.Instant;
import java.time.ZoneOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RecordToProtoUtils.kt */
@Metadata(m286d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000\u001a\f\u0010\u0007\u001a\u00020\u0005*\u00020\bH\u0000\u001a\u0014\u0010\t\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH\u0002\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000eH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u000fH\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0010H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0011H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0012H\u0000\u001a\n\u0010\f\u001a\u00020\u0013*\u00020\u0014¨\u0006\u0015"}, m287d2 = {"protoDataType", "Landroidx/health/platform/client/proto/DataProto$DataType;", "dataTypeName", "", "instantaneousProto", "Landroidx/health/platform/client/proto/DataProto$DataPoint$Builder;", "Landroidx/health/connect/client/records/InstantaneousRecord;", "intervalProto", "Landroidx/health/connect/client/records/IntervalRecord;", "setMetadata", "metadata", "Landroidx/health/connect/client/records/metadata/Metadata;", "toProto", "Landroidx/health/platform/client/proto/DataProto$SubTypeDataValue;", "Landroidx/health/connect/client/records/ExerciseLap;", "Landroidx/health/connect/client/records/ExerciseRoute$Location;", "Landroidx/health/connect/client/records/ExerciseSegment;", "Landroidx/health/connect/client/records/SkinTemperatureRecord$Delta;", "Landroidx/health/connect/client/records/SleepSessionRecord$Stage;", "Landroidx/health/platform/client/proto/DataProto$Device;", "Landroidx/health/connect/client/records/metadata/Device;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class RecordToProtoUtilsKt {
    public static final DataProto.DataType protoDataType(String dataTypeName) {
        Intrinsics.checkNotNullParameter(dataTypeName, "dataTypeName");
        DataProto.DataType build = DataProto.DataType.newBuilder().setName(dataTypeName).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder().setName(dataTypeName).build()");
        return build;
    }

    public static final DataProto.DataPoint.Builder instantaneousProto(InstantaneousRecord $this$instantaneousProto) {
        Intrinsics.checkNotNullParameter($this$instantaneousProto, "<this>");
        DataProto.DataPoint.Builder newBuilder = DataProto.DataPoint.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DataProto.DataPoint.Builder builder = setMetadata(newBuilder, $this$instantaneousProto.getMetadata()).setInstantTimeMillis($this$instantaneousProto.getTime().toEpochMilli());
        ZoneOffset it = $this$instantaneousProto.getZoneOffset();
        if (it != null) {
            builder.setZoneOffsetSeconds(it.getTotalSeconds());
        }
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        return builder;
    }

    public static final DataProto.DataPoint.Builder intervalProto(IntervalRecord $this$intervalProto) {
        Intrinsics.checkNotNullParameter($this$intervalProto, "<this>");
        DataProto.DataPoint.Builder newBuilder = DataProto.DataPoint.newBuilder();
        Intrinsics.checkNotNullExpressionValue(newBuilder, "newBuilder()");
        DataProto.DataPoint.Builder builder = setMetadata(newBuilder, $this$intervalProto.getMetadata()).setStartTimeMillis($this$intervalProto.getStartTime().toEpochMilli()).setEndTimeMillis($this$intervalProto.getEndTime().toEpochMilli());
        ZoneOffset it = $this$intervalProto.getStartZoneOffset();
        if (it != null) {
            builder.setStartZoneOffsetSeconds(it.getTotalSeconds());
        }
        ZoneOffset it2 = $this$intervalProto.getEndZoneOffset();
        if (it2 != null) {
            builder.setEndZoneOffsetSeconds(it2.getTotalSeconds());
        }
        Intrinsics.checkNotNullExpressionValue(builder, "builder");
        return builder;
    }

    private static final DataProto.DataPoint.Builder setMetadata(DataProto.DataPoint.Builder $this$setMetadata, androidx.health.connect.client.records.metadata.Metadata metadata) {
        if (!Intrinsics.areEqual(metadata.getId(), "")) {
            $this$setMetadata.setUid(metadata.getId());
        }
        if (metadata.getDataOrigin().getPackageName().length() > 0) {
            $this$setMetadata.setDataOrigin(DataProto.DataOrigin.newBuilder().setApplicationId(metadata.getDataOrigin().getPackageName()).build());
        }
        if (metadata.getLastModifiedTime().isAfter(Instant.EPOCH)) {
            $this$setMetadata.setUpdateTimeMillis(metadata.getLastModifiedTime().toEpochMilli());
        }
        String it = metadata.getClientRecordId();
        if (it != null) {
            $this$setMetadata.setClientId(it);
        }
        if (metadata.getClientRecordVersion() > 0) {
            $this$setMetadata.setClientVersion(metadata.getClientRecordVersion());
        }
        Device it2 = metadata.getDevice();
        if (it2 != null) {
            $this$setMetadata.setDevice(toProto(it2));
        }
        if (metadata.getRecordingMethod() > 0) {
            $this$setMetadata.setRecordingMethod(metadata.getRecordingMethod());
        }
        return $this$setMetadata;
    }

    public static final DataProto.Device toProto(Device $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        DataProto.Device.Builder $this$toProto_u24lambda_u248 = DataProto.Device.newBuilder();
        String it = $this$toProto.getManufacturer();
        if (it != null) {
            $this$toProto_u24lambda_u248.setManufacturer(it);
        }
        String it2 = $this$toProto.getModel();
        if (it2 != null) {
            $this$toProto_u24lambda_u248.setModel(it2);
        }
        $this$toProto_u24lambda_u248.setType(DeviceTypeConvertersKt.getDEVICE_TYPE_INT_TO_STRING_MAP().getOrDefault(Integer.valueOf($this$toProto.getType()), DeviceTypes.UNKNOWN));
        DataProto.Device build = $this$toProto_u24lambda_u248.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .ap…       }\n        .build()");
        return build;
    }

    public static final DataProto.SubTypeDataValue toProto(SkinTemperatureRecord.Delta $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        DataProto.SubTypeDataValue build = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis($this$toProto.getTime().toEpochMilli()).setEndTimeMillis($this$toProto.getTime().toEpochMilli()).putValues("temperatureDelta", ValueExtKt.doubleVal($this$toProto.getDelta().getCelsius())).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…elsius))\n        .build()");
        return build;
    }

    public static final DataProto.SubTypeDataValue toProto(SleepSessionRecord.Stage $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        DataProto.SubTypeDataValue.Builder $this$toProto_u24lambda_u2410 = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis($this$toProto.getStartTime().toEpochMilli()).setEndTimeMillis($this$toProto.getEndTime().toEpochMilli());
        DataProto.Value it = ValueExtKt.enumValFromInt($this$toProto.getStage(), SleepSessionRecord.STAGE_TYPE_INT_TO_STRING_MAP);
        if (it != null) {
            $this$toProto_u24lambda_u2410.putValues("stage", it);
        }
        DataProto.SubTypeDataValue build = $this$toProto_u24lambda_u2410.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…       }\n        .build()");
        return build;
    }

    public static final DataProto.SubTypeDataValue toProto(ExerciseSegment $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        DataProto.SubTypeDataValue build = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis($this$toProto.getStartTime().toEpochMilli()).setEndTimeMillis($this$toProto.getEndTime().toEpochMilli()).putValues("type", ValueExtKt.longVal($this$toProto.getSegmentType())).putValues("reps", ValueExtKt.longVal($this$toProto.getRepetitions())).build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…Long()))\n        .build()");
        return build;
    }

    public static final DataProto.SubTypeDataValue toProto(ExerciseLap $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        DataProto.SubTypeDataValue.Builder $this$toProto_u24lambda_u2412 = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis($this$toProto.getStartTime().toEpochMilli()).setEndTimeMillis($this$toProto.getEndTime().toEpochMilli());
        Length it = $this$toProto.getLength();
        if (it != null) {
            $this$toProto_u24lambda_u2412.putValues("length", ValueExtKt.doubleVal(it.getMeters()));
        }
        DataProto.SubTypeDataValue build = $this$toProto_u24lambda_u2412.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…rs)) } }\n        .build()");
        return build;
    }

    public static final DataProto.SubTypeDataValue toProto(ExerciseRoute.Location $this$toProto) {
        Intrinsics.checkNotNullParameter($this$toProto, "<this>");
        DataProto.SubTypeDataValue.Builder $this$toProto_u24lambda_u2416 = DataProto.SubTypeDataValue.newBuilder().setStartTimeMillis($this$toProto.getTime().toEpochMilli()).setEndTimeMillis($this$toProto.getTime().toEpochMilli()).putValues("latitude", ValueExtKt.doubleVal($this$toProto.getLatitude())).putValues("longitude", ValueExtKt.doubleVal($this$toProto.getLongitude()));
        Length it = $this$toProto.getHorizontalAccuracy();
        if (it != null) {
            $this$toProto_u24lambda_u2416.putValues("horizontal_accuracy", ValueExtKt.doubleVal(it.getMeters()));
        }
        Length it2 = $this$toProto.getVerticalAccuracy();
        if (it2 != null) {
            $this$toProto_u24lambda_u2416.putValues("vertical_accuracy", ValueExtKt.doubleVal(it2.getMeters()));
        }
        Length it3 = $this$toProto.getAltitude();
        if (it3 != null) {
            $this$toProto_u24lambda_u2416.putValues("altitude", ValueExtKt.doubleVal(it3.getMeters()));
        }
        DataProto.SubTypeDataValue build = $this$toProto_u24lambda_u2416.build();
        Intrinsics.checkNotNullExpressionValue(build, "newBuilder()\n        .se…       }\n        .build()");
        return build;
    }
}
