package ban1;

public class EspecieBean {
    private int codespecie;
    private int expectativaespecie;
    private String nomeespecie;

    public EspecieBean(int codespecie, int expectativaespecie, String nomeespecie) {
        this.codespecie = codespecie;
        this.expectativaespecie = expectativaespecie;
        this.nomeespecie = nomeespecie;
        /*
        forçando essa porra desse pull request
        */
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
    
    @Override
    public String toString() {
        return "EspecieBean{" + "codespecie=" + codespecie + ", expectativaespecie=" + expectativaespecie + ", nomeespecie=" + nomeespecie + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final EspecieBean other = (EspecieBean) obj;
        if (this.codespecie != other.codespecie) {
            return false;
        }
        return true;
    }
}
