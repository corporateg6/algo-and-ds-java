/*
 * Brently George
 */
import java.util.Scanner;
import java.io.*;

public class FileIOSolutions {
	//constants to help read tube file
	public static final int TUBE_FILE_WIDTH = 3;
	public static final String DELIM = "\t";
	
	public static double totalTubeVolume(String tubeFile) {
		double totalVolume = 0.0;
		//put file operations in try/catch
		try {
			//create file reader
			Scanner fileReader = new Scanner(new File(tubeFile));
			String readLine;
			String[] splitLine;
			
			while (fileReader.hasNext()) {
				readLine = fileReader.nextLine();
				splitLine = readLine.split(DELIM);
				if (splitLine.length != TUBE_FILE_WIDTH)
					continue;
				//calculate volume of current tube and add to subtotal.
				//convert string to value before passing to the method
				totalVolume += calcTubeVolume(Double.valueOf(splitLine[1]),Double.valueOf(splitLine[2]));
			}
			fileReader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return totalVolume;
	}
	
	//math for tube volume
	public static double calcTubeVolume(double radius, double height) {
		return Math.pow(radius,2) * height * Math.PI;
	}

	public static void pastTense(String fileIn, String fileOut) {
		//put file operations in try/catch
		try {
			//create file reader and file writer
			Scanner fileReader = new Scanner(new File(fileIn));
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileOut));
			//iterate through file as long as there is something left to read in.
			while(fileReader.hasNext()) {
				//grab the current string
				String nextString = fileReader.next();
				//display in the console.
				System.out.println(nextString);
				//if "is" change to "was" if "Is" change to "Was"
				switch(String.valueOf(nextString)) {
				case "is":
					nextString = "was";
					break;
				case "Is":
					nextString = "Was";
					break;
				case "iS":
					nextString = "was";
					break;
				case "IS":
					nextString = "Was";
					break;
				}
				//write the string to output file
				fileWriter.println(nextString);
			}
			//close the files
			fileReader.close();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
