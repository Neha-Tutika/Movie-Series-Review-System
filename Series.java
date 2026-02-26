package media;
import review.*;

public class Series extends Media implements RatingSystem {
    private int seasons;
    private int episodes;
    private Platform platform; // Composition

    public Series(String title, String director, int releaseYear, 
                  String[] genres, String country, String language, 
                  double imdbRating, int seasons, int episodes,
                  Platform platform) {
        super(title, director, releaseYear, genres, country, language, imdbRating);
        this.seasons = seasons;
        this.episodes = episodes;
        this.platform = platform;
    }

    @Override
    public void displayDetails() {
        System.out.println("\n Series Details:");
        System.out.println("Title: " + title);
        System.out.println("Director: " + director);
        System.out.println("Year: " + releaseYear);
        System.out.println("Seasons: " + seasons);
        System.out.println("Episodes: " + episodes);
        System.out.println("IMDb Rating: " + imdbRating);
        System.out.println("Genres: " + String.join(", ", genres));
        platform.displayPlatform(); // ✅ Composition usage
    }

    @Override
    public double calculateRating(Media media) {
        return getImdbRating();
    }

    public void displayDetails(boolean showExtra) {
        displayDetails();
        if (showExtra) {
            System.out.println("Country: " + country);
            System.out.println("Language: " + language);
        }
    }
}
