package graphComponents;

import java.util.HashMap;
import java.util.LinkedList;

import interfaces.IGraph;

/**
 * Implementation of an undirected, weighted graph.
 * @param <Vertex>	Type to be used for vertices in the graph
 */
public class Graph<Vertex> implements IGraph<Vertex> {

	/**
	 * A HashMap using vertices as keys and a linked list holding the edges, as values
	 */
	private final HashMap<Vertex, LinkedList<Edge<Vertex,?>>> graph;
	private final boolean directed;

	/**
	 * Constructor used to make an empty graph
	 * @param directed Boolean used to determine if the graph is directed
	 */
	public Graph(boolean directed) {
		graph = new HashMap<>();
		this.directed = directed;
	}

	/**
	 * Constructor used to create a graph given a array of vertices
	 * @param directed  Boolean used to determine if the graph is directed
	 * @param vertices	Array containing vertices
	 */
	public Graph(boolean directed, Vertex[] vertices){
		this.directed = directed;
		graph = new HashMap<>();

		for(Vertex vertex : vertices){
			graph.putIfAbsent(vertex, new LinkedList<>());
		}
	}

	@Override
	public boolean isEmpty() {
		return graph.isEmpty();
	}

	@Override
	public int numVertices() {
		return graph.size();
	}

	@Override
	public int numEdges() {
		int counter = 0;
		for(LinkedList<Edge<Vertex, ?>> edges : graph.values()) {
			counter += edges.size();
		}
		
		return counter;
	}

	@Override
	public boolean edgeExists(Vertex vertex1, Vertex vertex2) {
		//returns true if the edge exists, false if it does not
		return !(findEdge(vertex1, vertex2) == null);
	}

	@Override
	public Object findWeight(Vertex vertex1, Vertex vertex2) {
		return findEdge(vertex1, vertex2).getWeight();
	}
	
	@Override
	public boolean addEdge(Vertex source, Edge edge) {

		graph.putIfAbsent(source, new LinkedList<>());

		if(directed){
			graph.get(source).add(edge);
			return true;
		}

		//If the graph is not directed, an edge is added connecting the destination to the source as well
		Edge<Vertex, ?> secondEdge = new Edge<>(source, edge.getWeight());
		Vertex destination = (Vertex) edge.getDestination();

		graph.get(source).add(edge);
		graph.get(destination).add(secondEdge);
		return true;

	}

	@Override
	public boolean deleteEdge(Vertex vertex1, Vertex vertex2) {

		Edge<? extends Object, ? extends Object> edge = findEdge(vertex1, vertex2);

		if(edge == null)
			return false;

		if(directed){
			graph.get(vertex1).remove(edge);
		}

		if(!directed){
			graph.get(vertex1).remove(edge);
			graph.get(vertex2).remove(edge);
		}

		return false;
	}

	@Override
	public Edge findEdge(Vertex vertex1, Vertex vertex2) {
		//if the graph doesn't contain either vertex null is returned
		if(!(graph.containsKey(vertex1) || graph.containsKey(vertex2))){
			return null;
		}
		//loops through the edges connected to the first vertex, to find a connection with the second vertex
		for(int edgeInVertex = 0; edgeInVertex < graph.get(vertex1).size(); edgeInVertex++) {
			if(graph.get(vertex1).get(edgeInVertex).getDestination().equals(vertex2)) {
				//if an edge is found, it is returned
				return graph.get(vertex1).get(edgeInVertex);
			}
		}
		//If there is no edge between the first and second vertex null is returned
		return null;
	}

	@Override
	public void breadthFirstSearch(Vertex startVertex) {
	
		LinkedList<Vertex> visited = new LinkedList<>();
		LinkedList<Vertex> queue = new LinkedList<>();
		
		queue.add(startVertex);
		visited.add(startVertex);
		
		while(!queue.isEmpty()) {
			//Search the first element in the queue
			Vertex currentVertex = queue.poll();

			//Looks at each vertex and adds the adjacent vertices to the queue
			//adjacent vertices are also added to the visited set, to prevent searching duplicates
			for (Edge<Vertex, ?> vertexEdge : graph.get(currentVertex)) {
				Vertex nextVertex = vertexEdge.getDestination();
				if (!visited.contains(nextVertex)) {
					visited.add(nextVertex);
					queue.add(nextVertex);
				}
			}
		}
	}

	/**
	 * Prints the graph starting from a given vertex, using breadth-first search
	 * @param startVertex vertex to start the search from
	 */
	public void printGraphBFS(Vertex startVertex){
		LinkedList<Vertex> visited = new LinkedList<>();
		LinkedList<Vertex> queue = new LinkedList<>();

		queue.add(startVertex);
		visited.add(startVertex);

		while(!queue.isEmpty()) {
			//Search the first element in the queue
			Vertex currentVertex = queue.poll();

			//Looks at each vertex and adds the adjacent vertices to the queue
			//adjacent vertices are also added to the visited set, to prevent searching duplicates
			System.out.println(currentVertex.toString() + ": ");

			for (Edge<Vertex, ?> vertexEdge : graph.get(currentVertex)) {
				Vertex nextVertex = vertexEdge.getDestination();
				System.out.println(vertexEdge.toString());
				if (!visited.contains(nextVertex)) {
					visited.add(nextVertex);
					queue.add(nextVertex);
				}
			}
		}
	}





}
