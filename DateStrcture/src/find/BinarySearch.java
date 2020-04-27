package find;

public class BinarySearch {
    public static int binarySearch(int[] array, int toFind) {
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (toFind < array[mid]) {
                right = mid - 1;
            } else if(toFind > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(binarySearch(array, 6));
    }
}
