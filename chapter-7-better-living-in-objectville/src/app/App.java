package app;

public class App {

    public class Rowboat extends Boat {
        public void rowTheBoat() {
            System.out.println("stroke natasha");
        }
    }

    public class Boat {
        private int length;

        public void setLength(int len) {
            length = len;
        }

        public int getLength() {
            return length;
        }

        public void move() {
            System.out.println("drift ");
        }
    }

    public class TestBoats {
        public void main(String[] args) throws Exception {
            Boat b1 = new Boat();
            Sailboat b2 = new Sailboat();
            Rowboat b3 = new Rowboat();
            b2.setLength(32);
            b1.move();
            b3.move();
            b2.move();
        }
    }

    public class Sailboat extends Boat {
        public void move() {
            System.out.println("hoist sail");
        }
    }
}