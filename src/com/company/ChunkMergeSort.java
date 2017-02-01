package com.company;

import com.company.com.SortAbstract;

import java.util.ArrayList;

/**
 * Created by AlexBrown on 2017-01-20.
 */
public class ChunkMergeSort extends SortAbstract {

    ArrayList<Integer> arrayList;
    ArrayList<ArrayList<Integer>> chunkManager = new ArrayList<>();

    public ChunkMergeSort() {}

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arrayEntered) {
        this.arrayList = arrayEntered;
        this.chunkManager.add(arrayEntered);

        chunkDivideLoop();



        return chunkMergeLoop();
    }

    public int countChunks(ArrayList<Integer> chunk){
        int chunkCount = 1;

        for(int i = 1; i < chunk.size(); i ++){
            if(chunk.get(i-1) > chunk.get(i)){
                chunkCount ++;
            }
        }

        return chunkCount;
    }
    public int getRoundUpHalf(int chunkCount){
        int roundUpHalf;

        if(chunkCount % 2 == 0) roundUpHalf = chunkCount/2;
        else roundUpHalf = (chunkCount + 1)/2;

        return roundUpHalf;
    }
    public DoubleChunk chunkDivide(ArrayList<Integer> chunkEntered,int chunkCount){
        ArrayList<Integer> chunk1 = new ArrayList<>();
        ArrayList<Integer> chunk2 = new ArrayList<>();
        int half = getRoundUpHalf(countChunks(chunkEntered));

        int chunkIncrement = 1;

        chunk1.add(chunkEntered.get(0));
        for(int i = 1; i < chunkEntered.size(); i ++){
            if(chunkEntered.get(i-1) > chunkEntered.get(i)){
                chunkIncrement ++;
            }
            if(chunkIncrement <= half) chunk1.add(chunkEntered.get(i));
            else chunk2.add(chunkEntered.get(i));
        }

        return new DoubleChunk(chunk1,chunk2);
    }
    public void chunkDivideLoop(){
        boolean done = false;
        ArrayList<ArrayList<Integer>> modifiedChunkManager = null;

        while(!done) {
            done = true;
            modifiedChunkManager = new ArrayList<>();
            for (int i = 0; i < chunkManager.size(); i++) {
                int chunkCount = countChunks(chunkManager.get(i));
                if (chunkCount != 1) {
                    DoubleChunk chunks = chunkDivide(chunkManager.get(i), chunkCount);
                    modifiedChunkManager.add(chunks.getChunk1());
                    modifiedChunkManager.add(chunks.getChunk2());
                    done = false;
                }else{
                    modifiedChunkManager.add(chunkManager.get(i));
                }
            }
            chunkManager = modifiedChunkManager;
        }

    }

    public ArrayList<Integer> chunkMerge(ArrayList<Integer> chunk1,ArrayList<Integer> chunk2){
        ArrayList<Integer> combinedChunk = new ArrayList<>();

        int chunk1Incrament = 0;
        int chunk2Incrament = 0;

        while(combinedChunk.size() <= ((chunk1.size())+(chunk2.size()-1))){
            if(chunk1Incrament < chunk1.size() && chunk2Incrament < chunk2.size()) {
                if (chunk1.get(chunk1Incrament) < chunk2.get(chunk2Incrament)) {
                    combinedChunk.add(chunk1.get(chunk1Incrament));
                    chunk1Incrament++;
                } else {
                    combinedChunk.add(chunk2.get(chunk2Incrament));
                    chunk2Incrament++;
                }
            }else if(!(chunk1Incrament < chunk1.size())){
                combinedChunk.add(chunk2.get(chunk2Incrament));
                chunk2Incrament++;
            }else{
                combinedChunk.add(chunk1.get(chunk1Incrament));
                chunk1Incrament++;
            }
        }


        return combinedChunk;
    }
    private ArrayList<Integer> chunkMergeLoop(){

        while (chunkManager.size() != 1){
            ArrayList<ArrayList<Integer>> modifiedChunkManager = new ArrayList<>();
            for(int i = 0; i < chunkManager.size(); i++){
                if((i+1<chunkManager.size())){
                    modifiedChunkManager.add(chunkMerge(chunkManager.get(i),chunkManager.get(i+1)));
                    i++;
                }else {
                    modifiedChunkManager.add(chunkManager.get(i));
                }
            }
            this.chunkManager = modifiedChunkManager;
        }

        return chunkManager.get(0);
    }

}
