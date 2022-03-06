package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.Department;
import org.javaboy.meeting.model.Employee;
import org.javaboy.meeting.model.Meeting;
import org.javaboy.meeting.model.MeetingRoom;
import org.javaboy.meeting.service.DepartmentService;
import org.javaboy.meeting.service.EmployeeService;
import org.javaboy.meeting.service.MeetingRoomService;
import org.javaboy.meeting.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MeetingController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private MeetingService meetingService;

    @RequestMapping("/bookmeeting")
    public String bookMeeting(Model model) {

        List<MeetingRoom> meetingRoomNames = meetingRoomService.getAllMeetingRoomName();
        model.addAttribute("roomNames", meetingRoomNames);
        return "bookmeeting";
    }

    @RequestMapping("/getAllDeps")
    @ResponseBody
    public List<Department> getAllDeps() {
        return departmentService.getAllDep();
    }

    @RequestMapping("/getEmpByDepId")
    @ResponseBody
    public List<Employee> getEmpByDepId(Integer depId) {
        return employeeService.getEmpByDepId(depId);
    }

    @RequestMapping("/doAddMeeting")
    public String doAddMeeting(Meeting meeting, Integer[] mps, HttpSession session) {
        Employee currentUser = (Employee) session.getAttribute("currentUser");
        meeting.setReservationistid(currentUser.getEmployeeid());
        Integer result = meetingService.addMeeting(meeting, mps);
        if (result == 1) {
            return "redirect:/searchmeetings";
        }

        return "forward:/bookmeeting";
    }

    @RequestMapping("/searchmeetings")
    public String searchMeetings(Model model) {
        List<Meeting> meetings = meetingService.getAllMeetings();
        model.addAttribute("meetings", meetings);

        return "searchmeetings";
    }
}
