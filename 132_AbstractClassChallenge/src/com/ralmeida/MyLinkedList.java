package com.ralmeida;

public class MyLinkedList implements NodeList {

    private MyListItem root = null;

    public MyLinkedList(MyListItem root) {
        this.root = root;
    }

    @Override
    public MyListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(MyListItem newItem) {
        if(this.root == null){
            // list is empty, so this item become the root
            this.root = newItem;
            return true;
        }

        MyListItem currentItem = this.root;

        while(currentItem != null){
            int comparison = (currentItem.compareTo(newItem));
            if(comparison<0){
                // newItem is greater, move to next
                if(currentItem.next() != null){
                    currentItem = currentItem.next();
                } else {
                    // there is no next, insert at end
//                    currentItem.setNext(newItem);
//                    newItem.setPrevious(currentItem);
                    currentItem.setNext(newItem).setPrevious(currentItem);
                    return true;
                }
            } else if (comparison > 0){
                // newItem is less, insert before
                if(currentItem.previous() != null){
                    currentItem.previous().setNext(newItem);
                    newItem.setPrevious(currentItem.previous());
                    newItem.setNext(currentItem);
                    currentItem.setPrevious(newItem);
                } else {
                    // the node with a previous is thr root
                    newItem.setNext(this.root);
                    this.root.setPrevious(newItem);
                    this.root = newItem;
                }
                return true;
            } else {
                // equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(MyListItem item) {
        if(item != null){
            System.out.println("Deleting item " + item.getValue());
        }

        MyListItem currentItem = this.root;
        while(currentItem != null){
            int comparison = currentItem.compareTo(item);
            if(comparison == 0){
                // found item to delete
                if(currentItem == this.root){
                    this.root = currentItem.next();
                } else {
                    currentItem.previous().setNext(currentItem.next());
                    if(currentItem.next() != null){
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0){
                currentItem = currentItem.next();
            } else { // comparison > 0
                // we are at an item greater  than one to be deleted
                // so the item is not in the list
                return false;
            }
        }
        // reached end of the list without finding item to delete
        return false;
    }

    @Override
    public void traverse(MyListItem root) {

        if(root == null){
            System.out.println("The list is empty");
        } else {
            while(root != null){
                System.out.println(root.getValue());
                root = root.next();
            }
        }
    }
}
