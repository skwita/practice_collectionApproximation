import java.util.*;

public class LINKEDHASHSET<E> {
    int len;
    float loadFactor;
    int initialCapacity;
    Base<E> set;


    public LINKEDHASHSET(int initialCapacity, float loadFactor) {
        set = new Base<>();
        this.loadFactor = loadFactor;
        this.initialCapacity = initialCapacity;
    }

    public LINKEDHASHSET(int initialCapacity) {
        set = new Base<>();
        this.loadFactor = .75f;
        this.initialCapacity = initialCapacity;
    }

    public LINKEDHASHSET() {
        set = new Base<>();
        this.loadFactor = .75f;
        this.initialCapacity = 16;
    }

    public LINKEDHASHSET(Collection<? extends E> c) {
        set = new Base<>();
        this.loadFactor = .75f;
        this.initialCapacity = 16;
        set.addAll(0, c);
    }

    public Spliterator<E> spliterator() {
        //непонятно как реализовывать методы этого интерфейса. Создавать вложенный класс и там это делать?
        return null;
    }
}
