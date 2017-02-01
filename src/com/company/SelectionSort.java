package com.company;

import com.company.com.SortAbstract;

import java.util.ArrayList;

/**
 * Created by AlexBrown on 2017-01-20.
 */
public class SelectionSort extends SortAbstract{

    private ArrayList<Integer> arrayList;

    public SelectionSort() {}

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> unsortedArray){

        ArrayList<Integer> sortedArray = new ArrayList<>();
        this.arrayList = unsortedArray;

        while(arrayList.size() != 0){
            int currentMin = 0;
            int currentMinIndex = 0;
            for(int i = 0; i < unsortedArray.size(); i++){
                if(i == 0){
                    currentMin = unsortedArray.get(0);
                    currentMinIndex = i;
                } else if (currentMin > unsortedArray.get(i)){
                    currentMin = unsortedArray.get(i);
                    currentMinIndex = i;
                }
            }
            sortedArray.add(currentMin);
            arrayList.remove(currentMinIndex);
        }

        return sortedArray;
    }

}
