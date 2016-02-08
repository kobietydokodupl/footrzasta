package pl.kobietydokodu.footrzasta.model.services;

import java.awt.Color;

import pl.kobietydokodu.footrzasta.model.enums.TextAlignment;

/**
 * Serwis do wyświetlania tekstów na ekranie.
 */
public interface TextService {

    /**
     * Wyświetla tekst na aktualnie renderowanej klatce.
     * 
     * @param content Treść do wyświetlenia
     * @param positionX Pozycja w osi X
     * @param positionY Pozycja w osi Y
     * @param alignment Wyrównanie wypisywanego tekstu
     * @param fontName Nazwa użytej czcionki
     * @param color Kolor, który ma zostać użyty do wyświetlenia tekstu
     */
    public void renderText(String content, Float positionX, Float positionY, 
            TextAlignment alignment, String fontName, Color color);

}
