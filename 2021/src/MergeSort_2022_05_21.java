public class MergeSort_2022_05_21 {
    public static void mergeSort(int[] arr){
        if (arr == null || arr.length < 2){
            return ;
        }
        process(arr,0,arr.length -1);
    }

    private static void process(int[] arr, int L, int R) {
        if(L== R){
            return;
        }
        int mid = L + ((R-L) >>1);
        process(arr,L,mid);
        process(arr,mid+1,R);
        merge(arr,L,mid,R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] help = new int[R-L+1];
        int i = 0;
        int p1 = L;
        int p2 = mid + 1;
        while(p1 <= mid && p2 <=R){
            help[i++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }
        while(p1<=mid)
        {
            help[i++] = arr[p1++];
        }

        while(p2<=R){
            help[i++] = arr[p2++];
        }
        for(i = 0;i < help.length;i++)
        {
            arr[L + i] = help[i];
        }

    }

    public static void mergeSort2(int[] arr){
        if(arr.length < 2 || arr == null)
        {
            return;
        }

        int N = arr.length;
        int mergeSize = 1;
        while(mergeSize < N){
            int L = 0;
            while(L < N){
                int M = L + mergeSize -1;
                if(M>=N){
                    break;//若步长已经超过整个数组长度，直接结束
                }
            int R = Math.min(M + mergeSize ,N-1);//可能出现左侧是满足步长 但右边剩下的不够步长，所以右边界需要求一个最小值
            merge(arr,L,M,R);
            L = R + 1;//下一个步长（不是下一轮步长）L直接来到下一个步长的位置进行排序
            //防止溢出  和左侧满足步长，右侧不足步长不矛盾 当步长非常接近int类型最大值，步长乘2之后必然超过了最大值变成了负数
            if(mergeSize > N/2){
                break;
            }
            mergeSize <<= 1;
            }
        }
    }



}
