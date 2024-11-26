
public class DummyClass implements Comparable<DummyClass> {
	public double value;
	public String otherVal;
	
	public int compareTo(DummyClass aD) {
		if(aD == null)
			return -1;
		if(value < aD.value)
			return -1;
		else if(value > aD.value)
			return 1;
		else
			return otherVal.compareTo(otherVal);
	}
}
