package com.util;
public class UtilValidation 
{
	public static boolean firstNameValidation(String firstName)
	{
		return UtilValidation.isNull(firstName) && UtilValidation.lengthOfValue(firstName); 
	}
	public static boolean isNull(String value) {
		return value==null;
	}
	public static boolean lengthOfValue(String value) {
		return value.trim().length()==0;
	}
	
	
	public static boolean lastNameValidation(String Lastname)
	{	
			return UtilValidation.isNull(Lastname) && UtilValidation.lengthOfValue(Lastname); 
	}
	public static boolean emailValidation(String email)
	{
			return UtilValidation.isNull(email) && UtilValidation.lengthOfValue(email); 
	}
	public static boolean dobValidation(String dob)
	{	
			return UtilValidation.isNull(dob) && UtilValidation.lengthOfValue(dob); 
	}
	public static boolean passwordValidation(String password)
	{
			return UtilValidation.isNull(password) && UtilValidation.lengthOfValue(password); 
	}
	public static boolean ConfirmpasswordValidation(String Confirmpassword)
	{
			return UtilValidation.isNull(Confirmpassword) && UtilValidation.lengthOfValue(Confirmpassword); 	
	}
	public static boolean houseNumberValidation(String HouseNumber)
	{
			return UtilValidation.isNull(HouseNumber) && UtilValidation.lengthOfValue(HouseNumber); 
	}
	public static boolean LandmarkValidation(String Landmark)
	{
			return UtilValidation.isNull(Landmark) && UtilValidation.lengthOfValue(Landmark); 
	}
	public static boolean cityValidation(String city)
	{
			return UtilValidation.isNull(city) && UtilValidation.lengthOfValue(city); 
	}
	public static boolean stateValidation(String state)
	{
				return UtilValidation.isNull(state) && UtilValidation.lengthOfValue(state); 
	}
	public static boolean pincodeValidation(String pincode)
	{
			return UtilValidation.isNull(pincode) && UtilValidation.lengthOfValue(pincode); 
	}
	public static boolean countryValidation(String country)
		{
				return UtilValidation.isNull(country) && UtilValidation.lengthOfValue(country); 
		}
		public static boolean phoneNumberValidation(String phoneNumber)
		{
				return UtilValidation.isNull(phoneNumber) && UtilValidation.lengthOfValue(phoneNumber); 
		}
		public static boolean securityQuestionValidation(String securityQuestion)
		{
				return UtilValidation.isNull(securityQuestion) && UtilValidation.lengthOfValue(securityQuestion); 
		}
		public static boolean secrityAnswerValidation(String secrityAnswer)
		{
				return UtilValidation.isNull(secrityAnswer) && UtilValidation.lengthOfValue(secrityAnswer); 
		}
		
		public static void main(String[] args) {
			System.out.println("Hello");
		}
}
