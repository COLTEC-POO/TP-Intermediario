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

    public Teacher(String userName, Sector discipline){
        this.setUserID(User.getQtdUser() + 1);
        this.setUserName(userName);
        this.setDiscipline(discipline);
        this.addNewUser();
    }

    public String toString(Boolean onlyname){
        return this.getUserName();
    }

    public String toString(boolean complete){
        return "ID: " + this.getUserID() + " Name: " + this.getUserName() + " Discipline: " + this.getDiscipline();
    }

    public boolean equals(Object obj){
        if(obj instanceof Teacher){
            Teacher temp = (Teacher) obj;
            if(temp.getUserName() == this.getUserName() && temp.getDiscipline() == this.getDiscipline())
                return true;
        }
        return false;
    }
}
