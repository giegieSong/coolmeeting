package org.javaboy.meeting.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.javaboy.meeting.model.Meeting;

import java.util.List;

@Mapper
public interface MeetingMapper {
    Integer addMeeting(Meeting meeting);

    void addParticipants(Meeting meeting, Integer[] mps);

    List<Meeting> getAllMeetings();
}
