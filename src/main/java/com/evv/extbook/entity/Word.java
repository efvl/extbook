package com.evv.extbook.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "word")
public class Word extends BaseUniqueEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Column(name = "page_num")
    private Long pageNum;

    @Column(name = "line_num")
    private Long lineNum;

    @Column(name = "word_num")
    private Long wordNum;

    @Column(name = "txt_content", length = 128)
    private String txtContent;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 20)
    private WordStatus status;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Long getPageNum() {
        return pageNum;
    }

    public void setPageNum(Long pageNum) {
        this.pageNum = pageNum;
    }

    public Long getLineNum() {
        return lineNum;
    }

    public void setLineNum(Long lineNum) {
        this.lineNum = lineNum;
    }

    public Long getWordNum() {
        return wordNum;
    }

    public void setWordNum(Long wordNum) {
        this.wordNum = wordNum;
    }

    public String getTxtContent() {
        return txtContent;
    }

    public void setTxtContent(String txtContent) {
        this.txtContent = txtContent;
    }

    public WordStatus getStatus() {
        return status;
    }

    public void setStatus(WordStatus status) {
        this.status = status;
    }

}
