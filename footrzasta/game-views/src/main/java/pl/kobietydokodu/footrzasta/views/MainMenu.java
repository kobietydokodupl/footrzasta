package pl.kobietydokodu.footrzasta.views;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pl.kobietydokodu.footrzasta.model.services.GameManager;
import pl.kobietydokodu.footrzasta.model.services.ViewManager;
import pl.kobietydokodu.footrzasta.views.menu.AbstractMenu;
import pl.kobietydokodu.footrzasta.views.menu.MenuAction;
import pl.kobietydokodu.footrzasta.views.menu.MenuElement;

/**
 * Główne menu i jednocześnie pierwszy widok aplikacji.
 */
@Primary
@Component
public class MainMenu extends AbstractMenu {

    @Autowired
    private GameManager game;
    
    @Autowired
    private ViewManager viewManager;
    
    private List<MenuElement> elements;

    @PostConstruct
    public void init() {
        MenuAction action = () -> viewManager.displayView("gameLevel");
        MenuElement element = new MenuElement("Plansza", action);
        // Dodajemy dwukrotnie ten sam element, żeby zobaczyć menu w akcji
        elements = Collections.unmodifiableList(Arrays.asList(element, element)); 
    }
    
    @Override
    protected void closeMenu() {
        game.closeGame();
    }

    @Override
    protected List<MenuElement> getElements() {
        return elements;
    }

}
