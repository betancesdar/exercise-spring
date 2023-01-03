package net.devdariobetances.demoApi.config;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
@Component

public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
        this.packages("net.devdariobetances.demoApi.controllers");

    }
}
