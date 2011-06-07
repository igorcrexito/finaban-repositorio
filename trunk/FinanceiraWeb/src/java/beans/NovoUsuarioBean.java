package beans;


import classes.Usuario;
import conexao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;


/**
 *
 * @author Igor
 */
@ManagedBean(name="newUserBean")
@SessionScoped
public class NovoUsuarioBean {


    /** Creates a new instance of UsuarioBean */
    private String login;
    private String password;
    private String passwordConfirmar;
    private String nivelAcesso;
    private String nome;
    private String erro="";

    public NovoUsuarioBean() {
    }

    public NovoUsuarioBean(String login, String password,String passwordConf, String nivelAcesso, String nome) {
        this.nivelAcesso = nivelAcesso;
        this.passwordConfirmar = passwordConf;
        this.nome = nome;
        this.login = login;
        this.password = password;
    }


    public void criaNovoUsuario () {
        checaTodos();
        UsuarioDAO userDao = new UsuarioDAO();
        boolean valid = true;
        System.out.println(nivelAcesso + "nivel");
        valid = userDao.checaLoginValido(this.login);


        if(valid) {
            erro= "";
        } else {
            erro = "Login de usuário já cadastrado. Cadastre um outro";
        }

        if (erro.equals(""))
        if (password.equals(passwordConfirmar)) {
            erro = "Usuario inserido com sucesso";
            checaTodos();
        } else {
            erro = "A senha e confirmação diferem";
            checaTodos();
        }

        if (erro.equals("Usuario inserido com sucesso")) {
            userDao.inserirUsuario(login, password, nome, Integer.parseInt(nivelAcesso));
        }
;
    }

    public void checaTodos() {
        if (this.login.equals("") || this.nome.equals("") || this.password.equals("") || this.passwordConfirmar.equals("")) {
            erro = "Todos os campos precisam ser preenchidos";
        } 
    }

    public String resetaUsuario () {
        this.passwordConfirmar = "";
        this.nome = "";
        this.login = "";
        this.password = "";
        this.erro="";
        this.nivelAcesso="";
        return "home.xhtml";
        
    }

    public String getErro() {
        return erro;
    }

    public void setErro(String erro) {
        this.erro = erro;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(String nivelAcesso) {
        this.nivelAcesso = nivelAcesso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPasswordConfirmar() {
        return passwordConfirmar;
    }

    public void setPasswordConfirmar(String passwordConfirmar) {
        this.passwordConfirmar = passwordConfirmar;
    }

}
