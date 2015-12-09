package midas.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageInputStream;

import midas.entidades.Mammogram;

public class ImageUtil {
	
	public static byte[] imageInByte;
	
	//public ImageUtil (){}
	
	public static BufferedImage converte(Mammogram mammogram) {
		
		try {
			
			imageInByte = mammogram.getImagem(); 
			ImageInputStream in = ImageIO.createImageInputStream(new ByteArrayInputStream(imageInByte));
			BufferedImage image = ImageIO.read(in);
			return image;
			
		} catch (IOException e) {
			return null;
		}
	}
}
