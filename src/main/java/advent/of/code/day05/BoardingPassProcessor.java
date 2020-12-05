package advent.of.code.day05;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.io.Resources.getResource;
import static com.google.common.io.Resources.readLines;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.util.stream.Collectors.toList;
import static java.util.stream.IntStream.rangeClosed;

public class BoardingPassProcessor {
    private final List<BoardingPass> boardingPasses;

    public BoardingPassProcessor(String file) throws Exception {
        this.boardingPasses = readLines(getResource(file), UTF_8).stream()
                .map(BoardingPass::new)
                .collect(toList());
    }

    public Seat getSeatWithHighestNumber() {
        return this.boardingPasses.stream()
                .map(BoardingPass::getSeat)
                .sorted()
                .collect(toList()).get(this.boardingPasses.size() - 1);
    }

    public List<Integer> getSeatIdsWithoutBoardingPass() {
        List<Integer> seatIdsWithBoardingPasses = this.boardingPasses.stream()
                .map(BoardingPass::getSeat)
                .map(Seat::getSeatId)
                .collect(toList());

        List<Integer> seatIdsWithoutBoardingPasses = new ArrayList<>();

        rangeClosed(0, (128 * 8) - 1)
                .forEach(seatId -> {
                    if (!seatIdsWithBoardingPasses.contains(seatId)) {
                        seatIdsWithoutBoardingPasses.add(seatId);
                    }
                });

        return seatIdsWithoutBoardingPasses;
    }

    public Integer getMySeatId() {
        return getMySeatIdFrom(0, getSeatIdsWithoutBoardingPass());
    }

    private Integer getMySeatIdFrom(int currentSeatId, List<Integer> seatIds) {
        if (seatIds.get(currentSeatId) != currentSeatId) {
            return seatIds.get(currentSeatId);
        }
        return getMySeatIdFrom(currentSeatId + 1, seatIds);
    }

    public List<BoardingPass> getBoardingPasses() {
        return this.boardingPasses;
    }
}
