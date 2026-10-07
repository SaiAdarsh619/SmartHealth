package androidx.compose.p000ui.node;

import androidx.compose.p000ui.Modifier;
import androidx.compose.p000ui.draw.BuildDrawCacheParams;
import androidx.compose.p000ui.draw.DrawCacheModifier;
import androidx.compose.p000ui.draw.DrawModifier;
import androidx.compose.p000ui.focus.FocusOrderModifier;
import androidx.compose.p000ui.focus.FocusOrderModifierToProperties;
import androidx.compose.p000ui.focus.FocusPropertiesModifier;
import androidx.compose.p000ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p000ui.input.pointer.PointerEvent;
import androidx.compose.p000ui.input.pointer.PointerEventPass;
import androidx.compose.p000ui.input.pointer.PointerInputModifier;
import androidx.compose.p000ui.layout.IntermediateLayoutModifier;
import androidx.compose.p000ui.layout.IntrinsicMeasurable;
import androidx.compose.p000ui.layout.IntrinsicMeasureScope;
import androidx.compose.p000ui.layout.LayoutCoordinates;
import androidx.compose.p000ui.layout.LayoutModifier;
import androidx.compose.p000ui.layout.LookaheadLayoutCoordinates;
import androidx.compose.p000ui.layout.LookaheadOnPlacedModifier;
import androidx.compose.p000ui.layout.Measurable;
import androidx.compose.p000ui.layout.MeasureResult;
import androidx.compose.p000ui.layout.MeasureScope;
import androidx.compose.p000ui.layout.OnGloballyPositionedModifier;
import androidx.compose.p000ui.layout.OnPlacedModifier;
import androidx.compose.p000ui.layout.OnRemeasuredModifier;
import androidx.compose.p000ui.layout.ParentDataModifier;
import androidx.compose.p000ui.layout.RemeasurementModifier;
import androidx.compose.p000ui.modifier.BackwardsCompatLocalMap;
import androidx.compose.p000ui.modifier.ModifierLocal;
import androidx.compose.p000ui.modifier.ModifierLocalConsumer;
import androidx.compose.p000ui.modifier.ModifierLocalMap;
import androidx.compose.p000ui.modifier.ModifierLocalNode;
import androidx.compose.p000ui.modifier.ModifierLocalNodeKt;
import androidx.compose.p000ui.modifier.ModifierLocalProvider;
import androidx.compose.p000ui.modifier.ModifierLocalReadScope;
import androidx.compose.p000ui.node.Owner;
import androidx.compose.p000ui.platform.InspectableValueKt;
import androidx.compose.p000ui.platform.InspectorInfo;
import androidx.compose.p000ui.semantics.SemanticsConfiguration;
import androidx.compose.p000ui.semantics.SemanticsModifier;
import androidx.compose.p000ui.unit.Density;
import androidx.compose.p000ui.unit.IntSizeKt;
import androidx.compose.p000ui.unit.LayoutDirection;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BackwardsCompatNode.kt */
@Metadata(m286d1 = {"\u0000þ\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\rB\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\u0010\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020\u001eH\u0002J\b\u0010G\u001a\u00020\u001eH\u0016J\b\u0010H\u001a\u00020EH\u0016J\b\u0010I\u001a\u00020EH\u0016J\b\u0010J\u001a\u00020EH\u0016J\r\u0010K\u001a\u00020EH\u0000¢\u0006\u0002\bLJ\u0010\u0010M\u001a\u00020E2\u0006\u0010N\u001a\u00020\"H\u0016J\u0010\u0010O\u001a\u00020E2\u0006\u0010N\u001a\u00020PH\u0016J\b\u0010Q\u001a\u00020EH\u0016J\u0010\u0010R\u001a\u00020E2\u0006\u0010N\u001a\u00020\"H\u0016J-\u0010S\u001a\u00020E2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u001d\u0010[\u001a\u00020E2\u0006\u00107\u001a\u00020;H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010?J\b\u0010]\u001a\u00020\u001eH\u0016J\b\u0010^\u001a\u00020_H\u0016J\b\u0010`\u001a\u00020EH\u0002J\b\u0010a\u001a\u00020EH\u0002J\u0006\u0010b\u001a\u00020EJ\u0006\u0010c\u001a\u00020EJ\u0012\u0010d\u001a\u00020E2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030eJ\f\u0010f\u001a\u00020E*\u00020gH\u0016J\u001c\u0010h\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020iH\u0016J\u001c\u0010n\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010o\u001a\u00020iH\u0016J)\u0010p\u001a\u00020q*\u00020r2\u0006\u0010k\u001a\u00020s2\u0006\u0010t\u001a\u00020uH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bv\u0010wJ\u001c\u0010x\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010m\u001a\u00020iH\u0016J\u001c\u0010y\u001a\u00020i*\u00020j2\u0006\u0010k\u001a\u00020l2\u0006\u0010o\u001a\u00020iH\u0016J\u0018\u0010z\u001a\u0004\u0018\u00010{*\u00020\u00142\b\u0010|\u001a\u0004\u0018\u00010{H\u0016R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R$\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u0010R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\u00020\u001e8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010#\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b%\u0010&R\u0014\u0010'\u001a\u00020(8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R2\u0010+\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030-0,j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030-`.X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u0014\u00103\u001a\u0002048VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b5\u00106R\u001d\u00107\u001a\u0002088VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b9\u0010:R-\u0010<\u001a\u00020;2\u0006\u0010\u0017\u001a\u00020;8V@VX\u0096\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\f\u001a\u0004\b=\u0010:\"\u0004\b>\u0010?R$\u0010@\u001a\u0002HA\"\u0004\b\u0000\u0010A*\b\u0012\u0004\u0012\u0002HA0-8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\bB\u0010C\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006}"}, m287d2 = {"Landroidx/compose/ui/node/BackwardsCompatNode;", "Landroidx/compose/ui/node/LayoutModifierNode;", "Landroidx/compose/ui/node/IntermediateLayoutModifierNode;", "Landroidx/compose/ui/node/DrawModifierNode;", "Landroidx/compose/ui/node/SemanticsModifierNode;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "Landroidx/compose/ui/modifier/ModifierLocalNode;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "Landroidx/compose/ui/node/ParentDataModifierNode;", "Landroidx/compose/ui/node/LayoutAwareModifierNode;", "Landroidx/compose/ui/node/GlobalPositionAwareModifierNode;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/draw/BuildDrawCacheParams;", "Landroidx/compose/ui/Modifier$Node;", "element", "Landroidx/compose/ui/Modifier$Element;", "(Landroidx/compose/ui/Modifier$Element;)V", "_providedValues", "Landroidx/compose/ui/modifier/BackwardsCompatLocalMap;", "density", "Landroidx/compose/ui/unit/Density;", "getDensity", "()Landroidx/compose/ui/unit/Density;", "value", "getElement", "()Landroidx/compose/ui/Modifier$Element;", "setElement", "focusOrderElement", "Landroidx/compose/ui/focus/FocusPropertiesModifier;", "invalidateCache", "", "isValid", "()Z", "lastOnPlacedCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "providedValues", "Landroidx/compose/ui/modifier/ModifierLocalMap;", "getProvidedValues", "()Landroidx/compose/ui/modifier/ModifierLocalMap;", "readValues", "Ljava/util/HashSet;", "Landroidx/compose/ui/modifier/ModifierLocal;", "Lkotlin/collections/HashSet;", "getReadValues", "()Ljava/util/HashSet;", "setReadValues", "(Ljava/util/HashSet;)V", "semanticsConfiguration", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getSemanticsConfiguration", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "()J", "Landroidx/compose/ui/unit/IntSize;", "targetSize", "getTargetSize-YbymL2g", "setTargetSize-ozmzZPI", "(J)V", "current", "T", "getCurrent", "(Landroidx/compose/ui/modifier/ModifierLocal;)Ljava/lang/Object;", "initializeModifier", "", "duringAttach", "interceptOutOfBoundsChildEvents", "onAttach", "onCancelPointerInput", "onDetach", "onDrawCacheReadsChanged", "onDrawCacheReadsChanged$ui_release", "onGloballyPositioned", "coordinates", "onLookaheadPlaced", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "onMeasureResultChanged", "onPlaced", "onPointerEvent", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "pass", "Landroidx/compose/ui/input/pointer/PointerEventPass;", "bounds", "onPointerEvent-H0pRuoY", "(Landroidx/compose/ui/input/pointer/PointerEvent;Landroidx/compose/ui/input/pointer/PointerEventPass;J)V", "onRemeasured", "onRemeasured-ozmzZPI", "sharePointerInputWithSiblings", "toString", "", "uninitializeModifier", "updateDrawCache", "updateFocusOrderModifierLocalConsumer", "updateModifierLocalConsumer", "updateModifierLocalProvider", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "draw", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "modifyParentData", "", "parentData", "ui_release"}, m288k = 1, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class BackwardsCompatNode extends Modifier.Node implements LayoutModifierNode, IntermediateLayoutModifierNode, DrawModifierNode, SemanticsModifierNode, PointerInputModifierNode, ModifierLocalNode, ModifierLocalReadScope, ParentDataModifierNode, LayoutAwareModifierNode, GlobalPositionAwareModifierNode, OwnerScope, BuildDrawCacheParams {
    private BackwardsCompatLocalMap _providedValues;
    private Modifier.Element element;
    private FocusPropertiesModifier focusOrderElement;
    private boolean invalidateCache;
    private LayoutCoordinates lastOnPlacedCoordinates;
    private HashSet<ModifierLocal<?>> readValues;

    public BackwardsCompatNode(Modifier.Element element) {
        Intrinsics.checkNotNullParameter(element, "element");
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(element));
        this.element = element;
        this.invalidateCache = true;
        this.readValues = new HashSet<>();
    }

    public final Modifier.Element getElement() {
        return this.element;
    }

    public final void setElement(Modifier.Element value) {
        Intrinsics.checkNotNullParameter(value, "value");
        if (getIsAttached()) {
            uninitializeModifier();
        }
        this.element = value;
        setKindSet$ui_release(NodeKindKt.calculateNodeKindSetFrom(value));
        if (getIsAttached()) {
            initializeModifier(false);
        }
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onAttach() {
        initializeModifier(true);
    }

    @Override // androidx.compose.ui.Modifier.Node
    public void onDetach() {
        uninitializeModifier();
    }

    private final void uninitializeModifier() {
        FocusPropertiesModifier focusOrderElement;
        BackwardsCompatNodeKt$DetachedModifierLocalReadScope$1 backwardsCompatNodeKt$DetachedModifierLocalReadScope$1;
        if (!getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Element element = this.element;
        BackwardsCompatNode this_$iv = this;
        int kind$iv = Nodes.INSTANCE.m3710getLocalsOLwlOKw();
        Modifier.Node this_$iv2 = (this_$iv.getKindSet() & kind$iv) != 0 ? 1 : null;
        if (this_$iv2 != null) {
            if (element instanceof ModifierLocalProvider) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, ((ModifierLocalProvider) element).getKey());
            }
            if (element instanceof ModifierLocalConsumer) {
                backwardsCompatNodeKt$DetachedModifierLocalReadScope$1 = BackwardsCompatNodeKt.DetachedModifierLocalReadScope;
                ((ModifierLocalConsumer) element).onModifierLocalsUpdated(backwardsCompatNodeKt$DetachedModifierLocalReadScope$1);
            }
            if ((element instanceof FocusOrderModifier) && (focusOrderElement = this.focusOrderElement) != null) {
                DelegatableNodeKt.requireOwner(this).getModifierLocalManager().removedProvider(this, focusOrderElement.getKey());
            }
        }
        BackwardsCompatNode this_$iv3 = this;
        int kind$iv2 = Nodes.INSTANCE.m3713getSemanticsOLwlOKw();
        if ((this_$iv3.getKindSet() & kind$iv2) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
    }

    private final void initializeModifier(boolean duringAttach) {
        if (!getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Element element = this.element;
        BackwardsCompatNode this_$iv = this;
        int kind$iv = Nodes.INSTANCE.m3710getLocalsOLwlOKw();
        Modifier.Node this_$iv2 = (this_$iv.getKindSet() & kind$iv) != 0 ? 1 : null;
        if (this_$iv2 != null) {
            if (element instanceof ModifierLocalProvider) {
                updateModifierLocalProvider((ModifierLocalProvider) element);
            }
            if (element instanceof ModifierLocalConsumer) {
                if (duringAttach) {
                    updateModifierLocalConsumer();
                } else {
                    sideEffect(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$1
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            BackwardsCompatNode.this.updateModifierLocalConsumer();
                        }
                    });
                }
            }
            if (element instanceof FocusOrderModifier) {
                final FocusOrderModifierToProperties scope = new FocusOrderModifierToProperties((FocusOrderModifier) element);
                this.focusOrderElement = new FocusPropertiesModifier(scope, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$$inlined$debugInspectorInfo$1
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                        invoke2(inspectorInfo);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(InspectorInfo $this$null) {
                        Intrinsics.checkNotNullParameter($this$null, "$this$null");
                        $this$null.setName("focusProperties");
                        $this$null.getProperties().set("scope", FocusOrderModifierToProperties.this);
                    }
                } : InspectableValueKt.getNoInspectorInfo());
                FocusPropertiesModifier focusPropertiesModifier = this.focusOrderElement;
                Intrinsics.checkNotNull(focusPropertiesModifier);
                updateModifierLocalProvider(focusPropertiesModifier);
                if (duringAttach) {
                    updateFocusOrderModifierLocalConsumer();
                } else {
                    sideEffect(new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$3
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            BackwardsCompatNode.this.updateFocusOrderModifierLocalConsumer();
                        }
                    });
                }
            }
        }
        BackwardsCompatNode this_$iv3 = this;
        int kind$iv2 = Nodes.INSTANCE.m3705getDrawOLwlOKw();
        Modifier.Node this_$iv4 = (this_$iv3.getKindSet() & kind$iv2) != 0 ? 1 : null;
        if (this_$iv4 != null) {
            if (element instanceof DrawCacheModifier) {
                this.invalidateCache = true;
            }
            LayoutModifierNodeKt.invalidateLayer(this);
        }
        BackwardsCompatNode this_$iv5 = this;
        int kind$iv3 = Nodes.INSTANCE.m3708getLayoutOLwlOKw();
        Modifier.Node this_$iv6 = (this_$iv5.getKindSet() & kind$iv3) != 0 ? 1 : null;
        if (this_$iv6 != null) {
            boolean isChainUpdate = DelegatableNodeKt.requireLayoutNode(this).getNodes().getTail().getIsAttached();
            if (isChainUpdate) {
                NodeCoordinator coordinator = getCoordinator();
                Intrinsics.checkNotNull(coordinator);
                ((LayoutModifierNodeCoordinator) coordinator).setLayoutModifierNode$ui_release(this);
                coordinator.onLayoutModifierNodeChanged();
            }
            LayoutModifierNodeKt.invalidateLayer(this);
            DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
        }
        boolean isChainUpdate2 = element instanceof RemeasurementModifier;
        if (isChainUpdate2) {
            ((RemeasurementModifier) element).onRemeasurementAvailable(this);
        }
        BackwardsCompatNode this_$iv7 = this;
        int kind$iv4 = Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw();
        Modifier.Node this_$iv8 = (this_$iv7.getKindSet() & kind$iv4) != 0 ? 1 : null;
        if (this_$iv8 != null) {
            if (element instanceof OnRemeasuredModifier) {
                boolean isChainUpdate3 = DelegatableNodeKt.requireLayoutNode(this).getNodes().getTail().getIsAttached();
                if (isChainUpdate3) {
                    DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
                }
            }
            boolean isChainUpdate4 = element instanceof OnPlacedModifier;
            if (isChainUpdate4) {
                this.lastOnPlacedCoordinates = null;
                boolean isChainUpdate5 = DelegatableNodeKt.requireLayoutNode(this).getNodes().getTail().getIsAttached();
                if (isChainUpdate5) {
                    DelegatableNodeKt.requireOwner(this).registerOnLayoutCompletedListener(new Owner.OnLayoutCompletedListener() { // from class: androidx.compose.ui.node.BackwardsCompatNode$initializeModifier$4
                        @Override // androidx.compose.ui.node.Owner.OnLayoutCompletedListener
                        public void onLayoutComplete() {
                            LayoutCoordinates layoutCoordinates;
                            layoutCoordinates = BackwardsCompatNode.this.lastOnPlacedCoordinates;
                            if (layoutCoordinates == null) {
                                BackwardsCompatNode.this.onPlaced(DelegatableNodeKt.m3597requireCoordinator64DMado(BackwardsCompatNode.this, Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw()));
                            }
                        }
                    });
                }
            }
        }
        BackwardsCompatNode this_$iv9 = this;
        int kind$iv5 = Nodes.INSTANCE.m3706getGlobalPositionAwareOLwlOKw();
        Modifier.Node this_$iv10 = (this_$iv9.getKindSet() & kind$iv5) != 0 ? 1 : null;
        if (this_$iv10 != null && (element instanceof OnGloballyPositionedModifier)) {
            boolean isChainUpdate6 = DelegatableNodeKt.requireLayoutNode(this).getNodes().getTail().getIsAttached();
            if (isChainUpdate6) {
                DelegatableNodeKt.requireLayoutNode(this).invalidateMeasurements$ui_release();
            }
        }
        BackwardsCompatNode this_$iv11 = this;
        int kind$iv6 = Nodes.INSTANCE.m3712getPointerInputOLwlOKw();
        Modifier.Node this_$iv12 = (this_$iv11.getKindSet() & kind$iv6) != 0 ? 1 : null;
        if (this_$iv12 != null && (element instanceof PointerInputModifier)) {
            ((PointerInputModifier) element).getPointerInputFilter().setLayoutCoordinates$ui_release(getCoordinator());
        }
        BackwardsCompatNode this_$iv13 = this;
        int kind$iv7 = Nodes.INSTANCE.m3713getSemanticsOLwlOKw();
        if ((this_$iv13.getKindSet() & kind$iv7) != 0) {
            DelegatableNodeKt.requireOwner(this).onSemanticsChange();
        }
    }

    @Override // androidx.compose.p000ui.draw.BuildDrawCacheParams
    public Density getDensity() {
        return DelegatableNodeKt.requireLayoutNode(this).getDensity();
    }

    @Override // androidx.compose.p000ui.draw.BuildDrawCacheParams
    public LayoutDirection getLayoutDirection() {
        return DelegatableNodeKt.requireLayoutNode(this).getLayoutDirection();
    }

    @Override // androidx.compose.p000ui.draw.BuildDrawCacheParams
    /* renamed from: getSize-NH-jbRc */
    public long mo1671getSizeNHjbRc() {
        return IntSizeKt.m4552toSizeozmzZPI(DelegatableNodeKt.m3597requireCoordinator64DMado(this, Nodes.INSTANCE.m3709getLayoutAwareOLwlOKw()).mo3497getSizeYbymL2g());
    }

    @Override // androidx.compose.p000ui.node.DrawModifierNode
    public void onMeasureResultChanged() {
        this.invalidateCache = true;
        DrawModifierNodeKt.requestDraw(this);
    }

    private final void updateDrawCache() {
        Function1 function1;
        final Modifier.Element element = this.element;
        if (element instanceof DrawCacheModifier) {
            function1 = BackwardsCompatNodeKt.onDrawCacheReadsChanged;
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateDrawCache$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    ((DrawCacheModifier) Modifier.Element.this).onBuildCache(this);
                }
            });
        }
        this.invalidateCache = false;
    }

    public final void onDrawCacheReadsChanged$ui_release() {
        this.invalidateCache = true;
        DrawModifierNodeKt.requestDraw(this);
    }

    public final HashSet<ModifierLocal<?>> getReadValues() {
        return this.readValues;
    }

    public final void setReadValues(HashSet<ModifierLocal<?>> hashSet) {
        Intrinsics.checkNotNullParameter(hashSet, "<set-?>");
        this.readValues = hashSet;
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalNode
    public ModifierLocalMap getProvidedValues() {
        BackwardsCompatLocalMap backwardsCompatLocalMap = this._providedValues;
        return backwardsCompatLocalMap != null ? backwardsCompatLocalMap : ModifierLocalNodeKt.modifierLocalMapOf();
    }

    @Override // androidx.compose.p000ui.modifier.ModifierLocalNode, androidx.compose.p000ui.modifier.ModifierLocalReadScope
    public <T> T getCurrent(ModifierLocal<T> modifierLocal) {
        NodeChain nodes;
        Intrinsics.checkNotNullParameter(modifierLocal, "<this>");
        this.readValues.add(modifierLocal);
        BackwardsCompatNode backwardsCompatNode = this;
        int m3710getLocalsOLwlOKw = Nodes.INSTANCE.m3710getLocalsOLwlOKw();
        if (!backwardsCompatNode.getNode().getIsAttached()) {
            throw new IllegalStateException("Check failed.".toString());
        }
        Modifier.Node parent = backwardsCompatNode.getNode().getParent();
        LayoutNode requireLayoutNode = DelegatableNodeKt.requireLayoutNode(backwardsCompatNode);
        while (requireLayoutNode != null) {
            if ((requireLayoutNode.getNodes().getHead().getAggregateChildKindSet() & m3710getLocalsOLwlOKw) != 0) {
                while (parent != null) {
                    if ((parent.getKindSet() & m3710getLocalsOLwlOKw) != 0) {
                        Object obj = parent;
                        if (obj instanceof ModifierLocalNode) {
                            ModifierLocalNode modifierLocalNode = (ModifierLocalNode) obj;
                            if (modifierLocalNode.getProvidedValues().contains$ui_release(modifierLocal)) {
                                return (T) modifierLocalNode.getProvidedValues().get$ui_release(modifierLocal);
                            }
                        } else {
                            continue;
                        }
                    }
                    parent = parent.getParent();
                }
            }
            requireLayoutNode = requireLayoutNode.getParent$ui_release();
            parent = (requireLayoutNode == null || (nodes = requireLayoutNode.getNodes()) == null) ? null : nodes.getTail();
        }
        return modifierLocal.getDefaultFactory$ui_release().invoke();
    }

    public final void updateModifierLocalConsumer() {
        Function1 function1;
        if (getIsAttached()) {
            this.readValues.clear();
            function1 = BackwardsCompatNodeKt.updateModifierLocalConsumer;
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateModifierLocalConsumer$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    Modifier.Element element = BackwardsCompatNode.this.getElement();
                    Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.modifier.ModifierLocalConsumer");
                    ((ModifierLocalConsumer) element).onModifierLocalsUpdated(BackwardsCompatNode.this);
                }
            });
        }
    }

    public final void updateFocusOrderModifierLocalConsumer() {
        Function1 function1;
        if (getIsAttached()) {
            function1 = BackwardsCompatNodeKt.updateFocusOrderModifierLocalConsumer;
            DelegatableNodeKt.requireOwner(this).getSnapshotObserver().observeReads$ui_release(this, function1, new Function0<Unit>() { // from class: androidx.compose.ui.node.BackwardsCompatNode$updateFocusOrderModifierLocalConsumer$1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    FocusPropertiesModifier focusPropertiesModifier;
                    focusPropertiesModifier = BackwardsCompatNode.this.focusOrderElement;
                    Intrinsics.checkNotNull(focusPropertiesModifier);
                    focusPropertiesModifier.onModifierLocalsUpdated(BackwardsCompatNode.this);
                }
            });
        }
    }

    public final void updateModifierLocalProvider(ModifierLocalProvider<?> element) {
        Intrinsics.checkNotNullParameter(element, "element");
        BackwardsCompatLocalMap providedValues = this._providedValues;
        if (providedValues != null && providedValues.contains$ui_release(element.getKey())) {
            providedValues.setElement(element);
            DelegatableNodeKt.requireOwner(this).getModifierLocalManager().updatedProvider(this, element.getKey());
            return;
        }
        this._providedValues = new BackwardsCompatLocalMap(element);
        boolean isChainUpdate = DelegatableNodeKt.requireLayoutNode(this).getNodes().getTail().getIsAttached();
        if (isChainUpdate) {
            DelegatableNodeKt.requireOwner(this).getModifierLocalManager().insertedProvider(this, element.getKey());
        }
    }

    @Override // androidx.compose.p000ui.node.OwnerScope
    public boolean isValid() {
        return getIsAttached();
    }

    @Override // androidx.compose.p000ui.node.IntermediateLayoutModifierNode
    /* renamed from: getTargetSize-YbymL2g, reason: not valid java name */
    public long mo3578getTargetSizeYbymL2g() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        return ((IntermediateLayoutModifier) element).getTargetSize();
    }

    @Override // androidx.compose.p000ui.node.IntermediateLayoutModifierNode
    /* renamed from: setTargetSize-ozmzZPI, reason: not valid java name */
    public void mo3582setTargetSizeozmzZPI(long value) {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.IntermediateLayoutModifier");
        ((IntermediateLayoutModifier) element).mo3495setTargetSizeozmzZPI(value);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    /* renamed from: measure-3p2s80s, reason: not valid java name */
    public MeasureResult mo3579measure3p2s80s(MeasureScope measure, Measurable measurable, long constraints) {
        Intrinsics.checkNotNullParameter(measure, "$this$measure");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        LayoutModifier $this$measure_3p2s80s_u24lambda_u2d2 = (LayoutModifier) element;
        return $this$measure_3p2s80s_u24lambda_u2d2.mo346measure3p2s80s(measure, measurable, constraints);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int minIntrinsicWidth(IntrinsicMeasureScope $this$minIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        LayoutModifier $this$minIntrinsicWidth_u24lambda_u2d3 = (LayoutModifier) element;
        return $this$minIntrinsicWidth_u24lambda_u2d3.minIntrinsicWidth($this$minIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int minIntrinsicHeight(IntrinsicMeasureScope $this$minIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$minIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        LayoutModifier $this$minIntrinsicHeight_u24lambda_u2d4 = (LayoutModifier) element;
        return $this$minIntrinsicHeight_u24lambda_u2d4.minIntrinsicHeight($this$minIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int maxIntrinsicWidth(IntrinsicMeasureScope $this$maxIntrinsicWidth, IntrinsicMeasurable measurable, int height) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicWidth, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        LayoutModifier $this$maxIntrinsicWidth_u24lambda_u2d5 = (LayoutModifier) element;
        return $this$maxIntrinsicWidth_u24lambda_u2d5.maxIntrinsicWidth($this$maxIntrinsicWidth, measurable, height);
    }

    @Override // androidx.compose.p000ui.node.LayoutModifierNode
    public int maxIntrinsicHeight(IntrinsicMeasureScope $this$maxIntrinsicHeight, IntrinsicMeasurable measurable, int width) {
        Intrinsics.checkNotNullParameter($this$maxIntrinsicHeight, "<this>");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.LayoutModifier");
        LayoutModifier $this$maxIntrinsicHeight_u24lambda_u2d6 = (LayoutModifier) element;
        return $this$maxIntrinsicHeight_u24lambda_u2d6.maxIntrinsicHeight($this$maxIntrinsicHeight, measurable, width);
    }

    @Override // androidx.compose.p000ui.node.DrawModifierNode
    public void draw(ContentDrawScope $this$draw) {
        Intrinsics.checkNotNullParameter($this$draw, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.draw.DrawModifier");
        DrawModifier $this$draw_u24lambda_u2d7 = (DrawModifier) element;
        if (this.invalidateCache && (element instanceof DrawCacheModifier)) {
            updateDrawCache();
        }
        $this$draw_u24lambda_u2d7.draw($this$draw);
    }

    @Override // androidx.compose.p000ui.node.SemanticsModifierNode
    public SemanticsConfiguration getSemanticsConfiguration() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.semantics.SemanticsModifier");
        return ((SemanticsModifier) element).getSemanticsConfiguration();
    }

    @Override // androidx.compose.p000ui.node.PointerInputModifierNode
    /* renamed from: onPointerEvent-H0pRuoY, reason: not valid java name */
    public void mo3580onPointerEventH0pRuoY(PointerEvent pointerEvent, PointerEventPass pass, long bounds) {
        Intrinsics.checkNotNullParameter(pointerEvent, "pointerEvent");
        Intrinsics.checkNotNullParameter(pass, "pass");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        PointerInputModifier $this$onPointerEvent_H0pRuoY_u24lambda_u2d8 = (PointerInputModifier) element;
        $this$onPointerEvent_H0pRuoY_u24lambda_u2d8.getPointerInputFilter().mo3385onPointerEventH0pRuoY(pointerEvent, pass, bounds);
    }

    @Override // androidx.compose.p000ui.node.PointerInputModifierNode
    public void onCancelPointerInput() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        PointerInputModifier $this$onCancelPointerInput_u24lambda_u2d9 = (PointerInputModifier) element;
        $this$onCancelPointerInput_u24lambda_u2d9.getPointerInputFilter().onCancel();
    }

    @Override // androidx.compose.p000ui.node.PointerInputModifierNode
    public boolean sharePointerInputWithSiblings() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        PointerInputModifier $this$sharePointerInputWithSiblings_u24lambda_u2d10 = (PointerInputModifier) element;
        return $this$sharePointerInputWithSiblings_u24lambda_u2d10.getPointerInputFilter().getShareWithSiblings();
    }

    @Override // androidx.compose.p000ui.node.PointerInputModifierNode
    public boolean interceptOutOfBoundsChildEvents() {
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.input.pointer.PointerInputModifier");
        PointerInputModifier $this$interceptOutOfBoundsChildEvents_u24lambda_u2d11 = (PointerInputModifier) element;
        return $this$interceptOutOfBoundsChildEvents_u24lambda_u2d11.getPointerInputFilter().getInterceptOutOfBoundsChildEvents();
    }

    @Override // androidx.compose.p000ui.node.ParentDataModifierNode
    public Object modifyParentData(Density $this$modifyParentData, Object parentData) {
        Intrinsics.checkNotNullParameter($this$modifyParentData, "<this>");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.ParentDataModifier");
        ParentDataModifier $this$modifyParentData_u24lambda_u2d12 = (ParentDataModifier) element;
        return $this$modifyParentData_u24lambda_u2d12.modifyParentData($this$modifyParentData, parentData);
    }

    @Override // androidx.compose.p000ui.node.GlobalPositionAwareModifierNode
    public void onGloballyPositioned(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Modifier.Element element = this.element;
        Intrinsics.checkNotNull(element, "null cannot be cast to non-null type androidx.compose.ui.layout.OnGloballyPositionedModifier");
        ((OnGloballyPositionedModifier) element).onGloballyPositioned(coordinates);
    }

    @Override // androidx.compose.p000ui.node.LayoutAwareModifierNode
    public void onLookaheadPlaced(LookaheadLayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        Modifier.Element element = this.element;
        if (element instanceof LookaheadOnPlacedModifier) {
            ((LookaheadOnPlacedModifier) element).onPlaced(coordinates);
        }
    }

    @Override // androidx.compose.p000ui.node.LayoutAwareModifierNode
    /* renamed from: onRemeasured-ozmzZPI, reason: not valid java name */
    public void mo3581onRemeasuredozmzZPI(long size) {
        Modifier.Element element = this.element;
        if (element instanceof OnRemeasuredModifier) {
            ((OnRemeasuredModifier) element).mo572onRemeasuredozmzZPI(size);
        }
    }

    @Override // androidx.compose.p000ui.node.LayoutAwareModifierNode
    public void onPlaced(LayoutCoordinates coordinates) {
        Intrinsics.checkNotNullParameter(coordinates, "coordinates");
        this.lastOnPlacedCoordinates = coordinates;
        Modifier.Element element = this.element;
        if (element instanceof OnPlacedModifier) {
            ((OnPlacedModifier) element).onPlaced(coordinates);
        }
    }

    public String toString() {
        return this.element.toString();
    }
}
