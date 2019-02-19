import java.util.*;

public class MyHashMap<K, V> implements Map<K, V> {

    // average number of entries per bucket before we grow the map
    private static final double ALPHA = 1.0;
    // average number of entries per bucket before we shrink the map
    private static final double BETA = .25;

    // resizing factor: (new size) = (old size) * (resize factor)
    private static final double SHRINK_FACTOR = 0.5, GROWTH_FACTOR = 2.0;

    private static final int MIN_BUCKETS = 16;

    // array of buckets
    protected LinkedList<Entry>[] buckets;
    private int size = 0;

    public MyHashMap() {
        initBuckets(MIN_BUCKETS);
    }

    public class Entry implements Map.Entry<K, V> {
        private K key;
        private V value;

        Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V newValue) {
            value = newValue;
            return value;
        }
    }

    /**
     * given a key, return the bucket where the `K, V` pair would be stored if it were in the map.
     */
    private LinkedList<Entry> chooseBucket(Object key) {
        // TODO
        // hint: use key.hashCode() to calculate the key's hashCode using its built in hash function
        // then use % to choose which bucket to return.
<<<<<<< HEAD
        //System.out.print(buckets);

        int idx = key.hashCode() % buckets.length;
        return buckets[idx];
=======
        return null;
>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    /**
     * return true if key is in map
     */
    @Override
    public boolean containsKey(Object key) {
        // TODO
<<<<<<< HEAD
        LinkedList<Entry> bucket = chooseBucket(key);
        for(int i = 0; i < bucket.size(); i++) {
            if (bucket.peekFirst().key .equals(key)) {
                return true;
            }
            Entry temp = bucket.peekFirst();
            bucket.removeFirst();
            bucket.addLast(temp);
        }
=======
>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
        return false;
    }

    /**
     * return true if value is in map
     */
    @Override
    public boolean containsValue(Object value) {
        // TODO
<<<<<<< HEAD
        for(int i = 0; i < buckets.length; i++){
            for(int j = 0; j < buckets[i].size(); j++) {
                if (buckets[i].get(j).value == value) {
                    return true;
                }
            }
        }
=======
>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
        return false;
    }

    @Override
    public V get(Object key) {
        // TODO
<<<<<<< HEAD
        LinkedList<Entry> bucket = chooseBucket(key);
        for(int i = 0; i < bucket.size(); i++) {
            if (bucket.peekFirst().key .equals(key)) {
                return bucket.peekFirst().value;
            }
            Entry temp = bucket.peekFirst();
            bucket.removeFirst();
            bucket.addLast(temp);
        }
=======
>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
        return null;
    }

    /**
     * add a new key-value pair to the map. Grow if needed, according to `ALPHA`.
     * @return the value associated with the key if it was previously in the map, otherwise null.
     */
    @Override
    public V put(K key, V value) {
        // TODO: Complete this method
        // hint: use chooseBucket() to determine which bucket to place the pair in
<<<<<<< HEAD
        // hint: use rehash() to appropriately grow the hashmap if
        if(size  > buckets.length * ALPHA  ){rehash(GROWTH_FACTOR);}
        V val = null;

        if (containsKey(key)){
             val = remove(key);
        }
        LinkedList<Entry> bucket = chooseBucket(key);
        Entry temp = new Entry(key , value);
        bucket.add(temp);
        size++;
        return val ;
=======
        // hint: use rehash() to appropriately grow the hashmap if needed
        return null;
>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
    }

    /**
     * Remove the key-value pair associated with the given key. Shrink if needed, according to `BETA`.
     * Make sure the number of buckets doesn't go below `MIN_BUCKETS`. Do nothing if the key is not in the map.
     * @return the value associated with the key if it was in the map, otherwise null.
     */
    @Override
    public V remove(Object key) {
        // TODO
        // hint: use chooseBucket() to determine which bucket the key would be
        // hint: use rehash() to appropriately grow the hashmap if needed
<<<<<<< HEAD
        if(size < buckets.length * BETA ){rehash(SHRINK_FACTOR);}
        LinkedList<Entry> bucket = chooseBucket(key);
        for(int i = 0; i < bucket.size(); i++) {
            if (bucket.peekFirst().key .equals(key)) {
                V val = bucket.peekFirst().value;
                bucket.removeFirst();
                size--;
                return val;
            }
            Entry temp = bucket.peekFirst();
            bucket.removeFirst();
            bucket.addLast(temp);
        }

=======
>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Map.Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /**
     * Changes the number of buckets and rehashes the existing entries.
     * If growthFactor is 2, the number of buckets doubles. If it is 0.25,
     * the number of buckets is divided by 4.
     */
    private void rehash(double growthFactor) {
        // TODO
        // hint: once you have removed all values from the buckets, use put(k, v) to add them back in the correct place
<<<<<<< HEAD
        LinkedList<Entry> temp = new LinkedList<>();
        for(int i = 0; i < buckets.length; i++){
            for(int j = 0; j < buckets[i].size(); j++) {
                temp.add(buckets[i].get(j));
            }
        }

        int newsize = (int) (buckets.length * growthFactor);
        if (newsize < 16){newsize = 16;}
        initBuckets(newsize);
        size = 0;
        while(!temp.isEmpty()){
            put(temp.getFirst().key,temp.getFirst().value);
            temp.removeFirst();
        }




=======
>>>>>>> 170e3eaa258ce07b5f451e12f0bc2740ef342c15
    }

    private void initBuckets(int size) {
        buckets = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            buckets[i] = new LinkedList<>();
        }
    }

    public void clear() {
        initBuckets(buckets.length);
        size = 0;
    }

    @Override
    public Set<K> keySet() {
        Set<K> keys = new HashSet<>();
        for (Map.Entry<K, V> e : entrySet()) {
            keys.add(e.getKey());
        }
        return keys;
    }

    @Override
    public Collection<V> values() {
        Collection<V> values = new ArrayList<>();
        for (Map.Entry<K, V> e : entrySet()) {
            values.add(e.getValue());
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new HashSet<>();
        for (LinkedList<Entry> map : buckets) {
            set.addAll(map);
        }
        return set;
    }
}
