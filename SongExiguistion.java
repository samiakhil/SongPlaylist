package screenShots;

public class SongExiguistion {

	
	public static void main(String[] args) {
        RecentlyPlayedStore store = new RecentlyPlayedStore(3);

        store.addUser("User1");
        store.addUser("User2");

        store.playSong("User1", "Song1");
        store.playSong("User1", "Song2");
        store.playSong("User1", "Song3");

        store.playSong("User2", "Song1");
        store.playSong("User2", "Song2");
        store.playSong("User2", "Song4");

        System.out.println(store.getRecentlyPlayedSongs("User1"));  // Output: [Song3, Song2, Song1]
        System.out.println(store.getRecentlyPlayedSongs("User2"));  // Output: [Song4, Song2, Song1]
    }
	
	
	
	
}
