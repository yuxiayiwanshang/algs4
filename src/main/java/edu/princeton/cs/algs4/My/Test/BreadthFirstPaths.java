import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BreadthFirstPaths{
  private static final int INFINITY = Integer.MAX_VALUE;
  private boolean[] marked;
  private int[] edgeTo;
  private static final s;
  private int[] distTo;
  
  public BreadthFirstPaths(Graph graph,int s){
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    distTo = new int[graph.V()];
    for(int i=0;i<graph.V();i++){
      distTo[i]= INFINITY;
    }
    this.s = s;
    bfs(graph,s);
  }
  
  public void bfs(Graph graph,int s){
    BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>();
    distTo[s];
    marked[s]=true;
    queue.add(s);
    while(!queue.empty()){
      int v = queue.remove();
      //marked[v]=true;
      for(int w:graph.adj(v)){
        if(!marked[w]){
          queue.add(w);
          marked[w]=true;
          distTo[w] = distTo[v]+1;
          edgeTo[w] = v;
        }
      }
    }
  }
  
  public boolean hasPathTo(int v){
    return marked[v];
  }
  
  public Iterable<Integer> pathTo(int v){
    if(!hasPathTo(v)) return null;
    Stack<Integer> st = new Stack<Integer>();
    for(int i=v;i != s; i=edgeTo[i]){
      st.push(i);
    }
    st.push(s);
    return st;
  }
  
  public static void main(String[] args) {
        
    int v = 8;
    int[] edges = {1,2,1,3,2,4,2,5,3,6,3,7};
    Graph graph = new Graph(v,edges);
    System.out.println(graph.toString());
    
    DepthFirstPaths dfs = new DepthFirstPaths(graph,1);

    for (int i= 0; i < graph.V(); i++) {
      if (dfs.hasPathTo(i)) {
      System.out.printf("%d to %d:  ", s, i);
      for (int w : dfs.pathTo(i) ){
        if (w == s) System.out.print(w);
        else        System.out.print(w + "->");
        }
        System.out.println();
      }
      else {
        System.out.printf("%d to %d:  not connected\n", s, i);
      }
    }
  }
  
  static class Graph{
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
  }
}
