package Users;

import Exceptions.CarAlreadyExists;

import java.util.ArrayList;

public class Manager extends User
{
    public String business_name, description, location, contact;
    public ArrayList<Car> cars=new ArrayList<>();
    public Manager(String username, String password, String phone_number, String email,String role){
        super(username, password, phone_number, email,role);

    }

    @Override
    public String toString() {
        return super.toString() +
                "bussiness_name='" + business_name + '\'' +
                ", description='" + description + '\'' +
                ", location='" + location + '\'' +
                ", contact='" + contact + '\'' +
                '}';
    }


    public boolean addCar(Car c) throws CarAlreadyExists {
        if(cars.contains(c))
        {
            throw new CarAlreadyExists(c.getName());
        }

        cars.add(c);
        return true;
    }

    public void deleteCar(String name, int year)
    {
        cars.removeIf(c -> c.getName().equals(name) && c.getYear() == year);

    }

    public ArrayList<Car> getCars() {
        return cars;
    }

    public void setCars(ArrayList<Car> cars) {
        this.cars = cars;
    }



    public static void main(String[] args) throws CarAlreadyExists {
        Car c1=new Car("Audi",2021,10000);
        Car c2=new Car("Audi",2020,10000);
        Manager m=new Manager("Ion","parola","07","email","Manager");
        System.out.println(m.addCar(c1));
        System.out.println(m.addCar(c2));
        System.out.println(m.cars);
        m.deleteCar("Audi",2020);
        System.out.println(m.cars);
    }
}
