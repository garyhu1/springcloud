package com.garyhu.pojo;

import java.math.BigDecimal;

import lombok.Data;

@Data
public class User {

	private Long id;
	private String name;
	private Integer age;
	private BigDecimal balance;
}
