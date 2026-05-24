package prob2;

import java.util.ArrayList;

/**
 * Dictionary implementation using Java ArrayList.
 *
 * @param <Key> key type
 * @param <E>   element type
 * 
 * @author Yan Liu
 */
public class ArrayListDictionary<Key, E>
        implements ADTDictionary<Key, E> {

    /**
     * Internal record structure.
     */
    private record KVPair<Key, E>(
            Key key,
            E value
    ) {}

    /**
     * Storage container.
     */
    private final ArrayList<KVPair<Key, E>> list;

    /**
     * Constructor.
     */
    public ArrayListDictionary() {
        list = new ArrayList<>();
    }

    /**
     * Remove all entries.
     */
    @Override
    public void clear() {
        list.clear();
    }

    /**
     * Insert key-value pair.
     */
    @Override
    public void insert(Key k, E e) {

        list.add(
        		new KVPair<>(k, e)
        );
    }

    /**
     * Remove by key.
     */
    @Override
    public E remove(Key k) {

        for (int i = 0;
             i < list.size();
             i++) {

            if (list.get(i)
                    .key()
                    .equals(k)) {

                E value =
                        list.get(i)
                                .value();

                list.remove(i);

                return value;
            }
        }

        return null;
    }

    /**
     * Remove arbitrary element.
     */
    @Override
    public E removeAny() {

        if (list.isEmpty()) {
            return null;
        }

        return list.remove(0)
                   .value();
    }

    /**
     * Find by key.
     */
    @Override
    public E find(Key k) {

        for (KVPair<Key, E> pair
                : list) {

            if (pair.key()
                    .equals(k)) {

                return pair.value();
            }
        }

        return null;
    }

    /**
     * Number of records.
     */
    @Override
    public int size() {
        return list.size();
    }

    /**
     * String representation.
     */
    @Override
    public String toString() {

        StringBuilder sb =
                new StringBuilder();

        sb.append("[\n");

        for (KVPair<Key, E> pair
                : list) {

            sb.append("  ")
              .append(pair.key())
              .append(" -> ")
              .append(pair.value())
              .append("\n");
        }

        sb.append("]");

        return sb.toString();
    }
}