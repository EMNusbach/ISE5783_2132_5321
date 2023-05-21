package renderer;

import org.junit.jupiter.api.Test;
import primitives.Color;

import static org.junit.jupiter.api.Assertions.*;

/**
 * This class contains a test case for the writeToImage() method of the ImageWriter class.
 */
class ImageWriterTest {
    /**
     * Tests the writeToImage() method of the ImageWriter class.
     * The test generates an image with alternating red and yellow pixels.
     */
    @Test
    void writeToImage() {
        ImageWriter imageWriter = new ImageWriter("testYellow",800,500);
        for (int i = 0; i < imageWriter.getNx(); i++) {
            for (int j = 0; j < imageWriter.getNy(); j++) {
                // 800/16 = 50
                if (i % 50 == 0) {
                    imageWriter.writePixel(i, j, Color.RED);
                }
                // 500/10 = 50
                else if (j % 50 == 0) {
                    imageWriter.writePixel(i, j, Color.RED);
                } else {
                    imageWriter.writePixel(i, j, Color.YELLOW);
                }
            }
        }
        imageWriter.writeToImage();
    }
}
