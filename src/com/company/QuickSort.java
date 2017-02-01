package com.company;

import com.company.com.SortAbstract;
import com.sun.tools.corba.se.idl.IncludeGen;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by AlexBrown on 2017-01-20.
 */
public class QuickSort extends SortAbstract {

    private ArrayList<Integer> arrayList = new ArrayList<>();
    private ArrayList<ArrayChunk> unsortedChunkManager = new ArrayList<>();

    public QuickSort() {}

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arrayEntered){
        this.arrayList = arrayEntered;
        unsortedChunkManager.add(new ArrayChunk(0,(arrayEntered.size()-1)));

        while(!(unsortedChunkManager.size() == 0)) {
            sortSort();
        }

        return arrayList;

    }
    public void sortSort(){
        ArrayList<ArrayChunk> updatedUnsortedChunkManager = new ArrayList<>();

        for (int i = 0; i < unsortedChunkManager.size(); i++){
            if(unsortedChunkManager.get(i).getSize() > 5){
                ArrayChunkPair chunkPair = sortLarge(unsortedChunkManager.get(i));
                updatedUnsortedChunkManager.add(chunkPair.getArrayChunk1());
                updatedUnsortedChunkManager.add(chunkPair.getArrayChunk2());
            }else if(unsortedChunkManager.get(i).getSize() == 1);
            else{
                bubbleSort(unsortedChunkManager.get(i));
            }
        }

        this.unsortedChunkManager = updatedUnsortedChunkManager;

    }
    public int choosePivot(ArrayChunk currentChunk){
        int pivot = -1;
        Random rand = new Random();
        int arrayChunkSize = currentChunk.getSize();
        int numGreater = 0;

        boolean flipper = true;


        while(!(numGreater >= arrayChunkSize/4 && numGreater <= (arrayChunkSize*3)/4)) {
            numGreater = 0;
            pivot = rand.nextInt(arrayChunkSize) + currentChunk.getMin();

            for(int i = currentChunk.getMin(); i < currentChunk.getMax(); i++){
                if(arrayList.get(i) > arrayList.get(pivot)){
                    numGreater ++;
                }else if(arrayList.get(i) == arrayList.get(pivot)){
                    if(flipper == true){
                        numGreater++;
                        flipper = false;
                    }else flipper = true;
                }
            }
        }
        return pivot;
    }
    public ArrayChunkPair sortLarge(ArrayChunk currentChunk){

        int PIVOT = choosePivot(currentChunk);

        int PIVOT_VALUE = arrayList.get(PIVOT);

        ArrayList<Integer> lesserArray = new ArrayList<>();
        ArrayList<Integer> greaterArray = new ArrayList<>();

        int arrayCounter = currentChunk.getMin();

        for(int i = currentChunk.getMin(); i <= currentChunk.getMax(); i++){
            if((arrayList.get(i) <= PIVOT_VALUE) && i != PIVOT) lesserArray.add(arrayList.get(i));
            else if(i == PIVOT);
            else greaterArray.add(arrayList.get(i));
        }

        for(int i = 0; i < lesserArray.size(); i ++){
            arrayList.set(arrayCounter,lesserArray.get(i));
            arrayCounter++;
        }

        arrayList.set(arrayCounter,PIVOT_VALUE);
        int pivotPlacement = arrayCounter;
        arrayCounter ++;

        for(int i = 0; i < greaterArray.size(); i++){
            if(arrayCounter > arrayList.size()-1){
                arrayList.add(greaterArray.get(i));
            }
            arrayList.set(arrayCounter,greaterArray.get(i));
            arrayCounter++;
        }

        return new ArrayChunkPair(new ArrayChunk(currentChunk.getMin(),(pivotPlacement - 1)),new ArrayChunk((pivotPlacement + 1),currentChunk.getMax()));

    }
    public void bubbleSort(ArrayChunk currentChunk){

        for(int i = currentChunk.getMax(); i >= currentChunk.getMin(); i--) {
            for (int j = currentChunk.getMin() + 1; j <= i; j++) {
                if(arrayList.get(j-1) > arrayList.get(j)){
                    int tmp = arrayList.get(j-1);
                    arrayList.set(j-1,arrayList.get(j));
                    arrayList.set(j,tmp);
                }
            }
        }
    }

}
