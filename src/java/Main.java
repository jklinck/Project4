import Profile.*;

public class Main {
    public static void main(String[] args){
        ProfileManager friendsList = new ProfileManager();
        Profile Joe = new Profile("Joe", 48);

        Joe.displayProfile();
        friendsList.addProfile(Joe);

    }
}
