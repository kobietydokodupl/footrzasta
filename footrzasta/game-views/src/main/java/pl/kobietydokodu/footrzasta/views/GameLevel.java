package pl.kobietydokodu.footrzasta.views;

import org.springframework.stereotype.Component;

import pl.kobietydokodu.footrzasta.model.View;
import pl.kobietydokodu.footrzasta.model.enums.KeyboardKey;

/**
 * Widok poziomu gry.
 */
@Component
public class GameLevel implements View {

    @Override
    public void renderFrame() {
        // TODO Implementacja rysowania widoku
    }

    @Override
    public void handleKey(KeyboardKey key) {
        // TODO Implementacja obsługi klawiszy
    }

}
