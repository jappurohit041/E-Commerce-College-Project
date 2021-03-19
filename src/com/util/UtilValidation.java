package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UtilValidation 
{
	public static boolean valueValidation(String firstName)
	{
		return UtilValidation.isNull(firstName) || UtilValidation.lengthOfValue(firstName); 
	}
	public static boolean isNull(String value) {
		return value==null;
	}
	public static boolean lengthOfValue(String value) {
		return value.trim().length()==0;
	}

	public static boolean nameValidation(String firstName)
	{
		String nameRegex="^[A-Za-z]\\w{2,29}$";
		Pattern pNameRegex=Pattern.compile(nameRegex);
		Matcher mFirstName=pNameRegex.matcher(firstName);
		return !mFirstName.matches();
	}

	public static boolean emailValidation(String email)
	{
		String emailRegex="^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		Pattern pEmailRegex=Pattern.compile(emailRegex);
		Matcher mEmail=pEmailRegex.matcher(email);
		return !mEmail.matches();
	}
	public static boolean passwordValidation(String password)
	{
		String passwordRegex="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
		Pattern pPasswordRegex=Pattern.compile(passwordRegex);
		Matcher	mPassword=pPasswordRegex.matcher(password);
		return !mPassword.matches();
	}
	public static boolean phoneValidation(String phoneNumber)
	{
		String phoneNumberRegex="^\\d{10}$";
		Pattern pPhoneNeumberRegex=Pattern.compile(phoneNumberRegex);
		Matcher mPhoneNumber=pPhoneNeumberRegex.matcher(phoneNumber);
		return !mPhoneNumber.matches();
	}
	public static boolean pincodeValidaition(String pincode)
	{
		String pinCodeRegex="^[1-9]{1}[0-9]{2}\\s{0,1}[0-9]{3}$";
		Pattern pPinCodeRegex=Pattern.compile(pinCodeRegex);
		Matcher mPincode=pPinCodeRegex.matcher(pincode);
		return !mPincode.matches();
	}
	public static boolean HouseNoValidaition(String HouseNumber)
	{
		String numberOnlyRegex="^\\s*[\\da-zA-Z][\\da-zA-Z\\s]*$";
		Pattern pHouseNumberRegex=Pattern.compile(numberOnlyRegex);
		Matcher mHouseNumber=pHouseNumberRegex.matcher(HouseNumber);
		return !mHouseNumber.matches();
	}

	public static boolean pincodeValidation(String pincode)
	{
			return !(UtilValidation.isNull(pincode) && UtilValidation.lengthOfValue(pincode)); 
	}
	public static boolean countryValidation(String country)
		{
				return !(UtilValidation.isNull(country) && UtilValidation.lengthOfValue(country)); 
		}
		public static boolean phoneNumberValidation(String phoneNumber)
		{
				return !(UtilValidation.isNull(phoneNumber) && UtilValidation.lengthOfValue(phoneNumber)); 
		}
		public static boolean securityQuestionValidation(String securityQuestion)
		{
				return !(UtilValidation.isNull(securityQuestion) && UtilValidation.lengthOfValue(securityQuestion)); 
		}
		public static boolean secrityAnswerValidation(String secrityAnswer)
		{
				return !(UtilValidation.isNull(secrityAnswer) && UtilValidation.lengthOfValue(secrityAnswer)); 
		}
		
	public static void main(String[] args) {
	//	String s="Jap" ;
		//System.out.println("Is Null: "+UtilValidation.isNull(s));
	//	System.out.println("Length: "+UtilValidation.lengthOfValue(s));
	//	System.out.println("Value validation: "+UtilValidation.valueValidation(s));
	//	System.out.println("Name validation: "+UtilValidation.emailValidation(s));
	//	System.out.println("Inside if condition: "+(UtilValidation.valueValidation(s) && UtilValidation.emailValidation(s)));
	}
}
