/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import classes.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author odontoradiosis
 */
public class UsuarioDAO {
    
    private ConexaoBD conexao;

    public UsuarioDAO() {
       conexao = ConexaoBD.getConexaoBD();
    }


    public Usuario getUsuariosFromLoginSenha (String login, String senha) throws SQLException {


        String SQL_string = "SELECT * FROM usuario WHERE " +
                "LOGIN LIKE'%" + login + "%'" + "AND SENHA LIKE '%"+senha+"%'";

        ResultSet rs= conexao.executeSql(SQL_string);
        rs.first();

        String nome = rs.getString("nome");
        int nivelAcesso = rs.getInt("nivelAcesso");

        
        if (nome!=null || !nome.equals("")) {
            return new Usuario(login,senha,nivelAcesso,nome);
        } else {
            return null;
        }
    }

    public void inserirUsuario(String login, String senha, String nome, int nivelAcesso) {

        String SQL_String = "INSERT INTO usuario (login,senha,nome,nivelAcesso)" +
                " VALUES ('" + login + "', '" + senha + "', '" + nome + "', '" + nivelAcesso+"')";

         conexao.execute(SQL_String);
    }


}
