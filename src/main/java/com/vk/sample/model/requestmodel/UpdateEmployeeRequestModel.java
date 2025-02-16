package com.vk.sample.model.requestmodel;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEmployeeRequestModel {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobNum;
    private String city;
}
