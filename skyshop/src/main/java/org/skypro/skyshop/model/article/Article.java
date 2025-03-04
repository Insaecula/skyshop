package org.skypro.skyshop.model.article;
import org.skypro.skyshop.model.search.Searchable;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;
import java.util.stream.Collectors;

public class Article implements Searchable {
    @Override
    public String getName() {
        return "";
    }

    private final UUID id;
    private final String title;
    private String content;
    private String contentType;

    public Article(UUID id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    private final Collection<Article> articles = new ArrayList<>();


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

    public void setContent(String content) {
        this.content = content;
    }


    @Override
    public String getContentType() {
        return "article";
    }

    @Override
    public String getSearchTerm() {
        return "";
    }

    public Collection<Article> getArticles() {
        return articles;
    }

    public Collection<Article> searchArticles(String query) {
        return articles.stream()
                .filter(article -> article.getTitle().toLowerCase().contains(query.toLowerCase())
                        || article.getContent().toLowerCase().contains(query.toLowerCase()))
                .collect(Collectors.toList());
    }
}

