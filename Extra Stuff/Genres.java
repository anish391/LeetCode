import java.util.*;

public class Genres {

    public static Map<String, List<String>> favoriteGenres(Map<String, List<String>> userSongs, Map<String, List<String>> songGenres){
        Map<String, String> genreToSongs = new HashMap<>();
        Map<String, List<String>> userGenres = new HashMap<>();
        for(String genre: songGenres.keySet()){
            List<String> songs = songGenres.get(genre);
            for(String song: songs)
                genreToSongs.put(song, genre);
        }
        System.out.println(genreToSongs);
        for(String user: userSongs.keySet()){
            List<String> songs = userSongs.get(user);
            int maxCount = Integer.MIN_VALUE;
            Map<String, Integer> genreCount = new HashMap<>();
            for(String song: songs){
                String genre = genreToSongs.get(song);
                int count = genreCount.getOrDefault(genre,0)+1;
                maxCount = Math.max(maxCount, count);
                genreCount.put(genre, count);
            }
            System.out.println(genreCount);
            List<String> genres = new ArrayList<>();
            for(String genre: genreCount.keySet()){
                if(genreCount.get(genre)==maxCount)
                    genres.add(genre);
            }
            userGenres.put(user, genres);
        }
        System.out.println(userGenres);
        return null;
    }

    public static void main(String[] args) {
        Map<String, List<String>> userSongs = new HashMap<>();
        Map<String, List<String>> songGenres = new HashMap<>();
        List<String> davidList = new ArrayList<>(Arrays.asList("song1", "song2", "song3", "song4", "song8"));
        List<String> emmaList = new ArrayList<>(Arrays.asList("song5", "song6", "song7"));
        userSongs.put("David", davidList);
        userSongs.put("Emma", emmaList);
        List<String> rockList = new ArrayList<>(Arrays.asList("song1", "song3"));
        List<String> dubList = new ArrayList<>(Arrays.asList("song7"));
        List<String> technoList = new ArrayList<>(Arrays.asList("song2", "song4"));
        List<String> popList = new ArrayList<>(Arrays.asList("song5", "song6"));
        List<String> jazzList = new ArrayList<>(Arrays.asList("song8", "song9"));
        songGenres.put("Rock", rockList);
        songGenres.put("Dubstep", dubList);
        songGenres.put("Techno", technoList);
        songGenres.put("Pop", popList);
        songGenres.put("Jazz", jazzList);
        System.out.println(userSongs);
        System.out.println(songGenres);
        favoriteGenres(userSongs, songGenres);
        //favoriteGenres(userSongs, new HashMap<>());
    }
}
