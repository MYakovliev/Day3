package by.epam.tasks.task3.model.entity;

import java.util.ArrayList;
import java.util.List;

public class Carriage {
    private int num;
    private int seatsNumber;
    private List<Seat> seats;
    private CarriageTypes type;

    public Carriage(int num, CarriageTypes type) {
        setNum(num);
        setType(type);
        refreshSeats();
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void refreshSeats() {
        seats = new ArrayList<>();
        for (int i = 0; i < seatsNumber; i++){
            seats.add(new Seat(i+1));
        }
    }

    public CarriageTypes getType() {
        return type;
    }

    public void setType(CarriageTypes type) {
        this.type = type;
        switch (type){
            case ECONOM: seatsNumber = 54; break;
            case BUSINESS: seatsNumber = 36; break;
            default:
                throw new IllegalArgumentException("unknown Carriage type");

        }
    }
}
