package first.example;

public class MyList {
    private boolean readOnly;
    private int size;
    private Object[] elements = new Object[10];

    public MyList() {}

    public MyList(boolean readOnly) {
        this.readOnly = readOnly;
    }
    
    public void add(Object newElement) {
        if (!readOnly) {
            int newSize = size + 1;
            if (newSize > elements.length) {
                Object[] newElements = new Object[elements.length + 10];
                for (int i = 0; i < elements.length; i++) {
                    newElements[i] = elements[i];
                }
                elements = newElements;
            }
            elements[size++] = newElement;
        }
    }

    public int getSize() { return size; }

    int getCapacity() { return elements.length; }
}
