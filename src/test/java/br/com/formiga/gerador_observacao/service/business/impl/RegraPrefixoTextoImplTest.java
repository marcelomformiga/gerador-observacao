
package br.com.formiga.gerador_observacao.service.business.impl;


import br.com.formiga.gerador_observacao.service.business.constants.TextoConstants;
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
public class RegraPrefixoTextoImplTest {
    
    @InjectMocks
    private RegraPrefixoTextoImpl regraPrefixoTextoImplMock;
    

    /**
     * Quando tamanho da lista é igual 1, deve retornar prefixo do texto no singular.
     */
    @Test
    public void testRetornarPrefixo_Singular() {
        
        String resposta = this.regraPrefixoTextoImplMock.retornarPrefixo(1);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[2]Objetos devem ser iguais", TextoConstants.PREFIXO_TEXTO_SINGULAR, resposta);
    }
    
    /**
     * Quando tamanho da lista é maior do que 1, deve retornar prefixo do texto no singular.
     */
    @Test
    public void testRetornarPrefixo_Plural() {
        
        String resposta = this.regraPrefixoTextoImplMock.retornarPrefixo(2);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[2]Objetos devem ser iguais", TextoConstants.PREFIXO_TEXTO_PLURAL, resposta);
    }
    
    /**
     * Quando a lista é vazia, deve retornar prefixo do texto vazio.
     */
    @Test
    public void testRetornarPrefixo_Vazio() {
        
        String resposta = this.regraPrefixoTextoImplMock.retornarPrefixo(0);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[2]Objetos devem ser iguais", "", resposta);
    }
    
}
