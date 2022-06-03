package com.example.lab_10;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PyramidsList implements Serializable {
    private final List<Pyramid> pyramidList;

    public PyramidsList() {
        this.pyramidList = new ArrayList<>();
    }

    public boolean add(Pyramid pyramid) {
        return this.pyramidList.add(pyramid);
    }

    public void remove(int number) {
        if (number >= 0 && number < this.pyramidList.size()) {
            this.pyramidList.remove(number);
        }
    }

    public void remove(Pyramid pyramid) {
        this.pyramidList.remove(pyramid);
    }

    @Override
    public String toString() {
        return "PyramidsList: " + pyramidList;
    }
    public Pyramid getMinSquare(){
        Pyramid result = pyramidList.get(0);
        for (int i = 1; i < pyramidList.size(); i++) {
            if (result.getSquare() > pyramidList.get(i).getSquare()){
                result = pyramidList.get(i);
            }
        }
        return result;
    }
}
