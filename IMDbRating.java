package review;

import media.Media;

public class IMDbRating implements RatingSystem {
    @Override
    public double calculateRating(Media media) {
        return media.getImdbRating();
    }
}
