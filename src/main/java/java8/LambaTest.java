package java8;

/**
 * Created by Movie on 2017/10/16.
 */
public class LambaTest {
    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(11);
        }).start();
    }
}
