package com.okf;

import java.util.ArrayList;
import java.util.List;

public class SearchEngine {

    private List<Document> documents;
    public SearchEngine(List<Document> documents) {
        this.documents = documents;
    }

    public List<Document> search(String query) {

        List<Document> results = new ArrayList<>();
        String queryLower = query.toLowerCase();
        for (Document document : documents) {
            String contentLower = document.getContent().toLowerCase();
            if (contentLower.contains(queryLower)) {
                results.add(document);
            }
        }
        return results;
    }
}