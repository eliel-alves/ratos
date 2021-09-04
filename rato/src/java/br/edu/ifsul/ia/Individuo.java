package br.edu.ifsul.ia;

public class Individuo implements Comparable<Individuo> {
	
	private Cromossomo rato;
	private Double notaFit;
	private Integer geracao;
	// private String cromossomos;
	
	public Individuo(Cromossomo rato) {
		super();
		this.notaFit = 0.0;
		this.geracao = 0;
		
		// if (java.lang.Math.random() < 0.5) {
			// this.cromossomos = "0";
		// } else {
			// this.cromossomos = "1";
		// }
	}
	
	public void avaliar() {
		Integer rgbRato = (this.rato.getR() + this.rato.getG() + this.rato.getB()) / 3;
		this.notaFit = 255.0 / rgbRato;
	}
	
	public Individuo cruzar(Individuo outro) {
		int cruzamento = 1 + (int) (Math.random() * 6);
		Individuo i = null;
		
		if(cruzamento == 1) {
			Cromossomo novoRato = new Cromossomo(this.rato.getR(), outro.rato.getG(), outro.rato.getB());
			i = new Individuo(novoRato);
			i.setGeracao(this.geracao+1);
		} else if(cruzamento == 2) {
			Cromossomo novoRato = new Cromossomo(this.rato.getR(), this.rato.getG(), outro.rato.getB());
			i = new Individuo(novoRato);
			i.setGeracao(this.geracao+1);
		} else if(cruzamento == 3) {
			Cromossomo novoRato = new Cromossomo(outro.rato.getR(), outro.rato.getG(), this.rato.getB());
			i = new Individuo(novoRato);
			i.setGeracao(this.geracao+1);
		} else if(cruzamento == 4) {
			Cromossomo novoRato = new Cromossomo(outro.rato.getR(), this.rato.getG(), this.rato.getB());
			i = new Individuo(novoRato);
			i.setGeracao(this.geracao+1);
		} else if(cruzamento == 5) {
			Cromossomo novoRato = new Cromossomo(outro.rato.getR(), this.rato.getG(), outro.rato.getB());
			i = new Individuo(novoRato);
			i.setGeracao(this.geracao+1);
		} else {
			Cromossomo novoRato = new Cromossomo(this.rato.getR(), outro.rato.getG(), this.rato.getB());
			i = new Individuo(novoRato);
			i.setGeracao(this.geracao+1);
		}
		
		return i;
	}
	
	public void mutar(int taxaMutacao) {
		int mutacao = 1 + (int) (Math.random() * 3);
		
		if(mutacao == 1) {
			if(this.rato.getR() + taxaMutacao > 255) // 
				this.rato.setR(255);
			else
				this.rato.setR(this.rato.getR() + taxaMutacao);
		} else if(mutacao == 2) {
			if(this.rato.getG() + taxaMutacao > 255) // 
				this.rato.setG(255);
			else
				this.rato.setG(this.rato.getG() + taxaMutacao);
		} else {
			if(this.rato.getB() + taxaMutacao > 255) // 
				this.rato.setB(255);
			else
				this.rato.setB(this.rato.getB() + taxaMutacao);
		}
	}
	
	public int compareTo(Individuo o) {
		if (this.notaFit > o.getNotaFit()) {
			return -1;
		}
		if (this.notaFit < o.getNotaFit()) {
			return 1;
		}
		return 0;
	}

	public Cromossomo getRato() {
		return rato;
	}

	public void setRato(Cromossomo rato) {
		this.rato = rato;
	}

	public Double getNotaFit() {
		return notaFit;
	}

	public void setNotaFit(Double notaFit) {
		this.notaFit = notaFit;
	}

	public Integer getGeracao() {
		return geracao;
	}

	public void setGeracao(Integer geracao) {
		this.geracao = geracao;
	}
	
}
