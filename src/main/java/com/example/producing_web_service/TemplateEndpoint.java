package com.example.producing_web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TemplateEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private TemplateRepository templateRepository;

    @Autowired
    public TemplateEndpoint(TemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetTemplateResponse getCountry(@RequestPayload GetTemplateRequest request) {
        GetTemplateResponse response = new GetTemplateResponse();
        response.setDateFormatTemplate(templateRepository.findTemplate(request.getName()));

        return response;
    }

}
