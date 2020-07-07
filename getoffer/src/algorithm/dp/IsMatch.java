package algorithm.dp;

/*
* 剑指 Offer 19. 正则表达式匹配
* 题解1：动态规划 TODO
* 题解2：暴力
* */

public class IsMatch {
    char[] words;
    String[] patterns;
    public boolean isMatch(String s, String p) {
        words = s.toCharArray();
        patterns = getPatterns(p);
        if (words.length == 0 && patterns[0].equals(""))
            return true;

        return dfs(0, 0);
    }

    boolean dfs(int i, int j) {
        if (i == words.length) {
            boolean endWithStar = true;
            for (int k = j; k < patterns.length; k ++) {
                if (!patterns[k].endsWith("*"))
                    endWithStar = false;
            }
            return endWithStar;
        }
        if (j == patterns.length && i < words.length)
            return false;
        if (patterns[j].equals(".") || String.valueOf(words[i]).equals(patterns[j])) {
            return dfs(i + 1, j + 1);
        } else if (patterns[j].endsWith("*")) {
            if (dfs(i, j + 1))
                return true;
            while (i < words.length && match(String.valueOf(words[i]), patterns[j].replace("*", ""))) {
                if (dfs(++ i, j + 1))
                    return true;
            }
        }
        return false;
    }

    String[] getPatterns(String p) {
        if (p.equals(""))
            return new String[]{""};
        String[] tmp = p.split("\\*");
        int patternLength = 0;
        for (String s: tmp) {
            patternLength += s.toCharArray().length;
        }
        String[] patterns = new String[patternLength];
        int i = 0;
        for (String s: tmp) {
            char[] chars = s.toCharArray();
            for (int j = 0; j < chars.length; j ++) {
                patterns[i] = String.valueOf(chars[j]);
                if (j == chars.length - 1)
                    patterns[i] += "*";
                i ++;
            }
        }
        if (!p.endsWith("*"))
            patterns[patternLength - 1] = patterns[patternLength - 1].replace("*", "");
        return patterns;
    }

    boolean match(String s, String p) {
        return (p.equals(".") || s.equals(p));
    }

    public static void main(String[] args) {
        for (String s: new IsMatch().getPatterns("abcde")) {
            System.out.println(new IsMatch().match("a", ""));
        }
        System.out.println(new IsMatch().isMatch("", ""));

    }
}
