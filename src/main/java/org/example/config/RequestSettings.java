package org.example.config;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@AllArgsConstructor
@Getter
@Setter
public class RequestSettings {

    private Map<String, RequestSetting> settings;
}
