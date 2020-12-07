package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.lang.NonNull;

@Entity
@Table(name = "events")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NonNull
	private String eventNAme;
	@NonNull
	private String imgUrl;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((eventNAme == null) ? 0 : eventNAme.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((imgUrl == null) ? 0 : imgUrl.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Event other = (Event) obj;
		if (eventNAme == null) {
			if (other.eventNAme != null)
				return false;
		} else if (!eventNAme.equals(other.eventNAme))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (imgUrl == null) {
			if (other.imgUrl != null)
				return false;
		} else if (!imgUrl.equals(other.imgUrl))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventNAme=" + eventNAme + ", imgUrl=" + imgUrl + "]";
	}

	public Event(String eventNAme, String imgUrl) {
		super();

		this.eventNAme = eventNAme;
		this.imgUrl = imgUrl;
	}

	public Long getId() {
		return id;
	}

	public Event() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getEventNAme() {
		return eventNAme;
	}

	public void setEventNAme(String eventNAme) {
		this.eventNAme = eventNAme;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
