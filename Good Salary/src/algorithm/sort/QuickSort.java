package algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/** 作者：王文彬 on 2019/9/3 10：38 邮箱：wwb199055@126.com */
public class QuickSort {

  public int[] sort(int[] srcArray) {
    return quickSort(srcArray, 0, srcArray.length - 1);
  }

  private int[] quickSort(int[] srcArray, int left, int right) {
    if (left > right) return srcArray;
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
    quickSort(srcArray, left, i - 1);
    quickSort(srcArray, i + 1, right);
    return srcArray;
  }

    @Test
    public void test() {
        int[] a = {1, 10, 8, 7, 4, 3};
        System.out.println(Arrays.toString(sort(a)));
    }
}
