import exceptions.UsuarioExcecao;
import models.entities.Comunidade;
import models.entities.Grupo;
import models.entities.Pessoal;
import models.entities.Usuario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UsuarioExcecao {

        principal();

    }

    public static void principal() throws UsuarioExcecao {
        Usuario u1 = new Pessoal("999.999.999-99", "Elian","elian@javeiros.com", "123456");
        Usuario u2 = new Pessoal("888.888.888-88", "Ana Amélia","ana.amelia@javeiros.com", "123456");
        Usuario u3 = new Pessoal("777.777.777-77", "José Neto","jose.neto@javeiros.com", "123456");

        Usuario u4 = new Pessoal("123.456.789-10", "Vinícius Silvano","vinicius@javeiros.com", "12345678");

//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Digite seu nome: ");
//        String nome = scanner.nextLine();
//        System.out.println("Digite seu CPF: ");
//        String cpf = scanner.nextLine();
//        System.out.println("Digite seu email: ");
//        String email = scanner.nextLine();
//        System.out.println("Digite sua senha: ");
//        String senha = scanner.nextLine();
//
//        Usuario u4 = new Pessoal(cpf, nome,email, senha);

        Grupo g1 = new Grupo();
        g1.setNome("Javeiros, guerreiros, destruidores");
        g1.setDescricao("Javeiros de corpo e alma");

        Grupo g2 = new Grupo();
        g2.setNome("C raiz");
        g2.setDescricao("Por que qualquer outra coisa é overhead");

        g1.adicionarMembro(u1);
        g1.adicionarMembro(u2);

        g2.adicionarMembro(u1);
        g2.adicionarMembro(u3);

        Comunidade c1 = new Comunidade();
        c1.setNome("Programadores do Iraque");
        c1.setDescricao("Programadores nascidos e criados em Irajá.");
        c1.adicionarGrupo(g1);
        c1.adicionarGrupo(g2);

        u1.notificar(c1, "Salve, salve, galera");
        g1.exportarParaCSV();
        g2.exportarParaCSV();

        System.out.println("Quantidade de membros da comunidade 1: " + c1.quantidadeMembros());

    }
}