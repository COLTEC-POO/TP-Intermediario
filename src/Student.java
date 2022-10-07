/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

public class Student extends User{
    
    private String registration;

    public String getRegistration(){
        return this.registration;
    }

    public void setRegistration(String registration){
        this.registration = registration;
    }


    public Student(){

    }

    public Student(Integer userID, String userName, String registration){
        this.setUserID(userID);
        this.setUserName(userName);
        this.setRegistration(registration);
    }


    public String toString(boolean complete){
        return "ID: " + this.getUserID() + " Name: " + this.getUserName() + " Registration: " + this.getRegistration();
    }

    public boolean equals(Object obj){
        if(obj instanceof Student){
            Student temp = (Student) obj;
            if(temp.getRegistration() == this.registration)
                return true;
        }
        return false;
    }
}