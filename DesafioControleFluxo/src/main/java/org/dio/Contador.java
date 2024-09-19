package org.dio;

import org.dio.excecao.ParametrosInvalidosException;

import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o primeiro parâmetro");
        int parametroUm = Integer.valueOf(scanner.next());
        System.out.println("Digite o segundo parâmetro");
        int parametroDois = Integer.valueOf(scanner.next());

        try {

            contar(parametroUm, parametroDois);

        } catch ( ParametrosInvalidosException e) {
            System.out.println("O primeiro valor tem que ser menor que o segundo valor");
        }



    }

    static void contar(int parametroUm, int parametroDois)   {

        if (parametroUm < parametroDois){
            int contagem = parametroDois - parametroUm;
            for (int i = 1; i <=contagem-1 ; i++) {
                System.out.printf("%d, ",i);

            }
                System.out.println(contagem);
        } else {

            throw new ParametrosInvalidosException();
        }


    }
}