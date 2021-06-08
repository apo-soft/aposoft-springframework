package cn.aposoft.netty.basic.buff;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

public class ButeBufOps {
    public static void main(String[] args) {
        ByteBuf buf = Unpooled.buffer(1024);
        for (int i = 0; i < 256; i++) {
            buf.writeByte(i);
        }
        System.out.println("readableBytes:" + buf.readableBytes());
        buf.markReaderIndex();
        for (int i = 0; i < 128; i++) {
            System.out.println(buf.readByte());
        }
        System.out.println("readableBytes:" + buf.readableBytes());
        buf.resetReaderIndex();
        System.out.println("readableBytes:" + buf.readableBytes());
    }
}
