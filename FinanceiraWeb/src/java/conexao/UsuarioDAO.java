/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import classes.Usuario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author odontoradiosis
 */
public class UsuarioDAO {
    
    private ConexaoBD conexao;

    public UsuarioDAO(ConexaoBD conexao) {
       this.conexao = conexao;
    }


    public Usuario getUsuariosFromLoginSenha (String login, String senha) throws SQLException {

        Usuario user = null;

        String SQL_string = "SELECT * FROM usuario WHERE " +
                "login LIKE '%" + login + "%' && password LIKE'%" +senha+"%&'";

        ResultSet rs= conexao.executeSql(SQL_string);


            String nome = rs.getString("nome");
            int nivelAcesso = rs.getInt("nivelAcesso");
            user = new Usuario(login,senha,nivelAcesso,nome);
        
        if (nome!=null || !nome.equals("")) {
            return user;
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
