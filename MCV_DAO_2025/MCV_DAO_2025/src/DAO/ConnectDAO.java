/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Model.Clientes;
import Model.Produtos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Alunos
 */
public class ConnectDAO {

    Connection con;

    public Connection connectDB() {
        JOptionPane.showMessageDialog(null, "Inicia a classe para " + "conexão com SQL SERVER!");

        String caminho = "jdbc:sqlserver://localhost:1433;" + "databaseName=MOV_CONTA_CORRENTE;" + "encrypt=true;trustServerCertificate=true;";
        String usuario = "sa"; //"sa"
        String senha = ".";    //"."

        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            JOptionPane.showMessageDialog(null, "Conectado com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão" + " connectDAO - Mensagem => " + erro.getMessage());

            JOptionPane.showMessageDialog(null, "Erro de conexão," + " connectDAO - Estado => " + erro.getSQLState());

            JOptionPane.showMessageDialog(null, "Erro de conexão," + " connectDAO - Código => " + erro.getErrorCode());
        }
        return con;
    }

    public void Fechar() {
        try {
            con.close();
            JOptionPane.showMessageDialog(null, "Conexão fechada com sucesso!");

        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro de conexão" + " connectDAO - Mensagem => " + erro.getMessage());

            JOptionPane.showMessageDialog(null, "Erro de conexão" + " connectDAO - Estado => " + erro.getSQLState());

            JOptionPane.showMessageDialog(null, "Erro de conexão" + " connectDAO - Código =>" + erro.getErrorCode());
        }

    }

    public void insereRegistroJFDB(String tabela, String strDados) {
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();

            String sql = "INSERT INTO dbo." + tabela + " VALUES (" + strDados + ")";
            JOptionPane.showMessageDialog(null, "String de Insert: " + sql);
            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso!");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão,"
                        + "connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de conexão,"
                        + "connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de conexão,"
                        + "connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Clientes pesquiseClienteJFDB(String tabela, String pesquisaId) {
        Clientes clientesReturn = new Clientes();
        String tabelaSGBD = "CLIENTES"; //CLIENTES
        if (tabela.equals(tabelaSGBD)) {
            // FAZER À PESQUISA E RETORNARA TABELA COMO RESULTADO
            con = connectDB(); //executa o método que conecta no DB e ret

            Statement stmt;

            try {
                stmt = con.createStatement();
                // Cria a string com a sentença SQL para inserir registro

                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                try {
                    //Executar a sentença de insert
                    // stmt = con,prepareStatement(sql);
                    // JOptionPane.showMessageDialog (null, "Vai execitar a query com; "+sql""
                    ResultSet dados;
                    dados = stmt.executeQuery(sql);
                    if (dados.next() == false) {

                        JOptionPane.showMessageDialog(null, "Nenhum registro foi " + "encontrado para essa pesquisa");
                    } else {
                        clientesReturn.setId_cli(dados.getInt(1));
                        clientesReturn.setNome_cli(dados.getString(2));
                        clientesReturn.setEnde_cli(dados.getString(3));
                        clientesReturn.setNume_cli(dados.getString(4));
                        clientesReturn.setComlp_cli(dados.getString(5));
                        clientesReturn.setBair_cli(dados.getString(6));
                        clientesReturn.setCida_cli(dados.getString(7));
                        clientesReturn.setUf_cli(dados.getString(8));
                        clientesReturn.setCep_cli(dados.getString(9));
                        clientesReturn.setFone_cli(dados.getString(10));
                        clientesReturn.setCpf_cli(dados.getString(11));
                        clientesReturn.setData_nasc(dados.getString(12));
                        clientesReturn.setCnpj_cli(dados.getString(13));

                    }
                    con.close();

                    return clientesReturn;
                } catch (SQLException erro) {
                    JOptionPane.showMessageDialog(null, "Erro de conexão," + " connectDAO Consulta - Mensagem => " + erro.getMessage());
                    JOptionPane.showMessageDialog(null, "Erro de conexão," + " connectDAO - Estado => " + erro.getSQLState());
                    JOptionPane.showMessageDialog(null, "Erro de conexão," + "connectDAO - Código => " + erro.getErrorCode());
                }
                con.close();
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return clientesReturn;
    }

    public Produtos pesquiseProdutoJFDB(String tabela, String pesquisaId) {
        Produtos prodReturn = new Produtos();
        String tabelaSGBD = "PRODUTOS";

        if (tabela.equalsIgnoreCase(tabelaSGBD)) {
            con = connectDB();

            try {
                Statement stmt = con.createStatement();
                String sql = "SELECT * FROM " + tabela + " WHERE " + pesquisaId;

                ResultSet dados = stmt.executeQuery(sql);

                if (!dados.next()) {
                    JOptionPane.showMessageDialog(null,
                            "Nenhum produto encontrado com esse código!");
                } else {
                    prodReturn.setCdProduto(dados.getInt("CdProduto"));
                    prodReturn.setDtCadastro(dados.getString("dtCadastro"));
                    prodReturn.setNome(dados.getString("Nome"));
                    prodReturn.setTipo(dados.getString("Tipo"));
                    prodReturn.setPreco(dados.getFloat("Preco"));
                    prodReturn.setQtdTotal(dados.getInt("QtdTotal"));
                    prodReturn.setDtUltimaAtz(dados.getString("DtUltimaAtz"));
                    prodReturn.setStatus(dados.getString("Status"));
                }

                con.close();
                return prodReturn;

            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null,
                        "Erro ao consultar produto: " + erro.getMessage());
            }
        }

        return prodReturn;
    }

    public void excluiRegistroJFDB(String tabela, String pesquisaId) {
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();

            String sql = "DELETE dbo." + tabela + " WHERE (" + pesquisaId + ")";
            // JOptionPane.showMessageDialog(null, "String de Insert: " + sql);
            try {
                stmt.executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Inclusão executada com sucesso!");
            } catch (SQLException erro) {
                JOptionPane.showMessageDialog(null, "Erro de conexão,"
                        + "connectDAO - Mensagem => " + erro.getMessage());
                JOptionPane.showMessageDialog(null, "Erro de conexão,"
                        + "connectDAO - Estado => " + erro.getSQLState());
                JOptionPane.showMessageDialog(null, "Erro de conexão,"
                        + "connectDAO - Código => " + erro.getErrorCode());
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void alteraRegistroJFDB(String tabela, String valores, String pesquisaId) {
        con = connectDB();
        Statement stmt;
        try {
            stmt = con.createStatement();
            String sql = "UPDATE dbo." + tabela + " SET " + valores + " WHERE " + pesquisaId;
            System.out.println("SQL gerado: " + sql); // ajuda a verificar se está certo

            int linhasAfetadas = stmt.executeUpdate(sql);
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Alteração executada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum registro foi alterado. Verifique o ID informado.");
            }

            con.close();
        } catch (SQLException erro) {
            JOptionPane.showMessageDialog(null, "Erro ao alterar registro: " + erro.getMessage());
        }
    }

    public ArrayList<Clientes> listarTodos() {
        ArrayList<Clientes> lista = new ArrayList<>();
        ConnectDAO conexao = new ConnectDAO();
        Connection conn = conexao.connectDB();

        try {
            String sql = "SELECT * FROM CLIENTES";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Clientes c = new Clientes();

                c.setId_cli(rs.getInt("ID_CLI"));
                c.setNome_cli(rs.getString("NOME_CLI"));
                c.setEnde_cli(rs.getString("ENDE_CLI"));
                c.setNume_cli(rs.getString("NUME_CLI"));
                c.setComlp_cli(rs.getString("COMPL_CLI"));
                c.setBair_cli(rs.getString("BAIR_CLI"));
                c.setCida_cli(rs.getString("CIDA_CLI"));
                c.setUf_cli(rs.getString("UF_CLI"));
                c.setCep_cli(rs.getString("CEP_CLI"));
                c.setFone_cli(rs.getString("FONE_CLI"));
                c.setCpf_cli(rs.getString("CPF_CLI"));
                c.setData_nasc(rs.getString("DATA_NASC"));
                c.setCnpj_cli(rs.getString("CNPJ_CLI"));

                lista.add(c);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao listar clientes: " + e.getMessage());
        }

        return lista;
    }

    public ArrayList<Produtos> listarTodosProdutos() {
        ArrayList<Produtos> lista = new ArrayList<>();

        Connection conn = connectDB();

        try {
            String sql = "SELECT * FROM PRODUTOS";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Produtos p = new Produtos();

                p.setCdProduto(rs.getInt("CdProduto"));
                p.setDtCadastro(rs.getString("dtCadastro"));
                p.setNome(rs.getString("Nome"));
                p.setTipo(rs.getString("Tipo"));
                p.setPreco(rs.getFloat("Preco"));
                p.setQtdTotal(rs.getInt("QtdTotal"));
                p.setDtUltimaAtz(rs.getString("DtUltimaAtz"));
                p.setStatus(rs.getString("Status"));

                lista.add(p);
            }

            rs.close();
            stmt.close();
            conn.close();

        } catch (SQLException e) {
            System.out.println("Erro ao listar produtos: " + e.getMessage());
        }

        return lista;
    }

}
