package nio;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


/**
 * @author:Lazy1ron
 * @date:2019/12/6 21:19
 */
public class ReadAndWrite {

    private static final String FILE_PATH = "D:\\mysql.txt";


    private ByteBuffer buffer = ByteBuffer.allocate(128);

    private RandomAccessFile file = new RandomAccessFile(FILE_PATH, "rw");

    public ReadAndWrite() throws FileNotFoundException {
    }


    public static void main(String[] args) throws IOException {
        String news = "i'm lazy1ron";

        ReadAndWrite raw = new ReadAndWrite();

        FileChannel fc = raw.file.getChannel();
        // 读取文件的内容，写入buffer中
        fc.read(raw.buffer);


        // 使原本的limit{default 128} = position{内容大小}, 并使position归零 mark = -1；
        raw.buffer.flip();
        byte[] bytes = new byte[raw.buffer.limit()];

        // 将bytes.length 的内容 写进 bytes中
        raw.buffer.get(bytes);

        System.out.println("文件内容: " + new String(bytes));

        // 并不会擦除buffer中的内容，而是重置buffer的limit、position、mark
        raw.buffer.clear();

        raw.buffer.put(news.getBytes());

        // flip() 告诉channel操作buffer的界限
        raw.buffer.flip();

        fc.write(raw.buffer);

        fc.close();

        raw.file.close();

    }
}
