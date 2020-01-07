package app;

public class MyTable {
    String name;

    public static void main(String[] args) {
        MyTable partner1 = new MyTable();
        partner1.talk();
        partner1.name = "JD";

        MyTable[] myPartners = new MyTable[3];
        myPartners[0] = new MyTable();
        myPartners[1] = new MyTable();
        myPartners[2] = partner1;

        myPartners[0].name = "Destiny";
        myPartners[1].name = "Derek";

        System.out.print(myPartners[0] + " says goodmorning!");
        System.out.println(myPartners[1] + " says don't talk to me!");

        int x = 0;
        while (x < myPartners.length) {
            myPartners[x].talk();
            x = x + 1;
        }
    }

    public void talk() {
        System.out.println(name + " says goodmorning!");
    }
}