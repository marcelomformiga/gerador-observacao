
package br.com.formiga.gerador_observacao.service.business.impl;


import br.com.formiga.gerador_observacao.service.business.ConverteValorParaMonetario;
import br.com.formiga.gerador_observacao.service.business.constants.TextoConstants;


/**
 *
 * @author formiga
 */
public class ConverteValorParaMonetarioImpl  implements ConverteValorParaMonetario {

    @Override
    public String converter(final Double valor) {
        
        StringBuilder valorMonetario = new StringBuilder();
        valorMonetario.append(TextoConstants.CIFRAO);
        valorMonetario.append(valor.toString());
        
        String valorDividido[] = valorMonetario.toString().replace(".", "-").split("-");
        
        String valorMonetarioString = valorDividido[0].concat(",");
        String centavos = valorDividido[1];
        
        if (centavos.length() == 1) {
            centavos = centavos.concat("0");
        } else {
            centavos = centavos.substring(0, 2);
        }
        
        return valorMonetarioString.concat(centavos);
    }
    
}