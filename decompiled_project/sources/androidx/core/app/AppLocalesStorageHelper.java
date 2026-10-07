package androidx.core.app;

import android.content.Context;
import android.util.Log;
import android.util.Xml;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.xmlpull.v1.XmlSerializer;
/* loaded from: classes.dex */
public class AppLocalesStorageHelper {
    static final String APPLICATION_LOCALES_RECORD_FILE = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file";
    static final boolean DEBUG = false;
    static final String LOCALE_RECORD_ATTRIBUTE_TAG = "application_locales";
    static final String LOCALE_RECORD_FILE_TAG = "locales";
    static final String TAG = "AppLocalesStorageHelper";
    private static final Object sAppLocaleStorageSync = new Object();

    private AppLocalesStorageHelper() {
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0047, code lost:
        r1 = r3.getAttributeValue(null, androidx.core.app.AppLocalesStorageHelper.LOCALE_RECORD_ATTRIBUTE_TAG);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static java.lang.String readLocales(android.content.Context r9) {
        /*
            java.lang.Object r0 = androidx.core.app.AppLocalesStorageHelper.sAppLocaleStorageSync
            monitor-enter(r0)
            java.lang.String r1 = ""
            java.lang.String r2 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            java.io.FileInputStream r2 = r9.openFileInput(r2)     // Catch: java.io.FileNotFoundException -> L7e java.lang.Throwable -> L81
            org.xmlpull.v1.XmlPullParser r3 = android.util.Xml.newPullParser()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
            java.lang.String r4 = "UTF-8"
            r3.setInput(r2, r4)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
            int r4 = r3.getDepth()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
        L1b:
            int r5 = r3.next()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
            r6 = r5
            r7 = 1
            if (r5 == r7) goto L4a
            r5 = 3
            if (r6 != r5) goto L2c
            int r7 = r3.getDepth()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
            if (r7 <= r4) goto L4a
        L2c:
            if (r6 == r5) goto L1b
            r5 = 4
            if (r6 != r5) goto L32
            goto L1b
        L32:
            java.lang.String r5 = r3.getName()     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
            java.lang.String r7 = "locales"
            boolean r7 = r5.equals(r7)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
            if (r7 == 0) goto L49
            java.lang.String r7 = "application_locales"
            r8 = 0
            java.lang.String r7 = r3.getAttributeValue(r8, r7)     // Catch: java.lang.Throwable -> L52 java.io.IOException -> L54 org.xmlpull.v1.XmlPullParserException -> L56
            r1 = r7
            goto L4a
        L49:
            goto L1b
        L4a:
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L50 java.lang.Throwable -> L81
        L4f:
            goto L66
        L50:
            r3 = move-exception
            goto L4f
        L52:
            r3 = move-exception
            goto L75
        L54:
            r3 = move-exception
            goto L57
        L56:
            r3 = move-exception
        L57:
            java.lang.String r4 = "AppLocalesStorageHelper"
            java.lang.String r5 = "Reading app Locales : Unable to parse through file :androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            android.util.Log.w(r4, r5)     // Catch: java.lang.Throwable -> L52
            if (r2 == 0) goto L66
            r2.close()     // Catch: java.io.IOException -> L50 java.lang.Throwable -> L81
            goto L4f
        L66:
            boolean r3 = r1.isEmpty()     // Catch: java.lang.Throwable -> L81
            if (r3 != 0) goto L6d
            goto L73
        L6d:
            java.lang.String r3 = "androidx.appcompat.app.AppCompatDelegate.application_locales_record_file"
            r9.deleteFile(r3)     // Catch: java.lang.Throwable -> L81
        L73:
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L81
            return r1
        L75:
            if (r2 == 0) goto L7c
            r2.close()     // Catch: java.io.IOException -> L7b java.lang.Throwable -> L81
            goto L7c
        L7b:
            r4 = move-exception
        L7c:
            throw r3     // Catch: java.lang.Throwable -> L81
        L7e:
            r2 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L81
            return r1
        L81:
            r1 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L81
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.app.AppLocalesStorageHelper.readLocales(android.content.Context):java.lang.String");
    }

    public static void persistLocales(Context context, String locales) {
        synchronized (sAppLocaleStorageSync) {
            if (locales.equals("")) {
                context.deleteFile(APPLICATION_LOCALES_RECORD_FILE);
                return;
            }
            try {
                FileOutputStream fos = context.openFileOutput(APPLICATION_LOCALES_RECORD_FILE, 0);
                XmlSerializer serializer = Xml.newSerializer();
                try {
                    try {
                        serializer.setOutput(fos, null);
                        serializer.startDocument("UTF-8", true);
                        serializer.startTag(null, LOCALE_RECORD_FILE_TAG);
                        serializer.attribute(null, LOCALE_RECORD_ATTRIBUTE_TAG, locales);
                        serializer.endTag(null, LOCALE_RECORD_FILE_TAG);
                        serializer.endDocument();
                    } catch (Exception e) {
                        Log.w(TAG, "Storing App Locales : Failed to persist app-locales in storage ", e);
                        if (fos != null) {
                            fos.close();
                        }
                    }
                    if (fos != null) {
                        fos.close();
                    }
                } catch (IOException e2) {
                }
            } catch (FileNotFoundException e3) {
                Log.w(TAG, String.format("Storing App Locales : FileNotFoundException: Cannot open file %s for writing ", APPLICATION_LOCALES_RECORD_FILE));
            }
        }
    }
}
