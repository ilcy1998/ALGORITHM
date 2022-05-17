public class JumpGameII {
    public static int jump(int[] arr){
        if(arr == null || arr.length == 0)
        {
            return 0;
        }
        int jump = 0;
        int border = 0;
        int next = 0;
        for(int i = 0; i < arr.length; i++)
        {
            if(border < i)
            {
                jump++;
                border = next;
            }
            next = Math.max(next,i + arr[i]);
        }
        return jump;
    }
}
