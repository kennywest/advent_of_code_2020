package advent.of.code.day07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.EqualsAndHashCode;

@EqualsAndHashCode(exclude = {"parents", "children"})
public class Bag {

    private final String color;
    private final List<Bag> parents = new ArrayList<>();
    private final List<Bag> children = new ArrayList<>();

    public Bag(String color) {
        this.color = color.trim();
    }

    public String getColor() {
        return this.color;
    }

    void addChild(Bag bag) {
        if (!this.children.contains(bag)) {
            this.children.add(bag);
        }
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
}
