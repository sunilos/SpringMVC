package com.sunilos.form;

import java.util.ArrayList;

/**
 * Controller to explain HTML tag data binding and its rendering using Array,
 * input elements using Spring Tags and binds this form-bean attributes.
 * 
 * @author SUNRAYS Developer
 * @version 1.0
 * @Copyright (c) SUNRAYS Technologies
 */

public class TagForm {

	/**
	 * Value is bound with INPUT email type element
	 */
	private String email = null;

	// Values are bound to Checkboxes
	private String name = null;

	private boolean agreed = false;

	private String[] selectedSkills = null;

	private ArrayList<String> selectedCourses = null;

	private String[] selectedLanguages = null;

	// Values are bound to RADIO buttons or SELECT list

	private String skill = null;

	private String course = null;

	private String gender = null;

	private String lang = null;

	private String role = null;

	// Accessor methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isAgreed() {
		return agreed;
	}

	public void setAgreed(boolean agreed) {
		this.agreed = agreed;
	}

	public String[] getSelectedSkills() {
		return selectedSkills;
	}

	public void setSelectedSkills(String[] selectedSkills) {
		this.selectedSkills = selectedSkills;
	}

	public ArrayList getSelectedCourses() {
		return selectedCourses;
	}

	public void setSelectedCourses(ArrayList selectedCourses) {
		this.selectedCourses = selectedCourses;
	}

	public String[] getSelectedLanguages() {
		return selectedLanguages;
	}

	public void setSelectedLanguages(String[] selectedLanguages) {
		this.selectedLanguages = selectedLanguages;
	}

	public String getSkill() {
		return skill;
	}

	public void setSkill(String skill) {
		this.skill = skill;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void displayValues() {

		System.out.println("*************************");
		System.out.println("Name: " + name);
		System.out.println("Agreed: " + agreed);
		System.out.println("Skill: " + skill);
		System.out.println("Course: " + course);
		System.out.println("Language: " + lang);
		System.out.println("Gender: " + gender);
		System.out.println("Role: " + role);

		System.out.println("Selected Skills: ");

		int i = 1;
		if (selectedSkills != null) {
			for (String val : selectedSkills) {
				System.out.println(i + "=" + val);
				i++;
			}
		}

		System.out.println("Selected Courses: ");

		if (selectedCourses != null) {
			i = 1;

			for (String val : selectedCourses) {
				System.out.println(i + "=" + val);
				i++;
			}
		}

		System.out.println("Selected Languages: ");

		if (selectedLanguages != null) {
			i = 1;
			for (String val : selectedLanguages) {
				System.out.println(i + "=" + val);
				i++;
			}
		}

	}

}
