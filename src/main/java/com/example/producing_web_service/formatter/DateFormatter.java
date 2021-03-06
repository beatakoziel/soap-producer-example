package com.example.producing_web_service.formatter;

import com.example.producing_web_service.generated.DateRequest;
import com.example.producing_web_service.generated.GetDateRequest;
import org.springframework.stereotype.Component;

@Component
public class DateFormatter {

    public String getFormattedDate(GetDateRequest getDateRequest) {
        DateRequest request = getDateRequest.getDateRequest();
        return String.format(
                "Day:%s Month:%s Year:%s",
                request.getDay(), request.getMonth(), request.getYear()
        );
    }
}
