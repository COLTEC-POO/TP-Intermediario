/**
 * Operacao.java
 *
 * @author Raphael Ananias Cornelio de Menezes
 * 
 */

 public class LaboratoryClass extends Classrooms{
    

    public LaboratoryClass(Integer number, Integer capacity){
        setNumber(number);
        setCapacity(capacity);
        setType("laboratory");
        setNewBookings();
    }
}
