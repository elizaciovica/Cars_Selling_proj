package Users;
public class Manager extends User
{
    String business_name, description, location, contact;

    public Manager(String username, String password, String phone_number, String email){
        super(username, password, phone_number, email);
        this.contact=contact;
        this.description=description;
        this.location=location;
        this.business_name = business_name;
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

}
