package com.evilsoulm.keep_nice.model.dao;

// THIS CODE IS GENERATED BY greenDAO, EDIT ONLY INSIDE THE "KEEP"-SECTIONS

// KEEP INCLUDES - put your custom includes here
// KEEP INCLUDES END

/**
 * Entity mapped to table "user".
 */
public class User {

    private Long userId;
    /**
     * Not-null value.
     */
    private String name;
    /**
     * Not-null value.
     */
    private String age;

    // KEEP FIELDS - put your custom fields here
    // KEEP FIELDS END

    public User() {
    }

    public User(Long userId) {
        this.userId = userId;
    }

    public User(Long userId, String name, String age) {
        this.userId = userId;
        this.name = name;
        this.age = age;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * Not-null value.
     */
    public String getName() {
        return name;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Not-null value.
     */
    public String getAge() {
        return age;
    }

    /**
     * Not-null value; ensure this value is available before it is saved to the database.
     */
    public void setAge(String age) {
        this.age = age;
    }

    // KEEP METHODS - put your custom methods here
    // KEEP METHODS END

}
