package com.server.rest.java.server.rest.classRMD;

import java.util.List;

public class Video {
  private String title;
  private String director;
  private Long id;
  private List<String> edition;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public List<String> getEdition() {
    return edition;
  }

  public void setEdition(List<String> edition) {
    this.edition = edition;
  }

  public String getDirector() {
    return director;
  }

  public void setDirector(String director) {
    this.director = director;
  }

  @Override
  public String toString() {
    return "Video{" + "id=" + id + ", title='" + title + ", director='" + director + '\'' + '}';
  }
}
