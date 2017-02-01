package com.company;

import com.company.com.SortAbstract;

import java.util.ArrayList;

/**
 * Created by AlexBrown on 2017-01-23.
 */
public class BubbleSort extends SortAbstract{

    private ArrayList<Integer> arrayList = new ArrayList<>();

    public BubbleSort() {}

    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> arrayList){

        this.arrayList = arrayList;

        for(int i = arrayList.size()-1; i > 0; i--){
            for(int j = 1; j<i; j++){
                if(arrayList.get(j-1) > arrayList.get(j)){
                    switchValues(j-1,j);
                }
            }
        }

        return arrayList;
    }
    public void switchValues(int valueOne, int valueTwo){
        int tmp = arrayList.get(valueOne);
        arrayList.set(valueOne,arrayList.get(valueTwo));
        arrayList.set(valueTwo,tmp);
    }

}
