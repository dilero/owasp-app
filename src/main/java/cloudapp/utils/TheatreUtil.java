package cloudapp.utils;

import cloudapp.entity.Theatre;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class TheatreUtil {
    public static String getRandomDescription() {
        ArrayList<String> descriptionArray = new ArrayList<String>();
        descriptionArray.add(
                "Diary of a Madman is a farcical short story by Nikolai Gogol. Along with The Overcoat and The Nose, Diary of a Madman is considered to be one of Gogol's greatest short stories.");
        descriptionArray.add(
                "Vasï¿½f ï¿½ngï¿½ren'in 1977'de yazdï¿½ï¿½ï¿½ tiyatro eseridir. Eser, epik tiyatronun Tï¿½rkiye'deki ï¿½nemli ï¿½rneklerinden biri kabul edilir. Oyunda, 1970 yï¿½lï¿½nda, Tï¿½rkiye'de bï¿½yï¿½k bir iï¿½ï¿½i eylemi olan 15-16 Haziran Olaylarï¿½.");
        descriptionArray.add(
                "On ï¿½ki ï¿½fkeli Adam 1950 yï¿½lï¿½nda ilk olarak ï¿½stanbul ï¿½ehir Tiyatrolarï¿½ tarafï¿½ndan sahnelemiï¿½ olduï¿½u oyun 22 Ekim 2014 tarihinde yeniden sahnemiï¿½tir. ï¿½nlï¿½ ingiliz yazar Reginald Rose kaleme aldï¿½ï¿½ï¿½ ï¿½evirisini.");
        int newdescription = (int) (Math.random() * 3);
        String description = descriptionArray.get(newdescription);
        return description;
    }

    public static String getRandomMalDescription() {
        getRandomDescription();

        ArrayList<String> descriptionArray = new ArrayList<String>();
        descriptionArray.add(TheatreConstants.malSample1);
        descriptionArray.add(TheatreConstants.malSample2);

        int newdescription = (int) (Math.random() * 2);
        String description = descriptionArray.get(newdescription);
        return description;
    }

    //
    public static Theatre getRandomTheatre() {
        List<Theatre> theatreList = new ArrayList<Theatre>();
        theatreList.add(new Theatre("The Shawshank Redemption",
                "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
                2, 142, new Date(1994, 10, 14), "Crime,Drama",
                getRandomCast()));

        theatreList.add(new Theatre("The Godfather",
                "The aging patriarch of an organized crime dynasty transfers control of his clandestine empire to his reluctant son.",
                3, 175, new Date(1972, 3, 24), "Crime,Drama", getRandomCast()));

        theatreList.add(new Theatre("The Dark Knight",
                "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, the caped crusader must come to terms with one of the greatest psychological tests of his ability to fight injustice.",
                3, 152, new Date(2008, 6, 18), "Action,Crime,Drama",
                getRandomCast()));

        theatreList.add(new Theatre("Pulp Fiction",
                "The lives of two mob hit men, a boxer, a gangster's wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
                3, 154, new Date(1994, 10, 14), "Crime,Drama",
                getRandomCast()));

        theatreList.add(new Theatre("Schindler's List",
                "In Poland during World War II, Oskar Schindler gradually becomes concerned for his Jewish workforce after witnessing their persecution by the Nazis.",
                4, 195, new Date(1993, 2, 4), "Biography, Drama, History",
                getRandomCast()));

        theatreList.add(new Theatre("Fight Club",
                "An insomniac office worker, looking for a way to change his life, crosses paths with a devil-may-care soap maker, forming an underground fight club that evolves into something much, much more...",
                2, 139, new Date(1999, 10, 15), "Drama", getRandomCast()));

        int random = (int) (Math.random() * theatreList.size());
        return theatreList.get(random);
    }

    public static Theatre getRandomMalTheatre() {
        getRandomTheatre();

        List<Theatre> theatreList = new ArrayList<Theatre>();
        theatreList.add(new Theatre(TheatreConstants.malSample1,
                TheatreConstants.malSample1, 2, 142, new Date(1994, 10, 14),
                TheatreConstants.malSample1, getRandomCast()));

        theatreList.add(new Theatre(TheatreConstants.malSample2,
                TheatreConstants.malSample2, 3, 175, new Date(1972, 3, 24),
                TheatreConstants.malSample2, getRandomCast()));

        int random = (int) (Math.random() * theatreList.size());
        return theatreList.get(random);
    }

    public static List<Integer> getRandomCast() {
        List<Integer> newCastList = new ArrayList<Integer>();
        int random = (int) (Math.random() * 20 + 1);
        for (int a = 0; a < random; a++) {
            int newPerson = (int) (Math.random() * 20 + 1);
            if (!newCastList.contains(newPerson)) {
                newCastList.add(newPerson);
            }
        }
        return newCastList;
    }
}
