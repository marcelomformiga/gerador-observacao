
package br.com.formiga.gerador_observacao.service;


import br.com.formiga.gerador_observacao.service.v2.GeradorObservacaoV2;
import br.com.formiga.gerador_observacao.service.business.ConverteValorParaMonetario;
import br.com.formiga.gerador_observacao.service.business.RegraPrefixoTexto;
import br.com.formiga.gerador_observacao.service.business.constants.TextoConstants;
import java.util.HashMap;
import java.util.Map;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;


/**
 *
 * @author formiga
 */
@RunWith(MockitoJUnitRunner.class)
public class GeradorObservacaoV2Test {
    
    @InjectMocks
    private GeradorObservacaoV2 geradorObservacaoV2Mock;
    
    @Mock
    private RegraPrefixoTexto regraPrefixoTextoMock;
    
    @Mock
    private ConverteValorParaMonetario converteValorParaMonetarioMock;
    

    /**
     * Quando o map possui mais de um elemento.
     */
    @Test
    public void testGeraObservacao_MapComMaisDeUmElemento() {
        
        Map<Integer, Double> valores = new HashMap<>();
        valores.put(1, 10.00);
        valores.put(2, 35.00);
        valores.put(3, 12.00);
        
        String valorMonetarioChave1 = "R$ 10,00";
        String valorMonetarioChave2 = "R$ 35,00";
        String valorMonetarioChave3 = "R$ 12,00";
        
        Double total = valores.get(1) + valores.get(2) + valores.get(3);
        
        String valorMonetarioTotal = "R$ 57,00";
        
        Mockito.when(this.regraPrefixoTextoMock.retornarPrefixo(valores.size())).thenReturn(TextoConstants.PREFIXO_TEXTO_PLURAL);
        
        Mockito.when(this.converteValorParaMonetarioMock.converter(valores.get(1))).thenReturn(valorMonetarioChave1);
        Mockito.when(this.converteValorParaMonetarioMock.converter(valores.get(2))).thenReturn(valorMonetarioChave2);
        Mockito.when(this.converteValorParaMonetarioMock.converter(valores.get(3))).thenReturn(valorMonetarioChave3);
        Mockito.when(this.converteValorParaMonetarioMock.converter(total)).thenReturn(valorMonetarioTotal);
        
        String resposta = this.geradorObservacaoV2Mock.geraObservacao(null, valores);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[2]Objetos devem ser iguais", "Fatura das notas fiscais de simples remessa: 1 cujo valor é R$ 10,00, 2 cujo valor é R$ 35,00, e 3 cujo valor é R$ 12,00. Total = R$ 57,00. ", resposta);
        
        Mockito.verify(this.regraPrefixoTextoMock, Mockito.only()).retornarPrefixo(Mockito.anyInt());
        Mockito.verify(this.converteValorParaMonetarioMock, Mockito.times(4)).converter(Mockito.anyDouble());
    }
    
    /**
     * Quando o map possui apenas um elemento.
     */
    @Test
    public void testGeraObservacao_MapComApenasUmElemento() {
        
        Map<Integer, Double> valores = new HashMap<>();
        valores.put(1, 10.00);
        
        String valorMonetarioChave1 = "R$ 10,00";
        
        Double total = valores.get(1);
        
        String valorMonetarioTotal = "R$ 10,00";
        
        Mockito.when(this.regraPrefixoTextoMock.retornarPrefixo(valores.size())).thenReturn(TextoConstants.PREFIXO_TEXTO_SINGULAR);
        
        Mockito.when(this.converteValorParaMonetarioMock.converter(valores.get(1))).thenReturn(valorMonetarioChave1);
        Mockito.when(this.converteValorParaMonetarioMock.converter(total)).thenReturn(valorMonetarioTotal);
        
        String resposta = this.geradorObservacaoV2Mock.geraObservacao(null, valores);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[2]Objetos devem ser iguais", "Fatura da nota fiscal de simples remessa: 1 cujo valor é R$ 10,00. Total = R$ 10,00. ", resposta);
        
        Mockito.verify(this.regraPrefixoTextoMock, Mockito.only()).retornarPrefixo(Mockito.anyInt());
        Mockito.verify(this.converteValorParaMonetarioMock, Mockito.times(2)).converter(Mockito.anyDouble());
    }
    
    /**
     * Quando o map não possui elementos.
     */
    @Test
    public void testGeraObservacao_MapVazio() {
        
        Map<Integer, Double> valores = new HashMap<>();
        
        String resposta = this.geradorObservacaoV2Mock.geraObservacao(null, valores);
        
        Assert.assertNotNull("[1]Resposta não pode ser nula", resposta);
        Assert.assertEquals("[2]Objetos devem ser iguais", "", resposta);
        
        Mockito.verify(this.regraPrefixoTextoMock, Mockito.never()).retornarPrefixo(Mockito.anyInt());
        Mockito.verify(this.converteValorParaMonetarioMock, Mockito.never()).converter(Mockito.anyDouble());
    }
    
}
