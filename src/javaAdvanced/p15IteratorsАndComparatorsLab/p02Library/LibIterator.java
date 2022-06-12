package javaAdvanced.p15IteratorsАndComparatorsLab.p02Library;

import java.util.Iterator;
import java.util.List;

public  class LibIterator implements Iterator<Book> {
   private  int pointer = 0;
   private List<Book> books;

   public LibIterator(List<Book> books) {
       this.books = books;
   }
    @Override
    public boolean hasNext() {
        return pointer < books.size();

    }

    @Override
    public Book next() {
        return books.get(pointer++);
    }
}
