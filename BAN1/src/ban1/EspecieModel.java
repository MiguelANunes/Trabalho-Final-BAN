package ban1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EspecieModel {
    
    public static void create(EspecieBean EB, Connection C) throws SQLException{
        PreparedStatement st;
        st = C.prepareStatement("insert into especies (codespecie, nomeespecie, expectivaespecie)" + 
                "values (?,?,?)");
        st.setInt(1, EB.getCodespecie());
        st.setString(2, EB.getNomeespecie());
        st.setInt(3, EB.getExpectativaespecie());
        st.execute();
        st.close();
    }
    
    public static HashSet listAll(Connection C) throws SQLException{
        Statement st;
        HashSet retorno = new HashSet();
        st = C.createStatement();
        ResultSet resultado = st.executeQuery("select codespecie, nomeespecie, expectivaespecie");
        
        while(resultado.next()){
//            retorno.add(new EspecieBean(resultado.getInt(1), resultado.getString(2), resultado.getInt(3)));
        }
        
        return retorno;
    }
    
}
