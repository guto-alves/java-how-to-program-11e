/*
 * Objetivo: 20.8 (Classe genérica Pair) Escreva uma classe genérica Pair 
 * que tem dois parâmetros de tipo — F e S —, cada um representando o tipo 
 * do primeiro e segundo elemento do par, respectivamente. Adicione os 
 * métodos get e set ao primeiro e ao segundo elemento do par. [Dica: o 
 * cabeçalho da classe deve ser public class Pair< F, S >.]
 * 
 * Autor: Gustavo Alves
 */

package ch20.ex20_08;

public class Pair<F, S> {
	private F f;
	private S s;

	public Pair(F f, S s) {
		this.f = f;
		this.s = s;
	}

	public F getF() {
		return f;
	}

	public void setF(F f) {
		this.f = f;
	}

	public S getS() {
		return s;
	}

	public void setS(S s) {
		this.s = s;
	}
}
