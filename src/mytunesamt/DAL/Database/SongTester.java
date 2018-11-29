/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.DAL.Database;

import java.util.Scanner;
import java.io.*;
/**
 *
 * @author Asvør
 */
public class SongTester
{
    public static void main (String[] args) throws FileNotFoundException
    {
        
        
        
        try
        {
            FileReader inputFile = new FileReader("C:\\Users\\Asvør\\Desktop\\Skúla\\Github\\MyTunesAMT\\Sangtest.txt");
            try
            {
                Scanner parser = new Scanner(inputFile);
                while (parser.hasNextLine())
                {
                    String line = parser.nextLine();
                    String[] songs = line.split(",");
                }
            }
            finally
            {
                inputFile.close();
            }
        }
            catch(IOException e)
                    {
                        e.printStackTrace();
                    }
        }
    }

