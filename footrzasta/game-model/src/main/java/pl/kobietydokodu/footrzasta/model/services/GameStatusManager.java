package pl.kobietydokodu.footrzasta.model.services;

import java.util.Map;

import pl.kobietydokodu.footrzasta.model.status.GameStatus;
import pl.kobietydokodu.footrzasta.model.status.HeroStatus;

/**
 * Serwis pozwalający pobierać aktualny status gry oraz bohatera.
 */
public interface GameStatusManager {

    /**
     * Pobiera aktualny status gry.
     * @return Aktualny status gry
     */
    public GameStatus getGameStatus();
    
    /**
     * Zwraca wszystkie dostępne, zapisane statusy gry.
     * @return Mapa, w której kluczem jest id statusu, a wartością sam status gry.
     */
    public Map<String, GameStatus> listGameStatuses();
    
    /**
     * Wczytuje wskazany status gry jako bieżący.
     * @param id Lokalizacja statusu
     */
    public void loadGameStatus(String id);
    
    /**
     * Zapisuje aktualny status gry
     */
    public void saveGameStatus();
    
    /**
     * Resetuje bieżący status gry.
     * Metoda ta usuwa informacje zawarte w statusie gry!
     */
    public void resetGameStatus();

    /**
     * Pobiera aktualny status bohatera.
     * @return Aktualny status bohatera
     */
    public HeroStatus getCurrentHeroStatus();
    
    /**
     * Resetuje status bohatera.
     * Obiekt zwracany przez {@link #getCurrentHeroStatus()} może być inną instancją obiektu.
     */
    public void resetHeroStatus();
    
}
