package idusw.javaweb.sba2.domain;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class Language {
    private String countryCode;
    private String language;
    private String isOfficial;
    private String population;
}
