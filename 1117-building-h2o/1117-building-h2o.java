class H2O {
    private Semaphore hydrogen = new Semaphore(2);
    private Semaphore oxygen = new Semaphore(1);
    private CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        hydrogen.release(2);
        oxygen.release(1);
    });


    public H2O() {
        
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogen.acquire();

        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        try{
        barrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygen.acquire();
        
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
		releaseOxygen.run();
        
        try {
            barrier.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }
}

/**

two threads -- we cant continue unless we have all of the molecules together 
    Two Semaphores
        for oxyegn -- 0
        for hydrogen -- 2
    Cyclic Barrier 


 */