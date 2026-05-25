package idusw.javaweb.sba2.domain;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
// Model - DTO(Data Transfer Object) : Beans 객체 또는 POJO(Plain Old Java Object)임
public class Blog {
    private long id;
    private String title;
    private String Content;
    private String email;
    private Timestamp regDateTime;


}
