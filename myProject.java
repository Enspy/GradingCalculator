import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;


class myProject {


public static void main(String[] args) {
    // Printing out program specifications for the user
        System.out.println("This program will receive up to 10 quiz scores from you.");
        System.out.println("You can enter grades until you reach 10, or quit the program by entering the number 999.");
        System.out.println( "After that, all the entered grades will be printed.");
        System.out.println("After the grades are printed, the program will calculate the average score.");
        System.out.println("The average score will then be converted to the corresponding letter grade.");
    // Initializing variables that will be used later on in the program
        double sum = 0;
        int count = 0;
        char letterGrade = 'F';
    // Initializing the Array List that will store the quiz scores. We use an Array List here for flexibility in size of the number of inputs.
        ArrayList<Double> grades = new ArrayList<>();
    
    // This while loop runs until the number of quiz scores entered reaches 10.
        while(grades.size()<10){
    // The Scanner class is used to create an object called scanner. This will be used to retrieve user input.
            Scanner scanner = new Scanner(System.in);
            double userInput;
            System.out.println("Please enter a quiz score [999 to quit]: ");
            
            

            try {
                // Assigns the variable userInput to the user input retrieved by the Scanner.nextDouble() method.
                userInput = scanner.nextDouble();
                // If input is not read due to the type, notifies the user with the following error message.
            } catch (InputMismatchException e) {
                System.out.println("ERROR: Input grades must be numeric!");
                continue;
            }
            // Ends the program if the user enters the value 999.
            if (userInput == 999){
                System.out.println("Ending program");
                break;
            }
            // Notifies the user if the value they entered does not fit the criteria.
            else if (userInput > 100){
                System.out.println("Scores can not be more than 100.");
            }
            else if (userInput < 0){
                System.out.println("Grades can't be negative.");
            }
            // Adds the quiz score to the Array List 'grades' and prints an update of the number of quizzes entered.
            else {
                grades.add(userInput);
                System.out.println("Succesfully added quiz # " + grades.size());
            }
        }

    
        // Using a for loop with 'grade' as the counter looping through the Array List 'grades'
        System.out.println(grades.size() + " grades collected. Printing received grades:");
        
        for (Double grade : grades){
            System.out.println(grade);
            sum += grade;
            count ++;
        }

        // Calculates the average score of all quizzes submitted
        double averageScore = (sum/count);

        // Uses if-else statements to determine the letter grade based on the average score calculated previously.
        if (averageScore >= 90){
            letterGrade ='A';
        }
        else if (averageScore >= 80){
            letterGrade = 'B';
        } 
        else if (averageScore >= 70){
            letterGrade = 'C';
        }
        else if (averageScore >= 60){
            letterGrade = 'D';
        }
        else if (averageScore >= 0){
            letterGrade = 'F';
        }
        System.out.println("The average score is " + averageScore);
        System.out.println("The average letter grade is " + letterGrade);
}

}

