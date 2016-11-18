package modelo;

public class Medidas {
	float bracoDireito, bracoEsquerdo, coxaDireita, coxaEsquerda, peito, percentualDeGordura;

	public Medidas(float bracoDireito, float bracoEsquerdo, float coxaDireita, float coxaEsquerda, float peito,
			float percentualDeGordura) {
		super();
		this.bracoDireito = bracoDireito;
		this.bracoEsquerdo = bracoEsquerdo;
		this.coxaDireita = coxaDireita;
		this.coxaEsquerda = coxaEsquerda;
		this.peito = peito;
		this.percentualDeGordura = percentualDeGordura;
	}
	
	public Medidas(){}

	public float getBracoDireito() {
		return bracoDireito;
	}

	public void setBracoDireito(float bracoDireito) {
		this.bracoDireito = bracoDireito;
	}

	public float getBracoEsquerdo() {
		return bracoEsquerdo;
	}

	public void setBracoEsquerdo(float bracoEsquerdo) {
		this.bracoEsquerdo = bracoEsquerdo;
	}

	public float getCoxaDireita() {
		return coxaDireita;
	}

	public void setCoxaDireita(float coxaDireita) {
		this.coxaDireita = coxaDireita;
	}

	public float getCoxaEsquerda() {
		return coxaEsquerda;
	}

	public void setCoxaEsquerda(float coxaEsquerda) {
		this.coxaEsquerda = coxaEsquerda;
	}

	public float getPeito() {
		return peito;
	}

	public void setPeito(float peito) {
		this.peito = peito;
	}

	public float getPercentualDeGordura() {
		return percentualDeGordura;
	}

	public void setPercentualDeGordura(float percentualDeGordura) {
		this.percentualDeGordura = percentualDeGordura;
	}
	
}
