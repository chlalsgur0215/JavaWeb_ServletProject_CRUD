package idusw.javaweb.sba2.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Actor {
    private int actorId;
    private String firstName;
    private String lastName;
    private Timestamp lastUpdate;
}
