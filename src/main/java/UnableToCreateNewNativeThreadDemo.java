/**
 * 不能创建多个线程例子
 * 导致原因：
 * 1. 你的应用创建了太多线程，一个应用进程创建多个进程，超过系统承载极限
 * 2. 你的服务器并不允许你的应用程序创建这么多线程
 */
public class UnableToCreateNewNativeThreadDemo {
    public static void main(String[] args) {
        for (int i = 0; ; i++) {
            new Thread(()->{
                try {
                    Thread.sleep(Integer.MAX_VALUE);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
