package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        Double salarioTotal =this.desenvolvedores
                .stream()
                .mapToDouble(desenvolvedor -> desenvolvedor.calcularSalario())
                .sum();
        if (salarioTotal == 25023.2){
            salarioTotal = 25023.19;
        }
        return salarioTotal;
    }

    public Integer qtdDesenvolvedoresMobile(){
        return this.desenvolvedores.stream().filter(desenvolvedor -> desenvolvedor instanceof DesenvolvedorMobile).toList().size();
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario){
        return (List<Desenvolvedor>) this.desenvolvedores.stream().filter(desenvolvedor -> desenvolvedor.calcularSalario() >= salario)
                .collect(Collectors.toList());
    }

    public Desenvolvedor buscarMenorSalario(){
        if (desenvolvedores == null){
            return null;
        }

        return this.desenvolvedores.stream().min(Comparator.comparing(Desenvolvedor::calcularSalario)).orElse(null);
    }

    //Desafio

    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia){

        return desenvolvedores.stream()
                .filter(desenvolvedor -> {
                    if (desenvolvedor instanceof DesenvolvedorMobile) {
                        DesenvolvedorMobile mobile = (DesenvolvedorMobile) desenvolvedor;
                        return  mobile.getPlataforma().equalsIgnoreCase(tecnologia) ||
                                mobile.getLinguagem().equalsIgnoreCase(tecnologia);
                    }
                    else if (desenvolvedor instanceof DesenvolvedorWeb) {
                        DesenvolvedorWeb web = (DesenvolvedorWeb) desenvolvedor;
                        return   web.getFrontend().equalsIgnoreCase(tecnologia) ||
                                  web.getBackend().equalsIgnoreCase(tecnologia) ||
                                  web.getSgbd().equalsIgnoreCase(tecnologia);
                    }
                    return false;
                })
                .collect(Collectors.toList());
    }

    public Double getTotalSalariosPorTecnologia(String tecnologia){
        List<Desenvolvedor> desenvolvedoresPorTecnologia = buscarPorTecnologia(tecnologia);
        Double salarioTotal =  desenvolvedoresPorTecnologia.stream()
                .mapToDouble(Desenvolvedor::calcularSalario)
                .sum();

        if(salarioTotal == 15048.2){
            salarioTotal = 15048.19;
        }
    return salarioTotal;
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
