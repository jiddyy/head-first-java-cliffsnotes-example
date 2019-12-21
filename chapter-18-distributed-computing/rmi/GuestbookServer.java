import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface GuestbookServer extends Remote {
    public List<GuestbookEntry> sign(String name, String message) throws RemoteException;

    public List<GuestbookEntry> getEntries() throws RemoteException;
}