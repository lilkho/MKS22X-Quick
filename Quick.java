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
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Quick.quicksort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}
