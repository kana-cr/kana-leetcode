package 七天练.图.A星;

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
    
    private class Vertex {
        public int id; // 顶点编号ID
        public int dist; // 从起始顶点，到这个顶点的距离，也就是g(i)
        public int f; // 新增：f(i)=g(i)+h(i)
        public int x, y; // 新增：顶点在地图中的坐标（x, y）
        public Vertex(int id, int x, int y) {
          this.id = id;
          this.x = x;
          this.y = y;
          this.f = Integer.MAX_VALUE;
          this.dist = Integer.MAX_VALUE;
        }
      }
      // Graph类的成员变量，在构造函数中初始化
      Vertex[] vertexes = new Vertex[this.v];
      // 新增一个方法，添加顶点的坐标
      public void addVetex(int id, int x, int y) {
        vertexes[id] = new Vertex(id, x, y);
      }


      int hManhattan(Vertex v1, Vertex v2) { // Vertex表示顶点，后面有定义
        return Math.abs(v1.x - v2.x) + Math.abs(v1.y - v2.y);
      }

      private class PriorityQueue { // 根据vertex的f值构建小顶堆
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

    public void clear() {
        count = 0;
        nodes = new Vertex[v+1];
    }
      }
      
      public void astar(int s, int t) { // 从顶点s到顶点t的路径
        int[] predecessor = new int[this.v]; // 用来还原路径
        // 按照vertex的f值构建的小顶堆，而不是按照dist
        PriorityQueue queue = new PriorityQueue(this.v);
        boolean[] inqueue = new boolean[this.v]; // 标记是否进入过队列
        vertexes[s].dist = 0;
        vertexes[s].f = 0;
        queue.add(vertexes[s]);
        inqueue[s] = true;
        while (!queue.isEmpty()) {
          Vertex minVertex = queue.poll(); // 取堆顶元素并删除
          for (int i = 0; i < adj[minVertex.id].size(); ++i) {
            Edge e = adj[minVertex.id].get(i); // 取出一条minVetex相连的边
            Vertex nextVertex = vertexes[e.tid]; // minVertex-->nextVertex
            if (minVertex.dist + e.w < nextVertex.dist) { // 更新next的dist,f
              nextVertex.dist = minVertex.dist + e.w;
              nextVertex.f 
                 = nextVertex.dist+hManhattan(nextVertex, vertexes[t]);
              predecessor[nextVertex.id] = minVertex.id;
              if (inqueue[nextVertex.id] == true) {
                queue.update(nextVertex);
              } else {
                queue.add(nextVertex);
                inqueue[nextVertex.id] = true;
              }
            }
            if (nextVertex.id == t) { // 只要到达t就可以结束while了
              queue.clear(); // 清空queue，才能推出while循环
              break; 
            }
          }
        }
        // 输出路径
        System.out.print(s);
        //print(s, t, predecessor); // print函数请参看Dijkstra算法的实现
      }
}