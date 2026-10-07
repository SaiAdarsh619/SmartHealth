package com.google.common.p004io;

import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes14.dex */
class MultiReader extends Reader {

    @CheckForNull
    private Reader current;

    /* renamed from: it */
    private final Iterator<? extends CharSource> f311it;

    MultiReader(Iterator<? extends CharSource> readers) throws IOException {
        this.f311it = readers;
        advance();
    }

    private void advance() throws IOException {
        close();
        if (this.f311it.hasNext()) {
            this.current = this.f311it.next().openStream();
        }
    }

    @Override // java.io.Reader
    public int read(char[] cbuf, int off, int len) throws IOException {
        Preconditions.checkNotNull(cbuf);
        if (this.current == null) {
            return -1;
        }
        int result = this.current.read(cbuf, off, len);
        if (result == -1) {
            advance();
            return read(cbuf, off, len);
        }
        return result;
    }

    @Override // java.io.Reader
    public long skip(long n) throws IOException {
        Preconditions.checkArgument(n >= 0, "n is negative");
        if (n > 0) {
            while (this.current != null) {
                long result = this.current.skip(n);
                if (result > 0) {
                    return result;
                }
                advance();
            }
        }
        return 0L;
    }

    @Override // java.io.Reader
    public boolean ready() throws IOException {
        return this.current != null && this.current.ready();
    }

    @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.current != null) {
            try {
                this.current.close();
            } finally {
                this.current = null;
            }
        }
    }
}
