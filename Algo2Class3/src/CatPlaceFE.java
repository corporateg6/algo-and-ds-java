/*
 * Brently George
 */
public class CatPlaceFE {

	public static void main(String[] args) {
		Cat cat01;
		cat01 = new Cat();
		Cat cat02 = new Cat("Fluff",9,4);
		Cat cat03 = new Cat("Boots",8.8,4);
		Cat cat04 = new Cat();
		System.out.println(cat03);
		System.out.println(cat01.equals(cat04));
		
	}

}
