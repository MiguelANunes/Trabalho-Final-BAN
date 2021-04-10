package ban1;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.HashSet;



public class AnimalBean {
    private String nomeAnimal;
    private int codEspecie, codAnimal,codAnimalPai, codAnimalMae;
    private String dtnasAnimal;

    public AnimalBean(String nomeAnimal, int codEspecie, int codAnimal, int codAnimalPai, int codAnimalMae, String dtnasAnimal) {
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

    public int getCodAnimalPai() {
        return codAnimalPai;
    }

    public int getCodAnimalMae() {
        return codAnimalMae;
    }

    public String getDtnasAnimal() {
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

    public void setDtnasAnimal(String dtnasAnimal) {
        this.dtnasAnimal = dtnasAnimal;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("Nome: "+nomeAnimal+"CodEspecie: "+codEspecie+" CodAnimal: "+codAnimal+" CodAnimalPai: "+codAnimalPai+" CodAnimalMae: "+codAnimalMae+" Data de Nascimento: "+dtnasAnimal);
        
        return sb.toString();
    }
    
    
    
    
    
}
