package com.rest.pojo.workspace;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.HashMap;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
@JsonIgnoreProperties(value = {"id","i"}, allowSetters = true)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Workspace {
    private String id;
    private String name;
    private String type;
    private String description;

    @JsonIgnore
    private int i;
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private HashMap<String, String> myHashMap;

    public Workspace(String name, String type, String description) {
        this.name = name;
        this.type = type;
        this.description = description;
    }
}
