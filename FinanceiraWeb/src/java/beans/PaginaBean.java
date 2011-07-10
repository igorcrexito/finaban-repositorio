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
import javax.faces.context.FacesContext;

/**
 *
 * @author 
 */
@ManagedBean(name="pagBean")
@SessionScoped
public class PaginaBean {

    private String nome;
    private String erro;
    private String conteudo;
    private String nomeUser;

    public String getNomeUser() {
        return nomeUser;
    }

    public void setNomeUser(String nomeUser) {
        this.nomeUser = nomeUser;
    }

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
        UsuarioBean userBean = (UsuarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userBean");

        if (userBean.getNome() != null || !userBean.getNome().equals("")) {
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
    }


    public String redirecionaPag() {
        if (nome==null || nome.equals(""))
            return "home.xhtml";
        else
            return "pagadministrador";
    }

    public void acionaQuemSomos() {
        nome="quemsomos";
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

    public void acionaCustos() {
        nome="custos";
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

    public void acionaGestao() {
        nome="gestao";
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

    public void acionaIntroducao() {
        nome="introducao";
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

  public void acionaAntecipacao() {
        nome="antecipacao";
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

    public void acionaProSolutoCom() {
        nome="prosolutocom";
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

  public void acionaProSolutoSem() {
        nome="prosolutosem";
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

    public void acionaLegislacao() {
        nome="legislacao";
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

      public void acionaMaturity() {
        nome="maturity";
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

     public void acionaImportExport() {
        nome="importexport";
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
        UsuarioBean userBean = (UsuarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userBean");

        if (userBean.getNome() != null || !userBean.getNome().equals("")) {
        if (this.nome==null || this.nome.equals("")) {
            erro = "Campo referente à página deve ser escolhido";
        } else {
            Pagina pag=null;
            PaginaDAO pagDao = new PaginaDAO();

            pagDao.updateConteudo(nome, conteudo);
        }
         }
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }



}
