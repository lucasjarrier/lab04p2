package lab04;

import easyaccept.EasyAccept;

/**
 * 
 * @author Lucas Jarrier de Aquino Cavalcanti
 * 
 *         Classe Facade: Responsavel por se comunicar com a classe Controller,
 *         essa classe é uma classe que so tem métodos que chamam outros
 *         métodos.
 */

public class Facade {
	
	public static void main(String[] args) {
		args = new String[] {"lab04.Facade", "acceptance_test/us1_text.txt","acceptance_test/us2_test.txt","acceptance_test/us3_test.txt","acceptance_test/us4_test.txt"};
		EasyAccept.main(args);
	}
	
	private Controller controller;

	public void inicializa(int caixa, double taxa) throws Exception {
		this.controller = new Controller(caixa, taxa);
	}

	public void cadastrarCenario(String descricao) throws Exception {
		controller.cadastrarCenario(descricao);
	}
	
	public void cadastrarCenarioBonus(String descricao, int bonus) throws Exception {
		controller.cadastrarCenarioBonus(descricao,bonus);
	}

	public void cadastrarAposta(int cenario, String nome, double valor, String previsao) throws Exception {
		controller.cadastraAposta(cenario,nome, valor, previsao);
	}

	public String exibirCenario(int numeracao) throws Exception {
		return this.controller.exibeCenario(numeracao);
	}

	public String cenariosCriados() {
		return this.controller.exibeTodosCenarios();
	}

	public int valorTotalDeApostas(int cenario) throws Exception {
		return controller.totalDeApostas(cenario);
	}


	public int totalDeApostas(int cenario) throws Exception {
		return controller.quantidadeDeApostas(cenario);
	}

	public String apostasCenario(int cenario) {
		return controller.exibeApostasCenario(cenario);
	}

	public void fecharCenario(int cenario, boolean ocorreu) {
		controller.fecharCenario(cenario, ocorreu);
	}

	public int getCaixaCenario(int cenario) {
		return controller.getCaixaCenario(cenario);
	}
	
	public int getCaixa() {
		return this.controller.getCaixa();
	}
	
	
}