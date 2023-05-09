package CW2;
import java.util.ArrayList;
import java.util.Scanner;

public class songProgram {
    public static void main(String[] args) {
        // create song list
        ArrayList<Song> songList = new ArrayList<Song>();

        // add the default songs
        addDefaultSongs(songList);

        // run the runProgram function, containing the command line interface parts
        System.out.println("Welcome to Rowan's Song Store Service!");
        runProgram(songList);
    }

    /**
     * the part of the program that uses the command line
     * having this as its own function allows it easily continuously be called
     * @param songList
     */
    public static void runProgram(ArrayList<Song> songList) {
        // start scanner
        Scanner scan = new Scanner(System.in);

        // output options for user
        System.out.println("Enter 1 to view your song list!");
        System.out.println("Enter 2 to view all your songs over a certain play count!");
        System.out.println("Enter 3 to add a song to your list!");
        System.out.println("Enter 4 to remove a song from your list!");
        System.out.println("Enter 5 to exit the program.");

        // uses switch statement to provide different options for user's input
        char entry = scan.next().charAt(0);
        switch(entry) {
            case '1':
            // user selected to view songs
            System.out.println("Showing song list!\n");
            Song_List.printSongList(songList);
            runProgram(songList);
            break;

            case '2':
            // user selected to view songs over a certain play count
            System.out.println("Enter the minimum play count for your search:");
            int MinNumPlays = scan.nextInt();
            System.out.println("Showing song list over " + MinNumPlays + "!\n");
            Song_List.printSongsAbovePlays(songList, MinNumPlays);
            System.out.println("");
            runProgram(songList);
            break;

            case '3':
            // user selected to add a song
            // due to errors with the scanner in this case, i had to create a scanner unique to this case
            Scanner scanAdd = new Scanner(System.in);
            System.out.println("Enter the details of the song to add!");
            System.out.println("Enter song name:");
            String name = scanAdd.nextLine();
            System.out.println("Enter song artist:");
            String artist = scanAdd.nextLine();
            System.out.println("Enter number of song plays:");
            int numPlays = scanAdd.nextInt();
            Song_List.addSongToList(name, artist, numPlays, songList);
            runProgram(songList);
            scanAdd.close();
            break;

            case '4':
            // user selected to remove a song
            // due to errors with the scanner in this case, i had to create a scanner unique to this case
            Scanner scanRemove = new Scanner(System.in);
            System.out.println("Enter the name of the song to remove:");
            String removeName = scanRemove.nextLine();
            System.out.println("Enter the name of the artist of the song:");
            String removeArtist = scanRemove.nextLine();
            Song_List.removeSongFromList(removeName, removeArtist, songList);
            runProgram(songList);
            scanRemove.close();
            break;

            case '5':
            // closes program
            System.out.println("Exiting...");
            System.exit(0);
            break;

            default:
            // called when user does an invalid input
            System.out.println("Invalid entry.");
            System.out.println("");
            runProgram(songList);
            }

        // close scanner
        scan.close();
    }

    /**
     * add the songs that are in the program as default
     * @param songList
     */
    public static void addDefaultSongs(ArrayList<Song> songList) {
        Song song1 = new Song("Watch What Happens Next", "Waterparks", 15018423);
        songList.add(song1);

        Song song2 = new Song("Kathleen", "Catfish and the Bottlemen", 146043701);
        songList.add(song2);

        Song song3 = new Song("Story of a Modern Child", "We Are The Ocean", 296608);
        songList.add(song3);

        Song song4 = new Song("Maps", "The Front Bottoms", 14112174);
        songList.add(song4);

        Song song5 = new Song("Little Monster", "Royal Blood", 89840942);
        songList.add(song5);

        Song song6 = new Song("Cause for Concern", "Lovejoy", 45986096);
        songList.add(song6);

        Song song7 = new Song("In My Mind", "The Amazons", 13024483);
        songList.add(song7);

        Song song8 = new Song("Brianstorm", "Arctic Monkeys", 186904896);
        songList.add(song8);

        Song song9 = new Song("W.D.Y.W.F.M?", "The Neighbourhood", 92398913);
        songList.add(song9);

        Song song10 = new Song("Brazil", "Declan McKenna", 370365076);
        songList.add(song10);

        Song song11 = new Song("Cities", "Throttle", 17550582);
        songList.add(song11);

        Song song12 = new Song("Do It All The Time", "I DONT KNOW HOW BUT THEY FOUND ME", 69274842);
        songList.add(song12);

        Song song13 = new Song("All These Things", "The Mysterines", 381718);
        songList.add(song13);

        Song song14 = new Song("Touch-Tone Telephone", "Lemon Demon", 57371419);
        songList.add(song14);

        Song song15 = new Song("Bigmouth Strikes Again", "The Smiths", 154303292);
        songList.add(song15);

        Song song16 = new Song("Cabo", "Ricky Montgomery", 15813621);
        songList.add(song16);

        Song song17 = new Song("Kerosene", "Tyler Posey", 645194);
        songList.add(song17);

        Song song18 = new Song("Fuzzy Tree", "The Amazons", 2387825);
        songList.add(song18);

        Song song19 = new Song("Decode", "Paramore", 182467807);
        songList.add(song19);

        Song song20 = new Song("Turbulent", "Waterparks", 54563680);
        songList.add(song20);

        Song song21 = new Song("War Crimes", "Waterparks", 4194653);
        songList.add(song21);

        Song song22 = new Song("The Road", "We Are The Ocean", 1642750);
        songList.add(song22);

        Song song23 = new Song("Losing Face", "Wilbur Soot", 39066968);
        songList.add(song23);

        Song song24 = new Song("Hook, Line & Sinker", "Royal Blood", 41045030);
        songList.add(song24);

        Song song25 = new Song("Zero Zero", "Gerard Way", 3512144);
        songList.add(song25);

        Song song26 = new Song("Twin Size Mattress", "The Front Bottoms", 137719817);
        songList.add(song26);

        Song song27 = new Song("2econd 2ight 2eer", "Will Wood", 16751277);
        songList.add(song27);

        Song song28 = new Song("Boy Division", "My Chemical Romance", 29950560);
        songList.add(song28);

        Song song29 = new Song("Leave Me Alone", "I DONT KNOW HOW BUT THEY FOUND ME", 31042754);
        songList.add(song29);

        Song song30 = new Song("Pacifier", "Catfish and the Bottlemen", 62246121);
        songList.add(song30);
    }
}

