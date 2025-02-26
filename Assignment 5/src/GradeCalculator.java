import java.util.HashMap;
import java.util.Scanner;

public class GradeCalculator{

    // Creates a hashmap for grades
    private HashMap<String, Integer>  grades = new HashMap<String, Integer>();;

    // Creates the keys and values for the grades hashmap
    public void intializesGrade(){
        grades.put("Outline", 100);
        grades.put("Quiz1", 10);
        grades.put("Quiz2", 10);
        grades.put("Quiz3", 8);
        grades.put("Quiz4", 8);
        grades.put("Quiz5", 12);
        grades.put("Assignment1", 30);
        grades.put("Assignment2", 30);
        grades.put("Assignment3", 30);
        grades.put("Assignment4", 24);
        grades.put("Assignment5", 18);
    }

    // Function to convert percentage to grade value
    public String getGradeValue(double percentage){
                    if(percentage >= 97){
                        return "A+";
                    }else if(percentage >= 94){
                        return "A";
                    }else if(percentage >= 90){
                        return "A-";
                    }else if(percentage >= 87){
                        return "B+";
                    }else if(percentage >= 84){
                        return "B";
                    }else if(percentage >= 80){
                        return "B-";
                    }else if(percentage >= 77){
                        return "C+";
                    }else if(percentage >= 74){
                        return "C";
                    }else if(percentage >= 70){
                        return "C-";
                    }else if(percentage >= 67){
                        return "D+";
                    }else if(percentage >= 64){
                        return "D";
                    }else if(percentage >= 60){
                        return "D-";
                    }else{
                        return "F";
                    }
        
            }
        
    // Method to calculate total points earned
    public int calcTotalPoints(){
        int total = 0;
        for(int points : grades.values()){
            total += points;
        }
        return total;
    }
    
    // Method to calculate overall grade percentage
    public double calculateOverallGrade(){
        double totalPoints = calcTotalPoints();
        double maxPoints = 100 + (5 * 10) + (3 * 30) + 24 + 18;
        return (totalPoints / maxPoints) * 100;
    }
    
    // Method to calculate the assignment average for every assignment
    public double getAssignmentAvg(){
        int totalAssignmentPoints = 0;
        int maxAssignmentPoints = 0;
        for(String key : grades.keySet()){
            if(key.startsWith("Assignment")){
                totalAssignmentPoints += grades.get(key);
                maxAssignmentPoints += 30;
                }
            }
        return (totalAssignmentPoints / (double) maxAssignmentPoints) * 100;
    }
                 
    // Method to calculate the quiz average
    public double getQuizAverage(){
        int totalQuizPoints = 0;
        int maxQuizPoints = 0; 
        for(String key : grades.keySet()){
            if(key.startsWith("Quiz")){
                totalQuizPoints += grades.get(key);
                maxQuizPoints += 10;
                }
            }
        return (totalQuizPoints / (double) maxQuizPoints) * 100;
    }
    
    // Main method to print out results
    public static void main(String[] args) throws Exception {
        GradeCalculator gradeCalc = new GradeCalculator();
        double quizAvg = gradeCalc.getQuizAverage();
        double assignmentAvg = gradeCalc.getAssignmentAvg();
        double overallGrade = gradeCalc.calculateOverallGrade();
        int totalPoints = gradeCalc.calcTotalPoints();
        
        System.out.printf("Quiz Average: %.2f%% --> %s%n", quizAvg, gradeCalc.getGradeValue(quizAvg));
        System.out.printf("Assignment Average: %.2f%% --> %s%n", assignmentAvg, gradeCalc.getGradeValue(assignmentAvg));
        System.out.printf("Total Points: %d pts%n", totalPoints);
        System.out.printf("Overall Grade: %.2f%% --> %s%n", overallGrade, gradeCalc.getGradeValue(overallGrade));

        // Extra Credit
        Scanner scan = new Scanner(System.in);
        try{
            System.out.print("Enter your percentage: ");
            double userPerc = scan.nextDouble();
            System.out.printf("Your grade: %.2f%% --> %s%n", userPerc, gradeCalc.getGradeValue(userPerc));
        } catch (Exception e){
            System.out.println("Invalid Percentage! Please enter a valid percentage you received!");
        }
        scan.close();
    }
}
