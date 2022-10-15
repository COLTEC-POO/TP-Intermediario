/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

public class Sector {
    
    private static Integer qtdSector = 0;

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

    public static Integer getQtdSector(){
        return Sector.qtdSector;
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
    public void addNewSector(){
        Sector.qtdSector++;
    }


    public Sector(){
        
    }

    public Sector(String sectorName){
        setSectorID(getQtdSector() + 1);   
        setSectorName(sectorName);
        setTeacher(null);
        addNewSector();
    }

    public Sector(String sectorName, Teacher responsavel){
        setSectorID(getQtdSector() + 1);   
        setSectorName(sectorName);
        setTeacher(responsavel);
        addNewSector();
    }


    public String toString(boolean onlyname){
        return this.sectorName;
    }

    public String toString(){
        return "ID: " + this.sectorID + " Sector: " + this.sectorName + " Teacher Responsable: " + this.responsable.getUserName();
    }
}
