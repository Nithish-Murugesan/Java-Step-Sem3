
class LeaveRequest {
    String employee;
    String status = "Pending";

    LeaveRequest(String employee) {
        this.employee = employee;
        System.out.println("Leave request submitted for " + employee);
    }

    void review(String decision) {
        if (status.equals("Pending")) {
            status = decision;
            System.out.println(employee + "'s leave " + status);
        } else {
            System.out.println("Cannot change status from " + status);
        }
    }

    void changeStatus(String newStatus) {
        if (!status.equals("Pending")) {
            System.out.println("Cannot change leave request status from "
                    + status + " to " + newStatus);
        } else {
            status = newStatus;
        }
    }
}

public class EmployeeLeaveSystem {
    public static void main(String[] args) {
        LeaveRequest john = new LeaveRequest("John");
        System.out.println("Status: " + john.status);
        john.review("Approved");

        LeaveRequest jane = new LeaveRequest("Jane");
        System.out.println("Status: " + jane.status);
        jane.review("Rejected");

        john.changeStatus("Pending");
    }
}
