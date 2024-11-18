import java.util.ArrayList;
import java.util.Scanner;

public class raceUtils {

    private static final String inputMessageRacingCarName =
            "Введите название гоночного автомобиля №%d: ";
    private static final String inputMessageRacingCarSpeed =
            "Введите скорость гоночного автомобиля №%d: ";
    private static final String alertMessageSpeedRange =
            "Скорость автомобиля должна быть указана в диапазоне от 1 до 250 км/ч";

    private static RacingCar setRacingCarNameAndSpeed(int carNumber) {
        String racingCarName = setRacingCarName(carNumber);
        int racingCarSpeed = setRacingCarSpeed(carNumber);

        System.out.print("\n");

        return new RacingCar(racingCarName, racingCarSpeed);
    }

    private static String setRacingCarName(int carNumber) {
        String racingCarName = "";
        boolean racingCarSpeedCheck = true;

        System.out.printf(inputMessageRacingCarName, carNumber);
        while (racingCarSpeedCheck) {
            Scanner scannerRacingCarName = new Scanner(System.in);
            racingCarName = scannerRacingCarName.nextLine();

            if (racingCarName.isEmpty()) {
                System.out.println("Название гоночного автомобиля не должно быть пустым!");
                System.out.printf(inputMessageRacingCarName, carNumber);
            } else {
                racingCarSpeedCheck = false;
            }
        }

        return racingCarName;
    }

    private static int setRacingCarSpeed(int carNumber) {
        int racingCarSpeed = 0;
        boolean racingCarSpeedCheck = true;

        System.out.printf(inputMessageRacingCarSpeed, carNumber);
        while (racingCarSpeedCheck) {
            Scanner scannerRacingCarSpeed = new Scanner(System.in);

            if (scannerRacingCarSpeed.hasNextInt()) {
                racingCarSpeed = scannerRacingCarSpeed.nextInt();

                if (racingCarSpeed > 0 && racingCarSpeed <= 250) {
                    racingCarSpeedCheck = false;
                } else {
                    System.out.println(alertMessageSpeedRange);
                    System.out.printf(inputMessageRacingCarSpeed, carNumber);
                }
            } else {
                System.out.println(alertMessageSpeedRange);
                System.out.printf(inputMessageRacingCarSpeed, carNumber);
            }
        }

        return racingCarSpeed;
    }

    public static ArrayList<RacingCar> getAllRacingCars(int countOfRacingCars) {
        int minCountOfRacingCars = 1;

        ArrayList<RacingCar> listRacingCars = new ArrayList<>();

        do {
            listRacingCars.add(setRacingCarNameAndSpeed(minCountOfRacingCars));
            minCountOfRacingCars++;
        } while (minCountOfRacingCars <= countOfRacingCars);

        return listRacingCars;
    }

    public static void getRaceWinner(ArrayList<RacingCar> listRacingCars) {
        int hoursOfRace = 24;
        int finalDistance;
        RacingCar winner = listRacingCars.get(0);

        for (RacingCar raceCar : listRacingCars) {
            finalDistance = raceCar.speed * hoursOfRace;

            if (finalDistance > winner.speed * hoursOfRace) {
                winner = raceCar;
            }
        }

        System.out.println("Самая быстрая машина: " + winner.name);
    }
}
