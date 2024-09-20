package org.dio.modelo;

import org.dio.interfaces.Iconta;

public abstract class Conta implements Iconta {
    private static  int sequencial=1;
    private static  final int agenciaPadrao = 001;


    protected Integer nConta;
    protected Integer nAgecia;
    protected String nomeCliente;
    protected Double saldo;

    public Conta(String nomeCliente) {
        this.nConta = sequencial++;
        this.nAgecia = agenciaPadrao;
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0;
    }

    @Override
    public void sacar(double valor) {
        saldo-= valor;
    }

    @Override
    public void deposito(double valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Conta cdestino, double valor) {
    this.sacar(valor);
    cdestino.deposito(valor);
    }


    protected void imprimirInfos() {
        System.out.println(" Conta: "+getnConta());
        System.out.println(" Agencia: "+getnAgecia());
        System.out.println(" Cliente:"+getNomeCliente());
        System.out.printf(" Saldo: R$%.2f\n",getSaldo());
    }

    //-------------------get-----------------------------
    public Integer getnConta() {
        return nConta;
    }

    public Integer getnAgecia() {
        return nAgecia;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public Double getSaldo() {
        return saldo;
    }


}
