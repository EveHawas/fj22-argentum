package br.com.caelum.argentum.testes;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

import br.com.caelum.argentum.modelo.*;

public class TestaCandlestickFactory {

	public static void main(String[] args) {
		
		Calendar hoje = Calendar.getInstance();

		Negociacao negociacao1 = new Negociacao(40.5, 100, hoje);
		Negociacao negociacao2 = new Negociacao(45.0, 100, hoje);
		Negociacao negociacao3 = new Negociacao(39.8, 100, hoje);
		Negociacao negociacao4 = new Negociacao(42.3, 100, hoje);
		
		List<Negociacao> negociacoes = Arrays.asList(negociacao1,negociacao2,negociacao3,negociacao4);
		
		CandlestickFactory cf = new CandlestickFactory();
		
		Candlestick cs = cf.constroiCandleParaData(hoje, negociacoes);
		
		
		
		System.out.println(cs);
		System.out.println(cs.getAbertura());
		System.out.println(cs.getFechamento());
		System.out.println(cs.getMaximo());
		System.out.println(cs.getMinimo());
		System.out.println(cs.getVolume());
		
	}

}
