package com.example.healthconnect.codelab.telemetry;

import android.util.Log;
import com.google.android.gms.common.internal.ImagesContract;
import com.google.common.net.HttpHeaders;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p005io.CloseableKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: TelemetryManager.kt */
@Metadata(m286d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004H\u0002J\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, m287d2 = {"Lcom/example/healthconnect/codelab/telemetry/TelemetryManager;", "", "()V", "endpointUrl", "", "isEnabled", "", "postData", "", "jsonData", "send", "snapshot", "Lcom/example/healthconnect/codelab/telemetry/TelemetrySnapshot;", "Lcom/example/healthconnect/codelab/telemetry/UserInfoSnapshot;", "setEnabled", "enabled", "setEndpoint", ImagesContract.URL, "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes6.dex */
public final class TelemetryManager {
    public static final int $stable = 8;
    private String endpointUrl = "https://telementryui.onrender.com/api/telemetry";
    private boolean isEnabled = true;

    public final void setEndpoint(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.endpointUrl = url;
    }

    public final void setEnabled(boolean enabled) {
        this.isEnabled = enabled;
    }

    public final void send(TelemetrySnapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Log.d("Telemetry", "Attempting to send snapshot for " + snapshot.getVitalType());
        if (this.isEnabled) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TelemetryManager$send$1(this, snapshot, null), 3, null);
        } else {
            Log.d("Telemetry", "Telemetry disabled");
        }
    }

    public final void send(UserInfoSnapshot snapshot) {
        Intrinsics.checkNotNullParameter(snapshot, "snapshot");
        Log.d("Telemetry", "Attempting to send USER_INFO");
        if (this.isEnabled) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new TelemetryManager$send$2(this, snapshot, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void postData(String jsonData) {
        URL url = new URL(this.endpointUrl);
        URLConnection openConnection = url.openConnection();
        Intrinsics.checkNotNull(openConnection, "null cannot be cast to non-null type java.net.HttpURLConnection");
        HttpURLConnection conn = (HttpURLConnection) openConnection;
        conn.setRequestMethod("POST");
        conn.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json; charset=UTF-8");
        conn.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
        conn.setDoOutput(true);
        conn.setConnectTimeout(10000);
        conn.setReadTimeout(10000);
        OutputStream outputStream = conn.getOutputStream();
        try {
            OutputStream os = outputStream;
            OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");
            writer.write(jsonData);
            writer.flush();
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(outputStream, null);
            int responseCode = conn.getResponseCode();
            if (200 <= responseCode && responseCode < 300) {
                Log.d("Telemetry", "Data sent successfully: " + responseCode);
            } else {
                Log.w("Telemetry", "Server returned error: " + responseCode);
            }
            conn.disconnect();
        } finally {
        }
    }
}
