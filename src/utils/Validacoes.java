package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validacoes {

    public static boolean isNomeValido(String nome){
        Pattern pattern = Pattern.compile(".*\\d.*");
        Matcher matcher = pattern.matcher(nome);
        if (nome.length() < 3 || matcher.matches()){
            return false;
        }
        return true;
    }

    public static boolean isEmailValido(String email){
        final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        if(matcher.matches()){
            return true;
        }
        return false;
    }

    public static boolean isSenhaValida(String senha){
        if(senha.length() < 6 || senha.length() > 16){
            return false;
        }
        return true;
    }

    public static boolean isValidCPF(String cpf) {
        final String CPF_REGEX = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}";
        Pattern pattern = Pattern.compile(CPF_REGEX);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }

    public static boolean isValidCNPJ(String cnpj) {
        final String CNPJ_REGEX = "\\d{2}\\.\\d{3}\\.\\d{3}/0001-\\d{2}";
        Pattern pattern = Pattern.compile(CNPJ_REGEX);
        Matcher matcher = pattern.matcher(cnpj);
        return matcher.matches();
    }

}
