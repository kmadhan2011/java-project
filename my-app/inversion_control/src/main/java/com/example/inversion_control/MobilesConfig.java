package com.example.inversion_control;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MobilesConfig {

    @Bean
    public Color getColor(){
        return new Color();
    }

    @Bean
    public Mobiles getOnePlusObject(Color getColor){

        return new Oneplus(getColor);
    }

    @Bean
    public Mobiles getIphoneObject(){
        return new Iphone();
    }
}
