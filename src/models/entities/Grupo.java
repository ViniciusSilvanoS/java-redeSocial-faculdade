package models.entities;

import exceptions.GrupoExcecao;
import exceptions.UsuarioExcecao;
import interfaces.IOuvinte;
import utils.LeitorCSV;
import utils.Validacoes;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Grupo implements IOuvinte {

    private String nome;
    private String descricao;
    private List<Usuario> membros;

    @Override
    public void receber(String mensagem) {
        for (Usuario membro : membros) {
            membro.receber(mensagem);
        }
    }

    public void adicionarMembro(Usuario membro) {
        membros.add(membro);
    }

    public void removerMembro(Usuario membro) {
        membros.remove(membro);
    }

    public void importarDeCSV(){
        try {
            String pastaCaminho = "output";
            String arquivoCaminho = pastaCaminho + File.separator + getNome() + ".csv";

            LeitorCSV leitorCSV = new LeitorCSV(arquivoCaminho);

            String[] dados = leitorCSV.lerDados();
            while ((dados = leitorCSV.lerDados()) != null) {
                String nome = dados[0];
                String identificacao = dados[1];
                String email = dados[2];
                String senha = dados[3];
                if(Validacoes.isValidCPF(identificacao)){
                    Usuario usuario = new Pessoal(identificacao, nome, email, senha);
                }else if(Validacoes.isValidCNPJ(identificacao)){
                    Usuario usuario = new Pessoal(identificacao, nome, email, senha);
                }else {
                    GrupoExcecao.excecaoCpfCnpj();
                }
            }
        } catch (UsuarioExcecao e) {
            throw new RuntimeException(e);
        } catch (GrupoExcecao e) {
            throw new RuntimeException(e);
        }
    }

    public void exportarParaCSV(){
        String diretorioOutput = "src\\output";
        String arquivoCaminho = diretorioOutput + File.separator + getNome() + ".csv";

        try{
            File diretorio = new File(diretorioOutput);
            if(!diretorio.exists()){
                boolean criado = diretorio.mkdir();
                if(!criado){
                    throw new IOException("Não foi possível criar o diretório: " + diretorio.getAbsolutePath());
                }
            }

            FileWriter fw = new FileWriter(arquivoCaminho, true);
            BufferedWriter buffWrite = new BufferedWriter(fw);

            buffWrite.write("");
            File arquivo = new File(arquivoCaminho);
            if (arquivo.length() == 0) {
                buffWrite.append("Nome;Cpf/Cnpj;Email;Senha\n");
            }
            for(Usuario membro : getMembros()){
                buffWrite.append(membro.getNome() + ";" + membro.toString() + ";" + membro.getEmail() + ";" + membro.getSenha() + "\n");
            }

            buffWrite.close();
        }catch(IOException e) {
            e.printStackTrace();
        }
    }

    public Grupo() {
        membros = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Usuario> getMembros() {
        return membros;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
