package graphComponents;

/**
 * This class is used to create a pairing between a destination vertex, and the weight of the edge to that vertex
 * @param <Vertex>	Destination vertex
 * @param <Weight>	Weight of the edge
 */
public class Edge<Vertex, Weight> {
	/**
	 * Weight of the edge
	 */
	private Weight weight;
	/**
	 * Destination vertex of the edge
	 */
	private Vertex destination;

	public Edge(Vertex destination, Weight weight) {
		this.destination = destination;
		this.weight = weight;
	}

	/**
	 * Returns the weight of the edge
	 * @return weight of the edge
	 */
	public Weight getWeight() {
		return weight;
	}

	/**
	 * Sets the weight of the edge
	 * @param weight weight to be set to
	 */
	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	/**
	 * Returns the destination vertex
	 * @return destination vertex
	 */
	public Vertex getDestination() {
		return destination;
	}

	/**
	 * Sets the destination vertex
	 * @param destination	vertex to be set to
	 */
	public void setDestination(Vertex destination) {
		this.destination = destination;
	}

	@Override
	public String toString(){
		return "(" + destination.toString() + ", " + weight + ")";
	}
	
	

}
