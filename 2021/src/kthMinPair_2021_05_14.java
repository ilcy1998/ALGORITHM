import java.util.Arrays;
import java.util.Comparator;

public class kthMinPair_2021_05_14 {
    public static class Pair{
        public int x;
        public int y;


        Pair(int x,int y){
            this.x = x;
            this.y = y;
        }
    }

    public static class PairComparator implements Comparator<Pair>{

        @Override
        public int compare(Pair arg0, Pair arg1){
            return arg0.x != arg1.x ? arg0.x - arg1.x : arg0.y - arg1.y;
        }
    }

    //复杂度O(N^2 * log(N^2)
    public static int[] kthMinPair1(int[] arr,int k){
        int N = arr.length;
        if(k > N  * N)
        {
            return null;
        }
        Pair[] pairs = new Pair[N * N];
        int index = 0;
        for(int i = 0; i < N; i++)
        {
            for(int j = 0;j < N; j++)
            {
                pairs[index++] = new Pair(arr[i],arr[j]);
            }
        }
        Arrays.sort(pairs,new PairComparator());
        return new int[] {pairs[k - 1].x,pairs[k-1].y};
    }

    //复杂度O(logN)
    public static int [] kthMinPair2(int [] arr,int k){
        int N = arr.length;
        if(k > N * N)
        {
            return null;
        }
        Arrays.sort(arr);
        int firstNum = arr[(k-1) / N];
        int lessFirstNumSize = 0;
        int firstNumSize = 0;
        for(int i = 0; i < N && arr[i] <= firstNum; i++)
        {
            if(arr[i] < firstNum)
            {
                lessFirstNumSize++;  //数出小于第一维数字的数的个数
            }else
            {
                firstNumSize++;//数出第一维数字的个数
            }
        }
        int rest = k - (lessFirstNumSize * N);
        return new int[] {firstNum,arr[(rest - 1) / firstNumSize]};
    }

    //复杂度O(N)
    public static int[] kthMinPair3(int[] arr, int k){
        int N = arr.length;
        if(k > N * N)
        {
            return null;
        }
        int firstNum = getMinKthByBFPRT(arr,((k-1) / N) + 1);
        int lessFirstNumSIze = 0;
        int firstNumSize = 0;
        for(int i = 0; i < N; i++)
        {
            if(arr[i] < firstNum)
            {
                lessFirstNumSIze++;
            }else
            {
                firstNumSize++;
            }
        }
        int rest = k - (lessFirstNumSIze * N);
        return new int[] {firstNum,getMinKthByBFPRT(arr,((rest - 1) / firstNumSize))};
    }

    private static int getMinKthByBFPRT(int[] arr, int k) {
        return select(arr,0,arr.length -1 , k-1);
    }

    private static int select(int[] arr, int begin, int end, int i) {
        if(begin == end)
        {
            return arr[begin];
        }
        int pivot = medianOfMedians(arr,begin,end);
        int[] pivotRange = partition(arr,begin,end,pivot);
        if(i >= pivotRange[0] && i<= pivotRange[1]){
            return arr[i];
        }else if(i < pivotRange[0])
        {
            return select(arr,begin,pivotRange[0] - 1,i);
        }else
        {
            return select(arr,pivotRange[1] + 1,end,i);
        }
    }

    public static int medianOfMedians(int[] arr, int begin, int end) {
        int num = end - begin + 1;
        int offset = num % 5 == 0 ? 0 : 1;
        int[] mArr = new int[num / 5 + offset];
        for (int i = 0; i < mArr.length; i++) {
            int beginI = begin + i * 5;
            int endI = beginI + 4;
            mArr[i] = getMedian(arr, beginI, Math.min(end, endI));
        }
        return select(mArr, 0, mArr.length - 1, mArr.length / 2);
    }

    public static int[] partition(int[] arr, int begin, int end, int pivotValue) {
        int small = begin - 1;
        int cur = begin;
        int big = end + 1;
        while (cur != big) {
            if (arr[cur] < pivotValue) {
                swap(arr, ++small, cur++);
            } else if (arr[cur] > pivotValue) {
                swap(arr, cur, --big);
            } else {
                cur++;
            }
        }
        int[] range = new int[2];
        range[0] = small + 1;
        range[1] = big - 1;
        return range;
    }

    public static int getMedian(int[] arr, int begin, int end) {
        insertionSort(arr, begin, end);
        int sum = end + begin;
        int mid = (sum / 2) + (sum % 2);
        return arr[mid];
    }

    public static void insertionSort(int[] arr, int begin, int end) {
        for (int i = begin + 1; i != end + 1; i++) {
            for (int j = i; j != begin; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                } else {
                    break;
                }
            }
        }
    }
    public static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    // 为了测试，生成值也随机，长度也随机的随机数组
    public static int[] getRandomArray(int max, int len) {
        int[] arr = new int[(int) (Math.random() * len) + 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * max) - (int) (Math.random() * max);
        }
        return arr;
    }

    // 为了测试
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // 随机测试了百万组，保证三种方法都是对的
    public static void main(String[] args) {
        int max = 100;
        int len = 30;
        int testTimes = 100000;
        System.out.println("test bagin, time times : " + testTimes);
        for (int i = 0; i < testTimes; i++) {
            int[] arr = getRandomArray(max, len);
            int[] arr1 = copyArray(arr);
            int[] arr2 = copyArray(arr);
            int[] arr3 = copyArray(arr);
            int N = arr.length * arr.length;
            int k = (int) (Math.random() * N) + 1;
            int[] ans1 = kthMinPair1(arr1, k);
            int[] ans2 = kthMinPair2(arr2, k);
            int[] ans3 = kthMinPair3(arr3, k);
            if (ans1[0] != ans2[0] || ans2[0] != ans3[0] || ans1[1] != ans2[1] || ans2[1] != ans3[1]) {
                System.out.println("Oops!");
            }
        }
        System.out.println("test finish");
    }
}
