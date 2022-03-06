package org.javaboy.meeting.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaboy.meeting.model.MeetingRoom;

import java.util.List;

@Mapper
public interface MeetingRoomMapper {
    List<MeetingRoom> meetingRooms();

    MeetingRoom meetingRoomById(Integer roomid);

    Integer roomdetails(MeetingRoom meetingRoom);

    Integer addRoom(MeetingRoom meetingRoom);

    List<MeetingRoom> getAllMeetingRoomName();
}
