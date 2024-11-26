/*
 * Brently G
 */
import java.util.*;

//of type double for this example
public class AdjMatrixGraph {
	public static final int DEF_VERT = 10;
	private double[][] adjMatrix;
	private LinkedList<Integer> markedList;
	
	public AdjMatrixGraph() {
		init(DEF_VERT);
	}
	
	public AdjMatrixGraph(int verts) {
		init(verts);
	}
	
	private void init(int verts) {
		if(verts <= 0) {
			verts = DEF_VERT;
		}
		adjMatrix = new double[verts][verts];
		//populate graph with default values of 0.0
		for(int i=0;i<adjMatrix.length;i++) {
			for(int j=0;j<adjMatrix[i].length;j++) {
				adjMatrix[i][j] = 0.0;
			}
		}
		markedList = new LinkedList<Integer>();
	}
	
	public void addEdge(int fromVert, int toVert, double weight) {
		if(!isValid(fromVert) || !isValid(toVert))
			return;
		adjMatrix[fromVert][toVert] = weight;
	}
	
	private boolean isValid(int index) {
		return index >=0 && index < adjMatrix.length;
	}
	
	public void printGraph() {
		for(int i=0;i<adjMatrix.length;i++) {
			for(int j=0;j<adjMatrix[i].length;j++) {
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//depth first search
	public void printDFS() {
		markedList.clear();
		printDFS(0);
	}
	
	public void printDFSorigin(int startVert) {
		markedList.clear();
		if(!isValid(startVert))
			return;
		printDFS(startVert);
	}
	
	private void printDFS(int index) {
		System.out.println(index);
		markedList.add(index);
		for(int i=0;i<adjMatrix.length;i++) {
			if(adjMatrix[index][i] != 0.0 && !markedList.contains(i)) {
				printDFS(i);
			}
		}
	}
	
}
