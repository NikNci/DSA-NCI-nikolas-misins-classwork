package addressbookapp;

/**
 *
 * @author Nikolas
 */
public class ContactTemplate {
    //standard data members available to all Contact children
    protected String firstname, surname, email, phone, address;
    
    //constructor keeps all values vague, they are meant to be overwritten, if user doesnt fill in a phone number, it does not stop the creation of class
    public ContactTemplate(){
        firstname=surname=email=phone=address=" ";
    }
    
    //setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    //output
    
    public String showDetails(){
        return firstname + surname + "\n" + email + "\n" + phone + "\n" + address + "\n";
    }
}
