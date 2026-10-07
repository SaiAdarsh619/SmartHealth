package androidx.health.connect.client.impl.platform.records;

import android.health.connect.datatypes.DataOrigin;
import android.health.connect.datatypes.Device;
import android.health.connect.datatypes.Metadata;
import java.time.Instant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MetadataConverters.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0010\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00020\u0003H\u0000\u001a\u0010\u0010\u0004\u001a\u00060\u0005j\u0002`\u0006*\u00020\u0007H\u0000\u001a\u0010\u0010\b\u001a\u00060\tj\u0002`\n*\u00020\u000bH\u0000\u001a\u0010\u0010\f\u001a\u00020\u0003*\u00060\u0001j\u0002`\u0002H\u0000\u001a\u0010\u0010\r\u001a\u00020\u0007*\u00060\u0005j\u0002`\u0006H\u0000\u001a\u0010\u0010\u000e\u001a\u00020\u000b*\u00060\tj\u0002`\nH\u0000¨\u0006\u000f"}, m287d2 = {"toPlatformDataOrigin", "Landroid/health/connect/datatypes/DataOrigin;", "Landroidx/health/connect/client/impl/platform/records/PlatformDataOrigin;", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "toPlatformDevice", "Landroid/health/connect/datatypes/Device;", "Landroidx/health/connect/client/impl/platform/records/PlatformDevice;", "Landroidx/health/connect/client/records/metadata/Device;", "toPlatformMetadata", "Landroid/health/connect/datatypes/Metadata;", "Landroidx/health/connect/client/impl/platform/records/PlatformMetadata;", "Landroidx/health/connect/client/records/metadata/Metadata;", "toSdkDataOrigin", "toSdkDevice", "toSdkMetadata", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class MetadataConvertersKt {
    public static final androidx.health.connect.client.records.metadata.Metadata toSdkMetadata(android.health.connect.datatypes.Metadata $this$toSdkMetadata) {
        Intrinsics.checkNotNullParameter($this$toSdkMetadata, "<this>");
        String id = $this$toSdkMetadata.getId();
        DataOrigin dataOrigin = $this$toSdkMetadata.getDataOrigin();
        Intrinsics.checkNotNullExpressionValue(dataOrigin, "dataOrigin");
        androidx.health.connect.client.records.metadata.DataOrigin sdkDataOrigin = toSdkDataOrigin(dataOrigin);
        Instant lastModifiedTime = $this$toSdkMetadata.getLastModifiedTime();
        String clientRecordId = $this$toSdkMetadata.getClientRecordId();
        long clientRecordVersion = $this$toSdkMetadata.getClientRecordVersion();
        int sdkRecordingMethod = IntDefMappingsKt.toSdkRecordingMethod($this$toSdkMetadata.getRecordingMethod());
        Device device = $this$toSdkMetadata.getDevice();
        Intrinsics.checkNotNullExpressionValue(device, "device");
        androidx.health.connect.client.records.metadata.Device sdkDevice = toSdkDevice(device);
        Intrinsics.checkNotNullExpressionValue(id, "id");
        Intrinsics.checkNotNullExpressionValue(lastModifiedTime, "lastModifiedTime");
        return new androidx.health.connect.client.records.metadata.Metadata(sdkRecordingMethod, id, sdkDataOrigin, lastModifiedTime, clientRecordId, clientRecordVersion, sdkDevice);
    }

    public static final androidx.health.connect.client.records.metadata.Device toSdkDevice(Device $this$toSdkDevice) {
        Intrinsics.checkNotNullParameter($this$toSdkDevice, "<this>");
        return new androidx.health.connect.client.records.metadata.Device($this$toSdkDevice.getType(), $this$toSdkDevice.getManufacturer(), $this$toSdkDevice.getModel());
    }

    public static final androidx.health.connect.client.records.metadata.DataOrigin toSdkDataOrigin(DataOrigin $this$toSdkDataOrigin) {
        Intrinsics.checkNotNullParameter($this$toSdkDataOrigin, "<this>");
        String packageName = $this$toSdkDataOrigin.getPackageName();
        Intrinsics.checkNotNullExpressionValue(packageName, "packageName");
        return new androidx.health.connect.client.records.metadata.DataOrigin(packageName);
    }

    public static final android.health.connect.datatypes.Metadata toPlatformMetadata(androidx.health.connect.client.records.metadata.Metadata $this$toPlatformMetadata) {
        Device it;
        Intrinsics.checkNotNullParameter($this$toPlatformMetadata, "<this>");
        Metadata.Builder $this$toPlatformMetadata_u24lambda_u241 = new Metadata.Builder();
        androidx.health.connect.client.records.metadata.Device device = $this$toPlatformMetadata.getDevice();
        if (device != null && (it = toPlatformDevice(device)) != null) {
            $this$toPlatformMetadata_u24lambda_u241.setDevice(it);
        }
        $this$toPlatformMetadata_u24lambda_u241.setLastModifiedTime($this$toPlatformMetadata.getLastModifiedTime());
        $this$toPlatformMetadata_u24lambda_u241.setId($this$toPlatformMetadata.getId());
        $this$toPlatformMetadata_u24lambda_u241.setDataOrigin(toPlatformDataOrigin($this$toPlatformMetadata.getDataOrigin()));
        $this$toPlatformMetadata_u24lambda_u241.setClientRecordId($this$toPlatformMetadata.getClientRecordId());
        $this$toPlatformMetadata_u24lambda_u241.setClientRecordVersion($this$toPlatformMetadata.getClientRecordVersion());
        $this$toPlatformMetadata_u24lambda_u241.setRecordingMethod(IntDefMappingsKt.toPlatformRecordingMethod($this$toPlatformMetadata.getRecordingMethod()));
        android.health.connect.datatypes.Metadata build = $this$toPlatformMetadata_u24lambda_u241.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformMetadataBuilder(…       }\n        .build()");
        return build;
    }

    public static final DataOrigin toPlatformDataOrigin(androidx.health.connect.client.records.metadata.DataOrigin $this$toPlatformDataOrigin) {
        Intrinsics.checkNotNullParameter($this$toPlatformDataOrigin, "<this>");
        DataOrigin.Builder $this$toPlatformDataOrigin_u24lambda_u242 = new DataOrigin.Builder();
        $this$toPlatformDataOrigin_u24lambda_u242.setPackageName($this$toPlatformDataOrigin.getPackageName());
        DataOrigin build = $this$toPlatformDataOrigin_u24lambda_u242.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformDataOriginBuilde…me(packageName) }.build()");
        return build;
    }

    public static final Device toPlatformDevice(androidx.health.connect.client.records.metadata.Device $this$toPlatformDevice) {
        Intrinsics.checkNotNullParameter($this$toPlatformDevice, "<this>");
        Device.Builder $this$toPlatformDevice_u24lambda_u245 = new Device.Builder();
        $this$toPlatformDevice_u24lambda_u245.setType($this$toPlatformDevice.getType());
        String it = $this$toPlatformDevice.getManufacturer();
        if (it != null) {
            $this$toPlatformDevice_u24lambda_u245.setManufacturer(it);
        }
        String it2 = $this$toPlatformDevice.getModel();
        if (it2 != null) {
            $this$toPlatformDevice_u24lambda_u245.setModel(it2);
        }
        Device build = $this$toPlatformDevice_u24lambda_u245.build();
        Intrinsics.checkNotNullExpressionValue(build, "PlatformDeviceBuilder()\n…       }\n        .build()");
        return build;
    }
}
