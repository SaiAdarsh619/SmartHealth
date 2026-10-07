package com.example.healthconnect.codelab.presentation;

import android.app.Application;
import com.example.healthconnect.codelab.data.HealthConnectManager;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: BaseApplication.kt */
@Metadata(m286d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, m287d2 = {"Lcom/example/healthconnect/codelab/presentation/BaseApplication;", "Landroid/app/Application;", "()V", "healthConnectManager", "Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "getHealthConnectManager", "()Lcom/example/healthconnect/codelab/data/HealthConnectManager;", "healthConnectManager$delegate", "Lkotlin/Lazy;", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes10.dex */
public final class BaseApplication extends Application {
    public static final int $stable = 8;

    /* renamed from: healthConnectManager$delegate, reason: from kotlin metadata */
    private final Lazy healthConnectManager = LazyKt.lazy(new Function0<HealthConnectManager>() { // from class: com.example.healthconnect.codelab.presentation.BaseApplication$healthConnectManager$2
        {
            super(0);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HealthConnectManager invoke() {
            return new HealthConnectManager(BaseApplication.this);
        }
    });

    public final HealthConnectManager getHealthConnectManager() {
        return (HealthConnectManager) this.healthConnectManager.getValue();
    }
}
