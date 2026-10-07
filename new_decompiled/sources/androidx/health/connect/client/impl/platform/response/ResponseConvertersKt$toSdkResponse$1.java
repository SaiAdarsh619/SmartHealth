package androidx.health.connect.client.impl.platform.response;

import android.health.connect.AggregateRecordsResponse;
import android.health.connect.datatypes.AggregationType;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ResponseConverters.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
/* synthetic */ class ResponseConvertersKt$toSdkResponse$1 extends FunctionReferenceImpl implements Function1<AggregationType<Object>, Object> {
    ResponseConvertersKt$toSdkResponse$1(Object obj) {
        super(1, obj, AggregateRecordsResponse.class, "get", "get(Landroid/health/connect/datatypes/AggregationType;)Ljava/lang/Object;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(AggregationType<Object> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((AggregateRecordsResponse) this.receiver).get(p0);
    }
}
