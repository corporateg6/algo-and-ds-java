/*
 * Brently George
 */

import java.util.Scanner;
import java.io.*;


public class TacoManager {
	
	//private Taco[] tacos;
	private GenLL<Taco> tacos;
	public static final String DELIM = "\t";//Tab
	//public static final int HEADER_FIELD_AMT = 2;
	public static final int BODY_FIELD_AMT = 3;
	//public static final int DEF_SIZE = 100;
	
	public TacoManager() {
		tacos = new GenLL<Taco>();
		//init(DEF_SIZE);
	}
	
	/*
	public TacoManager(int size) {
		init(size);
	}
	
	public void init(int size) {
		if (size>=1)
			this.tacos = new Taco[size];
		else
			this.tacos = new Taco[DEF_SIZE];
	}*/
	
	public void addTaco(Taco aTaco) {
		
		if (aTaco == null)
			return;
		
		tacos.add(aTaco);
		
		/*
		if (this.tacos[this.tacos.length-1] != null)
			return;
		for (int i=0;i<this.tacos.length;i++) {
			if (this.tacos[i] == null) {
				this.tacos[i] = aTaco;
				break;
			}
		} */
		
		//TODO sort
	}
	
	public void removeTaco(String aName) {
		tacos.reset();
		while(tacos.hasMore()) {
			if(tacos.getCurrent().getName().equals(aName)) {
				tacos.removeCurrent();
				break;
			}
			tacos.gotoNext();
		}
		/*
		int removeIndex = -1;
		//Search
		for (int i=0; i<this.tacos.length; i++) {
			if(this.tacos[i] != null && this.tacos[i].getName().equals(aName)) {
				removeIndex = i;
				break;
			}
		}
		//if search fails
		if (removeIndex == -1)
			return;
		//remove and shift left
		for (int i=removeIndex;i<this.tacos.length-1;i++)
			this.tacos[i] = this.tacos[i+1];
		this.tacos[this.tacos.length-1] = null;
		*/
	}
	
	public void print() {
		tacos.print();
		/*
		for (int i=0;i<tacos.length;i++) {
			if(tacos[i] == null)
				break;
			System.out.println(tacos[i]);
		}*/
	}
	
	public void writeTacoFile (String aName) {
		try {
			PrintWriter fileWriter = new PrintWriter(new FileOutputStream(aName));
			//print header
			//fileWriter.println("Taco Amt:"+DELIM+this.tacos.length);
			//print body
			tacos.reset();
			while (tacos.hasMore()) {
				Taco current = tacos.getCurrent();
				fileWriter.println(current.getName()+DELIM+
						current.getLocation()+DELIM+
						current.getPrice());
				tacos.gotoNext();
			}
			/*
			for (int i = 0; i<this.tacos.length; i++) {
				if (tacos[i] == null)
					break;
				fileWriter.println(this.tacos[i].getName()+DELIM+
						this.tacos[i].getLocation()+DELIM+
						this.tacos[i].getPrice());
			}*/
			fileWriter.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void readTacoFile(String aName) {
		try {
			Scanner fileScanner = new Scanner(new File(aName));
			/*Read the header
			String fileLine = fileScanner.nextLine();
			//Split the line
			String[] splitLines = fileLine.split(DELIM);
			if(splitLines.length != HEADER_FIELD_AMT)
				return;
			int size = Integer.parseInt(splitLines[1]);
			*/
			//Read the body
			while(fileScanner.hasNextLine()) {
				String fileLine = fileScanner.nextLine();
				String[] splitLines = fileLine.split(DELIM);
				if(splitLines.length != BODY_FIELD_AMT)
					continue;
				String name = splitLines[0];
				String loc = splitLines[1];
				double price = Double.parseDouble(splitLines[2]);
				Taco newTaco = new Taco(name,loc,price);
				this.addTaco(newTaco);
			}
			fileScanner.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void sortByPrice() {
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i=0; i<tacos.getSize();i++) {
				if(tacos.getAt(i).getPrice() > tacos.getAt(i+1).getPrice()) {
					Taco temp = tacos.getAt(i);
					Taco temp1 = tacos.getAt(i+1);
					tacos.setAt(i, temp1);
					tacos.setAt(i+1, temp);
					swapped = true;
				}
			}
		}
		/*
		boolean swapped = true;
		while (swapped) {
			swapped = false;
			for (int i=0;i<tacos.length=1;i++) {
				if(tacos[i] == null || tacos[i+1] == null)
					break;
				if(tacos[i].getPrice() > tacos[i+1].getPrice()) {
					Taco temp = tacos
				}
			}
		}*/
	}
	
}
