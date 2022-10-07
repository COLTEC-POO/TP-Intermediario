import java.sql.Date;

/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

public abstract class Classrooms {

    private static Integer maxReservations = 20;

    private Integer number;
    private Integer capacity;
    private String type;
    private BookingClass[] reservation = new BookingClass[maxReservations];

    public Classrooms(){

    }

    //Getters
    public Integer getNumber(){
        return this.number;
    }
    public Integer getCapacity(){
        return this.capacity;
    }
    public String getType(){
        return this.type;
    }
    public String getReservation(){
        return this.reservation.toString();
    }

    //Setters
    public void setNumber(Integer number){
        this.number = number;
    }
    public void setCapacity(Integer capacity){
        this.capacity = capacity;
    }
    public void setType(String type){
        this.type = type;
    }

    public void ShowMadeReservations(){
        System.out.println("Reservations for class: " + this.number);
        for (BookingClass bookingClass : reservation) {
            if(bookingClass.getTeacher() != null)
                bookingClass.toString();
        }
    }

    public void ShowAllReservations(){
        System.out.println("Reservations for class: " + this.number);
        for (BookingClass bookingClass : reservation) {
            bookingClass.toString();
        }
    }

    public void ShowClearReservations(){
        System.out.println("Reservations for class: " + this.number);
        for (BookingClass bookingClass : reservation) {
            if(bookingClass.getTeacher() != null)
                bookingClass.toString();
        }
    }

    public boolean CanReserve(User user){
        if(user instanceof Teacher)
            return true;
        return false;
    }

    public void MakeReservation(Teacher teacher, Sector sector, Date begin, Date end){
        for (BookingClass bookingClass : reservation) {
            if(bookingClass.getTeacher() == null){
                bookingClass = new BookingClass(teacher, sector, begin, end);
                break;
            }
        }
    }

    public void TakeReservation(Teacher teacher, Sector sector, Date begin, Date end){
        for (BookingClass bookingClass : reservation) {
            if(bookingClass.getTeacher() == teacher && bookingClass.getSector() == sector &&
               bookingClass.getReservationStartDate() == begin && bookingClass.getReservationEndDate() == end){
                bookingClass.setTeacher(null);
                bookingClass.setSector(null);
                bookingClass.setReservationStartDate(null);
                bookingClass.setReservationEndDate(null);
            }
        }
    }

    public void ClearAllBooking(){
        for (BookingClass bookingClass : reservation) {
            bookingClass.setTeacher(null);
            bookingClass.setSector(null);
            bookingClass.setReservationStartDate(null);
            bookingClass.setReservationEndDate(null);
        }
    }

    public Integer CountFreeReservation(){
        Integer free = 0;
        for (BookingClass bookingClass : reservation) {
            if(bookingClass.getTeacher() == null)
                free++;
        }
        return free;
    }

    public Boolean CanReserveClass(){
        return (this.CountFreeReservation() < 20) ? true : false;
    }
}

