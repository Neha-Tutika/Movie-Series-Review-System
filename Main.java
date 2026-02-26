package system;
import media.*;
import review.Review;
import java.util.*;
import java.util.regex.*;
public class Main {
    public static boolean isValidEmail(String email) {
        return email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");
    }
    public static void main(String[] args) {
    	
        Scanner scanner = new Scanner(System.in);
        MediaManager manager = new MediaManager();
        Map<String, User> userMap = new HashMap<>();
        System.out.print(" Enter your username(can be numbers or letters): ");
        String username = scanner.nextLine();
        User currentUser;
        if (userMap.containsKey(username)) {
            currentUser = userMap.get(username);
        } else {
            String email;
            while (true) {
                System.out.print(" Enter your email: ");
                email = scanner.nextLine();
                if (isValidEmail(email)) break;
                System.out.println("❌ Invalid email format! Try again (e.g., user@example.com)");
            }
            currentUser = new User(username, email);
            userMap.put(username, currentUser);
        }

        System.out.println("\nWelcome to the Movie & Series Review System!");
        while (true) {
            System.out.println("\n** Menu Options **");
            System.out.println("1️  Fetch Trending Movies & Series");
            System.out.println("2️  Filter by Country");
            System.out.println("3️  Filter by Language");
            System.out.println("4️  Search by Director");
            System.out.println("5️  Filter by Genre");
            System.out.println("6️  Add to Watchlist");
            System.out.println("7️  Add a Review");
            System.out.println("8️  View Reviews of a Media");
            System.out.println("9️  Switch User");
            System.out.println("10  View All Users and Their Reviews");
            System.out.println("0️  Exit");
            System.out.print("\nEnter your choice (0-10): ");
            int choice;
            while (true) {
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();
                    if (choice >= 0 && choice <= 10) break;
                }
                System.out.print("❗Invalid input! Enter a number between 0-10: ");
                scanner.nextLine();
            }
            scanner.nextLine(); 
            switch (choice) {
                case 1:
                    manager.getTrending();
                    break;
                case 2:
                	String country;
                	while (true) {
                	    System.out.print("\n Enter country to search movies & series: ");
                	    country = scanner.nextLine().trim();
                	    if (country.isEmpty() ||  country.matches("\\d+")) {
                	        System.out.println(" Invalid input! country cannot be empty or numeric.");
                	    } else {
                	        break;
                	    }
                	}
                	manager.filterByCountry(country);
                         break;
                case 3:
                	String language;
                	while (true) {
                	    System.out.print("\n Enter language to search movies & series: ");
                	    language = scanner.nextLine().trim();
                	    if (language.isEmpty() ||  language.matches("\\d+")) {
                	        System.out.println("Invalid input! language cannot be empty or numeric.");
                	    } else {
                	        break;
                	    }
                	}
                
                	manager.filterByLanguage(language);
                         break;
                case 4:
                	String director;
                	while (true) {
                	    System.out.print("\n Enter director name to search movies & series: ");
                	    director = scanner.nextLine().trim();
                	    if (director.isEmpty() || director.matches("\\d+")) {
                	        System.out.println(" Invalid input! Director name cannot be empty or numeric.");
                	    } else {
                	        break;
                	    }
                	}
                	
                	manager.filterByDirector(director);
                         break;
                case 5:
                	String genre;
                	while (true) {
                	    System.out.print("\n🎭 Enter genre to filter movies & series: ");
                	    genre = scanner.nextLine().trim();
                	    if (genre.isEmpty() || genre.matches("\\d+")) {
                	        System.out.println("❌ Invalid input! Genre cannot be empty or numeric.");
                	    } else {
                	        break;
                	    }
                	}
                	manager.filterByGenre(genre);
                	break;

                case 6:
                    System.out.print("Enter title to add to watchlist: ");
                    Media mediaToAdd = manager.findMediaByTitle(scanner.nextLine());
                    if (mediaToAdd != null) {
                        currentUser.addToWatchlist(mediaToAdd);
                        System.out.println(" Added to watchlist!");
                        currentUser.displayWatchlist();
                    } else {
                        System.out.println("No media found!");
                    }
                    break;
                case 7:
                    System.out.print("Enter title to review: ");
                    Media mediaToReview = manager.findMediaByTitle(scanner.nextLine());
                    if (mediaToReview != null) {
                        int rating = 0;
                        boolean valid = false;
                        while (!valid) {
                            System.out.print("Enter rating (1-5): ");
                            try {
                                rating = scanner.nextInt();
                                scanner.nextLine(); 
                                if (rating >= 1 && rating <= 5) valid = true;
                                else System.out.println(" Rating must be between 1 and 5.");
                            } catch (InputMismatchException e) {
                                System.out.println("Invalid input! Enter a number.");
                                scanner.nextLine();
                            }
                        }
                        System.out.print("Enter your comment: ");
                        String comment = scanner.nextLine();
                        try {
                            manager.addReview(new Review(currentUser, mediaToReview, rating, comment));
                            System.out.println(" Review added successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 8:
                    System.out.print("Enter title to view reviews: ");
                    manager.showReviewsForMedia(scanner.nextLine());
                    break;
                case 9:
                    System.out.print("Enter new username: ");
                    String newUsername = scanner.nextLine();
                    if (userMap.containsKey(newUsername)) {
                        currentUser = userMap.get(newUsername);
                        System.out.println("Switched to existing user: " + newUsername);
                    } else {
                        String newEmail;
                        while (true) {
                            System.out.print(" Enter email for new user: ");
                            newEmail = scanner.nextLine();
                            if (isValidEmail(newEmail)) break;
                            System.out.println("Invalid email format! Try again.");
                        }
                        currentUser = new User(newUsername, newEmail);
                        userMap.put(newUsername, currentUser);
                        System.out.println("New user created and logged in.");
                    }
                    break;
                case 10:
                    System.out.println("\n All Users and Their reviews:");
                    for (User user : userMap.values()) {
                        System.out.println("\n User: " + user.getUsername());
                        System.out.println("Email: " + user.getEmail());
                        System.out.println("Reviews:");
                        manager.showReviewsByUser(user);
                    }
                    break;
                case 0:
                    System.out.println("Exiting... Have a great day!");
                    scanner.close();
                    return;
            }
        }
    }
}
