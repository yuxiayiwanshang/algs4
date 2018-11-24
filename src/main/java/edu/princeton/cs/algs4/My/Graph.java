import java.util.List;
import java.util.ArrayList;

public class Graph{
  private static final String NEWLINE = System.getProperty("line.separator");
  private int V;
  private int E;
  private List<Integer>[] adj;
  
  public Graph(int V){
    this.V = V;
    this.E =0;
    adj = new ArrayList[V];
    for(int i=0;i<V;i++){
      adj[i] = new ArrayList<>();
    }
  }
  public Graph(int V,int[] edges){
    this(V);
    for(int i=0;i<edges.length-1;i=i+2){
      addEdge(edges[i],edges[i+1]);
    }
  }
  
  public int V() {
    return V;
  }
  
  public int E() {
    return E;
  }
  
  
  public void addEdge(int v,int w){
    this.E++;
    adj[v].add(w);
    adj[w].add(v);
  }
  
  public Iterable<Integer> adj(int v) {
        return adj[v];
  }
  
  public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " vertices, " + E + " edges " + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (int w : adj[v]) {
                s.append(w + " ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
  }
  
  public static void main(String[] args){
    int v = 7;
    int[] edges = {0,1,0,2,1,3,1,4,2,5,2,6};
    Graph graph = new Graph(v,edges);
    System.out.println(graph.toString());
  }
}
