package idusw.javaweb.sba2.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Country { // boilerplate code를 자동으로 생성함
    private long id; // identifier - 식별자, 유일키(primary key), 후보키(candidate key)
    private String code;
    private String name; // unique 성질을 가짐
    private String continent;
    private String region;
}
