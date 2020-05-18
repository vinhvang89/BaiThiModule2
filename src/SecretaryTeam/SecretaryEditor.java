package SecretaryTeam;

import Manager.ContactManager;

import java.util.Scanner;


public class SecretaryEditor {
    private ContactManager contactManager;
    private SecretaryMenu secretaryMenu;
    public SecretaryEditor() {
        contactManager = ContactManager.getInstance();
    }
    public void edit(){
        secretaryMenu.editMenu();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a phone number");
        String phoneNumber = scanner.nextLine();
        if( contactManager.checkPhoneNumber(phoneNumber)) {
            System.out.println("Enter your choose :");
            int choose = scanner.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Enter new name : ");
                    String name = scanner.nextLine();
                    contactManager.editName(phoneNumber,name);
                    break;
            }
        }
    }
}
