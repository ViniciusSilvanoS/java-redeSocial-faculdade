package models.entities;

import exceptions.UsuarioExcecao;
import utils.Validacoes;

public class Pessoal extends Usuario {

    private String cpf;

    public Pessoal(String cpf, String nome, String email, String senha) throws UsuarioExcecao {
        super(nome, email, senha);
        setCpf(cpf);
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) throws UsuarioExcecao {
        if (Validacoes.isValidCPF(cpf)) {
            this.cpf = cpf;
        }else {
            UsuarioExcecao.excecaoCPF();
        }
    }

    @Override
    public String toString() {
        return getCpf();
    }
}
