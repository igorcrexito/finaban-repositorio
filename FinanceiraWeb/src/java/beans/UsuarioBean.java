/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import classes.Criptografia;
import classes.Usuario;
import conexao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor
 */
@ManagedBean(name="userBean")
@SessionScoped
public class UsuarioBean {

    
    /** Creates a new instance of UsuarioBean */
    private String login;
    private boolean logado;
    private String password;
    private String passwordConfirmar;
    private int nivelAcesso;
    private String nome;
    private String erro="";
    Criptografia criptografar = new Criptografia();
    String senhaCrip;

    public UsuarioBean() {
    }

    public UsuarioBean(String login, String password) {

        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        senhaCrip = criptografar.criptografar(password);
        this.password = senhaCrip;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

     public String getPasswordConfirmar() {
        return passwordConfirmar;
    }

    public void setPasswordConfirmar(String passwordConfirmar) {
        this.passwordConfirmar = passwordConfirmar;
    }

    public String invalidaUsuario () {
        this.nome = null;
        this.erro =null;
        this.login = null;
        this.password = null;
        return "index.xhtml";
    }

    public String checaUsuario () {
        if (this.login.equals("") || this.password.equals("")) {
            erro = "Campos não preenchidos. Favor colocá-los";
            return "acessoregistro.xhtml";
        } else {

        Usuario usuario=null;
        UsuarioDAO userDao = new UsuarioDAO();
        try {
            usuario = userDao.getUsuariosFromLoginSenha(login, password);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        if (usuario!=null) {
            login = usuario.getLogin();
            password = usuario.getPassword();
            nivelAcesso = usuario.getNivelAcesso();
            nome = usuario.getNome();
            erro = null;
            return "pagadministrador.xhtml";
        } else {
            erro = "Senha ou Login incorreto(s)";
            return "acessoregistro.xhtml";
        }
        }
    }
    
}
