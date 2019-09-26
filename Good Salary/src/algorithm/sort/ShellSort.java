package algorithm.sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/** 作者：王文彬 on 2019/9/3 11：09 邮箱：wwb199055@126.com */
public class ShellSort {
  public int[] sort(int[] srcArray) {
    int gap = srcArray.length / 2;
    while (1 <= gap) {
      for (int i = gap; i < srcArray.length; i++) {
        int j = 0;
        int temp = srcArray[i];
        for (j = i - gap; j >= 0 && temp < srcArray[j]; j = j - gap) {
          srcArray[j + gap] = srcArray[j];
        }
        srcArray[j + gap] = temp;
      }
      gap /= 2;
    }

    return srcArray;
  }

  public int[] sort0(int[] srcArray) {
    int gap = 1;
    while (gap < srcArray.length) {
      gap = gap * 3 + 1;
    }

    while (gap > 0) {
      for (int i = 0; i < srcArray.length; i++) {
        int temp = srcArray[i];
        int j = i - gap;
        while (j >= 0 && temp < srcArray[j]) {
          srcArray[j + gap] = srcArray[j];
          j--;
        }
        srcArray[j + gap] = temp;
      }
      gap = (int) Math.floor((double) (gap / 3));
    }

    return srcArray;
  }

  @Test
  public void test() {
    int[] a = {1, 10, 8, 7, 4, 3};
    System.out.println(Arrays.toString(sort(a)));
  }
}
