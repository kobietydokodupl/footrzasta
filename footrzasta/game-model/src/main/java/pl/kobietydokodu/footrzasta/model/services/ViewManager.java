package pl.kobietydokodu.footrzasta.model.services;

/**
 * Serwis do zarządzania widokami.
 * Pozwala na zmianę aktualnego widoku oraz udostępnia metodę pomocniczą do obsługi renderowania.
 */
public interface ViewManager {

    /**
     * Metoda pomocnicza do renderowania - wywołuje obsługę klawiszy w widoku oraz jego metodę renderowania.
     * 
     * @see pl.kobietydokodu.footrzasta.model.View#renderFrame()
     * @see pl.kobietydokodu.footrzasta.model.View#handleKey(pl.kobietydokodu.footrzasta.model.enums.KeyboardKey)
     */
	void loop();

	/**
	 * Zmienia bieżący widok na wskazany. Zmiana dokonywana jest w ramach wywołania metody.
	 * 
	 * @param viewName Nazwa widoku do wyświetlenia
	 */
	void displayView(String viewName);

}
