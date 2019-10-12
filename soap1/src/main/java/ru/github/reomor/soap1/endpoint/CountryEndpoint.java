package ru.github.reomor.soap1.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import ru.github.reomor.soap1.config.WebServiceConfig;
import ru.github.reomor.soap1.model.GetCountryRequest;
import ru.github.reomor.soap1.model.GetCountryResponse;
import ru.github.reomor.soap1.repository.CountryRepository;

@Endpoint
public class CountryEndpoint {
    private static final String NAMESPACE_URI = WebServiceConfig.NAMESPACE_URI;

    private CountryRepository countryRepository;

    @Autowired
    public CountryEndpoint(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetCountryResponse getCountry(@RequestPayload GetCountryRequest request) {
        GetCountryResponse response = new GetCountryResponse();
        response.setCountry(countryRepository.findCountry(request.getName()));

        return response;
    }
}
