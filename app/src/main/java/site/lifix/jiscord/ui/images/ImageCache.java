package site.lifix.jiscord.ui.images;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import site.lifix.jiscord.utility.Utility;

import java.util.ArrayList;
import java.util.List;

public class ImageCache {
    private static final long IMAGE_REFRESH_TIME_MS = 5 * 60 * 1000;
    private static final byte[] PLACEHOLDER_IMAGE = Utility.fileToByteArray("images/blank.png");
    private static final List<ImageRefreshData> IMAGE_TIMINGS = new ArrayList<>();

    public static void startImageRefreshThread() {
        new Thread(() -> {
            while (true) {
                try {
                    ImageRefreshData[] safeImageTimings = IMAGE_TIMINGS.toArray(new ImageRefreshData[0]);
                    for (ImageRefreshData data : safeImageTimings) {
                        if (data.getLastRefreshed() < System.currentTimeMillis() - IMAGE_REFRESH_TIME_MS) {
                            System.out.println("Refreshing on " + data.getUrl());
                            data.setData(Utility.urlToByteArray(data.getUrl()));
                            data.setLastRefreshed(System.currentTimeMillis());
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static byte[] getImageData(String url) {
        ImageRefreshData refreshData = new ImageRefreshData(-1, url, new byte[0]);

        for (ImageRefreshData data : IMAGE_TIMINGS) {
            if (data.getUrl().equals(url)) {
                if (data.getData().length > 0) {
                    return data.getData();
                } else {
                    return PLACEHOLDER_IMAGE;
                }
            }
        }

        IMAGE_TIMINGS.add(refreshData);
        if (refreshData.getData().length > 0) {
            return refreshData.getData();
        } else {
            return PLACEHOLDER_IMAGE;
        }
    }

    @Getter
    @Setter
    @AllArgsConstructor
    public static class ImageRefreshData {
        private long lastRefreshed;
        private String url;
        private byte[] data;
    }
}
