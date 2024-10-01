package org.example;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Client {
    private long id;
    private String name;

    public Client(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "\nClient: id - " + id + ", name - " + name;
    }
}
