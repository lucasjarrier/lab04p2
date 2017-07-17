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

public enum EstadoAposta {
	FINALIZADO_OCORREU("Finalizado (ocorreu)"), FINALIZADO_N_OCORREU(
			"Finalizado (n ocorreu)"), N_FINALIZADO("Nao finalizado");

	private String valores;

	EstadoAposta(String valor) {
		this.valores = valor;
	}

	public String getValores() {
		return valores;
	}

}