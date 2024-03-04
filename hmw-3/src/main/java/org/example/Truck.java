package org.example;

public class Truck implements Runnable{

    private String name;
    private LoadingDock dock;

    /**
     * Constructor.
     */
    public Truck(String name, LoadingDock dock) {
        this.name = name;
        this.dock = dock;
    }

    /**
     * take 20 packages every second
     */
    @Override
    public void run() {
        while (true) {
            this.dock.takePackages(this.name,20);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
