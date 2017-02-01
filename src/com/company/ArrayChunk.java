package com.company;

/**
 * Created by AlexBrown on 2017-01-27.
 */
public class ArrayChunk {

    private int min;
    private int max;

    public ArrayChunk(int min, int max) {
        this.max = max;
        this.min = min;
    }

    public int getMax() {
        return max;
    }
    public int getMin() {
        return min;
    }
    public int getSize(){
        return max - min + 1;
    }

}
