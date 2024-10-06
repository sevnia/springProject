package com.bs.spring.student.controller;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentVO {
	private String name;
	private String age;
	private String agec;
	private String cl;
	private String c;
}
