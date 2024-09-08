package com.MYproject2.EmailSenderApp.api;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private  String from;
    private String content;
    private List<String> files;
    private String  Subjects;
}
