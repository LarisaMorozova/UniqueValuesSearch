/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package duplicates;

import java.io.*;
import java.util.*;

/**
 *
 * @author Larisa Morozova
 * 
 * Compares the provided two files containing strings on separate lines
 * Checks for duplicate values in both of them
 * And leave unique values in file with more lines.
 * If both files contain the same numbers of lines it's prints unique values
 * for second file. 
 */
public class Duplicates {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        List<String> firstList = new ArrayList<>();
        List<String> secondList = new ArrayList<>();
        
        //Prompt user for first file input
        Scanner firstScanner = new Scanner(System.in);
        System.out.print("Enter a first file name: ");
        System.out.flush();
        String firstFilename = firstScanner.nextLine();
        File firstFile = new File(firstFilename);
        
        //Prompt user for second file input
        Scanner secondScanner = new Scanner(System.in);
        System.out.print("Enter a second file name: ");
        System.out.flush();
        String secondFilename = secondScanner.nextLine();
        File secondFile = new File(secondFilename);

        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(secondFile));
            String line;
            while ((line = br.readLine()) != null) {
                secondList.add(line);
            }
        } catch (Exception ex) {
        } finally {
            br.close();
        }
        System.out.println("Rows in the " + secondFile.getName() + " File: " + secondList.size());

        try {
            br = new BufferedReader(new FileReader(firstFile));
            String line;
            while ((line = br.readLine()) != null) {
                firstList.add(line);
            }
        } catch (Exception ex) {
        } finally {
            br.close();
        }
        System.out.println("Rows in the " + firstFile.getName() + " File: " + firstList.size());
        
        if (firstList.size() > secondList.size()) {
            for (String s : secondList) {
                if (firstList.contains(s)) {
                    firstList.remove(s);
                }
            }

            if (firstList.size() > 0) {
                for (String ngkKey : firstList) {
                    System.out.println(firstFile.getName() + " contains following unique values:");
                    System.out.println(ngkKey);
                }
            } else {
                System.out.println("Nothing to print");
            }
        } else {
            for (String s : firstList) {
                if (secondList.contains(s)) {
                    secondList.remove(s);
                }
            }

            if (secondList.size() > 0) {
                for (String ngkKey : secondList) {
                    System.out.println(secondFile.getName() + " contains following unique values:");
                    System.out.println(ngkKey);
                }
            } else {
                System.out.println("Nothing to print");
            }
        }
    }
}
