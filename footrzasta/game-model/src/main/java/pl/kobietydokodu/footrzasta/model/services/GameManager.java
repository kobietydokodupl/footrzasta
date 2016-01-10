package pl.kobietydokodu.footrzasta.model.services;

/**
 * Interfejs serwisu zarządzającego grą jako całością.
 */
public interface GameManager {

    /**
     * 'Miękkie' zamknięcie gry - pozwala aplikacji na zwolnienie zasobów i zakończenie wszystkich akcji.
     */
    void closeGame();

}
