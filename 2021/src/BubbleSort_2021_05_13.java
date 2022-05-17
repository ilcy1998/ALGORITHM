public class BubbleSort_2021_05_13 {
    public static void bubbleSort(int arr[]){
        if(arr == null || arr.length < 2)
        {
            return ;
        }
        for(int i = arr.length - 1 ; i> 0 ; i--)
        {
            for(int j = 0; j< i ;j++)
            {
                if(arr[j] > arr[j+1])
                {
                    swap(arr,j,j+1);
                }
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}
