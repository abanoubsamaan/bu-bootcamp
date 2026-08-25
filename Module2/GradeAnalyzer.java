import java.io.*; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
 
public class GradeAnalyzer {

    static int invalidLines = 0;
 
    public static void main(String[] args) {
        // Step 1: read scores from file
        ArrayList<Integer> scores = readScores("scores.txt");
        // Step 2: calculate statistics
        double avg = calculateAverage(scores);

        // find highest and lowest scores
        int highestScore = 0;
        int lowestScore = 100;

        if(scores.size() == 0) {
            lowestScore = 0;
        }

        for(int score : scores) {
            if(score > highestScore) {
                highestScore = score;
            }
            if(score < lowestScore) {
                lowestScore = score;
            }
        }
        // Step 3: write and print report
       writeReport(scores, avg, highestScore, lowestScore, "report.txt");
    } 
 
    // Returns a list of valid scores read from the file
    public static ArrayList<Integer> readScores(String filename) {
        ArrayList<Integer> scores = new ArrayList<Integer>();
        BufferedReader reader = null; 

        try {
            reader = new BufferedReader(new FileReader(filename));
        } catch (FileNotFoundException e) {
            System.out.println("File " + filename + " not found.");
        }

        String line = null;

        try {
            while((line = reader.readLine()) != null) {
                try {
                    line = line.trim(); // trim the spaces
                    int score = Integer.parseInt(line); // convert to int
                    scores.add(score); // add to the list
                } catch (NumberFormatException e) {
                    System.out.println("Invalid score found in the file: " + line);
                    invalidLines++;
                }
            }

        }  catch (IOException e) {
            System.out.println("Error reading scores from file.");
        } finally {
            try {
                reader.close();
            } catch (IOException e) {
                System.out.println("Error closing file.");
            }
        }


        return scores;
    }
 
    // Returns the average of a list of scores, or 0.0 if the list is empty
    public static double calculateAverage(ArrayList<Integer> scores) {
        if (scores.size() == 0) {
            return 0.0;
        }

        Double avg = 0.0;

        for (int i = 0; i < scores.size(); i++) {
            avg += scores.get(i);
        }
        
        avg = avg /scores.size();

        return avg;
    } 


    public static Map<String, Integer> countGrades(ArrayList<Integer> scores) {
        Map<String, Integer> grades = new HashMap<>();
        
        int countA = 0;
        int countB = 0;
        int countC = 0;
        int countD = 0;
        int countF = 0;

        for (int score : scores) {
            if (score >= 90) {
                countA++;
                continue;
            } else if (score >= 80) {
                countB++;
                continue;
            } else if (score >= 70) {
                countC++;
                continue;
            } else if (score >= 60) {
                countD++;
                continue;
            } else {
                countF++;
                continue;
            }
        }

        grades.put("A", countA);
        grades.put("B", countB);
        grades.put("C", countC);
        grades.put("D", countD);
        grades.put("F", countF);

        return grades;
    }

    // Writes and prints the report
    public static void writeReport(ArrayList<Integer> scores, double avg, int high, int low,String outputFile) {
        String title = "Grade Report";
        String separator = "=====================";
        String scoresProcessed = "Total scores processed: %d";
        String invalidLinesText = "Invalid lines skipped: %d";
        String averageScore = "Average score: %.2f";
        String highestScore = "Highest score: %d";
        String lowestScore = "Lowest score: %d";
        String smallSeparator = "------------";
        String distributionTitle = "Grades Distribution:";
        String gradeA = "A (90-100):   %d";
        String gradeB = "B (80-89):    %d";
        String gradeC = "C (70-79):    %d";
        String gradeD = "D (60-69):    %d";
        String gradeF = "F (below 60): %d";

        Map<String, Integer> grades = countGrades(scores);

        System.out.println(title);
        System.out.println(separator);

        System.out.println(String.format(scoresProcessed, scores.size()));
        System.out.println(String.format(invalidLinesText, invalidLines));
        System.out.println(String.format(averageScore, avg));
        System.out.println(String.format(highestScore, high));
        System.out.println(String.format(lowestScore, low));

        System.out.println(smallSeparator);

        System.out.println(distributionTitle);

        System.out.println(String.format(gradeA, grades.get("A")));
        System.out.println(String.format(gradeB, grades.get("B")));
        System.out.println(String.format(gradeC, grades.get("C")));
        System.out.println(String.format(gradeD, grades.get("D")));
        System.out.println(String.format(gradeF, grades.get("F")));
 
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            writer.write(title);
            writer.newLine();
            writer.write(separator);
            writer.newLine();

            writer.write(String.format(scoresProcessed, scores.size()));
            writer.newLine();

            writer.write(String.format(invalidLinesText, invalidLines));
            writer.newLine();

            writer.write(String.format(averageScore, avg));
            writer.newLine();

            writer.write(String.format(highestScore, high));
            writer.newLine();

            writer.write(String.format(lowestScore, low));
            writer.newLine();

            writer.write(smallSeparator);
            writer.newLine();

            writer.write(distributionTitle);
            writer.newLine();

            writer.write(String.format(gradeA, grades.get("A")));
            writer.newLine();

            writer.write(String.format(gradeB, grades.get("B")));
            writer.newLine();

            writer.write(String.format(gradeC, grades.get("C")));
            writer.newLine();

            writer.write(String.format(gradeD, grades.get("D")));
            writer.newLine();

            writer.write(String.format(gradeF, grades.get("F")));
            writer.newLine();

        } catch (IOException e) {
            System.out.println("Could not write file: " + e.getMessage());
        }
    }
} 
