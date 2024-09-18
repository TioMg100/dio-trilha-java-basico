package Java.Dao;

import Java.Modelo.Dados;
import Java.conexao.Conexao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DadosDao {

    public boolean cadastrarDados(Dados despesa)  {

        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM `despesas` WHERE `nome` LIKE ? ";
        ResultSet resultado;
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + despesa.getNome() + "%");
            resultado = stmt.executeQuery();
            //stmt.close();


            if (!resultado.next()) {

                sql = "INSERT INTO despesas (nome, descricao, valor, data, status" +
                        ") VALUES (?,?,?,?,?) ";
                try {
                    stmt = conexao.prepareStatement(sql);
                    stmt.setString(1, despesa.getNome());
                    stmt.setString(2, despesa.getDescricao());
                    stmt.setDouble(3, despesa.getValor());
                    stmt.setDate(4, despesa.getData());
                    stmt.setInt(5, despesa.getStatus());
                    stmt.execute();


                    stmt.close();
                    return true;
                } catch (SQLException e) {
                    System.out.println("Entre com um nome valido");
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println("Entre com um nome valido");
            return false;
        }

        return false;
    }

    public List<Dados> retornarDados(String nome) {


        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM `despesas` WHERE `nome` LIKE ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, "%" + nome + "%");
            ResultSet resultado = stmt.executeQuery();

            List<Dados> despesas = new ArrayList<>();


            while (resultado.next()) {

                despesas.add(new Dados(resultado.getString("nome"), resultado.getString("descricao"), resultado.getDouble("valor"), resultado.getDate("data"), resultado.getInt("status")));
            }


            stmt.close();

            return despesas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Dados> retornarTodosOsDados() {


        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM `despesas` ORDER BY `despesas`.`data` ASC ";
        try {
            Statement stmt = conexao.createStatement();
            ResultSet resultado = stmt.executeQuery(sql);

            List<Dados> despesas = new ArrayList<>();


            while (resultado.next()) {

                despesas.add(new Dados(resultado.getString("nome"), resultado.getString("descricao"), resultado.getDouble("valor"), resultado.getDate("data"), resultado.getInt("status")));
            }


            stmt.close();

            return despesas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Dados> retornaPeriodo(String ano, String mes) {


        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM despesas WHERE  YEAR(data) = ? and MONTH(data) = ?   ORDER BY `despesas`.`data` ASC";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, ano);
            stmt.setString(2, mes);
            ResultSet resultado = stmt.executeQuery();
            List<Dados> despesas = new ArrayList<>();

            while (resultado.next()) {

                despesas.add(new Dados(resultado.getString("nome"), resultado.getString("descricao"), resultado.getDouble("valor"), resultado.getDate("data"), resultado.getInt("status")));
            }


            stmt.close();

            return despesas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean alterarDados(String nome, String descricao, Double valor, Date data, String nomeantigo) {


        Connection conexao = Conexao.getConexao();
        String sql = " UPDATE `despesas` SET `nome` = ?, `descricao` = ?, `valor` = ?, `data` = ? WHERE `despesas`.`nome`= ?";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, descricao);
            stmt.setDouble(3, valor);
            stmt.setDate(4, new java.sql.Date(data.getTime()));
            stmt.setString(5, nomeantigo);
            stmt.executeUpdate();



            stmt.close();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public boolean deletarDados(String nome) {


        Connection conexao = Conexao.getConexao();
        String sql = "  DELETE FROM despesas WHERE nome = ?";

        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1,   nome );

            stmt.execute();
            stmt.close();

            return true;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Dados> todasAsDespesas(String ano, String mes) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM despesas WHERE  YEAR(data) = ? and MONTH(data) = ? and `status` LIKE 1";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, ano);
            stmt.setString(2, mes);
            ResultSet resultado = stmt.executeQuery();

            List<Dados> despesas = new ArrayList<>();




            while (resultado.next()) {

                despesas.add(new Dados(resultado.getString("nome"), resultado.getString("descricao"), resultado.getDouble("valor"), resultado.getDate("data"), resultado.getInt("status")));
            }


            stmt.close();

            return despesas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    public List<Dados> todasAsReceitas(String ano, String mes) {
        Connection conexao = Conexao.getConexao();
        String sql = "SELECT * FROM despesas WHERE YEAR(data) = ? and MONTH(data) = ? and `status` LIKE 2 ";
        try {
            PreparedStatement stmt = conexao.prepareStatement(sql);
            stmt.setString(1, ano);
            stmt.setString(2, mes);
            ResultSet resultado = stmt.executeQuery();

            List<Dados> despesas = new ArrayList<>();




            while (resultado.next()) {

                despesas.add(new Dados(resultado.getString("nome"), resultado.getString("descricao"), resultado.getDouble("valor"), resultado.getDate("data"), resultado.getInt("status")));
            }


            stmt.close();

            return despesas;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public Double balanco(List<Dados> dadosDespesa, List<Dados> dadosReceita) {

        Double controleDespesa = dadosDespesa.stream()
                .filter(dado -> dado.getValor() != null)
                .mapToDouble(Dados::getValor)
                .sum();


        Double controleReceita = dadosReceita.stream()
                .filter(dado -> dado.getValor() != null)
                .mapToDouble(Dados::getValor)
                .sum();

        return controleReceita - controleDespesa;
    }

    public void conexaoclose() {
        Connection conexao = Conexao.getConexao();
        try {
            conexao.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
