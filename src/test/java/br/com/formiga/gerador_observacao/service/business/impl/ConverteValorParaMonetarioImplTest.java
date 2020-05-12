
package br.com.formiga.gerador_observacao.service.business.impl;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;


/**
 *
 * @author formiga
 */
@RunWith(MockitoJUnitRunner.class)
public class ConverteValorParaMonetarioImplTest {
    
    @InjectMocks
    private ConverteValorParaMonetarioImpl converteValorParaMonetarioImplMock;

    
    /**
     * Centavos com apenas um dígito e deve concatenar com um 0 no final.
     */
    @Test
    public void testConverter_CentavosIncompleto() {
        
        final String resposta = this.converteValorParaMonetarioImplMock.converter(10.2);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[1]Objetos devem ser iguais", "R$ 10,20", resposta);
    }
    
    /**
     * Centavos contém mais de dois dígitos e deve retornar os dois primeiros apenas.
     */
    @Test
    public void testConverter_CentavosComMaisDeDoisDígitos() {
        
        final String resposta = this.converteValorParaMonetarioImplMock.converter(10.254);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[1]Objetos devem ser iguais", "R$ 10,25", resposta);
    }
    
}
