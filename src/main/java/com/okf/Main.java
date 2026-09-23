package com.okf;

import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {

        // 1. Load Markdown files
        MarkdownLoader loader = new MarkdownLoader();
        List<Document> documents = loader.loadDocuments("knowledge");
        System.out.println("Documents loaded: "+ documents.size());

        // 2. Create search engine
        SearchEngine searchEngine = new SearchEngine(documents);

        // 3. Query
        String query = "battery";
        System.out.println("\nQuery: " + query);

        // 4. Measure retrieval time
        long start = System.nanoTime();

        List<SearchResult> results = searchEngine.search(query);

        long end = System.nanoTime();

        // 5. Display results
        System.out.println("\nResults:");

        int rank = 1;

        for (SearchResult result : results) {
            System.out.println(rank + ". "+ result.getDocument().getTitle()+ " | Score: "+ result.getScore());
            rank++;
        }

        // 6. Performance
        double timeMs = (end - start) / 1_000_000.0;

        System.out.println("\nRetrieval time: "+ timeMs + " ms");
    }
}