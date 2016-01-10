package pl.kobietydokodu.footrzasta.game;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/**
 * Główna klasa gry - uruchamiająca aplikację
 */
@ComponentScan(basePackages="pl.kobietydokodu.footrzasta")
public class Game {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Game.class);
        ctx.refresh();
        ctx.close();
    }
    
}
