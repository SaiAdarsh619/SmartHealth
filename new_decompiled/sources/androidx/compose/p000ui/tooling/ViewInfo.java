package androidx.compose.p000ui.tooling;

import androidx.compose.p000ui.tooling.data.SourceLocation;
import androidx.compose.p000ui.unit.IntRect;
import androidx.health.connect.client.records.Vo2MaxRecord;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: ComposeViewAdapter.kt */
@Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0087\b\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\u0002\u0010\fJ\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0003JC\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000bHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010!\u001a\u00020\u001fJ\t\u0010\"\u001a\u00020\u0005HÖ\u0001J\b\u0010#\u001a\u00020\u0003H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00000\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016¨\u0006$"}, m287d2 = {"Landroidx/compose/ui/tooling/ViewInfo;", "", "fileName", "", "lineNumber", "", "bounds", "Landroidx/compose/ui/unit/IntRect;", "location", "Landroidx/compose/ui/tooling/data/SourceLocation;", "children", "", "(Ljava/lang/String;ILandroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/tooling/data/SourceLocation;Ljava/util/List;)V", "getBounds", "()Landroidx/compose/ui/unit/IntRect;", "getChildren", "()Ljava/util/List;", "getFileName", "()Ljava/lang/String;", "getLineNumber", "()I", "getLocation", "()Landroidx/compose/ui/tooling/data/SourceLocation;", "allChildren", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", Vo2MaxRecord.MeasurementMethod.OTHER, "hasBounds", "hashCode", "toString", "ui-tooling_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final /* data */ class ViewInfo {
    public static final int $stable = 8;
    private final IntRect bounds;
    private final List<ViewInfo> children;
    private final String fileName;
    private final int lineNumber;
    private final SourceLocation location;

    public static /* synthetic */ ViewInfo copy$default(ViewInfo viewInfo, String str, int i, IntRect intRect, SourceLocation sourceLocation, List list, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = viewInfo.fileName;
        }
        if ((i2 & 2) != 0) {
            i = viewInfo.lineNumber;
        }
        int i3 = i;
        if ((i2 & 4) != 0) {
            intRect = viewInfo.bounds;
        }
        IntRect intRect2 = intRect;
        if ((i2 & 8) != 0) {
            sourceLocation = viewInfo.location;
        }
        SourceLocation sourceLocation2 = sourceLocation;
        if ((i2 & 16) != 0) {
            list = viewInfo.children;
        }
        return viewInfo.copy(str, i3, intRect2, sourceLocation2, list);
    }

    /* renamed from: component1, reason: from getter */
    public final String getFileName() {
        return this.fileName;
    }

    /* renamed from: component2, reason: from getter */
    public final int getLineNumber() {
        return this.lineNumber;
    }

    /* renamed from: component3, reason: from getter */
    public final IntRect getBounds() {
        return this.bounds;
    }

    /* renamed from: component4, reason: from getter */
    public final SourceLocation getLocation() {
        return this.location;
    }

    public final List<ViewInfo> component5() {
        return this.children;
    }

    public final ViewInfo copy(String fileName, int lineNumber, IntRect bounds, SourceLocation location, List<ViewInfo> children) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(children, "children");
        return new ViewInfo(fileName, lineNumber, bounds, location, children);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) other;
        return Intrinsics.areEqual(this.fileName, viewInfo.fileName) && this.lineNumber == viewInfo.lineNumber && Intrinsics.areEqual(this.bounds, viewInfo.bounds) && Intrinsics.areEqual(this.location, viewInfo.location) && Intrinsics.areEqual(this.children, viewInfo.children);
    }

    public int hashCode() {
        return (((((((this.fileName.hashCode() * 31) + Integer.hashCode(this.lineNumber)) * 31) + this.bounds.hashCode()) * 31) + (this.location == null ? 0 : this.location.hashCode())) * 31) + this.children.hashCode();
    }

    public ViewInfo(String fileName, int lineNumber, IntRect bounds, SourceLocation location, List<ViewInfo> children) {
        Intrinsics.checkNotNullParameter(fileName, "fileName");
        Intrinsics.checkNotNullParameter(bounds, "bounds");
        Intrinsics.checkNotNullParameter(children, "children");
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.bounds = bounds;
        this.location = location;
        this.children = children;
    }

    public final String getFileName() {
        return this.fileName;
    }

    public final int getLineNumber() {
        return this.lineNumber;
    }

    public final IntRect getBounds() {
        return this.bounds;
    }

    public final SourceLocation getLocation() {
        return this.location;
    }

    public final List<ViewInfo> getChildren() {
        return this.children;
    }

    public final boolean hasBounds() {
        return (this.bounds.getBottom() == 0 || this.bounds.getRight() == 0) ? false : true;
    }

    public final List<ViewInfo> allChildren() {
        List<ViewInfo> list = this.children;
        Iterable $this$flatMap$iv = this.children;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$flatMap$iv) {
            ViewInfo it = (ViewInfo) element$iv$iv;
            Iterable list$iv$iv = it.allChildren();
            CollectionsKt.addAll(destination$iv$iv, list$iv$iv);
        }
        return CollectionsKt.plus((Collection) list, destination$iv$iv);
    }

    public String toString() {
        String str;
        StringBuilder append = new StringBuilder().append('(').append(this.fileName).append(':').append(this.lineNumber).append(",\n            |bounds=(top=").append(this.bounds.getTop()).append(", left=").append(this.bounds.getLeft()).append(",\n            |location=");
        SourceLocation it = this.location;
        if (it == null || (str = new StringBuilder().append('(').append(it.getOffset()).append('L').append(it.getLength()).toString()) == null) {
            str = "<none>";
        }
        return StringsKt.trimMargin$default(append.append(str).append("\n            |bottom=").append(this.bounds.getBottom()).append(", right=").append(this.bounds.getRight()).append("),\n            |childrenCount=").append(this.children.size()).append(')').toString(), null, 1, null);
    }
}
