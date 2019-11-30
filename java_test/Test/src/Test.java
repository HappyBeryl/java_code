import java.util.Arrays;

public class Test {
    public static int[] binerayArray(int[] array1, int[] array2) {
        int[] array3 = new int[array1.length+array2.length];
        int i = 0;
        int j = 0;
        int z = 0;
        while (true) {
            if (array1[i] <= array2[j]) {
                array3[z] = array1[i];
                i++;
                z++;
            } else {
                array3[z] = array2[j];
                j++;
                z++;
            }
            if (i == array1.length && j < array2.length) {
                for (int k = j; k < array2.length ; k++) {
                    array3[z] = array2[k];
                }
                break;
            }

            if (j == array2.length && i < array1.length) {
                for (int k = i; k < array1.length ; k++) {
                    array3[z] = array1[k];
                }
                break;
            }
            if (i == array1.length && j == array2.length) {
                break;
            }
        }
       return array3;
    }

    public static void main1(String[] args) {
        int[] array1 = {1,3,6,9,10};
        int[] array2 = {2,4,6,8,15,16};
        int[] arr = binerayArray(array1,array2);
        System.out.println(Arrays.toString(arr));
    }

    public static void reverse(char[] array,int left,int right) {
        while (left < right) {
            char tmp = array[left];
            array[left] = array[right];
            array[right] = tmp;
            left++;
            right--;
        }
    }

    public static String reverseSentence(String str) {
        char[] array = str.toCharArray();
        reverse(array,0,array.length-1);
        int i = 0;
        int j = 0;
        //单词逆置
        while (i < array.length) {
            if (array[i] == ' ') {
                i++;
                j++;
            } else if (j == array.length || array[j] == ' '){
                reverse(array,i,j-1);
                i = ++j;
            } else {
                j++;
            }
        }
        return String.copyValueOf(array);
    }

    public static void main(String[] args) {
        String ret = reverseSentence("i am student");
        System.out.println(ret);
    }



}
