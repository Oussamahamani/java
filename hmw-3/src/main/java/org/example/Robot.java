package org.example;

public class Robot implements Runnable {
    public String name;
    private LoadingDock dock;

    /**
     * Constructor.
     */
    public Robot(String name, LoadingDock dock) {
        this.name = name;
        this.dock = dock;
    }

    /**
     * add a random number of packages every second
     */
    @Override
    public void run() {
        while (true) {
            int randomAmount = (int)(Math.random() * 3) + 1;
            this.dock.addPackages(this.name,randomAmount);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
