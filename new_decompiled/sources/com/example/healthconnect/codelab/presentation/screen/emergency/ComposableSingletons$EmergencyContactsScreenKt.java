package com.example.healthconnect.codelab.presentation.screen.emergency;

import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material.IconKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.TextKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material.icons.filled.DeleteKt;
import androidx.compose.material.icons.filled.EditKt;
import androidx.compose.p000ui.Modifier;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyContactsScreen.kt */
@Metadata(m288k = 3, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes12.dex */
public final class ComposableSingletons$EmergencyContactsScreenKt {
    public static final ComposableSingletons$EmergencyContactsScreenKt INSTANCE = new ComposableSingletons$EmergencyContactsScreenKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f384lambda1 = ComposableLambdaKt.composableLambdaInstance(-1124651472, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C82@3368L59:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1124651472, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-1.<anonymous> (EmergencyContactsScreen.kt:81)");
            }
            IconKt.m1415Iconww6aTOc(AddKt.getAdd(Icons.INSTANCE.getDefault()), "Add Contact", (Modifier) null, 0L, $composer, 48, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f385lambda2 = ComposableLambdaKt.composableLambdaInstance(1996530089, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C147@6706L6,144@6498L264:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1996530089, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-2.<anonymous> (EmergencyContactsScreen.kt:143)");
                }
                IconKt.m1415Iconww6aTOc(EditKt.getEdit(Icons.INSTANCE.getDefault()), "Edit", (Modifier) null, MaterialTheme.INSTANCE.getColors($composer, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), $composer, 48, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-3, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f386lambda3 = ComposableLambdaKt.composableLambdaInstance(1877074528, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-3$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C157@7316L6,154@7104L266:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 11) != 2 || !$composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1877074528, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-3.<anonymous> (EmergencyContactsScreen.kt:153)");
                }
                IconKt.m1415Iconww6aTOc(DeleteKt.getDelete(Icons.INSTANCE.getDefault()), "Delete", (Modifier) null, MaterialTheme.INSTANCE.getColors($composer, MaterialTheme.$stable).m1311getError0d7_KjU(), $composer, 48, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            $composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-4, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f387lambda4 = ComposableLambdaKt.composableLambdaInstance(911640838, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-4$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C185@8553L6,185@8512L60:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(911640838, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-4.<anonymous> (EmergencyContactsScreen.kt:184)");
            }
            TextKt.m1585TextfLXpl1I("Test Alert", null, MaterialTheme.INSTANCE.getColors($composer, MaterialTheme.$stable).m1315getOnSecondary0d7_KjU(), 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65530);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-5, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f388lambda5 = ComposableLambdaKt.composableLambdaInstance(-971582811, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-5$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C231@10144L12:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-971582811, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-5.<anonymous> (EmergencyContactsScreen.kt:231)");
            }
            TextKt.m1585TextfLXpl1I("Name", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-6, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f389lambda6 = ComposableLambdaKt.composableLambdaInstance(-677884196, false, new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-6$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer $composer, int $changed) {
            ComposerKt.sourceInformation($composer, "C238@10442L20:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 11) == 2 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-677884196, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-6.<anonymous> (EmergencyContactsScreen.kt:238)");
            }
            TextKt.m1585TextfLXpl1I("Phone Number", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-7, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f390lambda7 = ComposableLambdaKt.composableLambdaInstance(306491116, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-7$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope TextButton, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
            ComposerKt.sourceInformation($composer, "C244@10840L14:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(306491116, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-7.<anonymous> (EmergencyContactsScreen.kt:244)");
            }
            TextKt.m1585TextfLXpl1I("Cancel", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: lambda-8, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f391lambda8 = ComposableLambdaKt.composableLambdaInstance(-1643339553, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt$lambda-8$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer $composer, int $changed) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            ComposerKt.sourceInformation($composer, "C249@11069L12:EmergencyContactsScreen.kt#z8wdr8");
            if (($changed & 81) == 16 && $composer.getSkipping()) {
                $composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1643339553, $changed, -1, "com.example.healthconnect.codelab.presentation.screen.emergency.ComposableSingletons$EmergencyContactsScreenKt.lambda-8.<anonymous> (EmergencyContactsScreen.kt:249)");
            }
            TextKt.m1585TextfLXpl1I("Save", null, 0L, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, null, null, $composer, 6, 0, 65534);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
    });

    /* renamed from: getLambda-1$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4705getLambda1$finished_debug() {
        return f384lambda1;
    }

    /* renamed from: getLambda-2$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4706getLambda2$finished_debug() {
        return f385lambda2;
    }

    /* renamed from: getLambda-3$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4707getLambda3$finished_debug() {
        return f386lambda3;
    }

    /* renamed from: getLambda-4$finished_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m4708getLambda4$finished_debug() {
        return f387lambda4;
    }

    /* renamed from: getLambda-5$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4709getLambda5$finished_debug() {
        return f388lambda5;
    }

    /* renamed from: getLambda-6$finished_debug, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m4710getLambda6$finished_debug() {
        return f389lambda6;
    }

    /* renamed from: getLambda-7$finished_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m4711getLambda7$finished_debug() {
        return f390lambda7;
    }

    /* renamed from: getLambda-8$finished_debug, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m4712getLambda8$finished_debug() {
        return f391lambda8;
    }
}
