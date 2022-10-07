/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

public class Sector {
    
    private Integer sectorID;
    private String sectorName;
    private Teacher responsable;

    public Integer getSectorID(){
        return this.sectorID;
    }

    public String getSectorName(){
        return this.sectorName;
    }

    public Teacher getTeacher(){
        return this.responsable;
    }

    public void setSectorID(Integer sectorID){
        this.sectorID = sectorID;
    }
    public void setSectorName(String sectorName){
        this.sectorName = sectorName;
    }
    public void setTeacher(Teacher responsavel){
        this.responsable = responsavel;
    }



    public Sector(){
        
    }

    public Sector(Integer sectorID, String sectorName){
        setSectorID(sectorID);   
        setSectorName(sectorName);
        setTeacher(null);
    }

    public Sector(Integer sectorID, String sectorName, Teacher responsavel){
        setSectorID(sectorID);   
        setSectorName(sectorName);
        setTeacher(responsavel);
    }



    public String toString(){
        return "ID: " + this.sectorID + " Sector: " + this.sectorName + " Teacher Responsable: " + this.responsable.getUserName();
    }
}
