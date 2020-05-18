package Client;


import Manager.ContactManager;
import SecretaryTeam.SecretaryMenu;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private static Client client;
    private SecretaryMenu secretaryMenu;
    private ContactManager contactManager;
    private Client() {
        secretaryMenu = SecretaryMenu.getInstance();
        contactManager = ContactManager.getInstance();
    }
    public static Client getInstance(){
        if( client == null)
            client = new Client();
        return  client;
    }
    public void app(){
        secretaryMenu.mainMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your choose ");
        int choose = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1 :
                contactManager.display();
                app();
                break;
            case 2:
                System.out.println("Enter name ");
                String name = scanner.nextLine();
                System.out.println("Enter phone number");
                String phoneNumber = scanner.nextLine();
                System.out.println("Enter group");
                String group = scanner.nextLine();
                System.out.println("Enter gender");
                String gender = scanner.nextLine();
                System.out.println("Enter address");
                String address = scanner.nextLine();
                System.out.println("Enter birthday");
                String birthday = scanner.nextLine();
                System.out.println("Enter Email ");
                String email = scanner.nextLine();
                Matcher matcherPhoneNumber = checkPhoneNumber(phoneNumber);
                Matcher matcherEmail = checkEmail(email);
                if( matcherEmail.matches() && matcherPhoneNumber.matches()) {
                    contactManager.newContact(name, phoneNumber, group, gender, address, birthday, email);
                } else {
                    System.out.println("Your email or phone number is not right");
                }
                app();
                break;
            case 3:
                System.out.println("Enter  phone number");
                String phoneNumber3 = scanner.nextLine();
                if(contactManager.checkPhoneNumber(phoneNumber3))
                    edit(phoneNumber3);
                else
                    System.out.println("Your phone number is wrong");
                app();
                break;
            case 4:
                System.out.println("Enter phone number");
                String phoneNumber4 = scanner.nextLine();
                if( contactManager.checkPhoneNumber(phoneNumber4))
                    contactManager.removeContact(phoneNumber4);
                else
                    System.out.println("This phone number is wrong");
                app();
                break;
            case 5:
                System.out.println("Enter phone number");
                String phoneNumber5 = scanner.nextLine();
                contactManager.search(phoneNumber5);
                app();
                break;
            case 6:
                contactManager.saveFile();
                app();
                break;
            case 7:
                contactManager.readFile();
                app();
                break;
            case 0:
                contactManager.saveFile();
                System.out.println("Thank you ^^");
        }
    }
    public void edit(String phoneNumber){
        Scanner scanner = new Scanner(System.in);
        secretaryMenu.editMenu();
        System.out.println("Enter your choose ");
        int choose  = scanner.nextInt();
        scanner.nextLine();
        switch (choose){
            case 1:
                System.out.println("Enter name :");
                String name = scanner.nextLine();
                contactManager.editName(phoneNumber,name);
                edit(phoneNumber);
                break;
            case 2:
                System.out.println("Enter group :");
                String group = scanner.nextLine();
                contactManager.editGroup(phoneNumber,group);
                edit(phoneNumber);
                break;
            case 3:
                System.out.println("Enter gender :");
                String gender = scanner.nextLine();
                contactManager.editGender(phoneNumber,gender);
                edit(phoneNumber);
                break;
            case 4:
                System.out.println("Enter birthday :");
                String birthday = scanner.nextLine();
                contactManager.editBirthday(phoneNumber,birthday);
                edit(phoneNumber);
                break;
            case 5:
                System.out.println("Enter address :");
                String address = scanner.nextLine();
                contactManager.editAddress(phoneNumber,address);
                edit(phoneNumber);
                break;
            case 6:
                System.out.println("Enter email :");
                String email = scanner.nextLine();
                if(checkEmail(email).matches()) {
                    contactManager.editName(phoneNumber, email);
                } else
                    System.out.println("Email is not right");
                edit(phoneNumber);
                break;
            case 7:
                contactManager.removeContact(phoneNumber);
                System.out.println("Enter name ");
                String name1 = scanner.nextLine();
                System.out.println("Enter group");
                String group1 = scanner.nextLine();
                System.out.println("Enter gender");
                String gender1 = scanner.nextLine();
                System.out.println("Enter address");
                String address1 = scanner.nextLine();
                System.out.println("Enter birthday");
                String birthday1 = scanner.nextLine();
                System.out.println("Enter Email ");
                String email1 = scanner.nextLine();
                Matcher matcherPhoneNumber = checkPhoneNumber(phoneNumber);
                Matcher matcherEmail = checkEmail(email1);
                if( matcherEmail.matches()) {
                    contactManager.newContact(name1, phoneNumber, group1, gender1, address1, birthday1, email1);
                } else {
                    System.out.println("Your email  is not right");
                }
                edit(phoneNumber);
                break;
            case 0:
                app();
                break;
            default:
                System.out.println("Please choose from 0 to 7");
                edit(phoneNumber);
        }

    }
    public Matcher checkPhoneNumber(String phoneNumber){
        Pattern pattern = Pattern.compile("^[0][0-9]{2}[0-9]{7}$");
        return pattern.matcher(phoneNumber);
    }
    public Matcher checkEmail(String email){
        Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
        return pattern.matcher(email);
    }
}
