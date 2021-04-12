package ban1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;



public class AnimalModel {
    static void create(AnimalBean ab, Connection con) throws SQLException{
        PreparedStatement st;
        st = con.prepareStatement("INSERT INTO animais (nomeanimal, codespecie, codanimal,codanimalpai,codanimalmae,dtnasanimal)" + "VALUES (?,?,?,?,?,?)");
        st.setString(1, ab.getNomeAnimal());
        st.setInt(2, ab.getCodEspecie());
        st.setInt(3, ab.getCodAnimal());
        st.setInt(4, ab.getCodAnimalPai());
        st.setInt(4, ab.getCodAnimalMae());
        st.setString(5, ab.getNomeAnimal());
        st.execute();
        st.close();
    }
    
    
    static HashSet listAll(Connection con) throws SQLException{
        Statement st;
        HashSet list = new HashSet();
        st = con.createStatement();
        String sql = "Select nomeanimal, codespecie, codanimal, codanimalpai, codanimalmae, dtnasanimal FROM animais";
        ResultSet result = st.executeQuery(sql);

        while(result.next()){
            list.add(new AnimalBean(result.getString(1),result.getInt(2),result.getInt(3),result.getInt(4),result.getInt(5),result.getString(6)));
        }
        
        return list;
    }
    
}

