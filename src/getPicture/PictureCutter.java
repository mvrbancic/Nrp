package getPicture;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class PictureCutter {
	
	public void cutCutCut() throws FileNotFoundException, IOException{
		String [] pictures = new String[2];
		Picture picture = new Picture();
		
		pictures[0] = "imgLearn/";
		pictures[1] = "imgWhatIs/";
		
	
		System.out.println(pictures.length);
		
		
		for(int i = 0; i< pictures.length; i++)
		{
			File folder = new File(pictures[i]);
			File[] listOfFiles = folder.listFiles();
		
			if(listOfFiles.length < 2){
				
					picture.createPicture(pictures[i]);
				
			}
		}	
	}

}
