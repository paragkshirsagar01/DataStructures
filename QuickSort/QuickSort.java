import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.Map;

public class QuickSort{
    public static int sort(int[] arr,int low,int high){
        int pivot = arr[high];
        int ind = low-1;
        for(int i = low;i<high;i++){
            if(arr[i]<pivot){
                ind++;
                int temp = arr[ind];
                arr[ind] = arr[i];
                arr[i] = temp;
            }
        }
        ind++;
        arr[high] = arr[ind];
        arr[ind] = pivot;
        return ind; 
    }
    public static void quickSort(int[] arr,int low,int high){
        System.out.println(Thread.currentThread().getName());
        if(low>=high){
            return;
        }
        int pivotInd = sort(arr,low,high);
        Thread left = new Thread(()->quickSort(arr,low,pivotInd-1));
        Thread right = new Thread(()->quickSort(arr,pivotInd+1,high));
        left.start();
        right.start();
        try{
            left.join();
            right.join();
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String[] args){
        int[] input= {1,2,5,4,3,6};
        quickSort(input, 0, input.length-1);
        for(int i: input){
            System.out.println(i);
        }
        int[][] edges = {{1,2},{2,3},{3,4}};
        var result = Arrays.stream(edges).collect(Collectors.toMap(
            a -> a[0],
            a -> Arrays.stream(a, 1, a.length).boxed().collect(Collectors.toList())
        ));
        System.out.println(result);
    }
}