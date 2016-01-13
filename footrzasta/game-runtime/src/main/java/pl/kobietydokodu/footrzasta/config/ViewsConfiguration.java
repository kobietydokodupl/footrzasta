package pl.kobietydokodu.footrzasta.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import pl.kobietydokodu.footrzasta.model.services.ViewManager;
import pl.kobietydokodu.footrzasta.services.MapViewManager;

/**
 * Konfiguracja Springowa dla ViewManagera
 */
@Configuration
public class ViewsConfiguration {

    /**
     * Tworzenie beana z implementacją {@link ViewManager}.
     * @return Implementacja interfejsu {@link ViewManager}
     */
    @Bean(initMethod = "initializeViewsMap")
    public ViewManager gameViews() {
        return new MapViewManager();
    }

}
