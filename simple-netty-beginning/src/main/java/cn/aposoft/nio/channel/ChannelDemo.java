package cn.aposoft.nio.channel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 * use file channel
 */
public class ChannelDemo {
    public static void main(String[] args) throws IOException {
        Channel c = null;
        FileOutputStream output = new FileOutputStream("d:/a.txt");

        FileChannel fileChannel = output.getChannel();
        byte[] srcba = "this is a text message".getBytes(StandardCharsets.UTF_8);
        ByteBuffer src = ByteBuffer.wrap(srcba);
        System.out.println("size:" + src.limit() + ",src.position:" + src.position());
        fileChannel.write(src);
        fileChannel.close();
        output.close();
        FileInputStream input = new FileInputStream("d:/a.txt");
        FileChannel inputChannel = input.getChannel();
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int length = inputChannel.read(readBuffer);
        if (length > 0) {
            System.out.println(new String(readBuffer.array(), StandardCharsets.UTF_8));
        }
        inputChannel.close();
        input.close();
    }
}
