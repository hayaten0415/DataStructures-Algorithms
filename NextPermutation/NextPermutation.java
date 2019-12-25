class NextPermutation {
  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;
    //後ろから見ていって昇順が終わるギリギリまで探す
    while (i >= 0 && nums[i] >= nums[i + 1]) {
      i--;
    }

    //昇順が終わる部分の前のインデックスを探す
    if (i >= 0) {
      int l = nums.length - 1;
      while (l >= 0 && nums[l] <= nums[i]) {
        l--;
      }
      //昇順が終わる部分の境目になっている部分をswap
      swap(nums, i, l);
    }

    reverse(nums, i + 1);
  }

  //既にソート済みの配列を逆順に並び替えるだけなので
  //O(n)で可能、厳密にはO(n/2)
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