package step5.view.result;

import step5.domain.car.Car;
import step5.domain.car.Cars;
import step5.domain.car.Position;
import step5.domain.race.RacingGame;

public class ResultView {

    private static final String MARKER = "-";
    private boolean isFirstView = true;

    public void printProgressOfRace(Cars cars, RacingGame racingGame) {
        if (isFirstView) {
            printTitle();
            isFirstView = false;
        }

        printPositionOfCars(cars);

        if (racingGame.isFinished())
            printWinnerOfRacing(racingGame.getWinnersName());

    }

    private void printPositionOfCars(Cars cars) {
        int size = cars.size();
        for (int i = 0; i < size; i++) {
            Car car = cars.get(i);
            System.out.println(progressOfRace(car));
        }
        System.out.println();
    }

    private String progressOfRace(Car car) {
        StringBuilder sb = new StringBuilder();
        sb.append(car.getName());
        sb.append(" : ");
        sb.append(getCarPosition(car));

        return sb.toString();
    }

    private String getCarPosition(Car car) {
        StringBuilder sb = new StringBuilder();
        Position position = car.getPosition();
        int currentPosition = position.getValue();

        for (int i = 0; i < currentPosition; i++) {
            sb.append(MARKER);
        }
        return sb.toString();
    }

    private void printTitle() {
        System.out.println("실행 결과");
    }

    public void printWinnerOfRacing(String winnersName) {
        System.out.println(String.format("%s가 최종 우승했습니다.", winnersName));
    }
}