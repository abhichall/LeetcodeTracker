class H2O {
    private Semaphore hydrogenSem = new Semaphore(2);
    private Semaphore oxygenSem = new Semaphore(1);
    private CyclicBarrier barrier = new CyclicBarrier(3, () -> {
        // Reset semaphores after forming one water molecule
        hydrogenSem.release(2);
        oxygenSem.release(1);
    });

    public H2O() {}

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        hydrogenSem.acquire();
        try {
            releaseHydrogen.run(); // outputs "H"
            barrier.await(); // wait for 2H + 1O
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        oxygenSem.acquire();
        try {
            releaseOxygen.run(); // outputs "O"
            barrier.await(); // wait for 2H + 1O
        } catch (Exception e) {
            Thread.currentThread().interrupt();
        }
    }
}