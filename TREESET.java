import java.util.*;

public class TREESET<E> {
    Base<E> set;

    public int size() {
        return set.size();
    }

    public TREESET() {
        this.set = new Base<>();
    }
    public TREESET(Collection<? extends E> c) {
        this.set = new Base<>();
        set.addAll(0, c);
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
     * Q:e is in TREESET; len > 0; len = len` + 1
     */
    public boolean add(E e) {
        if (set.search(e, false) != -1) {
            set.add(set.size(), e);
        }
        set.sort(false);
        return set.search(e, false) != -1;
    }

    /**
     * P: len != 0
     * Q: o is not in TREESET; len = len` - 1
     */
    public boolean remove(Object o) {
        set.remove(set.search(o, false));
        set.sort(false);
        return set.search(o, false) != -1;
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
     * Q: len > 0
     */
    public  boolean addAll(Collection<? extends E> c) {
        boolean temp = set.addAll(0, c);
        set.sort(false);
        return temp;
    }
    /**
     * P: len > 0
     * Q: len_new = index(fromElement) - index(toElement)
     */
    public TREESET<E> subSet(E fromElement, boolean fromInclusive, E toElement,   boolean toInclusive) {
        return new TREESET<>(set.subSet(fromElement, fromInclusive, toElement, toInclusive).collection());
    }
    /**
     * P: len > 0
     * Q: len_new = index(toElement)
     */
    public TREESET<E> headSet(E toElement, boolean inclusive) {
        return new TREESET<>(set.subSet(set.get(0), true, toElement, inclusive).collection());
    }
    /**
     * P: len > 0
     * Q: len_new = set.size() - index(toElement)
     */
    public TREESET<E> tailSet(E fromElement, boolean inclusive) {
        return new TREESET<>(set.subSet(set.get(0), true, set.get(set.size()), inclusive).collection());
    }
    public TREESET<E> subSet(E fromElement, E toElement) {
        return subSet(fromElement, true, toElement, false);
    }
    public TREESET<E> headSet(E toElement) {
        return headSet(toElement, false);
    }
    public TREESET<E> tailSet(E fromElement) {
        return tailSet(fromElement, true);
    }

    public Comparator<? super E> comparator() {
        //тот же вопрос, что и у spliterator
        //непонятно как реализовывать методы этого интерфейса. Создавать вложенный класс и там это делать?
        return null;
    }


    /**
     * P: len != 0
     * Q: out is min
     */
    public E first() {
        return set.get(0);
    }

    /**
     * P: len != 0
     * Q: out is max
     */
    public E last() {
        return set.get(set.size()-1);
    }

    /**
     * P: len != 0
     * Q: out < e
     */
    public E lower(E e) {
        return set.get(set.search(set.getNearest(e, true), false)-1);
    }


    /**
     * P: len != 0
     * Q: out <= e
     */
    public E floor(E e) {
        return set.getNearest(e, true);
    }

    /**
     * P: len != 0
     * Q: out >= e
     */
    public E ceiling(E e) {
        return set.getNearest(e, false);
    }

    /**
     * P: len != 0
     * Q: out > e
     */
    public E higher(E e) {
        return set.get(set.search(set.getNearest(e, true), false)+1);
    }

    /**
     * P: len != 0
     * Q: e is not in set; e is min; len = len' - 1
     */
    public E pollFirst() {
        E e = set.get(0);
        set.remove(set.search(e, false));
        return e;
    }

    /**
     * P: len != 0
     * Q: e is not in set; e is max; len = len' - 1
     */
    public E pollLast() {
        E e = set.get(set.size() - 1);
        set.remove(set.search(e, false));
        return e;
    }
    /**
     * P: true
     * Q: this.len = new.len
     */
    @SuppressWarnings("unchecked")
    public Object clone() {
        Base<E> tempList = set.removeAll();
        this.set.addAll(0, tempList.collection());
        return new TREESET<>(tempList.collection());
    }
}
