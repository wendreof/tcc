import java.util.Objects;

public class Estudante {

    private String nome;
    private String tituloTcc;
    private Boolean aprovado;
    private int idade;

    public String getNome() {
        return nome;
    }

    public String getTituloTcc() {
        return tituloTcc;
    }

    public Boolean getAprovado() {
        return aprovado;
    }

    public int getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTituloTcc(String tituloTcc) {
        this.tituloTcc = tituloTcc;
    }

    public void setAprovado(Boolean aprovado) {
        this.aprovado = aprovado;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return "Estudante{" +
                "nome='" + nome + '\'' +
                ", tituloTcc='" + tituloTcc + '\'' +
                ", aprovado=" + aprovado +
                ", idade=" + idade +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Estudante)) return false;
        Estudante estudante = (Estudante) o;
        return getIdade() == estudante.getIdade() &&
                Objects.equals(getNome(), estudante.getNome()) &&
                Objects.equals(getTituloTcc(), estudante.getTituloTcc()) &&
                Objects.equals(getAprovado(), estudante.getAprovado());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome(), getTituloTcc(), getAprovado(), getIdade());
    }
}
