package br.com.biblia.data;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BibliaData {
    private String reference;
    private List<Main> verses;
    private String text;
    private String translation_id;
    private String translation_name;
    private String translation_note;

    @Getter
    @Setter
    public static class Main {
        private String book_name;
        private int chapter;
        private int verse;
        private String text;
    }

    @Override
    public String toString() {
        StringBuilder versesText = new StringBuilder();
        for (Main verse : verses) {
            versesText.append("Nome do livro: ").append(verse.book_name)
                    .append(", Capítulo: ").append(verse.chapter)
                    .append(", Verso: ").append(verse.verse)
                    .append(", Texto: ").append(verse.text).append("\n");
        }
        return versesText.toString();
    }

}