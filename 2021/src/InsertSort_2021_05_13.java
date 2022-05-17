public class InsertSort_2021_05_13 {
    public static void insertionSort(int [] arr){
        if(arr == null || arr.length < 2)
        {
            return;
        }
        for(int i = 1;i < arr.length;i++)
        {
            for(int j = i-1; j>=0 && arr[j]> arr[j+1];j--)
            {
                swap(arr,j,j+1);
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
/*
*插入排序的思想是首先选择前两个元素比较，小的放前大的放后，构成一个局部有序
* 然后每次向后纳入一名元素，与前两位进行比较，使之成为一个更大的局部有序
* 重复此操作直到全局有序
 */