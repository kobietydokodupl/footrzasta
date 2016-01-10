package pl.kobietydokodu.footrzasta.model.services;

/**
 * Interfejs do zarządzania zasobami pozwalający na ich uprzednie wczytanie oraz pobranie.
 */
public interface ResourcesManager {

    /**
     * Próbuje przyspieszyć późniejsze użycie grafiki.
     * @param imageName Nazwa grafiki, którą będziemy używać.
     */
	public void preloadImage(String imageName);
	
	//TODO: Określić typ zwracany i zmodyfikować sygnaturę metody
	/**
	 * Zwraca grafikę a postaci czytelnej dla LWJGL.
	 * @param imageName Nazwa grafiki do pobrania.
	 * @return Obiekt grafiki w formie gotowej do użycia w LWJGL
	 */
	public Object getImageResource(String imageName);
	
}
