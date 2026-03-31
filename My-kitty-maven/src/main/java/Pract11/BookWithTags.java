package Pract11;

import java.util.List;

public class BookWithTags {
    private String title;
    private List<String> tags;

    public BookWithTags(String title, List<String> tags) {
        this.title = title;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getTags() {
        return tags;
    }

    @Override
    public String toString() {
        return "BookWithTags(" +
                "title = '" + title +
                ", tags = " + tags +
                ')';
    }
}
