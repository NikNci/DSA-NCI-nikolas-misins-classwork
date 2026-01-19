package addressbookapp;

/**
 *
 * @author Nikolas
 */
public class BusinessContact extends ContactTemplate{
    //data members
    private String companyName;
    
    //constructor
    public BusinessContact(){
        super();
        companyName = "Null";
    }
    
    //set
    public void setCompanyName(String c){
        this.companyName = c;
    }
    
    @Override
    public String showDetails(){
        return super.showDetails() + companyName;
    }
}
