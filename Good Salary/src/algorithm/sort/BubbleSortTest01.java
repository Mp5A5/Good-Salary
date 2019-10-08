package algorithm.sort;

/** 作者：王文彬 on 2019/10/7 11：45 邮箱：wwb199055@126.com */
public class BubbleSortTest01 {

  public int[] sort(int[] srcArray) {
    int lastChangeIndex = 0;
    int sortBorder = srcArray.length - 1;
    for (int i = 0; i < srcArray.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < sortBorder; j++) {
        if (srcArray[j] > srcArray[j + 1]) {
          int temp = srcArray[j];
          srcArray[j] = srcArray[j + 1];
          srcArray[j + 1] = temp;
          lastChangeIndex = j;
          isSorted = false;
        }
        sortBorder = lastChangeIndex;
        if (isSorted) break;
      }
    }
    return srcArray;
  }
}
