
package br.com.formiga.gerador_observacao.service.v2;


import br.com.formiga.gerador_observacao.service.VersaoGerador;
import br.com.formiga.gerador_observacao.service.business.ConverteValorParaMonetario;
import br.com.formiga.gerador_observacao.service.business.RegraPrefixoTexto;
import br.com.formiga.gerador_observacao.service.business.constants.TextoConstants;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 *
 * @author formiga
 */
public class GeradorObservacaoV2 implements VersaoGerador {
    
    private final RegraPrefixoTexto regraPrefixoTexto;
    private final ConverteValorParaMonetario converteValorParaMonetario;

    
    public GeradorObservacaoV2(RegraPrefixoTexto regraPrefixoTexto, ConverteValorParaMonetario converteValorParaMonetario) {
        this.regraPrefixoTexto = regraPrefixoTexto;
        this.converteValorParaMonetario = converteValorParaMonetario;
    }
    
    @Override
    public String geraObservacao(List<Integer> lista, Map<Integer, Double> map) {
        
        if (!map.isEmpty()) {
            return retornaCodigos(map);
        }	

        return "";		
    }

    private String retornaCodigos(Map<Integer, Double> map) {
        
        String prefixoTexto = this.regraPrefixoTexto.retornarPrefixo(map.size());
        
        StringBuilder texto = new StringBuilder();
        texto.append(prefixoTexto);

        Double total = 0D;
        int indexUltimoSeparador = 0;
        
        Iterator iterator = map.entrySet().iterator();
        
        while (iterator.hasNext()) {
            Map.Entry<Integer, Double> par = (Map.Entry<Integer, Double>) iterator.next();
            
            texto.append(par.getKey().toString());
            texto.append(TextoConstants.TEXTO_INTERMEDIARIO_DE_VALOR);
            texto.append(this.converteValorParaMonetario.converter(par.getValue()));
            
            total += par.getValue();
            
            if (iterator.hasNext()) {
                texto.append(TextoConstants.VIRGULA);
                
                indexUltimoSeparador = texto.length() - 1;
            } else {
                
                if (map.size() > 1) {
                    texto.replace(indexUltimoSeparador, indexUltimoSeparador + 1, TextoConstants.E);
                }
                
                texto.append(TextoConstants.PONTO);
                texto.append(TextoConstants.TOTAL);
                texto.append(this.converteValorParaMonetario.converter(total));
                texto.append(TextoConstants.PONTO);
            }
        }
        
        return texto.toString();
    }
    
}