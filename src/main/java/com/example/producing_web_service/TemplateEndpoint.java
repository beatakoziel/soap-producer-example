package com.example.producing_web_service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TemplateEndpoint {
    private static final String NAMESPACE_URI = "http://spring.io/guides/gs-producing-web-service";

    private DateFromatter dateFromatter;

    @Autowired
    public TemplateEndpoint(DateFromatter dateFromatter) {
        this.dateFromatter = dateFromatter;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getCountryRequest")
    @ResponsePayload
    public GetDateResponse getFormattedDate(@RequestPayload GetDateRequest request) {
        GetDateResponse response = new GetDateResponse();
        response.setFormattedDate(dateFromatter.getFormattedDate(request));
        return response;
    }

}
