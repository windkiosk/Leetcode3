package leetcode;

public class P31_NextPermutation {

  public static void main(String[] args) {
    P31_NextPermutation nextPermutation = new P31_NextPermutation();
    int[] nums = new int[]{1, 1};
    nextPermutation.nextPermutation(nums);
    System.out.println(nums);
  }

  public void nextPermutation(int[] nums) {
    if (nums == null || nums.length < 2) return;
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i --;
    }

    int j = nums.length - 1;
    while (i > 0 && j > i) {
      if (nums[j] > nums[i]) {
        swap(nums, i, j);
        break;
      }
      j --;
    }
    reverse(nums, i + 1);
  }

  void swap(int[] nums, int i, int j) {
    int tmp = nums[i];
    nums[i] = nums[j];
    nums[j] = tmp;
  }

  void reverse(int[] nums, int s) {
    int i = s, j = nums.length - 1;
    while (i < j) {
      swap(nums, i, j);
      i ++;
      j --;
    }
  }
}
