/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import classes.Pagina;
import conexao.PaginaDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Nalminha
 */
@ManagedBean(name="pagBean")
@SessionScoped
public class PaginaBean {

    private String nome;
    private String erro;
    private String conteudo;

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void checaPagina() {
        if (this.nome==null || this.nome.equals("")) {
            erro = "Campo referente à página deve ser escolhido";
        } else {
        Pagina pag=null;
        PaginaDAO pagDao = new PaginaDAO();
        try {
            pag = pagDao.getPaginaFromNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
            nome = pag.getNome();
            conteudo = pag.getConteudo();
            erro = null;
        }
    }

  public void acionaFaleConosco() {
        nome="faleconosco";
        Pagina pag=null;
        PaginaDAO pagDao = new PaginaDAO();
        try {
            pag = pagDao.getPaginaFromNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
            nome = pag.getNome();
            conteudo = pag.getConteudo();
        }

public void acionaProSolvendo() {
        nome="prosolvendo";
        Pagina pag=null;
        PaginaDAO pagDao = new PaginaDAO();
        try {
            pag = pagDao.getPaginaFromNome(nome);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
            nome = pag.getNome();
            conteudo = pag.getConteudo();
            System.out.println(conteudo);
        }


     public void salvaPagina() {
        if (this.nome==null || this.nome.equals("")) {
            erro = "Campo referente à página deve ser escolhido";
        } else {
            Pagina pag=null;
            PaginaDAO pagDao = new PaginaDAO();

            pagDao.updateConteudo(nome, conteudo);
        }
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }



}
