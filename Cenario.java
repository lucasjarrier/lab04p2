package lab04;

/**
 * Classe denominada: Cenario. Um cenario tem uma descrição, e um Estado (Pode ou não acontecer).
 * 
 * 
 * @author Lucas Jarrier de Aquino Cavalcanti
 */

import java.util.ArrayList;

public class Cenario {

	private final String LN = System.lineSeparator();
	protected int numeracao;
	protected String descricao;
	protected EstadoAposta estado;
	protected ArrayList<Apostas> totalApostas;
	protected int rateio;

	/**
	 * Instancia um novo cenário. Cada cenaŕio possui uma descrição, um estado e
	 * uam lista de Apostas.
	 * 
	 * 
	 * @param Descrição,
	 *            É o nome que o cenário recebeu.
	 * @throws Exception
	 * 
	 */

	public Cenario(String descricao, int numeracao) throws Exception {

		if (descricao == null || descricao.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de cenario: Descricao nao pode ser vazia");
			}
		
		this.totalApostas = new ArrayList<Apostas>();
		this.estado = EstadoAposta.N_FINALIZADO;
		this.numeracao = numeracao;
		this.descricao = descricao;

		/**
		 * Construtor da classe cenario, responsavel pelos seus atributos.
		 */
	}

	/**
	 * 
	 * Gett's and Setters, metodos responsaveis por Setar e permitir ao usuário
	 * chamar os valores dessa classe.
	 * @throws Exception 
	 */
	
	public void cadastraAposta(String nome,int valor,String previsao) throws Exception {
		Apostas apostas = new Apostas(nome,valor,previsao);
		totalApostas.add(apostas);
	}
	
	/**
	 * Metodo apostasDoCenario.
	 * 
	 * @return Responsavel por exibir as apostas de um cenário.
	 */
	
	public String apostasDoCenario() {
		String retorno = "";
		for (int i = 0; i < totalApostas.size(); i++) {
			retorno += totalApostas.get(i).toString() + LN;
		}
		return retorno;
	}
	
	/**
	 * 
	 * @param nVaiAcontecer Recebe uma previsão.
	 * @return Retorna o valor do caixa.
	 */
	
	public double getCaixa(Previsao previsao) {
		int caixa = 0;
		for (Apostas aposta : this.totalApostas) {
			if (aposta.getPrevisao().equals(previsao)) {
				caixa += aposta.getValor();
			}
		}
		return caixa;
	}
	
	/**
	 * Metodo totalApostas.
	 * 
	 * @return Responsavel por somar e mostrar todas as apostas de um cenário.
	 */

	public int totalApostas() {
		int retorno = 0;
		for (int i = 0; i < totalApostas.size(); i++) {
			retorno += totalApostas.get(i).getValor();
		}
		return retorno;
	}
	
	public int getNumeracao() {
		return numeracao;
	}

	public ArrayList<Apostas> getTotalApostas() {
		return this.totalApostas;
	}

	public void setTotalApostas(ArrayList<Apostas> totalApostas) {
		this.totalApostas = totalApostas;
	}

	public void setNumeracao(int numeracao) {
		this.numeracao = numeracao;
	}

	public EstadoAposta getEstado() {
		return estado;
	}

	public void setEstado(EstadoAposta estado) {
		this.estado = estado;
	}

	/**
	 * Representação Textual da classe Cenario.
	 */

	@Override
	public String toString() {
		return this.numeracao + " - " + this.descricao + " - " + this.estado.getValores();
	}
}