package udemy;

import java.util.ArrayList;

public class Telephone {
    String myPhoneNumber;
    ArrayList<Contact>repertoire;

    public Telephone(String myPhoneNumber) {
        this.myPhoneNumber = myPhoneNumber;
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


    public int findContact(Contact contact){
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
        if (position>=0){
            repertoire.remove(position);

        }
        System.out.println("the name "+ contact.getName()+" was not found in the repertoire");

    }

    void editRepertoire(int position, Contact newContact){

           repertoire.set(position,newContact);
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


}
