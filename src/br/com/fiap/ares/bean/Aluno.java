package br.com.fiap.ares.bean;

public class Aluno extends Usuario{

    private String causaMorte = "Nenhuma";
    private int diasSobrevividos = 0;

    public Aluno() {
    }

    public Aluno(String nome, String email, String senha, String causaMorte, int diasSobrevividos) {
        super(nome, email, senha);
        this.causaMorte = causaMorte;
        this.diasSobrevividos = diasSobrevividos;
    }

    public String getCausaMorte() {
        return causaMorte;
    }

    public void setCausaMorte(String causaMorte) {
        this.causaMorte = causaMorte;
    }

    public int getDiasSobrevividos() {
        return diasSobrevividos;
    }

    public void setDiasSobrevividos(int diasSobrevividos) {
        this.diasSobrevividos = diasSobrevividos;
    }

}
