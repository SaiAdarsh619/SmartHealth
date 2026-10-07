package com.example.healthconnect.codelab.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserProfileManager.kt */
@Metadata(m286d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R$\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\r\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R$\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R$\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u0015\"\u0004\b\u001a\u0010\u0017R$\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u00128F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001b\u0010\u0015\"\u0004\b\u001c\u0010\u0017R\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m287d2 = {"Lcom/example/healthconnect/codelab/data/UserProfileManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "value", "", "age", "getAge", "()I", "setAge", "(I)V", "", HintConstants.AUTOFILL_HINT_GENDER, "getGender", "()Ljava/lang/String;", "setGender", "(Ljava/lang/String;)V", "", "hasHeartCondition", "getHasHeartCondition", "()Z", "setHasHeartCondition", "(Z)V", "hasRespiratoryCondition", "getHasRespiratoryCondition", "setHasRespiratoryCondition", "isAthlete", "setAthlete", "prefs", "Landroid/content/SharedPreferences;", "kotlin.jvm.PlatformType", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes8.dex */
public final class UserProfileManager {
    public static final int $stable = 8;
    private final SharedPreferences prefs;

    public UserProfileManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.prefs = context.getSharedPreferences("user_profile_prefs", 0);
    }

    public final int getAge() {
        return this.prefs.getInt("age", 30);
    }

    public final void setAge(int value) {
        SharedPreferences prefs = this.prefs;
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor editor$iv = prefs.edit();
        editor$iv.putInt("age", value);
        editor$iv.apply();
    }

    public final String getGender() {
        String string = this.prefs.getString(HintConstants.AUTOFILL_HINT_GENDER, "Male");
        return string == null ? "Male" : string;
    }

    public final void setGender(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        SharedPreferences prefs = this.prefs;
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor editor$iv = prefs.edit();
        editor$iv.putString(HintConstants.AUTOFILL_HINT_GENDER, value);
        editor$iv.apply();
    }

    public final boolean getHasHeartCondition() {
        return this.prefs.getBoolean("has_heart_condition", false);
    }

    public final void setHasHeartCondition(boolean value) {
        SharedPreferences prefs = this.prefs;
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor editor$iv = prefs.edit();
        editor$iv.putBoolean("has_heart_condition", value);
        editor$iv.apply();
    }

    public final boolean isAthlete() {
        return this.prefs.getBoolean("is_athlete", false);
    }

    public final void setAthlete(boolean value) {
        SharedPreferences prefs = this.prefs;
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor editor$iv = prefs.edit();
        editor$iv.putBoolean("is_athlete", value);
        editor$iv.apply();
    }

    public final boolean getHasRespiratoryCondition() {
        return this.prefs.getBoolean("has_respiratory_condition", false);
    }

    public final void setHasRespiratoryCondition(boolean value) {
        SharedPreferences prefs = this.prefs;
        Intrinsics.checkNotNullExpressionValue(prefs, "prefs");
        SharedPreferences.Editor editor$iv = prefs.edit();
        editor$iv.putBoolean("has_respiratory_condition", value);
        editor$iv.apply();
    }
}
