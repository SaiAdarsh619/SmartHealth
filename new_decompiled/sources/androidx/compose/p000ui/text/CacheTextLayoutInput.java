package androidx.compose.p000ui.text;

import androidx.compose.p000ui.text.style.TextOverflow;
import androidx.compose.p000ui.unit.Constraints;
import androidx.health.connect.client.records.Vo2MaxRecord;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TextMeasurer.kt */
@Metadata(m286d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, m287d2 = {"Landroidx/compose/ui/text/CacheTextLayoutInput;", "", "textLayoutInput", "Landroidx/compose/ui/text/TextLayoutInput;", "(Landroidx/compose/ui/text/TextLayoutInput;)V", "getTextLayoutInput", "()Landroidx/compose/ui/text/TextLayoutInput;", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hashCode", "", "ui-text_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class CacheTextLayoutInput {
    private final TextLayoutInput textLayoutInput;

    public CacheTextLayoutInput(TextLayoutInput textLayoutInput) {
        Intrinsics.checkNotNullParameter(textLayoutInput, "textLayoutInput");
        this.textLayoutInput = textLayoutInput;
    }

    public final TextLayoutInput getTextLayoutInput() {
        return this.textLayoutInput;
    }

    public int hashCode() {
        TextLayoutInput $this$hashCode_u24lambda_u2d0 = this.textLayoutInput;
        int result = $this$hashCode_u24lambda_u2d0.getText().hashCode();
        return (((((((((((((((((((result * 31) + $this$hashCode_u24lambda_u2d0.getStyle().hashCodeLayoutAffectingAttributes$ui_text_release()) * 31) + $this$hashCode_u24lambda_u2d0.getPlaceholders().hashCode()) * 31) + $this$hashCode_u24lambda_u2d0.getMaxLines()) * 31) + Boolean.hashCode($this$hashCode_u24lambda_u2d0.getSoftWrap())) * 31) + TextOverflow.m4296hashCodeimpl($this$hashCode_u24lambda_u2d0.getOverflow())) * 31) + $this$hashCode_u24lambda_u2d0.getDensity().hashCode()) * 31) + $this$hashCode_u24lambda_u2d0.getLayoutDirection().hashCode()) * 31) + $this$hashCode_u24lambda_u2d0.getFontFamilyResolver().hashCode()) * 31) + Integer.hashCode(Constraints.m4338getMaxWidthimpl($this$hashCode_u24lambda_u2d0.getConstraints()))) * 31) + Integer.hashCode(Constraints.m4337getMaxHeightimpl($this$hashCode_u24lambda_u2d0.getConstraints()));
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof CacheTextLayoutInput)) {
            return false;
        }
        TextLayoutInput $this$equals_u24lambda_u2d1 = this.textLayoutInput;
        return Intrinsics.areEqual($this$equals_u24lambda_u2d1.getText(), ((CacheTextLayoutInput) other).textLayoutInput.getText()) && $this$equals_u24lambda_u2d1.getStyle().hasSameLayoutAffectingAttributes(((CacheTextLayoutInput) other).textLayoutInput.getStyle()) && Intrinsics.areEqual($this$equals_u24lambda_u2d1.getPlaceholders(), ((CacheTextLayoutInput) other).textLayoutInput.getPlaceholders()) && $this$equals_u24lambda_u2d1.getMaxLines() == ((CacheTextLayoutInput) other).textLayoutInput.getMaxLines() && $this$equals_u24lambda_u2d1.getSoftWrap() == ((CacheTextLayoutInput) other).textLayoutInput.getSoftWrap() && TextOverflow.m4295equalsimpl0($this$equals_u24lambda_u2d1.getOverflow(), ((CacheTextLayoutInput) other).textLayoutInput.getOverflow()) && Intrinsics.areEqual($this$equals_u24lambda_u2d1.getDensity(), ((CacheTextLayoutInput) other).textLayoutInput.getDensity()) && $this$equals_u24lambda_u2d1.getLayoutDirection() == ((CacheTextLayoutInput) other).textLayoutInput.getLayoutDirection() && $this$equals_u24lambda_u2d1.getFontFamilyResolver() == ((CacheTextLayoutInput) other).textLayoutInput.getFontFamilyResolver() && Constraints.m4338getMaxWidthimpl($this$equals_u24lambda_u2d1.getConstraints()) == Constraints.m4338getMaxWidthimpl(((CacheTextLayoutInput) other).textLayoutInput.getConstraints()) && Constraints.m4337getMaxHeightimpl($this$equals_u24lambda_u2d1.getConstraints()) == Constraints.m4337getMaxHeightimpl(((CacheTextLayoutInput) other).textLayoutInput.getConstraints());
    }
}
