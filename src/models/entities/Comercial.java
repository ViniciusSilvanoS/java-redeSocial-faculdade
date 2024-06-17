package models.entities;

import exceptions.UsuarioExcecao;
import utils.Validacoes;

public class Comercial extends Usuario {

    private String cnpj;

    public Comercial(String cnpj, String nome, String email, String senha) throws UsuarioExcecao {
        super(nome, email, senha);
        this.cnpj = cnpj;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) throws UsuarioExcecao {
        if(Validacoes.isValidCNPJ(cnpj)){
            this.cnpj = cnpj;
        }else {
            UsuarioExcecao.excecaoCNPJ();
        }

    }

    @Override
    public String toString() {
        return getCnpj();
    }
}
