/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytunesamt.DAL.Database;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import mytunesamt.BE.Playlist;
import mytunesamt.BE.Song;

public class PlaylistDbDao
{

    DbConnectionProvider ds;

    public PlaylistDbDao() throws IOException
    {
        ds = new DbConnectionProvider();
    }

    public void addToPlaylist(Song selectedSong, Playlist selectedPlaylist)
    {
        try (Connection con = ds.getConnection())
        {
            String sql = " INSERT INTO PlaylistSongs VALUES (?, ?)";
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, selectedPlaylist.getId());
            pstmt.setInt(2, selectedSong.getId());

            pstmt.execute();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Song> getAllSongsOnPlaylist(Playlist playlist)
    {
        List<Song> songList = new ArrayList<>();
        try (Connection con = ds.getConnection())
        {

            PreparedStatement pstmt = con.prepareStatement("SELECT * FROM PlaylistSongs WHERE PlaylistID = (?) ");
            pstmt.setInt(1, playlist.getId());

            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                String title = rs.getString("Title");
                String artist = rs.getString("Artist");
                String location = rs.getString("Location");
                int id = rs.getInt("id");
                songList.add(new Song(title, artist, location, id));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return songList;
    }

    public void newPlaylist(Playlist playlistName)
    {
        String name = playlistName.getName();

        try (Connection con = ds.getConnection())
        {
            String sql = "INSERT INTO Playlist VALUES (?)";
            PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, name);

            pstmt.execute();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public List<Playlist> getAllPlaylists() throws SQLException
    {
        List<Playlist> playlistList = new ArrayList<>();
        try (Connection con = ds.getConnection())
        {

            Statement statement = con.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Playlist");
            while (rs.next())
            {
                String name = rs.getString("Name");
                int id = rs.getInt("id");
                playlistList.add(new Playlist(id, name));
            }
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return playlistList;
    }

    public void deletePlaylist(Playlist playlist)
    {
        int id = playlist.getId();
        try (Connection con = ds.getConnection())
        {

            PreparedStatement pstmt = con.prepareStatement("DELETE FROM Playlist WHERE ID=(?)");
            pstmt.setInt(1, id);
            pstmt.execute();
            pstmt.close();
            System.out.println(id + "has been deleted");
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public void editPlaylist(Playlist playlist)
    {
        try (Connection con = ds.getConnection())
        {
            PreparedStatement pstmt = con.prepareStatement("UPDATE Playlist SET Name = (?) WHERE ID = (?)");
            pstmt.setString(1, playlist.getName());
            pstmt.setInt(2, playlist.getId());
            pstmt.execute();
            pstmt.close();

        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
