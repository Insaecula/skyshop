package org.skypro.skyshop.model.article;
import org.skypro.skyshop.model.search.Searchable;
import java.util.UUID;

public class Article implements Searchable{
    @Override
    public String getName() {
        return "";
    }
//
    private final UUID id;
    private final String title;
    private final String content;

    public Article(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }



    @Override
    public String getContentType() {
        return "article";
    }
}

