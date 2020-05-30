package leetcode;

public class P509_FibonacciNumber {

  public static void main(String[] args) {
    P509_FibonacciNumber p509_fibonacciNumber = new P509_FibonacciNumber();
    System.out.println(p509_fibonacciNumber.fibIterative(5));
  }

  int fib(int n) {
    if (n <= 0) return 0;
    if (n == 1 || n == 2) return 1;

    return fib(n - 1) + fib(n - 2);
  }

  int fibIterative(int n) {
    if (n <= 0) return 0;
    if (n == 1 || n == 2) return 1;

    int first = 1;
    int second = 1;
    for (int i = 3; i <= n; i ++) {
      int tmp = first + second;
      first = second;
      second = tmp;
    }
    return second;
  }
}
