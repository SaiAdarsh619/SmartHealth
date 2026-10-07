package androidx.health.connect.client.records;

import androidx.health.connect.client.records.ExerciseRoute;
import androidx.health.connect.client.records.Vo2MaxRecord;
import androidx.health.connect.client.units.Length;
import com.google.common.net.HttpHeaders;
import java.time.Instant;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExerciseRoute.kt */
@Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u000fB\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseRoute;", "", "route", "", "Landroidx/health/connect/client/records/ExerciseRoute$Location;", "(Ljava/util/List;)V", "getRoute", "()Ljava/util/List;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", HttpHeaders.LOCATION, "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class ExerciseRoute {
    private final List<Location> route;

    public ExerciseRoute(List<Location> route) {
        Intrinsics.checkNotNullParameter(route, "route");
        this.route = route;
        Iterable $this$sortedBy$iv = this.route;
        List sortedRoute = CollectionsKt.sortedWith($this$sortedBy$iv, new Comparator() { // from class: androidx.health.connect.client.records.ExerciseRoute$special$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                ExerciseRoute.Location it = (ExerciseRoute.Location) t;
                ExerciseRoute.Location it2 = (ExerciseRoute.Location) t2;
                return ComparisonsKt.compareValues(it.getTime(), it2.getTime());
            }
        });
        int lastIndex = CollectionsKt.getLastIndex(sortedRoute);
        for (int i = 0; i < lastIndex; i++) {
            if (!((Location) sortedRoute.get(i)).getTime().isBefore(((Location) sortedRoute.get(i + 1)).getTime())) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
    }

    public final List<Location> getRoute() {
        return this.route;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other instanceof ExerciseRoute) {
            return Intrinsics.areEqual(this.route, ((ExerciseRoute) other).route);
        }
        return false;
    }

    public int hashCode() {
        return this.route.hashCode();
    }

    public String toString() {
        return "ExerciseRoute(route=" + this.route + ')';
    }

    /* compiled from: ExerciseRoute.kt */
    @Metadata(m286d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cBA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\r¨\u0006\u001d"}, m287d2 = {"Landroidx/health/connect/client/records/ExerciseRoute$Location;", "", "time", "Ljava/time/Instant;", "latitude", "", "longitude", "horizontalAccuracy", "Landroidx/health/connect/client/units/Length;", "verticalAccuracy", "altitude", "(Ljava/time/Instant;DDLandroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Length;Landroidx/health/connect/client/units/Length;)V", "getAltitude", "()Landroidx/health/connect/client/units/Length;", "getHorizontalAccuracy", "getLatitude", "()D", "getLongitude", "getTime", "()Ljava/time/Instant;", "getVerticalAccuracy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "toString", "", "Companion", "connect-client_release"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
    public static final class Location {
        private static final double MAX_LATITUDE = 90.0d;
        private static final double MAX_LONGITUDE = 180.0d;
        private static final double MIN_LATITUDE = -90.0d;
        private static final double MIN_LONGITUDE = -180.0d;
        private final Length altitude;
        private final Length horizontalAccuracy;
        private final double latitude;
        private final double longitude;
        private final Instant time;
        private final Length verticalAccuracy;

        public Location(Instant time, double latitude, double longitude, Length horizontalAccuracy, Length verticalAccuracy, Length altitude) {
            Intrinsics.checkNotNullParameter(time, "time");
            this.time = time;
            this.latitude = latitude;
            this.longitude = longitude;
            this.horizontalAccuracy = horizontalAccuracy;
            this.verticalAccuracy = verticalAccuracy;
            this.altitude = altitude;
            UtilsKt.requireNotLess(Double.valueOf(this.latitude), Double.valueOf(MIN_LATITUDE), "latitude");
            UtilsKt.requireNotMore(Double.valueOf(this.latitude), Double.valueOf(MAX_LATITUDE), "latitude");
            UtilsKt.requireNotLess(Double.valueOf(this.longitude), Double.valueOf(MIN_LONGITUDE), "longitude");
            UtilsKt.requireNotMore(Double.valueOf(this.longitude), Double.valueOf(MAX_LONGITUDE), "longitude");
            Length length = this.horizontalAccuracy;
            if (length != null) {
                UtilsKt.requireNotLess(length, this.horizontalAccuracy.zero$connect_client_release(), "horizontalAccuracy");
            }
            Length length2 = this.verticalAccuracy;
            if (length2 == null) {
                return;
            }
            UtilsKt.requireNotLess(length2, this.verticalAccuracy.zero$connect_client_release(), "verticalAccuracy");
        }

        public /* synthetic */ Location(Instant instant, double d, double d2, Length length, Length length2, Length length3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(instant, d, d2, (i & 8) != 0 ? null : length, (i & 16) != 0 ? null : length2, (i & 32) != 0 ? null : length3);
        }

        public final Instant getTime() {
            return this.time;
        }

        public final double getLatitude() {
            return this.latitude;
        }

        public final double getLongitude() {
            return this.longitude;
        }

        public final Length getHorizontalAccuracy() {
            return this.horizontalAccuracy;
        }

        public final Length getVerticalAccuracy() {
            return this.verticalAccuracy;
        }

        public final Length getAltitude() {
            return this.altitude;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Location) || !Intrinsics.areEqual(this.time, ((Location) other).time)) {
                return false;
            }
            if (this.latitude == ((Location) other).latitude) {
                return ((this.longitude > ((Location) other).longitude ? 1 : (this.longitude == ((Location) other).longitude ? 0 : -1)) == 0) && Intrinsics.areEqual(this.horizontalAccuracy, ((Location) other).horizontalAccuracy) && Intrinsics.areEqual(this.verticalAccuracy, ((Location) other).verticalAccuracy) && Intrinsics.areEqual(this.altitude, ((Location) other).altitude);
            }
            return false;
        }

        public int hashCode() {
            int result = this.time.hashCode();
            int result2 = ((((result * 31) + Double.hashCode(this.latitude)) * 31) + Double.hashCode(this.longitude)) * 31;
            Length length = this.horizontalAccuracy;
            int result3 = (result2 + (length != null ? length.hashCode() : 0)) * 31;
            Length length2 = this.verticalAccuracy;
            int result4 = (result3 + (length2 != null ? length2.hashCode() : 0)) * 31;
            Length length3 = this.altitude;
            return result4 + (length3 != null ? length3.hashCode() : 0);
        }

        public String toString() {
            return "Location(time=" + this.time + ", latitude=" + this.latitude + ", longitude=" + this.longitude + ", horizontalAccuracy=" + this.horizontalAccuracy + ", verticalAccuracy=" + this.verticalAccuracy + ", altitude=" + this.altitude + ')';
        }
    }
}
