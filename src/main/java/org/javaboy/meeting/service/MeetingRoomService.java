package org.javaboy.meeting.service;

import org.javaboy.meeting.mapper.MeetingRoomMapper;
import org.javaboy.meeting.model.MeetingRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeetingRoomService {

    @Autowired
    private MeetingRoomMapper meetingRoomMapper;

    public List<MeetingRoom> meetingRooms() {
        return meetingRoomMapper.meetingRooms();
    }

    public MeetingRoom meetingRoomById(Integer roomid) {
        return meetingRoomMapper.meetingRoomById(roomid);
    }

    public Integer roomdetails(MeetingRoom meetingRoom) {
        return meetingRoomMapper.roomdetails(meetingRoom);
    }

    public Integer addRoom(MeetingRoom meetingRoom) {
        return meetingRoomMapper.addRoom(meetingRoom);
    }

    public List<MeetingRoom> getAllMeetingRoomName() {
        return meetingRoomMapper.getAllMeetingRoomName();
    }
}
