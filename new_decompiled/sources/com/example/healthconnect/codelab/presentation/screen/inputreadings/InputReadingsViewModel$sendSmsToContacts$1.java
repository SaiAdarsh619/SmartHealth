package com.example.healthconnect.codelab.presentation.screen.inputreadings;

import android.os.Build;
import android.telephony.SmsManager;
import android.util.Log;
import com.example.healthconnect.codelab.data.EmergencyContact;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: InputReadingsViewModel.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, m287d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
@DebugMetadata(m296c = "com.example.healthconnect.codelab.presentation.screen.inputreadings.InputReadingsViewModel$sendSmsToContacts$1", m297f = "InputReadingsViewModel.kt", m298i = {}, m299l = {328}, m300m = "invokeSuspend", m301n = {}, m302s = {})
/* loaded from: classes12.dex */
final class InputReadingsViewModel$sendSmsToContacts$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ List<EmergencyContact> $contacts;
    final /* synthetic */ boolean $isTest;
    final /* synthetic */ String $message;
    int label;
    final /* synthetic */ InputReadingsViewModel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InputReadingsViewModel$sendSmsToContacts$1(InputReadingsViewModel inputReadingsViewModel, boolean z, String str, List<EmergencyContact> list, Continuation<? super InputReadingsViewModel$sendSmsToContacts$1> continuation) {
        super(2, continuation);
        this.this$0 = inputReadingsViewModel;
        this.$isTest = z;
        this.$message = str;
        this.$contacts = list;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new InputReadingsViewModel$sendSmsToContacts$1(this.this$0, this.$isTest, this.$message, this.$contacts, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((InputReadingsViewModel$sendSmsToContacts$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00a4 A[Catch: Exception -> 0x00b8, TryCatch #4 {Exception -> 0x00b8, blocks: (B:22:0x009e, B:24:0x00a4, B:35:0x00b2), top: B:21:0x009e, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ce A[Catch: Exception -> 0x010c, LOOP:0: B:27:0x00c8->B:29:0x00ce, LOOP_END, TryCatch #3 {Exception -> 0x010c, blocks: (B:26:0x00be, B:27:0x00c8, B:29:0x00ce, B:31:0x00e4, B:39:0x00b9, B:22:0x009e, B:24:0x00a4, B:35:0x00b2), top: B:21:0x009e, inners: #4 }] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00b2 A[Catch: Exception -> 0x00b8, TRY_LEAVE, TryCatch #4 {Exception -> 0x00b8, blocks: (B:22:0x009e, B:24:0x00a4, B:35:0x00b2), top: B:21:0x009e, outer: #3 }] */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0099  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        InputReadingsViewModel$sendSmsToContacts$1 inputReadingsViewModel$sendSmsToContacts$1;
        Object $result;
        String locationLink;
        Object lastLocation;
        Object $result2;
        String str;
        String locationLink2;
        SmsManager smsManager;
        SmsManager smsManager2;
        HealthConnectManager healthConnectManager;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        switch (this.label) {
            case 0:
                ResultKt.throwOnFailure(obj);
                inputReadingsViewModel$sendSmsToContacts$1 = this;
                $result = obj;
                locationLink = null;
                try {
                    inputReadingsViewModel$sendSmsToContacts$1.label = 1;
                    lastLocation = inputReadingsViewModel$sendSmsToContacts$1.this$0.getLastLocation(inputReadingsViewModel$sendSmsToContacts$1);
                } catch (Exception e) {
                    e = e;
                    Log.e("Vitals", "Error fetching location for SMS: " + e.getMessage());
                    locationLink2 = locationLink;
                    String finalMessage = locationLink2 != null ? inputReadingsViewModel$sendSmsToContacts$1.$message + "\nLocation: " + locationLink2 : inputReadingsViewModel$sendSmsToContacts$1.$message;
                    try {
                        try {
                            if (Build.VERSION.SDK_INT >= 31) {
                            }
                            smsManager = smsManager2;
                        } catch (Exception e2) {
                            smsManager = SmsManager.getDefault();
                        }
                        Iterable $this$forEach$iv = inputReadingsViewModel$sendSmsToContacts$1.$contacts;
                        while (r13.hasNext()) {
                        }
                        Log.d("Vitals", "Emergency SMS sent to " + inputReadingsViewModel$sendSmsToContacts$1.$contacts.size() + " contacts. Msg: " + finalMessage);
                    } catch (Exception e3) {
                        Log.e("Vitals", "Failed to send SMS: " + e3.getMessage());
                    }
                    return Unit.INSTANCE;
                }
                if (lastLocation == coroutine_suspended) {
                    return coroutine_suspended;
                }
                $result2 = $result;
                $result = lastLocation;
                str = null;
                try {
                    locationLink2 = (String) $result;
                    try {
                        if (inputReadingsViewModel$sendSmsToContacts$1.$isTest && locationLink2 == null) {
                            Log.w("Vitals", "Test Alert: Location was null.");
                        }
                    } catch (Exception e4) {
                        e = e4;
                        Object obj2 = $result2;
                        locationLink = locationLink2;
                        $result = obj2;
                        Log.e("Vitals", "Error fetching location for SMS: " + e.getMessage());
                        locationLink2 = locationLink;
                        String finalMessage2 = locationLink2 != null ? inputReadingsViewModel$sendSmsToContacts$1.$message + "\nLocation: " + locationLink2 : inputReadingsViewModel$sendSmsToContacts$1.$message;
                        if (Build.VERSION.SDK_INT >= 31) {
                        }
                        smsManager = smsManager2;
                        Iterable $this$forEach$iv2 = inputReadingsViewModel$sendSmsToContacts$1.$contacts;
                        while (r13.hasNext()) {
                        }
                        Log.d("Vitals", "Emergency SMS sent to " + inputReadingsViewModel$sendSmsToContacts$1.$contacts.size() + " contacts. Msg: " + finalMessage2);
                        return Unit.INSTANCE;
                    }
                } catch (Exception e5) {
                    e = e5;
                    Object obj3 = $result2;
                    locationLink = str;
                    $result = obj3;
                }
                String finalMessage22 = locationLink2 != null ? inputReadingsViewModel$sendSmsToContacts$1.$message + "\nLocation: " + locationLink2 : inputReadingsViewModel$sendSmsToContacts$1.$message;
                if (Build.VERSION.SDK_INT >= 31) {
                    healthConnectManager = inputReadingsViewModel$sendSmsToContacts$1.this$0.healthConnectManager;
                    healthConnectManager.getContext();
                    smsManager2 = SmsManager.getDefault();
                } else {
                    smsManager2 = SmsManager.getDefault();
                }
                smsManager = smsManager2;
                Iterable $this$forEach$iv22 = inputReadingsViewModel$sendSmsToContacts$1.$contacts;
                for (Object element$iv : $this$forEach$iv22) {
                    EmergencyContact contact = (EmergencyContact) element$iv;
                    smsManager.sendTextMessage(contact.getPhoneNumber(), null, finalMessage22, null, null);
                }
                Log.d("Vitals", "Emergency SMS sent to " + inputReadingsViewModel$sendSmsToContacts$1.$contacts.size() + " contacts. Msg: " + finalMessage22);
                return Unit.INSTANCE;
            case 1:
                inputReadingsViewModel$sendSmsToContacts$1 = this;
                $result = obj;
                locationLink = null;
                try {
                    ResultKt.throwOnFailure($result);
                    str = null;
                    $result2 = $result;
                    locationLink2 = (String) $result;
                    if (inputReadingsViewModel$sendSmsToContacts$1.$isTest) {
                        Log.w("Vitals", "Test Alert: Location was null.");
                    }
                } catch (Exception e6) {
                    e = e6;
                    Log.e("Vitals", "Error fetching location for SMS: " + e.getMessage());
                    locationLink2 = locationLink;
                    String finalMessage222 = locationLink2 != null ? inputReadingsViewModel$sendSmsToContacts$1.$message + "\nLocation: " + locationLink2 : inputReadingsViewModel$sendSmsToContacts$1.$message;
                    if (Build.VERSION.SDK_INT >= 31) {
                    }
                    smsManager = smsManager2;
                    Iterable $this$forEach$iv222 = inputReadingsViewModel$sendSmsToContacts$1.$contacts;
                    while (r13.hasNext()) {
                    }
                    Log.d("Vitals", "Emergency SMS sent to " + inputReadingsViewModel$sendSmsToContacts$1.$contacts.size() + " contacts. Msg: " + finalMessage222);
                    return Unit.INSTANCE;
                }
                String finalMessage2222 = locationLink2 != null ? inputReadingsViewModel$sendSmsToContacts$1.$message + "\nLocation: " + locationLink2 : inputReadingsViewModel$sendSmsToContacts$1.$message;
                if (Build.VERSION.SDK_INT >= 31) {
                }
                smsManager = smsManager2;
                Iterable $this$forEach$iv2222 = inputReadingsViewModel$sendSmsToContacts$1.$contacts;
                while (r13.hasNext()) {
                }
                Log.d("Vitals", "Emergency SMS sent to " + inputReadingsViewModel$sendSmsToContacts$1.$contacts.size() + " contacts. Msg: " + finalMessage2222);
                return Unit.INSTANCE;
            default:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }
}
