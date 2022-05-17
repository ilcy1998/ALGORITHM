public class BinarySearchNearLeft_2021_05_13 {
    public static int nearstIndex(int[] arr,int value){
        int L = 0;
        int R = arr.length - 1;
        int index = -1;
        while(L <= R)
        {
            int mid = L+((R - L) >>1);
            if(arr[mid] >= value)
            {
                index = mid;
                R = mid -1;
            }
            else
            {
                L = mid +1;
            }
        }
        return index;
    }
}
