package advent.of.code.day07;

public class BagRuleListener {
    private final BagRepository bagRepository;
    private Bag currentBag;

    public BagRuleListener(BagRepository bagRepository) {
        this.bagRepository = bagRepository;
    }

    public void bagWithColor(String bagWithColor) {
        if (this.currentBag != null) {
            this.currentBag.addChild(getOrCreateBag(bagWithColor));
        } else {
            this.currentBag = getOrCreateBag(bagWithColor);
        }
    }

    private Bag getOrCreateBag(String bagWithColor) {
        return this.bagRepository.findBag(bagWithColor)
                .orElseGet(() -> this.bagRepository.save(new Bag(bagWithColor)));
    }

    public void count(int count) {
    }

    public void contains() {
    }

    public void and() {
    }

    public void period() {
        this.currentBag = null;
    }
}
