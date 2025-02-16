package com.vk.sample.model.requestmodel;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreateEmployeeRequestModel {

    private String firstName;
    private String lastName;
    private String email;
    private String gender;
    private String mobNum;
    private String city;

}
