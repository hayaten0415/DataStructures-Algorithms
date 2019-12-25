class NextPermutation {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }
    if (i >= 0) {
      int l = nums.length - 1;
      while (l >= 0 && nums[l] <= nums[i]) {
        l--;
      }
      swap(nums, i, l);
    }
    reverse(nums, i + 1);
  }

  private void reverse(int[] nums, int start) {
    int i = start;
    int l = nums.length - 1;
    while (i < l) {
      swap(nums, i, l);
      i++;
      l--;
    }

  }

  private void swap(int[] nums, int i, int l) {
    int temp = nums[i];
    nums[i] = nums[l];
    nums[l] = temp;
  }
}