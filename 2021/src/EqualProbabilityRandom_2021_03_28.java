public class EqualProbabilityRandom_2021_03_28 {
    public static class RandomBox{
        private final double p;
        public RandomBox(double zeroP){
            p = zeroP;
        }
        public int random(){
            return Math.random() < p?0:1;
        }
    }

    public static int rand01(RandomBox randomBox){
        int num;
        do {
            num = randomBox.random();
        }while (num == randomBox.random());
        return num;
    }

    public static void main(String[] args) {
        double zeroP = 0.88;
        RandomBox randomBox = new RandomBox(zeroP);
        int time = 1000000;
        int count  = 0;
        for(int i = 0;i<time;i++){
            if(rand01(randomBox)==0){
                count++;
            }
        }
        System.out.println((double)count / (double) time);
    }
}
