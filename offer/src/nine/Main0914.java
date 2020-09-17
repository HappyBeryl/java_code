package nine;

public class Main0914 {
//    public int[][] RotateMatrix (int[][] matrix) {
//        // write code here
//
//    }
//
    public String GetCommon (String str1, String str2) {
        if (str1 == null || str1.length()==0 || str2==null || str2.length()==0) {
            return null;
        }
        // write code here
        String max = null;
        String min = null;
        max = str1.length()>str2.length()?str1:str2;
        min = max.equals(str1)?str2:str1;
        int len = max.length();
        if (max.contains(min)) {
            return min;
        }
        for (int i = 0; i < len; i++) {
            for (int s = 0,e = len-i; e < len; s++,e++) {
                String tmp = min.substring(s, e);
                if (max.contains(tmp)) {
                    return tmp;
                }
            }
        }
        return null;
    }


}
