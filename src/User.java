/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

public abstract class User {
    
    private static Integer qtdUser = 0;

    private Integer userID;
    private String userName;

    public Integer getUserID(){
        return this.userID;
    }
    public String getUserName(){
        return this.userName;
    }
    public static Integer getQtdUser(){
        return User.qtdUser;
    }

    public void setUserID(Integer userID){
        this.userID = userID;
    }
    public void setUserName(String userName){
        this.userName = userName;
    }
    public void addNewUser(){
        User.qtdUser++;
    }

    public User(){

    }

    public String toString(){
        return this.userID + " - " + this.userName;
    }

    public abstract String toString(boolean complete);

    public boolean equals(Object obj){
        if(obj instanceof User){
            User temp = (User) obj;
            if(temp.getUserID() == this.getUserID())
                return true;
        }
        return false;
    }

    public void setRegistration(String registration){};

    public void setDiscipline(String discipline){};

}
