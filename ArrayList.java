/**
 * Custom ArrayList implementation
 * @author Isaac Meltsner
 */
public class ArrayList<T> implements List<T> {
    T[] arr;
    int size;

    public ArrayList() {
        size = 0;
        arr = (T[]) new Object[8];
    }

    public T get(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        return arr[pos];
    }

    public int size() {
        return size;
    }

    public boolean add(T item) {
        if (size == arr.length) {
            grow_array();
        }
        arr[size++] = item;
        return true;
    }

    public void add(int pos, T item) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == arr.length) {
            grow_array();
        }
        for (int i = size; i > pos; i--) {
            arr[i] = arr[i-1];
        }
        arr[pos] = item;
        ++size;
    }

    public T remove(int pos) {
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException();
        }
        T temp = arr[pos];
        if (pos == size - 1) {
            arr[pos] = null;
            size--;
            return temp;
        }
        for (int i = pos; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
        }
        size--;
        return temp;
    } 

    public Iterator<T> iterator() {
        return new ALIterator<T>();
    }

    private void grow_array() {
        T[] new_arr = (T[]) new Object[arr.length * 2];
        for (int i = 0; i < arr.length; i++) {
            new_arr[i] = arr[i];
        }
        arr = new_arr;
    }

    private class ALIterator<T> implements Iterator<T> {
        private int nextIndex = 0;
    
        public boolean hasNext() {
            return nextIndex < size && nextIndex >= 0;
        }
    
        public T next() {
            return (T) arr[nextIndex++];
        }
    }
}