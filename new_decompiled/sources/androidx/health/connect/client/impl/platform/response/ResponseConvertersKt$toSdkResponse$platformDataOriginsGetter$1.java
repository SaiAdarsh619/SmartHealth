package androidx.health.connect.client.impl.platform.response;

import android.health.connect.AggregateRecordsGroupedByDurationResponse;
import android.health.connect.datatypes.AggregationType;
import android.health.connect.datatypes.DataOrigin;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseConverters.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$1 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Set<DataOrigin>> {
    ResponseConvertersKt$toSdkResponse$platformDataOriginsGetter$1(Object obj) {
        super(1, obj, AggregateRecordsGroupedByDurationResponse.class, "getDataOrigins", "getDataOrigins(Landroid/health/connect/datatypes/AggregationType;)Ljava/util/Set;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Set<DataOrigin> invoke(AggregationType<Object> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((AggregateRecordsGroupedByDurationResponse) this.receiver).getDataOrigins(p0);
    }
}
