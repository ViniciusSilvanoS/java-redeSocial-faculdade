package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class LeitorCSV {
    BufferedReader buffRead;

    public LeitorCSV(String path) {
        try {
            buffRead = new BufferedReader(new FileReader(path));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public String[] lerDados() {
        try {
            String linha = buffRead.readLine();
            String[] valores = null;
            if (linha != null) {
                valores = linha.split(";");
            } else {
                return null;
            }
            return valores;
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
