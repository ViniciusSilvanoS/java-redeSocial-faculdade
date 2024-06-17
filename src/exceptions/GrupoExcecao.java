package exceptions;

import utils.EscrerLerEmArquivoTxt;

public class GrupoExcecao extends Exception {

    public GrupoExcecao(String msg) {
        super(msg);
        EscrerLerEmArquivoTxt.logThrow(msg);
    }

    public static void excecaoCpfCnpj() throws GrupoExcecao {
        GrupoExcecao e = new GrupoExcecao("CPF ou CNPJ inválido!");
        throw e;
    }

}
