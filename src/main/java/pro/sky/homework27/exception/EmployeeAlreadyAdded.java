package pro.sky.homework27.exception;

public class EmployeeAlreadyAdded extends RuntimeException{
    public EmployeeAlreadyAdded(String message) {
        super(message);
    }

}
