
public class BinarySearch {

    public static int indexOf(int[] a, int key) {
        int lo = 0;
        int hi = a.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;

            if (key > a[mid]) {
                lo = mid + 1;
            } else if (key < a[mid]) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 10, 20, 30, 35, 40, 50, 55, 60, 65, 75, 80, 100 };
        int[] arr1 = new int[] {};
        int[] arr2 = new int[] { 1 };
        System.out.println(indexOf(arr1, 5) == -1);
        System.out.println(indexOf(arr2, 1) == 0);
        System.out.println(indexOf(arr2, 3) == -1);
        System.out.println(indexOf(arr, 5) == -1);
        System.out.println(indexOf(arr, 15) == -1);
        System.out.println(indexOf(arr, 30) == 2);
        System.out.println(indexOf(arr, 50) == 5);
        System.out.println(indexOf(arr, 80) == 10);
        System.out.println(indexOf(arr, 120) == -1);
        System.out.println(indexOf(arr, 10) == 0);
        System.out.println(indexOf(arr, 100) == 11);
        System.out.println(indexOf(arr, 90) == -1);
    }
}
