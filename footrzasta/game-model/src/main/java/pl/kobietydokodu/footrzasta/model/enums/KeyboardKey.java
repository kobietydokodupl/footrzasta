package pl.kobietydokodu.footrzasta.model.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * Enum do reprezentowania klawiszy wciśniętych na klawiaturze. 
 * Wartości liczbowe pochodzą z <a href="http://legacy.lwjgl.org/javadoc/org/lwjgl/input/Keyboard.html"biblioteki LWJGL</a>.
 */
public enum KeyboardKey {

    KEY_UNKNOWN(-1),
    KEY_ESCAPE(1), 
    KEY_ENTER(28);
    
    /**
     * Pole do przechowywania wartości liczbowej danego klawisza.
     */
    private int keyCode;
    
    /**
     * Konstruktor prywatny niezbędny do zainicjowania wartości pola keyCode.
     * @param keyCode Wartość liczbowa klawisza zgodna z wartościami używanymi w LWJGL.
     */
    private KeyboardKey(int keyCode) {
        this.keyCode = keyCode;
    }
    
    /**
     * Znajduje odpowiednią wartość Enuma na podstawie kodu liczbowego.
     * @param keyCode Kod liczbowy klawisza wg wartości z LWJGL
     * @return Enum odpowiadający argumentowi lub KEY_UNKNOWN, jeśli dopasowanie się nie powiodło.
     */
    public static KeyboardKey findByCode(final int keyCode) {
        Optional<KeyboardKey> optionalKey = Arrays.asList(values()).stream().filter(key -> key.keyCode==keyCode).findFirst();
        return optionalKey.orElse(KEY_UNKNOWN);
    }
}
