package testing;

import com.sun.javafx.collections.ImmutableObservableList;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by AlexBrown on 2017-01-28.
 */
public class RandomGenerator {

    private ArrayList<Integer> randomArray = new ArrayList<Integer>();

    public RandomGenerator(int SIZE) {
        generateRandomArray(SIZE);
    }

    private void generateRandomArray(int SIZE){
        Random rand = new Random();
        ArrayList<Integer> randomArrayGenerated = new ArrayList<>();

        for(int i = 0; i < SIZE; i++){
            randomArrayGenerated.add(rand.nextInt(1000000));
        }

        this.randomArray = randomArrayGenerated;

    }

    public ArrayList<Integer> getRandomArray() {
        return new ArrayList<>(randomArray);
    }

}
