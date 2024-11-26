/*
 * Brently George
 */

import java.io.*;
import java.util.Scanner;

public class VideoGameManager {
	
	public static final String DELIM = "\t";
	public static final int VG_FILE_WIDTH = 2;
	
	//create VideoGame linked list with GenLL class
	private VideoGameLL vgDatabase;
	private VideoGameLL vgSearchResults;
	
	public VideoGameManager() {
		this.vgDatabase = new VideoGameLL();
		this.vgSearchResults = new VideoGameLL();
	}
	
	public void writeSearchResultsFile(String fileName) {
		//write search results to a file with the name of the file as input
		//this method overwrites any existing file with the same name.
		//if there are no search results, just return without doing anything
		if (!this.hasSearchResults())
			return;
		try {
			System.out.println("Writing to "+fileName);
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName));
			//set pointer to head
			this.vgSearchResults.reset();
			while(vgSearchResults.hasNext()) {
				fileWriter.println(vgSearchResults.getCurrent().toString());
				this.vgSearchResults.gotoNext();
			}
			//one more time to cover the last item
			fileWriter.println(vgSearchResults.getCurrent().toString());
			//reset the list pointer again
			this.vgSearchResults.reset();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void appendSearchResultsFile(String fileName) {
		//same as writeSearchResultsFile(), except with the append flag
		//if there are no search results, just return without doing anything
		if (!this.hasSearchResults())
			return;
		try {
			System.out.println("Appending to "+fileName); 
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(fileName,true));
			//set pointer to head
			this.vgSearchResults.reset();
			while(vgSearchResults.hasNext()) {
				fileWriter.println(vgSearchResults.getCurrent().toString());
				this.vgSearchResults.gotoNext();
			}
			//one more time to cover the last item
			fileWriter.println(vgSearchResults.getCurrent().toString());
			//reset the list pointer again
			this.vgSearchResults.reset();
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//return true if vgDatabase is not empty, else returns false
	public boolean hasLoadedVGFile() {
		return !this.vgDatabase.isEmpty();
	}

	//return true if vgSearchResults is not empty, else returns false.
	public boolean hasSearchResults() {
		return !this.vgSearchResults.isEmpty();
	}
	
	//prints loaded database file
	public void printLoadedFile() {
		this.vgDatabase.print();
	}
	
	//prints search results
	public void printSearchResults() {
		System.out.println("Printing search results:");
		this.vgSearchResults.print();
	}
	
	//searches the loaded database file for any matches based on the input vgName and consoleName
	//if vgName or consoleName equals *, then include every option in the results.
	//(ref1) strategy:  check each item in the vgDatabase list to see if it matches our search terms vgName and consoleName.
	//matching in this sense means either the input string is a * OR the input string is contained somewhere in the
	//string of the name or console inside the current data node.  I'm using the built in string.contains() method for this
	//and I'm converting both to lowercase for the comparison. (ref1)
	
	//(ref2) note that my loop only runs where there is a next item in the list.  however the processing actions on the current item.
	//therefore after my loop terminates, there is still one item left to process, which is why I perform the comparison one last
	//time after the while loop ends.  I'm sure there is a better way to do this to be more efficient and easier to read, but for
	//now until I figure it I might do this differently (ref2).
	public void searchVGFile (String vgName, String consoleName) {
		//if there is nothing to search just return
		if (this.vgDatabase.isEmpty())
			return;
		Boolean nameMatch = false;
		Boolean consoleMatch = false;
		//reset database pointer in case it got moved
		this.vgDatabase.reset();
		//clear any existing search results
		this.vgSearchResults = new VideoGameLL();
		//iterate through all except last, will need to do this again for the last one
		while(this.vgDatabase.hasNext()) {
			//this is checking our results to see if we have both name and console matches
			//see method description for more details about these 2 lines (ref1)
			//using placeholders to make the if condition a bit cleaner
			//could also refactor this into another method to make it a bit clearer, since I use it again below.
			nameMatch = (vgName.equals("*") || this.vgDatabase.getCurrent().getName().toLowerCase().contains(vgName.toLowerCase()));
			consoleMatch = (consoleName.equals("*") || this.vgDatabase.getCurrent().getConsole().toLowerCase().contains(consoleName.toLowerCase()));
			//if both match, we have a match and we can add it to our results
			if (nameMatch && consoleMatch) {
				//if we have a match, add it to the end of the search results list
				this.vgSearchResults.add(this.vgDatabase.getCurrent());
			}
			this.vgDatabase.gotoNext();
			nameMatch = consoleMatch = false; //reset match flags
		} 
		//need to do this one last time due to my logic, potential refactor opportunity if I want to clean this up
		//same logic again but I need to do this one last time, more details why in the method description (ref2)
		nameMatch = (vgName.equals("*") || this.vgDatabase.getCurrent().getName().toLowerCase().contains(vgName.toLowerCase()));
		consoleMatch = (consoleName.equals("*") || this.vgDatabase.getCurrent().getConsole().toLowerCase().contains(consoleName.toLowerCase()));
		if (nameMatch && consoleMatch) {
			//if we have a match, add it to the end of the search results list
			this.vgSearchResults.add(this.vgDatabase.getCurrent());
		}
	}
	
	//loads VideoGame(s) stored in a file into our VideoGameLL() vgDatabase
	public void loadVGFile(String fileName) {
		try {
			Scanner fileScanner = new Scanner(new File(fileName));
			String fileLine;
			String[] splitLine;
			//reset the database file first, in case there is a loaded file already
			//this is so if we load a new file, we don't just add to our existing list we may have loaded before
			this.vgDatabase = new VideoGameLL();
			//load each game from the file provided
			while(fileScanner.hasNextLine()) {
				fileLine = fileScanner.nextLine();
				splitLine = fileLine.split(DELIM);
				if (splitLine.length != VG_FILE_WIDTH)
					continue;
				String name = splitLine[0];
				String console = splitLine[1];
				this.vgDatabase.add(new VideoGame(name,console));
			}
			fileScanner.close();
		} catch (Exception e) {
			System.out.println("Unable to load the file, please try again.");
			System.out.println("ERROR: "+e.getMessage());
		}
	}
}
