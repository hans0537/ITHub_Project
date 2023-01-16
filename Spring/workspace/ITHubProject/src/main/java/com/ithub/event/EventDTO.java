package com.ithub.event;

import java.sql.Date;

public class EventDTO {
	
	private int eventSeq;
	private int mSeq;
	private int pSeq;
	private String eventPic;
	private int eventType;
	private String eventName;
	private Date eventSlot;
	private Date eventStart;
	private Date eventEnd;
	private String eventLink;
	private String eventExplain;
	private String eventPresenter;
	
	public EventDTO() {}
	
	public EventDTO(int eventSeq, int mSeq, int pSeq, String eventPic, int eventType, String eventName, Date eventSlot,
			Date eventStart, Date eventEnd, String eventLink, String eventExplain, String eventPresenter) {
		super();
		this.eventSeq = eventSeq;
		this.mSeq = mSeq;
		this.pSeq = pSeq;
		this.eventPic = eventPic;
		this.eventType = eventType;
		this.eventName = eventName;
		this.eventSlot = eventSlot;
		this.eventStart = eventStart;
		this.eventEnd = eventEnd;
		this.eventLink = eventLink;
		this.eventExplain = eventExplain;
		this.eventPresenter = eventPresenter;
	}

	public int getEventSeq() {
		return eventSeq;
	}

	public void setEventSeq(int eventSeq) {
		this.eventSeq = eventSeq;
	}

	public int getmSeq() {
		return mSeq;
	}

	public void setmSeq(int mSeq) {
		this.mSeq = mSeq;
	}

	public int getpSeq() {
		return pSeq;
	}

	public void setpSeq(int pSeq) {
		this.pSeq = pSeq;
	}

	public String getEventPic() {
		return eventPic;
	}

	public void setEventPic(String eventPic) {
		this.eventPic = eventPic;
	}

	public int getEventType() {
		return eventType;
	}

	public void setEventType(int eventType) {
		this.eventType = eventType;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public Date getEventSlot() {
		return eventSlot;
	}

	public void setEventSlot(Date eventSlot) {
		this.eventSlot = eventSlot;
	}

	public Date getEventStart() {
		return eventStart;
	}

	public void setEventStart(Date eventStart) {
		this.eventStart = eventStart;
	}

	public Date getEventEnd() {
		return eventEnd;
	}

	public void setEventEnd(Date eventEnd) {
		this.eventEnd = eventEnd;
	}

	public String getEventLink() {
		return eventLink;
	}

	public void setEventLink(String eventLink) {
		this.eventLink = eventLink;
	}

	public String getEventExplain() {
		return eventExplain;
	}

	public void setEventExplain(String eventExplain) {
		this.eventExplain = eventExplain;
	}

	public String getEventPresenter() {
		return eventPresenter;
	}

	public void setEventPresenter(String eventPresenter) {
		this.eventPresenter = eventPresenter;
	}
	
}
