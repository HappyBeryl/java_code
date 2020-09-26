package nine;

import java.util.ArrayList;

public class Mainouyunlian {

    public static void main(String[] args) {
        System.out.println(isPalindrome("Was it a bar or a bat I saw"));
    }
    public static boolean isPalindrome (String s) {
        // write code here
        s = s.toUpperCase();
        int i = 0;
        int j = s.length()-1;
        while (i < j) {
            if (isNumOrWord(s.charAt(i)) && isNumOrWord(s.charAt(j)) ) {
                if (s.charAt(i) != s.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            } else if (!isNumOrWord(s.charAt(i)) &&isNumOrWord(s.charAt(j))) {
                i++;
            } else if (isNumOrWord(s.charAt(i)) && !isNumOrWord(s.charAt(j))) {
                j--;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private static boolean isNumOrWord(char s) {
        if ((s >= 'a' && s <= 'z') ||(s >= '0' && s <= '9') ) {
            return true;
        }
        return false;
    }

    public String[] permutate (String s) {
        // write code here
        ArrayList<String> result = new ArrayList<>();
        if (s != null && s.length() > 0) {
            permutateChild(s.toCharArray(), 0, result);
        }
        String[] ret = new String[result.size()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = result.get(i);
        }
        return ret;
    }

    private void permutateChild(char[] str, int start, ArrayList<String> result) {
        if (start == str.length-1) {
            if (!IsExist(result, str)) {
                result.add(new String(str));
            }
            return;
        }
        for (int j = start; j < str.length; j++) {
            Swap(str,start, j );
            permutateChild(str, start+1, result);
            Swap(str, start, j);
        }
    }

    private void Swap(char[] str, int i, int j) {
        char tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }

    private boolean IsExist(ArrayList<String> result, char[] str) {
        return result.contains(String.valueOf(str));
    }

}
