package modulaireMobiliteit_Prototype.domain;

import java.util.Arrays;

public class MapImage {
    private final byte[] imageData;
    private final String format; // Bijvoorbeeld "png" of "jpeg"

    public MapImage(byte[] imageData, String format) {
        if (imageData == null || imageData.length == 0) {
            throw new IllegalArgumentException("Image data cannot be null or empty.");
        }
        this.imageData = Arrays.copyOf(imageData, imageData.length); // Immutable copy
        this.format = format;
    }

    public byte[] getImageData() {
        return Arrays.copyOf(imageData, imageData.length);
    }

    public String getFormat() {
        return format;
    }

    @Override
    public String toString() {
        return "MapImage{" +
                "format='" + format + '\'' +
                ", size=" + imageData.length + " bytes" +
                '}';
    }
}
