package androidx.health.platform.client.utils;

import android.content.Intent;
import android.os.Bundle;
import androidx.autofill.HintConstants;
import androidx.health.platform.client.proto.AbstractMessageLite;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: IntentExt.kt */
@Metadata(m286d1 = {"\u0000.\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0003\u001a\u001a\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005\u001a@\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0001\"\u0010\b\u0000\u0010\u0007*\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u0002H\u00070\n\u001a \u0010\u000b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u001a(\u0010\u000e\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0014\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\b0\r¨\u0006\u0010"}, m287d2 = {"getByteArraysExtra", "", "", "Landroid/content/Intent;", HintConstants.AUTOFILL_HINT_NAME, "", "getProtoMessages", "T", "Landroidx/health/platform/client/proto/AbstractMessageLite;", "parser", "Lkotlin/Function1;", "putByteArraysExtra", "byteArrays", "", "putProtoMessages", "messages", "connect-client_release"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes14.dex */
public final class IntentExtKt {
    public static final Intent putProtoMessages(Intent $this$putProtoMessages, String name, Collection<? extends AbstractMessageLite<?, ?>> messages) {
        Intrinsics.checkNotNullParameter($this$putProtoMessages, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(messages, "messages");
        Collection<? extends AbstractMessageLite<?, ?>> $this$map$iv = messages;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            AbstractMessageLite it = (AbstractMessageLite) item$iv$iv;
            destination$iv$iv.add(it.toByteArray());
        }
        return putByteArraysExtra($this$putProtoMessages, name, (List) destination$iv$iv);
    }

    public static final Intent putByteArraysExtra(Intent $this$putByteArraysExtra, String name, Collection<byte[]> byteArrays) {
        Intrinsics.checkNotNullParameter($this$putByteArraysExtra, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(byteArrays, "byteArrays");
        Bundle $this$putByteArraysExtra_u24lambda_u242 = new Bundle(byteArrays.size());
        Collection<byte[]> $this$forEachIndexed$iv = byteArrays;
        int index = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            byte[] bytes = (byte[]) item$iv;
            $this$putByteArraysExtra_u24lambda_u242.putByteArray(String.valueOf(index), bytes);
            index = index$iv;
        }
        Unit unit = Unit.INSTANCE;
        Intent putExtra = $this$putByteArraysExtra.putExtra(name, $this$putByteArraysExtra_u24lambda_u242);
        Intrinsics.checkNotNullExpressionValue(putExtra, "putExtra(\n        name,\n…bytes) }\n        },\n    )");
        return putExtra;
    }

    public static final <T extends AbstractMessageLite<?, ?>> List<T> getProtoMessages(Intent $this$getProtoMessages, String name, Function1<? super byte[], ? extends T> parser) {
        Intrinsics.checkNotNullParameter($this$getProtoMessages, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(parser, "parser");
        Iterable byteArraysExtra = getByteArraysExtra($this$getProtoMessages, name);
        if (byteArraysExtra == null) {
            return null;
        }
        Iterable $this$map$iv = byteArraysExtra;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            destination$iv$iv.add(parser.invoke(item$iv$iv));
        }
        return (List) destination$iv$iv;
    }

    public static final List<byte[]> getByteArraysExtra(Intent $this$getByteArraysExtra, String name) {
        Intrinsics.checkNotNullParameter($this$getByteArraysExtra, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Bundle bundle = $this$getByteArraysExtra.getBundleExtra(name);
        if (bundle == null) {
            return null;
        }
        int size = bundle.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            int index = i;
            byte[] byteArray = bundle.getByteArray(String.valueOf(index));
            if (byteArray == null) {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
            Intrinsics.checkNotNullExpressionValue(byteArray, "requireNotNull(bundle.ge…eArray(index.toString()))");
            arrayList.add(byteArray);
        }
        return arrayList;
    }
}
