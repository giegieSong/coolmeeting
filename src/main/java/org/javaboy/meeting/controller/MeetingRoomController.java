package org.javaboy.meeting.controller;

import org.javaboy.meeting.model.MeetingRoom;
import org.javaboy.meeting.service.MeetingRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class MeetingRoomController {

    @Autowired
    private MeetingRoomService meetingRoomService;

    @RequestMapping("/meetingrooms")
    public String meetingRooms(Model model) {
        List<MeetingRoom> meetingRooms = meetingRoomService.meetingRooms();
        model.addAttribute("meetingRooms", meetingRooms);
        return "meetingrooms";
    }

    @RequestMapping("/roomdetails")
    public String roomdetails(Integer roomid, Model model) {
        MeetingRoom room = meetingRoomService.meetingRoomById(roomid);
        model.addAttribute("room", room);
        return "roomdetails";
    }

    @RequestMapping("/updateRoom")
    public String updateRoom(MeetingRoom meetingRoom) {
        Integer result = meetingRoomService.roomdetails(meetingRoom);

        if (result == 1) {
            return "redirect:/meetingrooms";
        }
        return "forward:/roomdetails?roomid=" + meetingRoom.getRoomid();
    }

    @RequestMapping("/admin/addmeetingroom")
    public String addMeetingRoom() {
        return "addmeetingroom";
    }

    @PostMapping("/admin/addRoom")
    public String addRoom(MeetingRoom meetingRoom) {
        Integer result = meetingRoomService.addRoom(meetingRoom);
        if (result == 1) {
            return "redirect:/meetingrooms";
        }
        return "forward:/admin/addmeetingroom";
    }
}
