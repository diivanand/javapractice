package diiv.javapractice.util.concurrency;

import java.util.Random;

public class ProducerThread extends Thread {
    public ProducerThread(ProducerConsumerQueue queue) {
        _queue = queue;
    }

    @Override
    public void run() {
        String messages[] = {
                "First message",
                "Second message",
                "Third message",
                "Fourth message",
                "Fifth message"
        };
        Random random = new Random();
        for (int i = 0; i < messages.length; i++) {
            System.out.println("Producer inserting: " + messages[i]);
            _queue.insert(messages[i]);
            try {
                int randInt = random.nextInt(5000);
                System.out.println("Producer sleeping for " + randInt + " milliseconds...");
                Thread.sleep(randInt);
                System.out.println("Producer woke up!");
            } catch (InterruptedException e) {}
        }
        _queue.insert("DONE");
        System.out.println("Producer inserted final message! Producer Thread exiting!");
    }

    private ProducerConsumerQueue _queue;
}
