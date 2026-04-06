package Pract12;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;

public class StatusFile {
    public static void updateStatus(Path file, int index, byte status) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "rw");
             FileChannel channel = raf.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1);
            buffer.put(status);
            buffer.flip();
            channel.position(index);
            channel.write(buffer);
        }
    }
    public static byte readStatus(Path file, int index) throws IOException {
        try (RandomAccessFile raf = new RandomAccessFile(file.toFile(), "r");
             FileChannel channel = raf.getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate(1);
            int bytesRead = channel.read(buffer, index);
            if (bytesRead > 0) {
                buffer.flip();
                return buffer.get();
            } else {
                throw new IOException("Кінець файлу (EOF) або недійсний індекс");
            }
        }
    }
}
