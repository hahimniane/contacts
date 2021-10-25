package udemy;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone("0039 330 4404");
    private static final Telephone telephone=new Telephone("0880311414");

    public static void main(String[] args) {
        addContact();
        edit();
        telephone.print();


        telephone.print();




    }
    public static void addContact(){
        System.out.println("Enter contact name");
        String name=scanner.nextLine();

        System.out.println("Enter phone number");
        String number=scanner.nextLine();

        if (telephone.addContact(Contact.createContact(name, number))){
            System.out.println("the contact was added successfully");

        }
        else{
            System.out.println("the contact exists already");
        }



    }

    public static void remove() {
        System.out.println("Enter the person's name you want to remove!");
       String  name=scanner.nextLine();
      Contact existingContact=telephone.queryContact(name);
      if (existingContact!=null){
          System.out.println("the contact was found and has been deleted");
          telephone.removeContact(existingContact);
      }
      else{
          System.out.println("it wasn't found");
      }
    }

    public static void edit(){
        System.out.println("Enter old name");
        String oldName=scanner.nextLine();
        Contact name=telephone.queryContact(oldName);

     if (name!=null){
         int location=telephone.findContact(name);
         System.out.println("Enter the new name");
         String newName=scanner.nextLine();
         System.out.println("Enter new number!");
         String number=scanner.nextLine();
         telephone.editRepertoire(location,);


     }
    }

}