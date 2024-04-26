import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class VirtualThread {
  public static void main(String[] args) throws InterruptedException {
    Thread.Builder builder = Thread.ofVirtual().name("worker-", 0);
    Runnable task = () -> {
      System.out.println("Thread ID: " + Thread.currentThread().threadId());
    };

// name "worker-0"
    Thread t1 = builder.start(task);
    t1.join();
    System.out.println(t1.getName() + " terminated");

// name "worker-1"
    Thread t2 = builder.start(task);
    t2.join();
    System.out.println(t2.getName() + " terminated");

    try {
      ExecutorService myExecutor = Executors.newVirtualThreadPerTaskExecutor();
      Set<Callable<String>> callables = new HashSet<Callable<String>>();

      callables.add(new Callable<String>() {
        public String call() throws Exception {
          return "Task 1";
        }
      });
      callables.add(new Callable<String>() {
        public String call() throws Exception {
          return "Task 2";
        }
      });
      callables.add(new Callable<String>() {
        public String call() throws Exception {
          return "Task 3";
        }
      });

      java.util.List<Future<String>> futures = myExecutor.invokeAll(callables);
      for(Future<String> future : futures){
        System.out.println("future.get = " + future.get());
      }

      myExecutor.shutdown();

      System.out.println("Task completed");
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    } catch (ExecutionException e) {
      throw new RuntimeException(e);
    }
  }

}
