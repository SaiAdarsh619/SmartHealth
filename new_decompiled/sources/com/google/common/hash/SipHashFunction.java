package com.google.common.hash;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.nio.ByteBuffer;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes14.dex */
final class SipHashFunction extends AbstractHashFunction implements Serializable {
    static final HashFunction SIP_HASH_24 = new SipHashFunction(2, 4, 506097522914230528L, 1084818905618843912L);
    private static final long serialVersionUID = 0;

    /* renamed from: c */
    private final int f284c;

    /* renamed from: d */
    private final int f285d;

    /* renamed from: k0 */
    private final long f286k0;

    /* renamed from: k1 */
    private final long f287k1;

    SipHashFunction(int c, int d, long k0, long k1) {
        Preconditions.checkArgument(c > 0, "The number of SipRound iterations (c=%s) during Compression must be positive.", c);
        Preconditions.checkArgument(d > 0, "The number of SipRound iterations (d=%s) during Finalization must be positive.", d);
        this.f284c = c;
        this.f285d = d;
        this.f286k0 = k0;
        this.f287k1 = k1;
    }

    @Override // com.google.common.hash.HashFunction
    public int bits() {
        return 64;
    }

    @Override // com.google.common.hash.HashFunction
    public Hasher newHasher() {
        return new SipHasher(this.f284c, this.f285d, this.f286k0, this.f287k1);
    }

    public String toString() {
        int i = this.f284c;
        int i2 = this.f285d;
        long j = this.f286k0;
        return new StringBuilder(81).append("Hashing.sipHash").append(i).append(i2).append("(").append(j).append(", ").append(this.f287k1).append(")").toString();
    }

    public boolean equals(@CheckForNull Object object) {
        if (!(object instanceof SipHashFunction)) {
            return false;
        }
        SipHashFunction other = (SipHashFunction) object;
        return this.f284c == other.f284c && this.f285d == other.f285d && this.f286k0 == other.f286k0 && this.f287k1 == other.f287k1;
    }

    public int hashCode() {
        return (int) ((((getClass().hashCode() ^ this.f284c) ^ this.f285d) ^ this.f286k0) ^ this.f287k1);
    }

    private static final class SipHasher extends AbstractStreamingHasher {
        private static final int CHUNK_SIZE = 8;

        /* renamed from: b */
        private long f288b;

        /* renamed from: c */
        private final int f289c;

        /* renamed from: d */
        private final int f290d;
        private long finalM;

        /* renamed from: v0 */
        private long f291v0;

        /* renamed from: v1 */
        private long f292v1;

        /* renamed from: v2 */
        private long f293v2;

        /* renamed from: v3 */
        private long f294v3;

        SipHasher(int c, int d, long k0, long k1) {
            super(8);
            this.f291v0 = 8317987319222330741L;
            this.f292v1 = 7237128888997146477L;
            this.f293v2 = 7816392313619706465L;
            this.f294v3 = 8387220255154660723L;
            this.f288b = 0L;
            this.finalM = 0L;
            this.f289c = c;
            this.f290d = d;
            this.f291v0 ^= k0;
            this.f292v1 ^= k1;
            this.f293v2 ^= k0;
            this.f294v3 ^= k1;
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void process(ByteBuffer buffer) {
            this.f288b += 8;
            processM(buffer.getLong());
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected void processRemaining(ByteBuffer buffer) {
            this.f288b += buffer.remaining();
            int i = 0;
            while (buffer.hasRemaining()) {
                this.finalM ^= (buffer.get() & 255) << i;
                i += 8;
            }
        }

        @Override // com.google.common.hash.AbstractStreamingHasher
        protected HashCode makeHash() {
            this.finalM ^= this.f288b << 56;
            processM(this.finalM);
            this.f293v2 ^= 255;
            sipRound(this.f290d);
            return HashCode.fromLong(((this.f291v0 ^ this.f292v1) ^ this.f293v2) ^ this.f294v3);
        }

        private void processM(long m) {
            this.f294v3 ^= m;
            sipRound(this.f289c);
            this.f291v0 ^= m;
        }

        private void sipRound(int iterations) {
            for (int i = 0; i < iterations; i++) {
                this.f291v0 += this.f292v1;
                this.f293v2 += this.f294v3;
                this.f292v1 = Long.rotateLeft(this.f292v1, 13);
                this.f294v3 = Long.rotateLeft(this.f294v3, 16);
                this.f292v1 ^= this.f291v0;
                this.f294v3 ^= this.f293v2;
                this.f291v0 = Long.rotateLeft(this.f291v0, 32);
                this.f293v2 += this.f292v1;
                this.f291v0 += this.f294v3;
                this.f292v1 = Long.rotateLeft(this.f292v1, 17);
                this.f294v3 = Long.rotateLeft(this.f294v3, 21);
                this.f292v1 ^= this.f293v2;
                this.f294v3 ^= this.f291v0;
                this.f293v2 = Long.rotateLeft(this.f293v2, 32);
            }
        }
    }
}
