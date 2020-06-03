package algo.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DeadLock {

  public static void main(String[] args) {
    MyThread thread1 = new MyThread(1, new int[]{2, 5});
    MyThread thread2 = new MyThread(2, new int[]{4, 3});
    MyThread thread3 = new MyThread(3, new int[]{1, 6});

    DeadLock lock = new DeadLock();
    System.out.println(lock.findDeadLock(new MyThread[]{thread1, thread2, thread3}));
  }

  boolean findDeadLock(MyThread[] threads) {
    Map<Integer, Set<Integer>> map = new HashMap<>();

    for (MyThread thread : threads) {
      Set<Integer> set = map.computeIfAbsent(thread.waitingLock, k -> new HashSet<>());

      for (int hold : thread.holdingLock) {
        set.add(hold);
      }
    }

    Set<Integer> path = new HashSet<>();
    for (int wait : map.keySet()) {
      if (dfs(wait, map, path)) {
        return true;
      }
    }

    return false;
  }

  private boolean dfs(int wait, Map<Integer, Set<Integer>> map, Set<Integer> path) {
    if (!path.add(wait)) {
      return true;
    }

    for (int hold : map.get(wait)) {
      if (dfs(hold, map, path)) {
        return true;
      }
    }

    path.remove(wait);
    return false;
  }

  static class MyThread {

    int waitingLock;
    int[] holdingLock;

    public MyThread(int waitingLock, int[] holdingLock) {
      this.waitingLock = waitingLock;
      this.holdingLock = holdingLock;
    }
  }
}
