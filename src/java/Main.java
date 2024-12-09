import Profile.Profile;
import Profile.ProfileManager;
import java.util.Scanner;

public class Main {

    public static void userSession(){
        ProfileManager friendsList = new ProfileManager();
        Scanner in = new Scanner(System.in);
        // use this so you can switch users
        Profile admin;
        boolean logout = false;
        int selection = 0;
        String name = "";
        int age = 0;

        System.out.println("Please enter a selection from below: ");
        System.out.println("    1: Create your profile.");
        System.out.println("    2. View all profiles.");
        System.out.println("    3. Add a friend.");
        System.out.println("    4. View your friends list");
        System.out.println("    5. Delete a profile.");
        System.out.println("    6. Add another profile.");
        System.out.println("    7. Switch to a different user.");
        System.out.println("    8. Run testMethod.");
        System.out.println("    9. Logout of your session.");
        while(!logout){
            
            /* check if user input is a number, if it is then continue into the if
            statement below
             */
            if(in.hasNextInt()){
                selection = in.nextInt();
                /*
                check if user input is valid (a number between 1-9), if it
                is then continue with the program
                 */
                if(selection >= 1 && selection <= 9){
                    if(selection ==1){
                        // create profile
                        System.out.println("Please enter your name: ");
                        name = in.next();
                        System.out.println("Please enter your age: ");
                        age = in.nextInt();
                        Profile newProfile = new Profile(name, age);
                        admin  = newProfile;
                        /*
                        it's not possible in Java to dynamically use the users data they
                        entered to name an object, I wanted to not use newProfile above and use
                        the users name
                         */
                        friendsList.addProfile(newProfile);
                        newProfile.displayProfile();
                    }
                    else if(selection == 2){
                        // view all profiles
                        friendsList.displayAllProfiles();
                    }
                    else if(selection == 3){
                        // add a friend

                    }
                    else if(selection == 4){
                        // view your friends list
                        friendsList.displayMyFriends(admin);
                    }
                    else if(selection == 5){
                        // delete a profile
                        // need an exception if the profile doesn't exist
                        System.out.println("Enter the name of the user you would like to delete: ");
//                        name = in.next();
//                        friendsList.deleteUser(name);
                    }
                    else if(selection == 6){
                        // add another profile
                        System.out.println("To add another user to the group, please enter their name: ");
                        name = in.next();
                        System.out.println("Please enter their age: ");
                        Profile addFriend = new Profile(name, age);
                        friendsList.addProfile(admin);
                    }
                    else if(selection == 7){
                        // switch to a different user
                        System.out.println("Enter the name of the user you would like to login: ");
                        name = in.next();
                        /*
                        admin = (Profile)name;
                        this doesn't work, I need to somehow loop through all users and then assign
                        admin to that users, this doesn't work because name is a String and not a
                        Profile object
                         */
                    }
                    else if(selection == 8){
                        testMethod();
                    }
                    else if(selection == 9){
                        logout = true;
                    }
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
        friendsList.connectFriends(John, Steve);

//        friendsList.displayAllProfiles();

        friendsList.displayMyFriends(John);
    }

    public static void main(String[] args){

        userSession();
//        testMethod();


    } // end main()
}


/*

COMPLETED

UML
Profile.java
ProfileManager.java

TO BE COMPLETED
add javadoc comments to Profile.java (Joe)
add javadoc comments to ProfileManager.java (Joe)
userSession in Main.java (Joe)
Profile.java test (Anthony)
ProfileManager.java test (Anthony)

OPTIONAL
DirectedGraph test
UndirectedGraph test
Vertex test


meet Monday 3pm
meet Tuesday 1pm

 */
