
package ban1;

public class EspecieBean {
    private int codespecie, expectativaespecie;
    private String nomeespecie;

    public EspecieBean(int codespecie, int expectativaespecie, String nomeespecie) {
        this.codespecie = codespecie;
        this.expectativaespecie = expectativaespecie;
        this.nomeespecie = nomeespecie;
    }

    public int getCodespecie() {
        return codespecie;
    }

    public int getExpectativaespecie() {
        return expectativaespecie;
    }

    public String getNomeespecie() {
        return nomeespecie;
    }

    public void setCodespecie(int codespecie) {
        this.codespecie = codespecie;
    }

    public void setExpectativaespecie(int expectativaespecie) {
        this.expectativaespecie = expectativaespecie;
    }

    public void setNomeespecie(String nomeespecie) {
        this.nomeespecie = nomeespecie;
    }
    
    
    
    
    
    
}
