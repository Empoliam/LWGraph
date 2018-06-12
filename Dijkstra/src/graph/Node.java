package graph;
import java.util.ArrayList;

public class Node {

	private ArrayList<Edge> Edges = new ArrayList<Edge>();
	private String name;
	
	//Dijkstra parameters
	protected int workingValue;
	protected int finalValue;
	protected boolean done;
	
	public Node(String name) {
		this.name = name;
	}

	public void addEdge(Edge E) {
		Edges.add(E);
	}
	
	public ArrayList<Edge> getEdges() {
		return Edges;
	}
	
	public String getName() {
		return name;
	}
	
	//Dijkstra methods
	
	public void purge() {
		workingValue = Integer.MAX_VALUE;
		done = false;
	}
	
	public int getWorkingValue() {
		return workingValue;
	}

	public void setWorkingValue(int workingValue) {
		this.workingValue = workingValue;
	}

	public int getFinalValue() {
		return finalValue;
	}

	public void setFinalValue(int finalValue) {
		this.finalValue = finalValue;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}
	
}
