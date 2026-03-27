
package Model;

public class Acesso {
    private int id;
    private int cdUser;
    private String login;
    private String hash;
    private String tipoUser;
    private String status;
    private String dtUltimoAcesso;
    
    public Acesso () {}
    
    public Acesso (int id, int cdUser, String login, String hash,
            String tipoUser, String status, String dtUltimoAcesso) {
        this.id = id;
        this.cdUser = cdUser;
        this.login = login;
        this.hash = hash;
        this.tipoUser = tipoUser;
        this.status = status;
        this.dtUltimoAcesso = dtUltimoAcesso;
    }
    
     public Acesso (int cdUser, String login, String hash,
            String tipoUser, String status, String dtUltimoAcesso) {
        this.cdUser = cdUser;
        this.login = login;
        this.hash = hash;
        this.tipoUser = tipoUser;
        this.status = status;
        this.dtUltimoAcesso = dtUltimoAcesso;
    }
     
     
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCdUser() {
        return cdUser;
    }

    public void setCdUser(int cdUser) {
        this.cdUser = cdUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getTipoUser() {
        return tipoUser;
    }

    public void setTipoUser(String tipoUser) {
        this.tipoUser = tipoUser;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDtUltimoAcesso() {
        return dtUltimoAcesso;
    }

    public void setDtUltimoAcesso(String dtUltimoAcesso) {
        this.dtUltimoAcesso = dtUltimoAcesso;
    }
     
// Incluindo o cdUser (certifique-se de que o banco permite o insert manual se for IDENTITY)
    public String dadosSQLValues() {
        return this.cdUser + ", '" 
                   + this.login + "', '"
                   + this.hash + "', '"
                   + this.tipoUser + "', '"
                   + this.status + "', '"
                   + this.dtUltimoAcesso + "'";
    }

    public String alteraDadosSQLValues() {
        return "cdUser = " + this.cdUser + ", "
             + "login = '" + this.login + "', "
             + "hash = '" + this.hash + "', "
             + "tipoUser = '" + this.tipoUser + "', "
             + "status = '" + this.status + "', "
             + "dtUltimoAcesso = '" + this.dtUltimoAcesso + "'";
    }
     
}
