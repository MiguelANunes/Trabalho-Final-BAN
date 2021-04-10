package ban1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import ban1.*;


public class Main {

    public static void main(String[] args) throws SQLException {
    Conexao c = new Conexao();
    Connection con = c.getConnection();
    int opcao = 0;
    
    do{
        opcao = menu();
        try{
            switch(opcao){
                
                case 1:
                    
                    break;
                    
                case 2:
                    
                    break;
                    
                case 3:
                    
                    break;
                    
                case 4:
                    
                    break;
                    
                case 5:
                    
                    break;
                    
                case 6:
                    
                    break;
                
            }
            
            
            
            
            
            
            
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        
        
        
        
        
        
    }while (opcao>0 && opcao<7);
    con.close();
        
        
        
        
    }
    
    
    private static int menu(){
        System.out.println("Selecione uma das opcoes abaixo:");
        System.out.println("1 - Inserir novo Animal");
        System.out.println("2 - Inserir nova Especie");
        System.out.println("3 - Listar Animais");
        System.out.println("4 - Listar Especies");
        System.out.println("5 - Listar Animais e Especies");
        System.out.println("6 - Listar Subconsulta e/ou funcao de agregacao"); // mudar isso eventualmente
        System.out.println("Selecione qualquer outra opcao para sair do programa");
        System.out.println("Sua opcao: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    
}
