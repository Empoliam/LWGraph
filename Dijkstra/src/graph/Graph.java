package graph;
import java.util.ArrayList;
import java.util.Collections;

public class Graph {

	protected ArrayList<Node> Nodes = new ArrayList<Node>();

	public Graph() {

	}

	public Graph(Node... N) {
		for (Node O : N) {
			Nodes.add(O);
		}
	}

	public void addEdge(int A, int B, int weight) {

		Node X = Nodes.get(A);
		Node Y = Nodes.get(B);

		Edge E = new Edge(X, Y, weight);

		Y.addEdge(E);
		X.addEdge(E);

	}

	public void addEdge(String A, String B, int weight) {

		Node X = null;
		Node Y = null;

		for(Node N : Nodes) {
			if(A.equals(N.getName())) X = N;
			else if(B.equals(N.getName())) Y = N;
		}

		try {
			Edge E = new Edge(X, Y, weight);

			Y.addEdge(E);
			X.addEdge(E);
		}
		catch(NullPointerException e) {
			System.out.println("One or more of the requested vertices is invalid");
		}
	}

	public void printGraph() {

		ArrayList<Edge> Edges = new ArrayList<Edge>();

		for(Node N : Nodes) {
			ArrayList<Edge> L = N.getEdges();
			for(Edge E : L) {
				if(!Edges.contains(E)) Edges.add(E);
			}
		}

		for(Edge E : Edges) {
			System.out.println(E.getNodeA().getName() + " - " + E.getNodeB().getName() + " : " + E.getWeight());
		}

	}

	public ArrayList<Node> Dijkstra(int s, int e) {

		Node start = Nodes.get(s);
		Node end = Nodes.get(e);

		ArrayList<Node> route = new ArrayList<Node>();

		for(Node N : Nodes) N.purge();

		start.setFinalValue(0);
		start.setDone(true);

		Node active = start;

		while(!end.getDone()) {

			for(Edge E : active.getEdges()) {

				Node check;

				if(E.getNodeA() == active) check = E.getNodeB();
				else check = E.getNodeA();

				if(! check.getDone()) {
					int newWorking = E.getWeight() + active.getFinalValue();
					if(check.getWorkingValue() > newWorking) check.setWorkingValue(newWorking);
				}

			}

			for(Node N : Nodes) {
				if(!N.getDone()) {
					if(active.getDone() || active.getWorkingValue() > N.getWorkingValue()) active = N;
				}
			}

			active.setFinalValue(active.getWorkingValue());
			active.setDone(true);

		}

		for(Node N : Nodes) System.out.println(N.getName() + " : " + N.getFinalValue());

		route.add(end);

		Node reverse = end;
		while(reverse != start) {
			for(Edge E : reverse.getEdges()) {
				if((reverse.getFinalValue() - E.getWeight()) == E.getNodeA().getFinalValue()) {
					reverse = E.getNodeA();
					break;
				}
				else if((reverse.getFinalValue() - E.getWeight()) == E.getNodeB().getFinalValue()) {
					reverse = E.getNodeB();
					break;
				}
			}
			route.add(reverse);
		}

		Collections.reverse(route);

		return route;

	}

}
