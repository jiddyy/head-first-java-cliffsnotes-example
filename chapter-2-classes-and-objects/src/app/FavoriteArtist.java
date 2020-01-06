package app;

class FavoriteArtist {
    String name;
    String song;

    void info() {
        System.out.println("Your favorite song from " + name + " is " + song);
    }
}

class FavoriteArtistTestDrive {
    public static void main(String[] args) {
        FavoriteArtist artist = new FavoriteArtist();
        artist.name = "Post Malone";
        artist.song = "Goodbyes";
        artist.info();
    }
}