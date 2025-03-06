package com.example.lesson5.entity;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Info {
    private String name;
    private String nickName;
    private String email;
    private String website;


}
