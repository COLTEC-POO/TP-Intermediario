import java.util.Date;

/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

public class BookingClass {
    
    private Teacher teacher;
    private Sector sector;
    private Date reservationStartDate;
    private Date reservationEndDate;

    //Getters
    public Teacher getTeacher(){
        return this.teacher;
    }
    public Sector getSector(){
        return this.sector;
    }
    public Date getReservationStartDate(){
        return this.reservationStartDate;
    }
    public Date getReservationEndDate(){
        return this.reservationEndDate;
    }
    /*
    public Date getDuration(){
        return this.reservationEndDate.getTime() - this.reservationStartDate;
    }
    */
    //Setters
    public void setTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public void setSector(Sector sector){
        this.sector = sector;
    }
    public void setReservationStartDate(Date reservationStartDate){
        this.reservationStartDate = reservationStartDate;
    }
    public void setReservationEndDate(Date reservationEndDate){
        this.reservationEndDate = reservationEndDate;
    }

    public BookingClass(User user, Sector sector, Date begin, Date end){
        setTeacher((Teacher) user);
        setSector(sector);
        setReservationStartDate(begin);
        setReservationEndDate(end);
    }

    public String toString(){
        return "";
    }
    
    public String getSchedule(){
        return "Teacher: " + this.teacher.toString(true) + " Sector: " + this.sector.toString(true) + " Reservation Date: " + this.reservationStartDate + " to " + this.reservationEndDate;
    }
}
