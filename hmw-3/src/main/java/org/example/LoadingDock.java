package org.example;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


public class LoadingDock {
    private int packages;
    private Lock lock = new ReentrantLock();
    private Condition newPackage = lock.newCondition();

    /**
     * Constructor.
     */
    public int getPackages() {
        return packages;
    }

    /**
     * Add Packages to the Loading Dock.
     *
     * @param robotName String robot name
     * @param numPackagesToAdd int numbers of packages to add
     */
    public void addPackages(String robotName, int numPackagesToAdd){
        lock.lock();
        this.packages += numPackagesToAdd;
        System.out.println("[Robot "+robotName+"] Added "+numPackagesToAdd +" packages, Total = "+this.getPackages()+"\n");
        newPackage.signalAll();
        lock.unlock();
    }

    /**
     * Take Packages from the Loading Dock.
     *
     * @param truckName String Truck name
     * @param numPackagesToTake int numbers of packages
     */
    public void takePackages(String truckName, int numPackagesToTake){
        lock.lock();
        try {
            while (this.getPackages() < numPackagesToTake) {
                System.out.println("[Truck "+truckName+"] is waiting for 20 packages, but there are only:  "+this.getPackages()+"\n");
                // Wait for the condition
                newPackage.await();
            }
            this.packages -= numPackagesToTake;
            System.out.println("[Truck "+truckName+"] is departing with 20 packages.\n");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
