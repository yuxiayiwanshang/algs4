public class DepthFirstPaths{
  private boolean[] marked;
  private int[] edgeTo;
  private int s;
  
  public DepthFirstPaths(Graph graph,int s){
    marked = new boolean[graph.V()];
    edgeTo = new int[graph.V()];
    this.s = s;
    dfs(graph,s);
  }
  
  public void dfs(Graph graph,int s){
    marked[s] = true;
    for(int w: graph.adj(s)){
      if(!marked[w]){
        edgeTo[w] = s;
        dfs(graph,w);
      }
    }
  }
  
  public boolean hasPathTo(int v){
    return marked[v];
  }
  
  public Iterable<Integer> pathTo(int v){
    if(!hasPathTo(v)) return null;
    Stack<Integer> st = new Stack<Integer>();
    for(int i=v;i != s; i=edgeTo(i)){
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
    
    DepthFirstPaths dfs = new DepthFirstPaths(G, 1);

    for (int i= 0; i < graph.V(); i++) {
      if (dfs.hasPathTo(i)) {
      System.out.printf("%d to %d:  ", s, i);
      for (int w : dfs.pathTo(i) ){
        if (w == s) System.out.print(w);
        else        System.out.print("-" + w);
        }
        System.out.println();
      }
      else {
        System.out.printf("%d to %d:  not connected\n", s, i);
      }
    }
  }
}
