package androidx.profileinstaller;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.profileinstaller.ProfileInstaller;

/* loaded from: classes14.dex */
public class ProfileInstallReceiver extends BroadcastReceiver {
    public static final String ACTION_INSTALL_PROFILE = "androidx.profileinstaller.action.INSTALL_PROFILE";
    public static final String ACTION_SKIP_FILE = "androidx.profileinstaller.action.SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION = "EXTRA_SKIP_FILE_OPERATION";
    private static final String EXTRA_SKIP_FILE_OPERATION_DELETE = "DELETE_SKIP_FILE";
    private static final String EXTRA_SKIP_FILE_OPERATION_WRITE = "WRITE_SKIP_FILE";

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            return;
        }
        String action = intent.getAction();
        if (ACTION_INSTALL_PROFILE.equals(action)) {
            ProfileInstaller.writeProfile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics(), true);
            return;
        }
        if (ACTION_SKIP_FILE.equals(action)) {
            Bundle extras = intent.getExtras();
            String operation = extras.getString(EXTRA_SKIP_FILE_OPERATION);
            if (EXTRA_SKIP_FILE_OPERATION_WRITE.equals(operation)) {
                ProfileInstaller.writeSkipFile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics());
            } else if (EXTRA_SKIP_FILE_OPERATION_DELETE.equals(operation)) {
                ProfileInstaller.deleteSkipFile(context, new ProfileInstallReceiver$$ExternalSyntheticLambda0(), new ResultDiagnostics());
            }
        }
    }

    class ResultDiagnostics implements ProfileInstaller.DiagnosticsCallback {
        ResultDiagnostics() {
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onDiagnosticReceived(int code, Object data) {
            ProfileInstaller.LOG_DIAGNOSTICS.onDiagnosticReceived(code, data);
        }

        @Override // androidx.profileinstaller.ProfileInstaller.DiagnosticsCallback
        public void onResultReceived(int code, Object data) {
            ProfileInstaller.LOG_DIAGNOSTICS.onResultReceived(code, data);
            ProfileInstallReceiver.this.setResultCode(code);
        }
    }
}
