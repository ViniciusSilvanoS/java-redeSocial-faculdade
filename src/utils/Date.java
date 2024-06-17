package utils;

import java.util.Calendar;

public class Date {

    public static String pegarDataHora(){
        Calendar hoje = Calendar.getInstance(); // singleton

        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH);
        int dia = hoje.get(Calendar.DAY_OF_MONTH);
        int hora = hoje.get(Calendar.HOUR_OF_DAY);
        int minutos = hoje.get(Calendar.MINUTE);
        int segundos = hoje.get(Calendar.SECOND);

        return String.format("%02d/%02d/%d %d:%d:%d", dia, (mes + 1), ano, hora, minutos, segundos);
    }

    public static String pegarData(){
        Calendar hoje = Calendar.getInstance(); // singleton

        int ano = hoje.get(Calendar.YEAR);
        int mes = hoje.get(Calendar.MONTH);
        int dia = hoje.get(Calendar.DAY_OF_MONTH);

        return String.format("%02d/%02d/%d", dia, (mes + 1), ano);
    }

    public static String pegarHora(){
        Calendar hoje = Calendar.getInstance(); // singleton

        int hora = hoje.get(Calendar.HOUR_OF_DAY);
        int minutos = hoje.get(Calendar.MINUTE);
        int segundos = hoje.get(Calendar.SECOND);

        return String.format("%d:%d:%d", hora, minutos, segundos);
    }

}
