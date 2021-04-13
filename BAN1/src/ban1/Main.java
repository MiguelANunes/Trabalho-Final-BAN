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
        System.out.println("5 - Listar Junção entre Especies e Animais");
        System.out.println("6 - Listar Subconsulta e/ou funcao de agregacao"); // mudar isso eventualmente
        System.out.println("Escreva qualquer outro número para sair");
        System.out.println("Sua opcao: ");
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();
    }
    
    
    private static void juncao(Connection C) throws SQLException{
        
        Statement st = C.createStatement();
        String atributos = "";
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        
        do{ // Sim, esses prints de atributos poderiam estar dentro de uma função, mas não tenho saco de fazer isso
            // Related: https://en.wikipedia.org/wiki/Sunk_cost
            
            System.out.println("Selecione os atributos da Classe Espécie que devem aparecer na Junção:");
            // se repetir atributos provavelmente vai dar problema
            System.out.println("Atibutos já escolhidos: " + atributos);
            System.out.println("1: codespecie");
            System.out.println("2: nomeespecie");
            System.out.println("3: expectivaespecie");
            System.out.println("4: Pular (só selecione essa opção se não quer nenhum atributo de Espécie)");
            opcao = sc.nextInt();
            
            if(opcao == 1) atributos += "especies.codespecie";
            if(opcao == 2) atributos += "nomeespecie";
            if(opcao == 3) atributos += "expectivaespecie";
            if(opcao == 4) break;
            
            System.out.println("Digite -1 para sair e 4 para escolher mais um atributo");
            opcao = sc.nextInt();
            
            if(opcao == 4) atributos += ", ";
            
        }while(opcao > 0);
        
        opcao = 0;
        
        do{
            atributos += atributos.length() == 0 ? "" : ", ";
            System.out.println("Selecione os atributos da Classe Animal que devem aparecer na Junção:");
            // se repetir atributos provavelmente vai dar problema
            System.out.println("Atibutos já escolhidos: " + atributos);
            System.out.println("1: nomeanimal");
            System.out.println("2: codespecie");
            System.out.println("3: codanimal");
            System.out.println("4: codanimalpai");
            System.out.println("5: codanimalmae");
            System.out.println("6: dtnasanimal");
            System.out.println("7: Pular (só selecione essa opção se não quer nenhum atributo de Animal)");
            opcao = sc.nextInt();
            
            if(opcao == 1) atributos += "nomeanimal";
            if(opcao == 2) atributos += "animais.codespecie";
            if(opcao == 3) atributos += "codanimal";
            if(opcao == 4) atributos += "codanimalpai";
            if(opcao == 5) atributos += "codanimalmae";
            if(opcao == 6) atributos += "dtnasanimal";
            if(opcao == 7) break;
            
            System.out.println("Digite -1 para sair e 8 para escolher mais um atributo");
            opcao = sc.nextInt();
            
            if(opcao == 8) atributos += ", ";
            
        }while(opcao > 0);
        
        opcao = 0;
        String tipoJuncao;
        String condicao = ""; // isso evita que o Java reclame
        boolean natural = true;
        
        System.out.println("É uma Junção Natural ?");
        System.out.println("1: Sim\n2: Não");
        opcao = sc.nextInt();
        tipoJuncao = opcao == 1 ? " natural join " : " join ";
        
        if(opcao == 2){
            
            natural = false;
            condicao = " on ";
            
            System.out.println("Especifique a Condição da Junção");
            System.out.println("(Será sempre da forma <attrEspecies> <operador> <attrAnimal>)");
            System.out.println("\tAtributos de Especie:");
            System.out.println("\t1: codespecie");
            System.out.println("\t2: nomeespecie");
            System.out.println("\t3: expectivaespecie");
            
            opcao = sc.nextInt();
            if(opcao == 1) condicao += "especies.codespecie";
            if(opcao == 2) condicao += "nomeespecie";
            if(opcao == 3) condicao += "expectivaespecie";
            
            System.out.println("\tOperadores: ");
            System.out.println("\t1: = ");
            System.out.println("\t2: > ");
            System.out.println("\t3: >= ");
            System.out.println("\t4: < ");
            System.out.println("\t5: <= ");
            
            opcao = sc.nextInt();
            if(opcao == 1) condicao += " = ";
            if(opcao == 2) condicao += " > ";
            if(opcao == 3) condicao += " >= ";
            if(opcao == 4) condicao += " < ";
            if(opcao == 5) condicao += " <= ";
            
            System.out.println("\tAtributos de Especie:");
            System.out.println("\t1: nomeanimal");
            System.out.println("\t2: codespecie");
            System.out.println("\t3: codanimal");
            System.out.println("\t4: codanimalpai");
            System.out.println("\t5: codanimalmae");
            System.out.println("\t6: dtnasanimal");
            
            opcao = sc.nextInt();
            if(opcao == 1) condicao += "nomeanimal";
            if(opcao == 2) condicao += "animais.codespecie";
            if(opcao == 3) condicao += "codanimal";
            if(opcao == 4) condicao += "codanimalpai";
            if(opcao == 5) condicao += "codanimalmae";
            if(opcao == 6) condicao += "dtnasanimal";

        }
        
        System.out.println("É uma Junção à Esquerda ?");
        System.out.println("1: Sim\n2: Não");
        opcao = sc.nextInt();
        
        if(opcao == 1){
            if(tipoJuncao.trim().length() == 4){ // comprimento == 4 -> tipoJunção = Join
                tipoJuncao = " left join ";
            }else{
                tipoJuncao = " natural left join ";
            }
        }else{
            
            System.out.println("É uma Junção à Direita ?");
            System.out.println("1: Sim\n2: Não");
            opcao = sc.nextInt();
            
            if(opcao == 1){
                if(tipoJuncao.trim().length() == 4){ // comprimento == 4 -> tipoJunção = Join
                    tipoJuncao = " right join ";
                }else{
                    tipoJuncao = " natural right join ";
                }
            }
        }
        
        System.out.println("Quem está à Esquerda ?");
        System.out.println("(Sim, isso é irrelevante caso não seja uma consulta externa, mas é mais fácil fazer desse jeito)");
        System.out.println("1: Especie\n2: Animal");
        opcao = sc.nextInt();
        
        tipoJuncao = opcao == 1 ? "especies" + tipoJuncao + "animais" : "animais" + tipoJuncao + "especies";
        tipoJuncao = natural ? tipoJuncao : tipoJuncao + condicao;
        
        String where = "";
        boolean temWhere = false;
        
        System.out.println("Adicionar uma cláusula where ?");
        System.out.println("1: Sim\n2: Não");
        opcao = sc.nextInt();
        
        if(opcao == 1){ // fucking kill me
            temWhere = true;
            System.out.println("Selecione o atributo relevante: ");
            System.out.println("1: [Especie] codespecie");
            System.out.println("2: [Especie] nomeespecie");
            System.out.println("3: [Especie] expectivaespecie");
            System.out.println("4: [Animais] nomeanimal");
            System.out.println("5: [Animais] codespecie");
            System.out.println("6: [Animais] codanimal");
            System.out.println("7: [Animais] codanimalpai");
            System.out.println("8: [Animais] codanimalmae");
            System.out.println("9: [Animais] dtnasanimal");
            opcao = sc.nextInt();
            
            if(opcao == 1) where += "especies.codespecie";
            if(opcao == 2) where += "nomeespecie";
            if(opcao == 3) where += "expectivaespecie";
            if(opcao == 4) where += "nomeanimal";
            if(opcao == 5) where += "codanimal";
            if(opcao == 5) where += "animais.codespecie";
            if(opcao == 7) where += "codanimalpai";
            if(opcao == 8) where += "codanimalmae";
            if(opcao == 9) where += "dtnasanimal";
            
            System.out.println("Selecione o Operador: ");
            System.out.println("1: = ");
            System.out.println("2: > ");
            System.out.println("3: >= ");
            System.out.println("4: < ");
            System.out.println("5: <= ");
            
            opcao = sc.nextInt();
            if(opcao == 1) where += " = ";
            if(opcao == 2) where += " > ";
            if(opcao == 3) where += " >= ";
            if(opcao == 4) where += " < ";
            if(opcao == 5) where += " <= ";
            
            System.out.println("Digite o valor que será comparado: ");
            System.out.println("(Caso queria comparar com um atributo, escreva <nomeTabela>.<nomeAtributo>)");
            where += sc.nextLine();
        }
        
        String consulta;
        consulta =  temWhere ? "select " + atributos + " from " + tipoJuncao + " where " + where 
                             : "select " + atributos + " from " + tipoJuncao ;
        
        ResultSet resultado = st.executeQuery(consulta);
    }
    
}
