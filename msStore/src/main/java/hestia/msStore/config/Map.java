package hestia.msStore.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Map {
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

}
