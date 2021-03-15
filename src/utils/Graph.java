package utils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Graph class.
 * <p>
 * Created on the 15th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class Graph {

  private Map<GraphNode, HashSet<GraphNode>> nodes;
  private boolean directed;


  public Graph(boolean isDirected) {
    this.nodes = new HashMap<>();
    this.directed = isDirected;
  }


  public void addEdge(GraphNode source, GraphNode destination) {

    if (!nodes.containsKey(source)) {
      nodes.put(source, new HashSet<>());
    }

    if (!nodes.containsKey(destination)) {
      nodes.put(destination, new HashSet<>());
    }

    nodes.get(source).add(destination);

    // If a graph is undirected, we want to add an edge from destination to source as well
    if (!directed) {
      nodes.get(destination).add(source);
    }
  }

  /**
   * Gets the nodes.
   *
   * @return nodes's value.
   */
  public Map<GraphNode, HashSet<GraphNode>> getNodes() {
    return nodes;
  }

  public static class GraphNode {

    int data;

    public GraphNode(int data) {
      this.data = data;
    }
  }

}
