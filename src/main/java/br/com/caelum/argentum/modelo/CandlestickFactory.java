package br.com.caelum.argentum.modelo;

import java.util.Calendar;
import java.util.List;

public class CandlestickFactory {

	public Candlestick constroiCandleParaData(Calendar data, List<Negociacao> negociacoes){
		double sum = 0;
		double menor = Double.MAX_VALUE;
		double maior =0;
		for (Negociacao negociacao : negociacoes) {
			sum+=negociacao.getVolume();
			if(negociacao.getPreco() < menor)
				menor = negociacao.getPreco();
			if(negociacao.getPreco() > maior)
				maior = negociacao.getPreco();
		}
		menor = menor == Double.MAX_VALUE ? 0 : menor;
		double abertura = negociacoes.isEmpty() ? 0 : negociacoes.get(0).getPreco();
		double fechamento = negociacoes.isEmpty() ? 0 : 
		          negociacoes.get(negociacoes.size() - 1).getPreco();
		
		return new CandlestickBuilder().comAbertura(abertura).comData(data).comFechamento(fechamento).comMaximo(maior).comMinimo(menor).comVolume(sum).geraCandle();
	}
	
}
