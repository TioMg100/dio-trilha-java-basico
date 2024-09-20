package org.dio.modelo;

public class CCorrente extends Conta {

    private double limiteChequeEspecial;

    public CCorrente(String nomeCliente, double limiteChequeEspecial) {
        super( nomeCliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    @Override
    public void sacar(double valor) {
        if (saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (saldo + limiteChequeEspecial >= valor) {
            saldo -= valor;
            destino.deposito(valor);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("-------------------------------------------------------------------------------------------------------\n\n");
        System.out.println("Extrato conta CORRENTE");
        super.imprimirInfos();
        System.out.printf("\n Limite do cheque especial %.2f",limiteChequeEspecial);
        System.out.printf("\n Limite do cheque especial utilizado %.2f\n", Math.abs(saldo));
        System.out.println("-------------------------------------------------------------------------------------------------------\n\n");
    }
}




