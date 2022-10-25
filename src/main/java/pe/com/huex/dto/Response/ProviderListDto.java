package pe.com.huex.dto.Response;

import pe.com.huex.entities.Provider;

import java.util.List;
import java.util.Optional;

public class ProviderListDto {

    public ProviderListDto() {
    }

    private List<Provider> providerList = null;

    public ProviderListDto providerList(List<Provider> providerList) {
        this.providerList = providerList;
        return this;
    }

    public void setProviderList(List<Provider> providerList) {
        this.providerList = providerList;
    }

    public List<Provider> getProviderList() {
        return providerList;
    }


}
