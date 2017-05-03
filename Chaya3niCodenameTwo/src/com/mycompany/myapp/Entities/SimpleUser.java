/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entities;



/**
 *
 * @author Admin
 */
public class SimpleUser {


      protected String id, name, surname, gender, dateBirth, email, username, pass, telephone, address1, address2, codePostal, photo, dateInscription, compteActif, newsletter, type, clearanceLevel, idCompany, latitude, longitude, secretQuestion, secretAnswer;
    protected static String currentId, currentUsername, currentPassword, currentName, currentSurname, currentEmail, currentSecretQuestion, currentSecretAnswer, currentPhoto, currentClearanceLevel, currentType;
  private static int splash=0;
  private static boolean status;
  private static boolean Auth=false;
private static SimpleUser currentuser=new SimpleUser();

    public static void setAuth(boolean Auth) {
        SimpleUser.Auth = Auth;
    }
    public static boolean isAuth() {
        return Auth;
    }
    public static boolean isStatus() {
        return status;
    }

    public static void setStatus(boolean status) {
        SimpleUser.status = status;
    }

    public static SimpleUser getCurrentuser() {
        return currentuser;
    }

    public static void setCurrentuser(SimpleUser currentuser) {
        SimpleUser.currentuser = currentuser;
    }

    public static int getSplash() {
        return splash;
    }

    public static void setSplash(int splash) {
        SimpleUser.splash = splash;
    }
  
    public static void UserCurrent(String currentId, String currentUsername, String currentPassword, String currentName, String currentSurname, String currentEmail, String currentSecretQuestion, String currentSecretAnswer, String currentPhoto, String currentClearanceLevel, String currentType) {
        SimpleUser.currentId = currentId;
        SimpleUser.currentUsername = currentUsername;
        SimpleUser.currentPassword = currentPassword;
        SimpleUser.currentName = currentName;
        SimpleUser.currentSurname = currentSurname;
        SimpleUser.currentEmail = currentEmail;
        SimpleUser.currentSecretQuestion = currentSecretQuestion;
        SimpleUser.currentSecretAnswer = currentSecretAnswer;
        SimpleUser.currentPhoto = currentPhoto;
        SimpleUser.currentClearanceLevel = currentClearanceLevel;
        SimpleUser.currentType = currentType;
    }
    
    
    
    public SimpleUser(String name, String surname, String gender, String dateBirth, String email, 
            String username, String pass, String telephone, String address1, String address2,
            String codePostal, String photo, String dateInscription, String newsletter, String idCompany, 
            String latitude, String longitude, String secretQuestion, String secretAnswer) {

        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.telephone = telephone;
        this.address1 = address1;
        this.address2 = address2;
        this.codePostal = codePostal;
        this.photo = photo;
        this.dateInscription = dateInscription;
        this.compteActif = "1";
        this.newsletter = newsletter;
        this.type = "User";
        this.clearanceLevel = "0";
        this.idCompany = idCompany;
        this.latitude = latitude;
        this.longitude = longitude;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
    }

    public SimpleUser(String id, String name, String surname, String gender, String dateBirth, 
            String email, String username, String pass, String telephone, String address1, 
            String address2, String codePostal, String photo, String dateInscription, String newsletter, 
            String idCompany, String latitude, String longitude, String secretQuestion, String secretAnswer) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.dateBirth = dateBirth;
        this.email = email;
        this.username = username;
        this.pass = pass;
        this.telephone = telephone;
        this.address1 = address1;
        this.address2 = address2;
        this.codePostal = codePostal;
        this.photo = photo;
        this.dateInscription = dateInscription;
        this.compteActif = "1";
        this.newsletter = newsletter;
        this.type = "User";
        this.clearanceLevel = "0";
        this.idCompany = idCompany;
        this.latitude = latitude;
        this.longitude = longitude;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
    }

    public SimpleUser() {
    }

    

    
    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", surname=" + surname + ", gender=" + gender + ", dateBirth=" + dateBirth + ", email=" + email + ", username=" + username + ", pass=" + pass + ", telephone=" + telephone + ", address1=" + address1 + ", address2=" + address2 + ", codePostal=" + codePostal + ", photo=" + photo + ", dateInscription=" + dateInscription + ", compteActif=" + compteActif + ", newsletter=" + newsletter + ", type=" + type + ", clearanceLevel=" + clearanceLevel + ", idCompany=" + idCompany + ", latitude=" + latitude + ", longitude=" + longitude + ", secretQuestion=" + secretQuestion + ", secretAnswer=" + secretAnswer + '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(String dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDateInscription() {
        return dateInscription;
    }

    public void setDateInscription(String dateInscription) {
        this.dateInscription = dateInscription;
    }

    public String getCompteActif() {
        return compteActif;
    }

    public void setCompteActif(String compteActif) {
        this.compteActif = compteActif;
    }

    public String getNewsletter() {
        return newsletter;
    }

    public void setNewsletter(String newsletter) {
        this.newsletter = newsletter;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getClearanceLevel() {
        return clearanceLevel;
    }

    public void setClearanceLevel(String clearanceLevel) {
        this.clearanceLevel = clearanceLevel;
    }

    public String getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(String idCompany) {
        this.idCompany = idCompany;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(String secretQuestion) {
        this.secretQuestion = secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public void setSecretAnswer(String secretAnswer) {
        this.secretAnswer = secretAnswer;
    }

    public static String getCurrentId() {
        return currentId;
    }

    public static void setCurrentId(String currentId) {
        SimpleUser.currentId = currentId;
    }

    public static String getCurrentUsername() {
        return currentUsername;
    }

    public static void setCurrentUsername(String currentUsername) {
        SimpleUser.currentUsername = currentUsername;
    }

    public static String getCurrentPassword() {
        return currentPassword;
    }

    public static void setCurrentPassword(String currentPassword) {
        SimpleUser.currentPassword = currentPassword;
    }

    public static String getCurrentName() {
        return currentName;
    }

    public static void setCurrentName(String currentName) {
        SimpleUser.currentName = currentName;
    }

    public static String getCurrentSurname() {
        return currentSurname;
    }

    public static void setCurrentSurname(String currentSurname) {
        SimpleUser.currentSurname = currentSurname;
    }

    public static String getCurrentEmail() {
        return currentEmail;
    }

    public static void setCurrentEmail(String currentEmail) {
        SimpleUser.currentEmail = currentEmail;
    }

    public static String getCurrentSecretQuestion() {
        return currentSecretQuestion;
    }

    public static void setCurrentSecretQuestion(String currentSecretQuestion) {
        SimpleUser.currentSecretQuestion = currentSecretQuestion;
    }

    public static String getCurrentSecretAnswer() {
        return currentSecretAnswer;
    }

    public static void setCurrentSecretAnswer(String currentSecretAnswer) {
        SimpleUser.currentSecretAnswer = currentSecretAnswer;
    }

    public static String getCurrentPhoto() {
        return currentPhoto;
    }

    public static void setCurrentPhoto(String currentPhoto) {
        SimpleUser.currentPhoto = currentPhoto;
    }

    public static String getCurrentClearanceLevel() {
        return currentClearanceLevel;
    }

    public static void setCurrentClearanceLevel(String currentClearanceLevel) {
        SimpleUser.currentClearanceLevel = currentClearanceLevel;
    }

    public static String getCurrentType() {
        return currentType;
    }

    public static void setCurrentType(String currentType) {
        SimpleUser.currentType = currentType;
    }
    
}
