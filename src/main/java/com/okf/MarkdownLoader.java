package com.okf;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class MarkdownLoader {

    public List<Document> loadDocuments(String directoryPath) throws IOException {

        List<Document> documents = new ArrayList<>();
        Path directory = Paths.get(directoryPath);
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(directory, "*.md")) {

            for (Path path : stream) {
                String content = Files.readString(path);
                String title = extractTitle(content);
                Document document = new Document(
                        path.getFileName().toString(),
                        title,
                        content
                );
                documents.add(document);
            }
        }
        return documents;
    }

    private String extractTitle(String content) {

        for (String line : content.split("\\R")) {
            if (line.startsWith("# ")) {
                return line.substring(2).trim();
            }
        }
        return "Untitled";
    }
}