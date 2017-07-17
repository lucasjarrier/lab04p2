package lab04;

public class CenarioBonus extends Cenario {

	private int bonus;

	public CenarioBonus(String descricao, int numeracao, int bonus) throws Exception {
		super(descricao, numeracao);

	}

	public int getBonus() {
		return bonus;
	}

	public void setBonus(int bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return this.numeracao + " - " + this.descricao + " - " + this.estado + this.bonus;
	}

}
