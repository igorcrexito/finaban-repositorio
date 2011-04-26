/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bancoDAO;

import classes.Usuario;
import conexao.ConexaoBD;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 */
public class UsuarioDAO {

    private Usuario usuario;
    private ConexaoBD conexao;

    public UsuarioDAO(ConexaoBD conexao) {
       this.conexao = conexao;
    }

    public Usuario getUsuarioLogin (String login, String password) throws SQLException {

        String SQL_string = "SELECT * FROM usuario WHERE " +
                "LOGIN LIKE '%" + login + "%'";

        ResultSet rs= conexao.executeSql(SQL_string);
        rs.first();

        String log = rs.getString("login");
        String pass = rs.getString("login");
        int nivelAcesso = rs.getInt("nivelAcesso");


        usuario = new Usuario(log,pass,nivelAcesso);
        return usuario;
    }
}