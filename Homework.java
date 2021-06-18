public class Homework{
    public static class ThreadA extends Thread{
        @Override
        public void run(){
            synchronized(this){
                System.out.println("A");
                this.notify();
                try{
                    this.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }  
        }
    }
    public static class ThreadB extends Thread{
        @Override
        public void run(){
            synchronized(this){
                System.out.println("B");
                this.notify();
                try{
                    this.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static class ThreadC extends Thread{
        @Override
        public void run(){
            synchronized(this){
                System.out.println("C");
                this.notify();
                try{
                    this.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args){
        ThreadA tA = new ThreadA();
        ThreadB tB = new ThreadB();
        ThreadC tC = new ThreadC();
        tA.start();
        tB.start();
        tC.start();

    }
}