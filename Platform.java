package media;

public class Platform {
    private String name;
    private boolean isAvailable;

    public Platform(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public void displayPlatform() {
        System.out.println("Streaming Platform: " + name + 
            (isAvailable ? " (Available)" : " (Not Available)"));
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }
}
