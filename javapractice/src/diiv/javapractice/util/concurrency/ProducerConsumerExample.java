package diiv.javapractice.util.concurrency;


public class ProducerConsumerExample {

    public static void main(String [] args) {
        ProducerConsumerQueue q = new ProducerConsumerQueue();
        Thread producer = new ProducerThread(q);
        Thread consumer = new ConsumerThread(q);
        consumer.start();
        producer.start();
    }
}
