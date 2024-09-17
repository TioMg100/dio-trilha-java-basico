package org.dio;

import modelo.Conta;

import java.util.Scanner;
import java.util.function.Function;

public class ContaTerminal {
    public static void main(String[] args) {

        Conta conta = new Conta();
        Scanner entrada = new Scanner(System.in);
        boolean controle = true;
        //-----------
        Function<String, String> dados = (e) -> {

            if (e.contains(",")) {

                e = e.replace(",", ".");
                return e;
            } else {
                return e;
            }

        };
        //------------------
        while (controle) {
            System.out.println(" Por favor, digite o número da Agência !");
            try {
                conta.setNumero(Integer.valueOf(entrada.nextLine()));

                controle = false;
            } catch (Exception e) {
                controle = true;
                System.out.println("Entre com um dado valido !!! ");

            }
        }
        controle = true;
        while (controle) {
            System.out.println(" Por favor, digite o nome da Agência !");
            try {
                conta.setAgencia(entrada.nextLine());
                if(conta.getAgencia().trim().length()>0){controle = false;}

            }catch (Exception e) {
                controle = true;
                System.out.println("Entre com um dado valido !!! ");

            }
        }
        controle = true;
        while (controle) {

            System.out.println(" Por favor, digite o nome do Cliente !");
            try {
                conta.setNomeCliente(entrada.nextLine());
                if(conta.getNomeCliente().trim().length()>0){controle = false;}
            }catch (Exception e) {

                System.out.println("Entre com um dado valido !!! ");
                controle = true;
            }
        }
        controle = true;
        while (controle) {
            System.out.println(" Por favor, digite o saldo !");
            try {
                conta.setSaldo(Double.valueOf(dados.apply(entrada.nextLine())));
                controle = false;
            }catch (Exception e) {

                System.out.println("Entre com um dado valido !!! ");
                controle = true;
            }
        }

        System.out.println("");
        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", conta.getNomeCliente(), conta.getAgencia(), conta.getNumero(), conta.getSaldo());
        entrada.close();


    }
}