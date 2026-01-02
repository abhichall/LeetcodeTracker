class Foo {

    //use latches 
        private final CountDownLatch latch1To2;
        private final CountDownLatch latch2To3;

    public Foo() {
        this.latch1To2 = new CountDownLatch(1); //waiting for one task to be done
        this.latch2To3 = new CountDownLatch(1);        
    }



    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();

        //signal that this is complete
        latch1To2.countDown(); // decreases internal countdown of events
    }

    public void second(Runnable printSecond) throws InterruptedException {

        latch1To2.await(); //waits for latch 1 to finish

        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();

        latch2To3.countDown(); //decreases internal countdown
    }

    public void third(Runnable printThird) throws InterruptedException {

        latch2To3.await();
        
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}

/**

need to make it so that threads print in the right order alwasy onetwothree

have to control the execution order
    locks - make each thread wait before proceeding
    first runs -- signal second -- second runns - signal third, etc -- guarentees order


 */