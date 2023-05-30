package gov.irrigation.util;

import java.util.HashMap;
import java.util.Map;

public class Constants {
    public static final String TOKEN_TYPE = "Bearer ";
    public static final String DEFAULT_PAGE_NUMBER = "0";
    public static final String DEFAULT_PAGE_SIZE = "20";
    public static final String DEFAULT_SORT_COLUMN = "id";

    public static final class TemplateType {
        private TemplateType() {

        }
        public static final String SMS = "SMS";
        public static final String REQUEST_REJECT ="REQUEST_REJECT";
        public static final String REQUEST_SEND = "REQUEST_SEND";
        public static final String REQUEST_PENDING ="REQUEST_PENDING";



    }

    public static final class MessageType {
        private MessageType() {

        }

        public static final String EMAIL_TYPE_MESSAGE = "EMAIL";
        public static final String SMS_TYPE_MESSAGE = "SMS";

    }

    public static final String FILE_SIZE_EXCEEDED = "FILE_SIZE_EXCEEDED";

    public static final class ErrorKeys {
        private ErrorKeys() {

        }
        public static final String APPLICATION_ID_NOT_FOUND = "APPLICATION_ID_NOT_FOUND";

        public static final String ERROR_UNAUTHORIZED = "ERROR_UNAUTHORIZED";
        public static final String APP_ID_DOESNT_EXIST = "APP_ID_DOESNT_EXIST";
        public static final String EMAIL_REQUIRED = "EMAIL_REQUIRED";
        public static final String MOBILE_COUNTRY_REQUIRED = "MOBILE_COUNTRY_REQUIRED";
        public static final String MOBILE_REQUIRED = "MOBILE_REQUIRED";
        public static final String USER_GROUP_REQUIRED = "USER_GROUP_REQUIRED";
        public static final String PERSON_TYPE_NOT_EXISTS = "PERSON_TYPE_NOT_EXISTS";
        public static final String PLACE_OF_RESIDENCE_REQUIRED = "PLACE_OF_RESIDENCE_REQUIRED";
        public static final String BUILDING_NUMBER_REQUIRED = "BUILDING_NUMBER_REQUIRED";
        public static final String CITY_REQUIRED = "CITY_REQUIRED";
        public static final String STREET_NAME_REQUIRED = "STREET_NAME_REQUIRED";
        public static final String POSTAL_CODE_REQUIRED = "POSTAL_CODE_REQUIRED";
        public static final String POWER_OF_ATTORNEY_REQUIRED = "POWER_OF_ATTORNEY_REQUIRED";

        public static final String NO_DATA_FOUND_FOR_IDENTIFIER_AND_CUSTOMER_ID = "NO_DATA_FOUND_FOR_IDENTIFIER_AND_CUSTOMER_ID";
        public static final String POWER_OF_ATTORNEY_INVALID = "POWER_OF_ATTORNEY_INVALID";

        public static final String YOU_ARE_NOT_AUTHORIZED = "YOU_ARE_NOT_AUTHORIZED";
        public static final String USER_NOT_AUTHORIZED = "USER_NOT_AUTHORIZED";
        public static final String DISTRICT_REQUIRED = "DISTRICT_REQUIRED";
        public static final String FIRST_NAME_AR_REQUIRED = "FIRST_NAME_AR_REQUIRED";
        public static final String FIRST_NAME_EN_REQUIRED = "FIRST_NAME_EN_REQUIRED";
        public static final String FATHER_NAME_AR_REQUIRED = "FATHER_NAME_AR_REQUIRED";
        public static final String FATHER_NAME_EN_REQUIRED = "FATHER_NAME_EN_REQUIRED";
        public static final String FAMILY_NAME_AR_REQUIRED = "FAMILY_NAME_AR_REQUIRED";
        public static final String FAMILY_NAME_EN_REQUIRED = "FAMILY_NAME_EN_REQUIRED";
        public static final String ORGANIZATION_NAME_AR_REQUIRED = "ORGANIZATION_NAME_AR_REQUIRED";
        public static final String ORGANIZATION_NAME_EN_REQUIRED = "ORGANIZATION_NAME_EN_REQUIRED";
        public static final String NATIONALITY_AR_REQUIRED = "NATIONALITY_AR_REQUIRED";
        public static final String LICENCED_TO_PRACTICE_REQUIRED = "LICENCED_TO_PRACTICE_REQUIRED";
        public static final String CUSTOMER_STATUS_REQUIRED = "CUSTOMER_STATUS_REQUIRED";

