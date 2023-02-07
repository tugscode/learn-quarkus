package org.acme.service;

import org.eclipse.microprofile.config.ConfigProvider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import java.util.Optional;
import java.util.UUID;
@ApplicationScoped
public class GreetingService {

//    @ConfigProperty(name = "greeting.name")
//    String name;

    @ConfigProperty(name = "greeting.suffix", defaultValue = "!")
    String suffix;

    @ConfigProperty(name = "greeting.prefix")
    Optional<String> prefix;

    public String sayHello(){
        final String name = ConfigProvider.getConfig().getValue("greeting.name",String.class);
        return prefix.orElse("_") + name + suffix;
    }
    public String sayHello(String name){
        return String.format("hello %s, your id is %s", name, UUID.randomUUID().toString());
    }
}
