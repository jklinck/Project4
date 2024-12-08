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
            
            /* check if user input is a number, if it is then continue into the if
            statement below
             */
            if(in.hasNextInt()){
                selection = in.nextInt();
                /*
                check if user input is valid (a number between 1-10), if it
                is then continue with the program
                 */
                if(selection >= 1 && selection <= 10){

                }
                /*
                if a user enters any other number than 1-10, then back up to the top of the loop
                to start again
                 */
                else{
                    System.out.println("Invalid option, please enter a number between 1-10.");
                }
            }
            // if a user enters something other than a number, start the loop over again
            else{
                System.out.println("Invalid option, please only choose a number.");
            }
        }



    } // end userSession()

    public static void testMethod(){
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
    }

    public static void main(String[] args){

//        userSession();
//        testMethod();


    } // end main()
}
