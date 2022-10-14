/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

 public class Teacher extends User{
    

    private Sector discipline;


    public Sector getDiscipline(){
        return discipline;
    }

    public void setDiscipline(Sector discipline){
        this.discipline = discipline;
    }


    public Teacher(){

    }

    public Teacher(Integer userID, String userName, Sector discipline){
        this.setUserID(userID);
        this.setUserName(userName);
        this.setDiscipline(discipline);
        this.addNewUser();
    }

    public String toString(boolean complete){
        return "ID: " + this.getUserID() + " Name: " + this.getUserName() + " Discipline: " + this.getDiscipline();
    }
}