        public static final String NUMBER_OF_POA_REQUIRED = "NUMBER_OF_POA_REQUIRED";
        public static final String IDENTIFIER_REQUIRED = "IDENTIFIER_REQUIRED";
        public static final String PASSPORT_NUMBER_REQUIRED = "PASSPORT_NUMBER_REQUIRED";
        public static final String PASSPORT_ATTACHMENT_ID = "PASSPORT_ATTACHMENT_ID";
        public static final String PASSPORT_EXPIRY_DATE_REQUIRED = "PASSPORT_EXPIRY_DATE_REQUIRED";
        public static final String EXCEPTION_RECORD_NOT_FOUND = "EXCEPTION_RECORD_NOT_FOUND";
        public static final String NOTIFICATION_TEMPLATE_TYPE_REQUIRED = "NOTIFICATION_TEMPLATE_TYPE_REQUIRED";
        public static final String NOTIFICATION_MESSAGE_TYPE_REQUIRED = "NOTIFICATION_MESSAGE_TYPE_REQUIRED";
        public static final String NOTIFICATION_DESTINATION_REQUIRED = "NOTIFICATION_DESTINATION_REQUIRED";
        public static final String NOTIFICATION_TEMPLATE_PARAMETERS_REQUIRED = "NOTIFICATION_TEMPLATE_PARAMETERS_REQUIRED";
        public static final String EMAIL_DUPLICATED = "EMAIL_DUPLICATED";
        public static final String IDENTIFIER_DUPLICATED = "IDENTIFIER_DUPLICATED";
        public static final String ORGANIZATION_DOES_NOT_EXIST = "ORGANIZATION_DOES_NOT_EXIST";
        public static final String APP_INFO_ALREADY_EXISTS = "APP_INFO_ALREADY_EXISTS";
        public static final String Priority_Expired = "Priority_Expired";
        public static final String ORGANIZATION_USER_DOES_NOT_EXIST = "ORGANIZATION_USER_DOES_NOT_EXIST";
        public static final String CUSTOMER_DOES_NOT_EXIST = "CUSTOMER_DOES_NOT_EXIST";
        public static final String USER_REQUIRED = "USER_REQUIRED";
        public static final String PHONE_REQUIRED = "PHONE_REQUIRED";
        public static final String IDENTIFIER_NOT_FOUND = "IDENTIFIER_DUPLICATED";
        public static final String USER_ALREADY_ASSIGNED = "USER_ALREADY_ASSIGNED";

        public static final String CUSTOMER_ACTIVE_STATUS_CANNOT_CHANGED = "CUSTOMER_ACTIVE_STATUS_CANNOT_CHANGED";
        public static final String CUSTOMER_REJECTED_STATUS_CANNOT_CHANGED = "CUSTOMER_REJECTED_STATUS_CANNOT_CHANGED";

        public static final String ORGANIZATION_USER_ACTIVATION_CODE_DOES_NOT_EXIST = "ORGANIZATION_USER_ACTIVATION_CODE_DOES_NOT_EXIST";

        public static final String USER_CANNOT_DELETE_HIM_SELF = "USER_CANNOT_DELETE_HIM_SELF";

        public static final String ATTORNEY_ERROR_MESSAGE_ENGLISH = "error message";

