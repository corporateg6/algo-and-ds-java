/*
 * Brently George
 */

package algo2class2;
import java.util.Scanner;

public class startingPoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Welcome to the sorter. Enter the size of the array.");
		int size = keyboard.nextInt();
		keyboard.nextLine(); //useful fixup??? 
		if (size <= 1) {
			System.out.println("That's invalid");
			System.exit(0); //terminate
		}
		//create array
		int[] a = new int[size];
		//populate the array
		for(int i=0;i<a.length;i++)
		{
			System.out.println("Enter value at index "+i);
			a[i] = keyboard.nextInt();
			keyboard.nextLine();
		}
		//Sorting - selection sort
		for(int i=0;i<a.length;i++)
		{
			int smallestIndex = i;
			for (int j=i+1;j<a.length;j++)
			{
				if(a[j] < a[smallestIndex])
				{
					smallestIndex = j;
				}
			}
			if(smallestIndex != 1)
			{
				//Swap
				int temp = a[i];
				a[i] = a[smallestIndex];
				a[smallestIndex] = temp;
			}

		}
		//Print it out
		for (int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}

	}

}
