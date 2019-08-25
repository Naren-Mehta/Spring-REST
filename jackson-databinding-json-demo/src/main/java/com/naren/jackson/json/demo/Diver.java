package com.naren.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Diver {

	public static void main(String[] args) {

		try {
			ObjectMapper mapper = new ObjectMapper();

			Student theStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);

			System.out.println(theStudent);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
