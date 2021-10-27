package com.tapusd.librarymanagement.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

public class BookDTO {
    private Long isbn;
    private String title;
    private Set<Long> authorIds;
    private Long categoryId;

    @NotNull
    public Long getIsbn() {
        return isbn;
    }

    public void setIsbn(Long isbn) {
        this.isbn = isbn;
    }

    @NotBlank
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @NotEmpty
    public Set<Long> getAuthorIds() {
        return authorIds;
    }

    public void setAuthorIds(Set<Long> authorIds) {
        this.authorIds = authorIds;
    }

    @NotNull
    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "BookDTO{" +
                "isbn=" + isbn +
                ", title='" + title + '\'' +
                ", authors=" + authorIds +
                ", categoryId=" + categoryId +
                '}';
    }
}
