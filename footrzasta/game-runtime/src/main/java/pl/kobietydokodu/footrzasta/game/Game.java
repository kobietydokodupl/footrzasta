package pl.kobietydokodu.footrzasta.game;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import pl.kobietydokodu.footrzasta.model.services.GameManager;
import pl.kobietydokodu.footrzasta.model.services.ViewManager;

/**
 * Główna klasa gry - uruchamiająca aplikację
 */
@Service
@ComponentScan(basePackages = "pl.kobietydokodu.footrzasta")
public class Game implements GameManager {

    private Logger log = LoggerFactory.getLogger(getClass());

    /**
     * Pole do sygnalizowania zamknięcia aplikacji.
     */
    private boolean doClose = false;

    @Autowired
    private ViewManager viewManager;

    /**
     * Metoda main do uruchamiania gry.
     * @param args Argumenty konsoli, ignorowane
     */
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Game.class);
        ctx.refresh();
        Game gameBean = ctx.getBean(Game.class);
        gameBean.renderFrames();
        ctx.close();
    }

    /**
     * Metoda główna uruchamiająca renderowanie
     */
    private void renderFrames() {
        try {
            Display.setDisplayMode(new DisplayMode(800, 600));
            Display.create();
        } catch (LWJGLException e) {
            log.error("Nie można stworzyć obiektu Display biblioteki OpenGL", e);
            System.exit(0);
        }

        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, 640, 480, 0, 1, -1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);

        while (!doClose && !Display.isCloseRequested()) {
            GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
            viewManager.loop();
            Display.update();
        }
        Display.destroy();
    }

    public void closeGame() {
        doClose = true;
    }
}
