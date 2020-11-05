package com.fylong.Web.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User implements Serializable {

    private String name;

    private String age;

    private String province;

    private String city;

    private String region;

    private String agentName;

}
