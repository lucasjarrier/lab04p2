package lab04;

/**
 * @author Lucas Jarrier de Aquino Cavalcanti
 */

import java.util.ArrayList;

public class Controller {

	/**
	 * Classe Controller, a classe mãe do código, responsavel pela
	 * manipulação de dados, essa clase é composta principalmente de metodos.
	 */

	private final String LN = System.lineSeparator();

	private ArrayList<Apostas> listaApostas;
	private ArrayList<Cenario> listaCenario;
	private int caixa;
	private double taxa;

	/**
	 * 
	 * @param caixa
	 *            Recebe um valor inicial do caixa.
	 * @param taxa
	 *            Recebe uma taxa que sera cobrada.
	 * @throws Exception
	 *             Trata os erros de Entrada.
	 */

	public Controller(int caixa, double taxa) throws Exception {

		/**
		 * Construtor da classe Controller.
		 */

		if (caixa < 0) {
			throw new Exception("Erro na inicializacao: Caixa nao pode ser inferior a 0");
		}

		if (taxa < 0) {
			throw new Exception("Erro na inicializacao: Taxa nao pode ser inferior a 0");
		}

		this.caixa = caixa;
		this.taxa = taxa;
		this.listaCenario = new ArrayList<Cenario>();

	}

	/**
	 * 
	 * @return Retorna o valor que tem em caixa.
	 */

	public int getCaixa() {
		return this.caixa;
	}

	/**
	 * 
	 * @return Retorna o valor da taxa.
	 */

	public double getTaxa() {
		return this.taxa;
	}

	public ArrayList<Cenario> getListaCenarios() {
		return this.listaCenario;
	}

	/**
	 * Metodo cuja função é cadastrar novos cenarios.
	 * 
	 */
	public void cadastrarCenario(String descricao) throws Exception {
		Cenario cenario = new Cenario(descricao, listaCenario.size() + 1);
		this.listaCenario.add(cenario);
	}

	/**
	 * 
	 * Metodo responsavel por cadastrar novas apostas.
	 * 
	 * @param cenario
	 *            Recebe um cenario
	 * @param nome
	 *            Recebe o nome de um apostador
	 * @param valor
	 *            O valor a ser apostado
	 * @param previsao
	 *            Recebe a Previsão dita pelo apostador
	 */

