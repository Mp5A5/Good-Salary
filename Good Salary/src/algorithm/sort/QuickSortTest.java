package algorithm.sort;

/** 作者：王文彬 on 2019/9/27 07：17 邮箱：wwb199055@126.com */
public class QuickSortTest {

  public int[] sort(int[] srcArray) {
    return quickSort(srcArray, 0, srcArray.length - 1);
  }

  private int[] quickSort(int[] srcArray, int left, int right) {
    if (left > right) return srcArray;
    int pivot = srcArray[left];
    int i = left;
    int j = right;
    while (i < j) {
      while (i < j && srcArray[j] >= pivot) j--;
      srcArray[i] = srcArray[j];
      while (i < j && srcArray[i] <= pivot) i++;
      srcArray[j] = srcArray[i];
    }
    pivot = srcArray[i];
    quickSort(srcArray, left, i - 1);
    quickSort(srcArray, i + 1, right);
    return srcArray;
  }
}
