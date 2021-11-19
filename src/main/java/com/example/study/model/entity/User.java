package com.example.study.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity // == table
//@Table(name = "user") // DB의 이름과 같다면 생략 가능
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;
    private String email;
    private String phoneNumber;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;

    // 1 (User) : N (OrderDetail)
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user" /*OrderDetail에 있는 user*/)
    private List<OrderDetail> orderDetailList;

}
