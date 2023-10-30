package company.hibob;

import java.util.LinkedList;

public class RateLimiter {

    private final long intervalMillis;
    private final long limit;
    private final LinkedList<Long> requests = new LinkedList<>();

    public RateLimiter(long intervalMillis, long limit) {
        this.intervalMillis = intervalMillis;
        this.limit = limit;
    }

    public boolean tryAcquire() {
        long currentTime = System.currentTimeMillis();
        cleanRequests(currentTime);
        if (requests.size() < limit) {
            synchronized (this) {
                requests.addFirst(currentTime);
            }
            return true;
        } else {
            return false;
        }
    }

    private synchronized void cleanRequests(long currentTime) {
        long threshold = currentTime - intervalMillis;
        while (!requests.isEmpty() && requests.getLast() < threshold) {
            requests.removeLast();
        }
    }

}

class RateLimiterTest {

    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new RateLimiter(1000, 2);

        int attempts = 10;
        while (attempts > 0) {
            System.out.println(rateLimiter.tryAcquire());
            Thread.sleep(200);
            attempts--;
        }
    }
}
