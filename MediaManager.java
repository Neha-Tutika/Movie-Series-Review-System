package system;
import media.*;
import review.Review;
import java.util.*;
public class MediaManager {
    private List<Media> library;
    private List<Review> reviews;
    private List<Platform> platforms;
    public MediaManager() {
        this.library = new ArrayList<>();
        this.reviews = new ArrayList<>();
        this.platforms = new ArrayList<>();
        initializeSampleData();
    }
    private void initializeSampleData() {
        Platform netflix = new Platform("Netflix", true);
        Platform prime = new Platform("Amazon Prime", true);
        platforms.add(netflix);
        platforms.add(prime);
            // composition
            library.add(new Movie("Inception", "Christopher Nolan", 2010,
                    new String[]{"Sci-Fi", "Action"}, "USA", "English", 8.8, 148, new Platform("Netflix", true)));
            library.add(new Movie("Parasite", "Bong Joon-ho", 2019,
                    new String[]{"Thriller", "Drama"}, "South Korea", "Korean", 8.6, 132, new Platform("Prime Video", true)));
            library.add(new Movie("Roma", "Alfonso Cuarón", 2018,
                    new String[]{"Drama"}, "Mexico", "Spanish", 7.8, 135, new Platform("Netflix", false)));
            library.add(new Movie("3 Idiots", "Rajkumar Hirani", 2009,
                    new String[]{"Comedy", "Drama"}, "India", "Hindi", 8.4, 170, new Platform("Netflix", true)));

            library.add(new Movie("Dangal", "Nitesh Tiwari", 2016,
            	    new String[]{"Drama", "Biography"}, "India", "Hindi", 8.4, 161,
            	    new Platform("Disney+ Hotstar", true)));
      
            library.add(new Movie("Sita Ramam", "Hanu Raghavapudi", 2022,
                    new String[]{"Romance", "Drama"}, "India", "Telugu", 8.6, 163, new Platform("Amazon Prime Video", true)));
            library.add(new Series("Stranger Things", "The Duffer Brothers", 2016,
                    new String[]{"Sci-Fi", "Horror"}, "USA", "English", 8.7, 4, 34, new Platform("Netflix", true)));
            library.add(new Series("Money Heist", "Álex Pina", 2017,
                    new String[]{"Crime", "Drama"}, "Spain", "Spanish", 8.2, 5, 41, new Platform("Netflix", true)));
        

    }

  
    public List<Media> getLibrary() {
        return library;
    }

    public void getTrending() {
        if (library.isEmpty()) {
            System.out.println("⚠️ No media in the library to display trending!");
            return;
        }
        System.out.println("\n Trending Media:");
        library.stream()
            .sorted((m1, m2) -> Double.compare(m2.getImdbRating(), m1.getImdbRating()))
            .limit(3)
            .forEach(m -> {
                if (m instanceof Movie) {
                    ((Movie) m).displayDetails(true);
                } else if (m instanceof Series) {
                    ((Series) m).displayDetails(true);
                } else {
                    m.displayDetails(); // fallback
                }
            });
    }

   
    public void filterByCountry(String country) {
        boolean found = false;
        System.out.println("\n Media from Country: " + country);
        for (Media m : library) {
            if (m.getCountry().equalsIgnoreCase(country)) {
            	if (m instanceof Movie) {
            	    ((Movie) m).displayDetails(true);
            	} else if (m instanceof Series) {
            	    ((Series) m).displayDetails(true);
            	} else {
            	    m.displayDetails(); // fallback
            	}
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No content found from country: " + country);
        }
    }

   
    public void filterByLanguage(String language) {
        boolean found = false;
        System.out.println("\n Media in Language: " + language);
        for (Media m : library) {
            if (m.getLanguage().equalsIgnoreCase(language)) {
                m.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No movies or series found in the language: " + language);
        }
    }


  
    public void filterByDirector(String director) {
        boolean found = false;
        System.out.println("\n Media directed by: " + director);
        for (Media m : library) {
            if (m.getDirector().equalsIgnoreCase(director)) {
                m.displayDetails();
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No movies or series found for director: " + director);
        }
    }

  
    public void addReview(Review review) {
        for (Review r : reviews) {
            if (r.getUser().getUsername().equalsIgnoreCase(review.getUser().getUsername())
                && r.getMedia().getTitle().equalsIgnoreCase(review.getMedia().getTitle())) {
                throw new IllegalArgumentException(" You have already reviewed " + review.getMedia().getTitle());
            }
        }
        reviews.add(review);
        System.out.println(" Review added for " + review.getMedia().getTitle());
    }

   
    public void showReviewsForMedia(String title) {
        System.out.println("\n Reviews for " + title + ":");
        boolean found = false;
        for (Review r : reviews) {
            if (r.getMedia().getTitle().equalsIgnoreCase(title)) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) {
            System.out.println(" No reviews found for " + title + ".");
        }
    }


    public void filterByGenre(String genre) {
        boolean found = false;
        System.out.println("\n Filtering by Genre: " + genre);
        for (Media m : library) {
            for (String g : m.getGenres()) {
                if (g.equalsIgnoreCase(genre)) {
                	if (m instanceof Movie) {
                	    ((Movie) m).displayDetails(true);
                	} else if (m instanceof Series) {
                	    ((Series) m).displayDetails(true);
                	} else {
                	    m.displayDetails(); 
                	}
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            System.out.println(" No content found for genre: " + genre);
        }
    }

    public Media findMediaByTitle(String title) {
        for (Media m : library) {
            if (m.getTitle().equalsIgnoreCase(title)) {
                return m;
            }
        }
        return null;
    }
    public void showReviewsByUser(User user) {
        boolean found = false;
        for (Review review : reviews) {
            if (review.getUser().getUsername().equalsIgnoreCase(user.getUsername())) {
                System.out.println("Media: " + review.getMedia().getTitle());
                System.out.println("Rating: " + review.getRating());
                System.out.println("Comment: " + review.getComment());
                System.out.println("----------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No reviews found for user: " + user.getUsername());
        }
    }


}
