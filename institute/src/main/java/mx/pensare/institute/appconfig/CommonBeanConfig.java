package mx.pensare.institute.appconfig;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.modelmapper.ModelMapper;

/**
 * @author Jorge Álvarez
 * @version 1.0 - 2018/04/03
 */
@Configuration
public class CommonBeanConfig {
    /**
     * Create a bean for {@link ModelMapper}
     *
     * @return an instance of {@link ModelMapper}
     */
    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    /**
     * Create a bean for {@link StrongPasswordEncryptor}
     *
     * @return an instance of {@link StrongPasswordEncryptor}
     */
//    @Bean
//    public StrongPasswordEncryptor strongPasswordEncryptor() {
//        return new StrongPasswordEncryptor();
//    }

    /**
     * Provides functionality for converting between Java objects and matching JSON
     *
     * @return an instance of {@link ObjectMapper}
     */
    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }
}
