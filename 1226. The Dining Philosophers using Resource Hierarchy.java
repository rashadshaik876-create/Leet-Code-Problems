import java.util.concurrent.locks.ReentrantLock;

class DiningPhilosophers {
    private final ReentrantLock[] forks = new ReentrantLock[5];

    public DiningPhilosophers() {
        for (int i = 0; i < 5; i++) {
            forks[i] = new ReentrantLock();
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        
        int leftFork = philosopher;
        int rightFork = (philosopher + 4) % 5;

        // Acquire the lower-indexed fork first to break the circular wait condition and prevent deadlock
        int firstFork = Math.min(leftFork, rightFork);
        int secondFork = Math.max(leftFork, rightFork);

        forks[firstFork].lock();
        forks[secondFork].lock();

        try {
            // Pick up left fork
            if (firstFork == leftFork) {
                pickLeftFork.run();
                pickRightFork.run();
            } else {
                pickRightFork.run();
                pickLeftFork.run();
            }

            // Eat
            eat.run();

            // Put down forks
            putLeftFork.run();
            putRightFork.run();
        } finally {
            forks[secondFork].unlock();
            forks[firstFork].unlock();
        }
    }
}
