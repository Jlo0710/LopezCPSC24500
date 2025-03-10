import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

public class MovieRatingsManager {
    private ArrayList<String> movies = new ArrayList<>();
    private HashMap<String, ArrayList<Integer>> ratings = new HashMap<>();
    private Random rand = new Random();

    public static void main(String[] args){
        MovieRatingsManager manager = new MovieRatingsManager();
        Scanner scan = new Scanner(System.in);

        while(true){

            System.out.println("\n1. Add Movie");
            System.out.println("2. Add Rating");
            System.out.println("3. Generate Random Rating");
            System.out.println("4. Display Ratings");
            System.out.println("5. Exit");
            System.out.print("Choose an option");

            int userInput = scan.nextInt();
            scan.nextLine();

            if(userInput == 1){
                System.out.print("Enter the name of your movie: ");
                String movie = scan.nextLine();
                manager.addMovies(movie);
            }else if (userInput == 2){
                System.out.print("Enter the name of your movie: ");
                String movie = scan.nextLine();
                System.out.print("Enter rating (1-5): ");
                int rating = scan.nextInt();
                manager.addRating(movie, rating);
            }else if(userInput == 3){
                System.out.print("Enter the name of your movie: ");
                String movie = scan.nextLine();
                manager.generateRandomRate(movie);
            }else if(userInput == 4){
                manager.displayRatings();
            }else if(userInput == 5){
                System.out.println("Exiting.");
                break;
            }else{
                System.out.println("Invalid choice. Input a choice from the options again.");
            }
        }
        scan.close();
    }
    
    public void addMovies(String name){
        if(!movies.contains(name)){
            movies.add(name);
            ratings.put(name, new ArrayList<>());
            System.out.println("Movie added: " + name);
        }else{
            System.out.println("Movie already exists");
        }
    }

    public void addRating(String name, int rate){
        if(movies.contains(name)){
            if(rate >= 1 && rate <= 5){
                ratings.get(name).add(rate);
                System.out.println("Added rating " + rate + " to " + name);
            } else {
                System.out.println("Rating invalid. Must be between 1-5.");
            }
        } else {
            System.out.println("Movie not found. Add the movie before you rate.");
        }
    }

    public void generateRandomRate(String name){
        if(movies.contains(name)){
            int randRate = rand.nextInt(5) + 1;
            addRating(name, randRate);
            System.out.println("Random rating generated " + randRate+ " for" + name);
        }else{
            System.out.println("Movie isn't found. Add movie first before rating.");
        }
    }

    public void displayRatings(){
        System.out.println("\nMovie Ratings:");
        for(String movie : movies){
            ArrayList<Integer> movieRatings = ratings.get(movie);
            if(movieRatings.isEmpty()){
                System.out.println(movie + " hasn't been rated yet.");
            }else{
                double avg = 0;
                for(int rating : movieRatings){
                    avg += rating;
                }
                double sum = avg / movieRatings.size();
                System.out.println(movie + " - Average Rating: " + Math.round(avg * 10.0) / 10.0);
            }
        }
    }

}
