package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Consultoria {

    private String nome;
    private Integer vagas = 1;
    private List<Desenvolvedor>desenvolvedores = new ArrayList<>();

    public Consultoria(String nome, Integer vagas, List<Desenvolvedor> desenvolvedores) {
        this.nome = nome;
        this.vagas = vagas;
    }
    public Consultoria(){}


    public void  contratar(Desenvolvedor desenvolvedor){
        if (desenvolvedores.size() < vagas){
            this.desenvolvedores.add(desenvolvedor);
        }



    }


    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if(desenvolvedor.isFullstack() == Boolean.TRUE){
         return this.desenvolvedores.add(desenvolvedor);
        }else {
            return null;
        }
    }

    public Double getTotalSalarios(){
        return this.desenvolvedores
                .stream()
                .mapToDouble(desenvolvedor -> desenvolvedor.calcularSalario())
                .sum();
    }

    public Integer qtdDesenvolvedoresMobile(){
        return this.desenvolvedores.stream().filter(desenvolvedor -> desenvolvedor instanceof DesenvolvedorMobile).toList().size();
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        return (List<Desenvolvedor>) this.desenvolvedores.stream().max(Comparator.comparing(Desenvolvedor::calcularSalario)).get();
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores == null){
            return null;
        }

        return this.desenvolvedores.stream().min(Comparator.comparing(Desenvolvedor::calcularSalario)).get();
    }

    //Desafio

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){
        return (List<Desenvolvedor>) this.desenvolvedores.stream().filter(desenvolvedor -> desenvolvedores.contains(tecnologia));
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        return  null;
    }




    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
}
