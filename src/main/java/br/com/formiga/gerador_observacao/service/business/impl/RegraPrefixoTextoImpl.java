
package br.com.formiga.gerador_observacao.service.business.impl;


import br.com.formiga.gerador_observacao.service.business.RegraPrefixoTexto;
import br.com.formiga.gerador_observacao.service.business.constants.TextoConstants;


/**
 *
 * @author formiga
 */
public class RegraPrefixoTextoImpl implements RegraPrefixoTexto {

    @Override
    public String retornarPrefixo(int valor) {
        
        if (valor == 1) {
            return TextoConstants.PREFIXO_TEXTO_SINGULAR;
        } else if (valor > 1) {
            return TextoConstants.PREFIXO_TEXTO_PLURAL;
        } else {
            return "";
        }
    }
    
}