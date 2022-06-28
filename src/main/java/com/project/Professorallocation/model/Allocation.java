package com.project.Professorallocation.model;

import java.time.DayOfWeek;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateDeserializer;
import com.fasterxml.jackson.databind.ser.std.DateSerializer;

@Entity
@Table(name = "allocation")
public class Allocation {
	// @JsonProperty(access = Access.WRITE_ONLY)
	@JsonProperty(access = Access.WRITE_ONLY)
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false, name = "day")
	private DayOfWeek dayOfWeek;

	@JsonFormat(pattern = "HH:mmZ", timezone = "America/Recife")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date startHour;

	@JsonFormat(pattern = "HH:mmZ", timezone = "America/Recife")
	@JsonSerialize(using = DateSerializer.class)
	@JsonDeserialize(using = DateDeserializer.class)
	@Temporal(TemporalType.TIME)
	@Column(nullable = false)
	private Date EndHour;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "professor_Id", nullable = false, unique = true)
	private Long professorId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_Id", nullable = false, insertable = false, updatable = false)
	private Professor professor;

	@JsonProperty(access = Access.WRITE_ONLY)
	@Column(name = "course_Id", nullable = false, unique = true)
	private Long courseId;

	@ManyToOne(optional = false)
	@JoinColumn(name = "course_Id", nullable = false, insertable = false, updatable = false)
	private Course course;

	public Allocation() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DayOfWeek getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(DayOfWeek dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public Date getStartHour() {
		return startHour;
	}

	public void setStartHour(Date startHour) {
		this.startHour = startHour;
	}

	public static Date getEndHour() {
		return getEndHour();
	}

	public void setEndHour(Date endHour) {
		this.EndHour = endHour;
	}

	public Long getProfessorId() {
		return professorId;
	}

	public void setProfessorId(Long professorId) {
		this.professorId = professorId;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Long getCourseId() {
		return courseId;
	}

	public void setCourseId(Long courseId) {
		this.courseId = courseId;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
	public String toString() {
		return "Allocation [id=" + id + ", dayOfWeek=" + dayOfWeek + ", startHour=" + startHour + ", endHour=" + EndHour
				+ ", professorId=" + professorId + ", courseId=" + courseId + "]";
	}

}