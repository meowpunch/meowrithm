package amazon;

import java.util.HashMap;
import java.util.List;

public class StringComposition {
    /*
        input
        ["rockstar", "rock", "star", rocks", "tar", "stars", "rockstars", "in", "heaven", "starinheaven"]

        output(print)
        "rockstar" -> "rock" + "star"
        "rocksasdatar" -> "rocks" + "tar"
        ...
        "starinheaven" -> "star" + "in" + "heaven"


        [

        loop
            targetWord - "rockstar"
            HashMap store occurrence of words other than targetWord

            loop excluding targetWord
                word - "star"
                check if building targetWord with the word and other words already occurred in hashMap (e.g. "rock")

     */
    public void process(List<String> input) {
        final int N = input.size();
        // loop
        for (int i = 0; i < N; i++) {
            final String targetWord = input.get(i);
            final HashMap<String, Boolean> occurrence = new HashMap<>();
            for (int j = 0; j < N; j++) {
                // excluding targetWord
                if (j == i) continue;

                final String word = input.get(j);

                // maybe I should check if targetWords contains word

                // split targetWord by word
                String[] splitStringList = targetWord.split(word);

            }
        }
    }


}
