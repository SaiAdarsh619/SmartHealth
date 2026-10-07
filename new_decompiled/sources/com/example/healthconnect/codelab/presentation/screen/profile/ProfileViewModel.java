package com.example.healthconnect.codelab.presentation.screen.profile;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.data.UserProfileManager;
import com.example.healthconnect.codelab.logic.SmartHealthMonitor;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* compiled from: ProfileViewModel.kt */
@Metadata(m286d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/profile/ProfileViewModel;", "Landroidx/lifecycle/ViewModel;", "healthConnectManager", "Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "userProfileManager", "Lcom/example/healthconnect/codelab/data/UserProfileManager;", "(Lcom/example/healthconnect/codelab/data/HealthConnectManager;Lcom/example/healthconnect/codelab/data/UserProfileManager;)V", "smartMonitor", "Lcom/example/healthconnect/codelab/logic/SmartHealthMonitor;", "<set-?>", "Landroidx/compose/runtime/MutableState;", "", "systemPhaseResult", "getSystemPhaseResult", "()Landroidx/compose/runtime/MutableState;", "getUserProfileManager", "()Lcom/example/healthconnect/codelab/data/UserProfileManager;", "loadSystemStatus", "", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes9.dex */
public final class ProfileViewModel extends ViewModel {
    public static final int $stable = 8;
    private final HealthConnectManager healthConnectManager;
    private final SmartHealthMonitor smartMonitor;
    private MutableState<String> systemPhaseResult;
    private final UserProfileManager userProfileManager;

    public final UserProfileManager getUserProfileManager() {
        return this.userProfileManager;
    }

    public ProfileViewModel(HealthConnectManager healthConnectManager, UserProfileManager userProfileManager) {
        Intrinsics.checkNotNullParameter(healthConnectManager, "healthConnectManager");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        this.healthConnectManager = healthConnectManager;
        this.userProfileManager = userProfileManager;
        this.smartMonitor = new SmartHealthMonitor(this.userProfileManager);
        this.systemPhaseResult = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("Checking System Status...", null, 2, null);
    }

    public final MutableState<String> getSystemPhaseResult() {
        return this.systemPhaseResult;
    }

    public final void loadSystemStatus() {
        BuildersKt__Builders_commonKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new ProfileViewModel$loadSystemStatus$1(this, null), 3, null);
    }
}
