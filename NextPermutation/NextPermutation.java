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

  private void stringreverse(char[] strings, int start) {
    int i = start;
    int l = strings.length - 1;
    while (i < l) {
      stringswap(strings, i, l);
      i++;
      l--;
    }
  }

  private void swap(int[] nums, int i, int l) {
    int temp = nums[i];
    nums[i] = nums[l];
    nums[l] = temp;
  }

  private void stringswap(char[] strings, int i, int l) {
    char temp = strings[i];
    strings[i] = strings[l];
    strings[l] = temp;
  }

  public String nextpermutation(char[] strings){
    int i = strings.length - 2;
    // 後ろから見ていって昇順が終わるギリギリまで探す
    while (i >= 0 && strings[i] >= strings[i + 1]) {
      i--;
    }
    //昇順が終わる部分の前のインデックスを探す
    if (i >= 0) {
      int l = strings.length - 1;
      while (l >= 0 && strings[l] <= strings[i]) {
        l--;
      }
      // 昇順が終わる部分の境目になっている部分をswap
      stringswap(strings, i, l);
      //辞書順で最も大きい順列の場合は"Final"を返す
      //元に戻したい場合はこのelseの部分を消す
    } else {
      return "Final";
    }
    stringreverse(strings, i + 1);
    //toString()はうまく渡せないのでString.valueOf(char)でcharからStringへ変換する
    String ans = String.valueOf(strings);
    return ans;
  }

  public static void main(String[] args) {
      //試しにabcdを入れてみて次の順列が返ってくるか試すmain()
      String str = "abcd";
      char[] strings = new char[str.length()];
      for (int i = 0; i < strings.length; i++) {
        strings[i] = str.charAt(i);
      }
      NextPermutation nPermutation = new NextPermutation();
      String ans = nPermutation.nextpermutation(strings);
      System.out.println(ans);
  }
}