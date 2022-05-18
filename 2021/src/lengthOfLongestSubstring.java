public class lengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String str){
        if(str==null || str.equals("")){
            return 0;
        }

        char[] chas = str.toCharArray();
        int[] map = new int[256];//ASCII最长255
        for(int i = 0; i<256;i++){
            map[i] = -1;//记录字符i上次出现位置
        }
        int len = 0;
        int pre = -1;//上一个位置向左推了多长
        int cur = 0;
        for(int i = 0;i != chas.length ;i++){
            pre = Math.max(pre,map[chas[i]]);
            cur = i - pre;
            len = Math.max(len,cur);
            map[chas[i]] = i;
        }
        return len;
    }


    public static int lengthOfLongestSubstring2(String str){
        if(str==null || str.equals("")){
            return 0;
        }

        char[] chas = str.toCharArray();
        int[] map = new int[256];//ASCII最长255
        for(int i = 0; i<256;i++){
            map[i] = -1;//记录字符i上次出现位置
        }
        int N = chas.length;
        int ans = 1;
        int pre = 1;
        map[chas[0]] = 0;
        for(int i = 1;i < N; i++)
        {
            int p1 = i - map[chas[i]];
            int p2  = pre + 1;
            int cur = Math.min(p1,p2);
            ans = Math.max(ans,cur);
            pre = cur;//全局答案更新，当前字符要变成上一字符的结果
            map[chas[i]] = i;//字符chas[i]上一次出现的位置map[chas[i]]要变成i位置
        }
        return ans;
    }



}
