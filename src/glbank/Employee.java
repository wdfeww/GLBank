

package glbank;


public class Employee {
    private int idemp;
    private String firstname;
    private String lastname;
    private String email;
    private char postion;

    public Employee(int idemp, String firstname, String lastname, String email, char postion) {
        this.idemp = idemp;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.postion = postion;
    }
    
    public int getIdemp() {
        return idemp;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public char getPostion() {
        return postion;
    }
    
}
