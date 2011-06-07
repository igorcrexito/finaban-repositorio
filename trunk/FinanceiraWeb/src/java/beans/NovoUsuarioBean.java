package beans;


import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;


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
    private int nivelAcesso;
    private String nome;
    private String erro="";

    public NovoUsuarioBean() {
    }

    public NovoUsuarioBean(String login, String password,String passwordConf, int nivelAcesso, String nome) {
        this.nivelAcesso = nivelAcesso;
        this.passwordConfirmar = passwordConf;
        this.nome = nome;
        this.login = login;
        this.password = password;
    }


    public void criaNovoUsuario () {
        if (password.equals(passwordConfirmar)) {
            erro = "Usuario inserido com sucesso";
        } else {
            erro = "A senha e confirmação diferem";
        }
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

    public int getNivelAcesso() {
        return nivelAcesso;
    }

    public void setNivelAcesso(int nivelAcesso) {
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
