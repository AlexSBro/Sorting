package com.company;

/**
 * Created by AlexBrown on 2017-01-28.
 */
public class ArrayChunkPair {

    private ArrayChunk arrayChunk1 = null;
    private ArrayChunk arrayChunk2 = null;

    public ArrayChunkPair(ArrayChunk arrayChunk1, ArrayChunk arrayChunk2) {
        this.arrayChunk1 = arrayChunk1;
        this.arrayChunk2 = arrayChunk2;
    }

    public ArrayChunk getArrayChunk1() {
        return arrayChunk1;
    }
    public ArrayChunk getArrayChunk2() {
        return arrayChunk2;
    }

}
