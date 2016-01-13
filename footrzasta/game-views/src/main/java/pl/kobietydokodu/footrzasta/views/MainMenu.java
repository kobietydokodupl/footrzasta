package pl.kobietydokodu.footrzasta.views;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pl.kobietydokodu.footrzasta.model.View;
import pl.kobietydokodu.footrzasta.model.enums.KeyboardKey;

/**
 * Główne menu i jednocześnie pierwszy widok aplikacji.
 */
@Primary
@Component
public class MainMenu implements View {

    @Override
    public void renderFrame() {
        // TODO Implementacja rysowania widoku
    }

    @Override
    public void handleKey(KeyboardKey key) {
        // TODO Implementacja obsługi klawiszy
    }

}
