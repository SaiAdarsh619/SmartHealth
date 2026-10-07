package com.example.healthconnect.codelab.presentation.screen.profile;

import android.content.Context;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import com.example.healthconnect.codelab.data.UserProfileManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ProfileScreen.kt */
@Metadata(m286d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001f\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, m287d2 = {"ProfileScreen", "", "userProfileManager", "Lcom/example/healthconnect/codelab/data/UserProfileManager;", "systemStatus", "", "(Lcom/example/healthconnect/codelab/data/UserProfileManager;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes9.dex */
public final class ProfileScreenKt {
    public static final void ProfileScreen(final UserProfileManager userProfileManager, String systemStatus, Composer $composer, final int $changed, final int i) {
        String systemStatus2;
        Object value$iv;
        Object value$iv2;
        Object value$iv3;
        Intrinsics.checkNotNullParameter(userProfileManager, "userProfileManager");
        Composer $composer2 = $composer.startRestartGroup(-85198128);
        ComposerKt.sourceInformation($composer2, "C(ProfileScreen)P(1)24@1039L7,26@1052L6790:ProfileScreen.kt#amutfg");
        if ((i & 2) != 0) {
            systemStatus2 = "Checking...";
        } else {
            systemStatus2 = systemStatus;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-85198128, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreen (ProfileScreen.kt:17)");
        }
        Object it$iv = $composer2.rememberedValue();
        if (it$iv == Composer.INSTANCE.getEmpty()) {
            value$iv = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(String.valueOf(userProfileManager.getAge()), null, 2, null);
            $composer2.updateRememberedValue(value$iv);
        } else {
            value$iv = it$iv;
        }
        MutableState age$delegate = (MutableState) value$iv;
        Object it$iv2 = $composer2.rememberedValue();
        if (it$iv2 == Composer.INSTANCE.getEmpty()) {
            value$iv2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(userProfileManager.getGender(), null, 2, null);
            $composer2.updateRememberedValue(value$iv2);
        } else {
            value$iv2 = it$iv2;
        }
        MutableState gender$delegate = (MutableState) value$iv2;
        Object it$iv3 = $composer2.rememberedValue();
        if (it$iv3 == Composer.INSTANCE.getEmpty()) {
            value$iv3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(userProfileManager.getHasHeartCondition()), null, 2, null);
            $composer2.updateRememberedValue(value$iv3);
        } else {
            value$iv3 = it$iv3;
        }
        MutableState hasCondition$delegate = (MutableState) value$iv3;
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
        Object consume = $composer2.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd($composer2);
        Context context = (Context) consume;
        final String systemStatus3 = systemStatus2;
        ScaffoldKt.m1484Scaffold27mzLpw(null, null, ComposableSingletons$ProfileScreenKt.INSTANCE.m4717getLambda2$finished_debug(), null, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.composableLambda($composer2, 835531858, true, new ProfileScreenKt$ProfileScreen$1(age$delegate, systemStatus2, $changed, gender$delegate, hasCondition$delegate, userProfileManager, context)), $composer2, 384, 12582912, 131067);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.profile.ProfileScreenKt$ProfileScreen$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i2) {
                ProfileScreenKt.ProfileScreen(UserProfileManager.this, systemStatus3, composer, $changed | 1, i);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileScreen$lambda$1(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ProfileScreen$lambda$4(MutableState<String> mutableState) {
        MutableState<String> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ProfileScreen$lambda$7(MutableState<Boolean> mutableState) {
        MutableState<Boolean> $this$getValue$iv = mutableState;
        return $this$getValue$iv.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void ProfileScreen$lambda$8(MutableState<Boolean> mutableState, boolean value) {
        mutableState.setValue(Boolean.valueOf(value));
    }
}
