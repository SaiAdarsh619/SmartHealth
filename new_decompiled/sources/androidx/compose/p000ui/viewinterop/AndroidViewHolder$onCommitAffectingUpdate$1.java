package androidx.compose.p000ui.viewinterop;

import android.os.Handler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

/* compiled from: AndroidViewHolder.android.kt */
@Metadata(m286d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, m287d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "invoke"}, m288k = 3, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class AndroidViewHolder$onCommitAffectingUpdate$1 extends Lambda implements Function1<AndroidViewHolder, Unit> {
    final /* synthetic */ AndroidViewHolder this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidViewHolder$onCommitAffectingUpdate$1(AndroidViewHolder androidViewHolder) {
        super(1);
        this.this$0 = androidViewHolder;
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(AndroidViewHolder androidViewHolder) {
        invoke2(androidViewHolder);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m4619invoke$lambda0(Function0 tmp0) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke();
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(AndroidViewHolder it) {
        final Function0 function0;
        Intrinsics.checkNotNullParameter(it, "it");
        Handler handler = this.this$0.getHandler();
        function0 = this.this$0.runUpdate;
        handler.post(new Runnable() { // from class: androidx.compose.ui.viewinterop.AndroidViewHolder$onCommitAffectingUpdate$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                AndroidViewHolder$onCommitAffectingUpdate$1.m4619invoke$lambda0(Function0.this);
            }
        });
    }
}
