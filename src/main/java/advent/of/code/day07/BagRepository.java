package advent.of.code.day07;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BagRepository {
    private final Map<String, Bag> bags = new HashMap<>();

    public Optional<Bag> findBag(String color) {
        return Optional.ofNullable(this.bags.get(color.trim()));
    }

    public Bag save(Bag bag) {
        this.bags.put(bag.getColor(), bag);
        return bag;
    }
}
