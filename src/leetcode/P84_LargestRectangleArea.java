package leetcode;

import java.util.Stack;

/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 */
public class P84_LargestRectangleArea {

  public static void main(String[] args) {
    int[] height = new int[]{2,1,5,6,2,3};
    // System.out.println(largestRectangleArea(height));
    System.out.println(findByDp(height));
  }

  // The main function to find the maximum rectangular area under given
  // histogram with n bars
  public static int largestRectangleArea(int hist[]) {
    // Create an empty stack. The stack holds indexes of hist[] array
    // The bars stored in stack are always in increasing order of their
    // heights.
    Stack<Integer> stack = new Stack<>();

    int max_area = 0; // Initialize max area
    int tp;  // To store top of stack
    int area_with_top; // To store area with top bar as the smallest bar

    // Run through all bars of given histogram
    int i = 0;
    while (i < hist.length) {
      // If this bar is higher than the bar on top stack, push it to stack
      if (stack.empty() || hist[stack.peek()] <= hist[i])
        stack.push(i++);

        // If this bar is lower than top of stack, then calculate area of rectangle
        // with stack top as the smallest (or minimum height) bar. 'i' is
        // 'right index' for the top and element before top in stack is 'left index'
      else {
        tp = stack.pop();  // pop the top

        // Calculate the area with hist[tp] stack as smallest bar
        area_with_top = hist[tp] * (stack.empty() ? i : i - stack.peek() - 1);

        // update max area, if needed
        if (max_area < area_with_top)
          max_area = area_with_top;
      }
    }

    // Now pop the remaining bars from stack and calculate area with every
    // popped bar as the smallest bar
    while (!stack.empty()) {
      tp = stack.pop();
      area_with_top = hist[tp] * (stack.empty() ? i : i - stack.peek() - 1);

      if (max_area < area_with_top)
        max_area = area_with_top;
    }

    return max_area;
  }

  public static int findByDp(int heights[]) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    int max = 0;
    int l = heights.length;
    int[][] hh = new int[l][l];
    for (int j = 1; j <= l; j ++) {
      for (int i = 0; i < l; i ++) {
        if (i + j - 1 == l) {
          break;
        }
        if (j == 1) {
          hh[i][i] = heights[i];
        } else {
          hh[i][i + j - 1] = Math.min(hh[i][i + j - 2], heights[i + j -1]);
        }
        if (hh[i][i + j - 1] * j > max) {
          max = hh[i][i + j - 1] * j;
        }
      }
    }

    return max;
  }
}
