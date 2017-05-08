package br.com.caelum.argentum.modelo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class Candlestick {

	public final double abertura;
	public final double fechamento;
	public final double minimo;
	public final double maximo;
	public final double volume;
	public final Calendar data;

	public Candlestick(double abertura, double fechamento, double minimo, double maximo, double volume, Calendar data) {
		if (maximo < minimo) {
			throw new IllegalArgumentException("maximo e maior que minimo");
		}

		if (abertura * fechamento * minimo * maximo * volume < 0) {
			throw new IllegalArgumentException("algum valor digitado e negativo");
		}

		this.abertura = abertura;
		this.fechamento = fechamento;
		this.minimo = minimo;
		this.maximo = maximo;
		this.volume = volume;
		this.data = data;
	}

	public double getAbertura() {
		return abertura;
	}

	public double getFechamento() {
		return fechamento;
	}

	public double getMinimo() {
		return minimo;
	}

	public double getMaximo() {
		return maximo;
	}

	public double getVolume() {
		return volume;
	}

	public Calendar getData() {
		return data;
	}

	public boolean isAlta() {
		return this.abertura <= this.fechamento;
	}

	public boolean isBaixa() {
		return this.abertura > this.fechamento;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[Abertura ");
		sb.append(this.abertura);
		sb.append(", Fechamento ");
		sb.append(this.fechamento);
		sb.append(", Minima ");
		sb.append(this.minimo);
		sb.append(", Maximo ");
		sb.append(this.maximo);
		sb.append(", Volume ");
		sb.append(getVolume());
		sb.append(", Data ");
		sb.append(new SimpleDateFormat("dd/mm/yyyy").format(this.data.getTime()));
		sb.append("];");
		return sb.toString();
	}

}
