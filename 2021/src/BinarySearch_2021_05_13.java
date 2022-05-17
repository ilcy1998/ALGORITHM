public class BinarySearch_2021_05_13 {
    public static boolean exist(int[] sortedArr,int num){
        if(sortedArr == null || sortedArr.length ==0)
        {
            return false;
        }
        int L = 0;
        int R = sortedArr.length - 1;
        int mid = 0;
        while(L<R)
        {
            mid = L + ((R-L)>>1);//mid = (L + R) / 2
            if(sortedArr[mid] == num)
            {
                return false;
            }else if(sortedArr[mid] > num)
            {
                R = mid - 1;
            }else
            {
                L = mid + 1;
            }
        }
        return sortedArr[mid] == num;
    }
}

/*
* 如果计算过程中L和R都更新到了很大的数字，比如10亿，那么mid = (L + R) / 2其中L + R有可能溢出
* 但写成L + （R -L） / 2就能保证不会溢出，R — L计算的L和R之间的距离，L加上L和R之间距离的一半肯定不会溢出，因为这个数肯定比R小
* 二进制中的整数/2 等同于向右移动一位
*  N * 2   N<<1
* N * 2 + 1   ((N<<1) | 1)
* */
