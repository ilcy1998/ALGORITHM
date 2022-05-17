public class MakeNo_2021_05_11 {
    public static int[] makeNo(int size){
        if(size == 1) {
            return new int[] {1};
        }
        //向上取整
        int halfSize = (size+1) / 2;
        int[] base = makeNo(halfSize);
        int[] ans = new int[size];
        int index = 0;
        for(;index < halfSize; index++)
        {
            ans[index] = base[index] * 2 +1;
        }
        for(int i = 0; index<size; index++)
        {
            ans[index] = base[i] * 2;
        }
        return ans;
    }

    public static boolean isValid(int[] arr)
    {
        int N = arr.length;
        for(int i = 0; i<N; i++)
        {
            for(int k = i+1; k<N;k++)
            {
                for(int j = k+1; j<N; j++)
                {
                    if(arr[i] +arr[j] == 2 * arr[k])
                    {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.println("begin");
        for(int N = 1;N< 1000;N++)
        {
            int arr[] = makeNo(N);
            if(!isValid(arr)){
                System.out.println("Oops ");
            }
            System.out.println("end");
            System.out.println(isValid(makeNo(1024)));
            System.out.println(isValid(makeNo(2981)));
        }
    }
}
