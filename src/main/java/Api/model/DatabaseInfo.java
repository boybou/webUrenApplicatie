package Api.model;

/**
 * Created by Boy.
 * This model represents the database info that corrisponds with the databasecolumns
 */
public class DatabaseInfo {

    public final static String projectTableName = "Project";
    public class ProjectColumnNames{
        public static final String name = "project_name";
        public static final String number = "project_number";
        public static final String clientName = "project_client_name";
    }
    public static final String employeeRoleTableName = "Employee_role";
    public class EmployeeRoleColumnNames{
        public static final String roleName = "employee_role_role_name";
    }
    public static final String employeeTypeTableName = "Employee_type";
    public class EmployeeTypeColumnNames{
        public static final String typeName = "employee_type_type_name";
    }
    public static final String employeeTableName = "Employee";
    public class EmployeeColumnNames{
        public static final String firstName = "employee_firstname";
        public static final String lastName = "employee_lastname";
        public static final String typeName = "employee_type_name";
        public static final String employeeNumber = "employee_employee_number";
        public static final String roleName = "employee_role_name";
        public static final String active = "employee_active";
    }
    public static final String loginDataTableName = "Login_Data";
    public class LoginDataColumnNames{
        public static final String password = "login_data_password";
        public static final String email = "login_data_email";
        public static final String employeeNumber = "login_data_employee_number";
    }
    public static final String clientTableName = "Client";
    public class ClientColumnNames{
        public static final String name = "client_name";
    }
    public static final String subprojectTableName = "Subproject";
    public class SubprojectColumnNames{
        public static final String name = "subproject_name";
        public static final String projectNumber = "subproject_project_number";
        public static final String number = "subproject_number";
    }
    public static final String hourStatusTableName = "Hour_status";
    public class HourStatusColumnNames{
        public static final String status = "hour_status_status";
    }
    public static final String hourTableName = "Hour";
    public class HourColumnNames{
        public static final String id = "hour_id";
        public static final String approved = "hour_approved";
        public static final String subprojectNumber = "hour_subproject_number";
        public static final String employeeNumber = "hour_employee_number";
        public static final String date = "hour_date";
        public static final String amountOfHours = "hour_amount_of_hours";
        public static final String starttime = "hour_starttime";
        public static final String endtime = "hour_endtime";
        public static final String comments = "hour_comments";
    }


}
