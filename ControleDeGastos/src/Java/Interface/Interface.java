package Java.Interface;

import Java.Dao.DadosDao;
import Java.Modelo.Dados;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Interface {
    public static void main(String[] args) {

        //  Bloco de variaveis
        String nome;
        List<Dados> despesas;
        int swt;
        int status;
        Double valor;
        boolean controle;
        boolean controle2 = true;
        boolean controle3 = true;
        boolean resposta;
        boolean sair = true;
        String ano;
        String mes;
        String a;
        String descricao;
        Date data;


        System.out.println(" *********** Menu *********** ");
        Scanner entrada = new Scanner(System.in);
        while (sair) {

            System.out.println("           *****************************************************");
            System.out.println("           *                Escolha uma das opçoes             *");
            System.out.println("           *       1 - Todas os dados                          *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       2 - Fazer busca por nome                    *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       3 - Fazer busca por data                    *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       4 - Fazer busca por mes e ano               *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       5 - Adicionar Receita ou Despesa            *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       6 - Editar dados                            *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       7 - Apagar dados                            *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       8 - Balanço do mes                          *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *       9 - Sair                                    *"); // funcionando ok - Não mata mais a aplicação caso valores errados
            System.out.println("           *****************************************************");

            String i = entrada.nextLine();

            if (i.equals("")) {
                i = "20";
            }

            swt = Integer.valueOf(i);

            switch (swt) {
                case 1:
                    despesas = new DadosDao().retornarTodosOsDados();
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    for (Dados d : despesas) {
                        System.out.println("NOME: " + d.getNome() + "| DESCRIÇÂO: " + d.getDescricao() + "| VALOR R$" + d.getValor() + "| DATA:" + d.getData());
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {
                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;
                                break;
                            default:
                                System.out.println("!Opção invalida!");
                        }
                    }

                    break;
                case 2:

                    System.out.println("Entre com o nome:");
                    nome = entrada.nextLine();
                    despesas = new DadosDao().retornarDados(nome);
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    for (Dados d : despesas) {
                        System.out.println("NOME: " + d.getNome() + "| DESCRIÇÂO: " + d.getDescricao() + "| VALOR R$" + d.getValor() + "| DATA:" + d.getData());
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {

                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;
                                break;
                            default:
                                System.out.println("!Opção invalida!");
                        }
                    }
                    break;
                case 3:
                    controle2 = true;
                    while (controle2) {
                        try {
                            System.out.println("Entre com o Data: dd/mm/aaaa");
                            String t = entrada.nextLine();
                            Date data2 = new InterfaceFucao().converterData(t);

                            despesas = new DadosDao().retornarTodosOsDados();
                            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                            despesas.stream().filter(d -> d.getData().equals(data2))
                                    .map(d -> "NOME: " + d.getData() + "| DESCRIÇÂO: " + d.getDescricao() + "| VALOR R$" + d.getValor() + "| DATA:" + d.getData())
                                    .forEach(System.out::println);
                            controle2 = false;
                        } catch (Exception e) {

                            System.out.println(" Entre com o dado correto");

                        }
                    }

                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {

                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;
                                break;
                            default:
                                System.out.println("!Opção invalida!");
                        }
                    }

                    break;
                case 4:

                    System.out.println("Entre com o ano:");
                    ano = entrada.nextLine();
                    System.out.println("Entre com o mes:");
                    mes = entrada.nextLine();
                    despesas = new DadosDao().retornaPeriodo(ano, mes);
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    for (Dados d : despesas) {
                        System.out.println("NOME: " + d.getNome() + "| DESCRIÇÂO: " + d.getDescricao() + "| VALOR R$" + d.getValor() + "| DATA:" + d.getData());
                    }
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {


                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;
                                break;
                            default:
                                System.out.println("!Opção invalida!");
                        }
                    }

                    break;
                case 5:
                    controle2 = true;
                    while (controle2) {
                        System.out.println("        *****************************");
                        System.out.println("        *        1 - Despesa        *");
                        System.out.println("        *        2 - Receita        *");
                        System.out.println("        *****************************");

                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }

                        status = Integer.valueOf(i);
                        if (status == 1 || status == 2) {
                            controle3 = true;
                            while (controle3) {
                                try {

                                    System.out.println("Entre com o nome:");
                                    nome = entrada.nextLine();
                                    System.out.println("Entre com o descrição:");
                                    descricao = entrada.nextLine();
                                    System.out.println("Entre com o valor R$:");
                                    i = entrada.nextLine();
                                    valor = Double.valueOf(i);
                                    System.out.println("Entre com a data:");
                                    a = entrada.nextLine();
                                    data = new InterfaceFucao().converterData(a);

                                    resposta = new DadosDao().cadastrarDados(new Dados(nome, descricao, valor, data, status));
                                    System.out.printf("Dado  %s ", resposta ? "SALVO\n" : "NÂO SALVO\n");

                                    controle3 = false;
                                    controle2 = false;
                                } catch (Exception e) {
                                    controle3 = true;
                                    System.out.println("ENTRE COM VALORES VALIDOS");
                                }


                            }

                        } else {
                            controle2 = true;
                            System.out.println("Entre com um opção valida");


                        }
                    }

                    System.out.println("");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {

                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;
                                break;
                            default:
                                System.out.println("!Opção invalida!");
                        }
                    }
                    break;
                case 6:
                    controle2 = true;
                    while (controle2) {
                        try {
                            System.out.println("Entre com o NOME ANTIGO:");
                            String antigo = entrada.nextLine();

                            System.out.println("Entre com o NOME NOVO:");
                            nome = entrada.nextLine();

                            System.out.println("Entre com o DESCRIÇÂO NOVO:");
                            descricao = entrada.nextLine();

                            System.out.println("Entre com o VALOR NOVO R$:");
                            i = entrada.nextLine();
                            valor = Double.valueOf(i);

                            System.out.println("Entre com a DATA NOVA:");
                            a = entrada.nextLine();

                            data = new InterfaceFucao().converterData(a);

                            resposta = new DadosDao().alterarDados(nome, descricao, valor, data, antigo);

                            System.out.printf("Dado + %s ", resposta ? "SALVO \n" : "NÂO SALVO\n");

                            controle2 = false;

                        } catch (Exception e) {

                            System.out.println("!!!!!ENTRE COM DADOS VALIDOS!!!!!! \n ");
                            controle2 = true;
                        }
                    }
                    System.out.println("");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {

                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;
                                break;
                            default:
                                System.out.println("!Opção invalida!");
                        }
                    }
                    break;
                case 7:

                    System.out.println("Entre com o nome:");
                    nome = entrada.nextLine();
                    if (i.equals("")) {
                        i = " Não pode ser nulo se nao apaga tudo o banco FOI CORRIGIDO";
                    }
                    resposta = new DadosDao().deletarDados(nome);
                    System.out.printf("Dado  %s  ", resposta ? "APAGADO" : " NÂO ENCONTRADO");
                    System.out.println("");
                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {

                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;

                        }
                    }
                    break;
                case 8:
                    System.out.println("Entre com o ano:");
                    ano = entrada.nextLine();
                    System.out.println("Entre com o mes:");
                    mes = entrada.nextLine();


                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");

                    List<Dados> despesasD = new DadosDao().todasAsDespesas(ano, mes);
                    System.out.println(" Despesas do mes" + mes + "/" + ano);
                    for (Dados d : despesasD) {
                        System.out.println("NOME: " + d.getNome() + "| DESCRIÇÂO: " + d.getDescricao() + "| VALOR R$" + d.getValor() + "| DATA:" + d.getData());
                    }

                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.println(" Receitas do mes" + mes + "/" + ano);
                    List<Dados> receitaD = new DadosDao().todasAsReceitas(ano, mes);
                    for (Dados d : receitaD) {
                        System.out.println("NOME: " + d.getNome() + "| DESCRIÇÂO: " + d.getDescricao() + "| VALOR R$" + d.getValor() + "| DATA:" + d.getData());
                    }
                    Double resultado = new DadosDao().balanco(despesasD, receitaD);


                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");
                    System.out.printf(" RS: %f  %s \n", resultado, resultado >= 0 ? " Saldo positivo " : " Saldo negativo ");

                    System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------- ");

                    System.out.println("");
                    System.out.println("        *****************************");
                    System.out.println("        * 1 - Sair                  *");
                    System.out.println("        * 2 - Fazer outra operação  *");
                    System.out.println("        *****************************");
                    controle = false;
                    while (sair && controle == false) {

                        i = entrada.nextLine();
                        if (i.equals("")) {
                            i = "3";
                        }
                        swt = Integer.valueOf(i);
                        switch (swt) {
                            case 1:
                                sair = false;
                                break;
                            case 2:

                                controle = true;

                        }
                    }

                    break;
                case 9:
                    sair = false;

                    break;
                default:
                    System.out.println("!Opção invalida!");


            }
            System.out.println("\n\n\n\n\n\n\n\n\n");
        }

        new DadosDao().conexaoclose();
        entrada.close();
    }
}

