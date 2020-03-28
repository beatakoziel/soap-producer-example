package com.example.producing_web_service.endpoint;

import com.example.producing_web_service.formatter.DateFormatter;
import com.example.producing_web_service.generated.GetDateRequest;
import com.example.producing_web_service.generated.GetDateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class TemplateEndpoint {
    private static final String NAMESPACE_URI = "http://example.com/producing-web-service";

    private DateFormatter dateFormatter;

    @Autowired
    public TemplateEndpoint(DateFormatter dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getDateRequest")
    @ResponsePayload
    public GetDateResponse getFormattedDate(@RequestPayload GetDateRequest request) {
        GetDateResponse response = new GetDateResponse();
        response.setFormattedDate(dateFormatter.getFormattedDate(request));
        return response;
    }

}
