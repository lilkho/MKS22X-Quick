import java.io.*;
import java.util.*;

public class Quick {

  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int []data, int k){
    return 0;
  }
  /*Modify the array such that:
  *1. Only the indices from start to end inclusive are considered in range
  *2. A random index from start to end inclusive is chosen, the corresponding
  *   element is designated the pivot element.
  *3. all elements in range that are smaller than the pivot element are placed before the pivot element.
  *4. all elements in range that are larger than the pivot element are placed after the pivot element.
  *@return the index of the final position of the pivot element.
  */
  public static int partition ( int [] data, int start, int end){
    int pivot=(int)(Math.random()*end);
    int pivotValue=data[pivot];
    data[pivot]=data[start];
    data[start]=pivotValue;
    start++;
    while (start<end) {
      if (data[start]>pivotValue) {
        int startValue = data[start];
        data[start]=data[end];
        data[end]=startValue;
        end--;
      } else {
        start++;
      }
    }
    pivot=start;
    while (data[pivot]>pivotValue) {
      pivot--;
    }
    data[0]=data[pivot];
    data[pivot]=pivotValue;
    return pivot;
  }

  public static void main(String[] args) {
  }
}
