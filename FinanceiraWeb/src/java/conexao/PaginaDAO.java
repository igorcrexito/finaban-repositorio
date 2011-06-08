/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package conexao;

import classes.Pagina;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Nalminha
 */
public class PaginaDAO {

    private ConexaoBD conexao;

    public PaginaDAO() {
       conexao = ConexaoBD.getConexaoBD();
    }


    public Pagina getPaginaFromNome (String nome) throws SQLException {



        String SQL_string = "SELECT * FROM paginas WHERE " +
                "NOME LIKE'%" + nome + "%'";

        ResultSet rs= conexao.executeSql(SQL_string);
        rs.first();

        String conteudo = rs.getString("conteudo");


        if (conteudo!=null || !conteudo.equals("")) {
            return new Pagina(nome,conteudo);
        } else {
            return null;
        }
    }

    public void updateConteudo(String nome,String conteudo) {

        //conecta3g.conecta();
        String tabela = "paginas";
        String SQL = "UPDATE " + tabela + " SET conteudo = '" + conteudo + "'WHERE nome = '" + nome + "'";
        
        conexao.execute(SQL);

        //conecta3g.desconecta();

    }

}
