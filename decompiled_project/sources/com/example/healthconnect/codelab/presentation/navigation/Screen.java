package com.example.healthconnect.codelab.presentation.navigation;

import com.example.healthconnect.codelab.R;
import com.google.android.gms.common.Scopes;
import kotlin.Metadata;
/* compiled from: Screen.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B!\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0012"}, d2 = {"Lcom/example/healthconnect/codelab/presentation/navigation/Screen;", "", "route", "", "titleId", "", "hasMenuItem", "", "(Ljava/lang/String;ILjava/lang/String;IZ)V", "getHasMenuItem", "()Z", "getRoute", "()Ljava/lang/String;", "getTitleId", "()I", "Vitals", "EmergencyContacts", "Profile", "finished_debug"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes11.dex */
public enum Screen {
    Vitals("vitals", R.string.app_name, true),
    EmergencyContacts("emergency_contacts", R.string.emergency_contacts, true),
    Profile(Scopes.PROFILE, R.string.app_name, true);
    
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
        To view partially-correct add '--show-bad-code' argument
    */
    /* synthetic */ Screen(java.lang.String r9, int r10, boolean r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r6 = this;
            r12 = r12 & 4
            if (r12 == 0) goto L7
            r11 = 1
            r5 = r11
            goto L8
        L7:
            r5 = r11
        L8:
            r0 = r6
            r1 = r7
            r2 = r8
            r3 = r9
            r4 = r10
            r0.<init>(r3, r4, r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.healthconnect.codelab.presentation.navigation.Screen.<init>(java.lang.String, int, java.lang.String, int, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
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
