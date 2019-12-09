package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


/**
 * TODO: 未完成
 * @author:Lazy1ron
 * @date:2019/12/9 9:26
 */
public class Client {

    private static final ByteBuffer BUFFER = ByteBuffer.allocate(4096);

    private static final int ops = SelectionKey.OP_READ | SelectionKey.OP_WRITE | SelectionKey.OP_CONNECT;


    public static void main(String[] args) throws IOException {

        SocketChannel sc = SocketChannel.open(new InetSocketAddress("localhost", 1773));

        sc.configureBlocking(false);

        Selector selector = Selector.open();

        sc.register(selector, ops);

        while (sc.isConnected()) {
            int result = selector.select();
            if (result == 0) continue;
            Set<SelectionKey> keySet = selector.selectedKeys();
            Iterator<SelectionKey> it = keySet.iterator();

            while (it.hasNext()) {

                SelectionKey sk = it.next();
                it.remove();

                if (sk.isConnectable()) {
                    System.out.println("连接成功");
                } else if (sk.isReadable()) {
                    sc.read(BUFFER);

                    System.out.println(buffer2Str(BUFFER));
                } else if (sk.isWritable()) {
                    str2localBuffer("我也爱你");
                    sc.write(BUFFER);
                }
            }
        }
    }

    public static String buffer2Str(ByteBuffer buffer) {
        buffer.flip();
        byte[] bytes = new byte[buffer.limit()];
        buffer.get(bytes);
        buffer.clear();
        return new String(bytes);
    }

    public static void str2localBuffer(String msg) {
        BUFFER.clear();
        byte[] bytes = msg.getBytes();

        if (bytes.length > 4096) {
            throw new OutOfMemoryError("消息过大");
        }
        BUFFER.put(bytes);
        BUFFER.flip();
    }
}
