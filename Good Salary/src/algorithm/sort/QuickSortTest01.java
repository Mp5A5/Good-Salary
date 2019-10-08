package algorithm.sort;

/** 作者：王文彬 on 2019/10/7 11：53 邮箱：wwb199055@126.com */
public class QuickSortTest01 {

  public int[] quickSort(int[] srcArray) {
    return sort(srcArray, 0, srcArray.length - 1);
  }

  private int[] sort(int[] srcArray, int left, int right) {
    if (left < right) return srcArray;
    int i = left;
    int j = right;
    int pivot = srcArray[left];
    while (i < j) {
      while (i < j && srcArray[j] >= pivot) j--;
      srcArray[i] = srcArray[j];
      while (i < j && srcArray[i] <= pivot) i++;
      srcArray[j] = srcArray[i];
    }
    srcArray[i] = pivot;
    sort(srcArray, left, i - 1);
    sort(srcArray, i + 1, right);
    return srcArray;
  }
}
