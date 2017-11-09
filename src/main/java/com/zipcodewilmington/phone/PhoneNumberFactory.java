package com.zipcodewilmington.phone;

import com.zipcodewilmington.exceptions.InvalidPhoneNumberFormatException;
import com.zipcodewilmington.tools.RandomNumberFactory;

import java.util.logging.Logger;


/**
 * Created by leon on 5/1/17.
 */
public final class PhoneNumberFactory {
    private static final Logger logger = Logger.getGlobal();

    private PhoneNumberFactory() {
        /** This constructor is private
         *  This class is uninstantiable */
    }

    /**
     * @param phoneNumberCount - number of PhoneNumber objects to instantiate
     * @return array of randomly generated PhoneNumber objects
     */ //TODO - Implement logic
    public static PhoneNumber[] createRandomPhoneNumberArray(int phoneNumberCount) {
        PhoneNumber [] phoneNumbers=new PhoneNumber[phoneNumberCount];
        for(int i=0; i<phoneNumberCount;i++)
            phoneNumbers[i]=createRandomPhoneNumber();
        return phoneNumbers;
    }

    /**
     * @return an instance of PhoneNumber with randomly generated phone number value
     */ //TODO - Implement logic
    private static PhoneNumber createRandomPhoneNumber() {

        int areaCode= RandomNumberFactory.createInteger(101,1000);
        int centralOfficeCode= RandomNumberFactory.createInteger(101,1000);
        int phoneLineCode= RandomNumberFactory.createInteger(1001,10000);
        return createPhoneNumberSafely(areaCode-1, centralOfficeCode-1, phoneLineCode-1);
    }


    /**
     * @param areaCode          - 3 digit code
     * @param centralOfficeCode - 3 digit code
     * @param phoneLineCode     - 4 digit code
     * @return a new phone number object
     */ //TODO - if input is valid, return respective PhoneNumber object, else return null
    public static PhoneNumber createPhoneNumberSafely(int areaCode, int centralOfficeCode, int phoneLineCode) {
        String phoneNumberString="("+areaCode+")-"+centralOfficeCode+"-"+phoneLineCode;
        try{
            return createPhoneNumber(phoneNumberString);
        }catch (InvalidPhoneNumberFormatException e){
            assert (true):phoneNumberString+ " is not a valid phone number";
            return null;
        }

    }

    /**
     * @param phoneNumberString - some String corresponding to a phone number whose format is `(###)-###-####`
     * @return a new phone number object
     * @throws InvalidPhoneNumberFormatException - thrown if phoneNumberString does not match acceptable format
     */ // TODO - Add throws statement to method signature
    public static PhoneNumber createPhoneNumber(String phoneNumberString) throws InvalidPhoneNumberFormatException {

        try {
            assert (true):"Attempting to create a new PhoneNumber object with a value of "+phoneNumberString;
            PhoneNumber phoneNumber = new PhoneNumber(phoneNumberString);
            return phoneNumber;
        } catch (InvalidPhoneNumberFormatException e) {
            throw new InvalidPhoneNumberFormatException();
        }
    }
}
