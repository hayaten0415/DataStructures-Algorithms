import java.util.ArrayList;
import java.util.List;

/**
 * This class represents a directed graph with no parallel edges
 * 
 * @author morin
 *
 */
public class AdjacencyMatrix implements Graph {
  protected int n;
  protected boolean[][] a;

  public AdjacencyMatrix(int n0) {
    n = n0;
    a = new boolean[n][n];
  }

  public void addEdge(int i, int j) {
    a[i][j] = true;
  }

  public removeEdge(int i, int j) {
    a[i][j] = false;
  }

  public hasEdge(int i, int j) {
    return a[i][j];
  }

  public List<Integer> outEdges(int i) {
    List<Integer> edges = new ArrayList<Integer>();
    for (int j = 0; j < n; j++) {
      if (a[i][j]) edges.add(i);
    }
    return edges;
  }
  
  public List<Integer> inEdges(int i) {
    List<Integer> edges = new ArrayList<Integer>();
    for (int j = 0; j < n; j++) {
      if (a[j][i]) edges.add(i);
    }
    return edges;
  }
}