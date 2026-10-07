package com.example.healthconnect.codelab.presentation.screen.profile;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.data.UserProfileManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileViewModel.kt */
@Metadata(m286d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J%\u0010\u0007\u001a\u0002H\b\"\b\b\u0000\u0010\b*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0016¢\u0006\u0002\u0010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/profile/ProfileViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "healthConnectManager", "Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "userProfileManager", "Lcom/example/healthconnect/codelab/data/UserProfileManager;", "(Lcom/example/healthconnect/codelab/data/HealthConnectManager;Lcom/example/healthconnect/codelab/data/UserProfileManager;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes9.dex */
public final class ProfileViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final HealthConnectManager healthConnectManager;
    private final UserProfileManager userProfileManager;

    public ProfileViewModelFactory(HealthConnectManager healthConnectManager, UserProfileManager userProfileManager) {
        Intrinsics.checkNotNullParameter(healthConnectManager, "healthConnectManager");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        this.healthConnectManager = healthConnectManager;
        this.userProfileManager = userProfileManager;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(ProfileViewModel.class)) {
            return new ProfileViewModel(this.healthConnectManager, this.userProfileManager);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
