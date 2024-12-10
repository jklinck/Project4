import Profile.Profile;
import Profile.ProfileManager;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void sessionOptions(){
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
    }

    public static void userSession(){
        ProfileManager friendsList = new ProfileManager();
        ArrayList<Profile> friendsArray = friendsList.getFriendsArray();
        Scanner in = new Scanner(System.in);
        // use this so you can switch users
        Profile admin = null;
        Profile newProfile = null;
        Profile newFriend = null;
        boolean logout = false;
        int selection = 0;
        String name = "";
        int age = 0;

        sessionOptions();

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
                        newProfile = new Profile(name, age);
                        admin  = newProfile;
                        friendsList.addProfile(admin);
                        newProfile.displayProfile();
                    }
                    else if(selection == 2){
                        // view all profiles
                        friendsList.displayAllProfiles();
                    }
                    else if(selection == 3){
                        // add a friend
                        if(admin != null) {
                            System.out.printf("Please enter the name of the friend you would like to add: ");
                            name = in.next();
                            boolean userFound = false;
                            for(Profile user: friendsArray){
                                if(user.getName().equals(name)){
                                    admin.addFriend(user);
                                    user.addFriend(admin);
                                    userFound = true;
                                    break;
                                }
                            }
                            if(!userFound){
                                System.out.println("You cannot add that friend because that user is not in the group.");
                            }
                        }
                        else{
                            System.out.println("You must first create a profile before you can add friends.");
                        }
                    }
                    else if(selection == 4){
                        // view your friends list
                        if(admin != null) {
                            friendsList.displayMyFriends(admin);
                        }
                        else{
                            System.out.println("You must first create a profile before you can print your friends.");
                        }
                    }
                    else if(selection == 5){
                        // delete a profile
                        // need an exception if the profile doesn't exist
                        System.out.println("Enter the name of the user you would like to delete: ");
                        name = in.next();
                        boolean userFound = false;
                        for(Profile user: friendsArray){
                            if(user.getName().equals(name)){
                                friendsList.removeProfile(user);
                                userFound = true;
                                break;
                            }
                        }
                        if(!userFound){
                            System.out.println("You cannot delete that user because they are not in the group.");
                        }
                    }
                    else if(selection == 6){
                        // add another profile
                        System.out.println("To add another user to the group, please enter their name: ");
                        name = in.next();
                        System.out.println("Please enter their age: ");
                        Profile addProfile = new Profile(name, age);
                        friendsList.addProfile(addProfile);
                        /*
                        if user did not create a profile upon starting the session then
                        this will assign admin to the user being created in this step, I did
                        this because we need to have an admin in order to not hit the else statements
                        in some of the other selections
                         */
                        if(admin == null){
                            admin = addProfile;
                        }
                    }
                    else if(selection == 7){
                        // switch to a different user
                        System.out.println("Enter the name of the user you would like to login: ");
                        name = in.next();
                        boolean userFound = false;
                        for(Profile user: friendsArray){
                            if(user.getName().equals(name)){
                                admin = user;
                                userFound = true;
                                break;
                            }
                        }
                        if(!userFound){
                            System.out.println("You cannot switch to that user because they are not in the group.");
                        }

                    }
                    else if(selection == 8){
                        testMethod();
                    }
                    else if(selection == 9){
                        System.out.println("You have successfully logged out.");
                        if(admin != null) {
                            admin.setStatus();
                        }
                        logout = true;
                    }
                }
                /*
                if a user enters any other number than 1-9, then back up to the top of the loop
                to start again
                 */
                else{
                    System.out.println("Invalid option.");
                    sessionOptions();
                }
            }
            // if a user enters something other than a number, start the loop over again
            else{
                System.out.println("Invalid option, please only choose a number.");
                sessionOptions();
                // clear the input buffer
                in.next();
            }
        }
        // close scanner
        in.close();
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

        System.out.println("Here is a list of all profiles: ");
        friendsList.displayAllProfiles();

        System.out.println("Here is a list of John's friends: ");
        friendsList.displayMyFriends(John);
    }

    public static void main(String[] args){
        userSession();
    } // end main()
} // end Main class

/*

We met a number of times both in person and in multiple huddles
on slack.

Initially we created a text file (which we deleted) that outlined what we
needed to do to create the Profile and ProfileManager classes as well as ideas
of how to implement the methods in each.

From there Anthony completed the UML and all testing. Joe completed Profile,
ProfileManager and Main.

While we each had our individual responsibilities, we also each looked over
each others work and made suggestions. So nothing was 100% one person's responsibility.

We each found things that needed to be fixed in each other's work.

Both Anthony and I (Joe) agree that this was a mutual effort where we each completed
half of the work for the project.

 */

