package androidx.compose.animation.core;

import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;

/* compiled from: SpringEstimation.kt */
@Metadata(m286d1 = {"\u00002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a6\u0010\u0000\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003\u001a.\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\u000b\u001a4\u0010\f\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a<\u0010\u0012\u001a\u00020\u00012\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0014\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a4\u0010\u0015\u001a\u00020\u00032\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0002\u001a9\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00192\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0019H\u0082\b\u001a\r\u0010\u001b\u001a\u00020\u001c*\u00020\u0003H\u0082\b¨\u0006\u001d"}, m287d2 = {"estimateAnimationDurationMillis", "", "stiffness", "", "dampingRatio", "initialVelocity", "initialDisplacement", "delta", "springConstant", "dampingCoefficient", "mass", "", "estimateCriticallyDamped", "roots", "Lkotlin/Pair;", "Landroidx/compose/animation/core/ComplexDouble;", "p0", "v0", "estimateDurationInternal", "initialPosition", "estimateOverDamped", "estimateUnderDamped", "iterateNewtonsMethod", "x", "fn", "Lkotlin/Function1;", "fnPrime", "isNotFinite", "", "animation-core_release"}, m288k = 2, m289mv = {1, 7, 1}, m291xi = 48)
/* loaded from: classes.dex */
public final class SpringEstimationKt {
    public static final long estimateAnimationDurationMillis(float stiffness, float dampingRatio, float initialVelocity, float initialDisplacement, float delta) {
        return estimateAnimationDurationMillis(stiffness, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    public static final long estimateAnimationDurationMillis(double stiffness, double dampingRatio, double initialVelocity, double initialDisplacement, double delta) {
        double dampingCoefficient = 2.0d * dampingRatio * Math.sqrt(stiffness);
        Pair roots = ComplexDoubleKt.complexQuadraticFormula(1.0d, dampingCoefficient, stiffness);
        return estimateDurationInternal(roots, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    public static final long estimateAnimationDurationMillis(double springConstant, double dampingCoefficient, double mass, double initialVelocity, double initialDisplacement, double delta) {
        double criticalDamping = Math.sqrt(springConstant * mass) * 2.0d;
        double dampingRatio = dampingCoefficient / criticalDamping;
        Pair roots = ComplexDoubleKt.complexQuadraticFormula(mass, dampingCoefficient, springConstant);
        return estimateDurationInternal(roots, dampingRatio, initialVelocity, initialDisplacement, delta);
    }

    private static final double estimateUnderDamped(Pair<ComplexDouble, ComplexDouble> pair, double p0, double v0, double delta) {
        double r = pair.getFirst().getReal();
        double c2 = (v0 - (r * p0)) / pair.getFirst().getImaginary();
        double c = Math.sqrt((p0 * p0) + (c2 * c2));
        return Math.log(delta / c) / r;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x00df  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final double estimateCriticallyDamped(Pair<ComplexDouble, ComplexDouble> pair, final double p0, double v0, double delta) {
        double max;
        final double signedDelta;
        Function1 fn;
        Function1 fnPrime;
        double tDelta;
        int iterations;
        final double r = pair.getFirst().getReal();
        final double c2 = v0 - (r * p0);
        double t1 = Math.log(Math.abs(delta / p0)) / r;
        double t2 = estimateCriticallyDamped$t2Iterate(Math.log(Math.abs(delta / c2)), r) / r;
        boolean z = false;
        if ((Double.isInfinite(t1) || Double.isNaN(t1)) ? false : true) {
            if (!Double.isInfinite(t2) && !Double.isNaN(t2)) {
                z = true;
            }
            max = !z ? t1 : Math.max(t1, t2);
        } else {
            max = t2;
        }
        double tCurr = max;
        double tInflection = (-((r * p0) + c2)) / (r * c2);
        if (!Double.isNaN(tInflection) && tInflection > 0.0d) {
            if (tInflection > 0.0d && (-estimateCriticallyDamped$xInflection(p0, r, tInflection, c2)) < delta) {
                if (c2 < 0.0d && p0 > 0.0d) {
                    tCurr = 0.0d;
                }
                signedDelta = -delta;
                fn = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Double invoke(double t) {
                        return Double.valueOf(((p0 + (c2 * t)) * Math.exp(r * t)) + signedDelta);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Double invoke(Double d) {
                        return invoke(d.doubleValue());
                    }
                };
                fnPrime = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public final Double invoke(double t) {
                        return Double.valueOf(((c2 * ((r * t) + 1)) + (p0 * r)) * Math.exp(r * t));
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Double invoke(Double d) {
                        return invoke(d.doubleValue());
                    }
                };
                tDelta = Double.MAX_VALUE;
                iterations = 0;
                while (tDelta > 0.001d && iterations < 100) {
                    iterations++;
                    double tLast = tCurr;
                    tCurr -= fn.invoke(Double.valueOf(tCurr)).doubleValue() / fnPrime.invoke(Double.valueOf(tCurr)).doubleValue();
                    tDelta = Math.abs(tLast - tCurr);
                    fn = fn;
                }
                return tCurr;
            }
            double tConcavChange = (-(2.0d / r)) - (p0 / c2);
            tCurr = tConcavChange;
            signedDelta = delta;
            fn = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Double invoke(double t) {
                    return Double.valueOf(((p0 + (c2 * t)) * Math.exp(r * t)) + signedDelta);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Double invoke(Double d) {
                    return invoke(d.doubleValue());
                }
            };
            fnPrime = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Double invoke(double t) {
                    return Double.valueOf(((c2 * ((r * t) + 1)) + (p0 * r)) * Math.exp(r * t));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Double invoke(Double d) {
                    return invoke(d.doubleValue());
                }
            };
            tDelta = Double.MAX_VALUE;
            iterations = 0;
            while (tDelta > 0.001d) {
                iterations++;
                double tLast2 = tCurr;
                tCurr -= fn.invoke(Double.valueOf(tCurr)).doubleValue() / fnPrime.invoke(Double.valueOf(tCurr)).doubleValue();
                tDelta = Math.abs(tLast2 - tCurr);
                fn = fn;
            }
            return tCurr;
        }
        signedDelta = -delta;
        fn = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double t) {
                return Double.valueOf(((p0 + (c2 * t)) * Math.exp(r * t)) + signedDelta);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        };
        fnPrime = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateCriticallyDamped$fnPrime$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double t) {
                return Double.valueOf(((c2 * ((r * t) + 1)) + (p0 * r)) * Math.exp(r * t));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d) {
                return invoke(d.doubleValue());
            }
        };
        tDelta = Double.MAX_VALUE;
        iterations = 0;
        while (tDelta > 0.001d) {
        }
        return tCurr;
    }

    private static final double estimateCriticallyDamped$t2Iterate(double guess, double r) {
        double t = guess;
        for (int i = 0; i < 6; i++) {
            t = guess - Math.log(Math.abs(t / r));
        }
        return t;
    }

    private static final double estimateCriticallyDamped$xInflection(double c1, double r, double tInflection, double c2) {
        return (Math.exp(r * tInflection) * c1) + (c2 * tInflection * Math.exp(r * tInflection));
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x010c A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x010d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static final double estimateOverDamped(Pair<ComplexDouble, ComplexDouble> pair, double p0, double v0, double delta) {
        double max;
        double c2;
        final double signedDelta;
        Function1 fn;
        final double r1 = pair.getFirst().getReal();
        final double r2 = pair.getSecond().getReal();
        double c22 = ((r1 * p0) - v0) / (r1 - r2);
        final double c1 = p0 - c22;
        double t1 = Math.log(Math.abs(delta / c1)) / r1;
        double t2 = Math.log(Math.abs(delta / c22)) / r2;
        boolean z = false;
        if ((Double.isInfinite(t1) || Double.isNaN(t1)) ? false : true) {
            if (!Double.isInfinite(t2) && !Double.isNaN(t2)) {
                z = true;
            }
            max = !z ? t1 : Math.max(t1, t2);
        } else {
            max = t2;
        }
        double tCurr = max;
        double tInflection = Math.log((c1 * r1) / ((-c22) * r2)) / (r2 - r1);
        if (Double.isNaN(tInflection)) {
            c2 = c22;
        } else if (tInflection <= 0.0d) {
            c2 = c22;
        } else {
            if (tInflection > 0.0d) {
                c2 = c22;
                if ((-m448estimateOverDamped$xInflection0(c1, r1, tInflection, c22, r2)) < delta) {
                    if (c2 > 0.0d && c1 < 0.0d) {
                        tCurr = 0.0d;
                    }
                    signedDelta = -delta;
                    final double d = c2;
                    fn = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final Double invoke(double t) {
                            return Double.valueOf((c1 * Math.exp(r1 * t)) + (d * Math.exp(r2 * t)) + signedDelta);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Double invoke(Double d2) {
                            return invoke(d2.doubleValue());
                        }
                    };
                    Function1 fnPrime = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final Double invoke(double t) {
                            return Double.valueOf((c1 * r1 * Math.exp(r1 * t)) + (d * r2 * Math.exp(r2 * t)));
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Double invoke(Double d2) {
                            return invoke(d2.doubleValue());
                        }
                    };
                    if (Math.abs(fn.invoke(Double.valueOf(tCurr)).doubleValue()) < 1.0E-4d) {
                        return tCurr;
                    }
                    double tDelta = Double.MAX_VALUE;
                    int iterations = 0;
                    while (tDelta > 0.001d && iterations < 100) {
                        iterations++;
                        double tLast = tCurr;
                        tCurr -= fn.invoke(Double.valueOf(tCurr)).doubleValue() / fnPrime.invoke(Double.valueOf(tCurr)).doubleValue();
                        tDelta = Math.abs(tLast - tCurr);
                    }
                    return tCurr;
                }
            } else {
                c2 = c22;
            }
            double tConcavChange = Math.log((-((c2 * r2) * r2)) / ((c1 * r1) * r1)) / (r1 - r2);
            tCurr = tConcavChange;
            signedDelta = delta;
            final double d2 = c2;
            fn = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Double invoke(double t) {
                    return Double.valueOf((c1 * Math.exp(r1 * t)) + (d2 * Math.exp(r2 * t)) + signedDelta);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Double invoke(Double d22) {
                    return invoke(d22.doubleValue());
                }
            };
            Function1 fnPrime2 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final Double invoke(double t) {
                    return Double.valueOf((c1 * r1 * Math.exp(r1 * t)) + (d2 * r2 * Math.exp(r2 * t)));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Double invoke(Double d22) {
                    return invoke(d22.doubleValue());
                }
            };
            if (Math.abs(fn.invoke(Double.valueOf(tCurr)).doubleValue()) < 1.0E-4d) {
            }
        }
        signedDelta = -delta;
        final double d22 = c2;
        fn = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fn$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double t) {
                return Double.valueOf((c1 * Math.exp(r1 * t)) + (d22 * Math.exp(r2 * t)) + signedDelta);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d222) {
                return invoke(d222.doubleValue());
            }
        };
        Function1 fnPrime22 = new Function1<Double, Double>() { // from class: androidx.compose.animation.core.SpringEstimationKt$estimateOverDamped$fnPrime$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final Double invoke(double t) {
                return Double.valueOf((c1 * r1 * Math.exp(r1 * t)) + (d22 * r2 * Math.exp(r2 * t)));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Double invoke(Double d222) {
                return invoke(d222.doubleValue());
            }
        };
        if (Math.abs(fn.invoke(Double.valueOf(tCurr)).doubleValue()) < 1.0E-4d) {
        }
    }

    /* renamed from: estimateOverDamped$xInflection-0, reason: not valid java name */
    private static final double m448estimateOverDamped$xInflection0(double c1, double r1, double tInflection, double c2, double r2) {
        return (Math.exp(r1 * tInflection) * c1) + (Math.exp(r2 * tInflection) * c2);
    }

    private static final long estimateDurationInternal(Pair<ComplexDouble, ComplexDouble> pair, double dampingRatio, double initialVelocity, double initialPosition, double delta) {
        double estimateCriticallyDamped;
        if (initialPosition == 0.0d) {
            if (initialVelocity == 0.0d) {
                return 0L;
            }
        }
        double v0 = initialPosition < 0.0d ? -initialVelocity : initialVelocity;
        double p0 = Math.abs(initialPosition);
        if (dampingRatio > 1.0d) {
            estimateCriticallyDamped = estimateOverDamped(pair, p0, v0, delta);
        } else if (dampingRatio < 1.0d) {
            estimateCriticallyDamped = estimateUnderDamped(pair, p0, v0, delta);
        } else {
            estimateCriticallyDamped = estimateCriticallyDamped(pair, p0, v0, delta);
        }
        return (long) (estimateCriticallyDamped * 1000.0d);
    }

    private static final double iterateNewtonsMethod(double x, Function1<? super Double, Double> function1, Function1<? super Double, Double> function12) {
        return x - (function1.invoke(Double.valueOf(x)).doubleValue() / function12.invoke(Double.valueOf(x)).doubleValue());
    }

    private static final boolean isNotFinite(double $this$isNotFinite) {
        return !((Double.isInfinite($this$isNotFinite) || Double.isNaN($this$isNotFinite)) ? false : true);
    }
}
