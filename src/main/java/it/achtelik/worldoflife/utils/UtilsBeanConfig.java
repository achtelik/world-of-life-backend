package it.achtelik.worldoflife.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UtilsBeanConfig {

    @Bean
    public JsonUtils getJsonUtils() {
        return new JsonUtils();
    }

}
