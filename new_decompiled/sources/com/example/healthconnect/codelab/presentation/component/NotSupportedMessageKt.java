package com.example.healthconnect.codelab.presentation.component;

import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.p000ui.graphics.Shadow;
import androidx.compose.p000ui.platform.CompositionLocalsKt;
import androidx.compose.p000ui.platform.UriHandler;
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
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: NotSupportedMessage.kt */
@Metadata(m286d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, m287d2 = {"NotSupportedMessage", "", "(Landroidx/compose/runtime/Composer;I)V", "NotSupportedMessagePreview", "finished_debug"}, m288k = 2, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes3.dex */
public final class NotSupportedMessageKt {
    public static final void NotSupportedMessage(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(1201939202);
        ComposerKt.sourceInformation($composer2, "C(NotSupportedMessage)38@1593L42,39@1648L42,40@1723L7,42@1757L86,46@1873L48,58@2280L266:NotSupportedMessage.kt#wkenw8");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1201939202, $changed, -1, "com.example.healthconnect.codelab.presentation.component.NotSupportedMessage (NotSupportedMessage.kt:37)");
            }
            final String tag = StringResources_androidKt.stringResource(C0965R.string.not_supported_tag, $composer2, 0);
            String url = StringResources_androidKt.stringResource(C0965R.string.not_supported_url, $composer2, 0);
            ProvidableCompositionLocal<UriHandler> localUriHandler = CompositionLocalsKt.getLocalUriHandler();
            ComposerKt.sourceInformationMarkerStart($composer2, 2023513938, "C:CompositionLocal.kt#9igjgp");
            Object consume = $composer2.consume(localUriHandler);
            ComposerKt.sourceInformationMarkerEnd($composer2);
            final UriHandler handler = (UriHandler) consume;
            String notSupportedText = StringResources_androidKt.stringResource(C0965R.string.not_supported_description, new Object[]{27}, $composer2, 64);
            String notSupportedLinkText = StringResources_androidKt.stringResource(C0965R.string.not_supported_link_text, $composer2, 0);
            $composer2.startReplaceableGroup(170967925);
            ComposerKt.sourceInformation($composer2, "*49@2024L6,54@2214L6");
            AnnotatedString.Builder $this$NotSupportedMessage_u24lambda_u242 = new AnnotatedString.Builder(0, 1, null);
            SpanStyle style$iv = new SpanStyle(MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1312getOnBackground0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null);
            int index$iv = $this$NotSupportedMessage_u24lambda_u242.pushStyle(style$iv);
            try {
                $this$NotSupportedMessage_u24lambda_u242.append(notSupportedText);
            } catch (Throwable th) {
                th = th;
            }
            try {
                $this$NotSupportedMessage_u24lambda_u242.append("\n\n");
                Unit unit = Unit.INSTANCE;
                $this$NotSupportedMessage_u24lambda_u242.pop(index$iv);
                $this$NotSupportedMessage_u24lambda_u242.pushStringAnnotation(tag, url);
                SpanStyle style$iv2 = new SpanStyle(MaterialTheme.INSTANCE.getColors($composer2, MaterialTheme.$stable).m1317getPrimary0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, 16382, (DefaultConstructorMarker) null);
                index$iv = $this$NotSupportedMessage_u24lambda_u242.pushStyle(style$iv2);
                try {
                    $this$NotSupportedMessage_u24lambda_u242.append(notSupportedLinkText);
                    Unit unit2 = Unit.INSTANCE;
                    $this$NotSupportedMessage_u24lambda_u242.pop(index$iv);
                    final AnnotatedString unavailableText = $this$NotSupportedMessage_u24lambda_u242.toAnnotatedString();
                    $composer2.endReplaceableGroup();
                    ClickableTextKt.m1023ClickableText4YKlhWE(unavailableText, null, new TextStyle(0L, 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, TextAlign.m4261boximpl(TextAlign.INSTANCE.m4270getJustifye0LSkKk()), (TextDirection) null, 0L, (TextIndent) null, 245759, (DefaultConstructorMarker) null), false, 0, 0, null, new Function1<Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.NotSupportedMessageKt$NotSupportedMessage$1
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
                                handler.openUri((String) it.getItem());
                            }
                        }
                    }, $composer2, 0, 122);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } finally {
                    $this$NotSupportedMessage_u24lambda_u242.pop(index$iv);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.NotSupportedMessageKt$NotSupportedMessage$2
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
                NotSupportedMessageKt.NotSupportedMessage(composer, $changed | 1);
            }
        });
    }

    public static final void NotSupportedMessagePreview(Composer $composer, final int $changed) {
        Composer $composer2 = $composer.startRestartGroup(-117294698);
        ComposerKt.sourceInformation($composer2, "C(NotSupportedMessagePreview)72@2608L50:NotSupportedMessage.kt#wkenw8");
        if ($changed != 0 || !$composer2.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-117294698, $changed, -1, "com.example.healthconnect.codelab.presentation.component.NotSupportedMessagePreview (NotSupportedMessage.kt:71)");
            }
            ThemeKt.HealthConnectTheme(false, ComposableSingletons$NotSupportedMessageKt.INSTANCE.m4700getLambda1$finished_debug(), $composer2, 48, 1);
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
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.example.healthconnect.codelab.presentation.component.NotSupportedMessageKt$NotSupportedMessagePreview$1
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
                NotSupportedMessageKt.NotSupportedMessagePreview(composer, $changed | 1);
            }
        });
    }
}
