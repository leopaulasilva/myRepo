package com.zenvia.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Msg {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("messageBody")
    private String messageBody;

    @JsonProperty("location")
    private String location;


}
