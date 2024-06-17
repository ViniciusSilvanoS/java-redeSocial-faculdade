package models.entities;

import exceptions.UsuarioExcecao;
import utils.EscrerLerEmArquivoTxt;
import interfaces.IEmissor;
import interfaces.IOuvinte;
import utils.Validacoes;

public class Usuario implements IOuvinte, IEmissor {

    private String nome;
    private String email;
    private String senha;

    @Override
    public void notificar(IOuvinte ouvinte, String mensagem) {
        ouvinte.receber(mensagem);

        String msgLog = "Emissor: " + getNome() + "\nReceptor: " + ouvinte.toString() + "\nmensagem: " + mensagem;
        EscrerLerEmArquivoTxt.logOutput(msgLog);
    }

    public void receber(String mensagem) {
        EscrerLerEmArquivoTxt.escreverPrint(mensagem);
    }

    public Usuario(String nome, String email, String senha) throws UsuarioExcecao {
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws UsuarioExcecao {
        if (Validacoes.isNomeValido(nome)){
            this.nome = nome;
        }else{
            UsuarioExcecao.excecaoNome();
        }
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws UsuarioExcecao {
        if(Validacoes.isEmailValido(email)){
            this.email = email;
        }else {
            UsuarioExcecao.excecaoEmail();
        }
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) throws UsuarioExcecao {
        if(Validacoes.isSenhaValida(senha)){
            this.senha = senha;
        }else{
            UsuarioExcecao.excecaoSenha();
        }
    }
}
