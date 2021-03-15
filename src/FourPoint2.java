import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import utils.Graph;
import utils.Graph.GraphNode;

/**
 * Given a directed graph, design an algorithm to find out whether there is a route between two
 * nodes.
 * <p>
 * Created on the 15th of March, 2021.
 *
 * @author <a href="https://github.com/JulianBroudy"><b>Julian Broudy</b></a>
 */
public class FourPoint2 {

  public static void main(String[] args) {
    Graph graph = new Graph(true);
    GraphNode source = new GraphNode(1);
    GraphNode destination = new GraphNode(7);
    GraphNode n2 = new GraphNode(2);
    GraphNode n3 = new GraphNode(3);
    GraphNode n4 = new GraphNode(4);
    GraphNode n5 = new GraphNode(5);
    GraphNode n6 = new GraphNode(6);
    graph.addEdge(source, n2);
    graph.addEdge(source, n3);
    graph.addEdge(source, n4);
    graph.addEdge(source, n5);
    graph.addEdge(source, n6);
    graph.addEdge(n4, n3);
    graph.addEdge(n4, n5);
    graph.addEdge(n4, n6);
    graph.addEdge(n6, n2);
    graph.addEdge(n2, destination);

    System.out.println(hasRouteBetween(graph, source, destination));


  }

  private static boolean hasRouteBetween(Graph graph, GraphNode source, GraphNode destination) {
    LinkedList<GraphNode> queue = new LinkedList<>();
    Map<GraphNode, HashSet<GraphNode>> nodes = graph.getNodes();
    HashSet<GraphNode> visited = new HashSet<>();

    // BFS:
    queue.add(source);
    GraphNode vertex;
    HashSet<GraphNode> neighbors;
    while (!queue.isEmpty()) {
      vertex = queue.remove();
      if (vertex == destination) {
        return true;
      }
      visited.add(vertex);
      neighbors = nodes.get(vertex);
      for (GraphNode neighbor : neighbors) {
        if (!visited.contains(neighbor)) {
          visited.add(neighbor);
          queue.add(neighbor);
        }
      }
    }
    return false;
  }

}
