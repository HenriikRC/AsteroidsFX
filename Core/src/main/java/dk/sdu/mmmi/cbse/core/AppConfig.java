package dk.sdu.mmmi.cbse.core;

import dk.sdu.mmmi.cbse.common.services.IEntityProcessingService;
import dk.sdu.mmmi.cbse.common.services.IGamePluginService;
import dk.sdu.mmmi.cbse.common.services.IPostEntityProcessingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;

@Configuration
public class AppConfig {

    public AppConfig(){}
    @Bean
    public Game game(){
        return new Game(gamePluginServices(), entityProcessingServiceList(), postEntityProcessingServices());
    }

    @Bean
    public List<IEntityProcessingService> entityProcessingServiceList() {
        List<IEntityProcessingService> services = ServiceLoader.load(IEntityProcessingService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
        System.out.println("Loaded Entity Processing Services: " + services.size());
        services.forEach(service -> System.out.println("Entity Processing Service: " + service.getClass().getName()));
        return services;
    }

    @Bean
    public List<IGamePluginService> gamePluginServices() {
        List<IGamePluginService> services = ServiceLoader.load(IGamePluginService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
        System.out.println("Loaded Game Plugin Services: " + services.size());
        services.forEach(service -> System.out.println("Game Plugin Service: " + service.getClass().getName()));
        return services;
    }

    @Bean
    public List<IPostEntityProcessingService> postEntityProcessingServices() {
        List<IPostEntityProcessingService> services = ServiceLoader.load(IPostEntityProcessingService.class)
                .stream()
                .map(ServiceLoader.Provider::get)
                .collect(toList());
        System.out.println("Loaded Post Entity Processing Services: " + services.size());
        services.forEach(service -> System.out.println("Post Entity Processing Service: " + service.getClass().getName()));
        return services;
    }
}
