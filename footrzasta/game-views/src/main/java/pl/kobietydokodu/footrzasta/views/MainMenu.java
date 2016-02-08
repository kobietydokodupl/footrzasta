package pl.kobietydokodu.footrzasta.views;

import java.awt.Color;

import org.lwjgl.opengl.GL11;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import pl.kobietydokodu.footrzasta.model.View;
import pl.kobietydokodu.footrzasta.model.enums.KeyboardKey;
import pl.kobietydokodu.footrzasta.model.enums.TextAlignment;
import pl.kobietydokodu.footrzasta.model.services.GameManager;
import pl.kobietydokodu.footrzasta.model.services.TextService;
import pl.kobietydokodu.footrzasta.model.services.ViewManager;

/**
 * Główne menu i jednocześnie pierwszy widok aplikacji.
 */
@Primary
@Component
public class MainMenu implements View {

    private Logger log = LoggerFactory.getLogger(getClass());
    
    @Autowired
    private GameManager game;
    
    @Autowired
    private ViewManager viewManager;
    
    @Autowired
    private TextService textService;

    @Override
    public void renderFrame() {
        GL11.glColor3f(0.5f, 0.5f, 1.0f);
        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(100, 100);
        GL11.glVertex2f(100 + 200, 100);
        GL11.glVertex2f(100 + 200, 100 + 200);
        GL11.glVertex2f(100, 100 + 200);
        GL11.glEnd();
        textService.renderText("Menu", 50.0f, 50.0f, TextAlignment.LEFT, "Lato-Regular", Color.RED);
    }

    @Override
    @SuppressWarnings("incomplete-switch")
    public void handleKey(KeyboardKey key) {
        log.debug("Pressed key {}", key);
        switch (key) {
            case KEY_ESCAPE:
                game.closeGame();
                break;
            case KEY_ENTER:
                viewManager.displayView("gameLevel");
                break;
        }
    }

}
