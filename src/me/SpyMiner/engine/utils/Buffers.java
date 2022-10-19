package me.SpyMiner.engine.utils;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;

public class Buffers {

    public static ByteBuffer createByteBuffer(byte[] data) {

        ByteBuffer buffer = ByteBuffer.allocateDirect(data.length).order(ByteOrder.nativeOrder());
        buffer.put(data);
        buffer.flip();

        return buffer;
    }

    public static FloatBuffer createFloatBuffer(float[] data) {

        FloatBuffer buffer = ByteBuffer.allocateDirect(data.length << 2).order(ByteOrder.nativeOrder()).asFloatBuffer();
        buffer.put(data);
        buffer.flip();

        return buffer;
    }

    public static IntBuffer createIntBuffer(int[] data) {

        IntBuffer buffer = ByteBuffer.allocateDirect(data.length << 2).order(ByteOrder.nativeOrder()).asIntBuffer();
        buffer.put(data);
        buffer.flip();

        return buffer;
    }
}