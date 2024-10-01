package org.example.findes_methods;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MaxProjectCountClient {
    private String name;
    private int projectCount;

    public MaxProjectCountClient(String name, int projectCount) {
        this.name = name;
        this.projectCount = projectCount;
    }

    @Override
    public String toString() {
        return name + " has the maximum number (" + projectCount + ") of projects";
    }

}

