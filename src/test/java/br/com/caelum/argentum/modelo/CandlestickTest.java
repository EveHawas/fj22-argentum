package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Test;


public class CandlestickTest {

	@Test(expected = IllegalArgumentException.class)
	public void isMaximoBiggerThanMinimo() {
		Candlestick c = new Candlestick(10, 50, 10, 5, 10, Calendar.getInstance());
	}

	@Test
	public void quandoAberturaIgualFechamentoEhAlta(){
		Candlestick c = new Candlestick(10, 10, 10, 50, 10, Calendar.getInstance());
		Assert.assertEquals(true, c.isAlta());
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void isCandlestickDataNull() {
		Candlestick c = new Candlestick(10, 50, 10, 5, 10, null);
	}

	@Test(expected = IllegalArgumentException.class)
	public void isAnyNegativeValue() {
		Candlestick c = new Candlestick(-10, 50, 10, 5, 10, Calendar.getInstance());
		Candlestick c1 = new Candlestick(-10, -50, 10, 5, 10, Calendar.getInstance());
		Candlestick c2 = new Candlestick(-10, -50, -10, 5, 10, Calendar.getInstance());
		Candlestick c3 = new Candlestick(-10, -50, -10, -5, 10, Calendar.getInstance());
		Candlestick c4 = new Candlestick(-10, -50, -10, -5, -10, Calendar.getInstance());

		Candlestick c5 = new Candlestick(10, -50, 10, 5, 10, Calendar.getInstance());
		Candlestick c6 = new Candlestick(10, -50, -10, 5, 10, Calendar.getInstance());
		Candlestick c7 = new Candlestick(10, -50, -10, -5, 10, Calendar.getInstance());
		Candlestick c8 = new Candlestick(10, -50, -10, -5, -10, Calendar.getInstance());

		Candlestick c9 = new Candlestick(10, 50, -10, 5, 10, Calendar.getInstance());
		Candlestick c10 = new Candlestick(10, 50, -10, -5, 10, Calendar.getInstance());
		Candlestick c11 = new Candlestick(10, 50, -10, -5, -10, Calendar.getInstance());

		Candlestick c12 = new Candlestick(10, 50, 10, -5, 10, Calendar.getInstance());
		Candlestick c13 = new Candlestick(10, 50, 10, -5, -10, Calendar.getInstance());

		Candlestick c14 = new Candlestick(10, 50, 10, 5, -10, Calendar.getInstance());

	}

}
