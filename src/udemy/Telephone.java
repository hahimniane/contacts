package udemy;

import java.util.ArrayList;

public class Telephone {
    String myPhoneNumber;
    ArrayList<Contact>repertoire;

    public Telephone(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
        System.out.println("Phone Imei "+this.myPhoneNumber);
        repertoire=new ArrayList<>();
    }

    boolean addContact(Contact contact){
        if (findContact(contact.getName())>=0){
            return false;
        }
        else {
            repertoire.add(contact);
            return true;
        }
    }


    private int findContact(Contact contact){
        return repertoire.indexOf(contact);
    }
    private int findContact (String name){
        for (int i=0;i<repertoire.size();++i){
            Contact contact=repertoire.get(i);
            if (contact.getName().equals(name)){
                return i;
            }
        }
        return -1;
    }

    void removeContact(Contact contact){
        int position=findContact(contact.getName());

            repertoire.remove(position);
    }

    void editRepertoire(Contact oldContact, Contact newContact) {
        int containsOldContact = findContact(oldContact.getName());
        int containsNewContact = findContact(newContact.getName());
        if (containsOldContact < 0) {
            System.out.println("the contact" + oldContact.getName() + " was not found");

        }
        else if (containsOldContact > 0) {
            if (containsNewContact >= 0) {
                System.out.println("can't be changed to a new contact because name " + newContact.getName() + " already exists");


            }
        }
        else
            repertoire.set(containsOldContact, newContact);
            System.out.println("it was successfully updated:");


    }



    void  print (){
        System.out.println("Number of Records in your list: "+repertoire.size());
        for (int i=0;i<repertoire.size();++i){
            System.out.println((i+1)+". "+repertoire.get(i).getName()+"---->"+repertoire.get(i).getPhoneNumber());
        }
    }
    public Contact queryContact(String name) {
        int position = findContact(name);
        if(position >=0) {
            return this.repertoire.get(position);
        }

        return null;
    }

  void queryContact(Contact contact){
      System.out.println("the name  "+contact.getName()+" was found with the number -----> "+contact.getPhoneNumber());
  }
}
