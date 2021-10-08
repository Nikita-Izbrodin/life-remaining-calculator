package com.company;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import java.time.LocalDate; // represents a date (year, month, day (yyyy-MM-dd))
import java.time.LocalTime; // represents a time (hour, minute, second & nanoseconds (HH-mm-ss-ns))
import java.time.LocalDateTime; // represents both a date & a time (yyyy-MM-dd-HH-mm-ss-ns)
import java.time.format.DateTimeFormatter; // formatting for displaying & parsing date-time objects

import java.util.Scanner; // used for user inputs

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in); // creates Scanner object

        DateTimeFormatter myFormat = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"); // creates format for displaying time

        LocalDateTime dateNow = LocalDateTime.now(); // "dateNow" is the date & time right now
        String formattedDate = dateNow.format(myFormat); // sets "dateNow" in "myFormat" format
        System.out.println("The date now is: " + formattedDate); // prints formatted date

        System.out.println("What year were you born in?");
        int userYear = input.nextInt(); // gets year from user

        System.out.println("What month were you born in?");
        int userMonth = input.nextInt(); // gets month from user

        System.out.println("What day were you born in?");
        int userDay = input.nextInt(); // gets day from user

        System.out.println("What hour were you born in? (put 0 if unsure)");
        int userHour = input.nextInt(); // gets hour from user

        System.out.println("What minute were you born in? (put 0 if unsure)");
        int userMin = input.nextInt(); // gets minute from user

        System.out.println("What second were you born in? (put 0 if unsure)");
        int userSec = input.nextInt(); // gets second from user

        LocalDateTime userBirth = LocalDateTime.of(userYear, userMonth, userDay, userHour, userMin, userSec); // puts integers from user input into date
        String formattedUserDate = userBirth.format(myFormat); // sets "userBirth" in "myFormat" format
        System.out.println("You were born in: " + formattedUserDate); // prints when user was born

        //
        // DIFFERENCE IN DATES STARTS HERE
        //

        // SimpleDateFormat converts the string format to date object
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

        // Try Block
        try {

            // parse method is used to parse the text from a string to produce the date
            Date d1 = sdf.parse(formattedUserDate);
            Date d2 = sdf.parse(formattedDate);

            // Calculate time difference in milliseconds
            long difference_In_Time = d2.getTime() - d1.getTime();

            // Calculate time difference in seconds, minutes, hours, years, and days
            long difference_In_Seconds = (difference_In_Time / 1000) % 60;

            long difference_In_Minutes = (difference_In_Time / (1000 * 60)) % 60;

            long difference_In_Hours = (difference_In_Time / (1000 * 60 * 60)+1) % 24;

            long difference_In_Years = (difference_In_Time / (1000L * 60 * 60 * 24 * 365));

            long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;

            // Print the date difference in years, in days, in hours, in minutes, and in seconds

            System.out.print("You have lived for: ");
            System.out.println(
                    difference_In_Years + " years, "
                    + difference_In_Days + " days, "
                    + difference_In_Hours + " hours, "
                    + difference_In_Minutes + " minutes, "
                    + difference_In_Seconds + " seconds");

            //
            // DIFFERENCE BETWEEN USER AND LIFE EXPECTANCY STARTS HERE
            //

            System.out.print("Based on average life expectancy, you have: ");
            System.out.print(
                    (81 - difference_In_Years) + " years, "
                    + difference_In_Days + " days, "
                    + difference_In_Hours + " hours, "
                    + difference_In_Minutes + " minutes, "
                    + difference_In_Seconds + " seconds");
            System.out.println(" left to live");
        }

        // Catch the Exception
        catch (ParseException e) {
            e.printStackTrace();

        }
    }
}