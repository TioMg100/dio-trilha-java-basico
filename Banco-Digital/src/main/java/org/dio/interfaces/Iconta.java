package org.dio.interfaces;

import org.dio.modelo.Conta;

public interface Iconta {

    public  void sacar(double valor);
    public  void deposito(double valor);
    public  void transferir(Conta destino, double valor);
    void  imprimirExtrato();


}
