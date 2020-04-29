package util;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class FontImage {

    private final String chars = " ¡'#$%&´()*+,-./0123456789:;<=>?©ABCDEFGHIJKLMNOPQRSTUVWXYZ[@]^_`abcdefghijklmnopqrstuvwxyz{:}~|";

    private BufferedImage bitmapFontImage;
    private BufferedImage originalBuffer;
    private BufferedImage[] letters;

    private int letterWidth;
    private int letterHeight;

    public FontImage(String fontRes, int cols, int rows) {
        loadFont(fontRes, cols, rows);
    }

    private void loadFont(String filename, Integer cols, Integer rows) {
        try {
            int lettersCount = cols * rows;
            bitmapFontImage = bitmapFontImage = ImageIO.read(getClass().getResourceAsStream(filename));
            letters = new BufferedImage[lettersCount];
            letterWidth = bitmapFontImage.getWidth() / cols;
            letterHeight = bitmapFontImage.getHeight() / rows;

            for (int y = 0; y < rows; y++) {
                for (int x = 0; x < cols; x++) {
                    letters[y * cols + x] = new BufferedImage(letterWidth, letterHeight, BufferedImage.TYPE_INT_ARGB);
                    Graphics2D ig = (Graphics2D) letters[y * cols + x].getGraphics();
                    ig.drawImage(bitmapFontImage, 0, 0, letterWidth, letterHeight,
                            x * letterWidth, y * letterHeight,
                            x * letterWidth + letterWidth, y * letterHeight + letterHeight, null);

                }
            }
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    public void drawText(Graphics2D g, String msg, int posx, int posy, Color overrideColor) {
        if (letters == null) {
            return;
        }

        for (int i = 0; i < msg.length(); i++) {
            int charx = chars.indexOf(msg.charAt(i));
            if (charx >= 0) {
                originalBuffer = new BufferedImage(
                        letters[charx].getWidth(),
                        letters[charx].getHeight(),
                        letters[charx].getType());
                originalBuffer.setData(letters[charx].getData());

                for (int x = 0; x < letters[charx].getWidth(); x++) {
                    for (int y = 0; y < letters[charx].getHeight(); y++) {
                        if (letters[charx].getRGB(x, y) == new Color(0, 0, 0).getRGB()) {
                            letters[charx].setRGB(x, y, Color.TRANSLUCENT);
                        }
                        if (letters[charx].getRGB(x, y) == new Color(255, 255, 255).getRGB()) {
                            letters[charx].setRGB(x, y, overrideColor.getRGB());
                        }
                    }
                }
                g.drawImage(letters[charx], posx + i * 16, posy, 16, 16, null);
                letters[charx] = originalBuffer;
            }
        }

    }

    //8*16 column and row
//    private Sprite words[][];
//    private Sprite sprite;
//    private String charsLetras1 = " ! #$%&'()*+,-./";
//    private String charsLetras2 = "0123456789:;<=>?";
//    private String charsLetras3 = "©ABCDEFGHIJKLMNO";
//    private String charsLetras4 = "PQRSTUVWXYZ[/]^_";
//    private String charsLetras5 = "`abcedfghijklmno";
//    private String charsLetras6 = "pqrstuvwxyz{:}~°";
//
//    public FontImage() {
//        sprite = new Sprite("/image/bitmap.png",8,8);
////        try {
////            words = new Sprite[16][6];
////            BufferedImage image = ImageIO.read(FontImage.class.getResource("/image/bitmap.png"));
////            for (int column = 0; column < words.length; column++) {
////                for (int row = 0; row < words[column].length; row++) {
////                    words[column][row] = new Sprite(image, column * 8, row * 8, 8, 8);
////                }
////            }
////        } catch (IOException ex) {
////
////        }
//    }
//    
//    public FontImage(Color source,Color destination) {
////        try {
////            words = new Sprite[16][6];
////            BufferedImage image = ImageIO.read(FontImage.class.getResource("/image/bitmap.png"));
////            OverrideColor(image,source,destination);            
////            for (int column = 0; column < words.length; column++) {
////                for (int row = 0; row < words[column].length; row++) {
////                    words[column][row] = new Sprite(image, column * 8, row * 8, 8, 8);
////                }
////            }
////        } catch (IOException ex) {
////
////        }
//    }
//
//    private void OverrideColor(BufferedImage image, Color source, Color destination) {
//        for (int i = 0; i < image.getWidth(); i++) {
//            for (int j = 0; j < image.getHeight(); j++) {
//                if (image.getRGB(i, j) == source.getRGB()) {
//                    image.setRGB(i, j, destination.getRGB());
//                }
//            }
//        }
//    }
//
//    public void render(Graphics2D graphics2d, String msg, int x, int y, Color color) {
//        sprite.drawText(graphics2d,msg);
////        msg = msg.toUpperCase();
////        for (int i = 0; i < msg.length(); i++) {
////            int iy1 = charsLetras1.indexOf(msg.charAt(i));
////            int iy2 = charsLetras2.indexOf(msg.charAt(i));
////            int iy3 = charsLetras3.indexOf(msg.charAt(i));
////            int iy4 = charsLetras4.indexOf(msg.charAt(i));
////            int iy5 = charsLetras5.indexOf(msg.charAt(i));
////            int iy6 = charsLetras6.indexOf(msg.charAt(i));
////            if (iy1 >= 0) {
////                words[iy1][0].render(graphics2d, x + i * 16, y, 16, 16,color);
////            }
////            if (iy2 >= 0) {
////                words[iy2][1].render(graphics2d, x + i * 16, y, 16, 16,color);
////            }
////            if (iy3 >= 0) {
////                words[iy3][2].render(graphics2d, x + i * 16, y, 16, 16,color);
////            }
////            if (iy4 >= 0) {
////                words[iy4][3].render(graphics2d, x + i * 16, y, 16, 16,color);
////            }
////            if (iy5 >= 0) {
////                words[iy5][4].render(graphics2d, x + i * 16, y, 16, 16,color);
////            }
////            if (iy6 >= 0) {
////                words[iy6][5].render(graphics2d, x + i * 16, y, 16, 16,color);
////            }
////        }
//    }
}
