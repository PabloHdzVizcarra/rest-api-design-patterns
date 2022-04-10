package jvm.pablohdz.restapidesignpatterns.model;

import jvm.pablohdz.restapidesignpatterns.dto.ChannelDto;
import jvm.pablohdz.restapidesignpatterns.dto.MessageRedisDto;
import jvm.pablohdz.restapidesignpatterns.dto.UserRedisDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ConversationModel {
    private UserRedisDto user;
    private MessageRedisDto message;
    private ChannelDto channel;
}
