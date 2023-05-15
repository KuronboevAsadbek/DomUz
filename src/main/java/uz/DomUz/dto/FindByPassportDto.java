package uz.DomUz.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FindByPassportDto {

    private Long id;

    private String name;

    private String  lastName;

    protected String passportNumber;


}
