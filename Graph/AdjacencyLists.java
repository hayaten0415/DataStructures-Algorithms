import java.util.Iterator;
import java.util.List;

public class AdjacencyLists implements Graph {
  int n;
  List<Integer>[] adj;

  public AdjacencyLists(int n0) {
    n = n0;
    adj = (List<Integer>[]) new List[n];
    for (int i = 0; i < n; i++)
      adj[i] = new ArrayStack<Integer>();
  }

  public void addEdge(int i, int j) {
    adj[i].add(j);
  }

  public void removeEdge(int i, int j) {
    Iterator<Integer> it = adj[i].iterator();
    while (it.hasNext()) {
      if (it.next() == j) {
        it.remove();
        return;
      }
    }
  }

  public boolean hasEdge(int i, int j) {
    return adj[i].contains(j);
  }

  public List<Integer> outEdges(int i) {
    return adj[i];
  }

  public List<Integer> inEdges(int i) {
    List<Integer> edges = new ArrayStack<Integer>();
    for (int j = 0; j < n; j++) {
      if (adj[j].contains(i)) edges.add(j);
    }
    return edges;
  }
}