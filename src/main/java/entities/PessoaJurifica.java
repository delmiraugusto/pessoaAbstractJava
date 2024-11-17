package entities;

public class PessoaJurifica extends Pessoa {

    private Integer numFuncionario;

    public PessoaJurifica() {
    }

    public PessoaJurifica(String nome, Double rendaAnual, Integer numFuncionario) {
        super(nome, rendaAnual);
        this.numFuncionario = numFuncionario;
    }

    public Integer getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(Integer numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    @Override
    public double calcularImposto() {
        if(numFuncionario <= 10) {
            return (getRendaAnual() * 0.16);
        }
        else {
            return (getRendaAnual() * 0.14);
        }

    }
}
