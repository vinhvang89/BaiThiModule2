package Manager;

import Source.Contact;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

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
        if( checkPhoneNumber(phoneNumber)) {
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setGroup(newGroup);
                    return;
                }
            }

        } else
            System.out.println(PHONE_WRONG);
    }
    public void editBirthday(String phoneNumber,String birthday){
        if( checkPhoneNumber(phoneNumber)) {
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setBirthday(birthday);
                    return;
                }
            }

        } else
            System.out.println(PHONE_WRONG);
    }
    public void editAddress(String phoneNumber,String newAddress){
        if( checkPhoneNumber(phoneNumber)) {
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setAddress(newAddress);
                    return;
                }
            }

        } else
            System.out.println(PHONE_WRONG);
    }
    public void editEmail(String phoneNumber,String newEmail){
        if( checkPhoneNumber(phoneNumber)) {
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setEmail(newEmail);
                    return;
                }
            }

        } else
            System.out.println(PHONE_WRONG);
    }
    public void editName(String phoneNumber,String newName){
        if( checkPhoneNumber(phoneNumber)) {
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setName(newName);
                    return;
                }
            }

        } else
            System.out.println(PHONE_WRONG);
    }
    public void editGender(String phoneNumber,String newGender){
        if( checkPhoneNumber(phoneNumber)) {
            for (Contact contact : contacts){
                if( contact.getPhoneNumber().equals(phoneNumber)) {
                    contact.setGender(newGender);
                    return;
                }
            }

        } else
            System.out.println(PHONE_WRONG);
    }
    public void display(){
        for(Contact contact : contacts){
            System.out.println(contact.toString());
        }
    }
    public void saveFile(){
        try {
            FileOutputStream f_o = new FileOutputStream("contact.csv");
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
            String link = "E:\\Codegym\\Module 2\\Week9\\ThiPassModule2\\contact.csv";
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
