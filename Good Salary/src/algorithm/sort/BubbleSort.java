package algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/** 作者：王文彬 on 2019/9/3 10：24 邮箱：wwb199055@126.com */
public class BubbleSort {

  public int[] sort(int[] srcArray) {
    for (int i = 0; i < srcArray.length; i++) {
      for (int j = 0; j < srcArray.length - 1 - i; j++) {
        if (srcArray[j] > srcArray[j + 1]) {
          int temp = srcArray[j];
          srcArray[j] = srcArray[j + 1];
          srcArray[j + 1] = temp;
        }
      }
    }
    return srcArray;
  }

  public int[] sort1(int[] srcArray) {
    for (int i = 0; i < srcArray.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < srcArray.length - 1 - i; j++) {
        if (srcArray[j] > srcArray[j + 1]) {
          int temp = srcArray[j];
          srcArray[j] = srcArray[j + 1];
          srcArray[j + 1] = temp;
          isSorted = false;
        }
      }
      if (isSorted) {
        break;
      }
    }
    return srcArray;
  }

  public int[] sort2(int[] srcArray) {
    int lastExchangeIndex = 0;
    int sortBorder = srcArray.length - 1;
    for (int i = 0; i < srcArray.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < sortBorder; j++) {
        if (srcArray[j] > srcArray[j + 1]) {
          int temp = srcArray[j];
          srcArray[j] = srcArray[j + 1];
          srcArray[j + 1] = temp;
          isSorted = false;
          lastExchangeIndex = j;
        }
      }
      sortBorder = lastExchangeIndex;
      if (isSorted) break;
    }
    return srcArray;
  }

  @Test
  public void test() throws Exception {
    int[] array = new int[] {5, 8, 6, 3, 9, 2, 1, 7};
    System.out.println(Arrays.toString(sort2(array)));
  }
}
