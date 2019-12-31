import java.nio.ByteBuffer;

/**
 * 本地内存用光异常例子
 */
public class DirectBufferMemoryDemo {
    public static void main(String[] args) {
        System.out.println("配置的maxDirectMemory:"+(sun.misc.VM.maxDirectMemory()/1024/10024)+"MB");
        // 使用NIO中的ByteBuffer.allcoteDirect()
        ByteBuffer bb = ByteBuffer.allocateDirect(6 * 1024 * 1024);
    }
}
