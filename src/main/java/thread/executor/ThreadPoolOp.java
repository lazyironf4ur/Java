package thread.executor;

import inherit.Son;
import inherit.SonCreateService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author:Lazy1ron
 * @date:2019/9/8 0:21
 * 使用场景：创建同时多个线程去访问同一接口，并将返回的数据封装
 */
public class ThreadPoolOp {
    private static SonCreateService sonCreateService = new SonCreateService();
    private static final ExecutorService service = new ThreadPoolExecutor(10,
            30,
            200,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(100));


    static class ExecutorTask implements Callable<Boolean> {

        private Son son;
        private SonCreateService sonCreateService;

        ExecutorTask(Son son, SonCreateService sonCreateService) {
            this.son = son;
            this.sonCreateService = sonCreateService;
        }

        @Override
        public Boolean call() throws Exception {
            return sonCreateService.addListElement(this.son);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<ExecutorTask> tasklist = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            ExecutorTask executorTask = new ExecutorTask(Son.RandomSon(), sonCreateService);
            tasklist.add(executorTask);
        }
        List<Future<Boolean>> futures = service.invokeAll(tasklist);

        futures.stream().forEach((future) -> {
            try {
                System.out.println(future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });
        service.shutdown();
        /**
         * 存在Bug：访问Sons时会出现对象丢失
         */
        System.out.println(new SonCreateService().getSons().toString());
    }
}
