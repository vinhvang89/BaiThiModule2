package Manager;

import Source.Contact;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ContactManager {
    private final ArrayList<Contact> contacts;
    private static ContactManager contactManager;
    private final String PHONE_WRONG = "This phone number is wrong";
    private ContactManager() {
        contacts = new ArrayList<>();
    }
    public static ContactManager getInstance(){
        if(contactManager == null)
            contactManager = new ContactManager();
        return contactManager;
    }
    public void newContact(String name,String phoneNumber,String group,String gender,String address,String birthday,String email){
        contacts.add(new Contact(name,phoneNumber,group,gender,address,birthday,email));
    }

    public ArrayList<Contact> getContacts() {
        return contacts;
    }
    public boolean checkPhoneNumber(String phoneNumber){
        for(Contact contact : contacts){
            if( contact.getPhoneNumber().equals(phoneNumber))
                return true;
        }
        return  false;
    }
    public void editGroup(String phoneNumber,String newGroup){
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setGroup(newGroup);
                    return;
                }
            }
    }
    public void editBirthday(String phoneNumber,String birthday){
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setBirthday(birthday);
                    return;
                }
            }
    }
    public void editAddress(String phoneNumber,String newAddress){
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setAddress(newAddress);
                    return;
                }
            }
    }
    public void editEmail(String phoneNumber,String newEmail){
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setEmail(newEmail);
                    return;
                }
            }
    }
    public void editName(String phoneNumber,String newName){
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setName(newName);
                    return;
                }
            }
    }
    public void editGender(String phoneNumber,String newGender){
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setGender(newGender);
                    return;
                }
            }
    }
    public void removeContact(String phoneNumber){
        for (Contact contact : contacts){
            if( contact.getPhoneNumber().equals(phoneNumber)) {
                contacts.remove(contact);
                return;
            }
        }
    }
    public void display(){
        for(Contact contact : contacts){
            System.out.println(contact.toString());
        }
    }
    public void search(String phoneNumber){
        for (Contact contact : contacts){
            if( contact.getPhoneNumber().contains(phoneNumber))
                System.out.println( contact.toString());
        }
    }
    public void saveFile(){
        try {
            FileOutputStream f_o = new FileOutputStream("E:\\Codegym\\Module 2\\Week9\\ThiPassModule2\\contact.txt");
            for (Contact contact : contacts) {
                byte[] bytes = contact.toString().getBytes();
                byte[] down = "\n".getBytes();
                f_o.write(bytes);
                f_o.write(down);
            }
            f_o.close();
        } catch (IOException e){
            System.out.println("Error error");
        }
    }
    public void readFile(){
        try {
            String link = "E:\\Codegym\\Module 2\\Week9\\ThiPassModule2\\contact.txt";
            FileReader path = new FileReader(link);
            BufferedReader br = new BufferedReader(path);
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] content = line.split(" ,");
                String name = content[0].substring(6);
                String phoneNumber = content[1].substring(14);
                String group = content[2].substring(7);
                String gender = content[3].substring(8);
                String address = content[4].substring(8);
                String birthday = content[5].substring(10);
                String email = content[6].substring(7);
                newContact(name,phoneNumber,group,gender,address,birthday,email);
            }
            br.close();
        }catch (IOException e){
            System.out.println("Error Error");
        }
    }
}
