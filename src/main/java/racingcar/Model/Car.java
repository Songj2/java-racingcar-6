package racingcar.Model;

public class Car {
    private String name;
    private int onGoing;

    public Car(){}

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setOnGoing(int onGoing) {
        this.onGoing = onGoing;
    }

    public int getOnGoing() {
        return onGoing;
    }
    @Override
    public boolean equals(Object o){
        if (this == o){
            return true;
        }
        return ((Car)o).getName().equals(this.name) ;
    }
}