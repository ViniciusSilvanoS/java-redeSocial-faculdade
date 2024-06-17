package exceptions;

import utils.EscrerLerEmArquivoTxt;

public class UsuarioExcecao extends Exception {

    public UsuarioExcecao(String msg) {
        super(msg);
        EscrerLerEmArquivoTxt.logThrow(msg);
    }

    public static void excecaoNome() throws UsuarioExcecao{
        UsuarioExcecao e = new UsuarioExcecao("Nome é inválido!");
        throw e;
    }

    public static void excecaoEmail() throws UsuarioExcecao{
        UsuarioExcecao e = new UsuarioExcecao("Email inválido!");
        throw e;
    }

    public static void excecaoSenha() throws UsuarioExcecao{
        UsuarioExcecao e = new UsuarioExcecao("Senha inválida!");
        throw e;
    }

    public static void excecaoCPF() throws UsuarioExcecao{
        UsuarioExcecao e = new UsuarioExcecao("CPF inálido!");
        throw e;
    }

    public static void excecaoCNPJ() throws UsuarioExcecao{
        UsuarioExcecao e = new UsuarioExcecao("CNPJ inálido!");
        throw e;
    }

}