        public static final String ATTORNEY_ERROR_MESSAGE_ARABIC = "رسالة الخطأ";

        public static final String POA_NUMBER_REQUIRED = "POA_NUMBER_REQUIRED";

        public static final String PERSON_IDENTIFIER_IS_NOT_VALID = "PERSON_IDENTIFIER_IS_NOT_VALID";
        public static final String ORGANIZATION_IDENTIFIER_IS_NOT_VALID = "ORGANIZATION_IDENTIFIER_IS_NOT_VALID";

        public static final String FILE_SIZE_EXCEEDED = "FILE_SIZE_EXCEEDED";

        public static final String FILE_EXTENSION_NOT_VALID = "FILE_EXTENSION_NOT_VALID";

        public static final String GENERAL_ERROR_MESSAGE = "GENERAL_ERROR_MESSAGE";

        public static final String DOCUMENT_ID_NOT_FOUND = "DOCUMENT_ID_NOT_FOUND";

        public static final String SOME_OF_CODES_NOT_RETURNED = "SOME_OF_CODES_NOT_RETURNED";

        public static final String CLASSIFICATION_NOT_FOUND = "CLASSIFICATION_NOT_FOUND";

    }

    public static final class SuccessMessages {
        private SuccessMessages() {

        }

        public static final String ATTORNEY_VALID_DATE_MESSAGE_ENGLISH = "Valid attorney number";
        public static final String ATTORNEY_VALID_DATE_MESSAGE_ARABIC = "تم التأكد من رقم التفويض";
        public static final String ATTORNEY_EXPIRED_DATE_MESSAGE_ENGLISH = "Expired attorney number";
        public static final String ATTORNEY_EXPIRED_DATE_MESSAGE_ARABIC = "رقم التوفيض منتهي الصلاحية";
    }

    public static final class AttorneyMessages {
        private AttorneyMessages() {

        }

        public static final Map<String, String> map = new HashMap<>();

        static {
            map.put("MOJINT1001", "Success");
            map.put("MOJINT1002", "Success With No Data");
            map.put("MOJINT1003", "Success with Comments");
            map.put("MOJINT2001", "Input Validation Issue");
            map.put("MOJINT2002", "Retrieval Input Validation Issue");
            map.put("MOJINT2003", "Header Input Validation Issue");
            map.put("MOJINT2004", "Conflict Business Input Validation Issue");
            map.put("MOJINT3001", "Security Failure");
            map.put("MOJINT3002", "Authentication Failure");
            map.put("MOJINT3003", "Authorization Issue");
            map.put("MOJINT4001", "Failure in Retrieval");
            map.put("MOJINT4002", "Failure in DB Save");
            map.put("MOJINT4003", "Failure of web service call");
            map.put("MOJINT5001", "Exception");
            map.put("MOJINT5002", "Internal System Exception");
            map.put("MOJINT7001", "Internal Issue");
            map.put("MOJINT7002", "Internal service Unresponsive");
        }
    }

    public static final class EventDriven {
        private EventDriven() {

        }

        public static final String QUEUE_NAME = "notification";

    }

    private Constants() {

    }



    public static final class MailSubject {


        private MailSubject() {


        }


        public static final String ACCEPTANCE_SUBJECT = "طلب مقبول";


        public static final String REJECTION_SUBJECT = "طلب مرفوض";

        public static final String PENDING_SUBJECT = "طلب معلق";

    }

    public static final class MailMessage {


        private MailMessage() {


        }

        public static final String ACCEPTANCE_MESSAGE = "ACCEPTANCE_MESSAGE";


        public static final String REJECTION_MESSAGE = "REJECTION_MESSAGE";

        public static final String PENDING_MESSAGE = "PENDING_MESSAGE";


    }


    public static final String ACTIVATION_ALLOWANCE_DAYS_COUNT = "ACTIVATION_ALLOWANCE_DAYS_COUNT";
}
