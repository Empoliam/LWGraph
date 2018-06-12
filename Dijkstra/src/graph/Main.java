package graph;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) {

		Graph G = new Graph(
				new Node("S"),
				new Node("A"),
				new Node("B"), 
				new Node("C"), 
				new Node("D"), 
				new Node("T"));
		
		G.addEdge("S", "A", 5);
		G.addEdge("S", "B", 6);
		G.addEdge("S", "C", 2);
		G.addEdge("A", "D", 4);
		G.addEdge("B", "C", 2);
		G.addEdge("B", "D", 4);
		G.addEdge("B", "T", 8);
		G.addEdge("C", "T", 12);
		G.addEdge("D", "T", 3);
		
		ArrayList<Node> shortest = G.Dijkstra(0, 5);
		
		for(Node N : shortest) System.out.println(N.getName());
				
	}

}
