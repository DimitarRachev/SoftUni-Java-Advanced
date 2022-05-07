package JavaAdvanced.p14IteratorsandComparatorsLab.p01Book;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Book {
    private String title;
    private int year;
    private List<String> authors;

    public Book(String title, int year, String... name) {
        this.title = title;
        this.year = year;
        addAuthors(name);
    }

    private void addAuthors(String[] name) {
        this.authors = new ArrayList<>();
        if (name.length > 0) {
            this.authors.addAll(Arrays.asList(name));
        }
    }

    public String getTitle() {
        return title;
    }

    private void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    private void setYear(int year) {
        this.year = year;
    }

    public List<String> getAuthors() {
        return authors;
    }

    private void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}
