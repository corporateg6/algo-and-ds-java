/*
 * Brently George
 */

import java.util.Scanner;
import java.io.File;


public class FileUtils {

	public Scanner openFileReader(String fileName) {
		Scanner file = null;
		try {
			file = new Scanner(new File(fileName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return file;
	}
	
	public void closeFile(Scanner file) {
		file.close();
	}
}
