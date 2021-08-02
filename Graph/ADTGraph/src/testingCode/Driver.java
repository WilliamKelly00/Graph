package testingCode;

import graphComponents.Edge;
import graphComponents.Graph;

import java.util.Random;

/**
 * Driver class used to test the ADT Graph
 */
public class Driver {
	public static void main(String[] args){

		Random random = new Random(System.currentTimeMillis());

		ExampleVertex[] exampleVertices = new ExampleVertex[10];
		for(int i = 0; i < exampleVertices.length; i++){
			exampleVertices[i] = new ExampleVertex(i, "Example vertex: " + i + "");
		}

		Graph<ExampleVertex> exampleGraph = new Graph<>(false, exampleVertices);

		for(int i = 0; i < exampleVertices.length -1; i++){
			exampleGraph.addEdge(exampleVertices[i], new Edge<ExampleVertex, Integer>(exampleVertices[i+1], random.nextInt(50)+1));
		}

		Graph<ExampleVertex> exampleGraphDirected = new Graph<>(true, exampleVertices);
		for(int i = 0; i < exampleVertices.length -1; i++){
			exampleGraphDirected.addEdge(exampleVertices[i], new Edge<ExampleVertex, Integer>(exampleVertices[i+1], random.nextInt(50)+1));
		}


		System.out.println("Number of edges: " + exampleGraph.numEdges());
		System.out.println("Number of vertices: " +exampleGraph.numVertices());

		System.out.println("Number of edges in directed graph: " + exampleGraphDirected.numEdges());

		System.out.println("is the graph empty? :" + exampleGraph.isEmpty());

		System.out.println("Printing the undirected graph");
		exampleGraph.printGraphBFS(exampleVertices[0]);
		System.out.println("Printing the directed graph \n");
		exampleGraphDirected.printGraphBFS(exampleVertices[0]);
	}

}
