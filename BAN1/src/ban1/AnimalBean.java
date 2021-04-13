package ban1;
import java.sql.Date;


public class AnimalBean {
    private String nomeAnimal;
    private int codEspecie, codAnimal;
    Integer codAnimalPai, codAnimalMae;
    private Date dtnasAnimal;

    public AnimalBean(String nomeAnimal, int codEspecie, int codAnimal, Integer codAnimalPai, Integer codAnimalMae, Date dtnasAnimal) {
        this.nomeAnimal = nomeAnimal;
        this.codEspecie = codEspecie;
        this.codAnimal = codAnimal;
        this.codAnimalPai = codAnimalPai;
        this.codAnimalMae = codAnimalMae;
        this.dtnasAnimal = dtnasAnimal;
    }

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public int getCodEspecie() {
        return codEspecie;
    }

    public int getCodAnimal() {
        return codAnimal;
    }

    public Integer getCodAnimalPai() {
        return codAnimalPai;
    }

    public Integer getCodAnimalMae() {
        return codAnimalMae;
    }

    public Date getDtnasAnimal() {
        return dtnasAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public void setCodEspecie(int codEspecie) {
        this.codEspecie = codEspecie;
    }

    public void setCodAnimal(int codAnimal) {
        this.codAnimal = codAnimal;
    }

    public void setCodAnimalPai(int codAnimalPai) {
        this.codAnimalPai = codAnimalPai;
    }

    public void setCodAnimalMae(int codAnimalMae) {
        this.codAnimalMae = codAnimalMae;
    }

    public void setDtnasAnimal(Date dtnasAnimal) {
        this.dtnasAnimal = dtnasAnimal;
    }

    @Override
    public String toString() {
        return "AnimalBean{" + "nomeAnimal=" + nomeAnimal + ", codEspecie=" + codEspecie + ", codAnimal=" + codAnimal + ", codAnimalPai=" + codAnimalPai + ", codAnimalMae=" + codAnimalMae + ", dtnasAnimal=" + dtnasAnimal + '}';
    }
    
    
    
}
