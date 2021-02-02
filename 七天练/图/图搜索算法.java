package 七天练.图;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 图搜索算法 {
    
   private static final int v = 8; 

   private Graph graph = new Graph(v);

   //广度优先搜索
    public void bfs(int s,int t){
        //属于同一个顶点
        if(s == t) return;
        //用于记录是否访问过这个顶点，避免重复访问
        boolean[] visited = new boolean[v];
        //出发点为true
        visited[s] = true;
        //用于存储已经被访问，但是相邻节点未被访问的节点
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        //用于记录搜索路径，路径被反向存储
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
          prev[i] = -1;
        }
        while(queue.size() > 0){
            //弹出队列头部元素
            int w = queue.poll();
            //遍历元素相邻所有顶点
            for (int i = 0; i < graph.adj[w].size(); i++) {
               int q = graph.adj[w].get(i);
               //记录该顶点已被访问
               if(!visited[q]){
                prev[q] = w;
                if(q == t){
                    print(prev, s, t);
                    return ;
                }
                visited[q] = true;
                queue.add(q);
               }
            }
        }
    }

    //用于记录是否已经找到
    public boolean found = false;

//深度优先搜索
    public void dfs(int s,int t){
        found = false;
        //属于同一个顶点
        if(s == t) return;
        //用于记录是否访问过这个顶点，避免重复访问
        boolean[] visited = new boolean[v];
        //用于记录搜索路径，路径被反向存储
        int[] prev = new int[v];
        for (int i = 0; i < v; ++i) {
          prev[i] = -1;
        }
        recurDfs(s, t, visited, prev);
        print(prev, s, t);
      
    }


    private void recurDfs(int w, int t, boolean[] visited, int[] prev) {
     if(found == true) return;
     visited[w] = true;
     if(w == t){
        found = true;
        return;
     } 
     for (int i = 0; i < graph.adj[w].size(); i++) {
        int q = graph.adj[w].get(i);
        if(!visited[q]){
            prev[q] = w;
            recurDfs(q, t, visited, prev);
        }
     }
    }

    //拓扑排序 kahn算法 使用贪心思路
    public void topoSortbyKahn(){
        int[] inDegree = new int[v]; // 统计每个顶点的入度
        for (int i = 0; i < v; ++i) {
            for (int j = 0; j < graph.adj[i].size(); ++j) {
              int w = graph.adj[i].get(j); // i->w
              inDegree[w]++;
            }
          }
          LinkedList<Integer> queue = new LinkedList<>();
          for (int i = 0; i < v; ++i) {
            if (inDegree[i] == 0) queue.add(i);
          }
          while (!queue.isEmpty()) {
            int i = queue.remove();
            System.out.print("->" + i);
            for (int j = 0; j < graph.adj[i].size(); ++j) {
              int k = graph.adj[i].get(j);
              inDegree[k]--;
              if (inDegree[k] == 0) queue.add(k);
            }
          }

    }
    public void topoSortByDFS() {
        // 先构建逆邻接表，边s->t表示，s依赖于t，t先于s
        LinkedList<Integer> inverseAdj[] = new LinkedList[v];
        for (int i = 0; i < v; ++i) { // 申请空间
          inverseAdj[i] = new LinkedList<>();
        }
        for (int i = 0; i < v; ++i) { // 通过邻接表生成逆邻接表
          for (int j = 0; j < graph.adj[i].size(); ++j) {
            int w = graph.adj[i].get(j); // i->w
            inverseAdj[w].add(i); // w->i
          }
        }
        boolean[] visited = new boolean[v];
        for (int i = 0; i < v; ++i) { // 深度优先遍历图
          if (visited[i] == false) {
            visited[i] = true;
            dfs(i, inverseAdj, visited);
          }
        }
      }
      private void dfs(
          int vertex, LinkedList<Integer> inverseAdj[], boolean[] visited) {
        for (int i = 0; i < inverseAdj[vertex].size(); ++i) {
          int w = inverseAdj[vertex].get(i);
          if (visited[w] == true) continue;
          visited[w] = true;
          dfs(w, inverseAdj, visited);
        } // 先把vertex这个顶点可达的所有顶点都打印出来之后，再打印它自己
        System.out.print("->" + vertex);
      }

    // 递归打印s->t的路径  
    private void print(int[] prev, int s, int t) { 
        if(prev[t] != -1){
            print(prev, s, prev[t]);
        }
        System.out.println(t + " ");
    }
}