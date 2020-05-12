# Gerador Observação

Projeto simples para simular parte de uma geração de relatório. Desafio proposto pela empresa Softplan.
Desenvolvido com os princípios do SOLID.

## Tecnologias

Projeto Java 8 criado com Maven e desenvolvido com a IDE NetBeans 11.

Os testes unitários foram gerados com o JUnit em conjunto Mockito.

## Arquitetura

Foi montada uma arquitetura simples de um projeto monolítico apenas para atender a proposta do desafio.
Há uma camada <b>service</b> que monta o relatório. Também conecta com as classes e interfaces de negócio. Essa camada contém o pacote <b>business</b> com as regras de negócio da aplicação.
Para versionar a classe <b>GeradorObservacao</b> conforme solicitado, foi criada uma nova classe chamada <b>GeradorObservacaoV2</b> e mantida a original. Ambas as classes implementam a interface <b>VersaoGerador</b>.
Caso seja passado como parâmetro uma lista de inteiros, conforme a versão 1 necessita, então chama a classe original, caso contrário chama a V2 que possui um "map" com os valores atribuídos a lista de inteiros, conforme proposto no exercício.
Esse exemplo de chamada pode ser verificada na classe <b>Application</b> que contém o método "main".
A arquitetura proposta, tentou seguir os padrões e princípios do SOLID, separando as principais atribuições do sistema em diferentes interfaces.

### Pontos Fracos da arquitetura original

Há muitas atribuições dentro da classe original que poderiam ser divididas em outras classes, mantendo assim uma coesão mais forte da classe, com menos responsabilidades cada uma delas, conforme os princípios do SOLID orientam.

### Motivação para melhoria

Além de ter que manter a funcionalidade original funcionando, sendo necessário versionar o sistema, a principal motivação foi seguir os princípios orientados do SOLID, que hoje está consolidado no mercado como referência de uma boa arquitetura.
Suas características, mantém um código mais fácil de manter, realizar ajustes e até facilitar a leitura de outros desenolvedores.

## Executar

Para executar a aplicação, é só executar a classe <b>Application</b>, onde há um exemplo da chamada para a versão 2, recebendo como parâmetro os valores propostos como exemplo no exercício.