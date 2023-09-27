package screenShots;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Song {
	
	
	 String name;
	    Song next;

	    public void Song(String name) {
	        this.name = name;
	        this.next =null;
	    }
	}

	class User {
	    String name;
	    int capacity;
	    HashMap<String, Song> playedSongs;
	    Song head;
	    Song tail;

	    public User(String name, int capacity) {
	        this.name = name;
	        this.capacity = capacity;
	        this.playedSongs = new HashMap<>();
	        this.head = null;
	        this.tail = null;
	    }

	    public void playSong(String songName) {
	        if (playedSongs.containsKey(songName)) {
	            Song song = playedSongs.get(songName);
	            moveToHead(song);
	        } else {
	            Song song = new Song();
	            playedSongs.put(songName, song);
	            if (head == null) {
	                head = tail = song;
	            } else {
	                head.next = song;
	                head = song;
	            }

	            if (playedSongs.size() > capacity) {
	                removeLeastRecentlyPlayed();
	            }
	        }
	    }

	    private void moveToHead(Song song) {
	        if (song != head) {
	            if (song == tail) {
	                tail = song.next;
	            }
	            if (song.next != null) {
	                song.next = song.next.next;
	            }
	            if (head != null) {
	                head.next = song;
	            }
	            song.next = null;
	            head = song;
	        }
	    }

	    private void removeLeastRecentlyPlayed() {
	        if (tail != null) {
	            playedSongs.remove(tail.name);
	            tail = tail.next;
	        }
	    }

	    public List<String> getRecentlyPlayedSongs() {
	        List<String> recentlyPlayedSongs = new ArrayList<>();
	        Song currentSong = tail;
	        while (currentSong != null) {
	            recentlyPlayedSongs.add(currentSong.name);
	            currentSong = currentSong.next;
	        }
	        return recentlyPlayedSongs;
	    }
	}

	class RecentlyPlayedStore {
	    int initialCapacity;
	    HashMap<String, User> users;

	    public RecentlyPlayedStore(int initialCapacity) {
	        this.initialCapacity = initialCapacity;
	        this.users = new HashMap<>();
	    }

	    public void addUser(String userName) {
	        users.put(userName, new User(userName, initialCapacity));
	    }

	    public void playSong(String userName, String songName) {
	        User user = users.get(userName);
	        if (user != null) {
	            user.playSong(songName);
	        } else {
	            System.out.println("User '" + userName + "' does not exist.");
	        }
	    }

	    public List<String> getRecentlyPlayedSongs(String userName) {
	        User user = users.get(userName);
	        if (user != null) {
	            return user.getRecentlyPlayedSongs();
	        }
	        return Collections.emptyList();
	    }
	}
	
		    
	

	
	
	
	
	
	
	


