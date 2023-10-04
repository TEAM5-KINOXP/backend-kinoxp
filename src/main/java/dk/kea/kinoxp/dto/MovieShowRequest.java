package dk.kea.kinoxp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class MovieShowRequest {
    int id;
    public MovieShowRequest(int id){
        this.id = id;
    }
}
