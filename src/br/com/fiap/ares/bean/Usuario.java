package br.com.fiap.ares.bean;

public class Usuario {
    private String nome;
    private String email;
    private String senha;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws Exception{
        if (senha == null){
            throw  new  Exception("Erro, a senha não pode ser vazia!");
        }if (senha.length() < 4) {
            throw new Exception("A senha precisa ter pelo menos 4 caracteres!");
        }
    }

    public void setEmail(String email) throws Exception {
        // Validação dos domínios permitidos
        if (email.contains("@gmail.com") || email.contains("@outlook.com") || email.contains("@hotmail.com")) {
            this.email = email;
        } else {
            // Se não for nenhum desses, a gente "trava" o sistema
            throw new Exception("Erro: Domínio inválido. Use Gmail, Outlook ou Hotmail.");
        }

    }
}
