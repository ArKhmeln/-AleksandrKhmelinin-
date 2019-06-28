package hw4.builder;

import hw4.enums.metalsAndColors.Elements;
import hw4.enums.metalsAndColors.Vegetables;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Builder
@Getter
@ToString
@EqualsAndHashCode
public class MetalsAndColorsData {

    private List<String> summary;       //radiobutton
    private List<Elements> elements;      //checkbox
    private String colors;              //dropdown
    private String metals;              //dropdown
    private List<Vegetables> vegetables;    //dropdown -> checkbox
}
