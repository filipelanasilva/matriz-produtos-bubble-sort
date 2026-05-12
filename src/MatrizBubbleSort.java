
import java.util.Scanner;  // Importa a classe Scanner para a possibilitação da chamada de seus respectivos métodos

public class MatrizBubbleSort {

    public static void main(String[] args) {  // Programa que recebe uma lista de produtos, cada um com seus respectivos códigos
                                              // nomes e valores, logo após, o usuário escolhe no console se deseja visualizar a
                                              // lista do menor código ao maior, pelos nomes começando de A até Z ou do menor
                                              // valor ao maior.

        Scanner scanner = new Scanner(System.in);  // Criação de objeto para aceitar valores vindos do usuário

        System.out.println("Bem-vindo(a) a sua lista de produtos!");
        System.out.print("Digite a quantidade total de produtos a serem listados: ");
        int quantidadeProdutos = scanner.nextInt();

        String[][] produtos = new String[quantidadeProdutos][3];  // Matriz contendo como quantidade de linhas, o valor da variável
                                                                  // (quantidadeProdutos) e um total de três colunas, índice [0] contendo código
                                                                  // dos produtos, assim como índice [1] seus nomes e o índice [2] os valores

        recebeProdutos(produtos, scanner);  // Chamada de método que atribuí a cada linha e coluna da matriz, seus devidos valores com base em
                                            // código, nome e valor de cada produto

        System.out.println("\nComo gostaria de visualizar a lista?");
        System.out.print("[0] do menor ao maior código \n[1] dos nomes de A - Z \n[2] do menor ao maior valor \nDigite sua resposta aqui: ");
        int resposta = scanner.nextInt();  // Variável que recebe como valor, o número digitado como resposta pelo usuário

        scanner.close();  // Fechamento do objeto scanner para liberação de mémoria e recursos

        switch (resposta) {  // Switch para a chamada de um método com base na escolha do usuário atribuída como valor da variável (resposta)

            case 0:  // Caso o usuário digite 0 como resposta, um método de classificação dos produtos, do menor ao maior código é chamado
                produtosPorCodigo(produtos);

            case 1:  // Caso o usuário digite 1 como resposta, um método de classificação dos nomes de A - Z é chamado
                produtosPorNome(produtos);

            case 2:  // Caso o usuário digite 2 como resposta, um método de classificação dos produtos do menor valor ao maior é chamado
                produtosPorValor(produtos);

        }

    }












    private static void recebeProdutos(String[][] arg1, Scanner arg2) {  // Método para receber input do usuário, guarda os valores na matriz do tipo
                                                                         // String (arg1) através de um objeto da classe Scanner atribuído a (arg2)

        System.out.print("\nLISTAGEM DOS PRODUTOS");

        for (int i = 0; i < arg1.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de
                                                 // linhas da matriz arg1

            for (int j = 0; j < arg1[i].length; j++) {  // Loop for que se repete enquanto (j) possuir um valor menor que a quantidade total de
                                                        // colunas da matriz arg1

                switch (j) {  // Switch para receber input do usuário com base nas colunas da matriz de arg1, na sequência de 0 que recebe o código dos
                              // de cada produto, 1 que recebe os nomes e 2 que recebe os valores

                    case 0:
                        System.out.printf("\nDigite o código númerico do %d° produto da lista: ", i + 1);
                        arg1[i][j] = arg2.next();  // Recebe o código do produto a ser armazenado na linha respectiva ao valor atual de (i) da coluna 0
                        break;
                    case 1:
                        System.out.printf("Digite o nome do %d° produto da lista: ", i + 1);
                        arg1[i][j] = arg2.next();  // Recebe o nome do produto a ser armazenado na linha respectiva ao valor atual de (i) da coluna 1
                        break;
                    case 2:
                        System.out.printf("Digite o valor do %d° produto da lista: ", i + 1);
                        arg2.nextLine();  // Prevenção de bug da classe Scanner
                        arg1[i][j] = arg2.next();  // Recebe o valor do produto a ser armazenado na linha respectiva ao valor atual de (i) da coluna 2
                        break;
                }

            }

        }

    }

