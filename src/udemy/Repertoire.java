package udemy;

public class Repertoire {
    String name;
    String number;

    public String getName() {
        return name;
    }



    public String getNumber() {
        return number;
    }

    public Repertoire(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public static Contact createContact(String name,String number){
        return new Contact(name,number);
    }

}
