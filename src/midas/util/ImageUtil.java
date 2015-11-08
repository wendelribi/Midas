package midas.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImageUtil {
	public static BufferedImage converte(byte[] vetorByte) {
		try {
			return ImageIO.read(new ByteArrayInputStream(vetorByte));
		} catch (IOException e) {
			return null;
		}
	}
}
