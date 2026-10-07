package androidx.health.connect.client.impl.platform.response;

import android.health.connect.datatypes.Record;
import androidx.health.connect.client.response.InsertRecordsResponse;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
/* compiled from: InsertRecordsResponseConverter.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toKtResponse", "Landroidx/health/connect/client/response/InsertRecordsResponse;", "Landroid/health/connect/InsertRecordsResponse;", "connect-client_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes14.dex */
public final class InsertRecordsResponseConverterKt {
    public static final InsertRecordsResponse toKtResponse(android.health.connect.InsertRecordsResponse $this$toKtResponse) {
        Intrinsics.checkNotNullParameter($this$toKtResponse, "<this>");
        Iterable records = $this$toKtResponse.getRecords();
        Intrinsics.checkNotNullExpressionValue(records, "records");
        Iterable $this$map$iv = records;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            Record record = (Record) item$iv$iv;
            String id = record.getMetadata().getId();
            Intrinsics.checkNotNullExpressionValue(id, "record.metadata.id");
            destination$iv$iv.add(id);
        }
        return new InsertRecordsResponse((List) destination$iv$iv);
    }
}
