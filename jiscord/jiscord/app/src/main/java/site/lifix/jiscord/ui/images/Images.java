package site.lifix.jiscord.ui.images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.lwjgl.BufferUtils;
import org.lwjgl.opengl.GL11;
import org.lwjgl.stb.STBImage;
import org.lwjgl.system.MemoryUtil;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

public class Images {
    @Getter
    @Setter
    @AllArgsConstructor
    public static class ImageData {
        private final boolean success;
        private final byte[] data;
        private final int width;
        private final int height;
        private final int textureId;
    }

    public static ImageData loadTexture(byte[] imageData, int imageWidth, int imageHeight) {
        try {
            if (imageData == null) {
                return new ImageData(false, new byte[0], imageWidth, imageHeight, -1);
            }

            IntBuffer imageWidthBuffer = BufferUtils.createIntBuffer(1);
            IntBuffer imageHeightBuffer = BufferUtils.createIntBuffer(1);
            IntBuffer imageChannelsBuffer = BufferUtils.createIntBuffer(1);

            ByteBuffer imageDataBuffer = MemoryUtil.memAlloc(imageData.length);
            imageDataBuffer.put(imageData);
            imageDataBuffer.flip();

            ByteBuffer imageBuffer = STBImage.stbi_load_from_memory(imageDataBuffer,
                    imageWidthBuffer, imageHeightBuffer, imageChannelsBuffer, 4);

            String failureReason = STBImage.stbi_failure_reason();
            if (failureReason != null) {
                System.out.println("STB Failure: " + failureReason);
            }

            if (imageBuffer != null) {
                int width = imageWidthBuffer.get();
                int height = imageHeightBuffer.get();

                int imageTexture = GL11.glGenTextures();

                GL11.glEnable(GL11.GL_BLEND);
                GL11.glEnable(GL11.GL_TEXTURE_2D);
                GL11.glBindTexture(GL11.GL_TEXTURE_2D, imageTexture);

                // Setup filtering parameters for display
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MIN_FILTER, GL11.GL_LINEAR);
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_MAG_FILTER, GL11.GL_LINEAR);
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_CLAMP);
                GL11.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_CLAMP);

                // Upload pixels into texture
                GL11.glTexImage2D(GL11.GL_TEXTURE_2D, 0, GL11.GL_RGBA,
                        width, height, 0, GL11.GL_RGBA, GL11.GL_UNSIGNED_BYTE, imageBuffer);

                STBImage.stbi_image_free(imageBuffer);

                return new ImageData(true, imageData, width, height, imageTexture);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new ImageData(false, new byte[0], imageWidth, imageHeight, -1);
    }
}
