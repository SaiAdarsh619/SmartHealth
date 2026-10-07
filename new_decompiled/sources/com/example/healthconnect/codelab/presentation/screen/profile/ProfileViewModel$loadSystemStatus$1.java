package com.example.healthconnect.codelab.presentation.screen.profile;

import android.util.Log;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import com.example.healthconnect.codelab.logic.SmartHealthMonitor;
import com.example.healthconnect.codelab.logic.SystemPhase;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ProfileViewModel.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.profile.ProfileViewModel$loadSystemStatus$1", m297f = "ProfileViewModel.kt", m298i = {}, m299l = {37}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes9.dex */
final class ProfileViewModel$loadSystemStatus$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ ProfileViewModel this$0;

    /* compiled from: ProfileViewModel.kt */
    @Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[SystemPhase.values().length];
            try {
                iArr[SystemPhase.COLD_START.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[SystemPhase.HYBRID.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[SystemPhase.PERSONALIZED.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ProfileViewModel$loadSystemStatus$1(ProfileViewModel profileViewModel, Continuation<? super ProfileViewModel$loadSystemStatus$1> continuation) {
        super(2, continuation);
        this.this$0 = profileViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new ProfileViewModel$loadSystemStatus$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((ProfileViewModel$loadSystemStatus$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x0062 A[Catch: Exception -> 0x0118, TryCatch #2 {Exception -> 0x0118, blocks: (B:11:0x005a, B:13:0x0062, B:16:0x006f, B:17:0x00d4, B:18:0x00d7, B:19:0x0114, B:20:0x0117, B:22:0x00e2), top: B:10:0x005a }] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x006f A[Catch: Exception -> 0x0118, TryCatch #2 {Exception -> 0x0118, blocks: (B:11:0x005a, B:13:0x0062, B:16:0x006f, B:17:0x00d4, B:18:0x00d7, B:19:0x0114, B:20:0x0117, B:22:0x00e2), top: B:10:0x005a }] */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object $result) {
        ProfileViewModel$loadSystemStatus$1 profileViewModel$loadSystemStatus$1;
        Exception e;
        ProfileViewModel$loadSystemStatus$1 profileViewModel$loadSystemStatus$12;
        HealthConnectManager healthConnectManager;
        Object heartRateHistory;
        Object $result2;
        List history;
        SmartHealthMonitor smartHealthMonitor;
        SmartHealthMonitor smartHealthMonitor2;
        String baseStatus;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure($result);
                profileViewModel$loadSystemStatus$1 = this;
                profileViewModel$loadSystemStatus$1.this$0.getSystemPhaseResult().setValue("Checking System Status...");
                Instant now = Instant.now();
                Instant startTime = now.minus(30L, (TemporalUnit) ChronoUnit.DAYS);
                try {
                    healthConnectManager = profileViewModel$loadSystemStatus$1.this$0.healthConnectManager;
                    Intrinsics.checkNotNullExpressionValue(startTime, "startTime");
                    Intrinsics.checkNotNullExpressionValue(now, "now");
                    profileViewModel$loadSystemStatus$1.label = 1;
                    heartRateHistory = healthConnectManager.getHeartRateHistory(startTime, now, profileViewModel$loadSystemStatus$1);
                } catch (Exception $result3) {
                    e = $result3;
                    profileViewModel$loadSystemStatus$12 = profileViewModel$loadSystemStatus$1;
                    Log.e("ProfileVM", "Error loading status", e);
                    profileViewModel$loadSystemStatus$12.this$0.getSystemPhaseResult().setValue("Status: Unavailable (Check Permissions)");
                    return Unit.INSTANCE;
                }
                if (heartRateHistory == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = heartRateHistory;
                try {
                    history = (List) $result;
                    if (history.isEmpty()) {
                        smartHealthMonitor = profileViewModel$loadSystemStatus$1.this$0.smartMonitor;
                        double durationDays = smartHealthMonitor.getHistoryDurationDays(history);
                        int count = history.size();
                        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                        String daysStr = String.format("%.1f", Arrays.copyOf(new Object[]{Boxing.boxDouble(durationDays)}, 1));
                        Intrinsics.checkNotNullExpressionValue(daysStr, "format(format, *args)");
                        smartHealthMonitor2 = profileViewModel$loadSystemStatus$1.this$0.smartMonitor;
                        SystemPhase phase = smartHealthMonitor2.getPhase(durationDays, count);
                        Log.d("ProfileVM", "Duration: " + durationDays + " days, Count: " + count + ", Phase: " + phase);
                        switch (WhenMappings.$EnumSwitchMapping$0[phase.ordinal()]) {
                            case 1:
                                baseStatus = "Initialize Mode (Medical Data)";
                                break;
                            case 2:
                                baseStatus = "Learning Mode (Hybrid)";
                                break;
                            case 3:
                                baseStatus = "Personalized Mode (User Data)";
                                break;
                            default:
                                throw new NoWhenBranchMatchedException();
                        }
                        profileViewModel$loadSystemStatus$1.this$0.getSystemPhaseResult().setValue(baseStatus + "\n(History: " + daysStr + " days, " + count + " records)");
                    } else {
                        profileViewModel$loadSystemStatus$1.this$0.getSystemPhaseResult().setValue("Initialize Mode (No Data)");
                    }
                } catch (Exception e2) {
                    ProfileViewModel$loadSystemStatus$1 profileViewModel$loadSystemStatus$13 = profileViewModel$loadSystemStatus$1;
                    e = e2;
                    $result = $result2;
                    profileViewModel$loadSystemStatus$12 = profileViewModel$loadSystemStatus$13;
                    Log.e("ProfileVM", "Error loading status", e);
                    profileViewModel$loadSystemStatus$12.this$0.getSystemPhaseResult().setValue("Status: Unavailable (Check Permissions)");
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            case 1:
                profileViewModel$loadSystemStatus$12 = this;
                try {
                    ResultKt.throwOnFailure($result);
                    profileViewModel$loadSystemStatus$1 = profileViewModel$loadSystemStatus$12;
                    $result2 = $result;
                    history = (List) $result;
                    if (history.isEmpty()) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    Log.e("ProfileVM", "Error loading status", e);
                    profileViewModel$loadSystemStatus$12.this$0.getSystemPhaseResult().setValue("Status: Unavailable (Check Permissions)");
                    return Unit.INSTANCE;
                }
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
