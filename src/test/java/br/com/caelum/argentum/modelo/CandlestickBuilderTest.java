package br.com.caelum.argentum.modelo;

import java.util.Calendar;

import org.junit.Test;

public class CandlestickBuilderTest {

	@Test(expected=IllegalStateException.class)
	public void geracaoDeCandleDeveTerTodosOsDadosNecessarios()
	{
		//o abaixo e o que funciona
		//new CandlestickBuilder().comAbertura(10).comFechamento(10).comMaximo(10).comMinimo(10).comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem abertura
		new CandlestickBuilder().comFechamento(10).comMaximo(10).comMinimo(10).comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem fechamento
		new CandlestickBuilder().comAbertura(10).comMaximo(10).comMinimo(10).comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem maximo
		new CandlestickBuilder().comAbertura(10).comFechamento(10).comMinimo(10).comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem minimo
		new CandlestickBuilder().comAbertura(10).comFechamento(10).comMaximo(10).comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem volume
		new CandlestickBuilder().comAbertura(10).comFechamento(10).comMaximo(10).comMinimo(10).comData(Calendar.getInstance()).geraCandle();
		//sem data
		new CandlestickBuilder().comAbertura(10).comFechamento(10).comMaximo(10).comMinimo(10).comVolume(10).geraCandle();
		//sem abertura e fechamento
		new CandlestickBuilder().comMaximo(10).comMinimo(10).comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem abertura fechaemnto e minimo
		new CandlestickBuilder().comMinimo(10).comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem abertura fechamento minimo e maximo
		new CandlestickBuilder().comVolume(10).comData(Calendar.getInstance()).geraCandle();
		//sem abertura fechamento minimo maximo e volume
		new CandlestickBuilder().comData(Calendar.getInstance()).geraCandle();
		//sem data
		new CandlestickBuilder().geraCandle();
		
	}

}
