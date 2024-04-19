package edu.bhcc.fitnessTracker;

import java.util.List;

public class TrackListWithTotal {
    private  List<Fitness> list;
    public double total = 0;

    public TrackListWithTotal(List<Fitness> list) {
        System.out.println(list);
        this.list = list;

        for (Fitness obj : list) {
            System.out.println("inside "+obj.getMiles());

            this.total+=obj.getMiles();
        }
//        System.out.println("after "+this.total);
    }

    public List<Fitness> getList() {
        return this.list;
    }


    public double getTotal() {
        return this.total;
    }


}
