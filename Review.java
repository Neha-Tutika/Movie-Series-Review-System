package review;

import media.Media;
import system.User;

public class Review {
    private User user;
    private Media media;
    private int rating;
    private String comment;

    public Review(User user, Media media, int rating, String comment) {
        this.user = user;
        this.media = media;
        setRating(rating);
        if (comment == null || comment.trim().isEmpty()) {
            throw new IllegalArgumentException(" Review comment cannot be empty!");
        }
        this.comment = comment;
    }


    public void setRating(int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5");
        }
        this.rating = rating;
    }

    public Media getMedia() { return media; }
    public User getUser() { return user; }
    public int getRating() { return rating; }
    public String getComment() { return comment; }

    @Override
    public String toString() {
        return user.getUsername() + " rated " + media.getTitle() +
               " " + rating + "/5: " + comment;
    }
}
