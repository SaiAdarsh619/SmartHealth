package androidx.work;

import android.content.Context;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.UUID;

/* loaded from: classes14.dex */
public interface ProgressUpdater {
    ListenableFuture<Void> updateProgress(Context context, UUID id, Data data);
}
