package beans;


import classes.Criptografia;
import classes.Usuario;
import conexao.UsuarioDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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
    Criptografia crip = new Criptografia();
    String senhacrip;

    public NovoUsuarioBean() {
    }

    public NovoUsuarioBean(String login, String password,String passwordConf, String nivelAcesso, String nome) {
        this.nivelAcesso = nivelAcesso;
        this.passwordConfirmar = passwordConf;
        this.nome = nome;
        this.login = login;
        this.password = password;
    }


    public String criaNovoUsuario () {
        checaTodos();
        if (!erro.equals("")) {
            erro= "Todos os campos precisam ser preenchidos";
            return "pagadministrador.xhtml";
        }
        
        UsuarioDAO userDao = new UsuarioDAO();
        boolean valid = true;

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
        UsuarioBean user = (UsuarioBean) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("userBean");

        if (user.getNome()!=null || !user.getNome().equals("")) {
            if (erro.equals("Usuario inserido com sucesso")) {
                userDao.inserirUsuario(login, password, nome, Integer.parseInt(nivelAcesso));
                return "pagadministrador.xhtml";
            } else {
                return "pagadministrador.xhtml";
            }
        } else {
            erro="Não há usuário logado";
            return "pagadministrador.xhtml";
        }
    }

    public void checaTodos() {
        if (this.login.equals("") || this.nome.equals("") || this.password.equals("") || this.passwordConfirmar.equals("") || this.nivelAcesso.equals("")) {
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
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("userBean", new UsuarioBean());
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("newUserBean", new NovoUsuarioBean());
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
        if(!password.equals("")){
        senhacrip = crip.criptografar(password);
        this.password = senhacrip;
        }
        else
        this.password = password;
    }

    public String getPasswordConfirmar() {
        return passwordConfirmar;
    }

    public void setPasswordConfirmar(String passwordConfirmar) {
         if(!password.equals("")){
        senhacrip = crip.criptografar(passwordConfirmar);
        this.passwordConfirmar = senhacrip;
        }
        else
            this.passwordConfirmar = passwordConfirmar;
    }

}
