package first.example;

// Adapted from "Refactoring to Patterns" by Joshua Kerievsky
public class MyList {
    private boolean readOnly;
    private int size;
    private Object[] elements = new Object[10];

    public MyList() {
    }

    public MyList(Object[] elements) {
        this.elements = elements;
        readOnly = true;
    }

    public void add(Object newElement) {
        if (readOnly) {
            return;
        }
        if (notEnoughCapacity()) {
            increaseCapacity();
        }
        addElement(newElement);
    }

    private void addElement(Object element) {
        elements[size++] = element;
    }

    private void increaseCapacity() {
        Object[] newElements = new Object[elements.length + 10];
        for (int i = 0; i < elements.length; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    private boolean notEnoughCapacity() {
        return size + 1 > elements.length;
    }

    int getSize() {
        return size;
    }

    int getCapacity() {
        return elements.length;
    }
}