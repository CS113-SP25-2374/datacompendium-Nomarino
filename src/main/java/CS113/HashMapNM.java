package CS113;

import CS113.interfaces.ListIteratorInterface;
import CS113.interfaces.MapInterface;

import java.util.ArrayList;

public class HashMapNM <K,V> implements MapInterface<K,V> {

    private class Entry<K,V> implements MapInterface.Entry<K,V>{
        K key;
        V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return this.key;
        }

        @Override
        public V getValue() {
            return this.value;
        }
        @Override
        public V setValue(V value) {
            return this.value = value;
        }
    }
    LinkedListNM<Entry<K,V>>[] buckets;
    final int BUCKET_SIZE = 16;
    int count;

    public HashMapNM() {
        buckets = new LinkedListNM[BUCKET_SIZE];
        for (int i = 0; i < BUCKET_SIZE; i++) {
            buckets[i] = new LinkedListNM<Entry<K,V>>();
        }
        count = 0;
    }

    @Override
    public int size() {
        return this.count;
    }

    @Override
    public boolean isEmpty() {
        return this.count == 0;
    }

    int hash(K key){
        return key == null ? 0 : key.hashCode() % buckets.length;
    }

    ListIteratorInterface<Entry<K,V>> bucketIterator(K key){
        return buckets[hash(key)].iterator();
    }

    @Override
    public boolean containsKey(K key) {
        int hashCode = key.hashCode();
        LinkedListNM<Entry<K,V>> list = buckets[hash(key)];
        ListIteratorInterface<Entry<K,V>> iterator = bucketIterator(key);
        while (iterator.hasNext()) {
            if (iterator.next().getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < buckets.length; i++) {
            ListIteratorInterface<Entry<K, V>> iterator = buckets[i].iterator();
            while (iterator.hasNext()) {
                if (iterator.next().getValue().equals(value)) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        ListIteratorInterface<Entry<K, V>> iterator = bucketIterator(key);
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        LinkedListNM<Entry<K,V>> bucket = buckets[hash(key)];
        ListIteratorInterface<Entry<K, V>> iterator = bucket.iterator();
        Entry<K, V> entry;
        while (iterator.hasNext()) {
            entry = iterator.next();
            if (entry.getKey().equals(key)) {
                return entry.setValue(value);
            }
        }
        entry = new Entry<>(key, value);
        buckets[hash(key)].add(entry);
        count++;
        return entry.getValue();
    }

    @Override
    public V remove(K key) {
        ListIteratorInterface<Entry<K, V>> iterator = bucketIterator(key);
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.getKey().equals(key)) {
                V value = entry.getValue();
                iterator.remove();
                count--;
                return value;
            }
        }
        return null;
    }

    @Override
    public void clear() {
    for (int i = 0; i < buckets.length; i++) {
        buckets[i].clear();
    }
    }

    @Override
    public ArrayList<K> keySet() {
        return null;
    }

    @Override
    public ArrayList<K> keys() {
        ArrayList<K> keys = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            ListIteratorInterface<Entry<K, V>> iterator = buckets[i].iterator();
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                keys.add(entry.getKey());
            }
        }
        return keys;
    }

    @Override
    public ArrayList<V> values() {
        ArrayList<V> values = new ArrayList<>();
        for (int i = 0; i < buckets.length; i++) {
            ListIteratorInterface<Entry<K, V>> iterator = buckets[i].iterator();
            while (iterator.hasNext()) {
                Entry<K, V> entry = iterator.next();
                values.add(entry.getValue());
            }
        }
        return values;
    }
}
