package algorithm.permutation;

/*
* 剑指 Offer 38. 字符串的排列
* 解法1：dfs加回溯法 TODO
* */


import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Permutation {
    List<String> res = new LinkedList<>();
    char[] words;
    public String[] permutation(String s) {
        words = s.toCharArray();
        dfs(0);
        return res.toArray(new String[res.size()]);
    }

    private void dfs(int x) {
        if (x == words.length - 1) {
            res.add(String.valueOf(words));
            return;
        }
        HashSet<Character> hashSet = new HashSet<>();
        for (int i = x; i < words.length; i ++) {
            if (hashSet.contains(words[i]))
                continue;
            hashSet.add(words[i]);
            swap(x, i);
            dfs(x + 1);
            swap(x, i);
        }
    }
    private void swap(int i, int j) {
        char tmp = words[i];
        words[i] = words[j];
        words[j] = tmp;
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        String[] ss = permutation.permutation("abc");
        for (String s: ss)
            System.out.println(s);
    }
}
