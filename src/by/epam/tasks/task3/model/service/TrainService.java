package by.epam.tasks.task3.model.service;

import by.epam.tasks.task3.model.entity.Carriage;
import by.epam.tasks.task3.model.entity.PassengerTrain;
import by.epam.tasks.task3.model.entity.Seat;

public class TrainService {
    final static int MINUTES_IN_HOUR = 60;
    public PassengerTrain findClosest(String destination, int[] time, PassengerTrain ...trains){
        int timeDifference = -1;
        PassengerTrain result = null;
        for(PassengerTrain train : trains){
            if (train.getDestination().equals(destination)){
                int[] departureTime = train.getDepartureTime();
                int dif = (departureTime[0] - time[0])*MINUTES_IN_HOUR + (departureTime[1]-time[1]);
                if (dif>0 && (dif<timeDifference || timeDifference == -1)){
                    timeDifference = dif;
                    result = train;
                }
            }
        }
        if (result != null){
            return result;
        }
        throw new IllegalArgumentException("train wasn't found");
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

    private boolean timeCompare(int[] time, int[] time1){

        return ((time1[0]-time[0])*MINUTES_IN_HOUR + (time1[1]-time[1])) >= 0;
    }

    private int calculateTrainAmount(PassengerTrain[] trains, String destination, int[] time){
        int count = 0;
        for (PassengerTrain train: trains){
            if (train.getDestination().equals(destination) && (timeCompare(time, train.getDepartureTime()))){
                count++;
            }
        }
        return count;
    }

    private int calculateTrainAmount(PassengerTrain[] trains, String destination){
        return calculateTrainAmount(trains, destination, new int[]{0, 0});
    }

    public PassengerTrain[] trainsToDestination(String destination, PassengerTrain ... trains){
        int count = calculateTrainAmount(trains, destination);
        PassengerTrain[] result = new PassengerTrain[count];
        count = 0;
        for (PassengerTrain train: trains) {
            if (train.getDestination().equals(destination)){
                result[count++] = train;
            }
        }
        return result;
    }

    public PassengerTrain[] trainsToDestination(String destination, int[] time, PassengerTrain ... trains){
        int count = calculateTrainAmount(trains, destination, time);
        PassengerTrain[] result = new PassengerTrain[count];
        count = 0;
        for (PassengerTrain train: trains) {
            if (train.getDestination().equals(destination) && timeCompare(time, train.getDepartureTime())){
                result[count++] = train;
            }
        }
        return result;
    }
}
