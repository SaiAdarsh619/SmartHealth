package androidx.compose.p000ui.text.android;

import android.os.Build;
import android.text.StaticLayout;
import androidx.core.os.BuildCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StaticLayoutFactory.kt */
@Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0017J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\bH\u0017¨\u0006\u000b"}, m287d2 = {"Landroidx/compose/ui/text/android/StaticLayoutFactory23;", "Landroidx/compose/ui/text/android/StaticLayoutFactoryImpl;", "()V", "create", "Landroid/text/StaticLayout;", "params", "Landroidx/compose/ui/text/android/StaticLayoutParams;", "isFallbackLineSpacingEnabled", "", "layout", "useFallbackLineSpacing", "ui-text_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class StaticLayoutFactory23 implements StaticLayoutFactoryImpl {
    @Override // androidx.compose.p000ui.text.android.StaticLayoutFactoryImpl
    public StaticLayout create(StaticLayoutParams params) {
        Intrinsics.checkNotNullParameter(params, "params");
        StaticLayout.Builder $this$create_u24lambda_u2d0 = StaticLayout.Builder.obtain(params.getText(), params.getStart(), params.getEnd(), params.getPaint(), params.getWidth());
        $this$create_u24lambda_u2d0.setTextDirection(params.getTextDir());
        $this$create_u24lambda_u2d0.setAlignment(params.getAlignment());
        $this$create_u24lambda_u2d0.setMaxLines(params.getMaxLines());
        $this$create_u24lambda_u2d0.setEllipsize(params.getEllipsize());
        $this$create_u24lambda_u2d0.setEllipsizedWidth(params.getEllipsizedWidth());
        $this$create_u24lambda_u2d0.setLineSpacing(params.getLineSpacingExtra(), params.getLineSpacingMultiplier());
        $this$create_u24lambda_u2d0.setIncludePad(params.getIncludePadding());
        $this$create_u24lambda_u2d0.setBreakStrategy(params.getBreakStrategy());
        $this$create_u24lambda_u2d0.setHyphenationFrequency(params.getHyphenationFrequency());
        $this$create_u24lambda_u2d0.setIndents(params.getLeftIndents(), params.getRightIndents());
        Intrinsics.checkNotNullExpressionValue($this$create_u24lambda_u2d0, "this");
        StaticLayoutFactory26.setJustificationMode($this$create_u24lambda_u2d0, params.getJustificationMode());
        if (Build.VERSION.SDK_INT >= 28) {
            Intrinsics.checkNotNullExpressionValue($this$create_u24lambda_u2d0, "this");
            StaticLayoutFactory28.setUseLineSpacingFromFallbacks($this$create_u24lambda_u2d0, params.getUseFallbackLineSpacing());
        }
        if (Build.VERSION.SDK_INT >= 33) {
            Intrinsics.checkNotNullExpressionValue($this$create_u24lambda_u2d0, "this");
            StaticLayoutFactory33.setLineBreakConfig($this$create_u24lambda_u2d0, params.getLineBreakStyle(), params.getLineBreakWordStyle());
        }
        StaticLayout build = $this$create_u24lambda_u2d0.build();
        Intrinsics.checkNotNullExpressionValue(build, "obtain(params.text, para…  }\n            }.build()");
        return build;
    }

    @Override // androidx.compose.p000ui.text.android.StaticLayoutFactoryImpl
    public boolean isFallbackLineSpacingEnabled(StaticLayout layout, boolean useFallbackLineSpacing) {
        Intrinsics.checkNotNullParameter(layout, "layout");
        if (BuildCompat.isAtLeastT()) {
            return StaticLayoutFactory33.isFallbackLineSpacingEnabled(layout);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            return useFallbackLineSpacing;
        }
        return false;
    }
}
