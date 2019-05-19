/*
 * Objetivo: 14.25 (Projeto: um gerador de palavras cruzadas) A maioria das pessoas já brincou de palavras cruzadas, mas poucos tentaram gerar um
 * jogo de palavras cruzadas. Gerar um jogo de palavras cruzadas é sugerido aqui como um projeto de manipulação de string que requer
 * bastante sofisticação e esforço.
 * Há muitas questões que o programador deve resolver para que até mesmo o mais simples aplicativo gerador de palavras cruzadas funcione.
 * Por exemplo, como você representa a grade das palavras cruzadas dentro do computador? Você deve utilizar uma série de strings ou
 * arrays bidimensionais?
 * O programador precisa de uma fonte de palavras (isto é, um dicionário computadorizado) que possa ser referenciado diretamente pelo
 * aplicativo. De que forma essas palavras devem ser armazenadas para facilitar as complexas manipulações requeridas pelo aplicativo?
 * Se você for realmente ambicioso, vai querer gerar a parte de pistas do quebra-cabeça, em que breves dicas para palavras na horizontal
 * e na vertical são impressas. Meramente imprimir uma versão da parte em branco do jogo não é um problema simples.
 * 
 * Autor: Gustavo Alves
 * Data: 17/04/2019
 */

package ch14.ex14_25;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GeradorPalavrasCruzadas extends JFrame {
	private static final long serialVersionUID = 1L;

	private JComboBox<String> temas;
	private String[] nomesTemas = { "Países", "Linguagens de Programação" };

	private final String[] palavrasLP = { "JavaScript", "HTML", "CSS", "SQL", "Java", "Shell", "Python", "C#", "PHP",
			"C++", "C", "TypeScript", "Ruby Swift", "Assembly", "Go", "Objective-C", "VB.NET", "R", "Matlab", "VBA",
			"Kotlin", "Scala", "Groovy", "Perl" };

	private final String[] palavrasPaises = { "Afeganistão", "África do Sul", "Akrotiri", "Albânia", "Alemanha",
			"Andorra", "Angola", "Anguila", "Antárctida", "Antígua e Barbuda", "Arábia Saudita", "Arctic Ocean",
			"Argélia", "Argentina", "Arménia", "Aruba", "Ashmore and Cartier Islands", "Atlantic Ocean", "Austrália",
			"Áustria", "Azerbaijão", "Baamas", "Bangladeche", "Barbados", "Barém", "Bélgica", "Belize", "Benim",
			"Bermudas", "Bielorrússia", "Birmânia", "Bolívia", "Bósnia e Herzegovina", "Botsuana", "Brasil", "Brunei",
			"Bulgária", "Burquina Faso", "Burúndi", "Butão", "Cabo Verde", "Camarões", "Camboja", "Canadá", "Catar",
			"Cazaquistão", "Chade", "Chile", "China", "Chipre", "Clipperton Island", "Colômbia", "Comores",
			"Congo-Brazzaville", "Congo-Kinshasa", "Coral Sea Islands", "Coreia do Norte", "Coreia do Sul",
			"Costa do Marfim", "Costa Rica", "Croácia", "Cuba", "Curacao", "Dhekelia", "Dinamarca", "Domínica",
			"Egipto", "Emiratos Árabes Unidos", "Equador", "Eritreia", "Eslováquia", "Eslovénia", "Espanha",
			"Estados Unidos", "Estónia", "Etiópia", "Faroé", "Fiji", "Filipinas", "Finlândia", "França", "Gabão",
			"Gâmbia", "Gana", "Gaza Strip", "Geórgia", "Geórgia do Sul e Sandwich do Sul", "Gibraltar", "Granada",
			"Grécia", "Gronelândia", "Guame", "Guatemala", "Guernsey", "Guiana", "Guiné", "Guiné Equatorial",
			"Guiné-Bissau", "Haiti", "Honduras", "Hong Kong", "Hungria", "Iémen", "Ilha Bouvet", "Ilha do Natal",
			"Ilha Norfolk", "Ilhas Caimão", "Ilhas Cook", "Ilhas dos Cocos", "Ilhas Falkland", "Ilhas Heard e McDonald",
			"Ilhas Marshall", "Ilhas Salomão", "Ilhas Turcas e Caicos", "Ilhas Virgens Americanas",
			"Ilhas Virgens Britânicas", "Índia", "Indian Ocean", "Indonésia", "Irão", "Iraque", "Irlanda", "Islândia",
			"Israel", "Itália", "Jamaica", "Jan Mayen", "Japão", "Jersey", "Jibuti", "Jordânia", "Kosovo", "Kuwait",
			"Laos", "Lesoto", "Letónia", "Líbano", "Libéria", "Líbia", "Listenstaine", "Lituânia", "Luxemburgo",
			"Macau", "Macedónia", "Madagáscar", "Malásia", "Malávi", "Maldivas", "Mali", "Malta", "Man, Isle of",
			"Marianas do Norte", "Marrocos", "Maurícia", "Mauritânia", "México", "Micronésia", "Moçambique", "Moldávia",
			"Mónaco", "Mongólia", "Monserrate", "Montenegro", "Mundo", "Namíbia", "Nauru", "Navassa Island", "Nepal",
			"Nicarágua", "Níger", "Nigéria", "Niue", "Noruega", "Nova Caledónia", "Nova Zelândia", "Omã",
			"Pacific Ocean", "Países Baixos", "Palau", "Panamá", "Papua-Nova Guiné", "Paquistão", "Paracel Islands",
			"Paraguai", "Peru", "Pitcairn", "Polinésia Francesa", "Polónia", "Porto Rico", "Portugal", "Quénia",
			"Quirguizistão", "Quiribáti", "Reino Unido", "República Centro-Africana", "República Checa",
			"República Dominicana", "Roménia", "Ruanda", "Rússia", "Salvador", "Samoa", "Samoa Americana",
			"Santa Helena", "Santa Lúcia", "São Bartolomeu", "São Cristóvão e Neves", "São Marinho", "São Martinho",
			"São Pedro e Miquelon", "São Tomé e Príncipe", "São Vicente e Granadinas", "Sara Ocidental", "Seicheles",
			"Senegal", "Serra Leoa", "Sérvia", "Singapura", "Sint Maarten", "Síria", "Somália", "Southern Ocean",
			"Spratly Islands", "Sri Lanca", "Suazilândia", "Sudão", "Sudão do Sul", "Suécia", "Suíça", "Suriname",
			"Svalbard e Jan Mayen", "Tailândia", "Taiwan", "Tajiquistão", "Tanzânia",
			"Território Britânico do Oceano Índico", "Territórios Austrais Franceses", "Timor Leste", "Togo", "Tokelau",
			"Tonga", "Trindade e Tobago", "Tunísia", "Turquemenistão", "Turquia", "Tuvalu", "Ucrânia", "Uganda",
			"União Europeia", "Uruguai", "Usbequistão", "Vanuatu", "Vaticano", "Venezuela", "Vietname", "Wake Island",
			"Wallis e Futuna", "West Bank", "Zâmbia", "Zimbabué" };

	private final int TAMANHO = 10;
	private JTextField[][] gradeTextField = new JTextField[TAMANHO][TAMANHO];
	private char[][] gradeMarcador = new char[TAMANHO][TAMANHO];
	private char[][] gradeRespostas = new char[TAMANHO][TAMANHO];

	private JButton jogar;

	private JPanel panelGrade;

	private int QTDE_DE_PALAVRAS = 2;

	private final SecureRandom random = new SecureRandom();

	public GeradorPalavrasCruzadas() {
		super("Gerador de Palavras Cruzadas");

		JPanel panelSettings = new JPanel(new FlowLayout(FlowLayout.CENTER));

		temas = new JComboBox<String>(nomesTemas);

		jogar = new JButton("Começar");
		jogar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				gerarPalavrasCruzadas(palavrasLP);
				inicializarTabuleiro();
				add(panelGrade, BorderLayout.CENTER);
				repaint();
				revalidate();
			}
		});
		panelSettings.add(temas);
		panelSettings.add(jogar);
		add(panelSettings, BorderLayout.NORTH);

		panelGrade = new JPanel(new GridLayout(TAMANHO, TAMANHO, 0, 0));

		for (int i = 0; i < TAMANHO; i++) {
			for (int j = 0; j < TAMANHO; j++) {
				gradeTextField[i][j] = new JTextField(1);
				gradeTextField[i][j].setHorizontalAlignment(JTextField.CENTER);
				panelGrade.add(gradeTextField[i][j]);
			}
		}

	}

	public void gerarPalavrasCruzadas(String[] palavrasDoTema) {
		// gera a primeira palavra (isto é, a palavra base)
		String palavraBase = palavrasDoTema[random.nextInt(palavrasDoTema.length)];

		// gera coordenada
		int linha = random.nextInt(TAMANHO);
		int coluna = random.nextInt(TAMANHO);

		// gera direção
		boolean tentaDeNovo = true;
		do {
			try {
				int direcao = random.nextInt(4);

				switch (direcao) {
				case 0:// esquerda para direita
					for (int i = 0; i < palavraBase.length(); i++) {
						gradeRespostas[linha][coluna] = palavraBase.charAt(i);
						gradeMarcador[linha][coluna] = '*';
						coluna++;
					}
					tentaDeNovo = false;
					break;
				case 1:
					for (int i = 0; i < palavraBase.length(); i++) {
						gradeRespostas[linha][coluna] = palavraBase.charAt(i);
						gradeMarcador[linha][coluna] = '*';
						coluna--;
					}
					tentaDeNovo = false;
					break;
				case 2: // cima para baixo
					for (int i = 0; i < palavraBase.length(); i++) {
						gradeRespostas[linha][coluna] = palavraBase.charAt(i);
						gradeMarcador[linha][coluna] = '*';
						linha++;
					}
					tentaDeNovo = false;
					break;
				case 3: // baixo para cima
					for (int i = 0; i < palavraBase.length(); i++) {
						gradeRespostas[linha][coluna] = palavraBase.charAt(i);
						gradeMarcador[linha][coluna] = '*';
						linha--;
					}
					tentaDeNovo = false;
					break;
				}
			} catch (Exception e) {
				tentaDeNovo = true;
			}
		} while (tentaDeNovo);

		int counter = 1;
		while (counter < QTDE_DE_PALAVRAS) {
			String palavra = palavrasDoTema[random.nextInt(palavrasDoTema.length)];

			boolean flag = false;
			for (int i = 0; i < palavraBase.length(); i++) {
				for (int j = 0; j < palavra.length(); j++) {
					if (palavraBase.charAt(i) == palavra.charAt(j)) {

						flag = true;
						break;
					}
				}
			}

			if (flag)
				counter++;
		}
	}

	public void inicializarTabuleiro() {
		for (int j = 0; j < gradeMarcador.length; j++) {
			for (int j2 = 0; j2 < gradeMarcador.length; j2++) {
				if (gradeMarcador[j][j2] == '*')
					gradeTextField[j][j2].setText(" ");
				else {
					gradeTextField[j][j2].setEditable(false);
					gradeTextField[j][j2].setBackground(Color.BLACK);
				}

			}
		}
	}

	public static void main(String[] args) {
		GeradorPalavrasCruzadas frame = new GeradorPalavrasCruzadas();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setSize(400, 400);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
