package src.jianzhioffer;

import java.util.HashMap;

public class Hash {

    /**
     * @return
     *
     * 第一个只出现一次的字符
     */
    public static char firstUniqChar(String s){
        if(s.length()==0) return ' ';
        HashMap<Character,Integer> map = new HashMap<Character,Integer>();


        for(int i = 0; i <= s.length()-1;i++){
            char a = s.charAt(i);
            if(map.containsKey(a)){
                map.put(a,(map.get(a)+1));
            }else{
                map.put(a,1);
            }
        }

        for(int j =0 ;j<=s.length()-1;j++){
            char a = s.charAt(j);
            int num = map.get(a);
            if(num==1) return a;
        }

        return ' ';
    }

}
