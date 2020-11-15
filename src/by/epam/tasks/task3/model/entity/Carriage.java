package by.epam.tasks.task3.model.entity;

public class Carriage {
    private int num;
    private int seatsNumber;
    private Seat[] seats;
    private String type;

    public Carriage(int num, String type) {
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

    public Seat[] getSeats() {
        return seats;
    }

    public void refreshSeats() {
        seats = new Seat[seatsNumber];
        for (int i = 0; i < seatsNumber; i++){
            seats[i] = new Seat(i+1);
        }
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
        if (type.equals("econom")){
            seatsNumber = 54;
        } else if (type.equals("business")){
            seatsNumber = 36;
        } else {
            throw new IllegalArgumentException("unknown Carriage type");
        }
    }
}
