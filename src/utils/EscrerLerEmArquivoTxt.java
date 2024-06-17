package utils;

import java.io.*;

public class EscrerLerEmArquivoTxt {

    public static void logThrow(String mensagem){
        String path = "src\\appLog.log";
        escrever(path, mensagem);
    }

    public static void logOutput(String mensagem){
        String path = "src\\output\\output.txt";
        escrever(path, mensagem);
    }

    public static void escreverPrint(String mensagem){
        String path = "src\\prints.txt";
        escrever(path, mensagem);
    }

    private static void escrever(String path, String mensagem){
        try{
            System.out.println(mensagem);

            FileWriter fw = new FileWriter(path, true);
            BufferedWriter buffWrite = new BufferedWriter(fw);
            buffWrite.append(Date.pegarDataHora() + "\n" + mensagem + "\n\n");
            buffWrite.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

}
