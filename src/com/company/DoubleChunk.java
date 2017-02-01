package com.company;

import java.util.ArrayList;

/**
 * Created by AlexBrown on 2017-01-28.
 */
public class DoubleChunk {
    private ArrayList<Integer> chunk1;
    private ArrayList<Integer> chunk2;

    public DoubleChunk(ArrayList<Integer> chunk1, ArrayList<Integer> chunk2) {
        this.chunk1 = chunk1;
        this.chunk2 = chunk2;
    }

    public ArrayList<Integer> getChunk1() {
        return chunk1;
    }
    public ArrayList<Integer> getChunk2() {
        return chunk2;
    }

}
