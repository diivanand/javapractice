package diiv.javapractice.util.concurrency;


import java.util.Random;

public class ConsumerThread extends Thread {
    public ConsumerThread(ProducerConsumerQueue queue) {
        _queue = queue;
    }

    @Override
    public void run() {
        Random random = new Random();
        for (String message = _queue.remove(); !message.equals("DONE"); message = _queue.remove()) {
            System.out.println("Consumer received: " + message);
            try {
                int randInt = random.nextInt(5000);
                System.out.println("Consumer sleeping for " + randInt + " milliseconds...");
                Thread.sleep(randInt);
                System.out.println("Consumer woke up!");
            } catch (InterruptedException e) {}
        }
        System.out.println("Consumer received final message! Consumer Thread exiting!");
    }

    private ProducerConsumerQueue _queue;
}
