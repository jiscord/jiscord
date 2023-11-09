package site.lifix.jiscord.utility;

import java.util.*;

public class SnowflakeList<T> {
    private final Map<Long, T> data = new HashMap<>();

    private List<Long> smallest() {
        List<Long> finalList = new ArrayList<>();
        for (Map.Entry<Long, T> entry : this.data.entrySet()) {
            finalList.add(entry.getKey());
        }
        finalList.sort(Comparator.naturalOrder());
        return finalList;
    }

    private List<Long> largest() {
        List<Long> finalList = this.smallest();
        Collections.reverse(finalList);
        return finalList;
    }

    public SnowflakeList<T> add(long id, T value) {
        this.data.put(id, value);
        return this;
    }

    public SnowflakeList<T> add(String id, T value) {
        return this.add(Long.parseLong(id), value);
    }

    public SnowflakeList<T> remove(long id) {
        this.data.remove(id);
        return this;
    }

    public SnowflakeList<T> remove(String id) {
        return this.remove(Long.parseLong(id));
    }

    public SnowflakeList<T> apply(List<T> values, CustomRunnable<Long, T> conversion) {
        for (T value : values) {
            Long id = conversion.run(value);
            this.add(id, value);
        }
        return this;
    }

    public Map<Long, T> getUnsortedMap() {
        return this.data;
    }

    public List<T> getFromOldest() {
        List<Long> keys = this.smallest();
        List<T> finalList = new ArrayList<>();
        for (Long key : keys) {
            finalList.add(this.data.get(key));
        }
        return finalList;
    }

    public List<T> getFromNewest() {
        List<Long> keys = this.largest();
        List<T> finalList = new ArrayList<>();
        for (Long key : keys) {
            finalList.add(this.data.get(key));
        }
        return finalList;
    }
}
