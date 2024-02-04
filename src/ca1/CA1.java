/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */// Link to github https://github.com/trayj23/CA1
package ca1;

import java.io.BufferedReader; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author jacktraynor
 */
public class CA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException { //menu/main method
        int option1 = 0; //user input variable declared
        while(option1 != 3) //loop until user enters the number 3 to quit the application
        {
        System.out.println("");
        System.out.println("***** Menu *****"); //user option information for menu
        System.out.println("Please select from the following: ");
        System.out.println("1. Export student.txt file to csv file");
        System.out.println("2. Add student information to student.txt file");
        System.out.println("3. Close Application");
        
        Scanner myObj = new Scanner(System.in);//allow user input using util.scanner
        
        String option = myObj.nextLine(); //user option input
        option1 = Integer.parseInt(option); //change user input variable to integer
        
        if(option1 == 1) //if statements for user options
        {
            outputCsv();//if option 1, calls to run csv output from txt file
        }
        else if(option1 == 2)
        {
            newStudent(); //calls to create new student info in txt file
        }
        else if(option1 == 3)
        {
            System.out.println("You have now exited the application");//goodbye message
        }
        else
        {
           System.out.println("input not recognised");//if any other input, unrecognise message
        }
        }
    }
    
    
    public static void newStudent() throws IOException //method to create new input from user and output to student.txt
    {
        try{
            Scanner myObj = new Scanner(System.in);//scanner to allow user input
            FileWriter fw = new FileWriter("students.txt"); //filewriter to write to specified.txt
            String specialChars = "[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?£]"; //special chars string for validation
        
            System.out.println("Please type first and last name of student."); //outputting to user what to input
            String studentFirst = myObj.nextLine(); //creating student name variable from user input
            System.out.println("Please type number of classes.");
            String classesNum = myObj.nextLine(); //number of classes from user input
            System.out.println("Please type last 2 digits of year, followed by degree and a random number between 1 and 200.");
            String studentNum = myObj.nextLine(); //student number from user input
            int countSpace = studentFirst.length() - studentFirst.replace(" ", "").length(); //beginning of validation for user inputs. creates an integer to count spaces within user input name
                if(countSpace > 1) //if statement for if input correct or not. if more than 1 space within string
                    {
                    System.out.println("Too many spaces in name. Space count is " +countSpace+ " when it should be 1."); //helpful message
                    }
                else if(countSpace < 1)  //if less than 1 space in string            
                    {
                    System.out.println("No space in count name. Please amend data to reflect a space between first and second name");//helpful message
                    }
                else if(countSpace == 1) //if correct, proceed
                    {
                    String[] splitName = studentFirst.trim().split("\\s+"); // split name into an array of first and last name           
                    boolean containsSpecial = splitName[1].matches(".*" +specialChars+ ".*"); //calling special chars string and checking to see if last name has special chars that should not be there, returns true or false
                    

                        if(splitName[0].matches("[a-zA-Z]+")){ //checking to see if first name has letters only.
                            if(containsSpecial)
                            {
                            System.out.println("Special characters detected in first name: " + splitName[1]);  //helpful message                         
                            }
                            else //if it only has letters proceed
                            {
                            int classesNum1 = Integer.parseInt(classesNum); //changed class string classesNum to int
                                if(classesNum1 > 0 && classesNum1 < 9)  //if number of classes are between 1-8, proceed
                                {
                                    if(studentNum.length() >= 6) //if total student number is greater than or equal to 6, proceed
                                    {
                                    String check1 = studentNum.substring(0, 2); //creating a new string with the first 2 characters in student number
                                    int check2 = Integer.parseInt(check1); //changing first to characters to integer as they are 2 numbers
                                        
                                        if(check2 >= 20) //validation for first 2 characters needs to be 20 or higher in student number. if higher, proceed
                                        {
                                        String check3 = studentNum.substring(2,5); //creating string for next 3 characters
                                        String check4 = studentNum.substring(2,4); //creating string for next 2 characters as 3rd 4th or 5th characters can be letters only
                                        boolean status = check3.matches("[a-zA-Z]+"); //checking to see if all characters, returns true or false as its a boolean
                                        boolean status1 = check4.matches("[a-zA-Z]+");
                                            
                                            if(status == false && status1 == false) //if not 3 letters or 2 letters
                                            {   
                                                System.out.println("issue with student number characters.");                                             
                                            }       
                                            else if(status == false && status1 == true) //if only first 2 characters, proceed as 2 characters and validate numbers next
                                            {
                                            String check5 = studentNum.substring(4,7); //string to check next 3 characters
                                            int check6 = Integer.parseInt(check5); //changing to int to prepare 1-200 validation check
                                                        
                                                if(check6 < 200 && check6 > 1) //if under 200 and over 1, proceed
                                                {         
                                                fw.append(studentFirst);//add student name to .txt
                                                fw.write("\n");//next row in .txt
                                                fw.append(classesNum); //add classes to .txt
                                                fw.write("\n");
                                                fw.append(studentNum); //add student number to .txt
                                                }
                                            }
                                            else//if 3 characters, proceed as 3 characters and validate numbers next
                                            {  
                                            String check7 = studentNum.substring(5,8);//string to check next 3 characters
                                            int check8 = Integer.parseInt(check7); //changing to int to prepare 1-200 validation check
                                            System.out.println(check8 + "check");
                                                
                                                if(check8 < 200 && check8 > 1)//if under 200 and over 1, proceed
                                                {          
                                                fw.append(studentFirst);//add student name to .txt
                                                fw.write("\n");//next row in .txt
                                                fw.append(classesNum); //add classes to .txt
                                                fw.write("\n");
                                                fw.append(studentNum); //add student number to .txt  
                                                System.out.println("Success! check .txt file");
                                                }
                                                else if(check2 < 20) //if year less than 20 in student number, helpful message
                                                {

                                                        System.out.println("Student year less than 20 on row"); //helpful message
                                                }
 
                                            }
                                        }
                                    }
                                }
                            } 
                        }                   
                    }
                   fw.close(); //   close writer 
                   
            }catch (IOException e)  //catch exception for try catch           
                {               
                System.out.println(e);
                }      
    }
    
      
    public static void outputCsv() //method to output .txt conversion to .csv with rearrangement of student information for out on csv
    {
       String[] array = getArray(); //create array of all rows within txt file
        int countTxt = getCount(); //get count of rows in .txt file
        int i = 0; //counter
        
        try{ //try catch for errors
            FileWriter fw = new FileWriter("students.csv"); //filewriter within method to write to csv
            
            while(i < countTxt) //while counter is less than counnt of rows in .txt file (continue)
            {
            String Name = array[i]; //getting name from first cell in array pulled from .txt. i counter used to pull from array
            i++;//add 1 to counter
            String numOfclasses = array[i]; //get number of classes from array
            i++; //add counter
            String yearCourse = array[i]; //get student number from array
            i++;  //add counter for following loop of while loop             
            String lastName; //declare string variable
            String note = (" - "); //declare string to concatenate once validation complete
            String nameAmend1; //declare string variable for concatenating later
            String finalOutput; //declare final string variable which is the complete first row for outputting to csv
            String workload = null; //declare classes string to output to csv
            String specialChars = "[!@#$%^&*()_+\\-=\\[\\]{};':\",.<>?£]"; // special char string for validation within method
                
            int number = Integer.parseInt(numOfclasses); //changing number of classes from string to integer
                
            int countSpace = Name.length() - Name.replace(" ", "").length(); //checking number of spaces within name as it should only be 1
                if(countSpace > 1) //if space in name greater than 1, helpful message
                {
                int x = i-2; //counter for helpful message
                System.out.println("Line " + x + ": " + Name);
                System.out.println("Too many spaces in name. Space count is " +countSpace+ " when it should be 1. Please amend text file");
                }
                else if(countSpace < 1) //if less than 1, helpful message       
                {
                System.out.println(Name);
                System.out.println("No space in count name. Please amend data to reflect a space within first and second name");
                }
                else if(countSpace == 1) //if correct, proceed with splitting first and second name
                {
                String[] splitName = Name.trim().split("\\s+"); //splitting name and removing spaces
                boolean containsSpecial = splitName[1].matches(".*" +specialChars+ ".*"); //checking for special characters in second name
                
                    if(splitName[0].matches("[a-zA-Z]+")){ //checking to ensure first name has only letters
                        if(containsSpecial) //if second name contained special characters, helpful message
                        {
                        int x = i-2; //counter for helpful message
                        System.out.println("Special characters detected in second name: " + splitName[1] + " on row: " + x + " in text file. Please amend.");                            
                        }
                        else //else proceed with validation
                        {
                        if(number > 0 && number < 9) //if classes between 1 and 8, proceed with validation
                        {
                            if(yearCourse.length() > 6) //if student number greater than 6 characters and less than 8, proceed with validation
                            {
                            String check1 = yearCourse.substring(0, 2); //pulling first 2 characters in student number to begin validation for 20 or higher
                            int check2 = Integer.parseInt(check1); //changing check1 from string to integer
                                        
                                if(check2 >= 20) //if first 2 characters 20 or above, proceed with validation and amending data
                                {
                                String check3 = yearCourse.substring(2,5);//check next 3 characters
                                String check4 = yearCourse.substring(2,4); //check next 2 characters as could be 2 or 3 letters after the year
                                boolean status = check3.matches("[a-zA-Z]+"); //boolean return true or false depending on if all letters or not
                                boolean status1 = check4.matches("[a-zA-Z]+"); //boolean return true or false depending on if all letters or not
                                            
                                    if(status == false && status1 == false) //if not all letters helpful message
                                    {   
                                        int x = i; //counter for helpful message to display correct row of error in .txt file
                                        System.out.println("issue with student number characters. only letters within the following on row: " +x);
                                    }       
                                    else if(status == false && status1 == true) //if 2 letters proceed with validation next 3 as numbers
                                    {
                                        if(yearCourse.length() > 7) //if student number length greater than 7, helpful message
                                        {
                                        System.out.println("Issue with student number");
                                        }
                                        else
                                        {
                                        String check5 = yearCourse.substring(4,7); //pulling next 3 characters from student number into new variable to validate less than 200
                                        int check6 = Integer.parseInt(check5); //changing from string to integer
                                                        
                                            if(check6 < 200 && check6 > 1) //if next 3 characters less than 200 and greater than 1, proceed with amendtments and output to csv.
                                            {
                                            lastName = splitName[1]; //last name variable pulling from split first and second name array
                                            nameAmend1 = lastName.concat(note);//adding last name and - to nameAmend1
                                            finalOutput = nameAmend1.concat(yearCourse); //adding name - and student number together into final output string

                                            if(number == 1) //if statement to decide what to call the number of classes the student has. if 1, proceed with 
                                            {
                                            workload = ("Very light");  
                                            }
                                            else if(number == 2) //if student has 2 classes, proceed with
                                            {
                                            workload = ("Light");
                                            }
                                            else if(number <= 5)
                                            {
                                            workload = ("Part Time");
                                            }
                                            else if(number >= 6)
                                            {
                                            workload = ("Full Time");
                                            }
                                            fw.write(finalOutput); //add new created string to csv file
                                            fw.write("\n"); //proceed to next row
                                            fw.write(workload); //add new classes string to .csv
                                            fw.write("\n"); //proceed to next row for next loop
                                        }
                                        }
                                    }
                                    else //if both checks are true, proceed with 3 next 3 characters and validate between 1-200
                                    {
                                        if(yearCourse.length() > 8) //if greater than 8, helpful message
                                        {
                                        System.out.println("Issue with Student name");
                                        }
                                        else
                                        {
                                        String check7 = yearCourse.substring(5,8);
                                         //pulling next 3 characters into separate variable
                                        int check8 = Integer.parseInt(check7); //changing 3 characters to an integer
                                                        
                                        if(check8 < 200 && check8 > 1) //if less than 200 and higher than 1, proceed with amendments
                                        {
                                        lastName = splitName[1]; //declaring last name into a new string
                                        nameAmend1 = lastName.concat(note); //adding last name and - together
                                        finalOutput = nameAmend1.concat(yearCourse); //adding nameAmend1 and student number together

                                            if(number == 1) //if statement for number of classes workload output
                                            {
                                            workload = ("Very light");  
                                            }
                                            else if(number == 2)
                                            {
                                            workload = ("Light");
                                            }
                                            else if(number <= 5)
                                            {
                                            workload = ("Part Time");
                                            }
                                            else if(number >= 6)
                                            {
                                            workload = ("Full Time");
                                            }
                                            fw.write(finalOutput); //add final output to .csv
                                            fw.write("\n"); //next row in csv
                                            fw.write(workload); //add workload to .csv
                                            fw.write("\n");} //next row for next loop
                                        }
                                        }
                                    }
                                    else if(check2 < 20) //else if number less than 20 in student number, (2020) helpful message 
                                    {
                                    int x = i-1;//row number referencing in output
                                    System.out.println("Student year less than 20 on row: " +x+ " in text file for student:" +Name);
                                    }
                            }
                            else//helpful message
                            {
                            int x = i-1;
                            System.out.println("Not enough characters in row:"+x);
                            }
                        }
                        else //helpful message
                        {
                        int x = i-1;
                        System.out.println("Number of classes in row:" +x+ " needs to be between 1 and 8 within text file. Please amend.");
                        }   
                    }
                    }
                    else //helpful message
                    {     
                    int x = i;
                    System.out.println("First name on row " +x+ " in text file has incorrect characters " +splitName[0]);
                    }
                }
            }
            fw.close(); //close writer
            }
            catch (IOException e)  //catch exception for try               
                {               
                System.out.println(e);    
                }           
    }
    
    
    public static String[] getArray(){ //create array method from students.txt file
    try { 
            BufferedReader br = new BufferedReader(new FileReader("students.txt")); //buffered reader to read students.txt
            List<String> list = new ArrayList<String>(); //creating a list to pull paste rows from students.txt
        
            String line = br.readLine(); //read line from students.txt variable
                
            while(line != null){ //while line is not empty, loop
                
                list.add(line); //adding row to list
                line = br.readLine(); //read next line
                
            }     
                br.close(); //close reader
                
                String[] array = list.toArray(new String[0]); //add list into newly created array
                return(array); //return array to output csv method
                }
                    catch (IOException e)                
                {               
                System.out.println(e);    
                }
    return (null);
                   
    }
    
    
    public static int getCount() //get count of rows method
    {
            try { 
            BufferedReader br = new BufferedReader(new FileReader("students.txt")); //read .txt file
            List<String> list = new ArrayList<String>(); //create list from info from .txt
        
            String line = br.readLine(); //read line variable
                
            while(line != null){ //while row not empty in .txt, loop
                
                list.add(line); //add row to list
                line = br.readLine(); //read next line  
                
            }     
                br.close(); //close reader
                int countTxt = list.size(); //count number of rows in list 
                return(countTxt); //return count
                }
                    catch (IOException e)                
                {               
                System.out.println(e);    
                }
        return 0;
    }
    
}
