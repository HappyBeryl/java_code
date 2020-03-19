package com.thread1;

public class MyTimer {
    //封装了一个方法
    interface TimerTask {
        void run();
    }

    //创建线程，传入任务和延迟时间
    static class Worker extends Thread {
        long delay;
        TimerTask task;

        Worker(TimerTask task, long delay) {
            this.task = task;
            this.delay = delay;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.run();
        }

        void schedule(TimerTask task, long delay) {
            Worker worker = new Worker(task, delay);
            worker.start();
        }
    }


}
