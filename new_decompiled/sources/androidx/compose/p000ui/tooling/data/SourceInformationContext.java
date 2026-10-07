package androidx.compose.p000ui.tooling.data;

import androidx.autofill.HintConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SlotTree.kt */
@UiToolingDataApi
@Metadata(m286d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001BO\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0002\u0010\u000fJ\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u001e\u001a\u00020\u00062\b\u0010\u001f\u001a\u0004\u0018\u00010\u0000R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0010R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0019\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0012R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014¨\u0006 "}, m287d2 = {"Landroidx/compose/ui/tooling/data/SourceInformationContext;", "", HintConstants.AUTOFILL_HINT_NAME, "", "sourceFile", "packageHash", "", "locations", "", "Landroidx/compose/ui/tooling/data/SourceLocationInfo;", "repeatOffset", "parameters", "Landroidx/compose/ui/tooling/data/Parameter;", "isCall", "", "(Ljava/lang/String;Ljava/lang/String;ILjava/util/List;ILjava/util/List;Z)V", "()Z", "getLocations", "()Ljava/util/List;", "getName", "()Ljava/lang/String;", "nextLocation", "getPackageHash", "()I", "getParameters", "getRepeatOffset", "getSourceFile", "nextSourceLocation", "Landroidx/compose/ui/tooling/data/SourceLocation;", "sourceLocation", "callIndex", "parentContext", "ui-tooling-data_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
final class SourceInformationContext {
    private final boolean isCall;
    private final List<SourceLocationInfo> locations;
    private final String name;
    private int nextLocation;
    private final int packageHash;
    private final List<Parameter> parameters;
    private final int repeatOffset;
    private final String sourceFile;

    public SourceInformationContext(String name, String sourceFile, int packageHash, List<SourceLocationInfo> locations, int repeatOffset, List<Parameter> list, boolean isCall) {
        Intrinsics.checkNotNullParameter(locations, "locations");
        this.name = name;
        this.sourceFile = sourceFile;
        this.packageHash = packageHash;
        this.locations = locations;
        this.repeatOffset = repeatOffset;
        this.parameters = list;
        this.isCall = isCall;
    }

    public final String getName() {
        return this.name;
    }

    public final String getSourceFile() {
        return this.sourceFile;
    }

    public final int getPackageHash() {
        return this.packageHash;
    }

    public final List<SourceLocationInfo> getLocations() {
        return this.locations;
    }

    public final int getRepeatOffset() {
        return this.repeatOffset;
    }

    public final List<Parameter> getParameters() {
        return this.parameters;
    }

    /* renamed from: isCall, reason: from getter */
    public final boolean getIsCall() {
        return this.isCall;
    }

    public final SourceLocation nextSourceLocation() {
        if (this.nextLocation >= this.locations.size() && this.repeatOffset >= 0) {
            this.nextLocation = this.repeatOffset;
        }
        if (this.nextLocation < this.locations.size()) {
            List<SourceLocationInfo> list = this.locations;
            int i = this.nextLocation;
            this.nextLocation = i + 1;
            SourceLocationInfo location = list.get(i);
            Integer lineNumber = location.getLineNumber();
            int intValue = lineNumber != null ? lineNumber.intValue() : -1;
            Integer offset = location.getOffset();
            int intValue2 = offset != null ? offset.intValue() : -1;
            Integer length = location.getLength();
            return new SourceLocation(intValue, intValue2, length != null ? length.intValue() : -1, this.sourceFile, this.packageHash);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0079  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final SourceLocation sourceLocation(int callIndex, SourceInformationContext parentContext) {
        String str;
        int i;
        int locationIndex = callIndex;
        if (locationIndex >= this.locations.size() && this.repeatOffset >= 0 && this.repeatOffset < this.locations.size()) {
            locationIndex = ((callIndex - this.repeatOffset) % (this.locations.size() - this.repeatOffset)) + this.repeatOffset;
        }
        Integer num = null;
        if (locationIndex >= this.locations.size()) {
            return null;
        }
        SourceLocationInfo location = this.locations.get(locationIndex);
        Integer lineNumber = location.getLineNumber();
        int intValue = lineNumber != null ? lineNumber.intValue() : -1;
        Integer offset = location.getOffset();
        int intValue2 = offset != null ? offset.intValue() : -1;
        Integer length = location.getLength();
        int intValue3 = length != null ? length.intValue() : -1;
        String str2 = this.sourceFile;
        if (str2 == null) {
            if (parentContext == null) {
                str = null;
                if (this.sourceFile != null) {
                    if (parentContext != null) {
                        i = parentContext.packageHash;
                    }
                    return new SourceLocation(intValue, intValue2, intValue3, str, num != null ? num.intValue() : -1);
                }
                i = this.packageHash;
                num = Integer.valueOf(i);
                return new SourceLocation(intValue, intValue2, intValue3, str, num != null ? num.intValue() : -1);
            }
            str2 = parentContext.sourceFile;
        }
        str = str2;
        if (this.sourceFile != null) {
        }
        num = Integer.valueOf(i);
        return new SourceLocation(intValue, intValue2, intValue3, str, num != null ? num.intValue() : -1);
    }
}
