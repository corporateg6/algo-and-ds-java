
public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		QueueI<Integer> qI;
		qI = new ArrayQueue<Integer>();
		for(int i=0;i<10;i++)
			qI.enqueue(i);
		for(int i=0;i<10;i++)
			System.out.println(qI.dequeue());
	}

}
