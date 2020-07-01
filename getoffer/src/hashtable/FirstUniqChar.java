package hashtable;

/*
* 剑指 Offer 50. 第一个只出现一次的字符
* 解法1：有序hash表，遍历字符串一遍构成hash，遍历hash表，获取结果，遍历次数更少
* 解法2：普通hash表，遍历字符串一遍构成hash，遍历第二遍找出第一个出现次数为1的字符
* */

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstUniqChar {

    public char firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (char c: chars) map.put(c, !map.containsKey(c));
        for (Map.Entry<Character, Boolean> dic: map.entrySet())
            if (dic.getValue()) return dic.getKey();
        return ' ';
    }

//    无需记录次数，数据有点冗余了
//    public char firstUniqChar(String s) {
//        char[] chars = s.toCharArray();
//        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
//        for (char c: chars) {
//            if (!map.containsKey(c))
//                map.put(c, 1);
//            else
//                map.put(c, map.get(c) + 1);
//        }
//        char result = (char)32;
//        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().iterator();
//        while (iterator.hasNext()) {
//            Map.Entry<Character, Integer> count = iterator.next();
//            if (count.getValue() == 1) {
//                result = count.getKey();
//                break;
//            }
//        }
//        return result;
//    }

    public static void main(String[] args) {
        FirstUniqChar firstUniqChar = new FirstUniqChar();
        firstUniqChar.firstUniqChar("nihao");
    }
}
