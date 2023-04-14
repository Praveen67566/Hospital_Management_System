
//package hospital_management;
import java.util.*;
import java.util.ArrayList;
import java.time.*;
interface Manager {
    void welcome_page();
    void login_as_admin();
}

interface User{
    void login_as_patient();
    void registration();
    void login_patient();
    void Book_an_appointment();
    void All_appointment();
}

class Doctor{
    private String name;
    private String speciality;

    public Doctor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    @Override
    public String toString() {
        return "{ " + name + " : " + speciality + "}";
    }

    public static void doctor_list_creation() {
        ArrayList<Doctor> doctor_list = new ArrayList<Doctor>();
        Doctor d1 = new Doctor("Rohan", "Cardiologist");
        Doctor d2 = new Doctor("Rohit", "Cardiologist");
        Doctor d3 = new Doctor("Rajat", "Cardiologist");
        Doctor d4 = new Doctor("Aman", "Cardiologist");
        Doctor d5 = new Doctor("Rajesh", "Cardiologist");
        Doctor d6 = new Doctor("Praveen", "Cardiologist");

        doctor_list.add(d1);
        doctor_list.add(d2);
        doctor_list.add(d3);
        doctor_list.add(d4);
        doctor_list.add(d5);
        doctor_list.add(d6);

        Iterator itr = doctor_list.iterator();
        while (itr.hasNext()) {
            System.out.println("\t\t\t" + itr.next());
        }
    }
}

class Patient implements User{
    String name;
    int age;
    String problem;
    Long mob_no;

    ArrayList<Patient> patient_list = new ArrayList<Patient>();
    HashMap hm = new HashMap();
    Scanner scan = new Scanner(System.in);
    String user = "Praveen";
    int pass = 2023;
    int i = 0;

    @Override
    public String toString() {
        return "{ " + name + " : " + problem + "}";
    }

    public void login_as_patient() {
        System.out.println("\t\t\tAre you already register?\n\t\t\t(Y/N)");
        System.out.print("\t\t\t");
        String choice = scan.next();
        switch (choice) {
            case "Y":
                login_patient();
                break;
            case "N":
                registration();
                break;
            default:
                System.out.println("\t\t\tYou choose Wrong option");
                break;

        }
    }

    public void registration() {
        Patient p1 = new Patient();
        try {
            System.out.print("\t\t\tEnter your name:");
            p1.name = scan.next();
            System.out.println();
            System.out.print("\t\t\tEnter your age:");
            p1.age = scan.nextInt();
            System.out.println();
            System.out.print("\t\t\tEnter your problem:");
            p1.problem = scan.next();
            System.out.println();
            System.out.print("\t\t\tEnter your mob_no:");
            p1.mob_no = scan.nextLong();
        } catch (Exception e) {
            System.out.println("\t\t\tYou choose Wrong option");
        }
        System.out.println();
        System.out.println("\t\t\tRegistration Done");
        patient_list.add(p1);
        try {

            set_username();
        } catch (Exception e) {
            System.out.println("\t\t\tYou choose Wrong option");
        }
        try {
            set_password();
        } catch (Exception e) {
            System.out.println("\t\t\tYou choose Wrong option");
        }
        System.out.println("\t\t\t1.You want to Login\n\t\t\t2.Exit");
        System.out.print("\t\t\t");
        int key = scan.nextInt();
        switch (key) {
            case 1:
                login_patient();
                break;
            case 2:
                Admin a = new Admin();
                a.welcome_page();
                break;
            default:
                System.out.println("\t\t\tYou choose Wrong option");
                break;
        }
    }

