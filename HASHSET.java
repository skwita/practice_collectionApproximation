import java.util.*;
public class HASHSET<E>{
    Base<E> set;

    public HASHSET() {
        set = new Base<>();
    }
    public HASHSET(Collection<? extends E> c) {
        set = new Base<>();
        set.addAll(0, c);
    }

    /**
     * P: true
     * Q: true
     */
    public int size() {
        return set.size();
    }

    /**
     * P: true
     * Q: true
     */
    public boolean isEmpty() {
        return set.size() == 0;
    }

    /**
     * P: true
     * Q: true
     */
    public boolean contains(Object o) {
        return set.search(o, false) != -1;
    }

    /**
     * P: true
     * Q: e is in set; len = len` + 1
     */
    public void add(E e) {
        if (set.search(e, false) != -1) {
            set.add(set.size(), e);
        }
    }


    /**
     * P: e is in set; len != 0
     * Q: e is not in set; len = len` - 1
     */
    public boolean remove(E e) {
        set.remove(set.search(e, false));
        return set.search(e, false) != -1;
    }

    /**
     * P: true
     * Q: len = 0
     */
    public void clear() {
        set.removeAll();
    }


    /**
     * P: true
     * Q: this.len = new.len
     */
    public Object clone() {
        Base<E> tempList = set.removeAll();
        this.set.addAll(0, tempList.collection());
        return new HASHSET<>(tempList.collection());
    }

    //не совсем понял, что эти методы делают и как их аппроксимировать поэтому.
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {}
    private void readObject(java.io.ObjectInputStream s) throws java.io.IOException {}

    public Spliterator<E> spliterator() {
        return null;
        //непонятно как реализовывать методы этого интерфейса. Создавать вложенный класс и там это делать?
    }

    public Object[] toArray() {
        return new Object[0];
        //непонятно как это сделать. Опять расширять базис дополнительным методом?
    }
    public <T> T[] toArray(T[] a) {
        return a;
    }
}
