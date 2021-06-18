import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Q2 {
    public static class Item{
        Item(){

        }
    }
    public static void main(String[] args) {
        //wait for the queue to become non-empty when retrieving 
        //an element, and wait for space to become available in 
        //the queue when storing an element
        //thread safe data structure
        BlockingQueue<Item> queue = new ArrayBlockingQueue<>(10);

        Runnable producer =()->{
            while(true){
                try {
                    queue.put(new Item());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }//blocks if full
            }
        };
        new Thread(producer).start();
        new Thread(producer).start();
        Runnable consumer = ()->{
            while(true){
                try {
                    Item i = queue.take();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }//blocks if empty
            }
        };
        new Thread(consumer).start();
        new Thread(consumer).start();

        Thread.sleep(2000);
    }
}
