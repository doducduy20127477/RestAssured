package com.rest.pojo.workspace;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Workspace {
    private String id;
    private String name;
    private String type;
    private String description;

    public Workspace(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }
}
