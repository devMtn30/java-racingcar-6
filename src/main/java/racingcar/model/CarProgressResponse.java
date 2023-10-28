package racingcar.model;

public final class CarProgressResponse {
    private final String name;
    private final int result;

    public CarProgressResponse(String name, int result) {
        this.name = name;
        this.result = result;
    }

    public String getName() {
        return name;
    }

    public int getResult() {
        return result;
    }
}
