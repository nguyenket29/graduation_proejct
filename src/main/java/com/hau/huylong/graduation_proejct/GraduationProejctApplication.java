package com.hau.huylong.graduation_proejct;

import com.hau.huylong.graduation_proejct.config.propertise.ApplicationPropertise;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationPropertise.class})
public class GraduationProejctApplication {

    public static void main(String[] args) {
        SpringApplication.run(GraduationProejctApplication.class, args);
    }

}