	public void cadastraAposta(int cenario, String nome, int valor, String previsao) throws Exception {

		if (cenario <= 0) {
			throw new Exception("Erro no cadastro de aposta: Cenario invalido");
		}
		if (cenario > listaCenario.size()) {
			throw new Exception("Erro no cadastro de aposta: Cenario nao cadastrado");
		}

		if (valor <= 0) {
			throw new NullPointerException("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		this.listaCenario.get(cenario - 1).cadastraAposta(nome, valor, previsao);
	}

	/**
	 * a Metodo responsavel por exibir um cenario, atravez de um numero de
	 * cenario.
	 * 
	 * @param numeracao
	 *            Recebe um numero de cenario passado pelo usuário.
	 * 
	 */

	public String exibeCenario(int numeracao) throws Exception {
		if (numeracao < 0) {
			throw new Exception("Erro na consulta de cenario: Cenario invalido");
		}
		if (numeracao > listaCenario.size()) {
			throw new Exception("Erro na consulta de cenario: Cenario nao cadastrado");
		}
		return listaCenario.get(numeracao - 1).toString();

	}

	/**
	 * 
	 * Metodo responsavel por imprimir todos os cenários existentes.
	 */

	public String exibeTodosCenarios() {
		String retorno = "";
		for (int i = 0; i < listaCenario.size(); i++) {
			retorno += listaCenario.get(i).toString() + LN;
		}
		return retorno;
	}

	/**
	 * Metodo responsavel por imprimir a soma dos valores de apostas feitas em
	 * um cenário.
	 * 
	 * @param cenario
	 *            Recebe um cenario como entrada de dados.
	 * @return o valor total dos cenários.
	 * @throws Exception
	 */
	public int totalDeApostas(int cenario) throws Exception {
		
		if (cenario <= 0) {
			throw new Exception("Erro na consulta do valor total de apostas: Cenario invalido");
		} 
		else if (cenario > listaCenario.size()) {
			throw new Exception("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return listaCenario.get(cenario - 1).totalApostas();
	}

	/**
	 * Metodo responsavel pela quantidade de apostas.
	 * 
	 * @param cenario
	 *            Recebe um cenário como parametro.
	 * @return Retorna a quantidade de apostas feitas nesse cenário.
	 * @throws Exception
	 */

	public int quantidadeDeApostas(int cenario) throws Exception {
		if (cenario <= 0) {
			throw new Exception("Erro na consulta do valor total de apostas: Cenario invalido");
		}
		if (cenario > listaCenario.size()) {
			throw new Exception("Erro na consulta do valor total de apostas: Cenario nao cadastrado");
		}
		return listaCenario.get(cenario - 1).getTotalApostas().size();
	}

	/**
	 * Exibhe apostas do cenário.
	 * 
	 * @param cenario
	 *            Recebe um cenario como parametro.
	 * @return Retorna as apostas daquele cenário.
	 */

	public String exibeApostasCenario(int cenario) {
		String retorno = "";
		Cenario novoCenario = listaCenario.get(cenario);
		for (int i = 0; i < novoCenario.getTotalApostas().size(); i++) {
			retorno += novoCenario.getTotalApostas().get(i) + LN;
		}

		return retorno;
	}

	/**
	 * Metodo responsavel por encerrar um cenário.
	 * 
	 * @param cenario
	 *            Recebe um cenário.
	 * @param ocorreu
	 *            E um boolean, se ocorreu ou não.
	 */

	public void fecharCenario(int cenario, boolean ocorreu) {

		if (ocorreu) {
			this.listaCenario.get(cenario - 1).setEstado(EstadoAposta.FINALIZADO_OCORREU);
		} else {
			this.listaCenario.get(cenario - 1).setEstado(EstadoAposta.FINALIZADO_N_OCORREU);
		}

		this.caixa += this.getCaixaCenario(cenario) * 100 * this.taxa;

	}

	/**
	 * Metodo responsavel pegar o valor do Caixa no cenário
	 * 
	 * @param cenario
	 *            Recebe como valor um cenário
	 * 
	 * @return Retorna o valor total de um cenário encerrado que será
	 *         destinado ao caixa
	 */

	public int getCaixaCenario(int cenario) {

		if (this.listaCenario.get(cenario - 1).getEstado().equals(EstadoAposta.FINALIZADO_OCORREU)) {

			return (int) this.listaCenario.get(cenario - 1).getCaixa(Previsao.N_VAI_ACONTECER);

		} else if (this.listaCenario.get(cenario - 1).getEstado().equals(EstadoAposta.FINALIZADO_N_OCORREU)) {

			return (int) this.listaCenario.get(cenario - 1).getCaixa(Previsao.VAI_ACONTECER);
		}

		return 0;
	}
	
	/**
	 *  Metodo responsavel por criar um cen�rio bonus.
	 * @param descricao Recebe um nome do cen�rio.
	 * @param bonus Recebe um valor bonus.
	 * @throws Exception 
	 */
	
	public void cadastrarCenarioBonus(String descricao, int bonus) throws Exception {
		
		if (descricao == null) {
			throw new Exception("Erro no cadastro de cenario: Descricao nao pode ser vazia");
		}
		if (descricao.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de cenario: Descricao nao pode ser vazia");	
		}
		if (bonus <= 0) {
			throw new Exception("Erro no cadastro de cenario: Bonus invalido");
		}
		
		CenarioBonus cenarioBonus = new CenarioBonus(descricao, listaCenario.size() + 1, bonus);
		caixa = caixa - bonus;
		listaCenario.add(cenarioBonus);

	}

	/**
	 * Metodo que distribui o rateio do cenário.
	 * 
	 * @param cenario
	 *            recebe como parâmetro um cenário
	 * @return Retorna o valor total de um cenário encerrado que será
	 *         destinado a distribuição entre as apostas vencedoras
	 */
	
	  public int getTotalRateioCenario(int cenario) {
	  if (this.listaCenario.get(cenario - 1).getEstado().equals(EstadoAposta.FINALIZADO_OCORREU)) {
		  int total = (int) (this.listaCenario.get(cenario - 1).getCaixa(Previsao.N_VAI_ACONTECER) * 100);
		  int rateio = (total - (int) (this.getCaixaCenario(cenario) * (this.taxa) * 100));
		  return rateio;
	  }
	  
	 else if (this.listaCenario.get(cenario -1).getEstado().equals(EstadoAposta.FINALIZADO_N_OCORREU)) {
		 int total = (int) (this.listaCenario.get(cenario - 1).getCaixa(Previsao.VAI_ACONTECER) * 100);
		 int rateio = total - (int) (this.getCaixaCenario(cenario) * (this.taxa) * 100);
		 return rateio; 
	 }
	 return 0;
	 }
}