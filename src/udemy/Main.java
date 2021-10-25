package udemy;

import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final MobilePhone mobilePhone = new MobilePhone("0039 330 4404");
    private static final Telephone telephone=new Telephone("0880311414");

    public static void main(String[] args) {
        bootingUpPhone();
        printFunctions();

      boolean LoppingShouldContinue=true;
      while (LoppingShouldContinue){
          System.out.println("Enter the choice you want: 5 to print menu");
          int choice=scanner.nextInt();
          scanner.nextLine();
          switch (choice) {
              case 0 -> {
                  shutOff();
                  LoppingShouldContinue = false;
              }
              case 1 -> addContact();
              case 2 -> edit();
              case 3 -> remove();
              case 4 -> queryContact();
              case 5 -> printFunctions();
              case 6 -> telephone.print();
          }
      }







    }
    public static void addContact(){
        System.out.println("Enter contact name");
        String name=scanner.nextLine().toUpperCase();

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
       String  name=scanner.nextLine().toUpperCase();
      Contact existingContact=telephone.queryContact(name);
      if (existingContact!=null){
          System.out.println("the contact was found and has been deleted");
          telephone.removeContact(existingContact);
      }
      else{
          System.out.println("the contact wasn't found");
      }
    }

    public static void edit(){
        System.out.println("Enter old name");
        String oldName=scanner.nextLine().toUpperCase();
        Contact name=telephone.queryContact(oldName);

     if (name!=null){

         System.out.println("Enter the new name");
         String newName=scanner.nextLine().toUpperCase();

         System.out.println("Enter number");
         String number=scanner.nextLine().toUpperCase();
         telephone.editRepertoire(name,Contact.createContact(newName,number));
     }
     else{
         System.out.println("wasn't able to edit");
     }

    }


    public static void bootingUpPhone(){
        System.out.println("turning your phone on");

    }
    public static void shutOff(){
        System.out.println("Good bye");
        System.out.println("shutting off...............");

    }


    public static void queryContact(){
        System.out.println("Enter name of the person you want to search");
        String name=scanner.nextLine().toUpperCase();
        Contact contact= telephone.queryContact(name);
        if (contact!=null){
        telephone.queryContact(contact);
        }
        else{
            System.out.println("the number was  ");
        }
    }

    public static void printFunctions(){
        System.out.println("""
                0------------> switch off the phone
                1------------> add new contact.
                2------------> edit contact.
                3------------> remove contacts
                4------------> search contacts
                5------------> show menu again
                6------------> print library
                """);
    }


}