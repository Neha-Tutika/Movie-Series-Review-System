package system;

import media.Media;
import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private List<Media> watchlist;
    
    public  String getUsername() { return username; }
    public  String getEmail() { return email; }
    
    public User(String username, String email) {
        this.username = username;
        this.email = email;
        this.watchlist = new ArrayList<>();
    }
    
    public void addToWatchlist(Media media) {
        if (watchlist.contains(media)) {
            throw new IllegalArgumentException("❌ " + media.getTitle() + " is already in your watchlist!");
        }
        watchlist.add(media);
        System.out.println(media.getTitle() + " added to your watchlist.");
    }

    
    public void displayWatchlist() {
        System.out.println("\n Watchlist:");
        watchlist.forEach(Media::displayDetails);
    }
    
   
}
