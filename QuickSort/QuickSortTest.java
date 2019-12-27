import java.util.Arrays;

public class QuickSortTest {
  public static void main(String[] args) {
    int[] unsorted_array = { 4, 7, 9, 9, 1, 2 };
    
    QuickSort algo = new QuickSort();
    algo.sort(unsorted_array);
    System.out.println(Arrays.toString(unsorted_array));
  }
}

class QuickSort {
  private int input[];

  public void sort(int[] num) {
    if (num == null || num.length == 0) {
      return;
    }
    this.input = num;
    quickSort(0, num.length - 1);
  }
  public void quickSort(int low, int high) {
    int i = low;
    int j = high;
    //pivotは配列の真ん中とする
    int pivot = input[(low + high) / 2];

    //pivotを基準として2つに分ける
    while (i <= j) {
      while (input[i] < pivot) {
        i++;
      }
      while (input[j] > pivot) {
        j--;
      }
      if (i <= j) {
        swap(i, j);
        //両サイドのindexを次のポジションにずらす
        i++;
        j--;
      }
    }
    //ここでpivotを基準にした分割が終了
    //再帰でソートする
    //low < iにすると再帰が終わらない
    if (low < j) {
      quickSort(low, j);
    }
    //j < highも同様
    if(i < high) {
      quickSort(i, high);
    }
  }
  private void swap(int i, int j) {
    int temp = input[i];
    input[i] = input[j];
    input[j] = temp;
  }
}
