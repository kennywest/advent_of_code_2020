package advent.of.code.day10;

import java.util.ArrayList;
import java.util.List;

import io.vavr.collection.Stream;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;

public class Adapters {
    private final List<Integer> ratings;

    public Adapters(List<Integer> ratings) {
        this.ratings = ratings;
    }

    public Adapters(String file) throws Exception {
        this(readLines(getResource(file), UTF_8).stream().map(Integer::parseInt).collect(toList()));
    }

    public int getNumberOfCombinations() {
        var listOfValidCombinations = Stream.ofAll(this.ratings)
                .combinations()
                .map(s -> s.collect(toList()))
                .filter(this::isValidCombination)
                .collect(toList());

        return listOfValidCombinations.size();
    }

    private boolean isValidCombination(List<Integer> combination) {
        if (getHighestRating() != getHighestRating(combination)) {
            return false;
        }

        if (getLowestRating(combination) != 1 && getLowestRating(combination) != 3) {
            return false;
        }


        int outletRating = 0;
        int deviceRating = getHighestRating() + 3;

        if (hasDifferenceBiggerThan(3, outletRating, deviceRating, combination)) {
            return false;
        }

        return numberOfDifferencesOfOneJolt(outletRating, deviceRating, combination)
                + numberOfDifferencesOfThreeJolts(outletRating, deviceRating, combination)
                + numberOfDifferencesOfNJolt(2, outletRating, deviceRating, combination) == combination.size() + 1;
    }

    public int getHighestRating() {
        return getHighestRating(this.ratings);
    }

    public static int getHighestRating(List<Integer> ratings) {
        return Stream.ofAll(ratings).max().getOrElse(0);
    }

    public static int getLowestRating(List<Integer> ratings) {
        return Stream.ofAll(ratings).min().getOrElse(0);
    }

    public int numberOfDifferencesOfOneJolt() {
        return numberOfDifferencesOfOneJolt(0, getHighestRating() + 3, this.ratings);
    }

    public static int numberOfDifferencesOfOneJolt(int outletRating, int deviceRating, List<Integer> adapterRatings) {
        return numberOfDifferencesOfNJolt(1, outletRating, deviceRating, adapterRatings);
    }

    public int numberOfDifferencesOfThreeJolts() {
        return numberOfDifferencesOfThreeJolts(0, getHighestRating() + 3, this.ratings);
    }

    public static int numberOfDifferencesOfThreeJolts(int outletRating, int deviceRating, List<Integer> adapterRatings) {
        return numberOfDifferencesOfNJolt(3, outletRating, deviceRating, adapterRatings);
    }

    private static boolean hasDifferenceBiggerThan(int n, int outletRating, int deviceRating, List<Integer> adapterRatings) {
        List<Integer> sortedRatings = sortedRatings(outletRating, deviceRating, adapterRatings);

        for (int i = 0; i < sortedRatings.size() - 1; i++) {
            if (sortedRatings.get(i + 1) - sortedRatings.get(i) > n) {
                return true;
            }
        }

        return false;
    }

    private static int numberOfDifferencesOfNJolt(int n, int outletRating, int deviceRating, List<Integer> adapterRatings) {
        int answer = 0;

        List<Integer> sortedRatings = sortedRatings(outletRating, deviceRating, adapterRatings);

        for (int i = 0; i < sortedRatings.size() - 1; i++) {
            if (sortedRatings.get(i + 1) - sortedRatings.get(i) == n) {
                answer++;
            }
        }

        return answer;
    }

    private static List<Integer> sortedRatings(int outletRating, int deviceRating, List<Integer> allRatings) {
        List<Integer> toSort = new ArrayList<>(allRatings);
        toSort.add(outletRating);
        toSort.add(deviceRating);

        return toSort.stream().sorted().collect(toList());
    }
}
