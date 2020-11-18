package by.epam.tasks.task3.model.service;

import by.epam.tasks.task3.model.entity.Carriage;
import by.epam.tasks.task3.model.entity.PassengerTrain;
import by.epam.tasks.task3.model.entity.Seat;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TrainService {
    final static int MINUTES_IN_HOUR = 60;
    public Optional<PassengerTrain> findClosest(String destination, int[] time, PassengerTrain ...trains){
        int timeDifference = -1;
        Optional<PassengerTrain> result = null;
        for(PassengerTrain train : trains){
            if (train.getDestination().equals(destination)){
                int[] departureTime = train.getDepartureTime();
                int dif = (departureTime[0] - time[0])*MINUTES_IN_HOUR + (departureTime[1]-time[1]);
                if (dif>0 && (dif<timeDifference || timeDifference == -1)){
                    timeDifference = dif;
                    result = Optional.of(train);
                }
            }
        }

        return result;
    }

    public int calculateFreeSeats(PassengerTrain train){
        int count = 0;
        for (Carriage carriage: train.getCarriages()){
            for (Seat seat: carriage.getSeats()){
                if (!seat.isReserved()){
                    count++;
                }
            }
        }
        return count;
    }

    private int timeCompare(int[] time, int[] time1){
        return ((time[0]-time1[0])*MINUTES_IN_HOUR + (time[1]-time1[1]));
    }


    public List<PassengerTrain> trainsToDestination(String destination, PassengerTrain ... trains){
        List<PassengerTrain> result = new ArrayList<>();
        for (PassengerTrain train: trains) {
            if (train.getDestination().equals(destination)){
                result.add(train);
            }
        }
        return result;
    }

    public List<PassengerTrain> trainsToDestination(String destination, int[] time, PassengerTrain ... trains){
        List<PassengerTrain> result = new ArrayList<>();
        for (PassengerTrain train: trains) {
            if (train.getDestination().equals(destination) && timeCompare(time, train.getDepartureTime()) < 0){
                result.add(train);
            }
        }
        return result;
    }
}
