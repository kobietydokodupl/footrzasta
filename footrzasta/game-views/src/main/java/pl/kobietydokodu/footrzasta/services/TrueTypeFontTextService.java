package pl.kobietydokodu.footrzasta.services;

import java.awt.Color;
import java.awt.Font;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import org.newdawn.slick.TrueTypeFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pl.kobietydokodu.footrzasta.model.enums.TextAlignment;
import pl.kobietydokodu.footrzasta.model.services.TextService;

@Service
public class TrueTypeFontTextService implements TextService {

    private Logger log = LoggerFactory.getLogger(getClass());
    private Map<String, TrueTypeFont> fontsCache = new HashMap<>();

    private TrueTypeFont getFont(String fontName) {
        if (!fontsCache.containsKey(fontName)) {
            try {
                InputStream inputStream = getClass().getClassLoader().getResourceAsStream("fonts/" + fontName + ".ttf");
                Font awtFont = Font.createFont(Font.TRUETYPE_FONT, inputStream);
                awtFont = awtFont.deriveFont(24f); // domyślny, stały rozmiar czcionki
                fontsCache.put(fontName, new TrueTypeFont(awtFont, true));
            } catch (Exception e) {
                log.error("Nie można wczytać fontu", e);
            }
        }
        return fontsCache.get(fontName);
    }

    @Override
    public void renderText(String content, Float positionX, Float positionY, TextAlignment alignment, String fontName,
            Color color) {
        TrueTypeFont font = getFont(fontName);
        Integer textWidth = font.getWidth(content);
        Float actualPositionX = positionX;
        switch (alignment) {
            case CENTER:
                actualPositionX -= textWidth/2;
                break;
            case RIGHT: 
                actualPositionX -= textWidth;
                break;
        }
        org.newdawn.slick.Color slickColor = new org.newdawn.slick.Color(color.getRed(), 
                color.getGreen(), color.getBlue(), color.getAlpha());
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        font.drawString(actualPositionX, positionY, content, slickColor);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
    }

}
