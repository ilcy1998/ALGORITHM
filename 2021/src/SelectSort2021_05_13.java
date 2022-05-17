import java.util.Arrays;

public class SelectSort2021_05_13 {
    public static void selectionSort(int arr[]){
        if(arr == null || arr.length < 2)
        {
            return ;
        }
        for(int i = 0;i<arr.length-1 ; i++)
        {
            int minIndex = i;
            for(int j = i+1; j<arr.length ;j++)
            {
                minIndex = arr[j] < arr[minIndex] ? j:minIndex;
            }
            swap(arr,i,minIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void comparator(int[] arr){
        Arrays.sort(arr);
    }

    public static int[] generateRandomArray(int max_size,int max_value){
        int[] arr = new int[(int)((max_size + 1) *Math.random())];
        for(int i = 0;i < arr.length; i++)
        {
            arr[i] = (int )((max_value + 1) * Math.random()) -(int ) (max_value * Math.random());
        }
        return arr;
    }

    public static int[] copyArray(int[] arr){
        if(arr == null)
        {
            return null;
        }
        int [] res = new int[arr.length];
        for(int i =0;i<arr.length;i++)
        {
            res[i] = arr[i];
        }
        return res;
    }

    public static boolean isEqual(int [] arr,int [] arr2){
        if(arr == null && arr2 != null || arr != null && arr2 ==null)
        {
            return false;
        }
        if(arr ==null &&arr2 ==null)
        {
            return true;
        }
        if(arr.length != arr2.length)
        {
            return false;
        }
        for(int i = 0;i< arr.length; i++)
        {
            if(arr[i] != arr2[i])
            {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr){
        if(arr == null)
        {
            return;
        }
        for(int i = 0;i < arr.length;i++)
        {
            System.out.println(
                    arr[i]+ " "
            );
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int test_time = 500000;
        int max_size = 100;
        int maxi_value = 100;
        boolean succeed = true;
        for(int i= 0; i<test_time ;i++)
        {
            int [] arr = generateRandomArray(max_size,maxi_value);
            int [] arr2 = copyArray(arr);
            selectionSort(arr);
            comparator(arr2);
            if(!isEqual(arr,arr2))
            {
                succeed = false;
                printArray(arr);
                printArray(arr2);
                break;
            }
        }
    }
}
/**
 * 选择排序的主要思想是假定第一个数是最小的，遍历整个序列，与每一个数进行比较，选出最小的数排在第一位
 * 然后假定第2位是第2小的数，遍历整个数组与之比较，找出次小的数放在第2位
 * 重复操作，每次找出次小的数放到前面，最终使整个数组有序
 */



