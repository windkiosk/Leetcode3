package util;

import java.util.LinkedList;

public class Graph {
  private int v;   // Number. of vertices
  private LinkedList<Integer> adj[]; //Adjacency Lists

  public Graph(int v) {
    if (v <= 0) {
      throw new RuntimeException("vertices number is less or equal to zero.");
    }
    this.v = v;
    adj = new LinkedList[v];
    for (int i = 0; i < v; i ++) {
      adj[i] = new LinkedList<>();
    }
  }

  public void addEdge(int i, int j) {
    if (i < 0 || i >= v || j < 0 || j >= v) {
      throw new RuntimeException("v index is illegal");
    }
    adj[i].add(j);
    adj[j].add(i);
  }

  void dfs(int s) {
    boolean[] visited = new boolean[v];
    dfsInternal(s, visited);
  }

  private void dfsInternal(int s, boolean[] visited) {
    if (visited[s]) {
      return;
    }

    System.out.println(s);
    visited[s] = true;
    for (int j : adj[s]) {
      dfsInternal(j, visited);
    }
  }

  void bfs(int s) {
    LinkedList<Integer> toVisit = new LinkedList<>();
    toVisit.add(s);

    boolean[] visited = new boolean[v];
    visited[s] = true;

    while (!toVisit.isEmpty()) {
      int t = toVisit.poll();
      System.out.println(t);
      for (int e : adj[t]) {
        if (!visited[e]) {
          visited[e] = true;
          toVisit.offer(e);
        }
      }
    }
  }

  public static void main(String[] args) {
    Graph graph = new Graph(4);
    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(1, 2);
    graph.addEdge(2, 3);

    graph.bfs(0);
    graph.dfs(0);
  }
}
