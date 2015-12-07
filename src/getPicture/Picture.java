package getPicture;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Picture {
	
	public static final String LEARN = "imgLearn/";
	public static final String WHATIS = "imgWhatIs/";
	
	public void createPicture(String pictures) throws FileNotFoundException, IOException 
	{
	
		
		File file = new File( pictures +"chess.jpg");
		FileInputStream fis = new FileInputStream(file);
		
		BufferedImage image = ImageIO.read(fis);
		
		int rows = 8;
		int cols = 8;
		
		int chunks = rows * cols;
		
		int chunkWidth = image.getWidth()/cols;
		int chunkHeight = image.getHeight()/rows;
		
		int count = 0;
		BufferedImage imgs[] = new BufferedImage[chunks];
		for(int i = 0; i<rows; i++)
		{
			for(int j = 0; j<cols; j++)
			{
				imgs[count] = new BufferedImage(chunkWidth, chunkHeight, image.getType());
				
				Graphics2D gr = imgs[count++].createGraphics();
				gr.drawImage(image, 0, 0, chunkWidth, chunkHeight, 
							 chunkWidth * j, chunkHeight * i, chunkWidth * j + chunkWidth,
							 chunkHeight * i + chunkHeight, null);
				gr.dispose();
			}			
		}
		
		System.out.println("Rezanje slike je završeno");
		
		for (int x = 0; x < cols; x++)
		{
			for(int y = 0; y < rows; y++)
			{
				String field = pictures;
				int index = 8 - x;
				int letterInt = 65 + y;
				char letter = (char) letterInt;
				field += letter + String.valueOf(index);
				ImageIO.write(imgs[x * cols + y], "png", new File(field + ".jpg"));
			}
		}
		
		System.out.println("Kreiranje slika je završeno");
	}
	
	
	
	
	
	

}
