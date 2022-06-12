package javaAdvanced.p15IteratorsАndComparatorsLab.p02Library;

import java.util.Iterator;
import java.util.List;

public class Library implements Iterable<Book> {
    private List<Book>books;

    public Iterator<Book> iterator() {
        return new LibIterator(books);
    }

    public  int getSize() {
        return books.size();
    }

    public void add(Book book) {
        books.add(book);
    }

    public Book get(int index) {
        return books.get(index);
    }
}
