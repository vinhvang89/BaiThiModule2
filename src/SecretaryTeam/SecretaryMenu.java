package SecretaryTeam;

public class SecretaryMenu {
    private static SecretaryMenu secretaryMenu;
    private SecretaryMenu() {
    }
    public static SecretaryMenu getInstance(){
        if( secretaryMenu == null)
            secretaryMenu = new SecretaryMenu();
        return  secretaryMenu;
    }
    public void mainMenu(){
        System.out.println("<===== Contact Manager =====>");
        System.out.println("1. Display all of contact");
        System.out.println("2. New a contact");
        System.out.println("3. Edit a contact");
        System.out.println("4. Remove a contact");
        System.out.println("5. Search by Phone number");
        System.out.println("6. Read from file");
        System.out.println("7. Write to file");
        System.out.println("0. Exit");
    }
    public void editMenu(){
        System.out.println("<+++++ Edit menu +++++>");
        System.out.println("1. Edit name ");
        System.out.println("2. Edit group ");
        System.out.println("3. Edit gender ");
        System.out.println("4. Edit birthday ");
        System.out.println("5. Edit address ");
        System.out.println("6. Edit email ");
        System.out.println("6. Edit all information ");
        System.out.println("0. Back to previous menu");
    }
}
