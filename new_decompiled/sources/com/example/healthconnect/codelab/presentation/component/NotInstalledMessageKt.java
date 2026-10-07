package com.example.healthconnect.codelab.presentation.component;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p000ui.res.StringResources_androidKt;
import androidx.compose.p000ui.text.AnnotatedString;
import androidx.compose.p000ui.text.SpanStyle;
import androidx.compose.p000ui.text.TextStyle;
import androidx.compose.p000ui.text.font.FontFamily;
import androidx.compose.p000ui.text.font.FontStyle;
import androidx.compose.p000ui.text.font.FontSynthesis;
import androidx.compose.p000ui.text.font.FontWeight;
import androidx.compose.p000ui.text.intl.LocaleList;
import androidx.compose.p000ui.text.style.BaselineShift;
import androidx.compose.p000ui.text.style.TextAlign;
import androidx.compose.p000ui.text.style.TextDecoration;
import androidx.compose.p000ui.text.style.TextDirection;
import androidx.compose.p000ui.text.style.TextGeometricTransform;
import androidx.compose.p000ui.text.style.TextIndent;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ScopeUpdateScope;
import com.example.healthconnect.codelab.C0965R;
import com.example.healthconnect.codelab.presentation.theme.ThemeKt;
import com.google.android.gms.common.internal.ImagesContract;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotInstalledMessage.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m287d2 = {"NotInstalledMessage", "", "(Landroidx/compose/runtime/Composer;I)V", "NotInstalledMessagePreview", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes3.dex */
public final class NotInstalledMessageKt {
    public static final void NotInstalledMessage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1582956698);
        ComposerKt.sourceInformation($composer2, "C(NotInstalledMessage)39@1558L42,41@1698L40,43@1789L52,45@1936L44,47@2024L7,49@2058L55,50@2143L48,62@2561L331:NotInstalledMessage.kt#wkenw8");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1582956698, $changed, -1, "com.example.healthconnect.codelab.presentation.component.NotInstalledMessage (NotInstalledMessage.kt:38)");
            }
            final String tag = StringResources_androidKt.stringResource(C0965R.string.not_installed_tag, $composer2, 0);
            Uri url = Uri.parse(StringResources_androidKt.stringResource(C0965R.string.market_url, $composer2, 0)).buildUpon().appendQueryParameter("id", StringResources_androidKt.stringResource(C0965R.string.health_connect_package, $composer2, 0)).appendQueryParameter(ImagesContract.URL, StringResources_androidKt.stringResource(C0965R.string.onboarding_url, $composer2, 0)).build();
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final Context context = (Context) consume;
            String notInstalledText = StringResources_androidKt.stringResource(C0965R.string.not_installed_description, $composer2, 0);
            String notInstalledLinkText = StringResources_androidKt.stringResource(C0965R.string.not_installed_link_text, $composer2, 0);
            $composer2.startReplaceableGroup(1830853455);
            ComposerKt.sourceInformation($composer2, "*53@2294L6,58@2495L6");
            AnnotatedString.Builder $this$NotInstalledMessage_u24lambda_u242 = new AnnotatedString.Builder(0, 1, null);
            SpanStyle style$iv = new SpanStyle(MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null);
            int index$iv = $this$NotInstalledMessage_u24lambda_u242.pushStyle(style$iv);
            try {
                $this$NotInstalledMessage_u24lambda_u242.append(notInstalledText);
            } catch (Throwable th) {
                th = th;
            }
            try {
                $this$NotInstalledMessage_u24lambda_u242.append("\n\n");
                Unit unit = Unit.INSTANCE;
                $this$NotInstalledMessage_u24lambda_u242.pop(index$iv);
                String uri = url.toString();
                Intrinsics.checkNotNullExpressionValue(uri, "url.toString()");
                $this$NotInstalledMessage_u24lambda_u242.pushStringAnnotation(tag, uri);
                SpanStyle style$iv2 = new SpanStyle(MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null);
                index$iv = $this$NotInstalledMessage_u24lambda_u242.pushStyle(style$iv2);
                try {
                    $this$NotInstalledMessage_u24lambda_u242.append(notInstalledLinkText);
                    Unit unit2 = Unit.INSTANCE;
                    $this$NotInstalledMessage_u24lambda_u242.pop(index$iv);
                    final AnnotatedString unavailableText = $this$NotInstalledMessage_u24lambda_u242.toAnnotatedString();
                    $composer2.endReplaceableGroup();
                    ClickableTextKt.m1023ClickableText4YKlhWE(unavailableText, null, new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, TextAlign.m4261boximpl(TextAlign.INSTANCE.m4270getJustifye0LSkKk()), (TextDirection) null, 0L, (TextIndent) null, 245759, (DefaultConstructorMarker) null), false, 0, 0, null, new Function1<Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.NotInstalledMessageKt$NotInstalledMessage$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int offset) {
                            AnnotatedString.Range it = (AnnotatedString.Range) CollectionsKt.firstOrNull((List) AnnotatedString.this.getStringAnnotations(tag, offset, offset));
                            if (it != null) {
                                context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String) it.getItem())));
                            }
                        }
                    }, $composer2, 0, 122);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } finally {
                    $this$NotInstalledMessage_u24lambda_u242.pop(index$iv);
                }
            } catch (Throwable th2) {
                th = th2;
                throw th;
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.NotInstalledMessageKt$NotInstalledMessage$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                NotInstalledMessageKt.NotInstalledMessage(composer, $changed | 1);
            }
        });
    }

    public static final void NotInstalledMessagePreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-882203114);
        ComposerKt.sourceInformation($composer2, "C(NotInstalledMessagePreview)78@2954L50:NotInstalledMessage.kt#wkenw8");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-882203114, $changed, -1, "com.example.healthconnect.codelab.presentation.component.NotInstalledMessagePreview (NotInstalledMessage.kt:77)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$NotInstalledMessageKt.INSTANCE.m4699getLambda1$finished_debug(), $composer2, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            $composer2.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.NotInstalledMessageKt$NotInstalledMessagePreview$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                NotInstalledMessageKt.NotInstalledMessagePreview(composer, $changed | 1);
            }
        });
    }
}
