package 七天练.图.Dijkstra;

import java.util.LinkedList;

public class Graph {
    private LinkedList<Edge>[] adj; // 邻接表
    private int v; // 顶点个数

    @SuppressWarnings("unchecked")
    public Graph(int v) {
      this.v = v;
      this.adj = new LinkedList[v];
      for (int i = 0; i < v; ++i) {
        this.adj[i] = new LinkedList<>();
      }
    }
    public void addEdge(int s, int t, int w) { // 添加一条边
      this.adj[s].add(new Edge(s, t, w));
    }

    private class Edge{

    public int sid; // 边的起始顶点编号
    public int tid; // 边的终止顶点编号
    public int w; // 权重

        public Edge(int s, int t, int w) {
            sid = s;
            tid = t;
            this.w = w;
        }
        
    }

    // 下面这个类是为了dijkstra实现用的
   private class Vertex {
    public int id; // 顶点编号ID
    public int dist; // 从起始顶点到这个顶点的距离
    public Vertex(int id, int dist) {
        this.id = id;
        this.dist = dist;
      }
}

private class PriorityQueue { // 根据vertex.dist构建小顶堆
    private Vertex[] nodes;
    private int count;
    public PriorityQueue(int v) {
      this.nodes = new Vertex[v+1];
      this.count = v;
    }
    public Vertex poll() { 
        if(count==0) return null;
      Vertex minVertex = nodes[1];  
      nodes[1] = nodes[count];
      --count;
      update(nodes[count]);
      return minVertex;
     }


    public void add(Vertex vertex) {
    if (count >= nodes.length - 1) return; // 堆满了
    ++count;
    nodes[count] = vertex;
    update(vertex);
    /**while (i/2 > 0 && nodes[i].dist > nodes[i/2].dist) { 
        // 自下往上堆化
      swap(nodes, i, i/2); 
      i = i/2;
    }**/    }

    // 更新结点的值，并且从下往上堆化，重新符合堆的定义。时间复杂度O(logn)。
    public void update(Vertex vertex) {
        int i = count;
        while (i/2 > 0 && nodes[i].dist < nodes[i/2].dist) { 
            swap(nodes, i, i/2);
            i = i/2;
          }
     } 

    public boolean isEmpty() { 
        return count == 0;
    }

           //交换
private void swap(Vertex[] arr,int a,int b){
    Vertex tmp = arr[a];
    arr[a]=arr[b];
    arr[b]=tmp;
}
  }

// 从顶点s到顶点t的最短路径
  public void dijkstra(int s, int t) { 
      // 用来还原最短路径
    int[] predecessor = new int[this.v]; 
    Vertex[] vertexes = new Vertex[this.v];
    for (int i = 0; i < this.v; ++i) {
        vertexes[i] = new Vertex(i, Integer.MAX_VALUE);
      }  
    PriorityQueue queue = new PriorityQueue(this.v);//小顶堆
    boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
    vertexes[s].dist = 0;
    queue.add(vertexes[s]);
    inqueue[s] = true;
    while(!queue.isEmpty()){
        Vertex minVertex= queue.poll(); // 取堆顶元素并删除
        if(minVertex.id == t) break;//最短路径产生
        for (int i = 0; i < adj[minVertex.id].size(); ++i) {
            Edge e = adj[minVertex.id].get(i); // 取出一条minVetex相连的边
            Vertex nextVertex = vertexes[e.tid];// minVertex-->nextVertex
            if (minVertex.dist + e.w < nextVertex.dist) { // 更新next的dist
                nextVertex.dist = minVertex.dist + e.w;
                predecessor[nextVertex.id] = minVertex.id;
                if(inqueue[nextVertex.id]){
                    queue.update(nextVertex);
                } else {
                    queue.add(nextVertex);
                    inqueue[nextVertex.id] = true;
                  }

            }


        }
    }
    
  }
}