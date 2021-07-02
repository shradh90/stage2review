package BinarySearch;

public class BinarySearchImplementation <T extends Comparable<T>> {
    T[] elements;

    public BinarySearchImplementation(T[]elements){
        this.elements = elements;
    }

    public int search (Comparable < T > v) {
        int low = 0;
        int high = elements.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            T midVal = elements[mid];
            int result = v.compareTo(midVal);
            if (result < 0) {
                high = mid - 1;
            } else if (result > 0) {
                low = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

