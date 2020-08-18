package com.jack.rookiepractice.bytebuffer;

import java.nio.ByteBuffer;

/**
 * @author Jack
 * @ClassName ByteBufferTest
 * Created By Jack on 2020/8/18
 * @date 2020/8/18 16:35
 * @Description:
 * ByteBuffer包含几个基本的属性：
 * position：当前的下标位置，表示进行下一个读写操作时的起始位置；
 * limit：结束标记下标，表示进行下一个读写操作时的（最大）结束位置；
 * capacity：该ByteBuffer容量；
 * mark: 自定义的标记位置；
 * mark <= position <= limit <= capacity
 *
 *
 *
 */
public class ByteBufferTest {
    public static void main(String[] args) {
        //1,ByteBuffer初始化
        ByteBuffer byteBuffer1 = ByteBuffer.allocate(16);
        ByteBuffer byteBuffer2 = ByteBuffer.wrap(new byte[16]);
        //System.out.println("position="+byteBuffer2.position());
        //System.out.println("limit="+byteBuffer2.limit());
        //System.out.println("capacity="+byteBuffer2.capacity());
        //修改position和limit
        //byteBuffer2.position(0);
        //byteBuffer2.limit(16);


        //*******************************************************
        //2,ByteBuffer写入数据
        //通过put(byte b)或put(byte[] b)方法向ByteBuffer中添加一个字节或一个字节数组。ByteBuffer也方便地提供了几种写入基本类型的put方法：putChar(char val)、putShort(short val)、putInt(int val)、putFloat(float val)、putLong(long val)、putDouble(double val)。执行这些写入方法之后，就会以当前的position位置作为起始位置，写入对应长度的数据，并在写入完毕之后将position向后移动对应的长度
        byte d1= 8;
        byteBuffer1.put(d1);
        byteBuffer1.putInt(33);
        System.out.println("position="+byteBuffer1.position());
        System.out.println("limit="+byteBuffer1.limit());
        System.out.println("capacity="+byteBuffer1.capacity());

        //3,ByteBuffer读取数据
        //getChar()、getShort()、getInt()、getFloat()、getLong()、getDouble()则读取相应字节数的数据，并转换成对应的数据类型。如getInt()即为读取4个字节，返回一个Int
        byteBuffer1.flip();
        System.out.println("position="+byteBuffer1.position());
        System.out.println("limit="+byteBuffer1.limit());
        System.out.println("capacity="+byteBuffer1.capacity());
        byte b2 = byteBuffer1.get();
        System.out.println("b2="+b2);
        int b3 = byteBuffer1.getInt();
        System.out.println("b3="+b3);
        System.out.println("position="+byteBuffer1.position());
        System.out.println("limit="+byteBuffer1.limit());
        System.out.println("capacity="+byteBuffer1.capacity());

        //4,字节序处理 buffer.order(ByteOrder.LITTLE_ENDIAN)
        //5，继续写入 compact()方法
    }
}
