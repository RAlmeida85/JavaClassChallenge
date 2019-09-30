package com.ralmeida;

public class Node extends MyListItem {
    public Node(Object value) {
        super(value);
    }

    @Override
    MyListItem next() {
        return this.rightLink;
    }

    @Override
    MyListItem setNext(MyListItem item) {
        this.rightLink = item;
        return this.rightLink;
    }

    @Override
    MyListItem previous() {
        return this.leftLink;
    }

    @Override
    MyListItem setPrevious(MyListItem item) {
        this.leftLink = item;
        return this.leftLink;
    }

    @Override
    int compareTo(MyListItem item) {
        if(item != null){
            return ((String)super.getValue()).compareTo((String)item.getValue());
        } else {
            return -1;
        }
    }
}
