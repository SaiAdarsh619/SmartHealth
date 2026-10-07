package androidx.health.connect.client;

import androidx.health.connect.client.records.Record;
import androidx.health.connect.client.response.ReadRecordResponse;
import androidx.health.connect.client.time.TimeRangeFilter;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

/* compiled from: HealthConnectClientExt.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086H¢\u0006\u0002\u0010\u0007\u001a:\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0086H¢\u0006\u0002\u0010\f\u001a,\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u000e\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\nH\u0086H¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, m287d2 = {"deleteRecords", "", "T", "Landroidx/health/connect/client/records/Record;", "Landroidx/health/connect/client/HealthConnectClient;", "timeRangeFilter", "Landroidx/health/connect/client/time/TimeRangeFilter;", "(Landroidx/health/connect/client/HealthConnectClient;Landroidx/health/connect/client/time/TimeRangeFilter;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "recordIdsList", "", "", "clientRecordIdsList", "(Landroidx/health/connect/client/HealthConnectClient;Ljava/util/List;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "readRecord", "Landroidx/health/connect/client/response/ReadRecordResponse;", "recordId", "(Landroidx/health/connect/client/HealthConnectClient;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class HealthConnectClientExt {
    public static final /* synthetic */ <T extends Record> Object deleteRecords(HealthConnectClient $this$deleteRecords, List<String> list, List<String> list2, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass<? extends Record> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Record.class);
        InlineMarker.mark(0);
        $this$deleteRecords.deleteRecords(orCreateKotlinClass, list, list2, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <T extends Record> Object deleteRecords(HealthConnectClient $this$deleteRecords, TimeRangeFilter timeRangeFilter, Continuation<? super Unit> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass<? extends Record> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Record.class);
        InlineMarker.mark(0);
        $this$deleteRecords.deleteRecords(orCreateKotlinClass, timeRangeFilter, continuation);
        InlineMarker.mark(1);
        return Unit.INSTANCE;
    }

    public static final /* synthetic */ <T extends Record> Object readRecord(HealthConnectClient $this$readRecord, String recordId, Continuation<? super ReadRecordResponse<T>> continuation) {
        Intrinsics.reifiedOperationMarker(4, "T");
        KClass<T> orCreateKotlinClass = Reflection.getOrCreateKotlinClass(Record.class);
        InlineMarker.mark(0);
        Object readRecord = $this$readRecord.readRecord(orCreateKotlinClass, recordId, continuation);
        InlineMarker.mark(1);
        return readRecord;
    }
}
