import java.io.PrintStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Scanner;

class GuestbookClient {
    private GuestbookServer server;
    private Scanner in;
    private PrintStream out;

    public GuestbookClient(GuestbookServer server, Scanner in, PrintStream out) {
        this.server = server;
        this.in = in;
        this.out = out;
    }

    public void go() throws RemoteException {
        while (true) {
            out.print("[s]ign, [r]ead, or [q]uit: ");
            switch (in.nextLine().toLowerCase()) {
            case "s":
                sign();
                break;
            case "r":
                read();
                break;
            case "q":
                return;
            default:
                out.println("Invalid Input");
                break;
            }
        }
    }

    public static void main(String[] args) {
        try {
            GuestbookServer server = (GuestbookServer) Naming.lookup("rmi://localhost/guestbook");
            Scanner in = new Scanner(System.in);
            new GuestbookClient(server, in, System.out).go();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void sign() throws RemoteException {
        out.print("Name: ");
        String name = in.nextLine();
        out.print("Message: ");
        String message = in.nextLine();
        server.sign(name, message);
    }

    private void read() throws RemoteException {
        for (GuestbookEntry entry : server.getEntries()) {
            out.println("Name: " + entry.getName());
            out.println("Message: " + entry.getMessage());
        }
    }
}