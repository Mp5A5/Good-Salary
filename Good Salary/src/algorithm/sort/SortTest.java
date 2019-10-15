package algorithm.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

/** 作者：王文彬 on 2019/10/14 22：16 邮箱：wwb199055@126.com */
public class SortTest {

  public int[] bubbleSort(int[] srcArray) {
    int lastChangeIndex = 0;
    int sortBorder = srcArray.length - 1;
    for (int i = 0; i < srcArray.length; i++) {
      boolean isSorted = true;
      for (int j = 0; j < sortBorder; j++) {
        if (srcArray[j] > srcArray[j + 1]) {
          int temp = srcArray[j];
          srcArray[j] = srcArray[j + 1];
          srcArray[j + 1] = temp;
          isSorted = false;
          lastChangeIndex = j;
        }
        sortBorder = lastChangeIndex;
        if (isSorted) break;
      }
    }
    return srcArray;
  }

  public int[] quickSort(int[] srcArray) {
    return quickSort(srcArray, 0, srcArray.length - 1);
  }

  private int[] quickSort(int[] srcArray, int left, int right) {
    if (left > right) return srcArray;
    int i = left;
    int j = right;
    int pivot = srcArray[left];
    while (i < j) {
      while (i < j && srcArray[j] > pivot) j--;
      srcArray[i] = srcArray[j];
      while (i < j && srcArray[i] < pivot) i++;
      srcArray[j] = srcArray[i];
    }
    srcArray[i] = pivot;
    quickSort(srcArray, left, i - 1);
    quickSort(srcArray, i + 1, right);
    return srcArray;
  }

  public int[] headSort(int[] srcArray) {
    int length = srcArray.length;
    buildMaxHeap(srcArray, length);
    for (int i = length - 1; i > 0; i--) {
      swap(srcArray, 0, i);
      length--;
      heapify(srcArray, 0, length);
    }
    return srcArray;
  }

  private void buildMaxHeap(int[] srcArray, int length) {
    for (int i = (int) Math.floor(length / 2); i >= 0; i--) {
      heapify(srcArray, i, length);
    }
  }

  private void heapify(int[] srcArray, int i, int length) {
    int left = 2 * i + 1;
    int right = 2 * i + 2;
    int largest = i;
    if (left < length && srcArray[left] > srcArray[largest]) {
      largest = left;
    }
    if (right < length && srcArray[right] > srcArray[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap(srcArray, i, largest);
      heapify(srcArray, largest, length);
    }
  }

  private void swap(int[] srcArray, int i, int j) {
    int temp = srcArray[i];
    srcArray[i] = srcArray[j];
    srcArray[j] = temp;
  }

  public int[] heapSorted(int[] srcArray) {
    int len = srcArray.length;
    buildMaxHeap0(srcArray, len);
    for (int i = len - 1; i > 0; i--) {
      swap0(srcArray, 0, i);
      len--;
      heapify0(srcArray, 0, i);
    }
    return srcArray;
  }

  private void buildMaxHeap0(int[] srcArray, int len) {
    for (int i = (int) Math.floor(len / 2); i >= 0; i--) {
      heapify0(srcArray, i, len);
    }
  }

  private void heapify0(int[] srcArray, int i, int len) {
    int left = i * 2 + 1;
    int right = i * 2 + 2;
    int largest = i;
    if (left < len && srcArray[left] > srcArray[largest]) {
      largest = left;
    }
    if (left < len && srcArray[right] > srcArray[largest]) {
      largest = right;
    }
    if (largest != i) {
      swap0(srcArray, i, largest);
      heapify0(srcArray, largest, len);
    }
  }

  private void swap0(int[] srcArray, int i, int j) {
    int temp = srcArray[i];
    srcArray[i] = srcArray[j];
    srcArray[j] = temp;
  }

  public int[] bucketSort(int[] srcArray) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int value : srcArray) {
      max = Math.max(max, value);
      min = Math.min(min, value);
    }
    // 桶数
    int bucketNums = (max - min) / srcArray.length + 1;
    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
    for (int i = 0; i < bucketNums; i++) {
      bucketList.add(new ArrayList<>());
    }
    // 将每个元素放入桶
    for (int i = 0; i < srcArray.length; i++) {
      int num = (srcArray[i] - min) / srcArray.length;
      bucketList.get(num).add(srcArray[i]);
    }
    // 对每个桶进行排序
    for (int i = 0; i < bucketList.size(); i++) {
      Collections.sort(bucketList.get(i));
    }
    // 将桶中元素全部取出来并放入 arr 中输出
    int index = 0;
    for (ArrayList<Integer> bucket : bucketList) {
      for (Integer data : bucket) {
        srcArray[index++] = data;
      }
    }
    return srcArray;
  }

  public int[] bucketSort0(int[] srcArray) {
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int value : srcArray) {
      max = Math.max(max, value);
      min = Math.min(min, value);
    }

    int bucketNum = (max - min) / srcArray.length + 1;

    ArrayList<ArrayList<Integer>> bucketList = new ArrayList<>();
    for (int i = 0; i < bucketNum; i++) {
      bucketList.add(new ArrayList<>());
    }
    for (int value : srcArray) {
      int num = (value - min) / srcArray.length;
      bucketList.get(num).add(value);
    }
    for (ArrayList<Integer> integers : bucketList) {
      Collections.sort(integers);
    }
    int index = 0;
    for (ArrayList<Integer> integers : bucketList) {
      for (int data : integers) {
        srcArray[index++] = data;
      }
    }
    return srcArray;
  }
}
