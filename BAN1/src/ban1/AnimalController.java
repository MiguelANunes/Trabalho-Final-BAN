package ban1;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.time.LocalDate;

public class AnimalController {
    
    public  void createAnimal(Connection con) throws SQLException{
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        System.out.println("Insira os dados para criar um novo Animal:");
        System.out.println("nome: ");
        String nome = sc.nextLine();
        sc.nextLine();
        System.out.println("codEspecie: ");
        int codEspecie = sc.nextInt();
        sc.nextLine();
        System.out.println("codAnimal: ");
        int codAnimal = sc.nextInt();
        sc.nextLine();
        System.out.println("codAnimalPai: ");
        int codAnimalPai = sc.nextInt();
        sc.nextLine();
        System.out.println("codAnimalMae: ");
        int codAnimalMae = sc.nextInt();
        sc.nextLine();
        System.out.println("data de nascimento do animal (Use yyyy/mm/dd): ");
        String dtnasAnimal = sc.nextLine();
        
        AnimalBean ab = new AnimalBean(nome,codEspecie,codAnimal,codAnimalPai,codAnimalMae,dtnasAnimal);
        AnimalModel.create(ab,con);
        System.out.println("Animal criado com sucesso!");
    }
    
    void listarAnimais(Connection con) throws SQLException{
        HashSet all = AnimalModel.listAll(con);
        Iterator<AnimalBean> it = all.iterator();
        while(it.hasNext()){
            System.out.println(it.next().toString());
        }
    }
    
    
    
    
}
