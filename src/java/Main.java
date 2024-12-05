import Profile.Profile;
import Profile.ProfileManager;
import ADTPackage.LinkedListWithIterator;

public class Main {
    public static void main(String[] args){
        ProfileManager friendsList = new ProfileManager();
        Profile John = new Profile("John", 30);
        Profile Amy = new Profile("Amy", 25);

        Profile Alex = new Profile("Alex", 21);
        Profile Steve = new Profile("Steve", 24);

        friendsList.addProfile(John);
        friendsList.addProfile(Amy);
        friendsList.addProfile(Alex);
        friendsList.connectFriends(John, Amy);
        John.addFriend(Amy);
        Amy.addFriend(John);
        friendsList.addProfile(Steve);

        friendsList.displayAllProfiles();



    }
}
