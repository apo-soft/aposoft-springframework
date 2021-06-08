package cn.aposoft.nio.buffer;

import java.nio.CharBuffer;

public class BufferDemo {
    public static void main(String[] args) {
        charArrayBuffer();
        if (truen()) {
            return;
        }
//        ByteBuffer buffer = ByteBuffer.allocate(100);
        CharBuffer charBuffer = CharBuffer.allocate(100);
        final String hello = "hello";
        charBuffer.append(hello);
        System.out.println("charBuffer.remaining:" + charBuffer.remaining());
        charBuffer.flip();
        final int size = hello.length();
        char[] carray = new char[size];
        if (charBuffer.length() >= size) {
            System.out.println("char buffer size:" + charBuffer.length() +
                    ",position:" + charBuffer.position() + ",remaining:" + charBuffer.remaining());
            charBuffer.mark();
            charBuffer.get(carray);
            charBuffer.reset();
            System.out.println(new String(carray));
        }
        charBuffer.get(carray, 0, size);
        System.out.println(new String(carray));

    }

    private static boolean truen() {
        return true;
    }

    static void charArrayBuffer() {
        char[] myArray = new char[100];
        CharBuffer charbuffer = CharBuffer.wrap(myArray, 12, 42);
        System.out.println("char buffer:" + charbuffer.capacity() + ",limit;" + charbuffer.limit() + ",position:" + charbuffer.position() + ",remaining:" + charbuffer.remaining() + ",length:" + charbuffer.length());
        charbuffer.put("a");
        System.out.println("char buffer:" + charbuffer.capacity() + ",limit;" + charbuffer.limit() + ",position:" + charbuffer.position() + ",remaining:" + charbuffer.remaining() + ",length:" + charbuffer.length());
        //charbuffer.flip();
        System.out.println("char buffer:" + charbuffer.capacity() + ",limit;" + charbuffer.limit() + ",position:" + charbuffer.position() + ",remaining:" + charbuffer.remaining() + ",length:" + charbuffer.length());
        // 直接get，会继续向后读，而实际读取的是0 position++
        System.out.println("get cbuffer:" + ((int) charbuffer.get()));
        System.out.println("char buffer:" + charbuffer.capacity() + ",limit;" + charbuffer.limit() + ",position:" + charbuffer.position() + ",remaining:" + charbuffer.remaining() + ",length:" + charbuffer.length());

    }
}
