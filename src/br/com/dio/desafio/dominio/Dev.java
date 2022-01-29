package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosIncricoes = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    public void inscreverBootcamp(Bootcamp bootcamp){
        this.conteudosIncricoes.addAll(bootcamp.getConteudos());
        bootcamp.getDevIncritos().add(this);
    }

    public void progredir(){
        Optional<Conteudo> conteudo = this.conteudosIncricoes.stream().findFirst();
        if(conteudo.isPresent()){
            this.conteudosConcluidos.add(conteudo.get());
            this.conteudosIncricoes.remove(conteudo.get());
        }else {
            System.err.println("Voce nao estar matriculado em nenhum conteudo!");
        }

    }

    public double calcularXp(){
        return this.conteudosConcluidos.stream().mapToDouble(Conteudo::calcularXp).sum();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosIncricoes() {
        return conteudosIncricoes;
    }

    public void setConteudosIncricoes(Set<Conteudo> conteudosIncricoes) {
        this.conteudosIncricoes = conteudosIncricoes;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    public void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosIncricoes, dev.conteudosIncricoes) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosIncricoes, conteudosConcluidos);
    }
}
