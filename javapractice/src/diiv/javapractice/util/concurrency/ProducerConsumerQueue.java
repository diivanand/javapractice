package diiv.javapractice.util.concurrency;

public class ProducerConsumerQueue {
    private String message;
    private boolean empty;

    public ProducerConsumerQueue() {
        message = null;
        empty = true;
    }

    public synchronized void insert(String item) {
        //System.out.println("insert: acquired object lock");
        while(!empty) {
            try {
                System.out.println("insert: 1 item queue is full so thread calling this function going to sleep until it's empty...");
                wait();
            } catch (InterruptedException e) {}
            System.out.println("insert: Thread calling this Function woke up!");
        }
        empty = false;
        message = item;
        notifyAll();
        //System.out.println("insert: releasing object lock");
    }

    public synchronized String remove() {
        //System.out.println("remove: acquired object lock");
        while(empty) {
            try {
                System.out.println("remove: 1 item queue is empty so thread calling this function going to sleep until it's full...");
                wait();
            } catch (InterruptedException e) {}
            System.out.println("remove: Thread calling this function woke up!");
        }
        empty = true;
        notifyAll();
        //System.out.println("remove: releasing object lock");
        return message;
    }

}
