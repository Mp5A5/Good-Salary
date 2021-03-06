package algorithm.sort;

/** 作者：王文彬 on 2019/10/7 12：10 邮箱：wwb199055@126.com */
public class MergeSortTest {

  public int[] mergeSort(int[] srcArray) {
    return divide(srcArray, 0, srcArray.length - 1);
  }

  private int[] divide(int[] srcArray, int left, int right) {
    if (left >= right) return srcArray;
    int mid = left + ((right - left) >> 1);
    divide(srcArray, left, mid);
    divide(srcArray, mid + 1, right);
    return merge(srcArray, left, mid, right);
  }

  private int[] merge(int[] srcArray, int left, int mid, int right) {
    int[] temp = new int[right - left + 1];
    for (int i = left; i <= right; i++) {
      temp[i - left] = srcArray[i];
    }
    int i = left;
    int j = mid + 1;
    for (int k = left; k <= right; k++) {
      if (i > mid) {
        srcArray[k] = temp[j - left];
        j++;
      } else if (j > right) {
        srcArray[k] = temp[i - left];
        i++;
      } else if (temp[i - left] < temp[j - left]) {
        srcArray[k] = temp[i - left];
        i++;
      } else {
        srcArray[k] = temp[j - left];
        j++;
      }
    }
    return srcArray;
  }
}
