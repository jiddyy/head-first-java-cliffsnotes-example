import java.io.Serializable;

public class GuestbookEntry implements Serializable {
    private String name;
    private String message;

    public GuestbookEntry(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getName() {
        return name;
    }
}