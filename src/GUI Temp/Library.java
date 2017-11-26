import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Class: Library
 * @author Samuel Berende
 * @version 1.0
 * Course: ITEC 3150
 * Written: January 22, 2017
 * 
 * This class describes a Library used to contain the media items.
 * 
 * Purpose: To contain the methods and attributes needed to create a Library of Media class items, read them from a file, display them, and allow the user to search for or remove said items.
 */

public class Library
{
    // Create library data
    private ArrayList<Media> libraryItems = new ArrayList<Media>();

    /**
     * Method: printlibraryItems()
     * Displays the library items contained in the libraryItems ArrayList.
     * @param none
     * @return nothing
     */
    public void printlibraryItems()
    {
        for (int i = 0; i < libraryItems.size(); i++)
        {
            Media item = libraryItems.get(i);
            System.out.println(item);
        }
    }

    /**
     * Method: searchByName()
     * Cycles through the library for an item using its name, and returns the item if found.
     * @param name
     * @return item
     */
    public Media searchByName(String name)
    {
        Media item = null;
        for (Media temp : libraryItems)
        {
            if (temp.getName().equalsIgnoreCase(name) )
            {
                item = temp;
            }
        }
        return item;
    }

    /**
     * Method: getlibraryItems()
     * Returns a library item.
     * @param none
     * @return libraryItems
     */
    public ArrayList<Media> getlibraryItems()
    {
        return libraryItems;
    }

    /**
     * Method: addItem()
     * Adds an item to the library.
     * @param m
     * @return nothing
     */
    public void addItem(Media m)
    {
        libraryItems.add(m);
    }

    /**
     * Method: removeItem()
     * Removes an item from the library based upon it's name.
     * @param name
     * @return nothing
     */
    public void removeItem(String name)
    {
        Media item = this.searchByName(name);
        if (item != null)
        {
            libraryItems.remove(item);
        }
    }

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // Create library by reading in from media.txt
        Library myLibrary = new Library();

        // Open text file
        File mediaFile = new File("media.txt");
        // open a Scanner to read data from File
        Scanner mediaReader = null;
        try
        {
          mediaReader = new Scanner(mediaFile);
        } 
        catch (FileNotFoundException e)
        {
            System.out.println("No Library Media found- Library is empty");
        }

        // Read one item at a time
        while (mediaReader != null && mediaReader.hasNext())
        {
            String category = mediaReader.nextLine();
            String name = mediaReader.nextLine();
            String itemNumString = mediaReader.nextLine();
            int itemNum = Integer.parseInt(itemNumString);

            if (category.equalsIgnoreCase("Book"))
            {
                String temp0 = mediaReader.nextLine();
                boolean print = Boolean.parseBoolean(temp0);
                String temp1 = mediaReader.nextLine();
                boolean eBook = Boolean.parseBoolean(temp1);
                String temp2 = mediaReader.nextLine();
                boolean audioBook = Boolean.parseBoolean(temp2);
                String author = mediaReader.nextLine();
                String isbnString = mediaReader.nextLine();
				long ISBN = Long.parseLong(isbnString);
                
                Book b = new Book(category, name, itemNum, print, eBook, audioBook, author, ISBN);
                myLibrary.addItem(b);
            } 
            else if (category.equalsIgnoreCase("Music"))
            {
            	String temp0 = mediaReader.nextLine();
                boolean vinyl = Boolean.parseBoolean(temp0);
                String temp1 = mediaReader.nextLine();
                boolean digital = Boolean.parseBoolean(temp1);
                String temp2 = mediaReader.nextLine();
                boolean cassette = Boolean.parseBoolean(temp2);
                String temp3 = mediaReader.nextLine();
                boolean cD = Boolean.parseBoolean(temp3);
                String artist = mediaReader.nextLine();

                Music m = new Music(category, name, itemNum, vinyl, digital, cassette, cD, artist);
                myLibrary.addItem(m);
            } 
            else if (category.equalsIgnoreCase("Video"))
            {
            	String temp0 = mediaReader.nextLine();
                boolean standardDefinition = Boolean.parseBoolean(temp0);
                String temp1 = mediaReader.nextLine();
                boolean highDefinition = Boolean.parseBoolean(temp1);
                String temp2 = mediaReader.nextLine();
                boolean dVD = Boolean.parseBoolean(temp2);
                String temp3 = mediaReader.nextLine();
                boolean digital = Boolean.parseBoolean(temp3);
                String director = mediaReader.nextLine();
                String genre = mediaReader.nextLine();
                String rating = mediaReader.nextLine();
                
                Video v = new Video(category, name, itemNum, standardDefinition, highDefinition, dVD, digital, director, genre, rating);
                myLibrary.addItem(v);
            }
            else
            {
                System.out.println("Unknown Media type " + category);
            }
        }

        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to the Library");
        boolean done = false;
        while (!done)
        {
            System.out.println("Would you like to :");
            System.out.println("  1. View contents of Media List");
            System.out.println("  2. Search for a Media");
            System.out.println("  3. Remove a Media");
            System.out.println("  4.  Exit");
            String tp = input.nextLine();
            int userInput = Integer.parseInt(tp);
            if (userInput == 1)
            {
                myLibrary.printlibraryItems();
            } 
            else if (userInput == 2)
            {
                System.out.println("Please enter Media name");
                String  name = input.nextLine();
                Media item = myLibrary.searchByName(name);
                if (item != null)
                {
                    System.out.println(item);
                } 
                else
                {
                    System.out.println("Sorry- item not found");
                }
            }
            else if (userInput == 3)
            {
                System.out.println("Please enter Media name");
                String name = input.nextLine();
                myLibrary.removeItem(name);
            } 
            else
            {
                done = true;
                // Write out contents of Library back to original file
                PrintWriter output = null;
                // Open file for writing
                try
                {
                	output = new PrintWriter(new File("media.txt"));
                } 
                catch (FileNotFoundException e)
                {
                    e.printStackTrace();
                }

                // Write contents of each Library item to file
                for (Media m : myLibrary.getlibraryItems())
                {
                    // Write attributes common
                	output.println(m.getCatagory());
                	output.println(m.getName());
                	output.println(m.getItemNum());

                    if (m.getCatagory().equalsIgnoreCase("Book"))
                    {
                        Book b = (Book) m;
                        output.println(b.isPrint());
                        output.println(b.iseBook());
                        output.println(b.isAudioBook());
                        output.println(b.getAuthor());
                        output.println(b.getISBN());
                    } 
                    else if (m.getCatagory().equalsIgnoreCase("Music"))
                    {
                        Music c = (Music) m;
                        output.println(c.isVinyl());
                        output.println(c.isDigital());
                        output.println(c.isCassette());
                        output.println(c.isCD());
                        output.println(c.getArtist());
                    } 
                    else if (m.getCatagory().equalsIgnoreCase("Video"))
                    {
                        Video v = (Video) m;
                        output.println(v.isStandardDefinition());
                        output.println(v.isHighDefinition());
                        output.println(v.isDVD());
                        output.println(v.isDigital());
                        output.println(v.getDirector());
                        output.println(v.getGenre());
                        output.println(v.getRating());
                    } 
                    else
                    {
                        System.out.println("Unknown Media type " + m.getCatagory());
                    }
                }
                output.close();
            }
        }
    }
}
