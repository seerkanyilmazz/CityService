package com.seerkanyilmazz.CityService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {
    @Id
    private String id;
    private Date createdDate = new Date();
    private String name;
}