    private static void produtosPorCodigo(String[][] arg) {  // Método que espera receber como argumento uma matriz do tipo String contendo todos os
                                                             // produtos listados fora de ordem pelo o usuário, para assim, ordená-los de forma
                                                             // crescente do menor código ao maior

        Integer[] codigoProdutos = new Integer[arg.length];  // Vetor do tipo não primitivo Integer com sua quantidade total de índices sendo a mesma
                                                             // que a quantidade total de linhas da matriz arg

        for (int i = 0; i < arg.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de
                                                // linhas da matriz arg

            codigoProdutos[i] = Integer.parseInt(arg[i][0]);  // O índice respectivo ao valor atual de (i) no vetor codigoProdutos recebe o
                                                              // valor/código armazenado na matriz arg linha de índice (i), coluna 0 que é convertido
        }                                                     // para o tipo int


        for (int i = 0; i < codigoProdutos.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de
                                                           // índices do vetor codigoProdutos

            for (int j = 0; j < codigoProdutos.length; j++) {  // Loop for que se repete enquanto (j) possuir um valor menor que a quantidade total
                                                               // de índices do vetor codigoProdutos

                if (codigoProdutos[j] > codigoProdutos[i]) {  // If para confirmar se o valor armazenado no índice (j) do vetor codigoProdutos é
                                                              // maior que o valor do índice atual de (i)

                    int aux = codigoProdutos[i];  // Variável do tipo int que guarda o valor armazenado no índice (i) do vetor codigoProdutos
                    codigoProdutos[i] = codigoProdutos[j];  // Valor do índice (i) de vetor codigoProdutos é substituído pelo valor do índice (j)
                    codigoProdutos[j] = aux;  // Valor do índice (j) de vetor codigoProdutos é substituído pelo valor do índice (j) anteriormente
                                              // guardado na variável aux
                }

            }

        }

        for (int i = 0; i < arg.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de
                                                // linhas da matriz arg

            arg[i][0] = Integer.toString(codigoProdutos[i]);  // Valor da linha de índice respectivo ao valor atual no loop da variável (i),
                                                              // coluna 0, é substituído pelo valor convertido do índice (i) do vetor
        }                                                     // codigoProdutos do tipo Integer para String

        System.out.println("\nLISTA DE PRODUTOS CLASSIFICADA DO MENOR CÓDIGO AO MAIOR");
        exibeProdutos(arg);  // Chamada de método para exibir todos os produtos ordenados do menor código ao maior

    }

    private static void produtosPorNome(String[][] arg) {  // Método que espera receber como argumento uma matriz do tipo não primitivo String,
                                                           // que contém todos os produtos listados pelo usuário fora de ordem, para assim então,
                                                           // ordená-los de com base nas iniciais dos nomes de cada, começando de A indo até Z

        for (int i = 0; i < arg.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de
                                                // linhas da matriz arg

            for (int j = 0; j < arg[i].length; j++) {  // Loop for que se repete enquanto (j) possuir um valor menor que a quantidade total de
                                                       // colunas da matriz arg

                if (arg[j][1].compareTo(arg[i][1]) > 0) {  // Condição de verificação, para determinar se o valor da linha de índice respectiva
                                                           // ao valor atual no loop da variável (j), na coluna de índice 1, se comparado
                                                           // de forma lexicográfica ao valor da linha de índice (i), coluna 1, retorna um valor
                                                           // maior que 0

                    String aux = arg[i][1];  // Variável de auxílio do tipo não primitivo String, guarda o valor da linha (i), coluna 1 da matriz arg
                    arg[i][1] = arg[j][1];  // Linha (i), coluna 1 da matriz arg recebe o valor da linha (j), coluna 1
                    arg[j][1] = aux;  // Linha (j), coluna 1 da matriz arg recebe o antigo valor da linha (i), coluna 1 guardado na variável de
                                      // auxílio anteriormente
                }

            }

        }

        System.out.println("\nLISTA DE PRODUTOS CLASSIFICADA POR NOMES DE A - Z");
        exibeProdutos(arg);  // Chamada de método para exibir todos os produtos ordenados por seus nomes começando com aqueles de inicial A até Z

    }

