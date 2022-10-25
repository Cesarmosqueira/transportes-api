package pe.com.huex.dto.Response;

import pe.com.huex.entities.Provider;

public class ProviderUpdateDto {
    private Provider provider = null;

    public ProviderUpdateDto() {
    }

    public ProviderUpdateDto provider(Provider provider) {
        this.provider = provider;
        return this;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

}
