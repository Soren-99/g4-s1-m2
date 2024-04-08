package sorenrahimi.g4s1m2.Exceptions;

public class NotFoundException extends RuntimeException {
    public NotFoundException(long id){
        super("Item with id " + id + "not found");
    }
}
