package pl.kobietydokodu.footrzasta.views.menu;

/**
 * Pojedynczy element w menu.
 */
public class MenuElement {
    /**
     * Etykieta wyświetlana na ekranie.
     */
    private String label;
    
    /**
     * Akcja wykonywana po wybraniu określonego elementu.
     */
    private MenuAction action;

    public MenuElement(String label, MenuAction action) {
        this.label = label;
        this.action = action;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MenuAction getAction() {
        return action;
    }

    public void setAction(MenuAction action) {
        this.action = action;
    }

}
