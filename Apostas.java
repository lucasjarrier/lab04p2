package lab04;

/**
 * 
 * @author Lucas Jarrier de Aquino Cavalcanti
 * 
 *
 */

public class Apostas {

	/**
	 * A classe apostas é responsavel pelo controle de apostas de um usuário.
	 * Seus atributos são, nome, valor e previsão.
	 */

	private String nome;
	private int valor;
	private Previsao previsao;

	/**
	 * 
	 * @param nome
	 *            Recebe o nome do apostador.
	 * @param valor
	 *            Recebe o valor apostado.
	 * @param previsao
	 *            Recebe uma previsão.
	 * @throws Exception
	 *             Lança os erros de entrada ao usuário.
	 */

	public Apostas(String nome, int valor, String previsao) throws Exception {
		
		/**
		 * Lan�ando as mensagens de Erro ao usu�rio.
		 */
		
		if (nome == null || nome.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de aposta: Apostador nao pode ser vazio ou nulo");
		}

		if (valor <= 0) {
			throw new Exception("Erro no cadastro de aposta: Valor nao pode ser menor ou igual a zero");
		}
		
		if (previsao == null || previsao.trim().isEmpty()) {
			throw new Exception("Erro no cadastro de aposta: Previsao nao pode ser vazia ou nula");
		}
		
		if (previsao.equals("N VAI ACONTECER") || previsao.equals("VAI ACONTECER") ) {
			
			this.nome = nome;
			this.valor = valor;
			
			if (previsao.equals(Previsao.VAI_ACONTECER.getPrevisao())) {
				this.previsao = Previsao.VAI_ACONTECER;
			}
			
			else if(previsao.equals(Previsao.N_VAI_ACONTECER.getPrevisao())) {
				this.previsao = Previsao.VAI_ACONTECER;
			}
		} 
		else {
			throw new Exception ("Erro no cadastro de aposta: Previsao invalida"); 
		}
	}

	/**
	 * 
	 * GET AND SETTERS, metodos responsaveis por Setar e permitir ao usuário
	 * chamar os valores dessa classe.
	 */

	public void setPrevisao(Previsao previsao) {
		
		if (this.previsao.equals(previsao.VAI_ACONTECER)){
			this.previsao = previsao.N_VAI_ACONTECER;
		}
		else if (this.previsao.equals(previsao.N_VAI_ACONTECER)) {
			this.previsao = previsao.VAI_ACONTECER;
		}
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

	public Previsao getPrevisao() {
		return previsao;
	}

	/**
	 * Representação textual da classe aposta. Nome: - Valor: - Previsão:
	 */
	@Override
	public String toString() {
		return this.nome + " - " + this.valor + " - " + this.previsao;
	}
}