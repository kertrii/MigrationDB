package org.example.findes_methods;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LongestProject {
    private String projectName;
    private int monthCount;

    public LongestProject(String projectName, int monthCount) {
        this.projectName = projectName;
        this.monthCount = monthCount;
    }

    @Override
    public String toString() {
        return projectName + " lasts the longest (" + monthCount + " months) ";
    }

}
