import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerExample {
    private static final int BUFFER_SIZE = 5;

    public static void main(String[] args) {
        BlockingQueue<Integer> buffer = new ArrayBlockingQueue<>(BUFFER_SIZE);

        Thread producer = new Thread(new Producer(buffer));
        Thread consumer = new Thread(new Consumer(buffer));

        producer.start();
        consumer.start();
    }

    static class Producer implements Runnable {
        private final BlockingQueue<Integer> buffer;

        Producer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            int value = 0;
            try {
                while (true) {
                    Thread.sleep((int)(Math.random() * 1000)); // Simulate work
                    buffer.put(value);
                    System.out.println("Produced: " + value);
                    value++;
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    static class Consumer implements Runnable {
        private final BlockingQueue<Integer> buffer;

        Consumer(BlockingQueue<Integer> buffer) {
            this.buffer = buffer;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    Thread.sleep((int)(Math.random() * 1500)); // Simulate work
                    int value = buffer.take();
                    System.out.println("Consumed: " + value);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}