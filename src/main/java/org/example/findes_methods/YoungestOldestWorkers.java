package org.example.findes_methods;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;


@Data
@Builder
public class YoungestOldestWorkers {
    private String type;
    private String name;
    private LocalDate birthday;

    public YoungestOldestWorkers(String type, String name, LocalDate birthday) {
        this.type = type;
        this.name = name;
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return type + " worker is " + name + " (birthday: " + birthday + ")";
    }
}
