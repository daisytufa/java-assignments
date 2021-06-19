public class QuestionOne{
	public static class MyRunnable implements Runnable{
		private Object prev;
		private Object self;
		private String name;

		public MyRunnable(String name, Object prev, Object self){
			this.prev = prev;
			this.self = self;
			this.name = name;
		}
		@Override
		public void run(){
			int count = 10;
			while(count >0){
				synchronized(prev){
					synchronized(self){
						System.out.print(name);
						count--;
						self.notifyAll();
					}
					try{
						if(count == 0){
							//terminate it
							prev.notifyAll();
						}else{
							prev.wait();
						}
					}catch(InterruptedException e){
						e.printStackTrace();
					}
				}
			}
		}
	}
	public static void main(String[] args) throws Exception{
	Object a = new Object();
	Object b = new Object();
	Object c = new Object();

	new Thread(new MyRunnable("A", c, a)).start();//allocate a new thread object and begin execution
	Thread.sleep(10);
    new Thread(new MyRunnable("B", a, b)).start();
    Thread.sleep(10);
    new Thread(new MyRunnable("C", b, c)).start();
    Thread.sleep(10);

	}
}