package diiv.javapractice.util.sorting;


public class DiivQuickSort<T extends Comparable> {
    public DiivQuickSort(T[] items) {
        if (items == null || items.length == 0) {
            throw new IllegalArgumentException("items cannot be null or empty");
        }
        quicksort(items, 0, items.length-1);
    }

    private void quicksort(T[] items, int startIndexInclusive, int endIndexInclusive) {
        int subArrayLength = endIndexInclusive - startIndexInclusive + 1;
        if (subArrayLength == 2) {
            swapIfGreaterThan(items, startIndexInclusive, endIndexInclusive);
        }
        else if (subArrayLength == 1){
            return;
        }
        else {
            int pivotIndex = endIndexInclusive + startIndexInclusive / 2;
            for (int leftSideIndex = startIndexInclusive; leftSideIndex < pivotIndex; leftSideIndex++)
            {
                swapIfGreaterThan(items, leftSideIndex, pivotIndex);
            }
            for (int rightSideIndex = pivotIndex+1; rightSideIndex <= endIndexInclusive; rightSideIndex++)
            {
                swapIfGreaterThan(items, pivotIndex, rightSideIndex);
            }
            quicksort(items, startIndexInclusive, pivotIndex-1);
            quicksort(items, pivotIndex+1, endIndexInclusive);
        }
    }

    //swaps if item in index1 if greater than item in index2
    private void swapIfGreaterThan(T[] items, int index1, int index2) {
        T item1 = items[index1];
        T item2 = items[index2];
        if (item1.compareTo(item2) > 0) {
            swap(items, index1, index2);
        }
    }

    private void swap(T[] items, int index1, int index2) {
        T tmp = items[index1];
        items[index1] = items[index2];
        items[index2] = tmp;
    }
}