/**
 * the Song class
 * has attributes of name, artist and numPlays
 */
class Song {
    public String name;
    public String artist;
    public int numPlays;

    // constructor for song class
    public Song(String name, String artist, int numPlays) {
        this.name = name;
        this.artist = artist;
        this.numPlays = numPlays;
    }

    // returns song name
    public String getName() {
        return name;
    }

    // returns song artist
    public String getArtist() {
        return artist;
    }

    // returns number of plays
    public int getNumPlays() {
        return numPlays;
    }
}

/**
 * Song_List class
 * contains methods which manipulate the song list
 * has ArrayList attribute - songList
 */
class Song_List {
    public static ArrayList<Song> songList;

    /**
     * method for printing out the song list
     * @param songList
     */
    public static void printSongList(ArrayList<Song> songList) {
        // uses for loop to loop through list
        for(Song songx : songList) {
            // get song info
            String name = songx.getName();
            String artist = songx.getArtist();
            int numPlays = songx.getNumPlays();

            // output song details
            System.out.println("Name: " + name);
            System.out.println("Artist: " + artist);
            System.out.println("Plays: " + numPlays);

            // output new line to split up output
            System.out.println("");
        }
    }

    /**
     * method for printing songs in song list over a certain amount of plays
     * @param songList
     * @param minNumPlays
     */
    public static void printSongsAbovePlays(ArrayList<Song> songList, int minNumPlays) {
        // uses for loop to loop through list
        for(Song songx : songList) {
            // get number of plays for the song
            int numPlays = songx.getNumPlays();

            // check if number of plays is above minNumPlays
            // if it is, display song info. if not, skip
            if (numPlays >= minNumPlays) {
                // get rest of song info
                String name = songx.getName();
                String artist = songx.getArtist();

                // output song details
                System.out.println("Name: " + name);
                System.out.println("Artist: " + artist);
                System.out.println("Plays: " + numPlays);

                // output new line to split up output
                System.out.println("");
            }
        }
    }

    /**
     * method for adding a song to the list
     * @param name
     * @param artist
     * @param numPlays
     * @param songList
     */
    public static void addSongToList(String name, String artist, int numPlays, ArrayList<Song> songList) {
        Song newSong = new Song(name, artist, numPlays);
        songList.add(newSong);
        System.out.println("Song added!\n");
    }

    /**
     * method for removing a song from the list
     * @param removeName
     * @param removeArtist
     * @param songList
     */
    public static void removeSongFromList(String removeName, String removeArtist, ArrayList<Song> songList) {
        // boolean variable to track if song has been found
        boolean found = false;
        // uses for loop to loop through list
        for(Song songx : songList) {
            // gets song name and artist
            String name = songx.getName();
            String artist = songx.getArtist();
            // if that song exists, remove it
            if (name.equals(removeName) && artist.equals(removeArtist)) {
                // set found to true
                found = true;
                songList.remove(songx);
                System.out.println("Song with name: " + removeName + " and artist: " + removeArtist + " has been removed from song list.\n");
                break;
            }
        }

        // if that song doesn't exist, output error message
        if (found == false) {
            System.out.println("There is no song with name '" + removeName + "' and artist '" + removeArtist + "' in song list, so can't be removed.\n");
        }
    }
}
