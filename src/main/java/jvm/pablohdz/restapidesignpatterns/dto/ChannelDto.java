package jvm.pablohdz.restapidesignpatterns.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChannelDto {
    private String id;
    private String channel;
    private String description;
}
