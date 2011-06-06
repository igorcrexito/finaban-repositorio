/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import classes.Usuario;
import conexao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
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
    private String password;
    private int nivelAcesso;

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
        this.password = password;
    }

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }


    public void checaUsuario () {
        Usuario usuario=null;
        System.out.println(login);
        System.out.println(password);
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
        }
    }
    
}
