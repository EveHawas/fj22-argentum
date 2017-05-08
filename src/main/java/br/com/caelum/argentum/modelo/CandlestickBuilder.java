package br.com.caelum.argentum.modelo;

import java.util.Calendar;

public class CandlestickBuilder {

	public double abertura;
	public double fechamento;
	public double minimo;
	public double maximo;
	public double volume;
	public Calendar data;
	private int checker = 0;

	public CandlestickBuilder comAbertura(double abertura) {
		checker += 1;
		this.abertura = abertura;
		return this;
	}

	public CandlestickBuilder comFechamento(double fechamento) {
		checker += 1;
		this.fechamento = fechamento;
		return this;
	}

	public CandlestickBuilder comMinimo(double minimo) {
		checker += 1;
		this.minimo = minimo;
		return this;
	}

	public CandlestickBuilder comMaximo(double maximo) {
		checker += 1;
		this.maximo = maximo;
		return this;
	}

	public CandlestickBuilder comVolume(double volume) {
		checker += 1;
		this.volume = volume;
		return this;
	}

	public CandlestickBuilder comData(Calendar data) {
		checker += 1;
		this.data = data;
		return this;
	}

	public Candlestick geraCandle() {
		if (checker < 6) {
			throw new IllegalStateException();
		}
		return new Candlestick(abertura, fechamento, minimo, maximo, volume, data);
	}

}
