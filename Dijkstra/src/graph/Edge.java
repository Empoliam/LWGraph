package graph;

public class Edge {

	protected Node A;
	protected Node B;
	
	protected int weight;

	public Edge(Node A, Node B, int weight) {

		this.A = A;
		this.B = B;

		this.weight = weight;
		
	}

	public Node getNodeA() {
		return A;
	}
	
	public Node getNodeB() {
		return B;
	}
	
	public int getWeight() {
		return weight;
	}

}
