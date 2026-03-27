package Model;

public class Produtos {

    private int CdProduto;
    private String dtCadastro;
    private String Nome;
    private String Tipo;
    private Float Preco;
    private int QtdTotal;
    private String DtUltimaAtz;
    private String Status;

    public Produtos() {}

    // Construtor para ALTERAÇÃO
    public Produtos(int CdProduto, String dtCadastro, String Nome, String Tipo, float Preco,
                    int QtdTotal, String DtUltimaAtz, String Status) {
        this.CdProduto = CdProduto;
        this.dtCadastro = dtCadastro;
        this.Nome = Nome;
        this.Tipo = Tipo;
        this.Preco = Preco;
        this.QtdTotal = QtdTotal;
        this.DtUltimaAtz = DtUltimaAtz;
        this.Status = Status;
    }

    // Construtor para INCLUSÃO (SEM CdProduto, porque ele é IDENTITY)
    public Produtos(String dtCadastro, String Nome, String Tipo, float Preco,
                    int QtdTotal, String DtUltimaAtz, String Status) {
        this.dtCadastro = dtCadastro;
        this.Nome = Nome;
        this.Tipo = Tipo;
        this.Preco = Preco;
        this.QtdTotal = QtdTotal;
        this.DtUltimaAtz = DtUltimaAtz;
        this.Status = Status;
    }

    public int getCdProduto() { return CdProduto; }
    public void setCdProduto(int CdProduto) { this.CdProduto = CdProduto; }

    public String getDtCadastro() { return dtCadastro; }
    public void setDtCadastro(String dtCadastro) { this.dtCadastro = dtCadastro; }

    public String getNome() { return Nome; }
    public void setNome(String Nome) { this.Nome = Nome; }

    public String getTipo() { return Tipo; }
    public void setTipo(String Tipo) { this.Tipo = Tipo; }

    public Float getPreco() { return Preco; }
    public void setPreco(Float Preco) { this.Preco = Preco; }

    public int getQtdTotal() { return QtdTotal; }
    public void setQtdTotal(int QtdTotal) { this.QtdTotal = QtdTotal; }

    public String getDtUltimaAtz() { return DtUltimaAtz; }
    public void setDtUltimaAtz(String DtUltimaAtz) { this.DtUltimaAtz = DtUltimaAtz; }

    public String getStatus() { return Status; }
    public void setStatus(String Status) { this.Status = Status; }

    // SEM o CdProduto — pois ele é IDENTITY
    public String dadosSQLValues() {
        return "'" + this.dtCadastro + "', '"
                   + this.Nome + "', '"
                   + this.Tipo + "', "
                   + this.Preco + ", "
                   + this.QtdTotal + ", '"
                   + this.DtUltimaAtz + "', '"
                   + this.Status + "'";
    }

    public String alteraDadosSQLValues() {
        return "dtCadastro = '" + this.dtCadastro + "', "
             + "Nome = '" + this.Nome + "', "
             + "Tipo = '" + this.Tipo + "', "
             + "Preco = " + this.Preco + ", "
             + "QtdTotal = " + this.QtdTotal + ", "
             + "DtUltimaAtz = '" + this.DtUltimaAtz + "', "
             + "Status = '" + this.Status + "'";
    }
}
