package org.dio;

import org.dio.modelo.CCorrente;
import org.dio.modelo.Cpoupanca;

public class Main {
    public static void main(String[] args) {


        CCorrente cCorrente = new CCorrente("chrystian",2000.00);
        cCorrente.imprimirExtrato();
        Cpoupanca cpoupanca = new Cpoupanca("Miguel",0.01);
        cpoupanca.imprimirExtrato();


        cCorrente.transferir(cpoupanca,3600.00);
        cCorrente.deposito(150);
        cCorrente.transferir(cpoupanca,350.00);
        cpoupanca.imprimirExtrato();
        cCorrente.imprimirExtrato();
    }
}