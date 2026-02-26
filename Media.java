package media;
// Base class for Movie and Series
public abstract class Media {
    protected String title;
    protected String director;
    protected int releaseYear;
    protected String[] genres;
    protected String country;
    protected String language;
    protected double imdbRating;
    
    public Media(String title, String director, int releaseYear, 
               String[] genres, String country, String language, 
               double imdbRating) {
        this.title = title;
        this.director = director;
        this.releaseYear = releaseYear;
        this.genres = genres;
        this.country = country;
        this.language = language;
        this.imdbRating = imdbRating;
    }
    
    public abstract void displayDetails(); 
   
    public String getTitle(){
    	return title; }
    public String getDirector() {
    	return director; }
    public int getReleaseYear() { 
    	return releaseYear; }
    public String[] getGenres() { 
    	return genres; }
    public String getCountry() { 
    	return country; }
    public String getLanguage() { 
    	return language; }
    public double getImdbRating() { 
    	return imdbRating; }
}
