public class RandToRand_2021_03_26 {
    public static int f(){
        return (int)(Math.random() * 5) + 1;

    }

    public static int a(){
        return f() -1;
    }

    public static int b(){
        return a()* 5 + a();
    }

    public static int g(){
        int t = 0;
        do{
            t = b();
        }while (t>20);
        return (t%7)+1;
    }

    //利用f()等概率生成0和1
    public static int c(){
        int t =0;
        do {
            t =f();
        }while(t == 3);
        return t<3 ? 0 : 1;
    }
    public static class RandomBox{
        private final int min;
        private final int max;
        public RandomBox(int min1,int max1){
            min = min1;
            max = max1;
        }

        public int random(){
            return min + (int)(Math.random() * (max - min + 1));
        }

        public int min(){
            return min;
        }
        public int max(){
            return max;
        }
    }

    // 利用条件RandomBox，如何等概率返回0和1
    public static int rand01(RandomBox randomBox) {
        int min = randomBox.min();
        int max = randomBox.max();
        // min ~ max
        int size = max - min + 1;
        // size是不是奇数，odd 奇数
        boolean odd = (size & 1) != 0;
        int mid = size / 2;
        int ans = 0;
        do {
            ans = randomBox.random() - min;
        } while (odd && ans == mid);
        return ans < mid ? 0 : 1;
    }

    public static int random(RandomBox randomBox,int f,int t){
        if(f == t){
            return f;
        }
        int range = t - f;
        int num = 1;
        //计算表示出range需要几个二进制位
        while((1<<num) - 1 <range){
            num++;
        }
        int ans = 0;
        do {
            ans = 0;
            for(int i = 0;i<num;i++) {
                ans |= (rand01(randomBox) << i);
            }
        }while(ans>range);
        return ans + f;
    }

    public static void main(String[] args) {
        int f = 3;
        int t = 9;
        RandomBox randomBox = new RandomBox(f,t);
        int[] ans = new int[t+1];
        int time = 1000000;
        for(int i = 0;i<time; i++){
            ans[random(randomBox,f,t)]++;
        }
        for(int i = 0 ; i < ans.length;i++) {
            System.out.println(i + "出现了" + ans[i]);
        }
    }
}
