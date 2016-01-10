package pl.kobietydokodu.footrzasta.model;

import pl.kobietydokodu.footrzasta.model.enums.KeyboardKey;

/**
 * Pojedynczy widok w grze, który obsługuje klawisze oraz renderuje sceny.
 * Widokami są zarówno poszczególne plansze, jak i menu. 
 */
public interface View {

    /**
     * Ta metoda wywoływana jest w pętli, jej zadaniem jest wygenerowanie aktualnej grafiki dla sceny.
     * @see pl.kobietydokodu.footrzasta.model.services.ViewManager#loop()
     */
    public void renderFrame();

    /**
     * Pozwala obsługiwać klawisze przez widok. 
     * Dla każdego naciśięcia klawisza (w momencie jego puszczenia) metoda ta jest wywoływana 
     * z odpowiednim argumentem reprezentującym klawisz.
     * Metoda ta jest wywoływana przed metodą renderFrame, może skutkować zmianą widoku.
     * 
     * Uwaga: W momencie wywołania tej metody, mógł upłynąć dodatkowy czas od zdarzenia.
     * @param key Użyty klawisz na klawiaturze
     * @see pl.kobietydokodu.footrzasta.model.services.ViewManager#loop()
     */
    public void handleKey(KeyboardKey key);

}
