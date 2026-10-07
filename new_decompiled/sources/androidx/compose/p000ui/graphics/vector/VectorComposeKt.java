package androidx.compose.p000ui.graphics.vector;

import androidx.autofill.HintConstants;
import androidx.compose.p000ui.graphics.Brush;
import androidx.compose.p000ui.graphics.PathFillType;
import androidx.compose.p000ui.graphics.StrokeCap;
import androidx.compose.p000ui.graphics.StrokeJoin;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.health.platform.client.SdkConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VectorCompose.kt */
@Metadata(m286d1 = {"\u0000L\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0085\u0001\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0016\u0010\u000f\u001a\u0012\u0012\u0004\u0012\u00020\u00010\u0010¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0013\u001a©\u0001\u0010\u0014\u001a\u00020\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00052\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00052\b\b\u0002\u0010#\u001a\u00020\u00052\b\b\u0002\u0010$\u001a\u00020\u00052\b\b\u0002\u0010%\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010'\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006("}, m287d2 = {"Group", "", HintConstants.AUTOFILL_HINT_NAME, "", "rotation", "", "pivotX", "pivotY", "scaleX", "scaleY", "translationX", "translationY", "clipPathData", "", "Landroidx/compose/ui/graphics/vector/PathNode;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/graphics/vector/VectorComposable;", "(Ljava/lang/String;FFFFFFFLjava/util/List;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Path", "pathData", "pathFillType", "Landroidx/compose/ui/graphics/PathFillType;", "fill", "Landroidx/compose/ui/graphics/Brush;", "fillAlpha", "stroke", "strokeAlpha", "strokeLineWidth", "strokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "strokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "strokeLineMiter", "trimPathStart", "trimPathEnd", "trimPathOffset", "Path-9cdaXJ4", "(Ljava/util/List;ILjava/lang/String;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/Brush;FFIIFFFFLandroidx/compose/runtime/Composer;III)V", "ui_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:41:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0194  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x01a1  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x01b5  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0197  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final void Group(String name, float rotation, float pivotX, float pivotY, float scaleX, float scaleY, float translationX, float translationY, List<? extends PathNode> list, final Function2<? super Composer, ? super Integer, Unit> content, Composer $composer, final int $changed, final int i) {
        float f;
        float f2;
        float translationX2;
        String name2;
        float rotation2;
        float pivotX2;
        float pivotY2;
        float scaleX2;
        float scaleY2;
        float translationY2;
        List clipPathData;
        String name3;
        float translationY3;
        List clipPathData2;
        float rotation3;
        float pivotX3;
        float pivotY3;
        float translationX3;
        float scaleX3;
        float scaleY3;
        ScopeUpdateScope endRestartGroup;
        int i2;
        Intrinsics.checkNotNullParameter(content, "content");
        Composer $composer2 = $composer.startRestartGroup(-213417674);
        ComposerKt.sourceInformation($composer2, "C(Group)P(2,5,3,4,6,7,8,9)40@1441L585:VectorCompose.kt#huu6hf");
        int $dirty = $changed;
        int i3 = i & 1;
        if (i3 != 0) {
            $dirty |= 6;
        } else if (($changed & 14) == 0) {
            $dirty |= $composer2.changed(name) ? 4 : 2;
        }
        int i4 = i & 2;
        if (i4 != 0) {
            $dirty |= 48;
        } else if (($changed & SdkConfig.SDK_VERSION) == 0) {
            $dirty |= $composer2.changed(rotation) ? 32 : 16;
        }
        int i5 = i & 4;
        if (i5 != 0) {
            $dirty |= 384;
            f = pivotX;
        } else if (($changed & 896) == 0) {
            f = pivotX;
            $dirty |= $composer2.changed(f) ? 256 : 128;
        } else {
            f = pivotX;
        }
        int i6 = i & 8;
        if (i6 != 0) {
            $dirty |= 3072;
            f2 = pivotY;
        } else if (($changed & 7168) == 0) {
            f2 = pivotY;
            $dirty |= $composer2.changed(f2) ? 2048 : 1024;
        } else {
            f2 = pivotY;
        }
        int i7 = i & 16;
        if (i7 != 0) {
            $dirty |= 24576;
        } else if (($changed & 57344) == 0) {
            $dirty |= $composer2.changed(scaleX) ? 16384 : 8192;
        }
        int i8 = i & 32;
        if (i8 != 0) {
            $dirty |= 196608;
        } else if (($changed & 458752) == 0) {
            $dirty |= $composer2.changed(scaleY) ? 131072 : 65536;
        }
        int i9 = i & 64;
        if (i9 != 0) {
            $dirty |= 1572864;
            translationX2 = translationX;
        } else if (($changed & 3670016) == 0) {
            translationX2 = translationX;
            $dirty |= $composer2.changed(translationX2) ? 1048576 : 524288;
        } else {
            translationX2 = translationX;
        }
        int i10 = i & 128;
        if (i10 != 0) {
            $dirty |= 12582912;
        } else if (($changed & 29360128) == 0) {
            $dirty |= $composer2.changed(translationY) ? 8388608 : 4194304;
        }
        int i11 = i & 256;
        if (i11 != 0) {
            $dirty |= 33554432;
        }
        if ((i & 512) == 0) {
            i2 = (1879048192 & $changed) == 0 ? $composer2.changed(content) ? 536870912 : 268435456 : 805306368;
            if (i11 != 256 && (1533916891 & $dirty) == 306783378 && $composer2.getSkipping()) {
                $composer2.skipToGroupEnd();
                name3 = name;
                rotation3 = rotation;
                scaleX3 = scaleX;
                scaleY3 = scaleY;
                translationY3 = translationY;
                clipPathData2 = list;
                translationX3 = translationX2;
                pivotX3 = f;
                pivotY3 = f2;
            } else {
                $composer2.startDefaults();
                if (($changed & 1) != 0 || $composer2.getDefaultsInvalid()) {
                    name2 = i3 == 0 ? "" : name;
                    rotation2 = i4 == 0 ? 0.0f : rotation;
                    pivotX2 = i5 == 0 ? 0.0f : f;
                    pivotY2 = i6 == 0 ? 0.0f : f2;
                    scaleX2 = i7 == 0 ? 1.0f : scaleX;
                    scaleY2 = i8 == 0 ? 1.0f : scaleY;
                    if (i9 != 0) {
                        translationX2 = 0.0f;
                    }
                    translationY2 = i10 == 0 ? 0.0f : translationY;
                    if (i11 == 0) {
                        clipPathData = VectorKt.getEmptyPath();
                        $dirty &= -234881025;
                    } else {
                        clipPathData = list;
                    }
                } else {
                    $composer2.skipToGroupEnd();
                    if (i11 != 0) {
                        $dirty &= -234881025;
                    }
                    name2 = name;
                    rotation2 = rotation;
                    scaleY2 = scaleY;
                    translationY2 = translationY;
                    clipPathData = list;
                    pivotX2 = f;
                    pivotY2 = f2;
                    scaleX2 = scaleX;
                }
                $composer2.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-213417674, $dirty, -1, "androidx.compose.ui.graphics.vector.Group (VectorCompose.kt:28)");
                }
                VectorComposeKt$Group$1 vectorComposeKt$Group$1 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // kotlin.jvm.functions.Function0
                    public final GroupComponent invoke() {
                        return new GroupComponent();
                    }
                };
                $composer2.startReplaceableGroup(-548224868);
                ComposerKt.sourceInformation($composer2, "C(ComposeNode)P(1,2)334@12548L9:Composables.kt#9igjgp");
                if (!($composer2.getApplier() instanceof VectorApplier)) {
                    ComposablesKt.invalidApplier();
                }
                $composer2.startNode();
                if ($composer2.getInserting()) {
                    $composer2.useNode();
                } else {
                    $composer2.createNode(vectorComposeKt$Group$1);
                }
                Composer $this$Group_u24lambda_u2d0 = Updater.m1639constructorimpl($composer2);
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, name2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str) {
                        invoke2(groupComponent, str);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, String it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setName(it);
                    }
                });
                name3 = name2;
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, Float.valueOf(rotation2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f3) {
                        invoke(groupComponent, f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setRotation(it);
                    }
                });
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, Float.valueOf(pivotX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f3) {
                        invoke(groupComponent, f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotX(it);
                    }
                });
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, Float.valueOf(pivotY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f3) {
                        invoke(groupComponent, f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setPivotY(it);
                    }
                });
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, Float.valueOf(scaleX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f3) {
                        invoke(groupComponent, f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleX(it);
                    }
                });
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, Float.valueOf(scaleY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f3) {
                        invoke(groupComponent, f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setScaleY(it);
                    }
                });
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, Float.valueOf(translationX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f3) {
                        invoke(groupComponent, f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationX(it);
                    }
                });
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, Float.valueOf(translationY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f3) {
                        invoke(groupComponent, f3.floatValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(GroupComponent set, float it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        set.setTranslationY(it);
                    }
                });
                Updater.m1646setimpl($this$Group_u24lambda_u2d0, clipPathData, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list2) {
                        invoke2(groupComponent, list2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                        Intrinsics.checkNotNullParameter(set, "$this$set");
                        Intrinsics.checkNotNullParameter(it, "it");
                        set.setClipPathData(it);
                    }
                });
                float translationY4 = translationY2;
                $composer2.startReplaceableGroup(-983907633);
                ComposerKt.sourceInformation($composer2, "C54@2011L9:VectorCompose.kt#huu6hf");
                if (((6 >> 6) & 14 & 11) == 2 || !$composer2.getSkipping()) {
                    content.invoke($composer2, Integer.valueOf(($dirty >> 27) & 14));
                } else {
                    $composer2.skipToGroupEnd();
                }
                $composer2.endReplaceableGroup();
                $composer2.endNode();
                $composer2.endReplaceableGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                translationY3 = translationY4;
                clipPathData2 = clipPathData;
                rotation3 = rotation2;
                pivotX3 = pivotX2;
                pivotY3 = pivotY2;
                translationX3 = translationX2;
                scaleX3 = scaleX2;
                scaleY3 = scaleY2;
            }
            endRestartGroup = $composer2.endRestartGroup();
            if (endRestartGroup != null) {
                return;
            }
            final String str = name3;
            final float f3 = rotation3;
            final float f4 = pivotX3;
            final float f5 = pivotY3;
            final float f6 = scaleX3;
            final float f7 = scaleY3;
            final float f8 = translationX3;
            final float f9 = translationY3;
            final List list2 = clipPathData2;
            endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i12) {
                    VectorComposeKt.Group(str, f3, f4, f5, f6, f7, f8, f9, list2, content, composer, $changed | 1, i);
                }
            });
            return;
        }
        $dirty |= i2;
        if (i11 != 256) {
        }
        $composer2.startDefaults();
        if (($changed & 1) != 0) {
        }
        if (i3 == 0) {
        }
        if (i4 == 0) {
        }
        if (i5 == 0) {
        }
        if (i6 == 0) {
        }
        if (i7 == 0) {
        }
        if (i8 == 0) {
        }
        if (i9 != 0) {
        }
        if (i10 == 0) {
        }
        if (i11 == 0) {
        }
        $composer2.endDefaults();
        if (ComposerKt.isTraceInProgress()) {
        }
        VectorComposeKt$Group$1 vectorComposeKt$Group$12 = new Function0<GroupComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final GroupComponent invoke() {
                return new GroupComponent();
            }
        };
        $composer2.startReplaceableGroup(-548224868);
        ComposerKt.sourceInformation($composer2, "C(ComposeNode)P(1,2)334@12548L9:Composables.kt#9igjgp");
        if (!($composer2.getApplier() instanceof VectorApplier)) {
        }
        $composer2.startNode();
        if ($composer2.getInserting()) {
        }
        Composer $this$Group_u24lambda_u2d02 = Updater.m1639constructorimpl($composer2);
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, name2, new Function2<GroupComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, String str2) {
                invoke2(groupComponent, str2);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupComponent set, String it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setName(it);
            }
        });
        name3 = name2;
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, Float.valueOf(rotation2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f32) {
                invoke(groupComponent, f32.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setRotation(it);
            }
        });
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, Float.valueOf(pivotX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f32) {
                invoke(groupComponent, f32.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setPivotX(it);
            }
        });
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, Float.valueOf(pivotY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f32) {
                invoke(groupComponent, f32.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setPivotY(it);
            }
        });
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, Float.valueOf(scaleX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f32) {
                invoke(groupComponent, f32.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setScaleX(it);
            }
        });
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, Float.valueOf(scaleY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f32) {
                invoke(groupComponent, f32.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setScaleY(it);
            }
        });
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, Float.valueOf(translationX2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f32) {
                invoke(groupComponent, f32.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTranslationX(it);
            }
        });
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, Float.valueOf(translationY2), new Function2<GroupComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, Float f32) {
                invoke(groupComponent, f32.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(GroupComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTranslationY(it);
            }
        });
        Updater.m1646setimpl($this$Group_u24lambda_u2d02, clipPathData, new Function2<GroupComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Group$2$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(GroupComponent groupComponent, List<? extends PathNode> list22) {
                invoke2(groupComponent, list22);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GroupComponent set, List<? extends PathNode> it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setClipPathData(it);
            }
        });
        float translationY42 = translationY2;
        $composer2.startReplaceableGroup(-983907633);
        ComposerKt.sourceInformation($composer2, "C54@2011L9:VectorCompose.kt#huu6hf");
        if (((6 >> 6) & 14 & 11) == 2) {
        }
        content.invoke($composer2, Integer.valueOf(($dirty >> 27) & 14));
        $composer2.endReplaceableGroup();
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
        }
        translationY3 = translationY42;
        clipPathData2 = clipPathData;
        rotation3 = rotation2;
        pivotX3 = pivotX2;
        pivotY3 = pivotY2;
        translationX3 = translationX2;
        scaleX3 = scaleX2;
        scaleY3 = scaleY2;
        endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup != null) {
        }
    }

    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m2593Path9cdaXJ4(final List<? extends PathNode> pathData, int pathFillType, String name, Brush fill, float fillAlpha, Brush stroke, float strokeAlpha, float strokeLineWidth, int strokeLineCap, int strokeLineJoin, float strokeLineMiter, float trimPathStart, float trimPathEnd, float trimPathOffset, Composer $composer, final int $changed, final int $changed1, final int i) {
        int pathFillType2;
        String name2;
        Brush fill2;
        float fillAlpha2;
        Brush stroke2;
        float strokeAlpha2;
        float strokeLineWidth2;
        int strokeLineCap2;
        int strokeLineJoin2;
        float strokeLineMiter2;
        float trimPathStart2;
        float trimPathEnd2;
        float trimPathOffset2;
        Intrinsics.checkNotNullParameter(pathData, "pathData");
        Composer $composer2 = $composer.startRestartGroup(-1478270750);
        ComposerKt.sourceInformation($composer2, "C(Path)P(3,4:c#ui.graphics.PathFillType,2!4,10,7:c#ui.graphics.StrokeCap,8:c#ui.graphics.StrokeJoin!1,13)76@2665L876:VectorCompose.kt#huu6hf");
        if ((i & 2) != 0) {
            pathFillType2 = VectorKt.getDefaultFillType();
        } else {
            pathFillType2 = pathFillType;
        }
        if ((i & 4) == 0) {
            name2 = name;
        } else {
            name2 = "";
        }
        if ((i & 8) == 0) {
            fill2 = fill;
        } else {
            fill2 = null;
        }
        if ((i & 16) == 0) {
            fillAlpha2 = fillAlpha;
        } else {
            fillAlpha2 = 1.0f;
        }
        if ((i & 32) == 0) {
            stroke2 = stroke;
        } else {
            stroke2 = null;
        }
        if ((i & 64) == 0) {
            strokeAlpha2 = strokeAlpha;
        } else {
            strokeAlpha2 = 1.0f;
        }
        if ((i & 128) == 0) {
            strokeLineWidth2 = strokeLineWidth;
        } else {
            strokeLineWidth2 = 0.0f;
        }
        if ((i & 256) == 0) {
            strokeLineCap2 = strokeLineCap;
        } else {
            strokeLineCap2 = VectorKt.getDefaultStrokeLineCap();
        }
        if ((i & 512) == 0) {
            strokeLineJoin2 = strokeLineJoin;
        } else {
            strokeLineJoin2 = VectorKt.getDefaultStrokeLineJoin();
        }
        if ((i & 1024) == 0) {
            strokeLineMiter2 = strokeLineMiter;
        } else {
            strokeLineMiter2 = 4.0f;
        }
        if ((i & 2048) == 0) {
            trimPathStart2 = trimPathStart;
        } else {
            trimPathStart2 = 0.0f;
        }
        if ((i & 4096) == 0) {
            trimPathEnd2 = trimPathEnd;
        } else {
            trimPathEnd2 = 1.0f;
        }
        if ((i & 8192) == 0) {
            trimPathOffset2 = trimPathOffset;
        } else {
            trimPathOffset2 = 0.0f;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, $changed, $changed1, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:60)");
        }
        final Function0 factory$iv = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final PathComponent invoke() {
                return new PathComponent();
            }
        };
        $composer2.startReplaceableGroup(1886828752);
        ComposerKt.sourceInformation($composer2, "C(ComposeNode):Composables.kt#9igjgp");
        if (!($composer2.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        $composer2.startNode();
        if ($composer2.getInserting()) {
            $composer2.createNode(new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.graphics.vector.PathComponent, java.lang.Object] */
                @Override // kotlin.jvm.functions.Function0
                public final PathComponent invoke() {
                    return Function0.this.invoke();
                }
            });
        } else {
            $composer2.useNode();
        }
        Composer $this$Path_9cdaXJ4_u24lambda_u2d2 = Updater.m1639constructorimpl($composer2);
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, name2, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, String str) {
                invoke2(pathComponent, str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, String it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setName(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, pathData, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, List<? extends PathNode> list) {
                invoke2(pathComponent, list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, List<? extends PathNode> it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                Intrinsics.checkNotNullParameter(it, "it");
                set.setPathData(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, PathFillType.m2232boximpl(pathFillType2), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, PathFillType pathFillType3) {
                m2595invokepweu1eQ(pathComponent, pathFillType3.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-pweu1eQ, reason: not valid java name */
            public final void m2595invokepweu1eQ(PathComponent set, int it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m2578setPathFillTypeoQ8Xj4U(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, fill2, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush) {
                invoke2(pathComponent, brush);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, Brush it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFill(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, Float.valueOf(fillAlpha2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setFillAlpha(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, stroke2, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Brush brush) {
                invoke2(pathComponent, brush);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(PathComponent set, Brush it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStroke(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, Float.valueOf(strokeAlpha2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeAlpha(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, Float.valueOf(strokeLineWidth2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineWidth(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, StrokeJoin.m2303boximpl(strokeLineJoin2), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeJoin strokeJoin) {
                m2596invokekLtJ_vA(pathComponent, strokeJoin.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-kLtJ_vA, reason: not valid java name */
            public final void m2596invokekLtJ_vA(PathComponent set, int it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m2580setStrokeLineJoinWw9F2mQ(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, StrokeCap.m2293boximpl(strokeLineCap2), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, StrokeCap strokeCap) {
                m2594invokeCSYIeUk(pathComponent, strokeCap.getValue());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-CSYIeUk, reason: not valid java name */
            public final void m2594invokeCSYIeUk(PathComponent set, int it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.m2579setStrokeLineCapBeK7IIE(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, Float.valueOf(strokeLineMiter2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setStrokeLineMiter(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, Float.valueOf(trimPathStart2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathStart(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, Float.valueOf(trimPathEnd2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathEnd(it);
            }
        });
        Updater.m1646setimpl($this$Path_9cdaXJ4_u24lambda_u2d2, Float.valueOf(trimPathOffset2), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(PathComponent pathComponent, Float f) {
                invoke(pathComponent, f.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PathComponent set, float it) {
                Intrinsics.checkNotNullParameter(set, "$this$set");
                set.setTrimPathOffset(it);
            }
        });
        $composer2.endNode();
        $composer2.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = $composer2.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final int i2 = pathFillType2;
        final String str = name2;
        final Brush brush = fill2;
        final float f = fillAlpha2;
        final Brush brush2 = stroke2;
        final float f2 = strokeAlpha2;
        final float f3 = strokeLineWidth2;
        final int i3 = strokeLineCap2;
        final int i4 = strokeLineJoin2;
        final float f4 = strokeLineMiter2;
        final float f5 = trimPathStart2;
        final float f6 = trimPathEnd2;
        final float f7 = trimPathOffset2;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i5) {
                VectorComposeKt.m2593Path9cdaXJ4(pathData, i2, str, brush, f, brush2, f2, f3, i3, i4, f4, f5, f6, f7, composer, $changed | 1, $changed1, i);
            }
        });
    }
}
