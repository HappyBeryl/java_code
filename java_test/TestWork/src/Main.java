public class Main {
    /**
     * 大写转小写
     * A 65 Z 90
     * a 97 z 122
     */
    public String toLowerCase(String str) {
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(ch >= 65 && ch <= 90) {
                ch = (char)(ch + 32);
            }
            sb.append(ch);
        }
        return sb.toString();
    }

    public String toLowerCase1(String str) {
        return str.toLowerCase();
    }

}
