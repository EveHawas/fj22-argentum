package br.com.caelum.argentum.modelo;

import static org.junit.Assert.*;

import java.util.Calendar;


import org.junit.Test;

public class NegociacaoTest {

	@Test(expected=IllegalArgumentException.class)
	public void naoCriaNegociacaoComDataNula() {
	  new Negociacao(10, 5, null);
	}
	
	@Test
	  public void dataDaNegociacaoEhImutavel() {
	    // se criar um negocio no dia 15...
	    Calendar c = Calendar.getInstance();
	    c.set(Calendar.DAY_OF_MONTH, 15);
	    Negociacao n = new Negociacao(10, 5, c);
	    

	    // ainda que eu tente mudar a data para 20...
	    n.getData().set(Calendar.DAY_OF_MONTH, 20);
	    
	    // ele continua no dia 15.
	    assertEquals(15, n.getData().get(Calendar.DAY_OF_MONTH));
	  }

}
