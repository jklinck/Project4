import Profile.Profile;
import Profile.ProfileManager;
import ADTPackage.LinkedListWithIterator;
import java.util.Scanner;

public class Main {

    public static void userSession(){
        Scanner in = new Scanner(System.in);
        boolean logout = false;
        int selection = 0;

        while(!logout){
            ProfileManager friendsList = new ProfileManager();
            System.out.println();
            logout = true;
        }



    } // end userSession()

    public static void main(String[] args){

//        userSession();
        ProfileManager friendsList = new ProfileManager();
        Profile John = new Profile("John", 30);
        Profile Amy = new Profile("Amy", 25);

        Profile Alex = new Profile("Alex", 21);
        Profile Steve = new Profile("Steve", 27);

        friendsList.addProfile(John);
        friendsList.addProfile(Amy);
        friendsList.addProfile(Alex);
        friendsList.addProfile(Steve);

        friendsList.connectFriends(John, Amy);
        friendsList.connectFriends(John, Alex);

        friendsList.displayAllProfiles();

    } // end main()
}
