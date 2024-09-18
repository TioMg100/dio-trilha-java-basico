package Java.Modelo;


import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Dados {

    private String nome;
    private String descricao;
    private Double valor;
    private Date data;
    private int status;


    public Dados() {

    }

    public Dados(String nome, String descricao, Double valor, Date data, int status) {
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.data = data;
        this.status = status;
    }

    public Dados(String nome, String descricao, Double valor, String data, int status) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setValor(valor);
        this.setData(data);
        this.setStatus(status);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValor() {
        return valor;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(String dataString) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate localDate = LocalDate.parse(dataString, formato);
        java.sql.Date dataSql = java.sql.Date.valueOf(localDate);

        this.data = dataSql;
    }


}

