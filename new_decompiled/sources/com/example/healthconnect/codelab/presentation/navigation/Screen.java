package com.example.healthconnect.codelab.presentation.navigation;

import com.example.healthconnect.codelab.C0965R;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Screen.kt */
@Metadata(m286d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/navigation/Screen;", "", "route", "", "titleId", "", "hasMenuItem", "", "(Ljava/lang/String;ILjava/lang/String;IZ)V", "getHasMenuItem", "()Z", "getRoute", "()Ljava/lang/String;", "getTitleId", "()I", "Vitals", "EmergencyContacts", "Profile", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes11.dex */
public enum Screen {
    Vitals("vitals", C0965R.string.app_name, true),
    EmergencyContacts("emergency_contacts", C0965R.string.emergency_contacts, true),
    Profile(Scopes.PROFILE, C0965R.string.app_name, true);

    private final boolean hasMenuItem;
    private final String route;
    private final int titleId;

    Screen(String route, int titleId, boolean hasMenuItem) {
        this.route = route;
        this.titleId = titleId;
        this.hasMenuItem = hasMenuItem;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    /* synthetic */ Screen(String str, int i, boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, i, r5);
        boolean z2;
        if ((i2 & 4) == 0) {
            z2 = z;
        } else {
            z2 = true;
        }
    }

    public final String getRoute() {
        return this.route;
    }

    public final int getTitleId() {
        return this.titleId;
    }

    public final boolean getHasMenuItem() {
        return this.hasMenuItem;
    }
}
