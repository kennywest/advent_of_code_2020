package advent.of.code.day07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.EqualsAndHashCode;
import lombok.Value;

@EqualsAndHashCode(exclude = {"parents", "children"})
public class Bag {

    private final String color;
    private final List<Bag> parents = new ArrayList<>();
    private final List<ChildBags> children = new ArrayList<>();

    public Bag(String color) {
        this.color = color.trim();
    }

    public String getColor() {
        return this.color;
    }

    void addChild(int count, Bag bag) {
        this.children.add(new ChildBags(count, bag));
        bag.addParent(this);
    }

    void addParent(Bag bag) {
        this.parents.add(bag);
    }

    public Set<Bag> findAllParentBags() {
        Set<Bag> parents = new HashSet<>();
        this.parents.forEach(parent -> visitParent(parent, parents));

        return parents;
    }

    public void visitParent(Bag bag, Set<Bag> parents) {
        parents.add(bag);

        if (bag.parents.isEmpty()) {
            return;
        }
        bag.parents.forEach(parent -> visitParent(parent, parents));
    }

    public int countParents() {
        return this.parents.size();
    }

    public int countChildren() {
        return this.children.size();
    }

    public int numberOfBagsFor(String bagColor) {
        return this.children.stream()
                .filter(c -> bagColor.equals(c.getColor()))
                .findFirst()
                .map(ChildBags::getCount)
                .orElse(0);
    }

    public int countChildBags() {
        return this.children.stream()
                .map(ChildBags::getCount)
                .mapToInt(i -> i)
                .sum();
    }

    @Value
    private static class ChildBags {
        int count;
        Bag bag;

        String getColor() {
            return this.bag.getColor();
        }

        public int getCount() {
            if (this.bag.children.isEmpty()) {
                return this.count;
            }
            return this.count + (this.count * this.bag.children.stream().map(ChildBags::getCount).mapToInt(i -> i).sum());
        }
    }
}
