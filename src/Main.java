import br.com.dio.desafio.dominio.*;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setCargaHoraria(8);
        curso1.setDescricao("estudar os conceitos de orientacao a objetos");

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("Desvendando JAVA");
        mentoria1.setDescricao("Mentorio de POO");
        mentoria1.setData(LocalDate.now());

        Conteudo conteudo1 = new Curso();
        Conteudo conteudo2 = new Mentoria();


        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Desenvolver novos talentos backend java");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(mentoria1);

        Dev dev1 = new Dev();
        dev1.setNome("Antonio");
        dev1.inscreverBootcamp(bootcamp);

        Dev dev2 = new Dev();
        dev2.setNome("Joao");
        dev2.inscreverBootcamp(bootcamp);

        System.out.println("--------------------\nBootcamps incritos");
        System.out.println("Conteudo incritos Antonio: \n" + dev1.getConteudosIncricoes());
        System.out.println("Conteudo incritos Joao: \n" + dev2.getConteudosIncricoes());

        System.out.println("--------------------\nBootcamps concluidos");

        dev1.progredir();
        dev1.progredir();
        dev2.progredir();
        dev2.progredir();
        System.out.println("Conteudo concluidos Antonio: \n" + dev1.getConteudosConcluidos() + "\nTotal de XP: " + dev1.calcularXp());
        System.out.println("Conteudo concluidos Joao: \n" + dev2.getConteudosConcluidos() + "\nTotal de XP: " + dev1.calcularXp());




    }
}
