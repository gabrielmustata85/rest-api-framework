package org.example.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import lombok.Getter;
import lombok.SneakyThrows;

import java.io.File;

@Getter
public class ConfigProperties {

    private String baseUrl;

    @SneakyThrows
    public ConfigProperties readConfigProperties(){
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        File file = new File(classLoader.getResource("config.yml").getFile());

        ObjectMapper om = new ObjectMapper(new YAMLFactory());

        ConfigProperties config = om.readValue(file, ConfigProperties.class);
        return config;
    }
}