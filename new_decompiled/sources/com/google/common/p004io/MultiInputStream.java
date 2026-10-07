package com.google.common.p004io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes14.dex */
final class MultiInputStream extends InputStream {

    /* renamed from: in */
    @CheckForNull
    private InputStream f309in;

    /* renamed from: it */
    private Iterator<? extends ByteSource> f310it;

    public MultiInputStream(Iterator<? extends ByteSource> it) throws IOException {
        this.f310it = (Iterator) Preconditions.checkNotNull(it);
        advance();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.f309in != null) {
            try {
                this.f309in.close();
            } finally {
                this.f309in = null;
            }
        }
    }

    private void advance() throws IOException {
        close();
        if (this.f310it.hasNext()) {
            this.f309in = this.f310it.next().openStream();
        }
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        if (this.f309in == null) {
            return 0;
        }
        return this.f309in.available();
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return false;
    }

    @Override // java.io.InputStream
    public int read() throws IOException {
        while (this.f309in != null) {
            int result = this.f309in.read();
            if (result != -1) {
                return result;
            }
            advance();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public int read(byte[] b, int off, int len) throws IOException {
        Preconditions.checkNotNull(b);
        while (this.f309in != null) {
            int result = this.f309in.read(b, off, len);
            if (result != -1) {
                return result;
            }
            advance();
        }
        return -1;
    }

    @Override // java.io.InputStream
    public long skip(long n) throws IOException {
        if (this.f309in == null || n <= 0) {
            return 0L;
        }
        long result = this.f309in.skip(n);
        if (result != 0) {
            return result;
        }
        if (read() == -1) {
            return 0L;
        }
        return this.f309in.skip(n - 1) + 1;
    }
}
