package algorithm.sort;

/** 作者：王文彬 on 2019/10/7 12：03 邮箱：wwb199055@126.com */
public class ShellSortTest {

  public int[] shellSort(int[] srcArray) {
    int gap = srcArray.length >> 1;
    while (1 <= gap) {
      for (int i = gap; i < srcArray.length; i++) {
        int j = 0;
        int temp = srcArray[i];
        for (j = i - gap; j >= 0 && temp < srcArray[j]; j = j - gap) {
          srcArray[j + gap] = srcArray[j];
        }
        srcArray[j + gap] = temp;
      }
      gap = gap >> 1;
    }
    return srcArray;
  }
}
