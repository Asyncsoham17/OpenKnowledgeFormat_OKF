package com.okf;

public class SearchResult {
    private Document document;
    private int score;
    public SearchResult(Document document, int score){
        this.document = document;
        this.score = score;
    }
    public Document getDocument(){
        return document;
    }
    public int getScore(){
        return score;
    }
}
