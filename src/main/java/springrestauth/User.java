package springrestauth;

public class User {
    private final int id;
    private final String name;

    User(int id, String name){
        this.id = id;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getId(){
        return id;
    }
}
