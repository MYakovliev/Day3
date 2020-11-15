package by.epam.tasks.task3.view;

import by.epam.tasks.task3.model.entity.PassengerTrain;
import by.epam.tasks.task3.model.service.TrainService;

public class Reports {
    static TrainService trainService = new TrainService();

    public String findClosestReport(PassengerTrain[] trains){
        StringBuilder sb = new StringBuilder();
        String dest = "dest1";
        PassengerTrain train = trainService.findClosest(dest, new int[]{10, 5}, trains);
        sb.append("Closest train to ").append(dest).append(" is ");
        sb.append(train).append("\n");
        return sb.toString();
    }

    public String calculateFreeSeatsReport(PassengerTrain[] trains){
        StringBuilder sb = new StringBuilder();
        int freeSeats = trainService.calculateFreeSeats(trains[0]);
        sb.append("Amount of free seats in ").append(trains[0]).append(" is ");
        sb.append(freeSeats).append("\n");
        return sb.toString();
    }

    public String trainsToDestinationReport(PassengerTrain[] trains){
        StringBuilder sb = new StringBuilder();
        String dest = "dest1";

        PassengerTrain[] trains1 = trainService.trainsToDestination(dest, trains);
        sb.append("List of trains to ").append(dest).append(": \n");
        for (PassengerTrain train: trains1){
            sb.append(train).append("\n");
        }
        return sb.toString();
    }

    public String trainsToDestinationReportAfterTime(PassengerTrain[] trains){
        StringBuilder sb = new StringBuilder();
        String dest = "dest1";
        int[] time = {7, 15};
        PassengerTrain[] trains1 = trainService.trainsToDestination(dest, time, trains);
        sb.append("List of trains to ").append(dest);
        sb.append(" that departure after ").append(time[0]).append(" : ").append(time[1]).append(" :\n");
        for (PassengerTrain train: trains1){
            sb.append(train).append("\n");
        }
        return sb.toString();
    }
}
