package androidx.health.platform.client.impl.ipc;

/* loaded from: classes14.dex */
public class ClientConfiguration {
    private final String mApiClientName;
    private final String mBindAction;
    private final String mServicePackageName;

    public ClientConfiguration(String apiClientName, String servicePackageName, String bindAction) {
        this.mServicePackageName = servicePackageName;
        this.mBindAction = bindAction;
        this.mApiClientName = apiClientName;
    }

    public String getServicePackageName() {
        return this.mServicePackageName;
    }

    public String getBindAction() {
        return this.mBindAction;
    }

    public String getApiClientName() {
        return this.mApiClientName;
    }
}
