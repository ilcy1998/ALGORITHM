public class FindHalfMajority_2021_03_28 {
    public static int halfMajor(int[] arr){
        int  candidate = 0;
        int flag = 0;//表示没有候选

        for(int i=0; i != arr.length;i++){
            if(flag == 0){
                candidate = arr[i];
                flag = 1;
            }else if(arr[i] == candidate){
                flag++;
            }else{
                flag--;
            }
        }
        if(flag == 0){
            return -1;
        }
        flag = 0;
        for(int i = 0;i!= arr.length;i++){
            if(arr[i] == candidate){
                flag++;
            }
        }
        return flag > arr.length /2 ? candidate :-1;
    }
}
