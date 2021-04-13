package ban1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.Date;

public class AnimalController {
    
    public static void createAnimal(Connection con) throws SQLException{
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Insira os dados para criar um novo Animal:");
        System.out.println("Nome: ");
        String nome = sc.nextLine();
        sc.nextLine();
        
        System.out.println("Código da Espécie: ");
        int codEspecie = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Código do Animal: ");
        int codAnimal = sc.nextInt();
        sc.nextLine();
        
        System.out.println("Código do Animal Pai (-1 para null): ");
        Integer codAnimalPai = sc.nextInt();
        codAnimalPai = codAnimalPai == -1 ? null : codAnimalPai;
        sc.nextLine();
        
        System.out.println("Código do Animal Mãe (-1 para null): ");
        Integer codAnimalMae = sc.nextInt();
        codAnimalMae = codAnimalMae == -1 ? null : codAnimalMae;
        sc.nextLine();
        
        System.out.println("Data de nascimento do animal (Use yyyy-mm-dd): ");
        String dtnasAnimalStr = sc.nextLine();
        Date dtnasAnimal = Date.valueOf(dtnasAnimalStr);
        
        System.out.println(nome);
        System.out.println(codEspecie);
        System.out.println(codAnimal);
        System.out.println(codAnimalPai);
        System.out.println(codAnimalMae);
//        System.out.println(codEspecie);
        AnimalBean ab = new AnimalBean(nome,codEspecie,codAnimal,codAnimalPai,codAnimalMae,dtnasAnimal);
        AnimalModel.create(ab,con);
        System.out.println("Animal criado com sucesso!");
    }
    
    public static void listarAnimais(Connection con) throws SQLException{
        HashSet all = AnimalModel.listAll(con);
        Iterator<AnimalBean> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    
    
    
    
}
