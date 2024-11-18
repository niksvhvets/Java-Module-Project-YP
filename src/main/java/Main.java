import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("\nВведите названия трех гоночных автомобилей и их скорость.\n");

        int countOfRacingCars = 3;

        ArrayList<RacingCar> listRacingCars = raceUtils.getAllRacingCars(countOfRacingCars);
        raceUtils.getRaceWinner(listRacingCars);
    }
}