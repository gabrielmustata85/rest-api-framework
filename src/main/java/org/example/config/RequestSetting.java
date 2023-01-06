package org.example.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class RequestSetting {


    private final ContentType contentType;
    private String endPoint;
    private String endPointSuffix;
    private final Map<String, Object> params;
}
