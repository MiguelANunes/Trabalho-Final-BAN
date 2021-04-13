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
                    AnimalController.createAnimal(con);
                    break;
                    
                case 2:
                    EspecieController.createEspecie(con);
                    break;
                    
                case 3:
                    AnimalController.listarAnimais(con);
                    break;
                    
                case 4:
                    EspecieController.ListarEspecies(con);
                    break;
                    
                case 5:
                    juncao(con);
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
        System.out.println("5 - Listar Junção entre Animais e Especies");
        System.out.println("6 - Listar Subconsulta e/ou funcao de agregacao"); // mudar isso eventualmente
        System.out.println("Selecione qualquer outra opcao para sair do programa");
        System.out.println("Sua opcao: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    
    private static void juncao(Connection C) throws SQLException{
        
        Statement st = C.createStatement();
        String escolha = "";
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        
        do{
            
            System.out.println("Selecione os atributos da Classe Espécie que devem aparecer na Junção:");
            // se repetir atributos provavelmente vai dar problema
            System.out.println("Atibutos já escolhidos: " + escolha);
            System.out.println("1: codespecie");
            System.out.println("2: nomeespecie");
            System.out.println("3: expectivaespecie");
            opcao = sc.nextInt();
            
            if(opcao == 1) escolha += "codespecie";
            if(opcao == 2) escolha += "nomeespecie";
            if(opcao == 3) escolha += "expectivaespecie";
            
            System.out.println("Digite -1 para sair e 4 para escolher mais um atributo");
            opcao = sc.nextInt();
            
            if(opcao == 4) escolha += ", ";
            
        }while(opcao > 0);
        
        opcao = 0;
        escolha = "";
        
        do{
            
            System.out.println("Selecione os atributos da Classe Animal que devem aparecer na Junção:");
            // se repetir atributos provavelmente vai dar problema
            System.out.println("Atibutos já escolhidos: " + escolha);
            System.out.println("1: nomeanimal");
            System.out.println("2: codanimal");
            System.out.println("3: codanimalpai");
            System.out.println("4: codanimalmae");
            System.out.println("5: dtnasanimal");
            opcao = sc.nextInt();
            
            if(opcao == 1) escolha += "nomeanimal";
            if(opcao == 2) escolha += "codanimal";
            if(opcao == 3) escolha += "codanimalpai";
            if(opcao == 4) escolha += "codanimalmae";
            if(opcao == 5) escolha += "dtnasanimal";
            
            System.out.println("Digite -1 para sair e 6 para escolher mais um atributo");
            opcao = sc.nextInt();
            
            if(opcao == 6) escolha += ", ";
            
        }while(opcao > 0);
        
        /*
            Fazer casos para: 
                Join (prompt para a condição de junção)
                Natural Join (sem nenhum prompt)
            Independente do que for selecionado, fazer prompt para uma Left/Right Joi
                Nesse caso tbm perguntar quem que fica na esquerda e quem que fica na direita
        */
        
    }
    
}
