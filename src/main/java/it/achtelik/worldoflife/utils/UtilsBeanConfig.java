package it.achtelik.worldoflife.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
public class UtilsBeanConfig {

    @Bean
    public JsonUtils getJsonUtils() {
        return new JsonUtils();
    }

    @Bean
    public HexColorUtils getHexColorUtils() {
        return new HexColorUtils(new Random());
    }

}
