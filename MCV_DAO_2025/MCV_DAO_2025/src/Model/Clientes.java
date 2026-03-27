/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Alunos
 */
public class Clientes {
    
    
    public Clientes(){
        
    }

    public Clientes(int id_cli, String nome_cli, String ende_cli, String nume_cli, String comlp_cli, String bair_cli,
    String cida_cli, String uf_cli, String cep_cli, String fone_cli, String cpf_cli, String data_nasc, String cnpj_cli) {
        this.id_cli = id_cli;
        this.nome_cli = nome_cli;
        this.ende_cli = ende_cli;
        this.nume_cli = nume_cli;
        this.comlp_cli = comlp_cli;
        this.bair_cli = bair_cli;
        this.cida_cli = cida_cli;
        this.uf_cli = uf_cli;
        this.cep_cli = cep_cli;
        this.fone_cli = fone_cli;
        this.cpf_cli = cpf_cli;
        this.data_nasc = data_nasc;
        this.cnpj_cli = cnpj_cli;
    }
    
        public Clientes(int id_cli, String nome_cli, String ende_cli, String nume_cli, String comlp_cli, String bair_cli,
    String cida_cli, String uf_cli, String cep_cli, String fone_cli, String data_nasc, String cnpj_cli) {
        this.id_cli = id_cli;
        this.nome_cli = nome_cli;
        this.ende_cli = ende_cli;
        this.nume_cli = nume_cli;
        this.comlp_cli = comlp_cli;
        this.bair_cli = bair_cli;
        this.cida_cli = cida_cli;
        this.uf_cli = uf_cli;
        this.cep_cli = cep_cli;
        this.fone_cli = fone_cli;
        this.data_nasc = data_nasc;
        this.cnpj_cli = cnpj_cli;
    }
    
      
    
    
    
   private int id_cli;
   private String nome_cli;
   private String ende_cli;
   private String nume_cli;
   private String comlp_cli;
   private String bair_cli;
   private String cida_cli;
   private String uf_cli;
   private String cep_cli;
   private String fone_cli;
   private String cpf_cli;
   private String data_nasc;
   private String cnpj_cli;
   
   
    public int getId_cli(){
        return id_cli;
    }
   
    public void setId_cli(int id_cli){
        this.id_cli = id_cli;
        
    }
    
    public String getNome_cli(){
        return nome_cli;
    }
        
    public void setNome_cli(String nome_cli){
        this.nome_cli = nome_cli;
    }

    public String getEnde_cli() {
        return ende_cli;
    }

    public void setEnde_cli(String ende_cli) {
        this.ende_cli = ende_cli;
    }

    public String getNume_cli() {
        return nume_cli;
    }

    public void setNume_cli(String nume_cli) {
        this.nume_cli = nume_cli;
    }

    public String getComlp_cli() {
        return comlp_cli;
    }

    public void setComlp_cli(String comlp_cli) {
        this.comlp_cli = comlp_cli;
    }

    public String getBair_cli() {
        return bair_cli;
    }

    public void setBair_cli(String bair_cli) {
        this.bair_cli = bair_cli;
    }

    public String getCida_cli() {
        return cida_cli;
    }

    public void setCida_cli(String cida_cli) {
        this.cida_cli = cida_cli;
    }

    public String getUf_cli() {
        return uf_cli;
    }

    public void setUf_cli(String uf_cli) {
        this.uf_cli = uf_cli;
    }

    public String getCep_cli() {
        return cep_cli;
    }

    public void setCep_cli(String cep_cli) {
        this.cep_cli = cep_cli;
    }

    public String getFone_cli() {
        return fone_cli;
    }

    public void setFone_cli(String fone_cli) {
        this.fone_cli = fone_cli;
    }

    public String getCpf_cli() {
        return cpf_cli;
    }

    public void setCpf_cli(String cfp_cli) {
        this.cpf_cli = cfp_cli;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getCnpj_cli() {
        return cnpj_cli;
    }

    public void setCnpj_cli(String cnpj_cli) {
        this.cnpj_cli = cnpj_cli;
    }
    
    public String dadosSQLValues(){
        String dadosClientes;
        dadosClientes = "'"
                +this.id_cli + "','"
                +this.nome_cli+ "' ,'"
                +this.ende_cli+ "','"
                +this.nume_cli+ "','"
                +this.comlp_cli+ "','"
                +this.bair_cli+ "','"
                +this.cida_cli+ "','"
                +this.uf_cli+ "','"
                +this.cep_cli+ "','"
                +this.fone_cli+ "','"
                +this.cpf_cli+ "','"
                +this.data_nasc+ "','"
                +this.cnpj_cli+ "'";
                
                return dadosClientes;
                
    }
    
    public String alteraDadosSQLValues() {
    String valores = 
        "NOME_CLI = '" + this.nome_cli + "', " +
        "ENDE_CLI = '" + this.ende_cli + "', " +
        "NUME_CLI = '" + this.nume_cli + "', " +
        "COMPL_CLI = '" + this.comlp_cli + "', " +
        "BAIR_CLI = '" + this.bair_cli + "', " +
        "CIDA_CLI = '" + this.cida_cli + "', " +
        "UF_CLI = '" + this.uf_cli + "', " +
        "CEP_CLI = '" + this.cep_cli + "', " +
        "FONE_CLI = '" + this.fone_cli + "', " +
        "CPF_CLI = '" + this.cpf_cli + "', " +
        "DATA_NASC = '" + this.data_nasc + "', " +
        "CNPJ_CLI = '" + this.cnpj_cli + "'";
    
    return valores;
}

    
    
    /*
    	NOME_CLI VARCHAR(50) NOT NULL,
	ENDE_CLI VARCHAR(50) NOT NULL,
	NUME_CLI VARCHAR(8),
	COMPL_CLI VARCHAR(20),
	BAIR_CLI VARCHAR(20),
	CIDA_CLI VARCHAR(30) NOT NULL,
	UF_CLI CHAR(2) NOT NULL,
	CEP_CLI CHAR(8) NOT NULL,
	FONE_CLI VARCHAR(13),
	CPF_CLI CHAR(11),
	DATA_NASC DATETIME,
	CNPJ_CLI CHAR(14) */
}
