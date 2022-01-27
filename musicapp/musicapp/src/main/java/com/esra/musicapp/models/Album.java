package com.esra.musicapp.models;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="albums")
public class Album {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	@NotBlank
	private String albumName;
	@Size(min=5)
	private String description;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	
	@OneToMany(mappedBy="albumRated", fetch=FetchType.LAZY)
	@JsonIgnore
	
	private List<Rating> ratings;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAlbumName() {
		return albumName;
	}

	public void setAlbumName(String albumName) {
		this.albumName = albumName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	public int getAvarageRating() {
		int sum=0;
		for(int i=0; i<this.ratings.size(); i++) {
			sum+=ratings.get(i).getRating();
		}
		if (sum==0) {
			return 0;
		}
		return sum/ratings.size();
		
//		public float getAvarageRating() {
//			int sum=0;
//			for(Rating rating: ratings) {
//				sum+=rating.getRating();
//				return sum/this.ratings.size();
//			}	
//		}
		
	}
	
	
	

}
