package 七天练.图;

import java.util.LinkedList;

//无向图
public class Graph {
    public int v;//顶点个数
    public LinkedList<Integer>[] adj;//邻接表

    @SuppressWarnings("unchecked")
    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            this.adj[i] = new LinkedList<>();
        }
    }

    //增加一条边 无向图一条边存两次 有向图存一次
    public void addEdge(int i , int j){
      adj[i].add(j);
      adj[j].add(i);
    }

    
}