    private static void produtosPorValor(String[][] arg) {  // Método que espera receber como argumento uma matriz do tipo não primitivo String,
                                                            // que contém todos os produtos listados pelo usuário fora de ordem, para assim então,
                                                            // ordená-los de com base nos valores de cada um deles, começando do mais barato ao
                                                            // mais caro

        Double[] valorProdutos = new Double[arg.length];  // Vetor do tipo não primitivo Double com sua quantidade total de índices sendo a mesma
                                                          // que a quantidade total de linhas da matriz arg

        for (int i = 0; i < arg.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de linhas da
                                                // matriz arg

            valorProdutos[i] = Double.valueOf(arg[i][2]);  // O índice respectivo ao valor atual de (i) no vetor valorProdutos recebe o valor
                                                           // do produto armazenado na matriz arg linha de índice (i), coluna 2 que é convertido
        }                                                  // para o tipo double


        for (int i = 0; i < valorProdutos.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de
                                                          // índices do vetor valorProdutos

            for (int j = 0; j < valorProdutos.length; j++) {  // Loop for que se repete enquanto (j) possuir um valor menor que a quantidade total
                                                              // de índices do vetor valorProdutos

                if (valorProdutos[j] > valorProdutos[i]) {  // If para confirmar se o valor armazenado no índice (j) do vetor valorProdutos é
                                                            // maior que o valor do índice atual de (i)

                    double aux = valorProdutos[i];  // Variável do tipo double que guarda o valor armazenado no índice (i) do vetor valorProdutos
                    valorProdutos[i] = valorProdutos[j];  // Valor do índice (i) de vetor valorProdutos é substituído pelo valor do índice (j)
                    valorProdutos[j] = aux;  // Valor do índice (j) de vetor valorProdutos é substituído pelo valor do índice (j) anteriormente
                                             // guardado na variável aux
                }

            }

        }

        for (int i = 0; i < arg.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de
                                                // linhas da matriz arg

            arg[i][2] = Double.toString(valorProdutos[i]);  // Valor da linha de índice respectivo ao valor atual no loop da variável (i),
                                                            // coluna 2, é substituído pelo valor convertido do índice (i) do vetor valorProdutos
        }                                                   // do tipo Double para String

        System.out.println("\nLISTA DE PRODUTOS CLASSIFICADA DO MENOR AO MAIOR VALOR");
        exibeProdutos(arg);  // Chamada de método para exibir todos os produtos ordenados começando pelo de menor valor indo ao de maior valor

    }

    private static void exibeProdutos(String[][] arg) {  // Método que espera receber como argumento uma matriz do tipo String e exibir seus valores

        for (int i = 0; i < arg.length; i++) {  // Loop for que se repete enquanto (i) possuir um valor menor que a quantidade total de linhas da
                                                // matriz arg

            String[] aux = new String[3];  // Vetor de auxílio do tipo não primitivo String, com um total de 3 índices

            for (int j = 0; j < arg[i].length; j++) {  // Loop for que se repete enquanto (j) possuir um valor menor que a quantidade total
                                                       // de colunas da matriz arg

                switch (j) {  // Switch que com base no valor atual da variável (j), determina em qual índice do vetor de auxílio, o valor da linha (i),
                              // coluna (j) deve ser guardado

                    case 0: // índice de código do produto atual
                        aux[0] = arg[i][j];  // Valor da linha (i), coluna (j) da matriz arg é guardado no índice 0 do vetor de auxílio, respectivo
                        break;               // ao código do produto

                    case 1:  // índice do nome do produto atual
                        aux[1] = arg[i][j];  // Valor da linha (i), coluna (j) da matriz arg é guardado no índice 1 do vetor de auxílio, respectivo
                        break;               // ao nome do produto

                    case 2:  // índice do valor do produto atual
                        aux[2] = arg[i][j];  // Valor da linha (i), coluna (j) da matriz arg é guardado no índice 2 do vetor de auxílio, respectivo
                        break;               // ao valor do produto
                }

            }

            System.out.printf("%d° Produto = Código %s | Nome %s | Valor R$%s\n", i + 1, aux[0], aux[1], aux[2]);

        }

    }

}
