package media;
import review.*;

public class Movie extends Media implements RatingSystem {
    private int duration;
    private Platform platform;  // ✅ Composition

    public Movie(String title, String director, int releaseYear,
                 String[] genres, String country, String language,
                 double imdbRating, int duration, Platform platform) {
        super(title, director, releaseYear, genres, country, language, imdbRating);
        this.duration = duration;
        this.platform = platform;  // Platform object created inside and controlled by Movie
    }

    @Override
    public void displayDetails() {
        System.out.println("\n🎬 Movie Details:");
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year: " + releaseYear);
        System.out.println("Duration: " + duration + " mins");
        System.out.println("IMDb Rating: " + imdbRating);
        System.out.println("Genres: " + String.join(", ", genres));
        if (platform != null) {
            platform.displayPlatform();  // This should print correctly
        } else {
            System.out.println("Streaming Platform: Not Available");
        }
    }

    @Override
    public double calculateRating(Media media) {
        return getImdbRating();
    }

    // Optional detailed view method
    public void displayDetails(boolean showExtra) {
        displayDetails();
        if (showExtra) {
            System.out.println("Country: " + country);
            System.out.println("Language: " + language);
        }
    }
}
