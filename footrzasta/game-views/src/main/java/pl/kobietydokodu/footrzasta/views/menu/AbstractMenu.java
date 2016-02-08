package pl.kobietydokodu.footrzasta.views.menu;

import java.awt.Color;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import pl.kobietydokodu.footrzasta.model.View;
import pl.kobietydokodu.footrzasta.model.enums.KeyboardKey;
import pl.kobietydokodu.footrzasta.model.enums.TextAlignment;
import pl.kobietydokodu.footrzasta.model.services.TextService;

/**
 * Abstrakcyjna klasa do generowania menu - konkretne menu muszą podać jednynie 
 * opcje oraz powiązane z nimi akcje.
 */
public abstract class AbstractMenu implements View {

    protected Logger log = LoggerFactory.getLogger(getClass());
    
    /**
     * Indeks aktualnie wybranego elementu menu.
     */
    private int currentElementIndex = 0;
    
    @Autowired
    private TextService textService;
    
    @Override
    public void renderFrame() {
        float initialPositionY = 50f;
        float incrementY = 50f;
        float positionX = 320f;
        List<MenuElement> elements = getElements();
        for (int renderingElement = 0; renderingElement<elements.size(); renderingElement++) {
            MenuElement element = elements.get(renderingElement);
            Color color = (renderingElement==currentElementIndex) ? Color.BLUE : Color.GREEN;
            textService.renderText(element.getLabel(), positionX, initialPositionY+renderingElement*incrementY, 
                    TextAlignment.CENTER, "Lato-Regular", color);
        }
    }

    @Override
    @SuppressWarnings("incomplete-switch")
    public void handleKey(KeyboardKey key) {
        switch (key){
            case KEY_ENTER:
                getElements().get(currentElementIndex).getAction().doAction();
                break;
            case KEY_ESCAPE:
                closeMenu();
                break;
            case KEY_UP:
                currentElementIndex = Math.floorMod(currentElementIndex-1, getElements().size());
                break;
            case KEY_DOWN:
                currentElementIndex = Math.floorMod(currentElementIndex+1, getElements().size());
                break;
        }
    }
    
    /**
     * Akcja wykonywana po naciśnięciu klawisza ESC.
     */
    protected abstract void closeMenu();

    /**
     * Metoda, której zadaniem jest wygenerowanie listy elementów.
     * @return Lista elementów menu wraz z odpowiadającymi im akcjami.
     */
    protected abstract List<MenuElement> getElements();
}
