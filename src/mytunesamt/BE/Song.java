/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.BE;

/**
 *
 * @author kokus
 */
public class Song
{
    private String title;
    private String artist;
    private String category;
    private String location;
    private final int id;

    public Song(String title, String artist, String category, String location, int id)
    {
        this.title = title;
        this.artist = artist;
        this.category = category;
        this.location = location;
        this.id = id;
    }
    
    
    
    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getArtist()
    {
        return artist;
    }

    public void setArtist(String artist)
    {
        this.artist = artist;
    }

    public String getCategory()
    {
        return category;
    }

    public void setCategory(String category)
    {
        this.category = category;
    }

    public String getLocation()
    {
        return location;
    }

    public void setLocation(String location)
    {
        this.location = location;
    }
}
