
package br.com.formiga.gerador_observacao;


import br.com.formiga.gerador_observacao.service.v1.GeradorObservacao;
import br.com.formiga.gerador_observacao.service.v2.GeradorObservacaoV2;
import br.com.formiga.gerador_observacao.service.VersaoGerador;
import br.com.formiga.gerador_observacao.service.business.ConverteValorParaMonetario;
import br.com.formiga.gerador_observacao.service.business.RegraPrefixoTexto;
import br.com.formiga.gerador_observacao.service.business.impl.ConverteValorParaMonetarioImpl;
import br.com.formiga.gerador_observacao.service.business.impl.RegraPrefixoTextoImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;



/**
 *
 * @author formiga
 */
public class Application {

    private static VersaoGerador versaoGerador;
    private static RegraPrefixoTexto regraPrefixoTexto;
    private static ConverteValorParaMonetario converteValorParaMonetario;
    
    private static List<Integer> lista;
    private static Map<Integer, Double> map;

    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        regraPrefixoTexto = new RegraPrefixoTextoImpl();
        converteValorParaMonetario = new ConverteValorParaMonetarioImpl();
        
        lista = null;
        
        map = new HashMap<>();
        map.put(1, 10.00);
        map.put(2, 35.00);
        map.put(3, 5.00);
        map.put(4, 1500.00);
        map.put(5, 0.30);
        
        if ((Objects.nonNull(lista)) && (!lista.isEmpty())) {
            versaoGerador = new GeradorObservacao();
        } else {
            versaoGerador = new GeradorObservacaoV2(regraPrefixoTexto, converteValorParaMonetario);
        }
        
        String resultado = versaoGerador.geraObservacao(lista, map);
        
        System.out.println(resultado);
    }
    
}