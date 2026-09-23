package com.okf;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SearchEngine {

    private List<Document> documents;
    public SearchEngine(List<Document> documents) {
        this.documents = documents;
    }

    public List<SearchResult> search(String query) {
        List<SearchResult> results = new ArrayList<>();
        String[] queryTerms = query.toLowerCase().split("\\s+");
        for (Document document : documents) {
            String content = document.getContent().toLowerCase();
            int score = 0;
            for(String term: queryTerms)
            {
                if(content.contains(term))
                {
                    score++;
                }
            }
            if(score>0)
            {
                results.add(new SearchResult(document, score));
            }
        }
        results.sort(Comparator.comparingInt(SearchResult::getScore).reversed());
        return results;
    }
}