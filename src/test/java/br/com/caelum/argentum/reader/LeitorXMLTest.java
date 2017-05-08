package br.com.caelum.argentum.reader;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import br.com.caelum.argentum.modelo.Negociacao;

public class LeitorXMLTest {

	@Test
	public void carregaXmlComUmaNegociacaoEmListaUnitaria() {
		String xmlDeTeste = "<list>" + "  <negociacao>" + "    <preco>43.5</preco>"
				+ "    <quantidade>1000</quantidade>" + "    <data>" + "      <time>1322233344455</time>"
				+ "    </data>" + "  </negociacao>" + "</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		Assert.assertEquals(1, negociacoes.size());
		Assert.assertEquals(43.5, negociacoes.get(0).getPreco(), 0.000001);
		Assert.assertEquals(1000, negociacoes.get(0).getQuantidade());
	}

	@Test
	public void carregaXmlSemNenhumaNegociacao() {
		String xmlDeTeste = "<list>" + "</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		Assert.assertEquals(0, negociacoes.size());
	}

	@Test
	public void carregaXmlFaltandoDados() {
		
		String xmlDeTeste = "<list>" + "  <negociacao>" + "    <preco></preco>" + "    <quantidade>1000</quantidade>"
				+ "    <data>" + "      <time>1322233344455</time>" + "    </data>" + "  </negociacao>" + "</list>";
		LeitorXML leitor = new LeitorXML();
		InputStream xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		List<Negociacao> negociacoes = leitor.carrega(xml);
		Assert.assertNotNull(negociacoes.get(0).getPreco());
		
		
		xmlDeTeste = "<list>" + "  <negociacao>" + "    <preco>43.5</preco>" + "    <quantidade></quantidade>"
				+ "    <data>" + "      <time>1322233344455</time>" + "    </data>" + "  </negociacao>" + "</list>";
		leitor = new LeitorXML();
		xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		negociacoes = leitor.carrega(xml);
		Assert.assertNotNull(negociacoes.get(0).getQuantidade());
		
		xmlDeTeste = "<list>" + "  <negociacao>" + "    <preco></preco>" + "    <quantidade></quantidade>"
				+ "    <data>" + "      <time>1322233344455</time>" + "    </data>" + "  </negociacao>" + "</list>";
		leitor = new LeitorXML();
		xml = new ByteArrayInputStream(xmlDeTeste.getBytes());
		negociacoes = leitor.carrega(xml);
		Assert.assertNotNull(negociacoes.get(0).getQuantidade());
		
	}

}
