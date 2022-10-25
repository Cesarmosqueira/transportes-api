package pe.com.huex.dto.Response;

import pe.com.huex.entities.Provider;

import java.util.List;

public class ProviderRetrieveDto {

    public ProviderRetrieveDto() {
    }

    private Provider provider = null;

    public ProviderRetrieveDto provider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Provider getProvider() {
        return provider;
    }


}
