/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import conexao.UsuarioDAO;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Igor
 */
@ManagedBean(name="userBean")
@SessionScoped
public class UsuarioBean {

    private UsuarioDAO userDao;
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

    public UsuarioDAO getUserDao() {
        return userDao;
    }

    public void setUserDao(UsuarioDAO userDao) {
        this.userDao = userDao;
    }

    public void checaUsuario (String login, String senha) {

    }
    
}
