public class RotateString_2021_03_25 {
    public static String rotate1(String s,int leftSize){
        if (leftSize <=0 || leftSize>=s.length()){
            return s;
        }
        return process1(s.toCharArray(),0,leftSize-1,s.length()-1);
    }
    //逆序
    public static String process1(char[] str,int L,int M,int R){
        reverse(str,L,M);
        reverse(str,M+1,R);
        reverse(str,L,R);
        return String.valueOf(str);
    }

    //向右平移
    public static void reverse(char[]str , int L,int R){
        while(L<R){
            char temp = str[L];
            str[L++] = str[R];
            str[R--] = temp;
        }
    }

    /**
     * 高效做法
     * L、R表示指针
     * @param s
     * @param leftSize
     * @return
     */
    public static String rotate2(String s,int leftSize){
        if (leftSize <= 0 || leftSize>s.length()){
            return s;
        }
        char[] str= s.toCharArray();
        int L = 0;
        int R = str.length -1;
        int lpart = leftSize;
        int rpart = str.length - leftSize;
        int same = Math.min(lpart,rpart);//比较谁更长
        int diff = lpart - rpart;
        exchange(str,L,R,same);
        while (diff!= 0){
            if(diff >0){
                L += same;
                lpart = diff;
            }else{
                R -=same;
                rpart = -diff;
            }
            same = Math.min(lpart,rpart);
            diff = lpart - rpart;
            exchange(str,L,R,same);
        }
        return String.valueOf(str);
}
    public static void exchange(char[] str,int L,int R,int size){
        int i = R - size +1;
        char temp = 0;
        while(size-- !=0){
            temp = str[L];
            str[L] = str[i];
            str[i] = temp;
            L++;
            i++;
        }
    }


}

