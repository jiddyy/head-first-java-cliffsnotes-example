import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class GuestbookServerImpl extends UnicastRemoteObject implements GuestbookServer {
    private List<GuestbookEntry> entries;

    public List<GuestbookEntry> sign(String name, String message) {
        entries.add(new GuestbookEntry(name, message));
        return entries;
    }

    public List<GuestbookEntry> getEntries() {
        return entries;
    }

    public GuestbookServerImpl() throws RemoteException {
        entries = new ArrayList<GuestbookEntry>();
    }

    public static void main(String[] args) {
        try {
            GuestbookServer server = new GuestbookServerImpl();
            Naming.rebind("guestbook", server);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}