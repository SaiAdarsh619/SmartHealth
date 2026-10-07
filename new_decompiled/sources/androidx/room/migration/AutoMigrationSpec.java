package androidx.room.migration;

import androidx.sqlite.p003db.SupportSQLiteDatabase;

/* loaded from: classes14.dex */
public interface AutoMigrationSpec {
    default void onPostMigrate(SupportSQLiteDatabase db) {
    }
}
