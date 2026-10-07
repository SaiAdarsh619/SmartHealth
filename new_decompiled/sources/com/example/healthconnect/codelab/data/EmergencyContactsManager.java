package com.example.healthconnect.codelab.data;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.autofill.HintConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: EmergencyContactsManager.kt */
@Metadata(m286d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ\u000e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\fJ\u0016\u0010\u0013\u001a\u00020\n2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0002J\u001e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m287d2 = {"Lcom/example/healthconnect/codelab/data/EmergencyContactsManager;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "gson", "Lcom/google/gson/Gson;", "prefs", "Landroid/content/SharedPreferences;", "addContact", "", HintConstants.AUTOFILL_HINT_NAME, "", HintConstants.AUTOFILL_HINT_PHONE_NUMBER, "getContacts", "", "Lcom/example/healthconnect/codelab/data/EmergencyContact;", "removeContact", "id", "saveContacts", "list", "updateContact", "finished_debug"}, m288k = 1, m289mv = {1, 8, 0}, m291xi = 48)
/* loaded from: classes8.dex */
public final class EmergencyContactsManager {
    public static final int $stable = 8;
    private final Gson gson;
    private final SharedPreferences prefs;

    public EmergencyContactsManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences("emergency_contacts", 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…s\", Context.MODE_PRIVATE)");
        this.prefs = sharedPreferences;
        this.gson = new Gson();
    }

    public final List<EmergencyContact> getContacts() {
        String json = this.prefs.getString("contacts", null);
        if (json == null) {
            return CollectionsKt.emptyList();
        }
        Type type = new TypeToken<List<? extends EmergencyContact>>() { // from class: com.example.healthconnect.codelab.data.EmergencyContactsManager$getContacts$type$1
        }.getType();
        Object fromJson = this.gson.fromJson(json, type);
        Intrinsics.checkNotNullExpressionValue(fromJson, "gson.fromJson(json, type)");
        return (List) fromJson;
    }

    public final void addContact(String name, String phoneNumber) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        List currentList = CollectionsKt.toMutableList((Collection) getContacts());
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        currentList.add(new EmergencyContact(uuid, name, phoneNumber));
        saveContacts(currentList);
    }

    public final void removeContact(final String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        List currentList = CollectionsKt.toMutableList((Collection) getContacts());
        CollectionsKt.removeAll(currentList, (Function1) new Function1<EmergencyContact, Boolean>() { // from class: com.example.healthconnect.codelab.data.EmergencyContactsManager$removeContact$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(EmergencyContact it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return Boolean.valueOf(Intrinsics.areEqual(it.getId(), id));
            }
        });
        saveContacts(currentList);
    }

    public final void updateContact(String id, String name, String phoneNumber) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(phoneNumber, "phoneNumber");
        List currentList = CollectionsKt.toMutableList((Collection) getContacts());
        int index$iv = 0;
        Iterator<EmergencyContact> it = currentList.iterator();
        while (true) {
            if (it.hasNext()) {
                Object item$iv = it.next();
                EmergencyContact it2 = (EmergencyContact) item$iv;
                if (Intrinsics.areEqual(it2.getId(), id)) {
                    break;
                } else {
                    index$iv++;
                }
            } else {
                index$iv = -1;
                break;
            }
        }
        int index = index$iv;
        if (index != -1) {
            currentList.set(index, EmergencyContact.copy$default(currentList.get(index), null, name, phoneNumber, 1, null));
            saveContacts(currentList);
        }
    }

    private final void saveContacts(List<EmergencyContact> list) {
        this.prefs.edit().putString("contacts", this.gson.toJson(list)).apply();
    }
}
