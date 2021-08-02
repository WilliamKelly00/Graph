package interfaces;

import graphComponents.Edge;

/**
 * Interface for the implementation of a graph
 * @param <Vertex> Type of Vertex used
 */
public interface IGraph<Vertex> {
	/**
	 * Determines if the graph is empty
	 * @return	true if the graph is empty
	 */
	public boolean isEmpty();

	/**
	 * Returns the number of vertices in the graph
	 * @return	number of vertices
	 */
	public int numVertices();

	/**
	 * Returns the number of edges in the graph
	 * @return	number of edges in graph
	 */
	public int numEdges();

	/**
	 * Determines if an edge between two vertices exists in the graph
	 * @param vertex1	first vertex
	 * @param vertex2	second vertex
	 * @return	true if an edge exists
	 */
	public boolean edgeExists(Vertex vertex1, Vertex vertex2);

	/**
	 * Finds the weight of an edge between two vertices
	 * @param vertex1	first vertex
	 * @param vertex2	second vertex
	 * @return	Weight of the edge if it exists, null if it does not
	 */
	public Object findWeight(Vertex vertex1, Vertex vertex2);

	/**
	 * Deletes an edge connecting two vertices
	 * @param vertex1	first vertex
	 * @param vertex2	second vertex
	 * @return true if the graph was modified
	 */
	public boolean deleteEdge(Vertex vertex1, Vertex vertex2);

	/**
	 * Finds an edge between two vertices, then returns it
	 * @param vertex1	first vertex
	 * @param vertex2	second vertex
	 * @return	edge connecting the two vertices
	 */
	public Object findEdge(Vertex vertex1, Vertex vertex2);

	/**
	 * Traverses the graph using Breadth-First Search
	 * @param startVertex	Starting vertex for the traversal
	 */
	public void breadthFirstSearch(Vertex startVertex);

	/**
	 * Adds an edge between two vertices
	 * @param vertex1	source vertex
	 * @param edge	edge containing the destination, and weight
	 * @return	returns true if the graph was modified
	 */
	boolean addEdge(Vertex vertex1, Edge edge);
}
