package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilValidation 
{
	public static boolean valueValidation(String firstName)
	{
		return UtilValidation.isNull(firstName) && UtilValidation.lengthOfValue(firstName); 
	}
	public static boolean isNull(String value) {
		return value==null;
	}
	public static boolean lengthOfValue(String value) {
		return value.trim().length()==0;
	}
	
	
     //////////////////////////////////////////////////	
	/////////////////   REGEX   ///////////////////////

	public static boolean nameValidation(String firstName)
	{
		String nameRegex="^[A-Za-z]\\w{5,29}$";
		Pattern pNameRegex=Pattern.compile(nameRegex);
		Matcher mFirstName=pNameRegex.matcher(firstName);
		return mFirstName.matches();
	}
	public static boolean emailValidation(String email)
	{
		String emailRegex="(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
		Pattern pEmailRegex=Pattern.compile(emailRegex);
		Matcher mEmail=pEmailRegex.matcher(email);
		return mEmail.matches();
	}
	public static boolean passwordValidation(String password)
	{
		String passwordRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8, 20}$";
		Pattern pPasswordRegex=Pattern.compile(passwordRegex);
		Matcher	mPassword=pPasswordRegex.matcher(password);
		return mPassword.matches();
	}
	public static boolean phoneValidation(String phoneNumber)
	{
		String phoneNumberRegex="^\\d{10}$";
		Pattern pPhoneNeumberRegex=Pattern.compile(phoneNumberRegex);
		Matcher mPhoneNumber=pPhoneNeumberRegex.matcher(phoneNumber);
		return mPhoneNumber.matches();
	}
	public static boolean pincodeValidaition(String pincode)
	{
		String pinCodeRegex="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
		Pattern pPinCodeRegex=Pattern.compile(pinCodeRegex);
		Matcher mPincode=pPinCodeRegex.matcher(pincode);
		return mPincode.matches();
	}
	public static boolean HouseNoValidaition(String HouseNumber)
	{
		String numberOnlyRegex="^[0-9]{1,4}$";
		Pattern pHouseNumberRegex=Pattern.compile(numberOnlyRegex);
		Matcher mHouseNumber=pHouseNumberRegex.matcher(HouseNumber);
		return mHouseNumber.matches();
	}

}

//	Pattern pLandmarkRegex=Pattern.compile(nameRegex);
//	Pattern pCityRegex=Pattern.compile(nameRegex);
//	Pattern pStateRegex=Pattern.compile(nameRegex);
	
	
	

//	Matcher mLastName=pNameRegex.matcher(lastName);
//	Matcher mLandmark=pNameRegex.matcher(Landmark);
//	Matcher mcity=pNameRegex.matcher(city);
//	Matcher mState=pNameRegex.matcher(state);
//	Matcher mCountry=pNameRegex.matcher(country);
	

//	Matcher	mConfirmPassword=pPasswordRegex.matcher(Confirmpassword);
