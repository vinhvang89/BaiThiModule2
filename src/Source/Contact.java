package Source;

public class Contact {
   private String name;
   private String phoneNumber;
   private String group;
   private String gender;
   private String address;
   private String birthday;
   private String email;

    public Contact(String name, String phoneNumber, String group, String gender, String address, String birthday, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.group = group;
        this.gender = gender;
        this.address = address;
        this.birthday = birthday;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString(){
        return "Name: " +name+" ,Phone number: "+phoneNumber+" ,Group: "+group+
                " ,Gender: "+gender+" ,Address: "+address+" ,Birthday: "+birthday+" ,Email: "+email;
    }
}
