package ban1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class EspecieController {
    
    public void createEspecie(Connection C) throws SQLException{
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Insira as Informações da Espécie:");
        System.out.print("Código: ");
        int codE = sc.nextInt();
        
        System.out.println("");
        System.out.print("Nome: ");
        String nome = sc.nextLine();
        
        System.out.println("");
        System.out.print("Expectativa de Vida: ");
        int expectativa = sc.nextInt();
        
        EspecieBean EB = new EspecieBean(codE, expectativa, nome);
        // EspecieModel.create(EB,C);
        System.out.println("Especie Adicionada com Sucesso !");
    }
    
    public void ListarEspecies(){
        // Precisa do Model
    }
}
