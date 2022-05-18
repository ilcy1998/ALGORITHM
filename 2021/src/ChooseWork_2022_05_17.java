public class ChooseWork_2022_05_17 {
    public static int maxmoney(int[][] income,int index,int rest)
    {
        if(income == null || income.length < 2 || (income.length & 1) != 0)
        {
            return 0;
        }
        int N = income.length;
        int M = N >> 1;
        return process(income,0,M);
    }
    //第一维指代司机index，第二维指代A或B

    public static int process(int[][] income,int index,int rest )
    {
        if(index == income.length)
        {
            return 0;
        }

        if(income.length -index == rest)
        {
            return income[index][0] + process(income,index+1,rest-1);
        }
        if(rest == 0)
        {
            return income[index][1] + process(income,index+1,rest-1);
        }

        int p1 = income[index][0] + process(income,index+1,rest-1);
        int p2 = income[index][1] + process(income,index+1,rest-1);
        return Math.max(p1,p2);
    }
}
