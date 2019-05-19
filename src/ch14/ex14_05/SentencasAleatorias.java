/*
 * Objetivo: 14.5 (Sentenças aleatórias) Elabore um aplicativo que utiliza geração de números aleatórios para criar frases. Utilize
 * quatro arrays de strings chamados article, noun, verb e preposition. Crie uma frase selecionando uma palavra aleatoriamente de cada array
 * na seguinte ordem: article, noun, verb, preposition, article e noun. À medida que cada palavra é selecionada, concatene-a às primeiras
 * palavras na frase. As palavras devem ser separadas por espaços. Quando a frase final for enviada para saída, ela deve iniciar com uma letra
 * maiúscula e terminar com um ponto. O aplicativo deve gerar e exibir 20 frases.
 * O array de artigos deve conter os artigos "the", "a", "one", "some" e "any"; 
 * o array de substantivos deve conter os substantivos"boy", "girl", "dog", "town" e "car"; 
 * o array de verbos deve conter os verbos "drove", "jumped", "ran", "walked" e "skipped"; 
 * o array de preposições deve conter as preposições "to", "from", "over", "under" e "on".
 * 
 * Autor: Gustavo Alves
 * Data: 30/03/2019
 */

package ch14.ex14_05;

import java.security.SecureRandom;

public class SentencasAleatorias {

	public static void main(String[] args) {
		SecureRandom random = new SecureRandom();

		String[] article = { "the", "a", "one", "some", "any" };
		String[] noun = { "boy", "girl", "dog", "town", "car" };
		String[] verb = { "drove", "jumped", "ran", "walked", "skipped" };
		String[] prepositon = { "to", "from", "over", "under", "on" };

		String[] sentences = new String[20];

		// cria 20 frases
		for (int i = 0; i < 20; i++) {
			String art = article[random.nextInt(5)];
			// deixa a primeira letra maiúscula
			art = art.replaceFirst(art.substring(0, 1), art.substring(0, 1).toUpperCase());

			sentences[i] = String.format("%s %s %s %s %s %s.", art, noun[random.nextInt(5)], verb[random.nextInt(5)],
					prepositon[random.nextInt(5)], article[random.nextInt(5)], noun[random.nextInt(5)]);
		}

		// exibe as frases
		for (int i = 0; i < sentences.length; i++)
			System.out.printf("%d° Frase: %s%n", i + 1, sentences[i]);

	}
}
