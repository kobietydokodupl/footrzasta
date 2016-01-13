package pl.kobietydokodu.footrzasta.services;

import java.util.Collections;
import java.util.Map;

import org.lwjgl.input.Keyboard;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import pl.kobietydokodu.footrzasta.model.View;
import pl.kobietydokodu.footrzasta.model.enums.KeyboardKey;
import pl.kobietydokodu.footrzasta.model.services.ViewManager;

/**
 * Manager widoków oparty o mapę, budowaną na podstawie informacji z kontekstu aplikacji.
 */
public class MapViewManager implements ViewManager {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Mapa, w której kluczem jest identyfikator widoku, a wartością sam widok.
     */
    private Map<String, View> views;

    @Autowired
    private ApplicationContext context;

    @Autowired
    private View currentView;

    /**
     * Metoda inicjująca mapę widoków na podstawie wszystkich beanów implementujących {@link View}.
     */
    public void initializeViewsMap() {
        views = Collections.unmodifiableMap(context.getBeansOfType(View.class));
        views.entrySet().forEach(
                entry -> log.info("Found view {} under id {}", entry.getValue().getClass().getName(), entry.getKey()));
    }

    public void displayView(String viewName) {
        if (views.containsKey(viewName)) {
            currentView = views.get(viewName);
        } else {
            log.error("Cannot find view {}, ignoring", viewName);
        }
    }

    public void loop() {
        while (Keyboard.next()) {
            if (!Keyboard.getEventKeyState()) { //reagujemy tylko na zwolnienie klawisza
                currentView.handleKey(KeyboardKey.findByCode(Keyboard.getEventKey()));
            }
        }
        currentView.renderFrame();
    }

}
