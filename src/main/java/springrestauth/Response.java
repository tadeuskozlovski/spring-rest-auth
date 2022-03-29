package springrestauth;

public class Response {
    private final int id;
    private final String name;
    private final String response;

    Response(User user){
        id = user.getId();
        name = user.getName();

        if (id == -1)
            response = "User not found";
        else
            response = "OK";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getResponse() {
        return response;
    }
}
