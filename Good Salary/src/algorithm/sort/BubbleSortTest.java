package algorithm.sort;

/** 作者：王文彬 on 2019/9/27 07：10 邮箱：wwb199055@126.com */
public class BubbleSortTest {

  public int[] sort(int[] srcArray) {
    int lastChangeIndex = 0;
    int sortedBorder = srcArray.length - 1;
    for (int i = 0; i < srcArray.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < sortedBorder; j++) {
        if (srcArray[j] > srcArray[j + 1]) {
          int temp = srcArray[j];
          srcArray[j] = srcArray[j + 1];
          srcArray[j + 1] = temp;
          isSorted = false;
          lastChangeIndex = j;
        }
      }
      sortedBorder = lastChangeIndex;
      if (isSorted) break;
    }
    return srcArray;
  }
}
