import java.util.*;
import java.io.*;

class MainMenu {
    public void menu() {
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t  EMPLOYEE MANAGEMENT SYSTEM");
        System.out.println("\t\t*******************************************");
        System.out.println("\t\t\t    --------------------");
        System.out.println("\n\nPress 1 : To Add an Employee Details");
        System.out.println("Press 2 : To See an Employee Details ");
        System.out.println("Press 3 : To Remove an Employee");
        System.out.println("Press 4 : To Update Employee Details");
        System.out.println("Press 5 : To Exit the EMS Portal");
    }
}

class Employee_Add {
    public void createFile() {
        Scanner sc = new Scanner(System.in);
        Employee_Detail emp = new Employee_Detail();
        emp.getInfo();

        try {
            File f1 = new File("File" + emp.employ_id + ".txt");
            if (f1.createNewFile()) {
                FileWriter fw = new FileWriter("File" + emp.employ_id + ".txt");
                fw.write(
                        "Employee ID:" + emp.employ_id + "\n" +
                                "Employee Name     :" + emp.name + "\n" +
                                "Father's Name     :" + emp.father_name + "\n" +
                                "Employee Contact  :" + emp.employ_contact + "\n" +
                                "Email Information :" + emp.email + "\n" +
                                "Employee position :" + emp.position + "\n" +
                                "Employee Salary   :" + emp.employ_salary);
                fw.close();
                System.out.println("\nEmployee has been Added :)\n");

                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            } else {
                System.out.println("\nEmployee already exists :(");
                System.out.print("\nPress Enter to Continue...");
                sc.nextLine();
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

class Employee_Detail {
    String name;
    String father_name;
    String email;
    String position;
    String employ_id;
    String employ_salary;
    String employ_contact;

    public void getInfo() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Employee's name --------: ");
        this.name = sc.nextLine();
        System.out.print("Enter Employee's Father name -: ");
        this.father_name = sc.nextLine();
        System.out.print("Enter Employee's ID ----------: ");
        this.employ_id = sc.nextLine();
        System.out.print("Enter Employee's Email ID ----: ");
        this.email = sc.nextLine();
        System.out.print("Enter Employee's Position ----: ");
        this.position = sc.nextLine();
        System.out.print("Enter Employee contact Info --: ");
        this.employ_contact = sc.nextLine();
        System.out.print("Enter Employee's Salary ------: ");
        this.employ_salary = sc.nextLine();
    }
}

class Employee_Show {

    public void view_file(String s) throws Exception {

        File file = new File("File" + s + ".txt");
        Scanner sc = new Scanner(file);

        while (sc.hasNextLine()) {
            System.out.println(sc.nextLine());
        }
    }
}

class Employee_Remove {

    public void removeFile(String ID) {

        File file = new File("File"+ID+".txt");
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("\nEmployee has been removed successfully");
            }
        } else {
            System.out.println("\nEmployee does not exists :( ");
        }
    }
}

class Employee_Update {
    public void updateFile(String ID, String old, String neww) throws IOException {

        File file = new File("File" + ID + ".txt");

        if (!file.exists()) {
            System.out.println("Employee with " + ID + " does not exist!");
        } else {
            Scanner sc = new Scanner(file);
            String newFile = "";
            while (sc.hasNextLine()) {
                newFile = newFile + "\n" + sc.nextLine();
            }
            FileWriter myWriter = new FileWriter("File" + ID + ".txt");
            newFile = newFile.replaceAll(old, neww);
            myWriter.write(newFile);
            myWriter.close();
        }
    }
}

class Code_Exit {

    public void out() {
        System.out.println("\n*****************************************");
        System.out.println("Thank You For using Employee Management System");
        System.out.println("*****************************************");
        System.exit(0);
    }
}

public class EmployManagementSystem {

    public static void main(String[] args) {

        /** ANSI escape code To clear the output Screen **/
        System.out.println("\033[H\033[2J");
        Scanner sc = new Scanner(System.in);

        Employee_Show empShow = new Employee_Show();

        int i = 0;

        MainMenu mainMenu = new MainMenu();
        mainMenu.menu();

        while (i < 6) {
            System.out.print("\nPlease Enter choice :");
            i = Integer.parseInt(sc.nextLine());

            switch (i) {

                case 1: {
                    Employee_Add ep = new Employee_Add();
                    ep.createFile();

                    System.out.print("\033[H\033[2J");
                    mainMenu.menu();
                    break;
                }

                case 2: {
                    System.out.print("\nPlease Enter Employee's ID :");
                    String s = sc.nextLine();

                    try {
                        empShow.view_file(s);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    mainMenu.menu();
                    break;
                }

                case 3: {
                    System.out.print("\nPlease Enter Employee's ID :");
                    String s = sc.nextLine();

                    Employee_Remove epr = new Employee_Remove();
                    epr.removeFile(s);

                    System.out.print("\nPress Enter to Continue...");
                    sc.nextLine();
                    System.out.print("\033[H\033[2J");
                    mainMenu.menu();
                    break;
                }

                case 4: {
                    System.out.print("\nPlease Enter Employee's ID :");
                    String s = sc.nextLine();

                    

                    try {
                        empShow.view_file(s);
                    } catch (Exception e) {
                        System.out.println(e);
                    }

                    Employee_Update epu = new Employee_Update();

                    System.out.print("Please Enter the detail you want to Update :");
                    System.out.print("\nFor Example :\n");
                    System.out.println(
                            "If you want to Change the Name, then Enter Current Name and Press Enter. Then write the new Name then Press Enter. It will Update the Name.\n");
                    String old = sc.nextLine();
                    System.out.print("Please Enter the Updated Info :");
                    String neww = sc.nextLine();

                    try {
                        epu.updateFile(s, old, neww);

                        System.out.print("\nPress Enter to Continue...");
                        sc.nextLine();
                        System.out.print("\033[H\033[2J");
                        mainMenu.menu();
                        break;
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                }

                case 5: {
                    Code_Exit ce = new Code_Exit();
                    ce.out();
                }
            }
        }

    }
}
