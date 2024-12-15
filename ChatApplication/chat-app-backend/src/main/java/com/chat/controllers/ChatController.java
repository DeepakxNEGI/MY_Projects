package com.chat.controllers;

import java.time.LocalDateTime;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;

import com.chat.entities.Message;
import com.chat.entities.Room;
import com.chat.playload.MessageRequest;
import com.chat.repositories.RoomRepository;

@Controller
public class ChatController {

private RoomRepository roomRepository;

public ChatController(RoomRepository roomRepository) {
    this.roomRepository = roomRepository;
}

//for sending and receiving messagees

@MessageMapping("/sendMessage/{roomId}")
@SendTo("/topic/room/{roomId}")
public Message sendMessage(
@DestinationVariable String roomID,
@RequestBody MessageRequest request)
{

   Room room=roomRepository.findByRoomId(request.getRoomId());
   Message message = new Message();
   message.setContent(request.getContent());
   message.setSender(request.getSender());
   message.setTimeStamp(LocalDateTime.now());
   if(room!=null){
    room.getMessages().add(message);
    roomRepository.save(room);

   }else{
    throw new RuntimeException("room not found !!");
   }
   return message;
}

}

