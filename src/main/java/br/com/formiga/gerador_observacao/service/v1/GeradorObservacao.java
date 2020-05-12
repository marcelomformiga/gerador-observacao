
package br.com.formiga.gerador_observacao.service.v1;


import br.com.formiga.gerador_observacao.service.VersaoGerador;
import java.util.Iterator;
import java.util.List;
import java.util.Map;


/**
 *
 * @author formiga
 */
public class GeradorObservacao implements VersaoGerador {
    
    //Textos pré-definidos
    static final String umoNota = "Fatura da nota fiscal de simples remessa: ";
    //Identificador da entidade
    String texto;

    //Gera observações, com texto pre-definido, incluindo os números, das notas fiscais, recebidos no parâmetro
    @Override
    public String geraObservacao(List lista, Map map) 
    {
            texto = "";
            if (!lista.isEmpty()) 
            {
                    return retornaCodigos(lista) + ".";
            }		
            return "";		
    }

    //Cria observação
    private String retornaCodigos(List lista) {
            if (lista.size() >= 2) {
                    texto = "Fatura das notas fiscais de simples remessa: ";
            } else {
                    texto = umoNota;
            }

            //Acha separador
            StringBuilder cod = new StringBuilder();
            for (Iterator<Integer> iterator = lista.iterator(); iterator.hasNext();) {
                    Integer c = iterator.next();
                    String s = "";
                    if( cod.toString() == null || cod.toString().length() <= 0 )
                            s =  "";
                            else if( iterator.hasNext() )
                                    s =  ", ";
                            else
                                    s =  " e ";

                    cod.append(s + c);
            }

            return texto + cod;
    }

}