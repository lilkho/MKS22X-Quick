import java.io.*;
import java.util.*;

public class Quick {

  /*return the value that is the kth smallest value of the array.
  */
  public static int quickselect(int []data, int k){
    int pivot = partition(data,0,data.length-1);
    while (pivot!=k-1) {
      if (k-1>pivot) {
        pivot=partition(data,pivot,data.length-1);
      } else {
        pivot=partition(data,0,pivot);
      }
    }
    return data[pivot];
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
    //choose random index
    int pivot=(int)(Math.random()*(end-start)+start);
    //swap index w beginning
    int pivotValue=data[pivot];
    data[pivot]=data[start];
    data[start]=pivotValue;
    int pivotPos=start; //keep track of where pivot is
    start++;
    while (start<end) {
      //if its equal make it 50/50 it goes to left or right
      if (data[start]==pivotValue) {
        if ((int)(Math.random())==0) {
          int startValue = data[start];
          data[start]=data[end];
          data[end]=startValue;
          end--;
        } else {
          start++;
        }
      }
      //if its greater then swap
      else if (data[start]>pivotValue) {
        int startValue = data[start];
        data[start]=data[end];
        data[end]=startValue;
        end--;
      //otherwise keep on going
      } else {
        start++;
      }
    }
    //check till its smaller
    pivot=start;
    while (data[pivot]>pivotValue) {
      pivot--;
    }
    //now swap
    data[pivotPos]=data[pivot];
    data[pivot]=pivotValue;
    System.out.println(Arrays.toString(data));
    return pivot;
  }
  /*Modify the array to be in increasing order.
  */
  public static void quicksort(int[] data) {
    quicksort(data,0,data.length-1);

  }
  private static void quicksort(int[] data, int lo, int hi) {
    if (lo>=hi) return;
    int pivot = partition(data,lo,hi);
    quicksort(data,lo,pivot-1);
    quicksort(data,pivot+1,hi);
  }


  public static void main(String[] args) {
    System.out.println("testingg quickselect");
    //
    int[] data = {8,7,6,5,3,0,9};
    System.out.println(quickselect(data,2));
    int[] data2 = {17,61,67,47,93,12,20,4,44,68};
    System.out.println(quickselect(data2,4));
    int[] data3 = {8,7,6,5,3,3,0,9};
    System.out.println(quickselect(data3,2));
    int[] data4 = {10,10,10,19,17,23,77,66,6,6,55,5,5};
    System.out.println(quickselect(data4,10));
    //
    System.out.println("testingg quicksort");
    //
    int[] dat = {17,61,67,47,93,12,20,4,44,68};
    quicksort(dat);
    System.out.println(Arrays.toString(dat));
  }
}
