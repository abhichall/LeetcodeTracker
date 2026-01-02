class FooBar {
    private int n;
    private Semaphore fooSem = new Semaphore(1);
    private Semaphore barSem = new Semaphore(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            fooSem.acquire(); //wait until it is allowed to print foo
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
        	printFoo.run();

            //foo was printed so 
            barSem.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            barSem.acquire(); //wait intil foo() signals
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	printBar.run();

            fooSem.release();
        }
    }
}

//ideas

/**

two threads must print out alternate -- foo then bar etc n times
alternating -- think of acquire and release pattern with semaphores
    Two Semaphores- one controlling foo print, one controlling bar print

    make foo available first - 1 permit only once
    bar is blocked - 0 permits
    
    after foo is printed, release bar block foo
    vice versa n times


 */