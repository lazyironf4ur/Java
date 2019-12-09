package nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;


/**
 * @author:Lazy1ron
 * @date:2019/12/8 23:09
 */
public class Server {

    private static final ByteBuffer BUFFER = ByteBuffer.allocate(4096);

    public static void main(String[] args) throws IOException {
        //ServerSocket socket = new ServerSocket();
        //
        //socket.bind(new InetSocketAddress("localhost", 4266));
        //
        //socket.accept();

        ServerSocketChannel ssc = ServerSocketChannel.open();

        ssc.configureBlocking(false);

        Selector selector = Selector.open();

        ssc.register(selector, SelectionKey.OP_ACCEPT);

        ssc.bind(new InetSocketAddress("localhost", 1773));



        System.out.println(selector.keys().iterator().next());

        while (true) {

            int result = selector.select();

            if (result == 0) continue;

            Set<SelectionKey> selectedkey = selector.selectedKeys();

            Iterator<SelectionKey> selectionKeyIterator = selectedkey.iterator();

            while (selectionKeyIterator.hasNext()) {
                SelectionKey sk = selectionKeyIterator.next();
                selectionKeyIterator.remove();

                if (sk.isAcceptable()) {
                    SocketChannel sc = ssc.accept();
                    System.out.println("收到连接");
                    str2localBuffer("我爱你");
                    sc.write(BUFFER);
                    System.out.println("消息发送");
                    sc.configureBlocking(false);
                    sc.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    SocketChannel sre = (SocketChannel) sk.channel();
                    sre.read(BUFFER);
                    System.out.println(buffer2Str(BUFFER));
                } else if (sk.isWritable()) {

                }

            }

        }

    }

    // once invoked, buffer would be clear and return a String obtains the message;

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
