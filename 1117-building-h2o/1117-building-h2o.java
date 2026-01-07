/**

switch between the hydrogen and the oxygen 

    semaphore for hydrogen - 2
    semaphore for oxygen - 0
 */

 class H2O {

    private Semaphore hSem = new Semaphore(2);
    private Semaphore oSem = new Semaphore(0);

    public H2O() {}

    public void hydrogen (Runnable releaseHydrogen) throws InterruptedException {
        hSem.acquire(); //wait for hydrogen to be open run
        releaseHydrogen.run();

        if (hSem.availablePermits() == 0) oSem.release(); //signal oSem to start
    }

    public void oxygen (Runnable releaseOxygen) throws InterruptedException {
        oSem.acquire(); //wait until 2 hydrogens are ready
        releaseOxygen.run();
        hSem.release(2);

    }


 }