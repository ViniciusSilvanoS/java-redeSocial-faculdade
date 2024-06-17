package models.entities;

import interfaces.IOuvinte;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Comunidade implements IOuvinte {

    private String nome;
    private String descricao;
    private List<Grupo> grupos;

    @Override
    public void receber(String mensagem) {
        for (Grupo grupo : grupos){
            grupo.receber(mensagem);
        }
    }

    public void adicionarGrupo(Grupo grupo) {
        grupos.add(grupo);
    }

    public void removerGrupo(Grupo grupo){
        grupos.remove(grupo);
    }

    public int quantidadeMembros() {
        HashSet<Usuario> membros = pegarTodosMembrosSemDuplicacao();
        return membros.size();
    }

    private HashSet<Usuario> pegarTodosMembrosSemDuplicacao() {
        HashSet<Usuario> todosUsuarios = new HashSet<>();
        for(Grupo grupo : grupos ){
            todosUsuarios.addAll(grupo.getMembros());
        }
        return todosUsuarios;
    }

    public Comunidade() {
        grupos = new ArrayList<>();
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
