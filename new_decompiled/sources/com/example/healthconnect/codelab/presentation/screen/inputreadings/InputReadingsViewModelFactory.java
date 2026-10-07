package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.example.healthconnect.codelab.data.EmergencyContactsManager;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.data.UserProfileManager;
import com.google.android.gms.location.FusedLocationProviderClient;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ%\u0010\u000b\u001a\u0002H\f\"\b\b\u0000\u0010\f*\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\f0\u000fH\u0016¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/screen/inputreadings/InputReadingsViewModelFactory;", "Landroidx/lifecycle/ViewModelProvider$Factory;", "healthConnectManager", "Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "contactsManager", "Lcom/example/healthconnect/codelab/data/EmergencyContactsManager;", "userProfileManager", "Lcom/example/healthconnect/codelab/data/UserProfileManager;", "fusedLocationClient", "Lcom/google/android/gms/location/FusedLocationProviderClient;", "(Lcom/example/healthconnect/codelab/data/HealthConnectManager;Lcom/example/healthconnect/codelab/data/EmergencyContactsManager;Lcom/example/healthconnect/codelab/data/UserProfileManager;Lcom/google/android/gms/location/FusedLocationProviderClient;)V", "create", "T", "Landroidx/lifecycle/ViewModel;", "modelClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Landroidx/lifecycle/ViewModel;", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes12.dex */
public final class InputReadingsViewModelFactory implements ViewModelProvider.Factory {
    public static final int $stable = 8;
    private final EmergencyContactsManager contactsManager;
    private final FusedLocationProviderClient fusedLocationClient;
    private final HealthConnectManager healthConnectManager;
    private final UserProfileManager userProfileManager;

    public InputReadingsViewModelFactory(HealthConnectManager healthConnectManager, EmergencyContactsManager contactsManager, UserProfileManager userProfileManager, FusedLocationProviderClient fusedLocationClient) {
        Intrinsics.checkNotNullParameter(healthConnectManager, "healthConnectManager");
        Intrinsics.checkNotNullParameter(contactsManager, "contactsManager");
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        Intrinsics.checkNotNullParameter(fusedLocationClient, "fusedLocationClient");
        this.healthConnectManager = healthConnectManager;
        this.contactsManager = contactsManager;
        this.userProfileManager = userProfileManager;
        this.fusedLocationClient = fusedLocationClient;
    }

    @Override // androidx.lifecycle.ViewModelProvider.Factory
    public <T extends ViewModel> T create(Class<T> modelClass) {
        Intrinsics.checkNotNullParameter(modelClass, "modelClass");
        if (modelClass.isAssignableFrom(InputReadingsViewModel.class)) {
            return new InputReadingsViewModel(this.healthConnectManager, this.contactsManager, this.userProfileManager, this.fusedLocationClient);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
