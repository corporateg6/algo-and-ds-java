
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackI<Integer> iStack;
		iStack = new LLStack<Integer>();
		for(int i=0; i<10; i++)
			iStack.push(i);
		for(int i=0; i<10; i++)
			System.out.println(iStack.pop());
	}

}
