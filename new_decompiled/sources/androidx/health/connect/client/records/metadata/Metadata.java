package androidx.health.connect.client.records.metadata;

import androidx.health.connect.client.records.Vo2MaxRecord;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.time.Instant;
import kotlin.annotation.AnnotationRetention;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Metadata.kt */
@kotlin.Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u0000 $2\u00020\u0001:\u0001$BO\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\"\u001a\u00020\u0003H\u0016J\b\u0010#\u001a\u00020\u0005H\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0002\u001a\u00020\u0003¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e¨\u0006%"}, m287d2 = {"Landroidx/health/connect/client/records/metadata/Metadata;", "", "recordingMethod", "", "id", "", "dataOrigin", "Landroidx/health/connect/client/records/metadata/DataOrigin;", "lastModifiedTime", "Ljava/time/Instant;", "clientRecordId", "clientRecordVersion", "", "device", "Landroidx/health/connect/client/records/metadata/Device;", "(ILjava/lang/String;Landroidx/health/connect/client/records/metadata/DataOrigin;Ljava/time/Instant;Ljava/lang/String;JLandroidx/health/connect/client/records/metadata/Device;)V", "getClientRecordId", "()Ljava/lang/String;", "getClientRecordVersion", "()J", "getDataOrigin", "()Landroidx/health/connect/client/records/metadata/DataOrigin;", "getDevice", "()Landroidx/health/connect/client/records/metadata/Device;", "getId", "getLastModifiedTime", "()Ljava/time/Instant;", "getRecordingMethod$annotations", "()V", "getRecordingMethod", "()I", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "toString", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class Metadata {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final String EMPTY_ID = "";
    public static final int RECORDING_METHOD_ACTIVELY_RECORDED = 1;
    public static final int RECORDING_METHOD_AUTOMATICALLY_RECORDED = 2;
    public static final int RECORDING_METHOD_MANUAL_ENTRY = 3;
    public static final int RECORDING_METHOD_UNKNOWN = 0;
    private final String clientRecordId;
    private final long clientRecordVersion;
    private final DataOrigin dataOrigin;
    private final Device device;
    private final String id;
    private final Instant lastModifiedTime;
    private final int recordingMethod;

    public static /* synthetic */ void getRecordingMethod$annotations() {
    }

    public Metadata(int recordingMethod, String id, DataOrigin dataOrigin, Instant lastModifiedTime, String clientRecordId, long clientRecordVersion, Device device) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(dataOrigin, "dataOrigin");
        Intrinsics.checkNotNullParameter(lastModifiedTime, "lastModifiedTime");
        this.recordingMethod = recordingMethod;
        this.id = id;
        this.dataOrigin = dataOrigin;
        this.lastModifiedTime = lastModifiedTime;
        this.clientRecordId = clientRecordId;
        this.clientRecordVersion = clientRecordVersion;
        this.device = device;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ Metadata(int i, String str, DataOrigin dataOrigin, Instant instant, String str2, long j, Device device, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, r0, r2, EPOCH, (i2 & 16) != 0 ? null : str2, (i2 & 32) != 0 ? 0L : j, (i2 & 64) == 0 ? device : null);
        Instant EPOCH;
        String str3 = (i2 & 2) != 0 ? "" : str;
        DataOrigin dataOrigin2 = (i2 & 4) != 0 ? new DataOrigin("") : dataOrigin;
        if ((i2 & 8) != 0) {
            EPOCH = Instant.EPOCH;
            Intrinsics.checkNotNullExpressionValue(EPOCH, "EPOCH");
        } else {
            EPOCH = instant;
        }
    }

    public final int getRecordingMethod() {
        return this.recordingMethod;
    }

    public final String getId() {
        return this.id;
    }

    public final DataOrigin getDataOrigin() {
        return this.dataOrigin;
    }

    public final Instant getLastModifiedTime() {
        return this.lastModifiedTime;
    }

    public final String getClientRecordId() {
        return this.clientRecordId;
    }

    public final long getClientRecordVersion() {
        return this.clientRecordVersion;
    }

    public final Device getDevice() {
        return this.device;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        return (other instanceof Metadata) && Intrinsics.areEqual(this.id, ((Metadata) other).id) && Intrinsics.areEqual(this.dataOrigin, ((Metadata) other).dataOrigin) && Intrinsics.areEqual(this.lastModifiedTime, ((Metadata) other).lastModifiedTime) && Intrinsics.areEqual(this.clientRecordId, ((Metadata) other).clientRecordId) && this.clientRecordVersion == ((Metadata) other).clientRecordVersion && Intrinsics.areEqual(this.device, ((Metadata) other).device) && this.recordingMethod == ((Metadata) other).recordingMethod;
    }

    public int hashCode() {
        int result = this.id.hashCode();
        int result2 = ((((result * 31) + this.dataOrigin.hashCode()) * 31) + this.lastModifiedTime.hashCode()) * 31;
        String str = this.clientRecordId;
        int result3 = (((result2 + (str != null ? str.hashCode() : 0)) * 31) + Long.hashCode(this.clientRecordVersion)) * 31;
        Device device = this.device;
        return ((result3 + (device != null ? device.hashCode() : 0)) * 31) + Integer.hashCode(this.recordingMethod);
    }

    public String toString() {
        return "Metadata(id='" + this.id + "', dataOrigin=" + this.dataOrigin + ", lastModifiedTime=" + this.lastModifiedTime + ", clientRecordId=" + this.clientRecordId + ", clientRecordVersion=" + this.clientRecordVersion + ", device=" + this.device + ", recordingMethod=" + this.recordingMethod + ')';
    }

    /* compiled from: Metadata.kt */
    @kotlin.Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0019B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\"\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007J\u0018\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0007J\u0014\u0010\u0015\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J&\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001c\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u0014\u0010\u0017\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J&\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u00042\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007J\u001c\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, m287d2 = {"Landroidx/health/connect/client/records/metadata/Metadata$Companion;", "", "()V", "EMPTY_ID", "", "RECORDING_METHOD_ACTIVELY_RECORDED", "", "RECORDING_METHOD_AUTOMATICALLY_RECORDED", "RECORDING_METHOD_MANUAL_ENTRY", "RECORDING_METHOD_UNKNOWN", "activelyRecorded", "Landroidx/health/connect/client/records/metadata/Metadata;", "device", "Landroidx/health/connect/client/records/metadata/Device;", "clientRecordId", "clientRecordVersion", "", "activelyRecordedWithId", "id", "autoRecorded", "autoRecordedWithId", "manualEntry", "manualEntryWithId", "unknownRecordingMethod", "unknownRecordingMethodWithId", "RecordingMethod", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Companion {

        /* compiled from: Metadata.kt */
        @kotlin.Metadata(m286d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, m287d2 = {"Landroidx/health/connect/client/records/metadata/Metadata$Companion$RecordingMethod;", "", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
        @Retention(RetentionPolicy.SOURCE)
        @kotlin.annotation.Retention(AnnotationRetention.SOURCE)
        public @interface RecordingMethod {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Metadata activelyRecorded(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new Metadata(1, null, null, null, null, 0L, device, 62, null);
        }

        public static /* synthetic */ Metadata activelyRecorded$default(Companion companion, Device device, String str, long j, int i, Object obj) {
            if ((i & 4) != 0) {
                j = 0;
            }
            return companion.activelyRecorded(device, str, j);
        }

        @JvmStatic
        public final Metadata activelyRecorded(Device device, String clientRecordId, long clientRecordVersion) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return new Metadata(1, null, null, null, clientRecordId, clientRecordVersion, device, 14, null);
        }

        @JvmStatic
        public final Metadata activelyRecorded(Device device, String clientRecordId) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return activelyRecorded$default(this, device, clientRecordId, 0L, 4, null);
        }

        @JvmStatic
        public final Metadata activelyRecordedWithId(String id, Device device) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(device, "device");
            return new Metadata(1, id, null, null, null, 0L, device, 60, null);
        }

        @JvmStatic
        public final Metadata autoRecorded(Device device) {
            Intrinsics.checkNotNullParameter(device, "device");
            return new Metadata(2, null, null, null, null, 0L, device, 62, null);
        }

        public static /* synthetic */ Metadata autoRecorded$default(Companion companion, Device device, String str, long j, int i, Object obj) {
            if ((i & 4) != 0) {
                j = 0;
            }
            return companion.autoRecorded(device, str, j);
        }

        @JvmStatic
        public final Metadata autoRecorded(Device device, String clientRecordId, long clientRecordVersion) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return new Metadata(2, null, null, null, clientRecordId, clientRecordVersion, device, 14, null);
        }

        @JvmStatic
        public final Metadata autoRecorded(Device device, String clientRecordId) {
            Intrinsics.checkNotNullParameter(device, "device");
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return autoRecorded$default(this, device, clientRecordId, 0L, 4, null);
        }

        @JvmStatic
        public final Metadata autoRecordedWithId(String id, Device device) {
            Intrinsics.checkNotNullParameter(id, "id");
            Intrinsics.checkNotNullParameter(device, "device");
            return new Metadata(2, id, null, null, null, 0L, device, 60, null);
        }

        public static /* synthetic */ Metadata manualEntry$default(Companion companion, Device device, int i, Object obj) {
            if ((i & 1) != 0) {
                device = null;
            }
            return companion.manualEntry(device);
        }

        @JvmStatic
        public final Metadata manualEntry(Device device) {
            return new Metadata(3, null, null, null, null, 0L, device, 62, null);
        }

        @JvmStatic
        public final Metadata manualEntry() {
            return manualEntry$default(this, null, 1, null);
        }

        public static /* synthetic */ Metadata manualEntry$default(Companion companion, String str, long j, Device device, int i, Object obj) {
            if ((i & 2) != 0) {
                j = 0;
            }
            if ((i & 4) != 0) {
                device = null;
            }
            return companion.manualEntry(str, j, device);
        }

        @JvmStatic
        public final Metadata manualEntry(String clientRecordId, long clientRecordVersion, Device device) {
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return new Metadata(3, null, null, null, clientRecordId, clientRecordVersion, device, 14, null);
        }

        @JvmStatic
        public final Metadata manualEntry(String clientRecordId) {
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return manualEntry$default(this, clientRecordId, 0L, null, 6, null);
        }

        @JvmStatic
        public final Metadata manualEntry(String clientRecordId, long clientRecordVersion) {
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return manualEntry$default(this, clientRecordId, clientRecordVersion, null, 4, null);
        }

        public static /* synthetic */ Metadata manualEntryWithId$default(Companion companion, String str, Device device, int i, Object obj) {
            if ((i & 2) != 0) {
                device = null;
            }
            return companion.manualEntryWithId(str, device);
        }

        @JvmStatic
        public final Metadata manualEntryWithId(String id, Device device) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Metadata(3, id, null, null, null, 0L, device, 60, null);
        }

        @JvmStatic
        public final Metadata manualEntryWithId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return manualEntryWithId$default(this, id, null, 2, null);
        }

        public static /* synthetic */ Metadata unknownRecordingMethod$default(Companion companion, Device device, int i, Object obj) {
            if ((i & 1) != 0) {
                device = null;
            }
            return companion.unknownRecordingMethod(device);
        }

        @JvmStatic
        public final Metadata unknownRecordingMethod() {
            return unknownRecordingMethod$default(this, null, 1, null);
        }

        @JvmStatic
        public final Metadata unknownRecordingMethod(Device device) {
            return new Metadata(0, null, null, null, null, 0L, device, 62, null);
        }

        public static /* synthetic */ Metadata unknownRecordingMethod$default(Companion companion, String str, long j, Device device, int i, Object obj) {
            if ((i & 2) != 0) {
                j = 0;
            }
            if ((i & 4) != 0) {
                device = null;
            }
            return companion.unknownRecordingMethod(str, j, device);
        }

        @JvmStatic
        public final Metadata unknownRecordingMethod(String clientRecordId, long clientRecordVersion, Device device) {
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return new Metadata(0, null, null, null, clientRecordId, clientRecordVersion, device, 14, null);
        }

        @JvmStatic
        public final Metadata unknownRecordingMethod(String clientRecordId) {
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return unknownRecordingMethod$default(this, clientRecordId, 0L, null, 6, null);
        }

        @JvmStatic
        public final Metadata unknownRecordingMethod(String clientRecordId, long clientRecordVersion) {
            Intrinsics.checkNotNullParameter(clientRecordId, "clientRecordId");
            return unknownRecordingMethod$default(this, clientRecordId, clientRecordVersion, null, 4, null);
        }

        public static /* synthetic */ Metadata unknownRecordingMethodWithId$default(Companion companion, String str, Device device, int i, Object obj) {
            if ((i & 2) != 0) {
                device = null;
            }
            return companion.unknownRecordingMethodWithId(str, device);
        }

        @JvmStatic
        public final Metadata unknownRecordingMethodWithId(String id, Device device) {
            Intrinsics.checkNotNullParameter(id, "id");
            return new Metadata(0, id, null, null, null, 0L, device, 60, null);
        }

        @JvmStatic
        public final Metadata unknownRecordingMethodWithId(String id) {
            Intrinsics.checkNotNullParameter(id, "id");
            return unknownRecordingMethodWithId$default(this, id, null, 2, null);
        }
    }

    @JvmStatic
    public static final Metadata activelyRecorded(Device device) {
        return INSTANCE.activelyRecorded(device);
    }

    @JvmStatic
    public static final Metadata activelyRecorded(Device device, String clientRecordId) {
        return INSTANCE.activelyRecorded(device, clientRecordId);
    }

    @JvmStatic
    public static final Metadata activelyRecorded(Device device, String clientRecordId, long clientRecordVersion) {
        return INSTANCE.activelyRecorded(device, clientRecordId, clientRecordVersion);
    }

    @JvmStatic
    public static final Metadata activelyRecordedWithId(String id, Device device) {
        return INSTANCE.activelyRecordedWithId(id, device);
    }

    @JvmStatic
    public static final Metadata autoRecorded(Device device) {
        return INSTANCE.autoRecorded(device);
    }

    @JvmStatic
    public static final Metadata autoRecorded(Device device, String clientRecordId) {
        return INSTANCE.autoRecorded(device, clientRecordId);
    }

    @JvmStatic
    public static final Metadata autoRecorded(Device device, String clientRecordId, long clientRecordVersion) {
        return INSTANCE.autoRecorded(device, clientRecordId, clientRecordVersion);
    }

    @JvmStatic
    public static final Metadata autoRecordedWithId(String id, Device device) {
        return INSTANCE.autoRecordedWithId(id, device);
    }

    @JvmStatic
    public static final Metadata manualEntry() {
        return INSTANCE.manualEntry();
    }

    @JvmStatic
    public static final Metadata manualEntry(Device device) {
        return INSTANCE.manualEntry(device);
    }

    @JvmStatic
    public static final Metadata manualEntry(String clientRecordId) {
        return INSTANCE.manualEntry(clientRecordId);
    }

    @JvmStatic
    public static final Metadata manualEntry(String clientRecordId, long clientRecordVersion) {
        return INSTANCE.manualEntry(clientRecordId, clientRecordVersion);
    }

    @JvmStatic
    public static final Metadata manualEntry(String clientRecordId, long clientRecordVersion, Device device) {
        return INSTANCE.manualEntry(clientRecordId, clientRecordVersion, device);
    }

    @JvmStatic
    public static final Metadata manualEntryWithId(String id) {
        return INSTANCE.manualEntryWithId(id);
    }

    @JvmStatic
    public static final Metadata manualEntryWithId(String id, Device device) {
        return INSTANCE.manualEntryWithId(id, device);
    }

    @JvmStatic
    public static final Metadata unknownRecordingMethod() {
        return INSTANCE.unknownRecordingMethod();
    }

    @JvmStatic
    public static final Metadata unknownRecordingMethod(Device device) {
        return INSTANCE.unknownRecordingMethod(device);
    }

    @JvmStatic
    public static final Metadata unknownRecordingMethod(String clientRecordId) {
        return INSTANCE.unknownRecordingMethod(clientRecordId);
    }

    @JvmStatic
    public static final Metadata unknownRecordingMethod(String clientRecordId, long clientRecordVersion) {
        return INSTANCE.unknownRecordingMethod(clientRecordId, clientRecordVersion);
    }

    @JvmStatic
    public static final Metadata unknownRecordingMethod(String clientRecordId, long clientRecordVersion, Device device) {
        return INSTANCE.unknownRecordingMethod(clientRecordId, clientRecordVersion, device);
    }

    @JvmStatic
    public static final Metadata unknownRecordingMethodWithId(String id) {
        return INSTANCE.unknownRecordingMethodWithId(id);
    }

    @JvmStatic
    public static final Metadata unknownRecordingMethodWithId(String id, Device device) {
        return INSTANCE.unknownRecordingMethodWithId(id, device);
    }
}
