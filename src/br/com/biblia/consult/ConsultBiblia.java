package br.com.biblia.consult;

import br.com.biblia.data.BibliaData;
import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsultBiblia {
    public BibliaData consultarBiblia() {
        Scanner sc = new Scanner(System.in);
        String livro;
        int cap = 0, vers = 0;

        System.out.println("Digite o livro da Bíblia desejado: ");
        livro = sc.nextLine();

        try {
            System.out.println("Digite o capítulo do livro " + livro + " desejado:");
            cap = sc.nextInt();
            System.out.println("Digite o versículo do capítulo " + cap + " de " + livro + " desejado:");
            vers = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Erro: Por favor, insira números válidos para o capítulo e o versículo.");
            return null;
        } finally {
            sc.close();
        }

        String address = "https://bible-api.com/" + livro + "+" + cap + ":" + vers + "?translation=almeida";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(address))
                .build();

        HttpResponse<String> response;
        try {
            response = client.send(request, HttpResponse.BodyHandlers.ofString());
        } catch (IOException | InterruptedException e) {
            System.out.println("Erro: " + e.getMessage());
            return null;
        }

        if (response != null && response.body() != null) {
            return new Gson().fromJson(response.body(), BibliaData.class);
        } else {
            System.out.println("Erro: Resposta nula do servidor");
            return null;
        }
    }
}