package datastructure.stacknqueue;

/*
* 剑指 Offer 58 - I. 翻转单词顺序
* 解法1：库函数
* 解法2：双指针确定单词的边界 TODO
* */

public class ReverseWords {

    public String reverseWords(String s) {
        String[] words = s.trim().split(" ");
        StringBuilder reverseWords = new StringBuilder();
        for (int i = words.length - 1; i >= 0; i --) {
            if (!words[i].equals(""))
                reverseWords.append(words[i] + " ");
        }
        return reverseWords.toString().trim();
    }

//    方法不够熟悉
//    public String reverseWords(String s) {
//        List wordList = Arrays.asList(s.split("\\s"));
//        ArrayList<String> words = new ArrayList<>();
//        for (Object o: wordList) {
//            if (!o.equals(""))
//                words.add(o.toString());
//        }
//        Collections.reverse(words);
//        StringBuilder result = new StringBuilder();
//        for (int i = 0; i < words.size(); i ++) {
//            String ss = words.get(i);
//            result.append(ss);
//            if (i < words.size() - 1) {
//                System.out.println(ss.length());
//                result.append(" ");
//            }
//        }
//        return result.toString();
//    }

    public static void main(String[] args) {
        ReverseWords rw = new ReverseWords();
        rw.reverseWords("  hello world!  ");
    }
}
