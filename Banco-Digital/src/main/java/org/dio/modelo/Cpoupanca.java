package org.dio.modelo;

public class Cpoupanca extends Conta{

    private double taxaRendimento;

    public Cpoupanca(String nomeCliente, double taxaRendimento) {
        super(nomeCliente);
        this.taxaRendimento = taxaRendimento;
    }



    @Override
    public void sacar(double valor) {
        if (saldo >= valor) {
            saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }

    @Override
    public void transferir(Conta destino, double valor) {
        if (saldo >= valor) {
            saldo -= valor;
            destino.deposito(valor);
        } else {
            System.out.println("Saldo insuficiente para transferência.");
        }
    }
    @Override
    public void imprimirExtrato() {
        System.out.println("-------------------------------------------------------------------------------------------------------\n\n");
        System.out.println("Extrato conta POUPANÇA");
        super.imprimirInfos();
        System.out.println("-------------------------------------------------------------------------------------------------------\n\n");
    }

    public void calcularRendimentoMensal() {
        saldo += saldo * taxaRendimento;
    }

    public double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }
}
