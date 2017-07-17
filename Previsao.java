package lab04;

/**
 * Classe Enum:
 * 
 * Responsavel por atribuir valores as constantes que serão utilizadas pelo
 * programa.
 * 
 * @author Lucas Jarrier de Aquino Cavalcanti
 *
 */

public enum Previsao {

	VAI_ACONTECER("Vai acontecer"), N_VAI_ACONTECER("Nao vai acontecer");

	private String previsao;

	Previsao(String previsao) {
		this.previsao = previsao;
	}

	public String toString() {
		return this.previsao;
	}

	public String getPrevisao() {
		return previsao;
	}

	public void setPrevisao(String previsao) {
		this.previsao = previsao;
	}

}