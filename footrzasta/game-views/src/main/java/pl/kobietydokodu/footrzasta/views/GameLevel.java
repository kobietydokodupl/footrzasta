package pl.kobietydokodu.footrzasta.views;

import org.lwjgl.opengl.GL11;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.kobietydokodu.footrzasta.model.View;
import pl.kobietydokodu.footrzasta.model.enums.KeyboardKey;
import pl.kobietydokodu.footrzasta.model.services.ViewManager;

/**
 * Widok poziomu gry.
 */
@Component
public class GameLevel implements View {

private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private ViewManager viewManager;

    @Override
    public void renderFrame() {
        GL11.glColor3f(1.0f, 0.5f, 0.5f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(200, 200);
        GL11.glVertex2f(200 + 200, 200);
        GL11.glVertex2f(200 + 200, 200 + 200);
        GL11.glVertex2f(200, 200 + 200);
        GL11.glEnd();
    }

    @Override
    @SuppressWarnings("incomplete-switch")
    public void handleKey(KeyboardKey key) {
        log.debug("Pressed key {}", key);
        switch (key) {
            case KEY_ESCAPE:
                viewManager.displayView("mainMenu");
                break;
        }
    }

}