    public void login_patient() {
        System.out.print("\t\t\tUser_Name:");
        String user1 = scan.next();
        System.out.println();
        System.out.print("\t\t\tPassword:");
        int pass1 = scan.nextInt();
        System.out.println();
        if (user.equals(user1) && pass == pass1) {
            System.out.println("\t\t\tLogged in");
            System.out.println("\t\t\t1.Book_an_appointment\n\t\t\t2.All_appointment\n\t\t\t3.Logout");
            System.out.print("\t\t\t");
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    Book_an_appointment();
                    break;
                case 2:
                    All_appointment();
                    break;
                case 3:
                    Admin a = new Admin();
                    a.welcome_page();
                    break;
                default:
                    System.out.println("\t\t\tYou choose Wrong option");
            }

        } else {
            System.out.println("\t\t\t###Wrong Password Or User_name###");
        }
    }

    public void set_username() {
        System.out.print("\t\t\tSet your User_name:");
        user = scan.next();
        System.out.println();
    }

    public void set_password() {
        System.out.print("\t\t\tSet your Password:");
        pass = scan.nextInt();
        System.out.println();
    }

    public void Book_an_appointment() {
        System.out.print("\t\t\tEnter your name:");
        name = scan.next();
        System.out.print("\t\t\tEnter your Date:");
        int date = scan.nextInt();
        System.out.print("\t\t\tEnter your Month:");
        int Month = scan.nextInt();
        System.out.print("\t\t\tEnter your Year:");
        int Year = scan.nextInt();
        hm.put(i, name);
        i++;
        if (date <= 30 && Month <= 12 && Year == 2023) {
            System.out.println("\t\t\tYour appointment Booked at : " + date + "/" + Month + "/" + Year);
            System.out.println("\t\t\t" + hm);
        } else {
            System.out.println("\t\t\tPlease Enter Right option");
        }

    }

    public void All_appointment() {
        System.out.println("\t\t\tAll_appointments are: ");
        System.out.println("\t\t\t" + hm);
    }
}
class Admin extends Patient implements Manager {
    private final String user_name = "Praveen@12";
    private final int pass_word = 1786;
    Scanner scan = new Scanner(System.in);
    LocalDate Date = LocalDate.now();
    LocalTime time = LocalTime.now();

    public void welcome_page() {
        System.out.println("\t\t\t***********************************************************");
        System.out.println("\t\t\t\tWelcome To Hospital Management System");
        System.out.print("\t\t\tDate:" + Date + "                    Time:" + time);
        System.out.println();
        System.out.println("\t\t\t1.Login_as_Admin\n\t\t\t2.Login_as_Patient");
        System.out.println();
        System.out.print("\t\t\t");
        int choice = scan.nextInt();
        switch (choice) {
            case 1:
                try {
                    login_as_admin();
                    break;
                } catch (Exception e) {
                    System.out.println("\t\t\tYou choose Wrong option");
                }

            case 2:
                login_as_patient();
                break;
            default:
                System.out.println("\t\t\tYou choose Wrong option");
        }
        System.out.println("\t\t\t***********************************************************");
    }

    public void login_as_admin() {
        System.out.print("\t\t\tUser_Name:");
        String user = scan.next();
        System.out.println();
        System.out.print("\t\t\tPassword:");
        int pass = scan.nextInt();
        System.out.println();
        if (user.equals(user_name) && pass == pass_word) {
            System.out.println("\t\t\tLogged in");
            System.out.println("\t\t\t1.Check_Doctor_Details\n\t\t\t2.Check_Patient_Details");
            System.out.print("\t\t\t");
            int key = scan.nextInt();
            switch (key) {
                case 1:
                    Doctor.doctor_list_creation();
                    break;
                case 2:
                    System.out.println("\t\t\t" + patient_list);
                    break;
                default:
                    System.out.println("\t\t\tYou choose Wrong option");

            }

        } else {
            System.out.println("\t\t\t###Wrong Password Or User_name###");
        }
    }

}

public class Launch_hms1 {
    public static void main(String[] args) {
        Admin a = new Admin();
        int i = 0;
        while (i < 3) {
            a.welcome_page();
            i++;
        }

    }
}