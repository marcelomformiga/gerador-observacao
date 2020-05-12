
package br.com.formiga.gerador_observacao.service;


import java.util.List;
import java.util.Map;


/**
 *
 * @author formiga
 */
public interface VersaoGerador {
    
    abstract String geraObservacao(List<Integer> lista, Map<Integer, Double> map);
}