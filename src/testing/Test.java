package testing;

import com.company.BubbleSort;
import com.company.ChunkMergeSort;
import com.company.QuickSort;
import com.company.SelectionSort;

import java.util.ArrayList;
import java.util.Random;

public class Test {

    private static SelectionSort selectionSort = new SelectionSort();
    private static ChunkMergeSort chunkMergeSort = new ChunkMergeSort();
    private static QuickSort quickSort = new QuickSort();
    private static BubbleSort bubbleSort = new BubbleSort();
    private static RandomGenerator randomGenerator = new RandomGenerator(10000);

    public static void main(String[] args) {

        runTest();

    }

    private static boolean checkInOrder(ArrayList<Integer> arrayList){
        boolean inOrder = true;

        for(int i = 1; i < arrayList.size(); i++){
            if(arrayList.get(i-1) > arrayList.get(i)) inOrder = false;
            break;
        }

        return inOrder;
    }
    private static float testQuick(){
        System.out.println("Quick Sort");
        System.out.println(String.valueOf(randomGenerator.getRandomArray()));
        long start = System.nanoTime();
        ArrayList<Integer> quikSortOrdered = quickSort.sort(randomGenerator.getRandomArray());
        long stop = System.nanoTime();

        System.out.println(String.valueOf(quikSortOrdered));
        System.out.println(String.valueOf(checkInOrder(quikSortOrdered)));
        System.out.println(String.valueOf(stop - start));
        System.out.println();
        return stop - start;
    }
    private static float testLinear(){
        System.out.println("Linear Sort");
        System.out.println(String.valueOf(randomGenerator.getRandomArray()));
        long start = System.nanoTime();
        ArrayList<Integer> selectionSortOrdered = selectionSort.sort(randomGenerator.getRandomArray());
        long stop = System.nanoTime();

        System.out.println(String.valueOf(selectionSortOrdered));
        System.out.println(String.valueOf(checkInOrder(selectionSortOrdered)));
        System.out.println(String.valueOf(stop - start));
        System.out.println();
        return stop - start;
    }
    private static float testBubble(){
        System.out.println("Bubble Sort");
        System.out.println(String.valueOf(randomGenerator.getRandomArray()));
        long start = System.nanoTime();
        ArrayList<Integer> bubbleSortOrdered = bubbleSort.sort(randomGenerator.getRandomArray());
        long stop = System.nanoTime();

        System.out.println(String.valueOf(bubbleSortOrdered));
        System.out.println(String.valueOf(checkInOrder(bubbleSortOrdered)));
        System.out.println(String.valueOf(stop - start));
        System.out.println();
        return stop - start;
    }
    private static float testMerge(){
        System.out.println("Chunk Merge Sort");
        System.out.println(String.valueOf(randomGenerator.getRandomArray()));
        long start = System.nanoTime();
        ArrayList<Integer> chunkMergeSortOrdered = chunkMergeSort.sort(randomGenerator.getRandomArray());
        long stop = System.nanoTime();

        System.out.println(String.valueOf(chunkMergeSortOrdered));
        System.out.println(String.valueOf(checkInOrder(chunkMergeSortOrdered)));
        System.out.println(String.valueOf(stop - start));
        System.out.println();
        return stop - start;
    }
    private static void runTest(){
        ArrayList<Float> stats = new ArrayList<>();
        stats.add(testQuick());
        stats.add(testMerge());
        stats.add(testBubble());
        stats.add(testLinear());

        float largest = 0;

        for(int i = 0; i < stats.size(); i++){
            if(stats.get(i) > largest) largest = stats.get(i);
        }
        System.out.println("Quick Sort = " + String.valueOf(stats.get(0)/largest));
        System.out.println("Chunk Merge Sort = " + String.valueOf(stats.get(1)/largest));
        System.out.println("Bubble Sort = " + String.valueOf(stats.get(2)/largest));
        System.out.println("Linear Sort = " + String.valueOf(stats.get(3)/largest));
    }

}
